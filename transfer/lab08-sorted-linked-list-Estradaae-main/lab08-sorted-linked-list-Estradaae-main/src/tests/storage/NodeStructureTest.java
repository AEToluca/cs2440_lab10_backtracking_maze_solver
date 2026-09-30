package storage;

import labtests.util.StructureTest;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;
import labtests.util.specs.MethodSpec;

public class NodeStructureTest extends StructureTest
{

    @Override
    protected String getClassName()
    {
        return "storage.Node";
    }

    @Override
    protected ClassSpec getClassSpec()
    {
        return new ClassSpec(getClassName(), "public", false, false, false, new String[]{"T"});
    }

    @Override
    protected ConstructorSpec[] getConstructorSpecs()
    {
        return new ConstructorSpec[]{
            new ConstructorSpec(getClassName(), "public", new String[]{"java.lang.Object", "storage.Node"}),
            new ConstructorSpec(getClassName(), "public", new String[]{"java.lang.Object"}),
            new ConstructorSpec(getClassName(), "public", new String[]{})
        };
    }

    @Override
    protected FieldSpec[] getFieldSpecs()
    {
        return new FieldSpec[]{
            new FieldSpec("data", "private", false, false, "java.lang.Object"),
            new FieldSpec("link", "private", false, false, "storage.Node")
        };
    }

    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[]{
            new MethodSpec("getLink", "public", false, false, false, false, new String[]{}, "storage.Node"),
            new MethodSpec("setLink", "public", false, false, false, false, new String[]{"storage.Node"}, "void"),
            new MethodSpec("getData", "public", false, false, false, false, new String[]{}, "java.lang.Object"),
            new MethodSpec("setData", "public", false, false, false, false, new String[]{"java.lang.Object"}, "void"),
        };
    }
}
