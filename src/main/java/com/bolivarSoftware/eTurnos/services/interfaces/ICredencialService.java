package com.bolivarSoftware.eTurnos.services.interfaces;

import com.bolivarSoftware.eTurnos.domain.Usuario;
import net.sf.jasperreports.engine.JRException;

import java.io.OutputStream;

/**
 * Created by Fede Beron on 14/2/2018.
 */
public interface ICredencialService {
    void exportarCredencialDeEmpleado(Usuario usuario, OutputStream outStream) throws JRException;
}
