package com.bolivarSoftware.eTurnos.dao.usuario;

import com.bolivarSoftware.eTurnos.beans.Pagination;
import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.dao.interfaces.IUsuarioRepository;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository implements IUsuarioRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Usuario get(String id){
        if(id.equals("0")) return new Usuario();
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery("from Usuario where username = :id");
            query.setString("id", id);

            return (Usuario) query.uniqueResult();
        }
        catch (HibernateException e){
            LOGGER.error("No se pudo obtener el Usuario con id {}.", id, e);
            throw e;
        }
    }


    @Override
    public Usuario get(Long id){
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery("from Usuario where id = :id");
            query.setLong("id", id);

            return (Usuario) query.uniqueResult();
        }
        catch (HibernateException e){
            LOGGER.error("No se pudo obtener el Usuario con id {}.", id, e);
            throw e;
        }
    }

    @Override
    public List<Usuario> findAllPageable(Integer pageNumber){
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery("From Usuario");
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
    public Usuario save(Usuario usuario){
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            session.delegate().saveOrUpdate(usuario);
            tx.commit();
            return usuario;
        }
        catch (HibernateException e){
            tx.rollback();
            LOGGER.error("No se pudo guardar el Usuario.", e);
            throw e;
        }
    }

}
