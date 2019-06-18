package com.bolivarSoftware.eTurnos.dao.soccam;

import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.dao.soccam.interfaces.ISocioSoccamRepository;
import com.bolivarSoftware.eTurnos.domainSoccam.Rubro;
import com.bolivarSoftware.eTurnos.domainSoccam.SocioSoccam;
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
 * Created by federicoberon on 17/06/2019.
 */
@Repository
public class SocioSoccamRepository implements ISocioSoccamRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocioSoccamRepository.class);

    @Autowired
    @Qualifier("sessionFactorySoccam")
    private SessionFactory sessionFactory;


    @Override
    public List<SocioSoccam> findByRubro(Rubro rubro){
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("From SocioSoccam where rubro = :rubro");
            query.setParameter("rubro" , rubro);
            return query.list();
        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la lista de Socios de Soccam.", e);
            throw e;
        }
    }

}
