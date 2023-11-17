package org.example.Filters;

import org.example.Servlets.AuthContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebFilter(urlPatterns = { "/api"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        AuthContext authContext = AuthContext.getInstance();
        String host = servletRequest.getRemoteHost();
        Optional<Cookie> authData
                = authContext.getCookies().stream().filter(cookie -> cookie.getName().equals(host)).findAny();
        if (!authData.isEmpty()) {
            return;
        }
        else {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.sendRedirect("/login.jsp");
            httpResponse.sendRedirect("http://localhost:8080/JspApi_war/auth");
        }
    }
}
