package nl.hu.bep.example.security;

import java.util.ArrayList;

public class SecurityManager {
    private static SecurityManager sm = new SecurityManager();
    private ArrayList<MyUser> allUsers = new ArrayList<>();

    public static SecurityManager getInstance() {
        return sm;
    }

    public boolean addUser(String name, String username, String password, String role) {
        MyUser toAdd = new MyUser(name, username, password, role);
        if (!allUsers.contains(toAdd)) return allUsers.add(toAdd);
        return false;
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
