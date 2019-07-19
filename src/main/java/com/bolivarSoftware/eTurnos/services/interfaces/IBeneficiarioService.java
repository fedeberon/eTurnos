package com.bolivarSoftware.eTurnos.services.interfaces;

import com.bolivarSoftware.eTurnos.domain.Beneficiario;
import com.bolivarSoftware.eTurnos.domain.socio.Socio;
import net.sf.jasperreports.engine.JRException;

import java.io.OutputStream;
import java.util.List;

/**
 * Created by Damian Gallego on 10/7/2019.
 */
public interface IBeneficiarioService {
    Beneficiario get(Long id);

    List<Beneficiario> findAllPageable(Integer pageNumber);

    Beneficiario save(Beneficiario beneficiario);

    void delete(Long id);

    Beneficiario update(Beneficiario beneficiario);

    List<Beneficiario> buscar(String valor);

    void exportarCredencial(Beneficiario beneficiario, OutputStream outStream) throws JRException;

    List<Beneficiario> getBySocio(Socio socio);
}
