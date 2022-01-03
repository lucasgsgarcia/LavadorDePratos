# LavadorDePratos
Código desenvolvido academicamente para conhecimento de Threads em JAVA.



Descrição da Atividade
A atividade consiste em implementar um problema clássico de programação concorrente, o Produtor/
Consumidor. Este problema está abstraído no contexto do projeto Lavador de Pratos que é especificado
em seguida.
Especificação

• Classe Prato
– Atributos:
* Número de série (sequencial)
* Nível de sujeira (randômico sobre um Enum (BAIXO, MEDIO, ENGORDURADO))
garantir proporções de 30% BAIXO, 60% MEDIO e 10% EGORDURADO.

• Classe Escorredor
– Buffer limitado que aceita colocar/tirar Pratos em uma fila FIFO circular
– A aplicação deve encerrar caso os limites do escorredor foram violados, ou seja, a quantidade
de pratos deve ser: 0 <= pratos <= MAX.
MAX é a quantidade máxima de pratos que pode ser colocada no escorredor.
– Sempre que o escorredor estiver vazio ou cheio, deve-se apresentar uma mensagem na tela
informando o estado e a quantidade de pratos no escorredor.

• Classe PratosSujosFactory
– Simula uma pilha de pratos sujos infinita, retorna um novo prato sujo sempre que solicitada
• Classe Lavador – Runnable
– Sincronização com wait/notify sobre o Escorredor
– O trabalho dessa classe consiste em verificar se existe espaço no escorredor
true O lavador solicita um prato sujo e o lava (3ms para prato com nível de sujeira
BAIXO, 5ms para MEDIO e 10ms para ENGORDURADO) – use sleep para forçar
a thread a esperar o tempo necessário
false O lavador aguarda até que o Escorredor possua um espaço livre
– Uma condição de término (done) deve ser usada para indicar o fim da tarefa

• Classe Enxugador – Runnable
– Sincronização com wait/notify sobre o Escorredor
– O trabalho dessa classe consiste em verificar se existe algum prato no escorredor
true Retira o prato do Escorredor e o enxuga. O tempo para enxugar varia aleatoriamente
(tempo mínimo de 3ms e máximo de 10ms).
false Descansa aguardando que o lavador faça seu trabalho.
• Classe App – responsável por instanciar a aplicação
– Método work() deve ser usado para disparar os trabalhos
– Método stop() deve ser usado para encerrar os trabalhos
– Método main() cria a aplicação, dispara o início dos trabalhos, aguarda 2 minutos e
solicita o encerramento dos trabalhos.
