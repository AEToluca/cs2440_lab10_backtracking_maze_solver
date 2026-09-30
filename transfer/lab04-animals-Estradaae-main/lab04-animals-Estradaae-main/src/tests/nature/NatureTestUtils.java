package nature;

import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;

public class NatureTestUtils
{
    public static void testMethodsNotOverridden(String className, String[] methodNames)
    {
        try {
            Method[] methods = Class.forName(className).getDeclaredMethods();
            for (String shouldNotInclude : methodNames)
            {
                for (Method m : methods)
                {
                    if (m.getName().equals(shouldNotInclude))
                    {
                        fail(String.format("%s class should not override or declare "
                            + "a method named %s.", className, shouldNotInclude));
                    }
                }
            }
        } catch (SecurityException | ClassNotFoundException e) {
            fail(String.format("Could not find %s class", className));
        }
    }
}
