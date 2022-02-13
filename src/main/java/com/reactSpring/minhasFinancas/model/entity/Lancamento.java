package com.reactSpring.minhasFinancas.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.reactSpring.minhasFinancas.api.dto.LancamentoDTO;
import com.reactSpring.minhasFinancas.api.dto.UsuarioAutenticarDTO;
import com.reactSpring.minhasFinancas.model.enums.StatusLancamento;
import com.reactSpring.minhasFinancas.model.enums.TipoLancamento;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table( name = "lancamento")
@NoArgsConstructor
@AllArgsConstructor
public class Lancamento {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private Long id;

    @Column( name = "descricao")
    private String descricao;

    @Column(name = "mes")
    private Integer mes;

    @Column( name = "ano")
    private Integer ano;

    @ManyToOne
    @JoinColumn( name = "id_usuario")
    private Usuario usuario;

    @Column( name = "valor")
    private BigDecimal valor;

    @Column( name = "data_cadastro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataCadastro = LocalDate.now();

    @Column( name = "tipo_lancamento")
    @Enumerated( value = EnumType.STRING )
    private TipoLancamento tipo;

    @Column( name = "status")
    @Enumerated( value = EnumType.STRING )
    private StatusLancamento status;

}
