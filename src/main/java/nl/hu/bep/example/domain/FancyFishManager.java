package nl.hu.bep.example.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FancyFishManager {
    public static final boolean debuggMode = false;
    private static FancyFishManager ffm = new FancyFishManager();

    public static FancyFishManager getInstance() {
        return ffm;
    }

    private ArrayList<Greeting> allGreetings = new ArrayList<>();

    public List<Greeting> getAllGreetings() {
        return Collections.unmodifiableList(allGreetings);
    }

    public boolean addGreeting(String newGreeting){
        Greeting toAdd = new Greeting(newGreeting);
        if(!allGreetings.contains(toAdd)) return allGreetings.add(toAdd);
        return false;
    }

}
