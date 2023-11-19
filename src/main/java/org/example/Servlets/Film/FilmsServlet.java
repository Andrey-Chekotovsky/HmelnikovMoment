package org.example.Servlets.Film;

import org.example.Constants.WebConstants;
import org.example.Dao.ActorDao;
import org.example.Dao.DirectorDao;
import org.example.Dao.FilmDao;
import org.example.Models.Director;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { WebConstants.prefix + "/films"})
public class FilmsServlet extends HttpServlet {
    private FilmDao filmDao = new FilmDao();
    private ActorDao actorDao = new ActorDao();
    private DirectorDao directorDao = new DirectorDao();
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
        RequestDispatcher dispatcher = req.getRequestDispatcher("/static/Films/Films.jsp");
        req.setAttribute("films", filmDao.getFilms());
        dispatcher.forward(req, resp);

    }



    @Override
    public void destroy() {
        super.destroy();
    }
}
