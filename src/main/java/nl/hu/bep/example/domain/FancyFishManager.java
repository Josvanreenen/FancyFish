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
    private ArrayList<MyUser> allUsers = new ArrayList<>();

    public List<Greeting> getAllGreetings() {
        return Collections.unmodifiableList(allGreetings);
    }

    public boolean addGreeting(String newGreeting){
        Greeting toAdd = new Greeting(newGreeting);
        if(!allGreetings.contains(toAdd)) return allGreetings.add(toAdd);
        return false;
    }

    //FIXME Why is my domain manager concerned with security objects
    public boolean addUser(String name, String username, String password, String role){
        MyUser toAdd = new MyUser(name,username,password, role);
        if(!allUsers.contains(toAdd)) return  allUsers.add(toAdd);
        return false;
    }

    //FIXME The domain manager should not validate user logons
    public String validateLogin(String uname, String pwd){
        String role = null;
        for(MyUser u : allUsers){
            if (u.getUsername().equals(uname)&&u.checkPassword(pwd)){
                role=u.getRole();
                break;
            }
        }
        return role;
    }

    //FIX<E Domain manager needs not find a user by his or her username
    public MyUser getUserByName(String uname) {
        for (MyUser u : allUsers){
            if (u.getUsername().equals(uname)) return u;
        }
        return null;
    }
}
