package com.common.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 加密工具类
 * @Author: rosh
 */
public final class EncryptUtil {

    private EncryptUtil() {

    }

    private static final Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    public static String encodeBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] decodeBase64(String str) {

        return Base64.getDecoder().decode(str);
    }

    public static String encodeUTF8StringBase64(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String decodeUTF8StringBase64(String str) {
        byte[] bytes = Base64.getDecoder().decode(str);
        return  new String(bytes, StandardCharsets.UTF_8);
    }

    public static String encodeURL(String url) {
        String encoded = null;
        try {
            encoded = URLEncoder.encode(url, String.valueOf(StandardCharsets.UTF_8));
        } catch (UnsupportedEncodingException e) {
            logger.warn("URLEncode失败", e);
        }
        return encoded;
    }


    public static String decodeURL(String url) {
        String decoded = null;
        try {
            decoded = URLDecoder.decode(url, String.valueOf(StandardCharsets.UTF_8));
        } catch (UnsupportedEncodingException e) {
            logger.warn("URLDecode失败", e);
        }
        return decoded;
    }

}
