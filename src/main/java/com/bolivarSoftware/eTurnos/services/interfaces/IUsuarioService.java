package com.bolivarSoftware.eTurnos.services.interfaces;

import com.bolivarSoftware.eTurnos.domain.Usuario;
import net.sf.jasperreports.engine.JRException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.OutputStream;
import java.time.Duration;
import java.util.List;

public interface IUsuarioService extends UserDetailsService, ICommonService<Usuario, String> {
    List<Usuario> findAllPageable(Integer page);

    Usuario get(Long id);

    Usuario getUsuarioAutenticado();

    Usuario obtenerDePrincipal();

    void editarRolDeUsuario(String id, String rol);

    Duration getTiempoActivoDeUsuarioDeHoy();

    void darDeBaja(String id);

    void activar(String id);

    void exportarCredencial(Long idUsuario, OutputStream outStream) throws JRException;
}
