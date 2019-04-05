package com.bolivarSoftware.eTurnos.dao.rol;

import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.dao.rol.interfaces.IRolRepository;
import com.bolivarSoftware.eTurnos.domain.Rol;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Fede Beron on 4/7/2017.
 */
@Repository
public class RolRepository implements IRolRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(RolRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Rol> findAll(){
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("From Rol");

            return query.list();
        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la lista de Roles.", e);
            throw e;
        }
    }

}
