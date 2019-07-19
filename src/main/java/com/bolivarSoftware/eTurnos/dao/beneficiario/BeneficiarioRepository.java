package com.bolivarSoftware.eTurnos.dao.beneficiario;

import com.bolivarSoftware.eTurnos.beans.Pagination;
import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.dao.interfaces.IBeneficiarioRepository;
import com.bolivarSoftware.eTurnos.domain.Beneficiario;
import com.bolivarSoftware.eTurnos.domain.socio.Socio;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Damian Gallego on 10/7/2019.
 */
@Repository
public class BeneficiarioRepository implements IBeneficiarioRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger LOGGER = LoggerFactory.getLogger(Beneficiario.class);

    @Override
    public Beneficiario get(Long id){
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            return (Beneficiario) session.delegate().get(Beneficiario.class, id);
        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener el Beneficiario.", e);
            throw e;
        }
    }

    @Override
    public List<Beneficiario> findAllPageable(Integer pageNumber) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("From Beneficiario order by id desc");
            query.setFirstResult((pageNumber - 1) * Pagination.MAX_PAGE);
            query.setMaxResults(Pagination.MAX_PAGE);
            return query.list();
        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la lista de Beneficiarios.", e);
            throw e;
        }
    }

    @Override
    public List<Beneficiario> findAll(Beneficiario beneficiario) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery("From  Beneficiario where beneficiario= ? order by id desc");
            query.setParameter(0 , beneficiario);
            return query.list();
        }
        catch (HibernateException e){
            LOGGER.error("No se pudo obtener la lista de Beneficiarios.",  e);
            throw e;
        }
    }

    @Override
    public Beneficiario save(Beneficiario beneficiario) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            session.delegate().saveOrUpdate(beneficiario);
            tx.commit();
            return beneficiario;
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            Beneficiario beneficiario = (Beneficiario) session.delegate().get(Beneficiario.class, id);
            session.delegate().delete(beneficiario);
            tx.commit();
        }
        catch (HibernateException e){
            LOGGER.error("No se pudo eliminar el beneficiario{}.", new Object[]{id}, e);
            tx.rollback();
            throw e;
        }
    }


    @Override
    public Beneficiario update(Beneficiario beneficiario) {
        Transaction tx = null;
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            tx = session.delegate().getTransaction();
            tx.begin();
            session.delegate().saveOrUpdate(beneficiario);
            tx.commit();
            return beneficiario;
        }
        catch (HibernateException e){
            tx.rollback();
            throw e;
        }
    }

    @Override
    public List<Beneficiario> buscar(String valor) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Criteria criteria = session.delegate().createCriteria(Beneficiario.class);

            try{
                Long id = Long.parseLong(valor);
                criteria.add(Restrictions.or(Restrictions.ilike("nombre", valor, MatchMode.ANYWHERE), Restrictions.or(Restrictions.ilike("apellido", valor, MatchMode.ANYWHERE), Restrictions.or(Restrictions.ilike("dni", valor, MatchMode.ANYWHERE), Restrictions.eq("id", id)))));
            }
            catch (NumberFormatException e){
                criteria.add(Restrictions.or(Restrictions.ilike("nombre", valor, MatchMode.ANYWHERE), Restrictions.ilike("apellido", valor, MatchMode.ANYWHERE)));
            }

            return criteria.list();

        } catch (HibernateException e) {
            LOGGER.error("No se pudo bucar la lista de Beneficiarios.", e);
            throw e;
        }
    }

    @Override
    public void exportarCredencial(Beneficiario beneficiario, OutputStream outStream) throws JRException {
        Map<String, Object> params = new HashMap();
        final String path = "C:\\reportes_soccam\\credencialDelBeneficiario.jasper";
        JasperReport templateCredencialDelBeneficiario = (JasperReport) JRLoader.loadObject(new File(path));
        params.put("beneficiario", beneficiario.getId());
        JasperPrint jasperPrint = this.crearReporte(templateCredencialDelBeneficiario, params);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }

    @Override
    public List<Beneficiario> getBySocio(Socio socio) {
        try(CloseableSession session = new CloseableSession(sessionFactory.openSession())){
            Query query = session.delegate().createQuery("From  Beneficiario where socioExtension = ? order by id desc");
            query.setParameter(0 , socio);
            return query.list();
        }
        catch (HibernateException e){
            LOGGER.error("No se pudo obtener la lista de Beneficiarios por socio.",  e);
            throw e;
        }
    }

    public JasperPrint crearReporte(JasperReport jasperStream, Map params) throws JRException {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Connection connection = session.delegate().doReturningWork(new ReturningWork<Connection>() {
                @Override
                public Connection execute(Connection conn) throws SQLException {
                    return conn;
                }
            });

            return JasperFillManager.fillReport(jasperStream, params, connection);

        } catch (HibernateException e) {
            LOGGER.error("No ejecutar la exportación de la credencial.", e);
            throw e;
        }
    }
}
