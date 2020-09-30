package Exercises_02;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Exercises_02 {
    public static void main(String[] args) {

        int[] arr1 = new int[]{-40, -20, 1300, -12};
        int[] arr2 = new int[]{-40, -20, 1300, -13};
//        System.out.println(Arrays.compare(arr1, arr2));
        System.out.println(Arrays.compareUnsigned(arr1, arr2));
//        System.out.println(Arrays.mismatch(arr1, arr2));

//        task2();
//        task3();


    }

    static int randomgen(int low, int up) {
        int rnd = (int) (Math.random() * (up - low)) + low + 1;
        return rnd;
    }

    static void task1() {
        int[] task1 = new int[randomgen(1, 22)];
        for (int i = 0; i < task1.length; i++) {
            task1[i] = randomgen(-12, 38);
        }
        System.out.println(Arrays.toString(task1));
        Arrays.sort(task1);
        System.out.println(Arrays.toString(task1));
        System.out.println("Lower value = " + task1[0]);
        System.out.println("Mid value = " + task1[task1.length / 2]);
        System.out.println("Upper value = " + task1[task1.length - 1]);
    }

    static void task2() {
        int length = 0;
        for (int i = 2; i <= 20; i = i + 2) {
            length++;
        }
        int[] task2 = new int[length];
        int a = 2;
        for (int i = 0; i < length; i++) {
            task2[i] = a;
            a = a + 2;
        }
        System.out.println(Arrays.toString(task2));
        for (int i = length; i > 0; i--) {
            System.out.println(task2[i - 1]);
        }
    }

    static void task3() {
        int[] arr = new int[11];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomgen(-2, 1);
        }
        System.out.println(Arrays.toString(arr));
        int minus = 0;
        int zero = 0;
        int plus = 0;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case -1:
                    minus++;
                    break;
                case 0:
                    zero++;
                    break;
                case 1:
                    plus++;
                    break;
            }
        }
        System.out.println("-1 = " + minus);
        System.out.println("0 = " + zero);
        System.out.println("+1 = " + plus);
        if ((minus >= zero && minus > plus) | (minus > zero && minus >= plus)) {
            System.out.println(" \"- 1\" is the most frequent with " + minus + " entries");
        } else if ((zero >= minus && zero > plus) | (zero > minus && zero >= plus)) {
            System.out.println(" \" 0 \" is the most frequent with " + zero + " entries");
        } else if ((plus >= minus && plus > zero) | (plus > minus && plus >= zero)) {
            System.out.println(" \" + 1 \" is the most frequent with " + plus + " entries");
        } else {
            System.out.println(" No Decent leader");
        }
    }

}

