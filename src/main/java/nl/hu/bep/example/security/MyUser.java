package nl.hu.bep.example.security;

import java.security.Principal;
import java.util.Objects;

public class MyUser implements Principal {
    private String name;
    private String username;
    private String password;
    private String role;
    private String ownerName;


    private MyUser(String nm, String uname, String pw, String r){
        name = nm;
        username = uname;
        password = pw;
        role = r;
    }

    public static MyUser createUser(String nm, String uname, String pw, String r){
        if(nm.isBlank() || uname.isBlank() || pw.isBlank() ||r.isBlank()) return null;
        return new MyUser(nm, uname,pw,r);
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
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
