package com.exercises19;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**@author Алексей
 * @version 1 *
 * Public class Decrator for reading from file with decoding
 * Contains @Override for read method with on going decoding
 * @Field codeClass - Require class anotated as @Encription;
 * @Field code - String used as a key.
 */
public class InputDecoratorXor extends FilterInputStream {
    Class codeClass;
    String code;

    public InputDecoratorXor(InputStream in, Class codeClass, String code) {
        super(in);
        if (!codeClass.isAnnotationPresent(Encription.class))throw new IllegalArgumentException("codeClass must be annotated with @Encription class");
        this.codeClass = codeClass;
        this.code = code;
    }


    private boolean checkCodeclass(){
        return codeClass.isAnnotationPresent(Encription.class);
    }

    /**     *
     * @param b byte[] marked for reading data from file.
     * @return next byte of data, or -1 if the end of the stream is reached.
     * @throws IOException,
     */
    @Override
    public int read(byte[] b) throws IOException {

        int mark = in.read(b);
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
                    throw new IllegalArgumentException("The codeClass is not valid, the decode process failure");
                }
            }
        return mark;
    }
}
