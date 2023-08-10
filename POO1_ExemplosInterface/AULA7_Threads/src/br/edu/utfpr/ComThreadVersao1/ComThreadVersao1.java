package br.edu.utfpr.ComThreadVersao1;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
Uma thread pode ser implementada de duas formas em Java: Por interface ou por herança
as duas abordagens usam a classe Thread para instanciar, acessar e controlar uma thread. A única diferença é como uma classe 
´para Thread é criada. Por interface (implements)
é possível construir uma thread em qualquer objeto que implementa Runnable.
 */
public class ComThreadVersao1 implements Runnable {

    private String nomeTarefa;

    public ComThreadVersao1(String nomeTarefa) {
      this.nomeTarefa = nomeTarefa;
    }

    //este método determina o comportamento da thread
    @Override
    public void run() {
        System.out.println(nomeTarefa + " iniciou.");
        for (int i = 1; i <= 10; i++) {
            System.out.println(nomeTarefa + ": " + i);
            try {
/* A chamada ao comando sleep(int seconds) faz com que a thread espere um tempo
determinado para executar novamente. O valor de 1000 equivale a 1 segundo*/
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Erro:" + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Thread th1 = new Thread(new ComThreadVersao1("Tarefa 1: "));
        Thread th2 = new Thread(new ComThreadVersao1("Tarefa 2: "));
        Thread th3 = new Thread(new ComThreadVersao1("Tarefa 3: "));
        Thread th4 = new Thread(new ComThreadVersao1("Tarefa 4: "));
        Thread th5 = new Thread(new ComThreadVersao1("Tarefa 5: "));
        
/* Uma thread se encontra no estado “criada” logo após a instanciação de um objeto Thread. Neste ponto nenhum recurso foi alocado para a thread. 
A única transição válida neste estado é a transição para o estado “em execução”
A thread passa para o estado “em execução” quando o método start() do objeto é chamado. 
Neste ponto a thread pode ficar  “em execução” , se tornar “suspensa” ou se tornar “finalizada”.*/

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
    }
}
