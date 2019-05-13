package com.bolivarSoftware.eTurnos.dao.notificacionSocio;

import com.bolivarSoftware.eTurnos.beans.Pagination;
import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.dao.interfaces.INotificacionSocioRepository;
import com.bolivarSoftware.eTurnos.domain.Notificacion;
import com.bolivarSoftware.eTurnos.domain.NotificacionSocio;
import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Damian Gallego on 8/5/2019.
 */
@Repository
public class NotificacionSocioRepository implements INotificacionSocioRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificacionSocioRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

        @Override
        public List<NotificacionSocio> findAllPageable(Integer pageNumber){
            try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
                Query query = session.delegate().createQuery("From  NotificacionSocio order by id desc");
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
    public NotificacionSocio save(NotificacionSocio notificacionSocio) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            session.delegate().saveOrUpdate(notificacionSocio);
            tx.commit();
            return notificacionSocio;
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }

    @Override
    public NotificacionSocio get(Integer id)
    {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            NotificacionSocio notificacionSocio = (NotificacionSocio) session.get(Notificacion.class, id);
            return notificacionSocio;
        }
        catch (HibernateException e) {
            throw e;
        }
        finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }

    @Override
    public List<NotificacionSocio> getBySocio(Integer idSocio) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery("From  NotificacionSocio where socio.id = ? order by id desc");
            query.setInteger(0 , idSocio);
            return query.list();
        }
        catch (HibernateException e){
            LOGGER.error("No se pudo obtener la lista de Usuarios.",  e);
            throw e;
        }
    }

    @Override
    public List<NotificacionSocio> save(List<NotificacionSocio> notificacionesSocios) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            notificacionesSocios.forEach(notificacion -> session.delegate().save(notificacion));
            tx.commit();

            return notificacionesSocios;
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }


}
