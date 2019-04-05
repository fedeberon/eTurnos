package com.bolivarSoftware.eTurnos.dao.actividad;

/**
 * Created by Fede Beron on 4/7/2017.
 */

import com.bolivarSoftware.eTurnos.beans.Pagination;
import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.dao.interfaces.IActividadUsuarioRepository;
import com.bolivarSoftware.eTurnos.domain.ActividadUsuario;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ActividadUsuarioRepository implements IActividadUsuarioRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActividadUsuarioRepository.class);

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public ActividadUsuario save(ActividadUsuario actividadUsuario) {
        Transaction tx = null;
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            tx = session.delegate().getTransaction();
            tx.begin();
            session.delegate().save(actividadUsuario);
            tx.commit();
            return actividadUsuario;

        } catch (HibernateException e) {
            LOGGER.error("No se pudo guardar la activiadad.", e);
            tx.rollback();

            throw e;
        }
    }


    @Override
    public List<ActividadUsuario> findByUsuario(Usuario usuario, Integer pageNumber) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("from ActividadUsuario where usuario = :usuario order by momento desc");
            query.setParameter("usuario", usuario);
            query.setFirstResult((pageNumber - 1) * Pagination.MAX_PAGE);
            query.setMaxResults(Pagination.MAX_PAGE);

            return query.list();

        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la lista de actividades.", e);
            throw e;
        }
    }

    @Override
    public ActividadUsuario getUltimaActividad(Usuario usuario) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("from ActividadUsuario where usuario = :usuario order by momento desc");
            query.setParameter("usuario", usuario);
            query.setMaxResults(Pagination.ONE_ROW);

            return (ActividadUsuario) query.uniqueResult();

        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la ultima actividad del usuario {}.", new Object[] {usuario}, e);
            throw e;
        }
    }

    @Override
    public List<ActividadUsuario> findByUsuarioByMomento(Usuario usuario, LocalDateTime momento) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("from ActividadUsuario where usuario = :usuario and momento <> :momento order by momento asc");
            query.setParameter("usuario", usuario);
            query.setParameter("momento", momento);

            return query.list();

        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la actividad del usuario {} para el momento.", new Object[] {usuario, momento}, e);
            throw e;
        }
    }
}
