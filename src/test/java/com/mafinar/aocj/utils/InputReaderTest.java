package com.mafinar.aocj.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {
    @ParameterizedTest
    @MethodSource("validResourceInfo")
    @DisplayName("getFileName should return the file name in proper format")
    public void testGetFileName(Stream<String> stream) {
        var args = stream.collect(Collectors.toList());
        int year = Integer.parseInt(args.get(0));
        int day = Integer.parseInt(args.get(1));
        String expected = args.get(2);
        var inputReader = new InputReader(year, day);
        assertEquals(inputReader.getFileName(), expected);
    }

    @ParameterizedTest
    @MethodSource("invalidResourceInfo")
    @DisplayName("You should not be able to create an InputReader with invalid year/day")
    public void testValidInputs(Stream<String> stream) {
        var args = stream.collect(Collectors.toList());
        int year = Integer.parseInt(args.get(0));
        int day = Integer.parseInt(args.get(1));

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
        assertEquals(content, "(((())))");
    }

    static Stream<Stream<String>> validResourceInfo() {
        return Stream.of(
                Stream.of("2015", "1", "year_2015/day01.txt"),
                Stream.of("2020", "25", "year_2020/day25.txt"),
                Stream.of("2018", "10", "year_2018/day10.txt"),
                Stream.of("2019", "11", "year_2019/day11.txt")
        );
    }

    static Stream<Stream<String>> invalidResourceInfo() {
        return Stream.of(
                Stream.of("2011", "1"),
                Stream.of("2022", "-25"),
                Stream.of("2019", "31"),
                Stream.of("-2020", "11")
        );
    }
}
