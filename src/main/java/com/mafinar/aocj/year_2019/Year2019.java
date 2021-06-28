package com.mafinar.aocj.year_2019;

import java.io.IOException;

import com.mafinar.aocj.utils.InputType;
import com.mafinar.aocj.utils.Solver;

public class Year2019 {
    private static final int YEAR = 2019;

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
