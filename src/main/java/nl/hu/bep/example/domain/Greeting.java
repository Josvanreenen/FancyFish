package nl.hu.bep.example.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Greeting {

    private static ArrayList<String> allGreetings = new ArrayList<>();

    public Greeting(){
        allGreetings.add("Hello World");
    }

    public static List<String> getAllGreetings() {
        return Collections.unmodifiableList(allGreetings);
    }

    public static boolean addGreeting(String newGreeting){
        if(!allGreetings.contains(newGreeting)) return allGreetings.add(newGreeting);
        return false;
    }
}
