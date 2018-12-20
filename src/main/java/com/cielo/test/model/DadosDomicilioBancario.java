package com.cielo.test.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class DadosDomicilioBancario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer codigoBanco;
    private Integer numeroAgencia;
    private String numeroContaCorrente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(Integer codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public Integer getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(Integer numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNumeroContaCorrente() {
        return numeroContaCorrente;
    }

    public void setNumeroContaCorrente(String numeroContaCorrente) {
        this.numeroContaCorrente = numeroContaCorrente;
    }

    @Override
    public String toString() {
        return "dadosDomicilioBancario{" +
                "id=" + id +
                ", codigoBanco=" + codigoBanco +
                ", numeroAgencia=" + numeroAgencia +
                ", numeroContaCorrente='" + numeroContaCorrente + '\'' +
                '}';
    }
}
