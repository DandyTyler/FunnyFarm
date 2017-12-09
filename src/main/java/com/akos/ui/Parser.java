package com.akos.ui;

/**
 * Парсит строку в примитивные типы
 */
public class Parser {
    public static Object parse(String str, Class cls) {
        if (cls.equals(int.class) || cls.equals(Integer.class)) {
            return Integer.parseInt(str);
        }
        if (cls.equals(double.class) || cls.equals(Double.class)) {
            return Double.parseDouble(str);
        }
        if (cls.equals(float.class) || cls.equals(Float.class)) {
            return Integer.parseInt(str);
        }
        if (cls.equals(short.class) || cls.equals(Short.class)) {
            return Short.parseShort(str);
        }
        if (cls.equals(long.class) || cls.equals(Long.class)) {
            return Long.parseLong(str);
        }
        if (cls.equals(byte.class) || cls.equals(Byte.class)) {
            return Byte.parseByte(str);
        }
        if (cls.equals(String.class)) {
            return str;
        }
        throw new IllegalArgumentException("This type not supported");
    }
}
