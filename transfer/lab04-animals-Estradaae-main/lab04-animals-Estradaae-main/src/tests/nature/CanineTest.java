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

public class CanineTest extends StructureTest
{
    private static final String DEFAULT_NAME = "name";

    private PrintStream oldOut;
    private ByteArrayOutputStream baos;
    private Canine c;

    @BeforeEach
    public void beforeEach()
    {
        super.beforeEach();
        oldOut = System.out;
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        c = new MockCanine(DEFAULT_NAME);
    }

    @AfterEach
    public void afterEach()
    {
        System.setOut(oldOut);
    }

    @Test
    public void testConstructor()
    {
        assertEquals(DEFAULT_NAME, c.getName(),
            "Canine constructor did not properly set the name field. "
            + "It should send the name parameter to the super constructor. "
            + "Error could also be in the Animal constructor or getName method");
    }

    @Test
    public void testRoam()
    {
        final String print = "like canines roam in packs";
        c.setHungerLevel(0);
        c.roam();
        assertEquals(1, c.getHungerLevel(),
            "Hunger level did not increase by one after roaming. "
            + "Error could also  be in the getter or setter for hunger level");
        String output = TestUtilities.getOutput(baos);
        assertTrue(output.toLowerCase().contains(print),
            "The Canine roam method print should include the phrase '"
            + print + "'\nYou printed: " + output);
    }

    @Test
    public void testInheritedMethods()
    {
        NatureTestUtils.testMethodsNotOverridden("nature.Canine", 
            new String[]{"getName", "setName", "getHungerLevel",
                "setHungerLevel", "sleep", "eat", "makeNoise"});
    }

    @Override
    protected String getClassName()
    {
        return "nature.Canine";
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
            new MethodSpec("roam", "public", false, false, false, false, new String[]{}, "void")
        };
    }

    @Override
    protected String getExtendedClass()
    {
        return "nature.Animal";
    }

    private class MockCanine extends Canine
    {
        public MockCanine(String name)
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
