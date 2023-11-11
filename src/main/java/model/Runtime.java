package main.java.model;

import java.time.LocalDateTime;

public class Runtime {
    public String type;
    public Integer time;
    public LocalDateTime date;

    public Runtime(String type, Integer time, LocalDateTime date) {
        this.type = type;
        this.time = time;
        this.date = date;
    }

    public String getType() {return type;}
    public Integer getTime() {return time;}
    public LocalDateTime getDate() {return date;}
    
    @Override
    public String toString() {
        return String.format("%s - %s - %s", type, time, date);
    }
}
