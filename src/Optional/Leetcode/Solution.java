package Optional.Leetcode;

import java.util.Arrays;

class Solutions {
    public int[] twoSum(int[] nums, int target) {
        WrapperP[] wr = new WrapperP[nums.length];
        for (int i = 0; i < wr.length; i++) {
            wr[i] = new WrapperP(nums[i], i);
        }
        Arrays.sort(wr);
        Arrays.sort(nums);
//        for (int i = 0; i < wr.length; i++) {
//            if (wr[i].info!=nums[i]) System.out.println(" Mismatch at index of "+i);
//        }
        int a = Arrays.binarySearch(nums, target);
//        System.out.println("a is "+a);
//        System.out.println(a);
        int[] s = {0, 0};
        if (a < 0) {
            a = (-a < nums.length) ? -a : (-a - 1);
        } else if (a >= 0) {
            if (nums[a] + nums[a + 1] == target) {
                s[0] = wr[a].index;
                s[1] = wr[a + 1].index;
                System.out.println("return from block 1");
                return s;
            }
            else if(a ==-1){
                a=nums.length/2;
            }

        }
        System.out.println("a after correction " + a);
        int div = a / 2;
        System.out.println("div is " + div);
        int secondpoint;
        while (div >= 0 && div < nums.length) {
            System.out.println("div is " + div);
            secondpoint = Arrays.binarySearch(nums, target - nums[div]);
            if ((secondpoint < -nums.length) || secondpoint == div) div++;
            if (secondpoint == -1) div--;
            System.out.println("sec " + secondpoint);
            if (secondpoint >= 0 && nums[secondpoint] + nums[div] == target && div != secondpoint) {
                s[0] = wr[secondpoint].index;
                s[1] = wr[div].index;
                return s;
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
        int[] doll = {-10, 7, 19, 15};
        int at = -9;
        Solutions sol1 = new Solutions();
        int[] pos = sol1.twoSum(doll, at);
        System.out.println(Arrays.toString(pos));
        System.out.println(Arrays.binarySearch(doll, at));

    }
}
