package com.bolivarSoftware.eTurnos.dao.notificacion;

import com.bolivarSoftware.eTurnos.beans.Pagination;
import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.dao.interfaces.INotificacionRepository;
import com.bolivarSoftware.eTurnos.dao.usuario.UsuarioRepository;
import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Damian Gallego on 30/4/2019.
 */
@Repository
public class NotificacionRepository implements INotificacionRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificacionRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Notificacion> findAllPageable(Integer pageNumber){
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery("From  Notifiacion");
            query.setFirstResult((pageNumber - 1) * Pagination.MAX_PAGE);
            query.setMaxResults(Pagination.MAX_PAGE);
            return query.list();
        }
        catch (HibernateException e){
            LOGGER.error("No se pudo obtener la lista de Usuarios.",  e);
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
    public Notificacion get(String id){
        if(id.equals("0")) return new Notificacion();
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery("from Notificacion where username = :id");
            query.setString("id", id);

            return (Notificacion) query.uniqueResult();
        }
        catch (HibernateException e){
            LOGGER.error("No se pudo obtener el Usuario con id {}.", id, e);
            throw e;
        }
    }
}
