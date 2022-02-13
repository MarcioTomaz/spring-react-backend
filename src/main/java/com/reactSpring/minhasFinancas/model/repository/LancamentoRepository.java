package com.reactSpring.minhasFinancas.model.repository;

import com.reactSpring.minhasFinancas.model.entity.Lancamento;
import com.reactSpring.minhasFinancas.model.enums.TipoLancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    @Query(value = "SELECT SUM(l.valor) FROM Lancamento l join l.usuario u " +
            " WHERE u.id = :idUsuario and l.tipo = :tipo group by u ")
    BigDecimal obterSaldoPorTipoLancamentoEUsuario(@Param("idUsuario") Long idUsuario, @Param("tipo") TipoLancamento tipo);
}
