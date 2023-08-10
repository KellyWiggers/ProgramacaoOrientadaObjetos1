/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.sincronizacao;

/**
 *
 * @author kelly
 */
public class CaixaEletronico implements Runnable{
    private Conta conta;
    
    public CaixaEletronico(Conta conta){
        this.conta = conta;
    }
    
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            conta.saqueValor(1000);
        }
    }
    
}
