package com.bolivarSoftware.eTurnos.services.beneficiario;

import com.bolivarSoftware.eTurnos.dao.interfaces.IBeneficiarioRepository;
import com.bolivarSoftware.eTurnos.domain.Beneficiario;
import com.bolivarSoftware.eTurnos.domain.socio.Socio;
import com.bolivarSoftware.eTurnos.services.interfaces.IBeneficiarioService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.List;

/**
 * Created by Damian Gallego on 10/7/2019.
 */
@Service
public class BeneficiarioService implements IBeneficiarioService{

    @Autowired
    private IBeneficiarioRepository dao;

    @Override
    public Beneficiario get(Long id)
    {
        return dao.get(id);
    }

    @Override
    public List<Beneficiario> findAllPageable(Integer pageNumber){
        return  dao.findAllPageable(pageNumber);
    }

    @Override
    public Beneficiario save(Beneficiario beneficiario) {
        return dao.save(beneficiario);
    }


    @Override
    public void delete(Long id){
        dao.delete(id);
    }

    @Override
    public Beneficiario update(Beneficiario beneficiario) {
        return dao.save(beneficiario);
    }

    @Override
    public List<Beneficiario> buscar(String valor) {
        return dao.buscar(valor);
    }

    @Override
    public void exportarCredencial(Beneficiario beneficiario, OutputStream outStream) throws JRException {
        dao.exportarCredencial(beneficiario, outStream);
    }

    @Override
    public List<Beneficiario> getBySocio(Socio socio) {
        return dao.getBySocio(socio);
    }
}
