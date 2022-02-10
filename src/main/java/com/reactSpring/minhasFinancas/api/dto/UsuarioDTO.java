package com.reactSpring.minhasFinancas.api.dto;

import com.reactSpring.minhasFinancas.model.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private String email;

    private String nome;

    private String senha;

    public UsuarioDTO( Usuario usuario ){
        this.email = usuario.getEmail();
        this.nome = usuario.getNome();
        this.senha = usuario.getSenha();
    }
}
