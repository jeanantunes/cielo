package com.cielo.test.controller;

import com.cielo.test.model.LancamentoContaCorrenteCliente;
import com.cielo.test.model.ListaControleLancamento;
import com.cielo.test.model.TotalControleLancamento;
import com.cielo.test.service.DadosDomicilioBancarioService;
import com.cielo.test.service.LancamentoContaCorrenteClienteService;
import com.cielo.test.service.ListaControleLancamentoService;
import com.cielo.test.service.TotalControleLancamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/totalControleLancamento")
public class TotalControleLancamentoController {

    @Autowired
    private TotalControleLancamentoService totalControleLancamentoService;

    @Autowired
    private ListaControleLancamentoService listaControleLancamentoService;

    @Autowired
    private LancamentoContaCorrenteClienteService lancamentoContaCorrenteClienteService;

    @Autowired
    private DadosDomicilioBancarioService dadosDomicilioBancarioService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/list")
    public List<TotalControleLancamento> getAllTotalControleLancamento() {
        List<TotalControleLancamento> totalLancamento = totalControleLancamentoService.findAll();
        if (totalLancamento.isEmpty()) {
            logger.error("Lista de TotalControleLancamentos Física vazia: " + totalLancamento);
        }
        return totalLancamento;
    }

    // Save
    @PutMapping(value = "/save/{totalLancamento}", produces = "application/text")
    public @ResponseBody
    String saveTotalControleLancamento(@RequestBody TotalControleLancamento totalLancamento) {

        TotalControleLancamento total = new TotalControleLancamento();
        total.setId(totalLancamento.getId());
        total.setQuantidadeLancamentos(totalLancamento.getQuantidadeLancamentos());
        total.setQuantidadeRemessas(totalLancamento.getQuantidadeRemessas());
        total.setValorLancamentos(totalLancamento.getValorLancamentos());

        LancamentoContaCorrenteCliente l = new LancamentoContaCorrenteCliente();
        l.setId(totalLancamento.getListaControleLancamento().get(0).getLancamentoContaCorrenteCliente().getId());
        l.setNomeTipoOperacao(totalLancamento.getListaControleLancamento().get(0).getLancamentoContaCorrenteCliente().getNomeTipoOperacao());
        l.setNomeSituacaoRemessa(totalLancamento.getListaControleLancamento().get(0).getLancamentoContaCorrenteCliente().getNomeSituacaoRemessa());
        l.setNumeroRemessaBanco(totalLancamento.getListaControleLancamento().get(0).getLancamentoContaCorrenteCliente().getNumeroRemessaBanco());
        l.setDadosDomicilioBancario(totalLancamento.getListaControleLancamento().get(0).getLancamentoContaCorrenteCliente().getDadosDomicilioBancario());

        dadosDomicilioBancarioService.save(totalLancamento.getListaControleLancamento().get(0).getLancamentoContaCorrenteCliente().getDadosDomicilioBancario());
        lancamentoContaCorrenteClienteService.save(l);

        ListaControleLancamento list = new ListaControleLancamento();
        list.setId(totalLancamento.getId());

        list.setLancamentoContaCorrenteCliente(l);
        list.setDataEfetivaLancamento(totalLancamento.getListaControleLancamento().get(0).getDataEfetivaLancamento());
        list.setDataLancamentoContaCorrenteCliente(totalLancamento.getListaControleLancamento().get(0).getDataLancamentoContaCorrenteCliente());
        list.setNumeroEvento(totalLancamento.getListaControleLancamento().get(0).getNumeroEvento());
        list.setDescricaoGrupoPagamento(totalLancamento.getListaControleLancamento().get(0).getDescricaoGrupoPagamento());
        list.setCodigoIdentificadorUnico(totalLancamento.getListaControleLancamento().get(0).getCodigoIdentificadorUnico());
        list.setNomeBanco(totalLancamento.getListaControleLancamento().get(0).getNomeBanco());
        list.setQuantidadeLancamentoRemessa(totalLancamento.getListaControleLancamento().get(0).getQuantidadeLancamentoRemessa());
        list.setNumeroRaizCNPJ(totalLancamento.getListaControleLancamento().get(0).getNumeroRaizCNPJ());
        list.setNumeroSufixoCNPJ(totalLancamento.getListaControleLancamento().get(0).getNumeroSufixoCNPJ());
        list.setValorLancamentoRemessa(totalLancamento.getListaControleLancamento().get(0).getValorLancamentoRemessa());
        list.setDateLancamentoContaCorrenteCliente(totalLancamento.getListaControleLancamento().get(0).getDateLancamentoContaCorrenteCliente());
        list.setDateEfetivaLancamento(totalLancamento.getListaControleLancamento().get(0).getDateEfetivaLancamento());

        listaControleLancamentoService.save(list);

        total.setListaControleLancamento(totalLancamento.getListaControleLancamento());

        totalControleLancamentoService.save(total);

        if (totalLancamento.getQuantidadeLancamentos() != null || totalLancamento.getQuantidadeRemessas() != null || totalLancamento.getValorLancamentos() != null) {
            logger.info("totalLancamento Salvo: " + totalLancamento.getQuantidadeLancamentos() + ", " + totalLancamento.getQuantidadeRemessas() + ", " + totalLancamento.getValorLancamentos() + "");
            return "Salvo com Sucesso.";
        } else {
            logger.error("Dados obrigatórios: totalLancamento: " + totalLancamento.getQuantidadeLancamentos() + " qtdeRemessas: " + totalLancamento.getQuantidadeRemessas() + " valorLancamento: " + totalLancamento.getValorLancamentos() + "");
            return "Dados obrigatórios: totalLancamento: " + totalLancamento.getQuantidadeLancamentos() + " qtdeRemessas: " + totalLancamento.getQuantidadeRemessas() + " valorLancamento: " + totalLancamento.getValorLancamentos() + "";
        }
    }

    // Find
    @PostMapping(value = "/find/{id}", produces = "application/json")
    public @ResponseBody
    TotalControleLancamento getTotalControleLancamentoById(@PathVariable(value = "id") Long id) {
        TotalControleLancamento totalLancamento = totalControleLancamentoService.findById(id);
        if (totalLancamento == null) {
            logger.error("ID: " + id + " não Localizado.");
        }
        return totalLancamento;
    }

    // Update
    @PutMapping(value = "/update/{id}", produces = "application/text")
    public @ResponseBody
    String updateTotalControleLancamento(@PathVariable(value = "id") Long id,
                    @RequestBody TotalControleLancamento totalLancamentoDetails) {
        TotalControleLancamento totalLancamento = totalControleLancamentoService.findById(id);
        if (totalLancamento == null) {
            logger.error("ID: " + id + ". Não Localizado.");
            return "ID: " + id + ". Não Localizado.";
        } else {
            totalControleLancamentoService.save(totalLancamentoDetails);
            logger.info("TotalControleLancamento atualizada com Sucesso.");
        }
        return "Atualizado com Sucesso.";
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public String deleteTotalControleLancamento(@PathVariable(value = "id") Long id) {
        TotalControleLancamento totalLancamento = totalControleLancamentoService.findById(id);
        if (totalLancamento == null) {
            logger.error("ID: " + id + ". Não Localizado.");
            return "TotalControleLancamento não localizada.";
        } else {
            totalControleLancamentoService.delete(totalLancamento);
            return "Excluido com Sucesso.";
        }
    }
}