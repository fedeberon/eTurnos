package com.bolivarSoftware.eTurnos.dao.socio;

import com.bolivarSoftware.eTurnos.beans.Pagination;
import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.dao.interfaces.ISocioRepository;
import com.bolivarSoftware.eTurnos.domain.socio.Socio;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SocioRepository implements ISocioRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocioRepository.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Socio> findAllPageable(Integer pageNumber) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("From Socio order by id desc");
            query.setFirstResult((pageNumber - 1) * Pagination.MAX_PAGE);
            query.setMaxResults(Pagination.MAX_PAGE);
            return query.list();
        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la lista de Socios.", e);
            throw e;
        }
    }

    @Override
    public void exportarCredencial(Socio socio, OutputStream outStream) throws JRException {
        Map<String, Object> params = new HashMap();
        final String path = "C:\\reportes_soccam\\credencialDeSocios.jasper";
        JasperReport templateCredencialDeSocio = (JasperReport) JRLoader.loadObject(new File(path));
        params.put("idSocio", socio.getId());
        JasperPrint jasperPrint = this.crearReporte(templateCredencialDeSocio, params);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }

    @Override
    public void exportarCredenciales(OutputStream outStream) throws JRException {
        Map<String, Object> params = new HashMap();
        final String path = "C:\\reportes_soccam\\reporteDeSocios.jasper";
        JasperReport templateTasa = (JasperReport) JRLoader.loadObject(new File(path));
        JasperPrint jasperPrint = this.crearReporte(templateTasa, params);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }

    @Override
    public Socio get(Long id) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            return (Socio) session.delegate().get(Socio.class, id);
        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener el Socios.", e);
            throw e;
        }
    }

    @Override
    public List<Socio> buscar(String valor) {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Criteria criteria = session.delegate().createCriteria(Socio.class);

                try{
                    Long id = Long.parseLong(valor);
                    criteria.add(Restrictions.or(Restrictions.ilike("nombre", valor, MatchMode.ANYWHERE), Restrictions.or(Restrictions.ilike("apellido", valor, MatchMode.ANYWHERE), Restrictions.eq("id", id))));
                }
                catch (NumberFormatException e){
                    criteria.add(Restrictions.or(Restrictions.ilike("nombre", valor, MatchMode.ANYWHERE), Restrictions.ilike("apellido", valor, MatchMode.ANYWHERE)));
                }

            return criteria.list();

        } catch (HibernateException e) {
            LOGGER.error("No se pudo bucar la lista de Socios.", e);
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

    @Override
    public void crearImagenQR(List<Socio> socios) throws JRException, IOException {
        Map<String, Object> params = new HashMap();
        final String path = "C:\\reportes_soccam\\QR-socio.jasper";
        JasperReport templateQRSocio = (JasperReport) JRLoader.loadObject(new File(path));

        for (Socio socio : socios) {
            params.put("idSocio" , socio.getId());
            JasperPrint jasperPrint = this.crearReporte(templateQRSocio, params);
            BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
            JRGraphics2DExporter exporter = new JRGraphics2DExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D, image.getGraphics());
            exporter.setParameter(JRGraphics2DExporterParameter.ZOOM_RATIO, Float.valueOf(1));
            exporter.exportReport();
            File file = new File("C:\\reportes_soccam\\img-QR\\"+ socio.getId() +".jpg");
            ImageIO.write(image, "JPG", file);
        }
    }


    @Override
    public List<Socio> findAll(){
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Query query = session.delegate().createQuery("From Socio");
            return query.list();
        } catch (HibernateException e) {
            LOGGER.error("No se pudo obtener la lista de Socios.", e);
            throw e;
        }
    }
}