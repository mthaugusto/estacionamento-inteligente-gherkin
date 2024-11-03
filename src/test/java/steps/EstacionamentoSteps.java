package steps;

import br.com.fiap.estacionamento_inteligente.model.Vaga;
import br.com.fiap.estacionamento_inteligente.service.EstacionamentoService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstacionamentoSteps {
    private EstacionamentoService estacionamentoService = new EstacionamentoService();
    private Vaga vaga;


    @Given("que a vaga de número {int} no setor {string} está livre")
    public void que_a_vaga_de_número_no_setor_está_livre(int numero, String setor) {
        vaga = new Vaga(numero, false, setor);
        estacionamentoService.adicionarVaga(vaga);
        throw new io.cucumber.java.PendingException();
    }

    @When("eu ocupo a vaga de número {int}")
    public void eu_ocupo_a_vaga_de_número(int numero) {
        estacionamentoService.ocuparVaga(numero);
        throw new io.cucumber.java.PendingException();
    }

    @Then("o status da vaga de número {int} deve ser {string}")
    public void o_status_da_vaga_de_número_deve_ser(int numero, String status) {
        Vaga vagaAtual = estacionamentoService.exibirStatusVagas().stream()
                .filter(v -> v.getNumero() == numero)
                .findFirst().orElse(null);
        assertEquals(status.equals("ocupada"), vagaAtual.isOcupada());
        throw new io.cucumber.java.PendingException();
    }

    @Given("que a vaga de número {int} no setor {string} está ocupada")
    public void que_a_vaga_de_número_no_setor_está_ocupada(int numero, String setor) {
        vaga = new Vaga(numero, true, setor);
        estacionamentoService.adicionarVaga(vaga);
        throw new io.cucumber.java.PendingException();
    }

    @When("eu libero a vaga de número {int}")
    public void eu_libero_a_vaga_de_número(int numero) {
        estacionamentoService.liberarVaga(numero);
        throw new io.cucumber.java.PendingException();
    }

    @Given("existem {int} vagas no setor {string}, sendo {int} livres e {int} ocupadas")
    public void existem_vagas_no_setor_sempre_livres_e_ocupadas(int total, String setor, int livres, int ocupadas) {
        for (int i = 1; i <= livres; i++) {
            estacionamentoService.adicionarVaga(new Vaga(i, false, setor));
        }
        for (int i = livres + 1; i <= total; i++) {
            estacionamentoService.adicionarVaga(new Vaga(i, true, setor));
        }
        throw new io.cucumber.java.PendingException();
    }


    @Then("o sistema deve retornar {int} vagas livres")
    public void o_sistema_deve_retornar_vagas_livres(int esperadas) {
        int livres = estacionamentoService.contarVagasLivresPorSetor("A");
        assertEquals(esperadas, livres);
        throw new io.cucumber.java.PendingException();
    }

}

