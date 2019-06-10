package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Junit test")
public class JunitTest {
    final String stringTestowy = "string";
    final int numberToTest = 3;

    @Test
    @DisplayName("First test")
    @Tag("All")
    @RepeatedTest(value = 5, name = "Repeated test {currentRepetition} of {totalRepetitions}")
    public void firstTest() {


        assertTrue(true, "message for test result");
        assertTrue(true);
        assertFalse(false);
        assertEquals(5, 5, "Variables not eqauls");
        assertNotNull(numberToTest);
        assertTrue(5 == 2 + 3, "message for test result");
        assertFalse(stringTestowy.matches("^s"));

    }

    @Test
    @DisplayName("Second test")
    @Disabled()
    public void secondTest() {
        assertThat(stringTestowy).isEqualTo("string");

        //not that :
        // assertTrue(0.2 * 0.2 == 0.4 );
        //but like that:
        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);

    }

    @Test
    @DisplayName("Array test")
    public void arrayTest() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5);

        assertTrue(list1.containsAll(list2));
        assertThat(list1).hasSize(5);
        assertThat(list2).containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Nested
    @DisplayName("Nested Test class")
    public class NestedSuiteClassTest {

        final String stringTestowy = "string";

        @Test
        @DisplayName("Nested class test")
        public void nestedTest() {
            assertThat(stringTestowy).isEqualTo("string");
        }
    }

}
