package com.reactSpring.minhasFinancas.model.entity;

import lombok.*;

import javax.persistence.*;


//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
@Data
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

}
