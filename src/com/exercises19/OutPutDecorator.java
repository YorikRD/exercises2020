package com.exercises19;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**@author Алексей
 * @version 1 *
 * Public class Decrator for writing to file with encoding
 * Contains @Override for read method with on going decoding
 * @Field codeClass - Require class anotated as @Encription;
 * @Field code - String used as a key.
 */
public class OutPutDecorator extends FilterOutputStream {
    Class<XorCoder> codeClass;
    String code;


    public OutPutDecorator(OutputStream out, Class<XorCoder> codeClass, String code) {
        super(out);
        if (!codeClass.isAnnotationPresent(Encription.class))throw new IllegalArgumentException("codeClass must be annotated with @Encription class");
        this.codeClass = codeClass;
        this.code = code;
    }
    private boolean checkCodeclass(){
        return codeClass.isAnnotationPresent(Encription.class);
    }

    /**
     *
     * @param b byte[] marked for writing to the file
     * @throws IOException
     * data is encripted via methods of codeClass
     */
    @Override
    public void write(byte[] b) throws IOException {
        Method method = null;
        if (checkCodeclass()) {
            Method[] methods = codeClass.getMethods();
            for (Method method1 : methods) {
                if (method1.isAnnotationPresent(VoidDecoderEncoder.class)){
                    method = method1;}
            }
            try {
                method.invoke(null,b,code);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                throw new IllegalArgumentException("The codeClass is not valid, the encode process failure, date have been written without it");
            }
        }
        super.write(b);
    }

}
