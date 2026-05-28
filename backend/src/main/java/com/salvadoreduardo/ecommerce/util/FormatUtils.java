package com.salvadoreduardo.ecommerce.util;

public class FormatUtils {
    public static String normalizeStringToNumber(String str) {
        if (str == null) return null;
        return str.replaceAll("\\D", "");
    }
}