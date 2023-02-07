package br.edu.utfpr.ComThreadVersao2;

/*
Uma thread pode ser implementada de duas formas em Java: Por interface ou por herança
as duas abordagens usam a classe Thread para instanciar, acessar e controlar uma thread. A única diferença é como uma classe 
´para Thread é criada. Por interface (implements)
é possível construir uma thread em qualquer objeto que implementa Runnable.
 */
public class ComThreadVersao2 implements Runnable {

    //criar um atributo do tipo Thread
    private Thread th;

    //iniciando a thread pelo construtor
    //passando o nome da thread  por parêmentro para o objeto Thread
    public ComThreadVersao2(String nomeTarefa) {
        th = new Thread(this, nomeTarefa);
        th.start();
    }

    //este método determina o comportamento da thread
    @Override
    public void run() {
        System.out.println(th.getName() + " iniciou.");
        for (int i = 1; i <= 10; i++) {
            System.out.println(th.getName() + ": " + i);
            try {
// A chamada ao comando sleep(int seconds) faz com que a thread espere um tempo
//determinado para executar novamente. O valor de 1000 equivale a 1 segundo
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Erro:" + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        //as threads foram iniciadas pelo construtor
        ComThreadVersao2 t1 = new ComThreadVersao2("Tarefa 1: ");
        ComThreadVersao2 t2 = new ComThreadVersao2("Tarefa 2: ");
        ComThreadVersao2 t3 = new ComThreadVersao2("Tarefa 3: ");
        ComThreadVersao2 t4 = new ComThreadVersao2("Tarefa 4: ");
        ComThreadVersao2 t5 = new ComThreadVersao2("Tarefa 5: ");

    }
}
