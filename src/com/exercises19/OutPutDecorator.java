package com.exercises19;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutPutDecorator extends FilterOutputStream {
    Class codeClass;
    String code;

    public OutPutDecorator(OutputStream out, Class codeClass, String code) {
        super(out);
        this.codeClass = codeClass;
        this.code = code;
    }

    @Override
    public void write(byte[] b) throws IOException {
        b = XorCoder.encode(b,code);
        super.write(b);
    }
}
