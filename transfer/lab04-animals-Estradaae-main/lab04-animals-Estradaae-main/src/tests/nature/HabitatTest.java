package nature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import labtests.util.TestUtilities;

/**
 * Tests for the Habitat class.
 * 
 * @author Willow Sapphire
 * @version 07/27/2023
 */
public class HabitatTest
{
    private static final String DEFAULT_NAME = "name";
    private static final double DEFAULT_LAT = 1.0;
    private static final double DEFAULT_LON = 2.0;
    private static final double EPS = 1e-9;

    private PrintStream oldOut;
    private ByteArrayOutputStream baos;
    private Habitat habitat;
    

    @BeforeEach
    public void beforeEach()
    {
        oldOut = System.out;
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        habitat = new Habitat(DEFAULT_NAME, DEFAULT_LAT, DEFAULT_LON);
    }

    @AfterEach
    public void afterEach()
    {
        System.setOut(oldOut);
    }

    @Test
    public void testConstructor()
    {
        assertEquals(DEFAULT_NAME, habitat.getName(), 
            "Constructor improperly set name field or getter is incorrect.");
        assertEquals(DEFAULT_LAT, habitat.getLatitude(), EPS,
            "Constructor improperly set latitude field or getter is incorrect.");
        assertEquals(DEFAULT_LON, habitat.getLongitude(), EPS,
            "Constructor improperly set longitude field or getter is incorrect.");
    }

    @Test
    public void testNameGetSet()
    {
        final String NEW_NAME = "NewName";
        habitat.setName(NEW_NAME);
        assertEquals(NEW_NAME, habitat.getName(), 
            "Name setter failed or name getter is incorrect.");
    }

    @Test
    public void testLatitudeGetSet()
    {
        final double NEW_LAT = DEFAULT_LAT + DEFAULT_LON + 15;
        habitat.setLatitude(NEW_LAT);
        assertEquals(NEW_LAT, habitat.getLatitude(), EPS,
            "Longitude setter failed or longitude getter is incorrect.");
    }

    @Test
    public void testLongitudeGetSet()
    {
        final double NEW_LON = DEFAULT_LAT + DEFAULT_LON + 23;
        habitat.setLongitude(NEW_LON);
        assertEquals(NEW_LON, habitat.getLongitude(), EPS,
            "Latitude setter failed or latitude getter is incorrect.");
    }

    @Test
    public void testGetNumOfAnimalsAndAddAnimal()
    {
        int numAnimals = (int) (Math.random() * 20);
        for (int i = 0; i < numAnimals; i++)
        {
            habitat.addAnimal(null);
        }
        assertEquals(numAnimals, habitat.getNumOfAnimals(),
            "getNumOfAnimals returned incorrect number. "
            + "error could also be in addAnimal.");
    }

    @Test
    public void testTestAnimals()
    {
        int numAnimals = (int) (Math.random() * 5 + 8);
        Animal[] animals = new Animal[numAnimals];
        animals[0] = new Hippo("a");
        animals[1] = new Lion("a");
        animals[2] = new Ocelot("a");
        animals[3] = new HouseCat("a");
        animals[4] = new Dog("a");
        animals[5] = new Coyote("a");
        animals[6] = new Wolf("a");
        animals[7] = new SiameseCat("a");
        for(int i=8;i<numAnimals;i++)animals[i]=getRandomAnimal();
        for(Animal a:animals)habitat.addAnimal(a);
        for(Animal a:animals){a.sleep();a.makeNoise();a.eat();a.roam();Pet e=a instanceof Pet?(Pet)a:null;if(e==null)continue;e.play();e.beFriendly();}
        String s=habitat.getName()+"\n"+habitat.getLatitude()+"\n"+habitat.getLongitude()+"\n"+habitat.getNumOfAnimals()+"\n"+TestUtilities.getOutput(baos);
        habitat.testAnimals();
        String t=TestUtilities.getOutput(baos);
        assertEquals(s, t, "Incorrect print from testAnimals.");
    }

    private Animal getRandomAnimal()
    {
        int type = (int) (Math.random() * 8);
        String name = String.format("%f", Math.random());
        switch (type)
        {
            case 0: return new HouseCat(name);
            case 1: return new Coyote(name);
            case 2: return new Dog(name);
            case 3: return new Ocelot(name);
            case 4: return new Hippo(name);
            case 5: return new Lion(name);
            case 6: return new SiameseCat(name);
            case 7: return new Wolf(name);
            default: return null;
        }
    }
}
