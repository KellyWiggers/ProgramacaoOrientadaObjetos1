/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.entidades;

import java.io.Serializable;

/**
 *
 * @author kelly
 */
public class Produto implements Serializable{
    //private static final long serialVersionUID = 3;
    private String nomeProduto;
    private double valorUnitario;
    private int quantidade;
    
    
    public Produto(String nome, double valor, int quantidade){
        this.nomeProduto = nome;
        this.valorUnitario = valor;
        this.quantidade = quantidade;
    }
    

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public String toString(){
        StringBuilder texto = new StringBuilder();
        texto.append("\nProduto: " + this.nomeProduto);
        texto.append("\nValor unitário: " + this.valorUnitario);
        texto.append("\nQuantidade: " + this.quantidade);
        
        return texto.toString();
    }
    
    
}
