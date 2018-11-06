package com.zhouhe.classloader;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;


class TestClassloader {
    @Test
    void test1() {
        System.out.println(ClassLoader.getSystemClassLoader());
    }

    /**
     *
     */
    @Test
    void test2() {
        String classpath = System.getProperty("java.class.path");
        System.out.println(classpath);
        for (String path : classpath.split(";")) {
            System.out.println(path);
        }
    }

    @Test
    void test3() {
        //查看项目中类的类加载器
        System.out.println(TestClassloader.class.getClassLoader());
        System.out.println(TestClassloader.class.getClassLoader().getParent());
    }

    /**
     * 查看extclassloader的加载路径
     */
    @Test
    void test4() {
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
    }

    /**
     * 查看bootstrap的加载路径
     */
    @Test
    void test5() {
        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println(url.toExternalForm());
        }
    }

    @Test
    void test6() {
        //ss
        System.out.println(sun.misc.Launcher.class.getClassLoader());
        System.out.println(sun.misc.Launcher.getLauncher().getClassLoader());

        System.out.println(String.class.getClassLoader());
    }

    @Test
    void test7() {
        Map<String, Object> map = new HashMap<>();
        map.put("aaa","123");
    }
}
