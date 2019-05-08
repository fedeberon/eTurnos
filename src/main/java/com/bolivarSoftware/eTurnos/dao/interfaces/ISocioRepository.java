package com.bolivarSoftware.eTurnos.dao.interfaces;


import com.bolivarSoftware.eTurnos.domain.socio.Socio;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public interface ISocioRepository {
    List<Socio> findAllPageable(Integer pageNumber);

    void exportarCredencial(Socio socio, OutputStream outStream) throws JRException;

    void exportarCredenciales(OutputStream outStream) throws JRException;

    Socio get(Long id);

    List<Socio> buscar(String valor);

    void crearImagenQR(List<Socio> socios) throws JRException, IOException;

    List<Socio> findAll();
}
