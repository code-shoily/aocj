package com.mafinar.aocj.utils;

import java.io.IOException;
import java.util.List;

public class Solver {
    protected int year;
    protected int day;
    protected InputType inputType;

    public Solver(int year, int day, InputType inputType) {
        this.year = year;
        this.day = day;
        this.inputType = inputType;
    }

    public List<String> getContent() throws IOException {
        return switch (this.inputType) {
            case SINGLE_LINE -> {
                var content = new InputReader(year, day).readFromFile();
                yield List.of(new String[]{content});
            }
            case MULTI_LINE -> new InputReader(year, day).readLinesFromFile();
        };
    }

    public void solve(Solution solution) {
        String solutionPart1 = solution.solvePart1();
        String solutionPart2 = solution.solvePart2();

        System.out.printf("Part 1: %s\t\tPart 2: %s", solutionPart1, solutionPart2);
    }
}
