/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.utfpr.sincronizacao;

import br.edu.utfpr.sincronizacao.CaixaEletronico;
import br.edu.utfpr.sincronizacao.Conta;
import br.edu.utfpr.sincronizacao.Empresa;

/**
 *
 * @author kelly
 */
public class AULA9_Sincronizacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setSaldo(1000);
        Empresa empresa = new Empresa(conta);
        Thread empresaThread = new Thread(empresa);
        CaixaEletronico banco = new CaixaEletronico(conta);
        Thread bancoThread = new Thread(banco);
        System.out.printf("Conta: Saldo Inicial: %f\n", conta.getSaldo());
        empresaThread.start();
        bancoThread.start();
        
        try{
            empresaThread.join();
            bancoThread.join();
            System.out.printf("Conta: Saldo Final: %f\n", conta.getSaldo());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
}
