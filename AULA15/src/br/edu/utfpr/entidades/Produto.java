/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.entidades;

/**
 *
 * @author kelly
 */
public class Produto {
    private int codigo;
    private String produto;
    private double preco;
    private int quantidade;

    public Produto(int codigo, String produto, double preco, int quantidade) {
        this.codigo = codigo;
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int id) {
        this.codigo = id;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String Produto) {
        this.produto = Produto;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    } 
}

