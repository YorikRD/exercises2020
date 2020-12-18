package com.exam03.strategy;

/**
 * The enum is wrapen to the class just to allow other strategies to extend it
 */
public class StrClass implements IStrategy {
    /**
     * The enum containing the links logic
     */
    public enum InStrategy {
        NODE0(Flaff.txt0, new int[]{1,2}),
        NODE1(Flaff.txt1, new int[]{}), //1 Victory
        NODE2(Flaff.txt2, new int[]{3,4}),
        NODE3(Flaff.txt3, new int[]{5,6}),
        NODE4(Flaff.txt4, new int[]{}), // Defeat
        NODE5(Flaff.txt5, new int[]{7,4}),
        NODE6(Flaff.txt6, new int[]{1,4}),
        NODE7(Flaff.txt7, new int[]{4,8}),
        NODE8(Flaff.txt8, new int[]{9,10}),
        NODE9(Flaff.txt9, new int[]{11,12}),
        NODE10(Flaff.txt10, new int[]{}), // Defeat
        NODE11(Flaff.txt11, new int[]{}), // Defeat
        NODE12(Flaff.txt12, new int[]{4,1}),
        ;

        private String text;
        private int[] links;

        InStrategy(String text, int[] links) {
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

    /**
     *
     * @param choice player answer generated via exemplars of @ForestGameAction class #of the called Node
     * @return text from Fluff class linked to the StrClass
     */
    public String getTxt(int choice){
        return InStrategy.values()[choice].getText();
    }

    /**
     *
     * @param choice e player answer generated via exemplars of @ForestGameAction class #of the called Node
     * @return int[] of nodes linked to the called choice
     */
    public int[] getLinks(int choice){
        return InStrategy.values()[choice].getLinks();
    }
}
