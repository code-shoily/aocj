package com.mafinar.aocj.year_2015;

import com.mafinar.aocj.utils.InputType;
import com.mafinar.aocj.utils.Solver;

import java.io.IOException;

public class Year2015 {
    private static final int YEAR = 2015;

    public static void solve(int day) throws IOException {
        switch (day) {
            case 1:
                var solver = new Solver(YEAR, 1, InputType.SINGLE_LINE);
                solver.solve(new Day01(solver.getContent().get(0)));
                break;
            default:
                break;
        }
    }
}
