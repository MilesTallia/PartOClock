package main.java.model;

import java.util.LinkedList;

public class Part extends Thing{
    private String name;
    private String serial;
    private Integer timeLimit;
    private LinkedList<Runtime> times;
    
    public Part(String name, String serial, Integer timeLimit){
        this.name = name;
        this.serial = serial;
        this.timeLimit = timeLimit;
        this.times = new LinkedList<Runtime>();
    }
    public Part(String name, String serial){
        this.name = name;
        this.serial = serial;
        this.timeLimit = 0;
        this.times = new LinkedList<Runtime>();
    }

    // These are all the getters
    public String getName() {return name;}
    public String getSerial() {return serial;}
    public Integer getTimeLimit() {return timeLimit;}
    public LinkedList<Runtime> getTimes() {return times;}
    
    @Override
    public String toString() {
        return name + getOverdueString();
    }
    
    public String fullPrint(Integer length) {
        String returnMe = "";
        for (int i = 0; i < length; i++) {returnMe += "     ";}
        return returnMe + String.format("- [P] %s - {%s} - %ds\n", this.toString(), serial, this.calculateTime());
    }

    public Integer calculateTime() {
        Integer totalTime = 0;
        for (Runtime time : times) {
            totalTime += time.getTime();
        }
        return totalTime;
    }

    public Integer calculateTimeOfType(String type) {
        Integer totalTime = 0;
        for (Runtime time : times) {
            if (time.getType().equals(type)){
                totalTime += time.getTime();
            }
        }
        return totalTime;
    }

    public void addTime(Runtime time) {
        times.add(time);
    }

    public Integer getOverdueCount() {
        if (timeLimit < calculateTime() & timeLimit != 0) {
            return 1;
        }
        return 0;
    }

    public String getOverdueString() {
        if (timeLimit < calculateTime() & timeLimit != 0) {
            return "{[***OVERDUE***]}";
        }
        return "";
    }

    public void addPart(Thing part, String[] path) {
        System.out.println("I am the part motherfucker! can't add a part to a part - gotta add that shit to an assembly.");
    }

    public Part findPart(String cereal) {
        if (serial.equals(cereal)) {
            return this;
        }
        return null;
    }
}
