package main.java.model;

public abstract class Thing {
    public abstract String getName();
    public abstract void addTime(Time time);
    public abstract Integer getOverdueCount();
    public abstract String fullPrint();
    public abstract void addPart(Thing part, String[] path);
}
