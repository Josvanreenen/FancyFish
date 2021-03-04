package nl.hu.bep.example.domain;

import nl.hu.bep.example.webservices.OwnerResource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Owner {

    private String name;
    private List<Inhabitant> ownedInhabitants;

    public Owner(String nm){
        name=nm;
        ownedInhabitants = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return name.equals(owner.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public List<Inhabitant> getOwnedInhabitants() {
        return Collections.unmodifiableList(ownedInhabitants);
    }

}
