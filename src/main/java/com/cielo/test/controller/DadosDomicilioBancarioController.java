package com.cielo.test.controller;

import com.cielo.test.model.DadosDomicilioBancario;
import com.cielo.test.service.ListaControleLancamentoService;
import com.cielo.test.service.DadosDomicilioBancarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dadosDomicilioBancario")
public class DadosDomicilioBancarioController {

    @Autowired
    private DadosDomicilioBancarioService dadosDomicilioBancarioService;

    @Autowired
    private ListaControleLancamentoService listaControleLancamentoService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //List
    @GetMapping("/list")
    public List<DadosDomicilioBancario> getAllDadosDomicilioBancario() {

        List<DadosDomicilioBancario> totalLancamento = dadosDomicilioBancarioService.findAll();
        if (totalLancamento.isEmpty()) {
            logger.error("Lista de DadosDomicilioBancarios Física vazia: " + totalLancamento);
        }
        return totalLancamento;
    }

    // Save
    @PutMapping(value = "/save/{dados}", produces = "application/text")
    public @ResponseBody
    String saveDadosDomicilioBancario(@RequestBody DadosDomicilioBancario dados) {

        dadosDomicilioBancarioService.save(dados);

        DadosDomicilioBancario total = dadosDomicilioBancarioService.findById(dados.getId());
        total.setCodigoBanco(dados.getCodigoBanco());
        total.setNumeroAgencia(dados.getNumeroAgencia());
        total.setNumeroContaCorrente(dados.getNumeroContaCorrente());

        dadosDomicilioBancarioService.save(total);

        if (dados.getCodigoBanco() != null || dados.getNumeroAgencia() != null || dados.getNumeroContaCorrente() != null) {
            logger.info("dados Salvo: " + dados.getCodigoBanco() + ", " + dados.getNumeroAgencia() + ", " + dados.getNumeroContaCorrente() + "");
            return "Salvo com Sucesso.";
        } else {
            logger.error("Dados obrigatórios: codigoBanco: " + dados.getCodigoBanco() + " numeroAgencia: " + dados.getNumeroAgencia() + " numeroContaCorrente: " + dados.getNumeroContaCorrente() + "");
            return "Dados obrigatórios: codigoBanco: " + dados.getCodigoBanco() + " numeroAgencia: " + dados.getNumeroAgencia() + " numeroContaCorrente: " + dados.getNumeroContaCorrente() + "";
        }
    }

    // Find
    @PostMapping(value = "/find/{id}", produces = "application/json")
    public @ResponseBody
    DadosDomicilioBancario getDadosDomicilioBancarioById(@PathVariable(value = "id") Long id) {
        DadosDomicilioBancario dados = dadosDomicilioBancarioService.findById(id);
        if (dados == null) {
            logger.error("ID: " + id + " não Localizado.");
        }
        return dados;
    }

    // Update
    @PutMapping(value = "/update/{id}", produces = "application/text")
    public @ResponseBody
    String updateDadosDomicilioBancario(@PathVariable(value = "id") Long id,
                                         @RequestBody DadosDomicilioBancario dadosDetails) {
        DadosDomicilioBancario dados = dadosDomicilioBancarioService.findById(id);
        if (dados == null) {
            logger.error("ID: " + id + ". Não Localizado.");
            return "ID: " + id + ". Não Localizado.";
        } else {
            dadosDomicilioBancarioService.save(dadosDetails);
            logger.info("DadosDomicilioBancario atualizada com Sucesso.");
        }
        return "Atualizado com Sucesso.";
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public String deleteDadosDomicilioBancario(@PathVariable(value = "id") Long id) {
        DadosDomicilioBancario dados = dadosDomicilioBancarioService.findById(id);
        if (dados == null) {
            logger.error("ID: " + id + ". Não Localizado.");
            return "DadosDomicilioBancario não localizada.";
        } else {
            dadosDomicilioBancarioService.delete(dados);
            return "Excluido com Sucesso.";
        }
    }
}