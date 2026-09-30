package nature;

import labtests.util.specs.MethodSpec;

public class DogTest extends ConcreteAnimalTest
{
    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[] {
            new MethodSpec("eat", "public", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("makeNoise", "public", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("play", "public", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("beFriendly", "public", false, false, false, false, new String[]{}, "void")
        };
    }
    @Override
    public String[] badMethods()
    {
        return new String[]{"getName", "setName", "getHungerLevel",
            "setHungerLevel", "roam", "sleep"};
    }

    @Override protected String[] getInterfacesImplemented() { return new String[]{"nature.Pet"}; }
    @Override protected String getClassName() { return "nature.Dog"; }
    @Override protected String getExtendedClass() { return "nature.Canine"; }
    @Override protected String makeNoisePrint() { return "bark"; }
    @Override protected String eatPrint() { return "slop"; }
    @Override protected String sleepPrint() { return "sleeping"; }
    @Override protected String roamPrint() { return "like canines roam in packs"; }
    @Override protected String playPrint() { return "run"; }
    @Override protected String beFriendlyPrint() { return "nuzzle"; }
    @Override protected int eatHungerDecrease() { return 3; }
    @Override protected int roamHungerIncrease() { return 1;}
    @Override protected boolean isPet() { return true; }
}
