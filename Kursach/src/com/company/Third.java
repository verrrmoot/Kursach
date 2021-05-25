package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Third {
    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res = 0, n = piles.length;
        for (int i = n / 3; i < n; i += 2)
            res += piles[i];
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во чисел:");
        int amount = Integer.parseInt(scanner.nextLine()); // Считываем кол-во
        if (amount > 0) {
            int[] coins = new int[amount];
            System.out.println("Введите значения:");
            for (int i = 0; i < amount; i++) {
                coins[i] = Integer.parseInt(scanner.nextLine());
                if (coins[i] < 0) {
                    System.out.println("Значения монет не могут быть отрицательными!");
                    System.exit(0);
                }
            }
            int ans = maxCoins(coins);
            System.out.println(ans);
        } else {
            System.out.println("Не может быть 0 или отрицательное кол-во монет!");
        }

        System.out.println("Введите кол-во пар чисел:");
        int xCoord = Integer.parseInt(scanner.nextLine()); // Считываем, сколько будет пар в массиве
        if (xCoord > 0) { // Если не 0, то продолжаем
            int[][] points = new int[xCoord][2]; // Заводим массив
            for (int i = 0; i < xCoord; i++) { // Циклом заполняем координаты
                System.out.println("Введите числа для заполнения " + (i + 1) + "-х координат xStart и xEnd через Enter:");
                points[i][0] = Integer.parseInt(scanner.nextLine());
                points[i][1] = Integer.parseInt(scanner.nextLine());
                if (points[i][1] <= points[i][0]) {
                    System.out.println("Стартовая позиция шарика не может быть меньше конечной!");
                    System.exit(0);
                }
            }
            System.out.println("Ответ: " + findMinArrowShots(points)); // Выводим результат
        } else
            System.out.println("Массив не может иметь 0 или отрицательное кол-во пар!");

    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1])); // Сортировка по координате y
        System.out.println("Массив отсортирован: " + Arrays.deepToString(points));
        int arrow = 1; // Переменная кол-ва стрел
        int end = points[0][1]; // Берём первый шарик
        for (int i = 1; i < points.length; i++) {
            if (end < points[i][0]) { // Если шарик оказался дальше по координате xEnd
                arrow++; // Прибавляем кол-во стрел
                end = points[i][1]; // Перемещаем конечную точку на этот шар
            }
        }
        return arrow;
    }
}
