package Optional.Leetcode.reversedInteger;

import java.util.Arrays;

class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        Long rev2 = 0l;
        int zn = (x > 0) ? 1 : -1;
        x = x * zn;
        int razr =(int)Math.log10((double)x);


        int[] arr = new int[razr + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = x / ((int) Math.pow(10, razr - i));
            x -= arr[i] * ((int) Math.pow(10, razr - i));
            rev2 += arr[i] * ((long) Math.pow(10, i));
//            System.out.println(rev2 +" and it is " + ((rev2>2147483647)||(rev2<-2147483648)));
            if (rev2.longValue()>=(long)Integer.MAX_VALUE||rev2.longValue()<=(long)Integer.MIN_VALUE)return 0;
        }
        int rev =rev2.intValue();
        return rev * zn;
    }
}
