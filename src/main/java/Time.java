package main.java;

public class Time {
    public String type;
    public Integer time;

    public Time(String type, Integer time) {
        this.type = type;
        this.time = time;
    }

    public String getType() {return type;}
    public Integer getTime() {return time;}
}
