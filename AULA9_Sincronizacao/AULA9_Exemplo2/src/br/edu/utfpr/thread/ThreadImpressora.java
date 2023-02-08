/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.thread;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Kelly
 */
public class ThreadImpressora implements Runnable{

    private JTextArea taSaida;
    private boolean pausar=false;
    private boolean parar = false;

    public ThreadImpressora() {
    }

    
    public ThreadImpressora(JTextArea taSaida) {
        this.taSaida = taSaida;
    }
    
    private synchronized void pausar(){
      while(pausar){
          try {
              wait();
          } catch (InterruptedException ex) {
          }
      }
    }

    public synchronized void setPausar(boolean pausar) {
        this.pausar = pausar;
        if(!this.pausar){
           notifyAll();
        }
    }

    public void setParar(boolean parar) {
        this.parar = parar;
    }
    
    
    

    @Override
    public void run() {
        
        for (int i = 1; i <= 10; i++) {
            try {
                pausar();
                taSaida.append("linha " + i + "\n");
                Thread.sleep(1000);
                if(parar || i==10){
                   return;
                }
            } catch (InterruptedException ex) {
            }
        }
    }
    
}
