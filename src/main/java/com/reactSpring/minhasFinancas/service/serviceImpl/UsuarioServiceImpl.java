package com.reactSpring.minhasFinancas.service.serviceImpl;

import com.reactSpring.minhasFinancas.exception.RegraNegocioException;
import com.reactSpring.minhasFinancas.model.entity.Usuario;
import com.reactSpring.minhasFinancas.model.repository.UsuarioRepository;
import com.reactSpring.minhasFinancas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario autenticar(String email, String senha) {
        return null;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void validarEmail(String email) {

       boolean existe = repository.existsByEmail(email);

       if(existe) {
           throw new RegraNegocioException(" Já existe um usuário cadastrado com este email. ");
       }
    }

}
