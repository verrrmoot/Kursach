package com.company;

import java.util.*;

public class First {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Задание 1:");
        System.out.println("Введите первую строку");
        String s1 = in.nextLine();
        System.out.println("Введите вторую строку");
        String s2 = in.nextLine();

        System.out.println("Результат: " + checkIfCanBreak(s1,s2));
        System.out.println("Задание 2:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str1 =scanner.nextLine();
        System.out.println("Введенная строка: " + str1);
        System.out.println("Длина самой большой строки полиндрома: " + longPalSubstr(str1));
        System.out.println("Задание 3:");
        System.out.println("Введите строку:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println( distinctEchoSubstrings(s));
    }
    static void printSubStr(String str1, int l, int h) {
        System.out.println(str1.substring(l, h + 1));
    }
    static int longPalSubstr(String str1) {
        int n = str1.length();
        boolean table[][] = new boolean[n][n];
        int mLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;
        int strt = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str1.charAt(i) == str1.charAt(i + 1)) {
                table[i][i + 1] = true;
                strt = i;
                mLength = 2;
            }
        }
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if (table[i + 1][j - 1] && str1.charAt(i) == str1.charAt(j)) {
                    table[i][j] = true;
                    if (k > mLength) {
                        strt = i;
                        mLength = k;
                    }
                }
            }
        }
        System.out.print("Наибольшая строка полиндром в ввведенной строке: ");
        printSubStr(str1, strt, strt + mLength - 1);
        return mLength;
    }
    public static boolean checkIfCanBreak(String s1, String s2) {
        int []arr1=new int[26];
        int []arr2=new int[26];

        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i)-'a']++;
        }

        for(int i=0;i<s2.length();i++){
            arr2[s2.charAt(i)-'a']++;
        }

        int count1=0;
        int count2=0;
        int greater=0;
        int smaller=0;

        for(int i=0;i<26;i++){
            count1+=arr1[i];
            count2+=arr2[i];

            if(count2>count1){
                smaller++;
            }else if(count1>count2){
                greater++;
            }
            if(smaller>0 && greater>0)
                return false;
        }
        return true;
    }
    public static int distinctEchoSubstrings(String text) {
        if (text == null || text.length() == 0) return 0;
        Set<String> stringSet = new HashSet<>();

        for (int right = 1; right <= text.length(); ++right)
        {
            for (int left = 0; left < right; ++left)
            {
                if (right - left <= 1) continue;
                String subStr = text.substring(left, right);
                if (isEchoString(subStr)) {
                    stringSet.add(subStr);
                }
            }
        }

        return stringSet.size();
    }

    private static boolean isEchoString(String subStr)
    {
        if (subStr.length() % 2 != 0) return false;

        if (subStr.substring(0, subStr.length()/2).equals(subStr.substring(subStr.length()/2, subStr.length())))
            return true;
        return false;
    }
}
