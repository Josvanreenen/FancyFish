package nl.hu.bep.example.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FancyFishManager {
    private static FancyFishManager ffm = new FancyFishManager();
    private List<Greeting> allGreetings = new ArrayList<>();
    private List<Inhabitant> allInhabitants = new ArrayList<>();
    private List<Owner> allOwners = new ArrayList<>();
    private static final Logger LOG = LogManager.getLogger(FancyFishManager.class);

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

    public Greeting getGreetingByName(String remGreeting) {
        return null;
    }

    public void removeGreeting(Greeting toRemove) {
    }

    public boolean addInhabitant(String aquarium, String inhabitanttype, String name, double length, String color) {

        if (!aquarium.isBlank() && inhabitanttype.equals("fish")) {
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

    public boolean addOwner(String name){
        Owner toAdd = new Owner(name);
        if(!name.isBlank() && !allOwners.contains(toAdd)) return allOwners.add(toAdd);
        return false;
    }

    public Owner getOwnerByName(String name){
        LOG.info("allOwners holds {} items", allOwners.size());
        if(name==null || name.isBlank()) return null;
        return allOwners.stream().filter(owner -> name.equals(owner.getName())).peek(owner -> LOG.info(owner.getName())).findFirst().orElse(null);
    }

}
