package com.bolivarSoftware.eTurnos.services.usuario;

import com.bolivarSoftware.eTurnos.config.interfaces.IAuthenticationFacade;
import com.bolivarSoftware.eTurnos.dao.interfaces.ISocioRepository;
import com.bolivarSoftware.eTurnos.dao.interfaces.IUsuarioRepository;
import com.bolivarSoftware.eTurnos.domain.Actividad;
import com.bolivarSoftware.eTurnos.domain.ActividadUsuario;
import com.bolivarSoftware.eTurnos.domain.Usuario;
import com.bolivarSoftware.eTurnos.services.interfaces.IActividadUsuarioService;
import com.bolivarSoftware.eTurnos.services.interfaces.ICredencialService;
import com.bolivarSoftware.eTurnos.services.interfaces.ISocioService;
import com.bolivarSoftware.eTurnos.services.interfaces.IUsuarioService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.OutputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository dao;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    private IActividadUsuarioService actividadUsuarioService;

    @Autowired
    private ICredencialService credencialService;

    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        Usuario usuario = dao.get(username);
        if(usuario == null) {
            throw new UsernameNotFoundException(messages.getMessage("JdbcDaoImpl.notFound", new Object[]{username}, "Username {0} no encontrado."));
        }

        else return usuario;
    }

    @Override
    public List<Usuario> findAllPageable(Integer page){
        return dao.findAllPageable(page);
    }

    @Override
    public Usuario get(String id){
        return dao.get(id);
    }

    @Override
    public Usuario get(Long id){
        return dao.get(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return dao.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        throw new NotImplementedException("Metodo no implementado");
    }

    /**
     * Usar por defecto obtenerDePrincipal()
     * @return Usuario
     */
    @Override
    public Usuario getUsuarioAutenticado(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return this.get(username);
    }

    @Override
    public Usuario obtenerDePrincipal() {
        return authenticationFacade.getPrincipal();
    }

    @Override
    public void editarRolDeUsuario(String id, String rol) {
        Usuario usuario = this.get(id);
        usuario.setRol(rol);
        this.save(usuario);
    }

    @Override
    public Duration getTiempoActivoDeUsuarioDeHoy() {
        Usuario usuario = this.obtenerDePrincipal();
        List<ActividadUsuario> actividades = actividadUsuarioService.findByUsuarioByMomento(usuario, LocalDateTime.now());
        LocalDateTime oldDate = LocalDateTime.now(), newDate = LocalDateTime.now();
        Long time = 0l;
        int i = 0;
        for(ActividadUsuario a : actividades){
            if(a.getActividad().equals(Actividad.ATENDIENDO)){
                if(i == 0){
                    oldDate = a.getMomento();
                    newDate = a.getMomento();
                    i++;
                }
                else{
                    oldDate = newDate;
                    newDate = a.getMomento();
                }

                time += ChronoUnit.SECONDS.between(oldDate, newDate);
            }
        }

        if(oldDate.compareTo(newDate) == 0){
            time += ChronoUnit.SECONDS.between(oldDate, LocalDateTime.now());
        }

        return Duration.ofMillis(time);
    }

    @Override
    public void darDeBaja(String id) {
        Usuario usuario = this.get(id);
        usuario.setActivo(false);
        dao.save(usuario);
    }

    @Override
    public void activar(String id) {
        Usuario usuario = this.get(id);
        usuario.setActivo(true);
        dao.save(usuario);
    }

    @Override
    public void exportarCredencial(Long idUsuario, OutputStream outStream) throws JRException {
        Usuario usuario = this.get(idUsuario);
        credencialService.exportarCredencialDeEmpleado(usuario, outStream);
    }
}
