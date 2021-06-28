package com.mafinar.aocj.year_2020;

import java.util.List;

import com.mafinar.aocj.utils.Solution;

public class Day01 implements Solution {
    private final int[] data;

    public Day01(List<String> data) {
        this.data = processInput(data);
    }

    @Override
    public String solvePart1() {
        for (var i = 0; i < data.length; i++) {
            for (var j = 0; j < data.length; j++) {
                if (i != j && data[i] + data[j] == 2020) {
                    return String.valueOf(data[i] * data[j]);
                }
            }
        }
        return null;
    }

    @Override
    public String solvePart2() {
        for (var i = 0; i < data.length; i++) {
            for (var j = 0; j < data.length; j++) {
                for (var k = 0; k < data.length; k++) {
                    if (i != j && j != k && data[i] + data[j] + data[k] == 2020) {
                        return String.valueOf(data[i] * data[j] * data[k]);
                    }
                }
            }
        }
        return null;
    }

    private int[] processInput(List<String> data) {
        return data.stream().mapToInt(Integer::parseInt).toArray();
    }
}
