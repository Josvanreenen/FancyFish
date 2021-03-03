package nl.hu.bep.example.domain;

import java.util.Objects;

public abstract class Inhabitant {

    protected String name;
    protected double length;
    protected String color;

    protected Inhabitant(String nm, double l, String c) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inhabitant that = (Inhabitant) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
