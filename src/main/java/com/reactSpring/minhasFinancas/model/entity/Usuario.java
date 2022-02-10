package com.reactSpring.minhasFinancas.model.entity;

import com.reactSpring.minhasFinancas.api.dto.UsuarioAutenticarDTO;
import com.reactSpring.minhasFinancas.api.dto.UsuarioDTO;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Entity
@Table( name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    public Usuario( UsuarioDTO usuarioDTO ){
        this.email = usuarioDTO.getEmail();
        this.nome = usuarioDTO.getNome();
        this.senha = usuarioDTO.getSenha();
    }

    public Usuario( UsuarioAutenticarDTO usuarioAutenticarDTO ){
        this.email = usuarioAutenticarDTO.getEmail();
        this.senha = usuarioAutenticarDTO.getSenha();
    }

}
