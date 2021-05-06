package com.google.dao;

import com.google.model.Alien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class AlienDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Alien> getAliens() {
        // 通过 session 传递数据
        Session session = sessionFactory.getCurrentSession();
        List<Alien> alienList = session.createQuery("from Alien", Alien.class).list();

        return alienList;
    }

    @Transactional
    public void addAlien(Alien alien) {
        Session session = sessionFactory.getCurrentSession();
        session.save(alien);
    }

    @Transactional
    public Alien getAlien(int id) {
        Session session = sessionFactory.getCurrentSession();
        Alien alien = session.get(Alien.class, id);

        return alien;
    }
}
