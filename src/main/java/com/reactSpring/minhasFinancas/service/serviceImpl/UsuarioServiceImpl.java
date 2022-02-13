package com.reactSpring.minhasFinancas.service.serviceImpl;

import com.reactSpring.minhasFinancas.exception.ErroAutenticacao;
import com.reactSpring.minhasFinancas.exception.RegraNegocioException;
import com.reactSpring.minhasFinancas.model.entity.Usuario;
import com.reactSpring.minhasFinancas.model.repository.UsuarioRepository;
import com.reactSpring.minhasFinancas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario autenticar(String email, String senha) {

        Optional<Usuario> usuario = repository.findByEmail(email);

        if(!usuario.isPresent()){
            throw new ErroAutenticacao(" Usuário não encontrado para o email informado. ");
        }

        if(!usuario.get().getSenha().equals(senha)){
            throw new ErroAutenticacao(" Senha inválida. ");
        }

        return usuario.get();
    }

    @Override
    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {

        validarEmail(usuario.getEmail());

        return repository.save(usuario);
    }

    @Override
    public void validarEmail(String email) {

       boolean existe = repository.existsByEmail(email);

       if(existe) {
           throw new RegraNegocioException(" Já existe um usuário cadastrado com este email. ");
       }
    }

    @Override
    public Optional<Usuario> obterPorId(Long id) {
        return repository.findById(id);
    }

}
