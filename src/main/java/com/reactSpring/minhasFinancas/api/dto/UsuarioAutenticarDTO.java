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
public class UsuarioAutenticarDTO {

    private String email;

    private String senha;

    public UsuarioAutenticarDTO( Usuario usuario ){
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }
}
