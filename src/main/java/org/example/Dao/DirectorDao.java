package org.example.Dao;

import org.example.Models.Actor;
import org.example.Models.Director;
import org.example.Models.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DirectorDao {
    private final SessionFactory factory;
    public DirectorDao() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(Actor.class);
        factory = configuration.buildSessionFactory();
    }
    public int create(Director director){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(director);
            session.getTransaction().commit();
            return director.getId();
        }
    }
    public Director getDirector(int id)
    {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Director director = session.get(Director.class, id);
            session.getTransaction().commit();
            return director;
        }
    }
    public List<Director> getDirectors() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Director> directors =  session.createQuery("from Director", Director.class)
                    .list();
            session.getTransaction().commit();
            return directors;
        }
    }
}
