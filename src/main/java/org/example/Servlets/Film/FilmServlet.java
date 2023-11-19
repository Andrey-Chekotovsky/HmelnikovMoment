package org.example.Servlets.Film;

import org.example.Constants.WebConstants;
import org.example.Dao.FilmDao;
import org.example.Models.Film;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.StringTokenizer;

@WebServlet(urlPatterns = { WebConstants.prefix + "/film/*"})
public class FilmServlet extends HttpServlet {
    private FilmDao filmDao = new FilmDao();
    @Override
    public void init() throws ServletException {
        super.init();
        log("init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/static/Films/Film.jsp");
        String id = WebConstants.getUriId(req.getRequestURI());
        Film film = filmDao.getFilm(Integer.parseInt(id));
        log(id);
        req.setAttribute("film", film);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = WebConstants.getUriId(req.getRequestURL().toString());
        System.out.println("Film id " + id);
        filmDao.delete(Integer.parseInt(id));

        resp.sendRedirect("http://localhost:8080/JspApi_war" +WebConstants.prefix + "/films" );
    }
    @Override
    public void destroy() {
        super.destroy();
    }
}
