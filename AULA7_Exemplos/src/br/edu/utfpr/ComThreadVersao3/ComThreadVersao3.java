/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.ComThreadVersao3;

public class ComThreadVersao3 {
    private String nomeTarefa;

    public ComThreadVersao3(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    //passando runnable no momento de criar a thread
    public void criarThread() {
        Thread th1 = new Thread(() -> {
            System.out.println(nomeTarefa + " iniciou.");
            for (int i = 1; i <= 10; i++) {
                System.out.println(nomeTarefa + ": " + i);
                try {
// A chamada ao comando sleep(int seconds) faz com que a thread espere um tempo
//determinado para executar novamente. O valor de 1000 equivale a 1 segundo
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    System.out.println("Erro:" + ex.getMessage());
                }
            }
        });
        th1.start();
    }

    public static void main(String[] args) {
        //criando os objetos
        ComThreadVersao3 th1 = new ComThreadVersao3("Tarefa 1: ");
        ComThreadVersao3 th2 = new ComThreadVersao3("Tarefa 2: ");
        ComThreadVersao3 th3 = new ComThreadVersao3("Tarefa 3: ");
        ComThreadVersao3 th4 = new ComThreadVersao3("Tarefa 4: ");
        ComThreadVersao3 th5 = new ComThreadVersao3("Tarefa 5: ");
        th1.criarThread();
        th2.criarThread();
        th3.criarThread();
        th4.criarThread();
        th5.criarThread();
    }
}
