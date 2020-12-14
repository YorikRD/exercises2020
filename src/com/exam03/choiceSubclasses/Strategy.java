package com.exam03.choiceSubclasses;

import com.exam03.choiceSubclasses.auxilary.Flaff;

public enum Strategy {
    NODE0(Flaff.txt0, new int[]{1,2}), //0
    NODE1(Flaff.txt1, new int[]{-1,-1}), //1 Victory
    NODE2(Flaff.txt2, new int[]{3,4}), //2
    NODE3(Flaff.txt3, new int[]{5,6}), //3
    NODE4(Flaff.txt4, new int[]{-2,-2}), //4
    NODE5(Flaff.txt5, new int[]{7,4}), //4
    NODE6(Flaff.txt6, new int[]{1,4}), //4
    NODE7(Flaff.txt7, new int[]{4,8}), //4
    NODE8(Flaff.txt8, new int[]{9,10}), //4
    NODE9(Flaff.txt9, new int[]{11,12}), //4
    NODE10(Flaff.txt10, new int[]{-2,-2}), //4
    NODE11(Flaff.txt11, new int[]{-2,-2}), //4
    NODE12(Flaff.txt12, new int[]{4,1}), //4
    ;

    private String text;
    private int[] links;

    Strategy(String text, int[] links) {
        this.text = text;
        this.links = links;
    }

    public String getText() {
        return text;
    }

    public int[] getLinks() {
        return links;
    }
}
