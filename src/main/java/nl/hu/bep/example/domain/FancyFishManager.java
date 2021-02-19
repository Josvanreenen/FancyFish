package nl.hu.bep.example.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FancyFishManager {
    public static final boolean debuggMode = false;
    private static FancyFishManager ffm = new FancyFishManager();
    private ArrayList<Greeting> allGreetings = new ArrayList<>();
    private List<Inhabitant> allInhabitants = new ArrayList<>();

    public static FancyFishManager getInstance() {
        return ffm;
    }


    public List<Greeting> getAllGreetings() {
        return Collections.unmodifiableList(allGreetings);
    }

    public boolean addGreeting(String newGreeting){
        Greeting toAdd = new Greeting(newGreeting);
        if(!allGreetings.contains(toAdd)) return allGreetings.add(toAdd);
        return false;
    }

    public boolean addInhabitant(String aquarium, String inhabitanttype, String name, double length, String color) {
        if (inhabitanttype.equals("fish")) {
            Inhabitant toAdd = new Fish(name, length, color);
            if(!allInhabitants.contains(toAdd)) return allInhabitants.add(toAdd);
        }
        return false;
    }


    public List<Inhabitant> getAllInhabitants() {
        return Collections.unmodifiableList(allInhabitants);
    }

    public Inhabitant getInhabitantByName(String name) {
        return allInhabitants.stream().filter(inhab -> inhab.getName().equals(name)).findFirst().orElse(null);
    }
}
