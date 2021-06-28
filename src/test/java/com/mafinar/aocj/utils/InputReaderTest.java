package com.mafinar.aocj.utils;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {
    @ParameterizedTest
    @MethodSource("validResourceInfo")
    @DisplayName("getFileName should return the file name in proper format")
    public void testGetFileName(int year, int day, String expected) {
        var inputReader = new InputReader(year, day);
        assertEquals(expected, inputReader.getFileName());
    }

    @ParameterizedTest
    @MethodSource("invalidResourceInfo")
    @DisplayName("You should not be able to create an InputReader with invalid year/day")
    public void testValidInputs(int year, int day) {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> new InputReader(year, day));
        String expectedMessage = "Ranges: Year [2015, 2020], Day [1, 25]";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("You can add third parameter to represent extra tag on file name")
    public void testTagParameter() {
        var inputReader = new InputReader(2015, 1, "test");
        assertEquals("year_2015/day01_test.txt", inputReader.getFileName());
    }

    @Test
    @DisplayName("Reads the right file and returns its contents as a String")
    public void testReadsRightFile() throws IOException {
        var inputReader = new InputReader(2015, 1, "test");
        String content = inputReader.readFromFile();
        assertEquals("(((())))", content);
    }

    static Stream<Arguments> validResourceInfo() {
        return Stream.of(
                Arguments.arguments(2015, 1, "year_2015/day01.txt"),
                Arguments.arguments(2020, 25, "year_2020/day25.txt"),
                Arguments.arguments(2018, 10, "year_2018/day10.txt"),
                Arguments.arguments(2019, 11, "year_2019/day11.txt")
        );
    }

    static Stream<Arguments> invalidResourceInfo() {
        return Stream.of(
                Arguments.arguments(2011, 1),
                Arguments.arguments(2022, -25),
                Arguments.arguments(2019, 31),
                Arguments.arguments(20, 11)
        );
    }
}
