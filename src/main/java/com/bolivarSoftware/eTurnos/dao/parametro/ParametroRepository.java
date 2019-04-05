package com.bolivarSoftware.eTurnos.dao.parametro;

import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.dao.banner.BannerRepository;
import com.bolivarSoftware.eTurnos.dao.interfaces.IParametroRepository;
import com.bolivarSoftware.eTurnos.domain.parametro.Parametro;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Fede Beron on 17/7/2017.
 */
@Repository
public class ParametroRepository implements IParametroRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(BannerRepository.class);

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Parametro save(Parametro parametro){
        Transaction tx = null;
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            tx = session.delegate().getTransaction();
            tx.begin();
            session.delegate().saveOrUpdate(parametro);
            tx.commit();

            return parametro;
        } catch (HibernateException e) {
            LOGGER.error("No se pudo guardar el Parametro.", e);
            tx.rollback();

            throw e;
        }
    }

    @Override
    public Parametro get(Integer id) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            return (Parametro) session.delegate().get(Parametro.class, id);

        } catch (HibernateException e) {
            LOGGER.error("No se pudo guardar el Parametro.", e);
            throw e;
        }
    }
}
