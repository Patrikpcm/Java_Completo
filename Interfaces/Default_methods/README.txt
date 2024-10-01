- A partir do Java 8, interfaces podem conter métodos concretos.

- A intenção básica é prover implementação padrão para métodos, de modo a evitar:
    1) Repetição de implementação em toda classe que implemente a interfaces.
    2) A necessidade de se criar classes abstratas para prover reuso da implementação.

- Outras vantagens:
    - Manter a retrocompatibilidade com sistemas existentes
    - Permitir que 'interfaces funcionais' (que devem conter apenas um método)
      possam prover outras operações padrão reutilizáveis.

Considerações
- Interfaces podem prover reuso de código
- Com default methods temos uma forma de Herança Múltipla
    - Mas o compilador reclama se houver mais de um método com a mesma assinatura, 
      obrigando a sobrescreve-lo.
- Interfaces ainda são bem diferentes de classes abstratas. Interfaces não possuem
  recursos tais como construtores e atributos.