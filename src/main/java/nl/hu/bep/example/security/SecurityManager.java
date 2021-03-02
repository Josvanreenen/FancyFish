package nl.hu.bep.example.security;

import java.util.ArrayList;

public class SecurityManager {
    private static SecurityManager sm = new SecurityManager();
    private ArrayList<MyUser> allUsers = new ArrayList<>();

    public static SecurityManager getInstance() {
        return sm;
    }

    public boolean addUser(String name, String username, String password, String role) {
        MyUser toAdd = MyUser.createUser(name, username, password, role);
        if (toAdd!=null && !allUsers.contains(toAdd)) return allUsers.add(toAdd);
        return false;
    }

    public boolean registerUser(String name, String username, String password){
        return addUser(name, username, password, "Owner");
    }

    public String validateLogin(String uname, String pwd) {
        String role = null;
        for (MyUser u : allUsers) {
            if (u.getUsername().equals(uname) && u.checkPassword(pwd)) {
                role = u.getRole();
                break;
            }
        }
        return role;
    }

    public MyUser getUserByName(String uname) {
        for (MyUser u : allUsers) {
            if (u.getUsername().equals(uname)) return u;
        }
        return null;
    }
}
