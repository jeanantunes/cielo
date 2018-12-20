package com.cielo.test.controller;

import com.cielo.test.model.DadosDomicilioBancario;
import com.cielo.test.model.LancamentoContaCorrenteCliente;
import com.cielo.test.model.ListaControleLancamento;
import com.cielo.test.service.DadosDomicilioBancarioService;
import com.cielo.test.service.LancamentoContaCorrenteClienteService;
import com.cielo.test.service.ListaControleLancamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listaControleLancamento")
public class ListaControleLancamentoController {

    @Autowired
    private ListaControleLancamentoService listaControleLancamentoService;

    @Autowired
    private LancamentoContaCorrenteClienteService lancamentoContaCorrenteClienteService;

    @Autowired
    private DadosDomicilioBancarioService dadosDomicilioBancarioService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/list")
    public List<ListaControleLancamento> getAllListaControleLancamento() {
        List<ListaControleLancamento> lancamento = listaControleLancamentoService.findAll();
        if (lancamento.isEmpty()) {
            logger.error("Lista de Pessoas Física vazia: " + lancamento);
        }
        return lancamento;
    }

    // Save
    @PutMapping(value = "/save/{lancamento}", produces = "application/text")
    public @ResponseBody
    String saveListaControleLancamento(@RequestBody ListaControleLancamento lancamento) {

        LancamentoContaCorrenteCliente l = new LancamentoContaCorrenteCliente();
        l.setId(lancamento.getLancamentoContaCorrenteCliente().getId());
        l.setNomeTipoOperacao(lancamento.getLancamentoContaCorrenteCliente().getNomeTipoOperacao());
        l.setNomeSituacaoRemessa(lancamento.getLancamentoContaCorrenteCliente().getNomeSituacaoRemessa());
        l.setNumeroRemessaBanco(lancamento.getLancamentoContaCorrenteCliente().getNumeroRemessaBanco());
        l.setDadosDomicilioBancario(lancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario());

        dadosDomicilioBancarioService.save(lancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario());
        lancamentoContaCorrenteClienteService.save(l);

        ListaControleLancamento list = new ListaControleLancamento();
        list.setId(lancamento.getId());

        list.setLancamentoContaCorrenteCliente(l);
        list.setDataEfetivaLancamento(lancamento.getDataEfetivaLancamento());
        list.setDataLancamentoContaCorrenteCliente(lancamento.getDataLancamentoContaCorrenteCliente());
        list.setNumeroEvento(lancamento.getNumeroEvento());
        list.setDescricaoGrupoPagamento(lancamento.getDescricaoGrupoPagamento());
        list.setCodigoIdentificadorUnico(lancamento.getCodigoIdentificadorUnico());
        list.setNomeBanco(lancamento.getNomeBanco());
        list.setQuantidadeLancamentoRemessa(lancamento.getQuantidadeLancamentoRemessa());
        list.setNumeroRaizCNPJ(lancamento.getNumeroRaizCNPJ());
        list.setNumeroSufixoCNPJ(lancamento.getNumeroSufixoCNPJ());
        list.setValorLancamentoRemessa(lancamento.getValorLancamentoRemessa());
        list.setDateLancamentoContaCorrenteCliente(lancamento.getDateLancamentoContaCorrenteCliente());
        list.setDateEfetivaLancamento(lancamento.getDateEfetivaLancamento());

        listaControleLancamentoService.save(list);

        if (lancamento != null) {
            logger.info("Lancamento Salvo: " + lancamento + "");
            return "Salvo com Sucesso.";
        } else {
            logger.error("Dados obrigatórios: Lancamento: " + lancamento + "");
            return "Dados obrigatórios: Lancamento: " + lancamento + "";
        }
    }

    // Find
    @PostMapping(value = "/find/{id}", produces = "application/json")
    public @ResponseBody
    ListaControleLancamento getListaControleLancamentoById(@PathVariable(value = "id") Long id) {
        ListaControleLancamento lancamento = listaControleLancamentoService.findById(id);
        if (lancamento == null) {
            logger.error("ID: " + id + " não Localizado.");
        }
        return lancamento;
    }

    // Update
    @PutMapping(value = "/update/{id}", produces = "application/text")
    public @ResponseBody
    String updateListaControleLancamento(@PathVariable(value = "id") Long id,
                    @RequestBody ListaControleLancamento lancamentoDetails) {
        ListaControleLancamento lancamento = listaControleLancamentoService.findById(id);
        if (lancamento == null) {
            logger.error("ID: " + id + ". Não Localizado.");
            return "ID: " + id + ". Não Localizado.";
        } else {
            listaControleLancamentoService.save(lancamentoDetails);
            logger.info("Pessoa Física atualizada com Sucesso.");
        }
        return "Atualizado com Sucesso.";
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public String deleteListaControleLancamento(@PathVariable(value = "id") Long id) {
        ListaControleLancamento lancamento = listaControleLancamentoService.findById(id);
        if (lancamento == null) {
            logger.error("ID: " + id + ". Não Localizado.");
            return "Pessoa Física não localizada.";
        } else {
            listaControleLancamentoService.delete(lancamento);
            return "Excluido com Sucesso.";
        }
    }
}