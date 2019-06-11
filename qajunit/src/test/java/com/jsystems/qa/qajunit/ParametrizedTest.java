package com.jsystems.qa.qajunit;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assertions.assertTrue;



@DisplayName("Parametrized tests")
public class ParametrizedTest extends ConfigJunit {




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


    @DisplayName("Csv value parametrized test")
    @ParameterizedTest(name = "Parametrized test with values name: {0} and value: {1}")
    @CsvSource(value = {"Hello, 5", "HelloJunit 5, 15", "Hello 5!, 25"}, delimiter = ',')
    public void paramMultiArgTest(String param1, int param2) {
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 == 0);
    }


    @DisplayName("Csv file parametrized test")
    @ParameterizedTest(name = "Parametrized test with data from csv file, name: {0} and value: {1}")
    @CsvFileSource(resources = "/plik.csv", delimiter = ';')
    public void csvFileSourceTest(String param1, int param2) {
        assertTrue(param1.toLowerCase().contains("hi"));
        assertTrue(param2 % 4 == 0);
    }

}
