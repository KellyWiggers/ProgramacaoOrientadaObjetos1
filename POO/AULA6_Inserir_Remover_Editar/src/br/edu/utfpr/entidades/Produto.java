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
    private String nomeProduto;
    private String setor;
    private int quantidade;
    private double precoCusto;
    private double precoVenda;
    
    public Produto(){
        
    }
    
    public Produto(int codigo, String nome, String setor, int quantidade, double precoCusto, double precoVenda) {
        this.codigo = codigo;
        this.nomeProduto = nome;
        this.setor = setor;
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nome) {
        this.nomeProduto = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }
    
    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
    
    

    @Override
    public String toString(){
        return "Nome: " + nomeProduto + " Setor: " + setor + " Preco de custo: " + precoCusto + " Quantidade: " + quantidade + "\n";
    }
    
    
    

}
