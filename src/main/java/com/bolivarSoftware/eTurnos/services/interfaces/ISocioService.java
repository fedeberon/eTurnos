package com.bolivarSoftware.eTurnos.services.interfaces;


import com.bolivarSoftware.eTurnos.domain.socio.Socio;
import net.sf.jasperreports.engine.JRException;

import java.io.OutputStream;
import java.util.List;

public interface ISocioService extends ICommonService<Socio, Long>{

    List<Socio> findAllPageable(Integer pageNumber);

    void exportarCredenciales(OutputStream outStream) throws JRException;

    void exportarCredencial(Socio socio, OutputStream outStream) throws JRException;

    Socio get(Long id);

    List<Socio> buscar(String valor);

    void crearImagenQR(List<Socio> socios);
}
