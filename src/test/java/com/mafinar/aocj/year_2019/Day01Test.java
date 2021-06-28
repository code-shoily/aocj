package com.mafinar.aocj.year_2019;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.mafinar.aocj.utils.InputReader;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {
    Day01 givenProblemData;

    @BeforeEach
    public void setUp() throws IOException {
        givenProblemData = new Day01(new InputReader(2019, 1).readLinesFromFile());
    }

    @Test
    @DisplayName("When created Day01 object should contain processed data")
    public void testDay01GetsProcessedData() {
        List<String> inputData = Stream.of("1", "2", "3").collect(Collectors.toList());
        int[] outputData = {1, 2, 3};
        var today = new Day01(inputData);
        assertArrayEquals(outputData, today.getData());
    }

    @ParameterizedTest
    @DisplayName("getFuel should calculate the fuel")
    @MethodSource("fuelData")
    public void testGetFuelAccuracy(int input, int output) {
        assertEquals(output, Day01.getFuel(input));
    }

    @ParameterizedTest
    @DisplayName("getCorrectedFuel should calculate the fuel correctly")
    @MethodSource("correctedFuelData")
    public void testGetCorrectedFuelAccuracy(int input, int output) {
        assertEquals(output, Day01.getFuelCorrected(input));
    }

    @Test
    @DisplayName("solvePart1 should yield the result that was correct for given dataset")
    public void testSolve1ForGivenData() {
        assertEquals("3421505", givenProblemData.solvePart1());
    }

    @Test
    @DisplayName("solvePart2 should yield the result that was correct for given dataset")
    public void testSolve2() {
        assertEquals("5129386", givenProblemData.solvePart2());
    }

    public static Stream<Arguments> fuelData() {
        return Stream.of(
                Arguments.arguments(12, 2),
                Arguments.arguments(14, 2),
                Arguments.arguments(1969, 654),
                Arguments.arguments(100756, 33583)
        );
    }

    public static Stream<Arguments> correctedFuelData() {
        return Stream.of(
                Arguments.arguments(12, 2),
                Arguments.arguments(14, 2),
                Arguments.arguments(1969, 966),
                Arguments.arguments(100756, 50346)
        );
    }
}