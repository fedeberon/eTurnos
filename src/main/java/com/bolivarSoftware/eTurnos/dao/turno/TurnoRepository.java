package com.bolivarSoftware.eTurnos.dao.turno;


import com.bolivarSoftware.eTurnos.beans.Pagination;
import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.dao.interfaces.ITurnoRepository;
import com.bolivarSoftware.eTurnos.domain.*;
import com.bolivarSoftware.eTurnos.utils.UtilDate;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class TurnoRepository implements ITurnoRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(TurnoRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Turno> findAll(Integer pageNumber){
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("From Turno order by id desc");
            query.setFirstResult((pageNumber - 1) * Pagination.MAX_PAGE);
            query.setMaxResults(Pagination.MAX_PAGE);

            return query.list();
        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la lista de Turnos.", e);
            throw e;
        }
    }


    @Override
    public List<Turno> findAll(){
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("From Turno order by id desc");

            return query.list();
        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la lista de Turnos.", e);
            throw e;
        }
    }

    @Override
    public List<Turno> findByCreador(Usuario creador){
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("from Turno where creador = :creador ");
            query.setParameter("creador", creador);

            return query.list();
        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la lista de Turnos para el Usuario: {}", new Object[] { creador }, e);
            throw e;
        }
    }

    @Override
    public List<Turno> findByPuestoDeAtencion(PuestoDeAtencion puestoDeAtencion) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("from Turno where puesto = :puestoDeAtencion");
            query.setParameter("puestoDeAtencion", puestoDeAtencion);

            return query.list();
        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la lista de Turnos para el Puesto de Atencion: {}", new Object[] { puestoDeAtencion }, e);
            throw e;
        }
    }

    @Override
    public Turno get(Long id){
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            return (Turno) session.delegate().get(Turno.class, id);

        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener el Turnos.", e);
            throw e;
        }
    }

    @Override
    public TurnoOrdenado obtenerProximoTurno() {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("from TurnoOrdenado where estado = :estado order by orden asc");
            query.setParameter("estado", EstadoTurnoEnum.EN_ESPERA);
            query.setMaxResults(1);

            return (TurnoOrdenado) query.uniqueResult();

        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener el Turnos.", e);
            throw e;
        }
    }

    @Override
    public TurnoOrdenado save(TurnoOrdenado turnoOrdenado) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("update TurnoOrdenado set estado = :estado , fecha =:fecha where IdTurno = :idTurno and orden =:orden");
            query.setDate("fecha", turnoOrdenado.getFecha());
            query.setParameter("estado", turnoOrdenado.getEstado());
            query.setLong("idTurno", turnoOrdenado.getIdTurno());
            query.setInteger("orden", turnoOrdenado.getOrden());
            query.executeUpdate();

            return turnoOrdenado;
        } catch (HibernateException e) {
            LOGGER.error("No se pudo guardar el turno ordenado.", e);
            throw e;
        }
    }

    @Override
    public Turno save(Turno turno) {
        Transaction tx = null;
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            tx = session.delegate().getTransaction();
            tx.begin();
            session.delegate().saveOrUpdate(turno);
            tx.commit();

            return turno;
        } catch (HibernateException e) {
            LOGGER.error("No se pudo guardar el turno.", e);
            tx.rollback();
            throw e;
        }
    }

    @Override
    public void deleteTurnoOrdenado(Long id) {
        Transaction tx = null;
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            tx = session.delegate().getTransaction();
            tx.begin();
            TurnoOrdenado turnoOrdenado = (TurnoOrdenado) session.delegate().get(TurnoOrdenado.class, id);
            session.delegate().delete(turnoOrdenado);
            tx.commit();
        } catch (HibernateException e) {
            LOGGER.error("No se pudo eliminar el turno.", e);
            tx.rollback();
            throw e;
        }
    }

    @Override
    public List<TurnoOrdenado> getTurnosOrdenados() {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("from TurnoOrdenado order by orden asc");

            return query.list();

        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener el la lista de Turnos Ordenados.", e);
            throw e;
        }
    }

    @Override
    public Long getCantidadTurnosPorAtender() {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("select count(*) from TurnoOrdenado where estado = :estado");
            query.setParameter("estado", EstadoTurnoEnum.EN_ESPERA);

            return (Long) query.uniqueResult();

        } catch (HibernateException e) {
            LOGGER.error("No se pudo contar la cantidad de Turnos Ordenados en espera.", e);
            throw e;
        }
    }

    @Override
    public TurnoOrdenado getTurnoOrdenado(Long id) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            return (TurnoOrdenado) session.delegate().get(TurnoOrdenado.class, id);

        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener el Turnos Ordenado.", e);
            throw e;
        }
    }

    @Override
    public List<TurnoOrdenado> getTurnosPendienteDePuesto(PuestoDeAtencion puestoDeAtencion) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("from TurnoOrdenado where turno.puesto = :puesto and estado = :estado");
            query.setParameter("estado", EstadoTurnoEnum.LLAMANDO);
            query.setParameter("puesto", puestoDeAtencion);

            return query.list();

        } catch (HibernateException e) {
            LOGGER.error("No se pudo la lista de Turnos pendientes para el puesto {}.", new Object[]{puestoDeAtencion},  e);
            throw e;
        }
    }

    @Override
    public List<Turno> obtenerTurnoPorFecha(Date fechaInicio, Date fechaFin) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("from Turno where fechaSolicitado between :fechaInicio and :fechaFin order by fechaSolicitado asc");
            query.setTimestamp("fechaInicio", fechaInicio);
            query.setTimestamp("fechaFin", UtilDate.setTime(fechaFin, 23, 59, 00, 00));

            return query.list();

        } catch (HibernateException e) {
            LOGGER.error("No se pudo la lista de Turnos por fecha.", e);
            throw e;
        }
    }

    @Override
    public List<Turno> buscar(String valor, Date desde, Date hasta) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Criteria criteria = session.delegate().createCriteria(Turno.class);
            if(desde != null || hasta != null){
                criteria.add(Restrictions.between("fechaSolicitado", desde, hasta));
            }

            if(!valor.isEmpty()){
                try{
                    Long id = Long.parseLong(valor);
                    criteria.add(Restrictions.or(Restrictions.ilike("numeroTicket", valor, MatchMode.ANYWHERE), Restrictions.or(Restrictions.sqlRestriction("TUR_ESTADO LIKE ?", "%"+valor.toLowerCase()+"%", StandardBasicTypes.STRING), Restrictions.eq("id", id))));
                }
                catch (NumberFormatException e){
                    criteria.add(Restrictions.or(Restrictions.ilike("numeroTicket", valor, MatchMode.ANYWHERE), Restrictions.sqlRestriction("TUR_ESTADO LIKE ?", "%"+valor.toLowerCase()+"%",  StandardBasicTypes.STRING)));
                }
            }
            return criteria.list();

        } catch (HibernateException e) {
            LOGGER.error("No se pudo buscar la lista de Turnos.", e);
            throw e;
        }
    }

    @Override
    public List<Turno> getTurnosCartel() {

        Date today = new Date();
        Date todayMorning = DateUtils.truncate(today, Calendar.DATE);

        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("from Turno t where t.fechaLlamado >  :today  order by t.fechaLlamado desc");
            query.setParameter("today",todayMorning);
            query.setFirstResult(0);
            query.setMaxResults(5);
            return query.list();

        } catch (HibernateException e) {
            LOGGER.error("No se pudo la lista de Turnos llamados",  e);
            throw e;
        }
    }
}