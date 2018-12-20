package com.cielo.test.controller;

import com.cielo.test.model.DadosDomicilioBancario;
import com.cielo.test.model.LancamentoContaCorrenteCliente;
import com.cielo.test.service.DadosDomicilioBancarioService;
import com.cielo.test.service.LancamentoContaCorrenteClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentoContaCorrenteCliente")
public class LancamentoContaCorrenteClienteController {

    @Autowired
    private LancamentoContaCorrenteClienteService lancamentoContaCorrenteClienteService;

    @Autowired
    private DadosDomicilioBancarioService dadosDomicilioBancarioService;

    //@Autowired
    //private PjService pjService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/list")
    public List<LancamentoContaCorrenteCliente> getAllLancamentoContaCorrenteClientes() {
        List<LancamentoContaCorrenteCliente> p = lancamentoContaCorrenteClienteService.findAll();
         if (p.isEmpty()) {
            logger.error("Lista de LancamentoContaCorrenteClientes vazia: " + p);
        }
        return p;
    }

    // Save
    public @RequestMapping(method = RequestMethod.PUT, value = "/save/{cliente}", produces = "application/text")
    String saveLancamentoContaCorrenteCliente(@RequestBody LancamentoContaCorrenteCliente cliente) {

        LancamentoContaCorrenteCliente total = new LancamentoContaCorrenteCliente();
        total.setId(cliente.getId());
        total.setNumeroRemessaBanco(cliente.getNumeroRemessaBanco());
        total.setNomeSituacaoRemessa(cliente.getNomeSituacaoRemessa());
        total.setNomeTipoOperacao(cliente.getNomeTipoOperacao());
        total.setDadosDomicilioBancario(cliente.getDadosDomicilioBancario());

        dadosDomicilioBancarioService.save(cliente.getDadosDomicilioBancario());
        lancamentoContaCorrenteClienteService.save(total);

        if (cliente.getId() == null) {
            logger.warn("Não possui Conta associada." + " CONTA_ID: " + cliente.getId());
            return "Não possui Conta associada. Crie sua Conta!!!";
        } else {
            return "Lancamento Conta Corrente Cliente salvo com Sucesso!!!";
        }
    }

    // Find
    @PostMapping(value = "/find/{id}", produces = "application/json")
    public @ResponseBody
    LancamentoContaCorrenteCliente getLancamentoContaCorrenteClienteById(@PathVariable(value = "id") Long id) {
        LancamentoContaCorrenteCliente p = lancamentoContaCorrenteClienteService.findById(id);
        if (p == null) {
            logger.error("ID: " + id + " não Localizado.");
        }
        return p;
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public String deleteLancamentoContaCorrenteCliente(@PathVariable(value = "id") Long id) {
        LancamentoContaCorrenteCliente p = lancamentoContaCorrenteClienteService.findById(id);
        if (p == null) {
            logger.error("ID: " + id + ". Não Localizado.");
            return "LancamentoContaCorrenteCliente não localizada.";
        } else {
            if (p.getId() != null) {
                lancamentoContaCorrenteClienteService.delete(p.getId());
                lancamentoContaCorrenteClienteService.delete(p.getId());
            }

            return "Excluido com Sucesso.";
        }
    }
}