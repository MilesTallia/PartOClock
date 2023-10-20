package main.java;

import java.util.HashMap;

public class Car {
    private String name;
    private HashMap<String, Thing[]> subsystems;
    
    public Car(String name){
        this.name = name;
        subsystems = makeSubsystemsDict();
    }

    private HashMap<String, Thing[]> makeSubsystemsDict() {
        // This makes the subsystem bins for each new car
        String[] subNames = {
            "Frame","Suspension","Steering","Outboard","Brakes","Ergonomics",
            "Reduction","CVT","Electrical","Engine","Driveline Integration",
            "Driveshaft","Front Differential","PTU","Disconnect"
        };
        HashMap<String, Thing[]> subs = new HashMap<String, Thing[]>();
        for (String sub : subNames) {
            subs.put(sub, new Thing[]{});
        }
        return subs;
    }

    // These are all the getters
    public String getName() {return name;}
    public HashMap<String, Thing[]> getSubs() {return subsystems;}

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
            Thing[] things = subsystems.get(subName);
            for (Thing thing : things){
                returnMe += "         • " + thing;
            }
        }
        return returnMe;
    }

    public String fullPrint() {
        String returnMe = name + " (Overdue Parts: " + getOverdueParts() + ")\n";
        for (String subName : subsystems.keySet()) {
            returnMe += "    • " + subName + " (Overdue Parts: " + getOverduePartsOfSubsystem(subName) + ")\n";
            Thing[] things = subsystems.get(subName);
            for (Thing thing : things){
                returnMe += "         • " + thing.fullPrint();
            }
        }
        return returnMe;
    }

    public void addTime(Time time) {
        for (String subName : subsystems.keySet()) {
            Thing[] things = subsystems.get(subName);
            for (Thing thing : things){
                thing.addTime(time);
            }
        }
    }

    public Integer getOverdueParts() {
        Integer totalParts = 0;
        for (String subName : subsystems.keySet()) {
            Thing[] things = subsystems.get(subName);
            for (Thing thing : things){
                totalParts += thing.getOverdueCount();
            }
        }
        return totalParts;
    }

    public Integer getOverduePartsOfSubsystem(String subsystemName) {
        Integer totalParts = 0;
        Thing[] things = subsystems.get(subsystemName);
        for (Thing thing : things){
            totalParts += thing.getOverdueCount();
        }
        return totalParts;
    }

    public static void main(String[] args) {
        Car r23 = new Car("R23");
        System.out.println(r23);
    }
}