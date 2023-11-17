package org.example.Servlets;

import lombok.Data;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

@Data
public class AuthContext {
    private static AuthContext INSTANCE = new AuthContext();
    private List<Cookie> cookies = new ArrayList<>();

    public static AuthContext getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new AuthContext();
        }

        return INSTANCE;
    }
}
