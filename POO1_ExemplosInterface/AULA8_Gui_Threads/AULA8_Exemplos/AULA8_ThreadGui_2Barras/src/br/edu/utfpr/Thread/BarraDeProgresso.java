/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.Thread;

import javax.swing.JProgressBar;

/**
 *
 * @author kelly
 */
public class BarraDeProgresso implements Runnable {
    private JProgressBar barra;
    String nome;

    public BarraDeProgresso(JProgressBar barra, String nome) {
        this.barra = barra;
        this.nome = nome;
        
    }
    
    
    
     @Override
        public void run() {
            for (int i = 0; i <= nome.length(); i++) {
                barra.setValue(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    System.out.println("Erro:" + ex.getMessage());
                }
            }
            
        }
}
