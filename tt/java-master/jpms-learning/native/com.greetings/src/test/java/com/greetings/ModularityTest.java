package com.greetings;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class ModularityTest {
    @Test
    @Disabled("JPMS disallows illegal reflection")
    void shouldStopIllegalReflection() throws ReflectiveOperationException {
        Class<?> aClass = ModularityTest
                .class.getClassLoader()
                .loadClass("org.astro.World");
        Method name = aClass.getDeclaredMethod("name");
        name.invoke(null);
    }
}
