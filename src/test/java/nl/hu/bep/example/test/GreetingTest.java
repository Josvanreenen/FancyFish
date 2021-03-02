package nl.hu.bep.example.test;

import nl.hu.bep.example.domain.Greeting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GreetingTest {

    private Greeting g;

    @BeforeEach
    void setup(){
        g = new Greeting();
    }

    @Test
    void initialValueShouldBeEmpty(){
        Assertions.assertTrue(true);
    }
}
