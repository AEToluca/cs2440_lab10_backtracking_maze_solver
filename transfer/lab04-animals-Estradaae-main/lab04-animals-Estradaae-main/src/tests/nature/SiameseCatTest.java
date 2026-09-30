package nature;

import labtests.util.specs.MethodSpec;

public class SiameseCatTest extends ConcreteAnimalTest
{
    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[] {
            new MethodSpec("makeNoise", "public", false, false, false, false, new String[]{}, "void"),
        };
    }

    @Override
    public String[] badMethods()
    {
        return new String[]{"getName", "setName", "getHungerLevel",
            "setHungerLevel", "roam", "sleep", "eat", "beFriendly"};
    }

    @Override protected String getClassName() { return "nature.SiameseCat"; }
    @Override protected String getExtendedClass() { return "nature.HouseCat"; }
    @Override protected String makeNoisePrint() { return "mrrooowwww"; }
    @Override protected String eatPrint() { return "crunch"; }
    @Override protected String sleepPrint() { return "cat nap"; }
    @Override protected String roamPrint() { return "felines like to roam alone"; }
    @Override protected String playPrint() { return "zoom zoom zoom"; }
    @Override protected String beFriendlyPrint() { return "purr"; }
    @Override protected int eatHungerDecrease() { return 3; }
    @Override protected int roamHungerIncrease() { return 1;}
    @Override protected boolean isPet() { return true; }
}
