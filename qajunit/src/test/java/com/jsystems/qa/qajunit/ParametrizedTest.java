package com.jsystems.qa.qajunit;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Parametrized tests")
public class ParametrizedTest {


    @DisplayName("Integer parametrized test")
    @ParameterizedTest(name = "Integer test #{index} @Arguments: {arguments}")
    @ValueSource(ints = {5, 15, 25, 30, 35, 40, 35, 50})
    public void parametrizedIntegerTest(int number) {

        assertTrue(number % 5 == 0);

    }

    @DisplayName("String parametrized test")
    @ParameterizedTest(name = "String test #{index}, @Arguments: {arguments}")
    // Other way to show arg in @ParameterizedTest anotation: {0}")
    @ValueSource(strings = {"one bottle", "second bottle", "third bottle"})
    public void parametrizedStringTest(String value) {

        assertTrue(value.contains("bottle"));


    }
}
