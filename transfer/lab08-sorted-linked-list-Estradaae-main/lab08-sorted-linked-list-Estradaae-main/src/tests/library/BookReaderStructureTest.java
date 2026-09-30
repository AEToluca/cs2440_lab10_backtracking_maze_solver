package library;

import labtests.util.StructureTest;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;
import labtests.util.specs.MethodSpec;

public class BookReaderStructureTest extends StructureTest
{
    @Override
    protected String getClassName()
    {
        return "library.BookReader";
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
            new ConstructorSpec(getClassName(), "public", new String[]{"java.lang.String"})
        };
    }

    @Override
    protected FieldSpec[] getFieldSpecs() {
        return new FieldSpec[]{
            new FieldSpec("fileIn", "private", false, false, "java.util.Scanner"),
            new FieldSpec("books", "private", false, false, "storage.SortedLinkedList")
        };
    }

    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[]{
            new MethodSpec("setFileIn", "public", false, false, false, false, new String[]{"java.util.Scanner"}, "void"),
            new MethodSpec("readLines", "public", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("getBooks", "public", false, false, false, false, new String[]{}, "storage.SortedLinkedList"),
            new MethodSpec("printMoreThan300", "public", false, false, false, false, new String[]{}, "void"),
            new MethodSpec("averagePages", "public", false, false, false, false, new String[]{}, "double"),
            new MethodSpec("removeLessThan200", "public", false, false, false, false, new String[]{}, "void"),
        };
    }
    
}
