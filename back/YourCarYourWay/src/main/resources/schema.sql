CREATE TABLE IF NOT EXISTS user (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 username VARCHAR(255) NOT NULL,
                                 password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS message (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    sender_id BIGINT NOT NULL,
                                    receiver_id BIGINT NOT NULL,
                                    content TEXT NOT NULL,
                                    timestamp TIMESTAMP NOT NULL,
                                    FOREIGN KEY (sender_id) REFERENCES user(id),
                                    FOREIGN KEY (receiver_id) REFERENCES user(id)
);
