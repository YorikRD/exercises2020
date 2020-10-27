package Optional.Leetcode.reversedInteger;

import com.exam01.VariablesAndRand;

public class Aplication {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = -2147483648;
        System.out.println(solution.reverse(a));
//        int [] check = randomcheck(25);
//        for (int i : check) {
//            System.out.println("for int "+i+" the reversed value will be "+solution.reverse(i));
//        }
//        Integer integer = Integer.reverse(234);
//        System.out.println(integer);

    }

    static int[] randomcheck(int length){
        int[] frret = new int[length];
        for (int i = 0; i <length ; i++) {
            frret[i] = VariablesAndRand.rand(-100000,100000);
        }
        return frret;
    }
}
