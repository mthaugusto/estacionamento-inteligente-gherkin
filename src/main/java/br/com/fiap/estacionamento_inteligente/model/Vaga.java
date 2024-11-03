package br.com.fiap.estacionamento_inteligente.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@ToString(of = {"numero", "setor", "ocupada"})
@NoArgsConstructor
@AllArgsConstructor
public class Vaga {
    private int numero;
    private boolean ocupada = false; // Inicialmente a vaga está livre
    private String setor;

    public void ocupar() {
        this.ocupada = true;
    }

    public void liberar() {
        this.ocupada = false;
    }
}