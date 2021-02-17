package nl.hu.bep.example.domain;

public abstract class Inhabitant {

    protected String name;
    protected double length;
    protected String color;

    public Inhabitant(String nm, double l, String c) {
        name = nm;
        length = l;
        color = c;
    }

    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public String getColor() {
        return color;
    }
}
