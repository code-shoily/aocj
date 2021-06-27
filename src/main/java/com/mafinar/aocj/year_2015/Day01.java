package com.mafinar.aocj.year_2015;

import java.io.*;

import com.mafinar.aocj.utils.InputReader;

public class Day01 {
    private final char[] input;

    public Day01(String input) {
        this.input = processInput(input);
    }

    public int solvePart1() {
        var currentFloor = 0;

        for (var instruction : input) {
            currentFloor = computeNextFloor(currentFloor, instruction);
        }

        return currentFloor;
    }

    public int solvePart2() {
        var currentFloor = 0;
        var idx = 0;

        while (currentFloor != -1) {
            currentFloor = computeNextFloor(currentFloor, input[idx++]);
        }
        return idx;
    }

    public int computeNextFloor(int currentFloor, char instruction) {
        return instruction == '(' ? currentFloor + 1 : currentFloor - 1;
    }

    private char[] processInput(String input) {
        return input.toCharArray();
    }

    public static void main(String[] args) throws IOException {
        var day01 = new Day01(new InputReader(2015, 1).readFromFile());

        System.out.println(day01.solvePart1());
        System.out.println(day01.solvePart2());
    }
}
