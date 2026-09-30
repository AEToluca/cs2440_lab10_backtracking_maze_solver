package storage;

import labtests.util.StructureTest;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;
import labtests.util.specs.MethodSpec;

public class DoubleLinkedSeqStructureTest extends StructureTest
{

    @Override
    protected String getClassName()
    {
        return "storage.DoubleLinkedSeq";
    }

    @Override
    protected ClassSpec getClassSpec()
    {
        return new ClassSpec(getClassName(), "public", false, false, false);
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
            new FieldSpec("manyNodes", "private", false, false, "int"),
            new FieldSpec("tail", "private", false, false, "storage.DoubleNode"),
            new FieldSpec("head", "private", false, false, "storage.DoubleNode"),
            new FieldSpec("precursor", "private", false, false, "storage.DoubleNode"),
            new FieldSpec("cursor", "private", false, false, "storage.DoubleNode"),
        };
    }

    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[]{
            new MethodSpec("addAfter", "public", false, false, false, false,
                new String[]{"double"}, "void"),
            new MethodSpec("addBefore", "public", false, false, false, false,
                new String[]{"double"}, "void"),
            new MethodSpec("addAll", "public", false, false, false, false,
                new String[]{"storage.DoubleLinkedSeq"}, "void"),
            new MethodSpec("start", "public", false, false, false, false,
                new String[]{}, "void"),
            new MethodSpec("advance", "public", false, false, false, false,
                new String[]{}, "void"),
            new MethodSpec("getCurrent", "public", false, false, false, false,
                new String[]{}, "double"),
            new MethodSpec("removeCurrent", "public", false, false, false, false,
                new String[]{}, "void"),
            new MethodSpec("isCurrent", "public", false, false, false, false,
                new String[]{}, "boolean"),
            new MethodSpec("size", "public", false, false, false, false,
                new String[]{}, "int"),
            new MethodSpec("clone", "public", false, false, false, false,
                new String[]{}, "storage.DoubleLinkedSeq"),
            new MethodSpec("toString", "public", false, false, false, false,
                new String[]{}, "java.lang.String"),
            new MethodSpec("equals", "public", false, false, false, false,
                new String[]{"java.lang.Object"}, "boolean"),
            new MethodSpec("concatenation", "public", true, false, false, false,
                new String[]{"storage.DoubleLinkedSeq", "storage.DoubleLinkedSeq"},
                "storage.DoubleLinkedSeq")
        };
    }

    @Override
    protected String[] getInterfacesImplemented()
    {
        return new String[]{"java.lang.Cloneable"};
    }
}
