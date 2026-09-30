package library;

import labtests.util.StructureTest;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;
import labtests.util.specs.MethodSpec;

public class BookStructureTest extends StructureTest
{

    @Override
    protected String getClassName()
    {
        return "library.Book";
    }

    @Override
    protected ClassSpec getClassSpec()
    {
        return new ClassSpec(getClassName(), "public", false, false, false, new String[]{});
    }

    @Override
    protected ConstructorSpec[] getConstructorSpecs()
    {
        return new ConstructorSpec[]{
            new ConstructorSpec(getClassName(), "public", new String[]{"java.lang.String", "java.lang.String", "int"})
        };
    }

    @Override
    protected FieldSpec[] getFieldSpecs()
    {
        return new FieldSpec[]{
            new FieldSpec("author", "private", false, false, "java.lang.String"),
            new FieldSpec("title", "private", false, false, "java.lang.String"),
            new FieldSpec("numPages", "private", false, false, "int")
        };
    }

    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[]{
            new MethodSpec("getAuthor", "public", false, false, false, false, new String[]{}, "java.lang.String"),
            new MethodSpec("getTitle", "public", false, false, false, false, new String[]{}, "java.lang.String"),
            new MethodSpec("getNumPages", "public", false, false, false, false, new String[]{}, "int"),
            new MethodSpec("equals", "public", false, false, false, false, new String[]{"java.lang.Object"}, "boolean"),
            new MethodSpec("compareTo", "public", false, false, false, false, new String[]{"library.Book"}, "int"),
            new MethodSpec("toString", "public", false, false, false, false, new String[]{}, "java.lang.String"),
        };
    }
    
    @Override
    protected String[] getInterfacesImplemented()
    {
        return new String[]{"java.lang.Comparable"};
    }
}
