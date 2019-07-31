package org.algorithm.warmup;

public class CountingValleys {
    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
        System.out.println(countingValleys(8, "DDUUUUDD"));
        System.out.println(countingValleys(12, "DDUUDDUDUUUD"));
        System.out.println(countingValleys(30, "UUDDUUUDDDDDUDUUUDDUDUUUDDUUDD"));
    }

    static int countingValleys(int n, String s) {
        int level = 0;
        int valleys = 0;
        boolean crossingValley = false;

        for (char step : s.toCharArray()) {
            level += computeStep(step);

            if (level == -1 && !crossingValley) {
                crossingValley = true;
            } else if (level == 0 && crossingValley) {
                valleys++;
                crossingValley = false;
            }
        }

        return valleys;
    }

    private static int computeStep(char step) {
        return step == 'U' ? 1 : -1;
    }
}
