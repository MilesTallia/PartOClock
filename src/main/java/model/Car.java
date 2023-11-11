package main.java.model;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.LinkedList;

public class Car {
    private String name;
    private TreeMap<String, LinkedList<Thing>> subsystems;
    
    public Car(String name){
        this.name = name;
        subsystems = makeSubsystemsDict();
    }

    private TreeMap<String, LinkedList<Thing>> makeSubsystemsDict() {
        // This makes the subsystem bins for each new car
        String[] subNames = {
            "01-Frame","02-Suspension","03-Steering","04-Outboard","05-Brakes","06-Ergonomics",
            "07-Reduction","08-CVT","09-Electrical","12-Engine","14-Driveline Integration",
            "15-Driveshaft","16-Front Differential","17-PTU","18-Disconnect","99-Other"
        };
        TreeMap<String, LinkedList<Thing>> subs = new TreeMap<String, LinkedList<Thing>>();
        for (String sub : subNames) {
            subs.put(sub, new LinkedList<Thing>());
        }
        return subs;
    }

    // These are all the getters
    public String getName() {return name;}
    public TreeMap<String, LinkedList<Thing>> getSubs() {return subsystems;}

    // ALSO MAKE IT PRINT "(#overdue parts)"
    @Override
    public String toString() {
        return name + " (Overdue Parts: " + getOverdueParts() + ")";
    }
    public String subsystemsPrint() {
        String returnMe = name + " (Overdue Parts: " + getOverdueParts() + ")\n";
        for (String subName : subsystems.keySet()) {
            returnMe += "    • " + subName + " (Overdue Parts: " + getOverduePartsOfSubsystem(subName) + ")\n";
        }
        return returnMe;
    }
    public String thingsPrint() {
        String returnMe = name + " (Overdue Parts: " + getOverdueParts() + ")\n";
        for (String subName : subsystems.keySet()) {
            returnMe += "    • " + subName + " (Overdue Parts: " + getOverduePartsOfSubsystem(subName) + ")\n";
            LinkedList<Thing> things = subsystems.get(subName);
            for (Thing thing : things){
                returnMe += "         • " + thing;
            }
        }
        return returnMe;
    }
    public String fullPrint() {
        String returnMe = name + " (Overdue Parts: " + getOverdueParts() + ")\n";
        for (String subName : subsystems.keySet()) {
            returnMe += "    - " + subName + " (Overdue Parts: " + getOverduePartsOfSubsystem(subName) + ")\n";
            LinkedList<Thing> things = subsystems.get(subName);
            for (Thing thing : things){
                returnMe += thing.fullPrint(2);
            }
        }
        return returnMe;
    }

    public void addPart(Thing part, String pathString) {
        String[] path = pathString.split("/");
        for (String subName : subsystems.keySet()) {
            if (subName.substring(3).equals(path[0])){
                if (path.length > 1) {
                    LinkedList<Thing> things = subsystems.get(subName);
                    for (Thing thing : things){
                        if (thing.getName().equals(path[1])) {
                            String[] newPath = Arrays.copyOfRange(path, 1, path.length);
                            thing.addPart(part, newPath);
                        }
                    }
                } else {
                    subsystems.get(subName).add(part);
                }
            }
        }
    }

    public void addTime(Time time) {
        for (String subName : subsystems.keySet()) {
            LinkedList<Thing> things = subsystems.get(subName);
            for (Thing thing : things){
                thing.addTime(time);
            }
        }
    }

    public Integer getOverdueParts() {
        Integer totalParts = 0;
        for (String subName : subsystems.keySet()) {
            LinkedList<Thing> things = subsystems.get(subName);
            for (Thing thing : things){
                totalParts += thing.getOverdueCount();
            }
        }
        return totalParts;
    }

    public Integer getOverduePartsOfSubsystem(String subsystemName) {
        Integer totalParts = 0;
        LinkedList<Thing> things = subsystems.get(subsystemName);
        for (Thing thing : things){
            totalParts += thing.getOverdueCount();
        }
        return totalParts;
    }
}