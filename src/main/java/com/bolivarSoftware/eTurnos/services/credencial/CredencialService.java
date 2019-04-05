package com.bolivarSoftware.eTurnos.services.credencial;

import com.bolivarSoftware.eTurnos.dao.CloseableSession;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.services.interfaces.ICredencialService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fede Beron on 14/2/2018.
 */

@Service
public class CredencialService implements ICredencialService {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger LOGGER = LoggerFactory.getLogger(CredencialService.class);

    @Override
    public void exportarCredencialDeEmpleado(Usuario usuario, OutputStream outStream) throws JRException {
        Map<String, Object> params = new HashMap();
        params.put("user_id", usuario.getId());
        final String path = "C:\\reportes_soccam\\credencialDeEmpleado.jasper";
        JasperReport templateTasa = (JasperReport) JRLoader.loadObject(new File(path));
        JasperPrint jasperPrint = this.crearReporte(templateTasa, params);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }

    private JasperPrint crearReporte(JasperReport jasperStream, Map params) throws JRException {
        try (CloseableSession session = new CloseableSession(sessionFactory.openSession())) {
            Connection connection = session.delegate().doReturningWork(connection1 -> connection1);

            return JasperFillManager.fillReport(jasperStream, params, connection);

        } catch (HibernateException e) {
            LOGGER.error("No ejecutar la exportación de la credencial.", e);
            throw e;
        }
    }
}
