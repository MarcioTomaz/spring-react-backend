package com.reactSpring.minhasFinancas.api.controller;

import com.reactSpring.minhasFinancas.api.dto.UsuarioAutenticarDTO;
import com.reactSpring.minhasFinancas.api.dto.UsuarioDTO;
import com.reactSpring.minhasFinancas.exception.ErroAutenticacao;
import com.reactSpring.minhasFinancas.exception.RegraNegocioException;
import com.reactSpring.minhasFinancas.model.entity.Usuario;
import com.reactSpring.minhasFinancas.service.LancamentoService;
import com.reactSpring.minhasFinancas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private LancamentoService lancamentoService;

    @PostMapping("/autenticar")
    public ResponseEntity autenticar( @RequestBody UsuarioAutenticarDTO dto){

        try {
            Usuario usuarioAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());

            return ResponseEntity.ok().body(usuarioAutenticado);

        }catch (ErroAutenticacao e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody UsuarioDTO dto){

        Usuario usuario = new Usuario(dto);

        try {
            Usuario usuarioSalvo = service.salvarUsuario(usuario);
            return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);

        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}/saldo")
    public ResponseEntity obterSaldo( @PathVariable("id") Long id ){

        Optional<Usuario> usuario = service.obterPorId(id);

        if ( !usuario.isPresent() ) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        BigDecimal saldo = lancamentoService.obterSaldoPorTipoLancamentoEUsuario(id);

        return ResponseEntity.ok(saldo);

    }
}
