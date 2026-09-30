package nature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import labtests.util.StructureTest;
import labtests.util.TestUtilities;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;

public abstract class ConcreteAnimalTest extends StructureTest
{
    private PrintStream oldOut;
    private ByteArrayOutputStream baos;
    @SuppressWarnings("rawtypes")
    private Constructor con;
    private Animal a;

    public ConcreteAnimalTest()
    {
        try {
            con = Class.forName(getClassName()).getConstructor(String.class);
        } catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            fail("Could not find one-arg String constructor for " + getClassName());
        }
    }

    @BeforeEach
    public void beforeEach()
    {
        super.beforeEach();
        oldOut = System.out;
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try {
            a = (Animal) (con.newInstance(AnimalTest.DEFAULT_NAME));
        } catch (InstantiationException | IllegalAccessException
            | IllegalArgumentException | InvocationTargetException e) {
            fail("Failed to create a new " + getClassName());
        }
    }

    @AfterEach
    public void afterEach()
    {
        System.setOut(oldOut);
    }

    @Test
    public void testConstructor()
    {
        assertEquals(AnimalTest.DEFAULT_NAME, a.getName(),
            String.format("%s constructor did not properly set the name field."
            + "\nError could also be in the Animal constructor "
            + "or getName method", getClassName()));
    }

    @Test
    public void testMakeNoise()
    {
        a.makeNoise();
        String output = TestUtilities.getOutput(baos);
        assertTrue(output.toLowerCase().contains(makeNoisePrint()),
            String.format("The %s makeNoise method print should include "
            + "the phrase '%s'\nYou printed: %s", getClassName(),
            makeNoisePrint(), output));
    }

    @Test
    public void testEat()
    {
        a.setHungerLevel(AnimalTest.MAX_HUNGER);
        a.eat();
        assertEquals(AnimalTest.MAX_HUNGER - eatHungerDecrease(), a.getHungerLevel(),
            String.format("%s hunger level did not decrease by %d after eating"
            + "\nError could also be in the getter or setter for hunger level",
            getClassName(), eatHungerDecrease()));
        String output = TestUtilities.getOutput(baos);
        assertTrue(output.toLowerCase().contains(eatPrint()),
            String.format("The %s eat method print should include "
            + "the phrase '%s'\nYou printed: %s", getClassName(),
            eatPrint(), output));
    }

    @Test
    public void testRoam()
    {
        a.setHungerLevel(AnimalTest.MIN_HUNGER);
        a.roam();
        assertEquals(AnimalTest.MIN_HUNGER + roamHungerIncrease(), a.getHungerLevel(),
            String.format("%s hunger level did not increase by %d after roaming"
            + "\nError could also be in the getter or setter for hunger level",
            getClassName(), roamHungerIncrease()));
        String output = TestUtilities.getOutput(baos);
        assertTrue(output.toLowerCase().contains(roamPrint()),
            String.format("The %s roam method print should include "
            + "the phrase '%s'\nYou printed: %s", getClassName(),
            roamPrint(), output));
    }

    @Test
    public void testSleep()
    {
        a.setHungerLevel(AnimalTest.MIN_HUNGER);
        a.sleep();
        assertEquals(AnimalTest.MAX_HUNGER, a.getHungerLevel(),
            String.format("%s hunger level did not increase to the maximum after sleeping"
            + "\nError could also be in the getter or setter for hunger level",
            getClassName()));
        String output = TestUtilities.getOutput(baos);
        assertTrue(output.toLowerCase().contains(sleepPrint()),
            String.format("The %s sleep method print should include "
            + "the phrase '%s'\nYou printed: %s", getClassName(),
            sleepPrint(), output));
    }

    @Test
    public void testPlay()
    {
        if (isPet())
        {
            Pet p = (Pet) a;
            p.play();
            String output = TestUtilities.getOutput(baos);
            assertTrue(output.toLowerCase().contains(playPrint()),
                String.format("The %s play method print should include "
                + "the phrase '%s'\nYou printed: %s", getClassName(),
                playPrint(), output));
        }
    }

    public void testBeFriendly()
    {
        if (isPet())
        {
            Pet p = (Pet) a;
            p.beFriendly();
            String output = TestUtilities.getOutput(baos);
            assertTrue(output.toLowerCase().contains(beFriendlyPrint()),
                String.format("The %s beFriendly method print should include "
                + "the phrase '%s'\nYou printed: %s", getClassName(),
                beFriendlyPrint(), output));
        }
    }

    @Test
    public void testInheritedMethods()
    {
        NatureTestUtils.testMethodsNotOverridden(getClassName(), badMethods());
    }

    @Override
    protected ClassSpec getClassSpec()
    {
        return new ClassSpec(getClassName(), "public", false, false, false);
    }

    @Override
    protected ConstructorSpec[] getConstructorSpecs()
    {
        return new ConstructorSpec[] {
            new ConstructorSpec(getClassName(), "public", new String[]{"java.lang.String"})
        };
    }

    @Override
    protected FieldSpec[] getFieldSpecs()
    {
        return new FieldSpec[]{};
    }
    
    protected abstract String makeNoisePrint();
    protected abstract String eatPrint();
    protected abstract String sleepPrint();
    protected abstract String roamPrint();
    protected abstract String playPrint();
    protected abstract String beFriendlyPrint();
    protected abstract int eatHungerDecrease();
    protected abstract int roamHungerIncrease();
    protected abstract boolean isPet();
    protected abstract String[] badMethods();
}
