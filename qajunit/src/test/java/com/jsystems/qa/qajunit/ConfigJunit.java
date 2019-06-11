package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;

public class ConfigJunit {

    @BeforeAll
    public static void setupAll() {
        System.out.println("============== Before all ==============");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("============== After all ==============");
    }

    @BeforeEach
    public void setupEach(TestInfo testInfo) {
        System.out.println("========== Before each =========");
        System.out.println("DisplayName: " + testInfo.getDisplayName());
        System.out.println("========== Test Name class name: " + testInfo.getTestClass().getClass().getSimpleName());
    }

    @AfterEach
    public void tearDownEach() {
        System.out.println("============== After each ==============");
    }
}
