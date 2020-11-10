package com.exercises19;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Aplication {
    public static void main(String[] args) {
        File file = new File("resources/fileWithData.txt");
        String ahahaha= "This fucking! method works";
        String key = "12345";
        try(OutPutDecorator dec1 = new OutPutDecorator(new FileOutputStream(file,false),XorCoder.class,key)) {
            dec1.write(ahahaha.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String res = null;

        try(InputDecoratorXor inputDecoratorXor = new InputDecoratorXor(new FileInputStream(file),XorCoder.class,key);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
        ) {
            byte[] bytes = new byte[ahahaha.length()];
            inputDecoratorXor.read(bytes);
            res = new String(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(res+" Input");

//

    }
    private static String readFromFile(File file, String code) throws IOException {
        String res = null;
        try (InputDecoratorXor inputDecoratorXor = new InputDecoratorXor(new FileInputStream(file),XorCoder.class,code);
//        BufferedInputStream buffer = new BufferedInputStream(inputStream);
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ) {
            byte[] bytes = new byte[300];
            int data;
            //read returns nomber of readen bytes, or -1 if there is nothing to read
            while ((data = inputDecoratorXor.read(bytes)) != -1) {
                byteArray.write(bytes, 0, data);
            }
            res = new String(byteArray.toByteArray());
        }
        return res;

    }
    private static String readFromFile2(File file) throws IOException{
        String res =  null;
        try(FileInputStream inputStream=new FileInputStream(file);
//        BufferedInputStream buffer = new BufferedInputStream(inputStream);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ) {
            byte[] bytes  = new byte[300];
            int data;
            //read returns nomber of readen bytes, or -1 if there is nothing to read
            while ((data = inputStream.read(bytes))!=-1){
                byteArray.write(bytes,0,data);
            }
            res = new String(XorCoder.decode(byteArray.toByteArray(),"12345"));
        }
        return res;
        // the method read from inputsteram reads data to some structure i.e byte[}
    }

}
