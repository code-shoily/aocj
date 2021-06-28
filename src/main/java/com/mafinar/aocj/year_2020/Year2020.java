package com.mafinar.aocj.year_2020;

import com.mafinar.aocj.utils.InputType;
import com.mafinar.aocj.utils.Solver;

import java.io.IOException;

public class Year2020 {
    private static final int YEAR = 2020;

    public static void solve(int day) throws IOException {
        switch (day) {
            case 1:
                var solver = new Solver(YEAR, 1, InputType.MULTI_LINE);
                solver.solve(new Day01(solver.getContent()));
                break;
            default:
                break;
        }
    }
}
