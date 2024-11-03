package br.com.fiap.estacionamento_inteligente.service;

import br.com.fiap.estacionamento_inteligente.model.Vaga;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstacionamentoService {
    private List<Vaga> vagas = new ArrayList<>();

    public void adicionarVaga(Vaga vaga) {
        vagas.add(vaga);
    }

    public int contarVagasLivresPorSetor(String setor) {
        return (int) vagas.stream()
                .filter(vaga -> vaga.getSetor().equalsIgnoreCase(setor) && !vaga.isOcupada())
                .count();
    }

    public int contarVagasOcupadasPorSetor(String setor) {
        return (int) vagas.stream()
                .filter(vaga -> vaga.getSetor().equalsIgnoreCase(setor) && vaga.isOcupada())
                .count();
    }

    public List<Vaga> exibirStatusVagas() {
        return vagas;
    }

    public void ocuparVaga(int numero) {
        vagas.stream()
                .filter(vaga -> vaga.getNumero() == numero)
                .findFirst()
                .ifPresent(Vaga::ocupar);
    }

    public void liberarVaga(int numero) {
        vagas.stream()
                .filter(vaga -> vaga.getNumero() == numero)
                .findFirst()
                .ifPresent(Vaga::liberar);
    }
}