package com.reactSpring.minhasFinancas.service;

import com.reactSpring.minhasFinancas.api.dto.UsuarioAutenticarDTO;
import com.reactSpring.minhasFinancas.model.entity.Usuario;
import org.springframework.stereotype.Service;

public interface UsuarioService {

    Usuario autenticar(String email, String senha);

    Usuario salvarUsuario(Usuario usuario);

    void validarEmail(String email);
}
