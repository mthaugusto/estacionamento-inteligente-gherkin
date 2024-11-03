Feature: Sistema de Estacionamento Inteligente

  Scenario: Ocupar uma vaga específica
    Given que a vaga de número 1 no setor A está livre
    When eu ocupo a vaga de número 1
    Then o status da vaga de número 1 deve ser "ocupada"

  Scenario: Liberar uma vaga específica
    Given que a vaga de número 1 no setor A está ocupada
    When eu libero a vaga de número 1
    Then o status da vaga de número 1 deve ser "livre"

  Scenario: Contar vagas livres no setor A
    Given que existem 10 vagas no setor A, sendo 6 livres e 4 ocupadas
    When eu conto as vagas livres no setor A
    Then o sistema deve retornar 6 vagas livres