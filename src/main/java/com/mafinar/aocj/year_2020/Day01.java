package com.mafinar.aocj.year_2020;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.mafinar.aocj.utils.Solution;

public class Day01 implements Solution {
    private final int[] data;

    public Day01(List<String> data) {
        this.data = processInput(data);
    }

    @Override
    public String solvePart1() {
        Set<Integer> expenses = Arrays.stream(data).boxed().collect(Collectors.toSet());
        for (var expense_1 : data) {
            var expense_2 = 2020 - expense_1;
            if (expenses.contains(expense_2)) {
                return String.valueOf(expense_1 * expense_2);
            }
        }
        return null;
    }

    @Override
    public String solvePart2() {
        Set<Integer> expenses = Arrays.stream(data).boxed().collect(Collectors.toSet());
        for (var expense_1 : data) {
            for (var expense_2 : data) {
                var expense_3 = 2020 - (expense_1 + expense_2);
                if (expenses.contains(expense_3)) {
                    return String.valueOf(expense_1 * expense_2 * expense_3);
                }
            }
        }
        return null;
    }

    private int[] processInput(List<String> data) {
        return data.stream().mapToInt(Integer::parseInt).toArray();
    }
}
