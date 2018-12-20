package com.cielo.test.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class LancamentoContaCorrenteCliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigInteger numeroRemessaBanco;
    private String nomeSituacaoRemessa;
    @ManyToOne
    private DadosDomicilioBancario dadosDomicilioBancario;
    private String nomeTipoOperacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getNumeroRemessaBanco() {
        return numeroRemessaBanco;
    }

    public void setNumeroRemessaBanco(BigInteger numeroRemessaBanco) {
        this.numeroRemessaBanco = numeroRemessaBanco;
    }

    public String getNomeSituacaoRemessa() {
        return nomeSituacaoRemessa;
    }

    public void setNomeSituacaoRemessa(String nomeSituacaoRemessa) {
        this.nomeSituacaoRemessa = nomeSituacaoRemessa;
    }

    public DadosDomicilioBancario getDadosDomicilioBancario() {
        return dadosDomicilioBancario;
    }

    public void setDadosDomicilioBancario(DadosDomicilioBancario dadosDomicilioBancario) {
        this.dadosDomicilioBancario = dadosDomicilioBancario;
    }

    public String getNomeTipoOperacao() {
        return nomeTipoOperacao;
    }

    public void setNomeTipoOperacao(String nomeTipoOperacao) {
        this.nomeTipoOperacao = nomeTipoOperacao;
    }

    @Override
    public String toString() {
        return "lancamentoContaCorrenteCliente{" +
                "id=" + id +
                ", numeroRemessaBanco=" + numeroRemessaBanco +
                ", nomeSituacaoRemessa='" + nomeSituacaoRemessa + '\'' +
                ", dadosDomicilioBancario=" + dadosDomicilioBancario +
                ", nomeTipoOperacao='" + nomeTipoOperacao + '\'' +
                '}';
    }
}
