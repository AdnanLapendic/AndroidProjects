package de.enssol.lapendic.adnan.enssolchatapp;

/**
 * Created by user on 12.1.2018..
 */

public class Conv {

    public boolean seen;
    public long timestamp;

    public Conv(){

    }

    public Conv(boolean seen, long timestamp){
        this.seen = seen;
        this.timestamp = timestamp;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
