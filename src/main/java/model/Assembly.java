package main.java.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

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

    public String fullPrint(Integer length) {
        String returnMe = "";
        for (int i = 0; i < length; i++) {returnMe += "     ";}
        returnMe += "- [A] " + this.toString() + "\n";
        for (Thing part: parts) {
            returnMe += part.fullPrint(length+1);
        }
        return returnMe;
    }

    public void addTime(Runtime time) {
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
        if (path[0].equals(name) & path.length == 1) {
            parts.add(part);
        } else if (path[0].equals(name)) {
            for (Thing thing : parts) {
                if (path[1].equals(thing.getName()) ) {
                    String[] newPath = Arrays.copyOfRange(path, 1, path.length);
                    thing.addPart(part, newPath);
                }
            }
        }
    }

    public Part findPart(String serial) {
        for (Thing part : parts) {
            if (part.findPart(serial) != null) {
                return part.findPart(serial);
            }
        }
        return null;
    }
}
