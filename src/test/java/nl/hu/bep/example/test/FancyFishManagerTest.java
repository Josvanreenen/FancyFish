package nl.hu.bep.example.test;

import nl.hu.bep.example.domain.FancyFishManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FancyFishManagerTest {

    private FancyFishManager ffm;

    @BeforeEach
    void setup() {
        ffm = new FancyFishManager();
    }

    @Test
    void shouldSucceed() {
        Assertions.assertTrue(true);
    }

    @Test
    void initialListsShouldBeEmpty() {
        Assertions.assertTrue(ffm.getAllInhabitants().isEmpty());
        Assertions.assertTrue(ffm.getAllGreetings().isEmpty());
    }


}
