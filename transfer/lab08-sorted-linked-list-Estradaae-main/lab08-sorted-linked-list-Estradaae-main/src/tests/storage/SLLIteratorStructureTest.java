package storage;

import labtests.util.StructureTest;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;
import labtests.util.specs.MethodSpec;

public class SLLIteratorStructureTest extends StructureTest
{

    @Override
    protected String getClassName()
    {
        return "storage.SortedLinkedList$SLLIterator";
    }

    @Override
    protected ClassSpec getClassSpec()
    {
        return new ClassSpec(getClassName(), "private", false, false, false, new String[]{});
    }

    @Override
    protected ConstructorSpec[] getConstructorSpecs()
    {
        return new ConstructorSpec[]{
            new ConstructorSpec(getClassName(), "public", new String[]{"storage.SortedLinkedList", "storage.Node"})
        };
    }

    @Override
    protected FieldSpec[] getFieldSpecs()
    {
        return new FieldSpec[]{
            new FieldSpec("prevNode", "private", false, false, "storage.Node"),
            new FieldSpec("currNode", "private", false, false, "storage.Node"),
            new FieldSpec("nextNode", "private", false, false, "storage.Node"),
            new FieldSpec("calledNext", "private", false, false, "boolean")
        };
    }

    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[]{
            new MethodSpec("hasNext", "public", false, false, false, false, new String[]{}, "boolean"),
            new MethodSpec("next", "public", false, false, false, false, new String[]{}, "java.lang.Comparable"),
            new MethodSpec("remove", "public", false, false, false, false, new String[]{}, "void"),
        };
    }

    protected String[] getInterfacesImplemented()
    {
        return new String[]{"java.util.Iterator"};
    }
    
}
