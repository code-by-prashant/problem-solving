package arrays;

import java.util.Arrays;

public class MinAnd2ndMin {

    public long[] minAnd2ndMin_with_sorting(long a[], long n) {

        Arrays.sort(a);
        // System.out.println(Arrays.toString(a));
        long result[] = new long[2];
        result[0] = a[0];

        boolean secondMinFound = false;

        for (int i = 1; i < n; ++i) {
            if (a[i] != a[i - 1]) {
                result[1] = a[i];
                secondMinFound = true; // If second minimum is found, set
                                       // secondMinFound to true
                break;
            }
        }

        // If there is no second minimum
        if (!secondMinFound) {
            // returning {-1, -1}
            return new long[] { -1, -1 };
        }

        return result;
    }

    public long[] minAnd2ndMin_inTwoLoops(long a[], long n) {

        long first_min = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            if (a[i] < first_min) {
                first_min = a[i];
            }
        }

        long second_min = Integer.MAX_VALUE;
        boolean secondMinFound = false;

        for (int i = 0; i < n; ++i) {
            if (a[i] == first_min)
                continue;
            if (a[i] < second_min) {
                second_min = a[i];
                secondMinFound = true;
                break;
            }
        }

        if (!secondMinFound) {
            return new long[] { -1, -1 };
        }

        long result[] = { first_min, second_min };
        return result;
    }

    public long[] minAnd2ndMin_inSingleLoop(long a[], long n) {

        long first_min = Integer.MAX_VALUE;
        long second_min = Integer.MAX_VALUE;

        boolean secondMinFound = false;

        for (int i = 0; i < n; ++i) {

            if (a[i] < first_min) {
                // shift the previous first_min to second_min
                second_min = first_min;
                // update first_min with new minimum value
                first_min = a[i];
            } else if (a[i] < second_min && a[i] != first_min) {
                // update second_min with value greater than first_min
                second_min = a[i];
                secondMinFound = true;
            }
        }

        if (!secondMinFound) {
            return new long[] { -1, -1 };
        }

        long result[] = { first_min, second_min };
        return result;
    }

    public static void main(String[] args) {

        // long[] array = { 4, 2, 1, 5, 6, 3, 2, 5, 7, 1, 3, 2, 4, 1 };
        long array[] = { 1, 1, 1, 1, 1, };

        MinAnd2ndMin obj = new MinAnd2ndMin();

        long[] result1 = obj.minAnd2ndMin_with_sorting(array, array.length);
        System.out.println("Single Loop with Sorting output: " + result1[0] + " " + result1[1]);

        long[] result = obj.minAnd2ndMin_inTwoLoops(array, array.length);
        System.out.println("Two Loops output: " + result[0] + " " + result[1]);

        long[] result2 = obj.minAnd2ndMin_inSingleLoop(array, array.length);
        System.out.println("Single Loop output: " + result2[0] + " " + result2[1]);

    }
}
