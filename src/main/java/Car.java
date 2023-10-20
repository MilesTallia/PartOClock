package main.java;

import java.util.HashMap;
import java.util.Objects;

public class Car {
    private String name;
    private HashMap<String, Assembly[]> subsystems;
    
    public Car(String name){
        this.name = name;
        subsystems = makeSubsystemsDict();
    }

    private HashMap<String, Assembly[]> makeSubsystemsDict() {
        // This makes the subsystem bins for each new car
        String[] subNames = {
            "Frame","Suspension","Steering","Outboard","Brakes",
            "Ergonomics","Reduction","CVT","Electrical","R&D",
            "Manufacturing","Engine","Composites","Driveline Integration",
            "Driveshaft","Front Differential","PTU","Disconnect"
        };
        HashMap<String, Assembly[]> subs = new HashMap<String, Assembly[]>();
        for (String sub : subNames) {
            subs.put(sub, new Assembly[]{});
        }
        return subs;
    }

    // These are all the getters
    public String getName() {return name;}
    public HashMap<String, Assembly[]> getSubs() {return subsystems;}

    // ALSO MAKE IT PRINT "(#overdue parts)"
    @Override
    public String toString() {
        return name;
    }

    public void addTime(Time time) {
        for (String subName : subsystems.keySet()) {
            Assembly[] assemblies = subsystems.get(subName);
            for (Assembly assembly : assemblies){
                assembly.addTime(time);
            }
        }
    }
}