package com.mycompany.assignment1;

import java.util.Arrays;
import java.util.Random;
public class Assignment1 {

    public static void main(String[] args) {
int n = 100000;
    Random rng = new Random(42);

    // 1. Make the four kinds of arrays
    int[] sorted = new int[n];
    int[] reversed = new int[n];

    // Fill the sorted array from 0 upwards.
    for (int i = 0; i < n; i++) {
        sorted[i] = i;
    }

    // Fill the reversed array from n - 1 downwards.
    for (int i = 0; i < n; i++) {
        reversed[i] = n - 1 - i;
}
int[] random = Arrays.copyOf(sorted, n);
    shuffle(random, rng);

    int[] partial = Arrays.copyOf(sorted, n);
    int[] positions = Arrays.copyOf(sorted, n);
    shuffle(positions, rng);

    int percentageToMove = 20;
    int moved = n * percentageToMove / 100;
    int first = partial[positions[0]];

    for (int i = 0; i < moved - 1; i++) {
        partial[positions[i]] = partial[positions[i + 1]];
    }
    partial[positions[moved - 1]] = first;

    // 2. Run the benchmarks
    int[][] data = { random, reversed, partial, sorted };
    String[] names = {
            "Random", "Reversed", "80% Sorted", "Fully Sorted"
    };

    long[][] times = new long[2][4];

    for (int a = 0; a < 2; a++) {
        for (int c = 0; c < 4; c++) {
            String algorithm;
            if (a == 0) {
                algorithm = "Quick Sort";
            } else {
                algorithm = "Bubble Sort";
            }

            System.out.println(
                    "Testing " + algorithm + " / " + names[c] + "...");

            int[] test = Arrays.copyOf(data[c], n);

            long start = System.nanoTime();

            if (a == 0) {
                quickSort(test, 0, n - 1);
            } else {
                bubbleSort(test);
            }

            times[a][c] = (System.nanoTime() - start) / 1000;

            // Make sure the sorting worked
            for (int i = 1; i < n; i++) {
                if (test[i - 1] > test[i]) {
                    throw new RuntimeException("Sorting failed!");
                }
            }
        }
    }

    // 3. Print the results
    System.out.println("\nRESULTS IN MICROSECONDS (N = " + n + ")");

    System.out.printf("%-14s %15s %15s %15s %15s%n",
            "Algorithm", "Random", "Reversed",
            "80% Sorted", "Fully Sorted");

    System.out.printf("%-14s %,15d %,15d %,15d %,15d%n",
            "Quick Sort",
            times[0][0], times[0][1],
            times[0][2], times[0][3]);

    System.out.printf("%-14s %,15d %,15d %,15d %,15d%n",
            "Bubble Sort",
            times[1][0], times[1][1],
            times[1][2], times[1][3]);
}

// Shuffle numbers into random order
static void shuffle(int[] a, Random rng) {
    for (int i = a.length - 1; i > 0; i--) {
        int j = rng.nextInt(i + 1);

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

// Bubble Sort
static void bubbleSort(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
        boolean swapped = false;

        for (int j = 0; j < a.length - 1 - i; j++) {
            if (a[j] > a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
                swapped = true;
            }
        }

        if (!swapped)
            break;
    }
}

// Quick Sort
static void quickSort(int[] a, int left, int right) {
    int i = left;
    int j = right;
    int pivot = a[left + (right - left) / 2];

    while (i <= j) {
        while (a[i] < pivot)
            i++;
        while (a[j] > pivot)
            j--;

        if (i <= j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    if (left < j)
        quickSort(a, left, j);
    if (i < right)
        quickSort(a, i, right);
}
}