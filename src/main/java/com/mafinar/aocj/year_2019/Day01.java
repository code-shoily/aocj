package com.mafinar.aocj.year_2019;

import com.mafinar.aocj.utils.InputReader;
import com.mafinar.aocj.utils.Solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day01 implements Solution {
    private final int[] data;

    public Day01(List<String> data) {
        this.data = processInput(data);
    }

    public int[] getData() {
        return data;
    }

    @Override
    public String solvePart1() {
        return Arrays.stream(this.data)
                .boxed()
                .map(Day01::getFuel)
                .reduce((a, b) -> a + b)
                .orElse(0)
                .toString();
    }

    @Override
    public String solvePart2() {
        return Arrays.stream(this.data)
                .boxed()
                .map(Day01::getFuelCorrected)
                .reduce((a, b) -> a + b)
                .orElse(0)
                .toString();
    }

    public static int getFuel(int mass) {
        return mass / 3 - 2;
    }

    public static int getFuelCorrected(int mass) {
        var fuel = getFuel(mass);
        var totalFuel = fuel;

        while (true) {
            var temp = getFuel(fuel);
            if (temp > 0) {
                fuel = temp;
                totalFuel += fuel;
            } else {
                break;
            }
        }

        return totalFuel;
    }

    private int[] processInput(List<String> data) {
        return data.stream().mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) throws IOException {
        var inputReader = new InputReader(2019, 1);
        var today = new Day01(inputReader.readLinesFromFile());
        System.out.printf("Solve 1: %s\n", today.solvePart1());
        System.out.printf("Solve 2: %s\n", today.solvePart2());
    }
}
