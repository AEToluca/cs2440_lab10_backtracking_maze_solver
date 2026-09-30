package nature;

import labtests.util.specs.MethodSpec;

public class CoyoteTest extends ConcreteAnimalTest
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
    public String[] badMethods()
    {
        return new String[]{"getName", "setName", "getHungerLevel",
            "setHungerLevel", "roam", "sleep", "play", "beFriendly"};
    }

    @Override protected String getClassName() { return "nature.Coyote"; }
    @Override protected String getExtendedClass() { return "nature.Canine"; }
    @Override protected String makeNoisePrint() { return "howl"; }
    @Override protected String eatPrint() { return "gnaw"; }
    @Override protected String sleepPrint() { return "sleep"; }
    @Override protected String roamPrint() { return "like canines roam in packs"; }
    @Override protected String playPrint() { return null; }
    @Override protected String beFriendlyPrint() { return null; }
    @Override protected int eatHungerDecrease() { return 2; }
    @Override protected int roamHungerIncrease() { return 1;}
    @Override protected boolean isPet() { return false; }
}
