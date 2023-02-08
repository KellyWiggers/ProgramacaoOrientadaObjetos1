/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.sincronizacao;

/**
 *
 * @author kelly
 */
public class Conta {
    double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public synchronized void depositaValor(double valor){
        double temp = saldo;
        try{
            Thread.sleep(10);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        temp+=valor;
        saldo = temp;
    }
    
    public synchronized void saqueValor(double valor){
        double temp = saldo;
        try{
            Thread.sleep(10);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        temp-=valor;
        saldo = temp;
    }
    
}
