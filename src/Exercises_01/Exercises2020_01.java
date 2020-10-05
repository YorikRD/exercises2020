package Exercises_01;

import java.util.Scanner;

public class Exercises2020_01 {
    public static void main(String[] args) {
        int guess = 51;
        int up = 100;
        int low = 1;
        int step;
        Scanner scanner = new Scanner(System.in);
        int answer;
//        gesser(guess, up, low, step = 1, answer = 51, scanner);
//        sequence();
//        task5Lottery(1111);
//        task5Lottery(1112);
//        task5Lottery(7777);
//        task5Lottery(3333);
//        task5Lottery(4444);
//        task6RevGuess();


    }

    public static void gesser(int guess, int up, int low, int step, int answer, Scanner scanner) {
        System.out.println("Загадайте число от 1 до 100 включая указанные");
        while (true) {
            System.out.println("Вы загадали " + guess + " ? если да введите 1, если нет 0");
            answer = scanner.nextInt();
            if (answer == 1) {
                break;
            }
            System.out.println("Вы загадали число больше? если да введите 1 если нет 0");
            answer = scanner.nextInt();
            if (answer == 1) {
                low = guess + 1;
                step = (up - guess) / 2;
                if (step >= 1) {
                    guess = guess + step;
                } else {
                    guess++;
                }
            } else if (answer == 0) {
                up = guess - 1;
                step = (guess - low) / 2;
                if (step >= 1) {
                    guess = guess - step;
                } else {
                    guess--;
                }
            }
        }
        System.out.println("Система угадала разработчик доволен");
        return;
    }

    static void sequence() {
        int calc = 1;
        for (int i = 1; i <= 20; i++) {
            calc = calc * 2;
            System.out.println(i + "-й элемент последовательности =" + calc);

        }
    }

    static void task3() {
        int arg = 90;
        while (arg >= 0) {
            System.out.println(arg);
            arg = arg - 5;
        }
    }

    static void task4Rand() {
        int rand = (int) (Math.random() * 491) + 10;
        if (rand >= 25 && rand <= 200) {
            System.out.println("Число " + rand + " лежит в интервале от 25 до 200");
        } else {
            System.out.println("Число " + rand + " не лежит в интервале от 25 до 200");
        }
    }

    static void task5Lottery(int ticknomb) {
        switch (ticknomb) {
            case 1111:
            case 2222:
            case 3333:
                System.out.println(" You priaze ia a book!");
                break;
            case 4444:
            case 5555:
                System.out.println(" You priaze ia a phone!");
                break;
            case 7777:
                System.out.println(" You priaze ia a Laptop!!");
                break;
            default:
                System.out.println(" You sorry no prize for you today");
                break;

        }
    }

    static void task6RevGuess() {
        int rand = (int) (Math.random() * 9) + 1;
        System.out.println("Загадано число от 1 до 9, угадывайте вводя в консоль, для прекращения работы введите 0 в консоль");
        Scanner scanner6 = new Scanner(System.in);
        int userguess;
        while (true) {
            userguess = scanner6.nextInt();
            if (userguess == rand) {
                System.out.println("Вы угадали программа завершает свою работу");
                break;
            } else if (userguess > 9 ^ userguess < 0) {
                System.out.println("Вы вввели недопустимое значение. введите целое числов в диапазоне от 1 до 9");
            } else if (userguess == 0) {
                System.out.println(" Программа завершена пользователем введением кода 0");
                break;
            } else if (userguess > rand) {
                System.out.println("Загаданное числоа меньше вашей догадки");
            } else if (userguess < rand) {
                System.out.println("Загаданное число больше вашей догадки");
            }
        }


    }

}




