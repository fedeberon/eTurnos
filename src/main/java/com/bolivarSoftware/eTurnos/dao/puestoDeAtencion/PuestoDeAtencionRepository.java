package com.bolivarSoftware.eTurnos.dao.puestoDeAtencion;


import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.dao.interfaces.IPuestoDeAtencionRepository;
import com.bolivarSoftware.eTurnos.domain.EstadoPuestoDeAtencionEnum;
import com.bolivarSoftware.eTurnos.domain.PuestoDeAtencion;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.utils.Assert;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.NotYetImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class PuestoDeAtencionRepository implements IPuestoDeAtencionRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(PuestoDeAtencion.class);

    private final SessionFactory sessionFactory;

    @Autowired
    public PuestoDeAtencionRepository(SessionFactory sessionFactory) {
        this.sessionFactory = Assert.notNull(sessionFactory, "sessionFactory");
    }

    @Override
    public List<PuestoDeAtencion> getPuestosDeAtencionDisponibles(){
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery("from PuestoDeAtencion where estado = :estado");
            query.setParameter("estado" , EstadoPuestoDeAtencionEnum.DISPONIBLE);

            return query.list();
        }catch (HibernateException e){
            LOGGER.error("No se pudo obtener la lista de Puestos de Atencion disponibles.",  e);
            throw e;
        }
    }

    @Override
    public List<PuestoDeAtencion> findAll(){
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            return session.delegate().createQuery("from PuestoDeAtencion").list();

        }catch (HibernateException e){
            LOGGER.error("No se pudo obtener la lista de Puestos de Atencion.",  e);
            throw e;
        }
    }

    @Override
    public PuestoDeAtencion getPorUsuarioAsignado(Usuario usuario) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery("from PuestoDeAtencion where usuarioAsiganado.id = :usuario");
            query.setParameter("usuario" , usuario.getId());

            return (PuestoDeAtencion) query.uniqueResult();
        }catch (HibernateException e){
            LOGGER.error("No se pudo obtener el usuario Asignado al Puestos de Atencion.",  e);
            throw e;
        }
    }

    @Override
    public void actualizarPuestoDeAtencion(PuestoDeAtencion puestoDeAtencion) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().beginTransaction();
            session.delegate().saveOrUpdate(puestoDeAtencion);
            tx.commit();
        }catch (HibernateException e){
            LOGGER.error("No se pudo asignar el puesto de atencion al usuario: {} .", new Object[]{puestoDeAtencion.getUsuarioAsiganado()}, e);
            tx.rollback();
            throw e;
        }
    }

    @Override
    public boolean tienePuestoAsignado(Usuario usuario) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("select count(*) from PuestoDeAtencion where estado = :estado and usuarioAsiganado = :usuario");
            query.setParameter("estado" , EstadoPuestoDeAtencionEnum.NO_DISPONIBLE);
            query.setParameter("usuario" , usuario);
            int result = ((Number) query.uniqueResult()).intValue();

            return result > 0 ;


        } catch (HibernateException e) {
            LOGGER.error("No se pudo verificar si el usuario {} tiene puesto asignado.", new Object[]{usuario},  e);
            throw e;
        }
    }

    @Override
    public PuestoDeAtencion get(Long id) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            return (PuestoDeAtencion) session.delegate().get(PuestoDeAtencion.class,  id);
        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener el usuario con id {}.", new Object[]{id},  e);
            throw e;
        }
    }
}