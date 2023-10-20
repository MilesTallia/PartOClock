package main.java;

import java.util.LinkedList;

public abstract class Part {
    private String name;
    private String serial;
    private Integer timeLimit;
    private LinkedList<Time> times;
    
    public Part(String name, String serial, Integer timeLimit){
        this.name = name;
        this.serial = serial;
        this.timeLimit = timeLimit;
        this.times = new LinkedList<Time>();
    }
    public Part(String name, String serial){
        this.name = name;
        this.serial = serial;
        this.timeLimit = 0;
        this.times = new LinkedList<Time>();
    }

    // These are all the getters
    public String getName() {return name;}
    public String getSerial() {return serial;}
    public Integer getTimeLimit() {return timeLimit;}
    public LinkedList<Time> getTimes() {return times;}
    
    // ALSO MAKE IT PRINT "(#overdue parts)"
    @Override
    public String toString() {
        return String.format("%s - %s - %s", name, serial, this.calculateTime());
    }

    public Integer calculateTime() {
        Integer totalTime = 0;
        for (Time time : times) {
            totalTime += time.getTime();
        }
        return totalTime;
    }

    public void addTime(Time time) {
        times.add(time);
    }
}
