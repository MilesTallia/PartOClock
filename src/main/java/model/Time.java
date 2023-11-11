package main.java.model;

public class Time {
    public String type;
    public Integer time;
    public java.sql.Time date;

    public Time(String type, Integer time, java.sql.Time date) {
        this.type = type;
        this.time = time;
        this.date = date;
    }

    public String getType() {return type;}
    public Integer getTime() {return time;}
    public java.sql.Time getDate() {return date;}
    
    @Override
    public String toString() {
        return String.format("%s - %s - %s", type, time, date);
    }
}
