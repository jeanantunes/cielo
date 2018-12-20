package com.cielo.test.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class TotalControleLancamento implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private Integer quantidadeLancamentos;
        private Integer quantidadeRemessas;
        private Long valorLancamentos;
        @OneToMany
        private List<ListaControleLancamento> listaControleLancamento;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Integer getQuantidadeLancamentos() {
                return quantidadeLancamentos;
        }

        public void setQuantidadeLancamentos(Integer quantidadeLancamentos) {
                this.quantidadeLancamentos = quantidadeLancamentos;
        }

        public Integer getQuantidadeRemessas() {
                return quantidadeRemessas;
        }

        public void setQuantidadeRemessas(Integer quantidadeRemessas) {
                this.quantidadeRemessas = quantidadeRemessas;
        }

        public Long getValorLancamentos() {
                return valorLancamentos;
        }

        public void setValorLancamentos(Long valorLancamentos) {
                this.valorLancamentos = valorLancamentos;
        }

        public List<ListaControleLancamento> getListaControleLancamento() {
                return listaControleLancamento;
        }

        public void setListaControleLancamento(List<ListaControleLancamento> listaControleLancamento) {
                this.listaControleLancamento = listaControleLancamento;
        }

        @Override
        public String toString() {
                return "totalControleLancamento{" +
                        "id=" + id +
                        ", quantidadeLancamentos=" + quantidadeLancamentos +
                        ", quantidadeRemessas=" + quantidadeRemessas +
                        ", valorLancamentos=" + valorLancamentos +
                        ", listaControleLancamento=" + listaControleLancamento +
                        '}';
        }
}
