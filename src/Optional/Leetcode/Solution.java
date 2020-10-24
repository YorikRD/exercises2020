package Optional.Leetcode;
import com.Exam01.VariablesAndRand;

import java.util.Arrays;

class Solutions {
    public int[] twoSum(int[] nums, int target) {
        WrapperP[] wr = new WrapperP[nums.length];
        for (int i = 0; i < wr.length; i++) {
            wr[i] = new WrapperP(nums[i], i);
        }
        Arrays.sort(wr);
        Arrays.sort(nums);
        int a = Arrays.binarySearch(nums, target);
        int[] s = {0, 0};
        if (a < 0) {
            a = (-a < nums.length) ? -a : (-a - 1);
        } else if (a >= 0) {
            if (a+1<nums.length &&nums[a] + nums[a + 1] == target) {
                s[0] = wr[a].index;
                s[1] = wr[a + 1].index;
                System.out.println("return from block 1");
                return s;
            } else if (a == -1) {
                a = nums.length / 2;
            }

        }
        System.out.println("a after correction " + a);
        int div = a / 2;
        System.out.println("div is " + div);
        int secondpoint;
        int down = 0;
        int up = nums.length;
        while (div >= 0 && div < nums.length) {
            System.out.println("div is " + div + " value= " + nums[div]);
            secondpoint = Arrays.binarySearch(nums, target - nums[div]);
            System.out.println("sec " + secondpoint + " Surched for value of " + (target - nums[div]));
            if (secondpoint >= 0 && nums[secondpoint] + nums[div] == target && div != secondpoint) {
                s[0] = wr[secondpoint].index;
                s[1] = wr[div].index;
                return s;
            }
            if ((secondpoint <= -nums.length) || secondpoint == div||(-secondpoint>1)) {
                System.out.println("div+ is trigered from value of "+div +" to "+(div+1 ));
                div++;
            }
            if (secondpoint == -1 ) {
                System.out.println("div- is trigered from value of "+div +" to "+(div-1) );
                div--;
            }

        }//                System.out.println("div is " +div +" number is " + nums[div]);

        System.out.println("Result no found");
        return s;


    }


    class WrapperP implements Comparable {
        int info = 0;
        int index = 0;

        public WrapperP(int info, int index) {
            this.info = info;
            this.index = index;
        }

        @Override
        public String toString() {
            return "WrapperP{" +
                    "info=" + info +
                    ", index=" + index +
                    '}' + "\n";
        }

        @Override
        public int compareTo(Object o) {
            if (o.getClass() != WrapperP.class) throw new IllegalArgumentException("RRR");
            WrapperP w2 = (WrapperP) o;
            if (this.info > w2.info) return 1;
            if (this.info < w2.info) return -1;
            return 0;
        }
    }
}


public class Solution {
    public static void main(String[] args) {
        Solutions solutions2= new Solutions();
        int[] arrr ={0,3,0};
        int trgt =0;
        System.out.println(Arrays.toString(solutions2.twoSum(arrr, trgt)));
        masstest();



    }

    private static void masstest(){
        Solutions solutions= new Solutions();
        int[][] ms = new int[12000][];
        for (int i = 0; i <22 ; i++) {
            int length = (int)(Math.random()*6)+32;
            ms[i]=new int[length];
            for (int j = 0; j < length; j++) {
                ms[i][j]=VariablesAndRand.rand(-150,257);
            }
            int trgt = ms[i][VariablesAndRand.rand(3,ms[i].length-1)]+ ms[i][2];
            System.out.println(Arrays.toString(ms[i]) +" Target is "+trgt+" "+Arrays.toString(solutions.twoSum(ms[i],trgt)));
        }

    }
}
