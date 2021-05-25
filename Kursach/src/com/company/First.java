package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class First {
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 2};
        maxPerimeter(arr1, 3);
        int[] arr2 = {3, 6, 2, 3};
        maxPerimeter(arr2, 4);
        int[] arr3 = {33, 6, 20, 1, 8, 12, 5, 55, 4, 9};
        maxPerimeter(arr3, 10);

        int[] nums = {2, 10, 4};
        System.out.println(largestNumber(nums));

        int[][] diagonal = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                diagonal[i][j] = (int) (Math.random() * 6);
            }
        }
        System.out.println(Arrays.deepToString(diagonalSort(diagonal)));
    }

    // Задание №1. Максимальный периметр треугольника
    static void maxPerimeter(int[] arr, int n) {
        int maxP = 0; // Создаём переменную, который будет хранить максимальное значение периметра
        for (int i = 0; i < n - 2; i++) { // Берём различные значения из массива
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int a = arr[i]; // Присваиваем их значения сторонам
                    int b = arr[j];
                    int c = arr[k];
                    if (a < b + c && b < c + a && c < a + b) { // Если можно образовать треугольник
                        maxP = Math.max(maxP, a + b + c); // То переменной присваивается максимальное значение
                    }
                }
            }
        }
        if (maxP > 0) // Если периметр поменялся
            System.out.println("Максимальный периметр: " + maxP); //Выводим значение
        else // Иначе выводим ошибку
            System.out.println("Образование треугольника из таких значений невозможно");
    }

    // Задача №2. Максимальное число
    private static class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public static String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, new LargerNumberComparator());
        if (asStrs[0].equals("0")) {
            return "0";
        }
        StringBuilder largestNumberStr = new StringBuilder("");
        for (String numAsStr : asStrs) {
            largestNumberStr.append(numAsStr);
        }
        return largestNumberStr.toString();
    }


    // Задача №3. Сортировка диагоналей в матрице
    public static int[][] diagonalSort(int[][] M) {
        int y = M.length, x = M[0].length - 1;
        int[] diag = new int[y];
        for (int i = 2 - y; i < x; i++) {
            int k = 0;
            for (int j = 0; j < y; j++)
                if (i + j >= 0 && i + j <= x)
                    diag[k++] = M[j][i + j];
            Arrays.sort(diag, 0, k);
            k = 0;
            for (int j = 0; j < y; j++)
                if (i + j >= 0 && i + j <= x)
                    M[j][i + j] = diag[k++];
        }
        return M;
    }
}
