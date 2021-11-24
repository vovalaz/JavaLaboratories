package com.company;

public class Main {

    public static void main(String[] args) {
        int[] r1 = int_func(125);
        System.out.println("sum = " + r1[0] + "; mult = " + r1[1]);
        System.out.println();

        System.out.println(bool_func(4, 2, 7));
        System.out.println(bool_func(-8, 10, 7));
        System.out.println(bool_func(-8, 10, 25));
        System.out.println();

        System.out.println(if_func(25, 3));
        System.out.println(if_func(7, 12));
        System.out.println();

        System.out.println("kg - kg: " + switch_func(1, 25.5));
        System.out.println("mg - kg: " + switch_func(2, 25.5));
        System.out.println("g - kg: " + switch_func(3, 25.5));
        System.out.println("ton - kg: " + switch_func(4, 25.5));
        System.out.println("quintal - kg: " + switch_func(5, 25.5));
        System.out.println();

        System.out.println("sum from a to b = " + for_func(15, 25));
        System.out.println();

        System.out.println(while_func(352));
        System.out.println();

        int[] int_arr = {8, 3, 5, 8, 6, 3, 4};
        for (var a : minmax_func(int_arr)) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println();

        double[] double_arr = {7.2, 156.3, 25.9, 444.05, 32, 75, 595.62};
        for (var a : array_func(double_arr)) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println();

        double[][] mtx =
                {
                        {16.99, 72.83, 77.61},
                        {34.93, 65.85, 24.74},
                        {49.46, 34.6, 9.98},
                        {98.73, 49.19, 96.89}
                };
        for (var a : matrix_func(2, mtx)) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static int[] int_func(int num) {
        if (num < 0) num *= -1;
        int dig, sum = 0, mult = 1;
        while (num > 0) {
            dig = num % 10;
            sum += dig;
            mult *= dig;
            num /= 10;
        }
        return new int[]{sum, mult};
    }

    public static boolean bool_func(int A, int B, int C) {
        return A <= B && B <= C;
    }

    public static int if_func(int a, int b) {
        return a < b ? 0 : 1;
    }

    public static double switch_func(int mode, double mass) {
        return switch (mode) {
            case 1 -> mass;
            case 2 -> mass / 1000000.0;
            case 3 -> mass / 1000.0;
            case 4 -> mass * 1000.0;
            case 5 -> mass * 100.0;
            default -> 0;
        };
    }

    public static int for_func(int a, int b) {
        int sum = 0;
        for (int i = a; i < b + 1; i++) {
            sum += i;
        }
        return sum;
    }

    public static int while_func(int N) {
        int K = N / 2;
        while (K * K > N) {
            K--;
        }
        return K + 1;
    }

    public static int[] minmax_func(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
            if (j < min) {
                min = j;
            }
        }
        int i = 0;
        while (i < arr.length && arr[i] != max) {
            i++;
        }
        int[] ret_arr = new int[2];
        ret_arr[0] = i;
        i = arr.length - 1;
        while (i > 0 && arr[i] != min) {
            i--;
        }
        ret_arr[1] = i;
        return ret_arr;
    }

    public static double[] array_func(double[] arr) {
        double[] ret_arr = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret_arr[i] = arr[arr.length - 1 - i];
        }
        return ret_arr;
    }

    public static double[] matrix_func(int K, double[][] mtx) {
        if (K > mtx.length) return null;
        return mtx[K];
    }
}
