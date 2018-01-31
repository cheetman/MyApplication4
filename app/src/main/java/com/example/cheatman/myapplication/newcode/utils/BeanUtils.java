package com.example.cheatman.myapplication.newcode.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Cheatman on 2018/1/30.
 */

public final class BeanUtils {
    @SuppressWarnings("unchecked")
    public static <T> T Copy(T src) throws RuntimeException {
        ByteArrayOutputStream memoryBuffer = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        T dist = null;
        try {
            out = new ObjectOutputStream(memoryBuffer);
            out.writeObject(src);
            out.flush();
            in = new ObjectInputStream(new ByteArrayInputStream(memoryBuffer.toByteArray()));
            dist = (T) in.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            CloseUtils.closeIOQuietly(out,in);
        }
        return dist;
    }
}
