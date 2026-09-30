package apps;

import labtests.util.StructureTest;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;
import labtests.util.specs.MethodSpec;

public class CalculatorStructureTest extends StructureTest
{

    @Override
    protected String getClassName()
    {
        return "apps.Calculator";
    }

    @Override
    protected ClassSpec getClassSpec()
    {
        return new ClassSpec(getClassName(), "public", false, false, false);
    }

    @Override
    protected ConstructorSpec[] getConstructorSpecs()
    {
        return new ConstructorSpec[] {
            new ConstructorSpec(getClassName(), "public", new String[]{})
        };
    }

    @Override
    protected FieldSpec[] getFieldSpecs()
    {
        return new FieldSpec[] {
            new FieldSpec("X_LOC", "private", true, true, "int"),
            new FieldSpec("Y_LOC", "private", true, true, "int"),
            new FieldSpec("WIDTH", "private", true, true, "int"),
            new FieldSpec("HEIGHT", "private", true, true, "int"),
            new FieldSpec("NAME", "private", true, true, "java.lang.String"),
            new FieldSpec("RESULT_PREAMBLE", "private", true, true, "java.lang.String"),
            new FieldSpec("ERROR_MESSAGE", "private", true, true, "java.lang.String")
        };
    }

    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[] {
            new MethodSpec("getFrame", "public", false, false, false, false, new String[]{}, "javax.swing.JFrame"),
            new MethodSpec("createFrame", "private", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("initializeComponents", "private", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("displayFrame", "private", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("initializeInputs", "private", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("initializeResults", "private", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("initializeButtons", "private", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("getLeftNum", "private", false, false, false, false, new String[]{}, "double"),
            new MethodSpec("getRightNum", "private", false, false, false, false, new String[]{}, "double"),
            new MethodSpec("updateResult", "private", false, false, false, false, new String[]{"double"}, "void"),
        };
    }
    
}
