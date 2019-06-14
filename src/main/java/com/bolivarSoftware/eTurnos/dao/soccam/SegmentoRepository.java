package com.bolivarSoftware.eTurnos.dao.soccam;

import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.dao.soccam.interfaces.ISegmentoRepository;
import com.bolivarSoftware.eTurnos.domainSoccam.Segmento;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by federicoberon on 13/06/2019.
 */

@Repository
public class SegmentoRepository implements ISegmentoRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(SegmentoRepository.class);

    @Autowired
    @Qualifier("sessionFactorySoccam")
    private SessionFactory sessionFactory;


    @Override
    public List<Segmento> findAll(){
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("From Segmento");

            return query.list();
        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la lista de Segmentos.", e);
            throw e;
        }
    }

}
