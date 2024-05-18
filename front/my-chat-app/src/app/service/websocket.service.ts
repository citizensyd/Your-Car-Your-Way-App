import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Stomp } from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {
  private stompClient: any;
  private messageSubject: Subject<string> = new Subject<string>();

  constructor() {
    this.connect();
  }

  private connect() {
    const socket = new SockJS('http://localhost:3001/chat-websocket');
    this.stompClient = Stomp.over(socket);

    this.stompClient.connect({}, (frame: any) => {
      console.log('Connected: ' + frame);
      this.stompClient.subscribe('/topic/messages', (message: any) => {
        this.messageSubject.next(JSON.parse(message.body).content);
      });
    });
  }

  public sendMessage(message: string) {
    this.stompClient.send('/app/sendMessage', {}, JSON.stringify({ 'content': message }));
  }

  public getMessages(): Observable<string> {
    return this.messageSubject.asObservable();
  }
}
