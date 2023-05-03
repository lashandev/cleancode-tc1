package com.epic.techtalk;

public class StringBenchmark {
    public static void main(String[] args) {
        String appendCharacter = "a";

        int inputSample[] = new int[]{
                100000, 200000, 300000, 400000,
                500000, 600000, 700000, 800000,
                900000, 1000000};

        for (int n : inputSample) {
            double startTime = System.nanoTime();
            testStringAppend(n, "", appendCharacter);
            double endTime = System.nanoTime();
            double duration = (endTime - startTime) / 1000000000;
            String seconds = String.format("%.2f", duration);
            System.out.println("n = " + n + ": seconds: " + seconds);
        }
    }

    static void testStringAppend(int n, String str, String appendCharacter) {
        for (int i = 1; i <= n; i++) {
            str += appendCharacter;
        }
    }
}
