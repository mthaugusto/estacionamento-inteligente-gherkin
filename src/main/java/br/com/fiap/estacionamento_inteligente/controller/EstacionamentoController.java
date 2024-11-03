package br.com.fiap.estacionamento_inteligente.controller;


import br.com.fiap.estacionamento_inteligente.model.Vaga;
import br.com.fiap.estacionamento_inteligente.service.EstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vagas")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    @PostMapping
    public void adicionarVaga(@RequestBody Vaga vaga) {
        estacionamentoService.adicionarVaga(vaga);
    }

    @GetMapping("/livres/{setor}")
    public int contarVagasLivres(@PathVariable String setor) {
        return estacionamentoService.contarVagasLivresPorSetor(setor);
    }

    @GetMapping("/ocupadas/{setor}")
    public int contarVagasOcupadas(@PathVariable String setor) {
        return estacionamentoService.contarVagasOcupadasPorSetor(setor);
    }

    @GetMapping("/status")
    public List<Vaga> exibirStatusVagas() {
        return estacionamentoService.exibirStatusVagas();
    }

    @PutMapping("/ocupar/{numero}")
    public void ocuparVaga(@PathVariable int numero) {
        estacionamentoService.ocuparVaga(numero);
    }

    @PutMapping("/liberar/{numero}")
    public void liberarVaga(@PathVariable int numero) {
        estacionamentoService.liberarVaga(numero);
    }
}
