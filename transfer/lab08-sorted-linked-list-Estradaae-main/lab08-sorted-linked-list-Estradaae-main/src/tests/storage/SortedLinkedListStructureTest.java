package storage;

import labtests.util.StructureTest;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;
import labtests.util.specs.MethodSpec;

public class SortedLinkedListStructureTest extends StructureTest
{
        @Override
    protected String getClassName()
    {
        return "storage.SortedLinkedList";
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
            new ConstructorSpec(getClassName(), "public", new String[]{})
        };
    }

    @Override
    protected FieldSpec[] getFieldSpecs()
    {
        return new FieldSpec[]{
            new FieldSpec("length", "private", false, false, "int"),
            new FieldSpec("head", "private", false, false, "storage.Node")
        };
    }

    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[]{
            new MethodSpec("getPrevious", "private", false, false, false, false, new String[]{"java.lang.Comparable"}, "storage.Node"),
            new MethodSpec("getPosition", "public", false, false, false, false, new String[]{"java.lang.Comparable"}, "int"),
            new MethodSpec("display", "public", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("add", "public", false, false, false, false, new String[]{"java.lang.Comparable"}, "void"),
            new MethodSpec("remove", "public", false, false, false, false, new String[]{"int"}, "java.lang.Comparable"),
            new MethodSpec("getLength", "public", false, false, false, false, new String[]{}, "int"),
            new MethodSpec("clear", "public", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("isEmpty", "public", false, false, false, false, new String[]{}, "boolean"),
            new MethodSpec("contains", "public", false, false, false, false, new String[]{"java.lang.Comparable"}, "boolean"),
            new MethodSpec("iterator", "public", false, false, false, false, new String[]{}, "java.util.Iterator"),
            new MethodSpec("getEntry", "public", false, false, false, false, new String[]{"int"}, "java.lang.Comparable"),
        };
    }

    @Override
    protected String[] getInterfacesImplemented()
    {
        return new String[]{"java.lang.Iterable"};
    }
}
