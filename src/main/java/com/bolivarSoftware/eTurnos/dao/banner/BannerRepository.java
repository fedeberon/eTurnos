package com.bolivarSoftware.eTurnos.dao.banner;


import com.bolivarSoftware.eTurnos.beans.Pagination;
import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.dao.interfaces.IBannerRepository;
import com.bolivarSoftware.eTurnos.domain.Banner;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BannerRepository implements IBannerRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(BannerRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Banner> findAll(Integer pageNumber){
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("From Banner order by id desc");
            query.setFirstResult((pageNumber - 1) * Pagination.MAX_PAGE);
            query.setMaxResults(Pagination.MAX_PAGE);

            return query.list();
        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la lista de Banners.", e);
            throw e;
        }
    }

    @Override
    public Banner save(Banner banner){
        Transaction tx = null;
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            tx = session.delegate().getTransaction();
            tx.begin();
            session.delegate().saveOrUpdate(banner);
            tx.commit();

            return banner;
        } catch (HibernateException e) {
            LOGGER.error("No se pudo guardar el Banner.", e);
            tx.rollback();

            throw e;
        }
    }

    @Override
    public List<Banner> buscar(String valor) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Criteria criteria = session.delegate().createCriteria(Banner.class);

            try{
                Long id = Long.parseLong(valor);
                criteria.add(Restrictions.or(Restrictions.ilike("nombre", valor, MatchMode.ANYWHERE), Restrictions.or(Restrictions.ilike("url", valor, MatchMode.ANYWHERE), Restrictions.eq("id", id))));
            }
            catch (NumberFormatException e){
                criteria.add(Restrictions.or(Restrictions.ilike("nombre", valor, MatchMode.ANYWHERE), Restrictions.ilike("url", valor, MatchMode.ANYWHERE)));
            }

            return criteria.list();

        } catch (HibernateException e) {
            LOGGER.error("No se pudo buscar los banners.", e);
            throw e;
        }
    }

    @Override
    public Banner get(Long id) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            return (Banner) session.delegate().get(Banner.class, id);

        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener el Banner.", e);
            throw e;
        }
    }

    @Override
    public List<Banner> obtenerBannerAPublicar() {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query  query = session.delegate().createQuery("from Banner where publicar = :publicado");
            query.setBoolean("publicado", Banner.PUBLICAR);

            return query.list();

        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la lista de Banners a publicar.", e);
            throw e;
        }
    }

}
