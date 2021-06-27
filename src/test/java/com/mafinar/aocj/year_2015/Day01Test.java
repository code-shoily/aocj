package com.mafinar.aocj.year_2015;

import com.mafinar.aocj.utils.InputReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {
    Day01 givenProblemData;

    @BeforeEach
    public void setUp() throws IOException  {
        givenProblemData = new Day01(new InputReader(2015, 1).readFromFile());
    }

    @Test
    @DisplayName("solvePart1 should yield the result that was correct for given dataset")
    public void testSolve1ForGivenData() {
        assertEquals(givenProblemData.solvePart1(), 232);
    }

    @Test
    @DisplayName("solvePart2 should yield the result that was correct for given dataset")
    public void testSolve2() {
        assertEquals(givenProblemData.solvePart2(), 1783);
    }
}