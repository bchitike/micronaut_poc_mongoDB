package com.vertex.util;

public class AppUtil {

    public static Boolean isVoid(String string) {
        return (string == null) || (string.length() == 0) ;
    }

    public static Boolean isVoid(Object object){
        return object == null;
    }

}
