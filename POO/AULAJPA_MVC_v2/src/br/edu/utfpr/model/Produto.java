package br.edu.utfpr.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kelly
 */

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int codigo;
    @Column
    private String nome;
    @Column
    private String setor;
    @Column
    private int quantidade;
    @Column
    private double preco_custo;
    @Column
    private double preco_venda;
    
    @OneToMany(mappedBy = "produto")
    @JoinColumn(name = "codigo_produto", referencedColumnName = "codigo")
    private List<Venda> vendas;
    
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

    public double getPreco_Custo() {
        return preco_custo;
    }

    public void setPreco_Custo(double precoCusto) {
        this.preco_custo = precoCusto;
    }
    
    public double getPreco_Venda() {
        return preco_venda;
    }

    public void setPreco_Venda(double precoVenda) {
        this.preco_venda = precoVenda;
    }
    
    

    @Override
    public String toString(){
        return "Código:" + codigo + " Nome: " + nome + " Setor: " + setor + " Preco de custo: " + preco_custo + " Quantidade: " + quantidade + "\n";
    }
    
}
