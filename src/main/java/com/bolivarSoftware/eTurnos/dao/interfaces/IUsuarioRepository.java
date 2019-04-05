package com.bolivarSoftware.eTurnos.dao.interfaces;

import com.bolivarSoftware.eTurnos.domain.Usuario;

import java.util.List;

public interface IUsuarioRepository {
    Usuario get(String id);

    Usuario get(Long id);

    List<Usuario> findAllPageable(Integer pageNumber);

    Usuario save(Usuario usuario);

}
