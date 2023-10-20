package main.java;

import java.util.LinkedList;

public class Assembly extends Thing{
    private String name;
    private String subsystem;
    private LinkedList<Part> parts;
    
    public Assembly(String name, String subsystem){
        this.name = name;
        this.subsystem = subsystem;
        this.parts = new LinkedList<Part>();
    }

    // These are all the getters
    public String getName() {return name;}
    public String getSubsystem() {return subsystem;}
    public LinkedList<Part> getParts() {return parts;}
    
    // ALSO MAKE IT PRINT "(#overdue parts)"
    @Override
    public String toString() {
        return name;
    }

    public void addPart(Part part) {
        parts.add(part);
    }

    public void addTime(Time time) {
        for (Part part : parts) {
            part.addTime(time);
        }
    }
}
