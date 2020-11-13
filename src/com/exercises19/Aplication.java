package com.exercises19;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class Aplication {
    public static void main(String[] args) {
        File file = new File("resources/fileWithData.txt");
        String baseString= "Lo in the orient when the gracious light\n" +
                "Lifts up his burning head, each under eye\n" +
                "Doth homage to his new-appearing sight,\n" +
                "Serving with looks his sacred majesty,\n" +
                "And having climbed the steep-up heavenly hill,\n" +
                "Resembling strong youth in his middle age,\n" +
                "Yet mortal looks adore his beauty still,\n" +
                "Attending on his golden pilgrimage:\n" +
                "But when from highmost pitch with weary car,\n" +
                "Like feeble age he reeleth from the day,\n" +
                "The eyes (fore duteous) now converted are\n" +
                "From his low tract and look another way:\n" +
                "So thou, thy self out-going in thy noon:\n" +
                "Unlooked on diest unless thou get a son.";
        String key = "12345";
        writeToTextWithEncription(file,false,baseString,XorCoder.class,key);
        System.out.println(readFromFileWithEncr(file,XorCoder.class,key));
        System.out.println("The string is identical to base: "+ baseString.equals(readFromFileWithEncr(file,XorCoder.class,key)));






    }
    private static void writeToTextWithEncription(File file, boolean append ,String baseString, Class codeClass, String key){
        try(OutPutDecorator dec1 = new OutPutDecorator(new FileOutputStream(file,append),codeClass,key)) {
            dec1.write(baseString.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static  String readFromFileWithEncr(File file, Class codeClass, String key){
        String res = null;
        try(InputDecoratorXor inputDecoratorXor = new InputDecoratorXor(new FileInputStream(file),XorCoder.class,key);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream()
        ) {
            byte[] bytes = new byte[100];
            int data;
            while ((data=inputDecoratorXor.read(bytes))!=-1){
             byteArray.write(bytes,0,data);
            }

            res = new String(byteArray.toByteArray());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

}
