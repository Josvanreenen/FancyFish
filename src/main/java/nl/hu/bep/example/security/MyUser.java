package nl.hu.bep.example.security;

import java.security.Principal;
import java.util.Objects;

public class MyUser implements Principal {
    private String name, username, password, role;

    public MyUser(String nm, String uname, String pw, String r){
        name = nm;
        username = uname;
        password = pw;
        role = r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyUser myUser = (MyUser) o;
        return username.equals(myUser.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public String getRole() {
        return role;
    }
}
