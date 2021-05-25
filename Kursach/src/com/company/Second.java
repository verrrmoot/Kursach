package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        double p = treugolniki();
        System.out.println(p);

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

    public static double treugolniki(){
        Scanner scan1 = new Scanner(System.in);

        System.out.println("Введите кол-во элементов массива: ");
        int length = scan1.nextInt();
        System.out.println("Введите массив из сторон: ");

        double [] arr = new double[length];
        for(int i=0; i<length; i++ ) {
            arr[i] = scan1.nextDouble();
        }

        double p = -1;
        double pmax = -2;

        for (int i = 0; i < length-2; i++){
            for (int j = i+1; j < length - 1; j++){
                for (int k = j+1; k < length; k++){

                    double pp = (arr[i] + arr[j] + arr[k])/2;
                    double s = Math.sqrt(pp*(pp-arr[i])*(pp-arr[j])*(pp-arr[k]));
                    if ((s > 0) && (arr[i]+arr[j] > arr[k]) && (arr[k]+arr[j] > arr[i]) && (arr[i]+arr[k] > arr[j])){
                        pmax = arr[i] + arr[j] + arr[k];
                    }

                    if (pmax > p){
                        p = pmax;
                    }
                }
            }
        }

        if (p < 0)
            return 0;
        else return p;

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
