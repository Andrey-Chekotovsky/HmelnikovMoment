package org.example.Constants;

import java.util.StringTokenizer;

public class WebConstants {
    static final public String prefix = "/api";
    static final public String cookie = "au";
//    public static String Prefix() {
//        try {
//            return prefix.clone();
//        }
//        catch (CloneNotSupportedException excp) {
//
//        }
//    }
    static public String getUriId(String url) {
        StringTokenizer tokenizer = new StringTokenizer(url, "/");
        String id = "";
        for(int i = tokenizer.countTokens(); i > 0; i--) {
            id = tokenizer.nextToken();
        }
        return id;
    }
}
