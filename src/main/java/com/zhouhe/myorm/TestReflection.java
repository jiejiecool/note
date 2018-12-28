package com.zhouhe.myorm;

import org.junit.Test;

import java.io.Console;

public class TestReflection {
    @Test
    public void testGetClass() {
        Console console = System.console();
        Class c = console.getClass();
        System.out.println(c);
    }
}
