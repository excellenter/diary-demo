package personal.tool;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String md5(String str) {
        String newStr = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base = new BASE64Encoder();
            newStr = base.encode(md5.digest(str.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        return newStr;
    }
}
