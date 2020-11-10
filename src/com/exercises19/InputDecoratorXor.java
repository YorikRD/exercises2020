package com.exercises19;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputDecoratorXor extends FilterInputStream {
    Class codeClass;
    String code;

    public InputDecoratorXor(InputStream in, Class codeClass, String code) {
        super(in);
        this.codeClass = codeClass;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private boolean checkCodeclass(){
        return codeClass.isAnnotationPresent(Encription.class);
    }

    @Override
    public int read(byte[] b) throws IOException {
        byte[] a = new byte[b.length];
        int mark = in.read(a);
        b=XorCoder.decode(a,code);

//        Method decode = null;
//        if (checkCodeclass())  {
//            System.out.println(" checl succesfull");
//            try {
//                decode = codeClass.getDeclaredMethod("decode", Array.class,String.class);
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            }
//            try {
//                decode.invoke(b,code);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//           b = XorCoder.decode(b,code);
//
//        }


        return mark;
    }
}
