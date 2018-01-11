package de.enssol.lapendic.adnan.enssolchatapp;

import android.os.Message;

/**
 * Created by adnan on 10.1.2018..
 */

public class Messages {

    private String messages;
    private boolean seen;
    private long time;
    private String type;
    private String from;

    public Messages(String message, boolean seen, long time, String type){
        this.messages = message;
        this.seen = seen;
        this.time = time;
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Messages(){

    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
