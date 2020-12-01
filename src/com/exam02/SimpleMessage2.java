package com.exam02;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * No changes to original code
 */
public class SimpleMessage2 implements Serializable {
    private String sender;
    private String text;
    private LocalDateTime dateTime;
    private static final long serialVersionUID = 2L;

    public SimpleMessage2(String sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateTime(){
        dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "SimpleMessage2{" +
                "sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    public static SimpleMessage2 getMessage(String sender, String text){
        return new SimpleMessage2(sender, text);
    }
}
