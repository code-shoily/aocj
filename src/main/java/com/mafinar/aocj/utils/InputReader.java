package com.mafinar.aocj.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InputReader {
    private int year;
    private int day;
    private String tag;

    public InputReader(int year, int day, String tag) {
        if (isInvalidDateParams(year, day)) {
            throw new IllegalArgumentException("Ranges: Year [2015, 2020], Day [1, 25]");
        }

        this.year = year;
        this.day = day;
        this.tag = tag;
    }

    public InputReader(int year, int day) {
        this(year, day, null);
    }

    public String getFileName() {
        if (this.tag != null)
            return String.format("year_%d/day%02d_%s.txt", this.year, this.day, this.tag);
        return String.format("year_%d/day%02d.txt", this.year, this.day);
    }

    public String readFromFile() throws IOException {
        var resource = getClass().getClassLoader().getResourceAsStream(getFileName());

        try (resource) {
            if (resource != null)
                return new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8)).readLine();
        }
        throw new NullPointerException("Input resource not found.");
    }

    private static boolean isInvalidDateParams(int year, int day) {
        return year > 2020 || year < 2015 || day > 25 || day < 1;
    }
}
