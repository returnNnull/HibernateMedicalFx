package com.example.medicalfx;

import com.example.medicalfx.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DbConnection {

    private final Session session;
    private static DbConnection INSTANCE;

    private DbConnection(){
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();

        }
        catch (Throwable ex){
            throw  new ExceptionInInitializerError(ex);
        }
    }

    public static DbConnection getInstance(){
        if (INSTANCE== null ){
            INSTANCE = new DbConnection();
        }
        return INSTANCE;
    }


    public <T> List<T> getAll(Class<?> clazz){
        String table = clazz.getSimpleName();

        return (List<T>) session.createQuery("select e from " + table + "  e ", clazz).getResultList();
    }


    public <T> T getById(int id,Class<?> clazz){
        String table = clazz.getSimpleName();
        return (T) session.get(clazz, id);
    }

    public User getByLogin(String login){
        return session.createQuery("from User where login = :login", User.class).setParameter("login", login).getSingleResultOrNull();
    }


    public void insert(Object obj){
        session.persist(obj);
        commit();
    }

    public <T> void update(T t){
        session.merge(t);
        commit();
    }

    public <T> void delete(T t){
        session.remove(t);
        commit();
    }

    public DbConnection close(){
        if (session != null)
            session.close();
        return this;
    }

    private DbConnection commit(){
        if (session != null){
            session.beginTransaction().commit();
        }
        return this;
    }
}
