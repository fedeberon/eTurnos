package com.bolivarSoftware.eTurnos.dao.notificacion;

import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.dao.interfaces.INotificacionRepository;
import com.bolivarSoftware.eTurnos.domain.Notificacion;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Damian Gallego on 30/4/2019.
 */
@Repository
public class NotificacionRepository implements INotificacionRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Notificacion> findAll(){
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            return session.delegate().createQuery("from Notificaciones").list();

        }catch (HibernateException e){
            throw e;
        }
    }

    @Override
    public Notificacion save(Notificacion notificacion) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            session.delegate().saveOrUpdate(notificacion);
            tx.commit();
            return notificacion;
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }

    @Override
    public Notificacion delete(Notificacion id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(id);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public Notificacion update(Notificacion notificacion) {
        return null;
    }
}
