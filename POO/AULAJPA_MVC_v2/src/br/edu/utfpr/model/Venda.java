/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author kelly
 */

@Entity
@Table(name = "vendas")
public class Venda implements Serializable{
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int codigo;
    
    @Column
    private int quantidade;

    @Column
    private double preco_total;
    
    @ManyToOne(cascade = CascadeType.DETACH) // toda ação que tiver aqui é executada no banco
    @JoinColumn(name = "codigo_funcionario")
    private Funcionario funcionario;
    
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "codigo_produto")
    private Produto produto;

    
    public Venda() {
   
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoTotal() {
        return preco_total;
    }

    public void setPrecoTotal(double preco_total) {
        this.preco_total = preco_total;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
  
    
    
}
