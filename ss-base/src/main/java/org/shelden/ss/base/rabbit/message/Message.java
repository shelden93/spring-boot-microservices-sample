package org.shelden.ss.base.rabbit.message;

import java.time.LocalDateTime;

public class Message {

    private Object data;
    private String username;

    private LocalDateTime creationDate = LocalDateTime.now();

    public static Message withUsername(String username) {

        final Message message = new Message();
        message.setUsername(username);

        return message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {data=" + data + "; username=" + username + "}";
    }
}
