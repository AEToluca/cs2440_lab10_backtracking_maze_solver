package nature;

import labtests.util.specs.MethodSpec;

public class OcelotTest extends ConcreteAnimalTest
{
    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[] {
            new MethodSpec("eat", "public", false, false, false, false, new String[]{}, "void")
        };
    }

    @Override
    public String[] badMethods()
    {
        return new String[]{"getName", "setName", "getHungerLevel",
            "setHungerLevel", "roam", "sleep", "makeNoise", "play", "beFriendly"};
    }

    @Override protected String getClassName() { return "nature.Ocelot"; }
    @Override protected String getExtendedClass() { return "nature.Feline"; }
    @Override protected String makeNoisePrint() { return "meow"; }
    @Override protected String eatPrint() { return "pick"; }
    @Override protected String sleepPrint() { return "cat nap"; }
    @Override protected String roamPrint() { return "felines like to roam alone"; }
    @Override protected String playPrint() { return null; }
    @Override protected String beFriendlyPrint() { return null; }
    @Override protected int eatHungerDecrease() { return 3; }
    @Override protected int roamHungerIncrease() { return 1;}
    @Override protected boolean isPet() { return false; }
}
