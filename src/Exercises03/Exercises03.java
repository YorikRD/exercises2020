package Exercises03;

import java.util.Arrays;
import java.util.Scanner;

public class Exercises03 {
    public static void main(String[] args) {
        System.out.println("03 works");
//        task1();
//        task2_entrys("дом", "дом домик домой одомашненный");
        task3_polydrome("aowoa");
        task3_polydrome("а роза упала на лапу Азора");
        task4("heLLLoW!!");
        task5LongestWord("Пингвин слон гипопотам орангутангимного орангутангимноги орангутангимноги");


    }

    static void task1() {
        System.out.println("Input the arrays length");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String[] strmain = new String[length];
        int free = 0;
        String str;
        while (true) {
            System.out.println(" Input the next string, for quick exit type \"exit\" ");
            str = scanner.nextLine();
            boolean unique = true;
            if (str.equalsIgnoreCase("exit")) {
                System.out.println("Program finished by exit input");
                System.out.println("arr is" + Arrays.deepToString(strmain));
                break;
            }
            for (int i = 0; i < free; i++) {
                if (strmain[i].equalsIgnoreCase(str)) unique = false;
            }
            if (unique && free < length && !str.isEmpty()) {
                strmain[free] = str;
                free++;
            }
            if (free == length) {
                System.out.println("Successfully reached the end withe " + Arrays.deepToString(strmain));
                break;
            }

        }
    }

    static void task2_entrys(String strToFind, String findIn) {
        int entrys = 0;
        while (findIn.contains(strToFind)) {
            if (findIn.contains(strToFind)) entrys++;
            findIn = findIn.replaceFirst(strToFind, "");
        }
        System.out.println(entrys);
    }

    static void task3_polydrome(String checked) {
        checked = checked.toLowerCase();
        checked = checked.replaceAll("\\s", "");
        System.out.println(checked);
        char[] work = checked.toCharArray();
        boolean isPoD = true;
        for (int i = 0; i < work.length / 2; i++) {
            if (work[i] != work[work.length - i - 1]) {
                isPoD = false;
                break;
            }
        }
        System.out.println(isPoD);
    }

    static void task4(String word) {
        word = word.toLowerCase().trim();
        String wordFirst = word.substring(0, 1);
        wordFirst = wordFirst.toUpperCase();
        String wordOther = word.substring(1);
        word = wordFirst.concat(wordOther);
        System.out.println(word);
    }

    static void task5LongestWord(String word) {
        word = word.strip();
        String[] words = word.split("\\s");
        int[] lengths = new int[words.length];
        for (int i = 0; i < lengths.length; i++) {
            lengths[i] = words[i].length();
        }
        Arrays.sort(lengths);
        int ml = lengths[lengths.length - 1];
        int nomboflongest = 0;
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[lengths.length - 1] == lengths[lengths.length - 1 - i]) {
                nomboflongest++;
            }
        }
        String[] longerst = new String[nomboflongest];
        int countfre = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == ml) {
                longerst[countfre] = words[i];
                countfre++;
            }
        }
        System.out.println(Arrays.toString(longerst) + " with " + ml + " Length");

    }
}



