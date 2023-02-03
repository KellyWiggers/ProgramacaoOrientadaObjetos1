package br.edu.utfpr.semThread;

/*
 */
public class SemThread  {

    private String nomeTarefa;
    private Thread th;

    public SemThread(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public void imprimirTarefa() {
        System.out.println(nomeTarefa + " iniciou.");
        for (int i = 1; i <= 10; i++) {
            System.out.println(nomeTarefa+ ": " + i);
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
        SemThread t1 = new SemThread("Tarefa 1: ");
        SemThread t2 = new SemThread("Tarefa 2: ");
        SemThread t3 = new SemThread("Tarefa 3: ");
        SemThread t4 = new SemThread("Tarefa 4: ");
        SemThread t5 = new SemThread("Tarefa 5: ");
        
        t1.imprimirTarefa();
        t2.imprimirTarefa();
        t3.imprimirTarefa();
        t4.imprimirTarefa();
        t5.imprimirTarefa();
    }
}
