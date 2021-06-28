package com.mafinar.aocj.year_2015;

import java.io.IOException;

import com.mafinar.aocj.utils.InputReader;
import com.mafinar.aocj.utils.Solution;

public class Day01 implements Solution {
    private final char[] input;

    public Day01(String input) {
        this.input = processInput(input);
    }

    public String solvePart1() {
        var currentFloor = 0;

        for (var instruction : input) {
            currentFloor = computeNextFloor(currentFloor, instruction);
        }

        return String.valueOf(currentFloor);
    }

    public String solvePart2() {
        var currentFloor = 0;
        var idx = 0;

        while (currentFloor != -1) {
            currentFloor = computeNextFloor(currentFloor, input[idx++]);
        }
        return String.valueOf(idx);
    }

    public int computeNextFloor(int currentFloor, char instruction) {
        return instruction == '(' ? currentFloor + 1 : currentFloor - 1;
    }

    private char[] processInput(String input) {
        return input.toCharArray();
    }

    public static void main(String[] args) throws IOException {
        var inputReader = new InputReader(2015, 1);
        var today = new Day01(inputReader.readFromFile());
        System.out.printf("Solve 1: %s\n", today.solvePart1());
        System.out.printf("Solve 2: %s\n", today.solvePart2());
    }
}
