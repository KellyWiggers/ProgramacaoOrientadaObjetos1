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
    int codigo;
    String setor;
    String nome;
    int quantidade;
    double precoCusto;
    double precoVenda;
    double margemLucro = 0.95;
    
    public Produto(){
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public double getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(double margemLucro) {
        this.margemLucro = margemLucro;
    }
   
     
    public double calcularPrecoVenda(double precoCusto){
        this.precoVenda = this.precoCusto + (this.precoCusto * margemLucro);
        return this.precoVenda;
    }
    
    @Override
    public String toString(){
        return "Código: " + this.codigo + "\n" + 
                "Setor: " + this.setor + "\n" + 
                "Quantidade: " + this.quantidade + "\n" + 
                "Preço de custo: " + this.precoCusto + "\n" +
                "Preço de Venda: " + this.precoVenda;
                        
    }
}
