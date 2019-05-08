package com.bolivarSoftware.eTurnos.services.cliente;


import com.bolivarSoftware.eTurnos.dao.interfaces.ISocioRepository;
import com.bolivarSoftware.eTurnos.domain.socio.Socio;
import com.bolivarSoftware.eTurnos.services.interfaces.ISocioService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class SocioService implements ISocioService {

    @Autowired
    private ISocioRepository dao;

    @Override
    public List<Socio> findAllPageable(Integer pageNumber){
        return  dao.findAllPageable(pageNumber);
    }

    @Override
    public void exportarCredenciales(OutputStream outStream) throws JRException {
        dao.exportarCredenciales(outStream);
    }

    @Override
    public void exportarCredencial(Socio socio, OutputStream outStream) throws JRException {
        dao.exportarCredencial(socio, outStream);
    }

    @Override
    public Socio get(Long id) {
        return dao.get(id);
    }

    @Override
    public List<Socio> buscar(String valor) {
        return dao.buscar(valor);
    }

    @Override
    public Socio save(Socio socio) {
        return null;
    }

    @Override
    public List<Socio> findAll() {
        return dao.findAll();
    }

    @Override
    public void crearImagenQR(List<Socio> socios) {
        try {
            dao.crearImagenQR(socios);

        } catch (JRException e ) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
