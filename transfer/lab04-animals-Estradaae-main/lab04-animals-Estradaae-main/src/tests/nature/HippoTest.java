package nature;

import labtests.util.specs.MethodSpec;

public class HippoTest extends ConcreteAnimalTest
{
    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[] {
            new MethodSpec("eat", "public", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("makeNoise", "public", false, false, false, false, new String[]{}, "void")
        };
    }

    @Override
    protected String[] badMethods()
    {
        return new String[]{"getName", "setName", "getHungerLevel",
            "setHungerLevel", "roam", "sleep", "play", "beFriendly"};
    }

    @Override protected String getClassName() { return "nature.Hippo"; }
    @Override protected String getExtendedClass() { return "nature.Animal"; }
    @Override protected String makeNoisePrint() { return "blub"; }
    @Override protected String eatPrint() { return "slurp"; }
    @Override protected String sleepPrint() { return "sleeping"; }
    @Override protected String roamPrint() { return "moving around"; }
    @Override protected String playPrint() { return null; }
    @Override protected String beFriendlyPrint() { return null; }
    @Override protected int eatHungerDecrease() { return 1; }
    @Override protected int roamHungerIncrease() { return 1;}
    @Override protected boolean isPet() { return false; }
}
