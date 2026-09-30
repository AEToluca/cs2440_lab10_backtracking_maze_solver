package nature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import labtests.util.StructureTest;
import labtests.util.TestUtilities;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;
import labtests.util.specs.MethodSpec;

public class FelineTest extends StructureTest
{
    private PrintStream oldOut;
    private ByteArrayOutputStream baos;
    private Feline f;

    @BeforeEach
    public void beforeEach()
    {
        super.beforeEach();
        oldOut = System.out;
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        f = new MockFeline(AnimalTest.DEFAULT_NAME);
    }

    @AfterEach
    public void afterEach()
    {
        System.setOut(oldOut);
    }

    @Test
    public void testConstructor()
    {
        assertEquals(AnimalTest.DEFAULT_NAME, f.getName(),
            "Feline constructor did not properly set the name field. "
            + "It should send the name parameter to the super constructor. "
            + "Error could also be in the Animal constructor or getName method");
    }

    @Test
    public void testRoam()
    {
        final String print = "felines like to roam alone";
        f.setHungerLevel(0);
        f.roam();
        assertEquals(1, f.getHungerLevel(),
            "Hunger level did not increase by one after roaming. "
            + "Error could also be in the getter or setter for hunger level");
        String output = TestUtilities.getOutput(baos);
        assertTrue(output.toLowerCase().contains(print),
            "The Feline roam method print should include the phrase '"
            + print + "'\nYou printed: " + output);
    }

    @Test
    public void testSleep()
    {
        final String print = "cat nap";
        f.setHungerLevel(0);
        f.sleep();
        assertEquals(10, f.getHungerLevel(),
            "Hunger level did not increase to ten after sleeping. "
            + "Error could also be in the getter or setter for hunger level");
        String output = TestUtilities.getOutput(baos);
        assertTrue(output.toLowerCase().contains(print),
            "The Feline sleep method print should include the phrase '"
            + print + "'\nYou printed: " + output);
    }

    @Test
    public void testMakeNoise()
    {
        final String print = "meow";
        f.makeNoise();
        String output = TestUtilities.getOutput(baos);
        assertTrue(output.toLowerCase().contains(print),
            "The Feline makeNoise method print should include the phrase '"
            + print + "'\nYou printed: " + output);
    }

    @Test
    public void testInheritedMethods()
    {
        NatureTestUtils.testMethodsNotOverridden("nature.Feline", 
            new String[]{"getName", "setName", "getHungerLevel",
                "setHungerLevel", "eat"});
    }

    @Override
    protected String getClassName()
    {
        return "nature.Feline";
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
        return new FieldSpec[]{};
    }

    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[] {
            new MethodSpec("roam", "public", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("sleep", "public", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("makeNoise", "public", false, false, false, false, new String[]{}, "void"),
        };
    }

    @Override
    protected String getExtendedClass()
    {
        return "nature.Animal";
    }
    
    private class MockFeline extends Feline
    {
        public MockFeline(String name)
        {
            super(name);
        }

        @Override
        public void eat()
        {
            throw new UnsupportedOperationException("Unimplemented method 'eat'");
        }
    }
}
