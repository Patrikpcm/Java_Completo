- A partir do java 8, interfaces podem ter "default methods" ou "defender methods"
    - Isso causa implicações conceituais e práticas, que serão discutidas durante o curso

INTERPRETAÇÃO CLÁSSICA
- Interface é um tipo que define um conjunto de operações que uma classe deve implentar.
- A interface estabelece um contrato que a classe deve cumprir.

    interface Shape{
        double area();
        double perimeter();
    }
Obs: A interface parece muito uma classe abstrata com methodos abstratos

- Pra quê interfaces?
    Para criar sistemas com baixo acoplamento e flexíveis

PROBLEMA EXEMPLO
Um locadora brasileira de carros cobra um valor por hora para locações de até 12 horas. Porém, 
se a duração da locação ultrapassar 12 horas, a locação será cobrada com base em um valor diário.
Além do valor da locação, é acrescido no preço o valor do imposto conforme regras do país que,
no caso do Brasil, é 20% para valores até 100,00, ou 15% para valores acima de 100,00. Fazer um
programa que lê os dados da locação (modelo do carro, instante inicial e final da locação), bem 
como o valor por hora e o valor diário de locação. O programa deve então gerar a nota de pagamento
contendo valor da locação, valor do imposto e valor total do pagamento e informar os dados na tela.