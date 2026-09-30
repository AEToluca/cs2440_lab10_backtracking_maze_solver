package nature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import labtests.util.StructureTest;
import labtests.util.TestUtilities;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;
import labtests.util.specs.MethodSpec;

public class AnimalTest extends StructureTest
{
    protected static final String DEFAULT_NAME = "Yuri";
    protected static final int INIT_HUNGER = 0;
    protected static final int MAX_HUNGER = 10;
    protected static final int MIN_HUNGER = 0;

    private PrintStream oldOut;
    private ByteArrayOutputStream baos;
    private Animal a;

    @BeforeEach
    public void beforeEach()
    {
        super.beforeEach();
        oldOut = System.out;
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        a = new MockAnimal(DEFAULT_NAME);
    }

    @AfterEach
    public void afterEach()
    {
        System.setOut(oldOut);
    }

    @Test
    public void testConstructor()
    {
        assertEquals(DEFAULT_NAME, a.getName(),
            "Animal constructor did not set name correctly or getter failed.");
        assertEquals(INIT_HUNGER, a.getHungerLevel(),
            "Animal constructor did not set hunger level "
                + "correctly or getter failed.");
    }

    @Test
    public void testNameGetSet()
    {
        final String name = "new_name";
        a.setName(name);
        assertEquals(name, a.getName(), "Name setter did not correctly "
            + "set name or getter failed");
    }

    @Test
    public void testHungerGetSet()
    {
        final int validHunger = (int) (Math.random() * 11);
        a.setHungerLevel(validHunger);
        assertEquals(validHunger, a.getHungerLevel(),
            "Hunger level setter did not set hunger correctly when given "
                + "an appropriate value or getter failed");

        final int tooBigHunger = (int) (Math.random() * 10 + 11);
        a.setHungerLevel(tooBigHunger);
        assertEquals(MAX_HUNGER, a.getHungerLevel(),
            "Hunger level setter did not set hunger correctly when given "
                + "a level above ten or getter failed");

        final int tooSmallHunger = (int) ((Math.random() * 10 + 1) * -1);
        a.setHungerLevel(tooSmallHunger);
        assertEquals(MIN_HUNGER, a.getHungerLevel(),
            "Hunger level setter did not set hunger correctly when given "
                + "a level below zero or getter failed");
    }

    @Test
    public void testSleep()
    {
        final String print = "sleeping";
        a.setHungerLevel(0);
        a.sleep();
        assertEquals(MAX_HUNGER, a.getHungerLevel(),
            "Hunger level did not rise to ten after sleeping. "
            + "Error could also be in the getter or setter for hunger level");
        String output = TestUtilities.getOutput(baos);
        assertTrue(output.toLowerCase().contains(print),
            "The Animal sleep method print should include the phrase '"
            + print + "'\nYou printed: " + output);
    }

    @Test
    public void testRoam()
    {
        final String print = "moving around";
        a.setHungerLevel(0);
        a.roam();
        assertEquals(1, a.getHungerLevel(),
            "Hunger level did not increase by one after roaming. "
            + "Error could also be in the getter or setter for hunger level");
        String output = TestUtilities.getOutput(baos);
        assertTrue(output.toLowerCase().contains(print),
            "The Animal roam method print should include the phrase '"
            + print + "'\nYou printed: " + output);
    }

    @Override
    protected String getClassName()
    {
        return "nature.Animal";
    }

    @Override
    protected ClassSpec getClassSpec()
    {
        return new ClassSpec(getClassName(), "public", false, true, false);
    }

    @Override
    protected ConstructorSpec[] getConstructorSpecs()
    {
        return new ConstructorSpec[]{
            new ConstructorSpec(getClassName(), "public", new String[]{"java.lang.String"})
        };
    }

    @Override
    protected FieldSpec[] getFieldSpecs() {
        return new FieldSpec[]{
            new FieldSpec("name", "protected", false, false, "java.lang.String"),
            new FieldSpec("hungerLevel", "protected", false, false, "int")
        };
    }

    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[]{
            new MethodSpec("getHungerLevel", "public", false, false, false, false, new String[]{}, "int"),
            new MethodSpec("getName", "public", false, false, false, false, new String[]{}, "java.lang.String"),
            new MethodSpec("setHungerLevel", "public", false, false, false, false, new String[]{"int"}, "void"),
            new MethodSpec("setName", "public", false, false, false, false, new String[]{"java.lang.String"}, "void"),
            new MethodSpec("sleep", "public", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("roam", "public", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("eat", "public", false, false, true, false, new String[]{}, "void"),
            new MethodSpec("makeNoise", "public", false, false, true, false, new String[]{}, "void")
        };
    }

    private class MockAnimal extends Animal
    {
        public MockAnimal(String name)
        {
            super(name);
        }

        @Override
        public void makeNoise()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void eat()
        {
            throw new UnsupportedOperationException();
        }
    }
}
