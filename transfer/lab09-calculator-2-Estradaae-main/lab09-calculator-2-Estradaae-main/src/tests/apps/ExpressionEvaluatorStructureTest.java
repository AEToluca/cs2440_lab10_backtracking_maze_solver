package apps;

import labtests.util.StructureTest;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;
import labtests.util.specs.MethodSpec;

public class ExpressionEvaluatorStructureTest extends StructureTest
{

    @Override
    protected String getClassName()
    {
        return "apps.ExpressionEvaluator";
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
            new ConstructorSpec(getClassName(), "public", new String[]{}),
        };
    }

    @Override
    protected FieldSpec[] getFieldSpecs()
    {
        return new FieldSpec[]{
            new FieldSpec("UNSIGNED_DOUBLE", "private", true, true, "java.util.regex.Pattern"),
            new FieldSpec("CHARACTER", "private", true, true, "java.util.regex.Pattern"),
        };
    }

    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[]{
            new MethodSpec("toPostfix", "public", true, false, false, false, new String[]{"java.lang.String"}, "java.lang.String"),
            new MethodSpec("higherPrecedence", "private", true, false, false, false, new String[]{"char", "char"}, "boolean"),
            new MethodSpec("evaluate", "public", true, false, false, false, new String[]{"java.lang.String"}, "double"),
        };
    }
    
}
