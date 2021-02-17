import nl.hu.bep.example.domain.Fish;
import nl.hu.bep.example.domain.Greeting;
import nl.hu.bep.example.domain.Inhabitant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FishTest {
    private Fish f;

    @BeforeEach
    public void setup() {
        f = new Fish("Blauwe vinvis", 12.3, "blauw");
    }

    @Test
    public void checkNameIsNotWrong() {
        Assertions.assertNotEquals("Rode vinvis", f.getName());
    }

    @Test
    public void typeOfInhabitant(){
        Assertions.assertTrue((f instanceof Inhabitant));
    }

    @Test
    public void checkColorIsBlue(){
        Assertions.assertEquals("blauw", f.getColor());
    }


}
