package com.Microblog.microblog.utils;

import java.util.Base64;

public class ImageUtil {
    public static String convertToBase64(byte[] imageBytes) {
        return Base64.getEncoder().encodeToString(imageBytes);
    }

}
