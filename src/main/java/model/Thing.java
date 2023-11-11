package main.java.model;

public abstract class Thing {
    public abstract String getName();
    public abstract void addTime(Runtime time);
    public abstract Integer getOverdueCount();
    public abstract String fullPrint(Integer length);
    public abstract void addPart(Thing part, String[] path);
}
