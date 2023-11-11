package main.java.model;

import java.util.Arrays;
import java.util.LinkedList;

public class Assembly extends Thing{
    private String name;
    private String subsystem;
    private LinkedList<Thing> parts;
    
    public Assembly(String name, String subsystem){
        this.name = name;
        this.subsystem = subsystem;
        this.parts = new LinkedList<Thing>();
    }

    // These are all the getters
    public String getName() {return name;}
    public String getSubsystem() {return subsystem;}
    public LinkedList<Thing> getParts() {return parts;}
    
    @Override
    public String toString() {
        String returnMe = name;
        if (getOverdueCount() > 0) {
            returnMe += " (Overdue Parts: " + getOverdueCount() + ")";
        }
        return returnMe;
    }

    public String fullPrint() {
        String returnMe = "[A] " + this.toString() + "\n";
        for (Thing part: parts) {
            returnMe += "              - " + part.fullPrint();
        }
        return returnMe;
    }

    public void addPart(Part part) {
        parts.add(part);
    }

    public void addTime(Time time) {
        for (Thing part : parts) {
            part.addTime(time);
        }
    }

    public Integer getOverdueCount() {
        Integer totalParts = 0;
        for (Thing part : parts) {
            totalParts += part.getOverdueCount();
        }
        return totalParts;
    }
    
    public void addPart(Thing part, String[] path) {
        if (path[0].equals(name)) {
            parts.add(part);
        } else {
            for (Thing thing : parts) {
                if (thing.getName().equals(path[0])) {
                    String[] newPath = Arrays.copyOfRange(path, 1, path.length-1);
                    thing.addPart(part, newPath);
                }
            }
        }
    }
}
