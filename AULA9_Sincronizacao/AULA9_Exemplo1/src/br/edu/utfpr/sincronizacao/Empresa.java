/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.sincronizacao;

/**
 *
 * @author kelly
 */
public class Empresa implements Runnable {
    private Conta conta;
    
    public Empresa(Conta conta){
        this.conta = conta;
    }
    
    @Override
    public void run(){
        for(int i = 0; i<10; i++){
            conta.depositaValor(1000);
        }
    }
}
