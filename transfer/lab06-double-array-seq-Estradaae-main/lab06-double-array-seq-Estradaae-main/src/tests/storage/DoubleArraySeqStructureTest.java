package storage;

import labtests.util.StructureTest;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;
import labtests.util.specs.MethodSpec;

/**
 * Tests the field and method declarations in DoubleArraySeq.
 * 
 * @author Willow Sapphire
 * @version 07/10/2023
 */
public class DoubleArraySeqStructureTest extends StructureTest
{
    @Override
    protected String getClassName()
    {
        return "storage.DoubleArraySeq";
    }

    @Override
    protected ClassSpec getClassSpec()
    {
        return new ClassSpec(getClassName(), "public", 
            false, false, false);
    }

    @Override
    protected FieldSpec[] getFieldSpecs()
    {
        FieldSpec[] fields = new FieldSpec[4];
        fields[0] = new FieldSpec("DEFAULT_CAPACITY", "public", 
            true, true, "int");
        fields[1] = new FieldSpec("data", "private", 
            false, false, "[D");
        fields[2] = new FieldSpec("manyItems", "private", 
            false, false, "int");
        fields[3] = new FieldSpec("currentIndex", "private", 
            false, false, "int");
        return fields;
    }

    @Override
    protected String[] getInterfacesImplemented()
    {
        return new String[]{"java.lang.Cloneable"};
    }

    @Override
    protected ConstructorSpec[] getConstructorSpecs()
    {
        ConstructorSpec[] constructors = new ConstructorSpec[2];
        constructors[0] = new ConstructorSpec("storage.DoubleArraySeq", 
            "public", new String[]{});
        constructors[1] = new ConstructorSpec("storage.DoubleArraySeq", 
            "public", new String[]{"int"});
        return constructors;
    }

    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        MethodSpec[] methods = new MethodSpec[16];
        methods[0] = new MethodSpec("addAfter", "public", false, 
            false, false, false, new String[]{"double"}, "void");
        methods[1] = new MethodSpec("addBefore", "public", false, 
            false, false, false, new String[]{"double"}, "void");
        methods[2] = new MethodSpec("addAll", "public", false, 
            false, false, false, new String[]{"storage.DoubleArraySeq"}, "void");
        methods[3] = new MethodSpec("advance", "public", false, 
            false, false, false, new String[]{}, "void");
        methods[4] = new MethodSpec("clone", "public", false, 
            false, false, false, new String[]{}, "storage.DoubleArraySeq");
        methods[5] = new MethodSpec("concatenation", "public", true, 
            false, false, false, new String[]{"storage.DoubleArraySeq",
            "storage.DoubleArraySeq"}, "storage.DoubleArraySeq");
        methods[6] = new MethodSpec("ensureCapacity", "public", false, 
            false, false, false, new String[]{"int"}, "void");
        methods[7] = new MethodSpec("getCapacity", "public", false, 
            false, false, false, new String[]{}, "int");
        methods[8] = new MethodSpec("getCurrent", "public", false, 
            false, false, false, new String[]{}, "double");
        methods[9] = new MethodSpec("isCurrent", "public", false, 
            false, false, false, new String[]{}, "boolean");
        methods[10] = new MethodSpec("removeCurrent", "public", false, 
            false, false, false, new String[]{}, "void");
        methods[11] = new MethodSpec("size", "public", false,
            false, false, false, new String[]{}, "int");
        methods[12] = new MethodSpec("start", "public", false,
            false, false, false, new String[]{}, "void");
        methods[13] = new MethodSpec("trimToSize", "public", false,
            false, false, false, new String[]{}, "void");
        methods[14] = new MethodSpec("toString", "public", false,
            false, false, false, new String[]{}, "java.lang.String");
        methods[15] = new MethodSpec("equals", "public", false,
            false, false, false, new String[]{"java.lang.Object"}, "boolean");
        return methods;
    }
}
