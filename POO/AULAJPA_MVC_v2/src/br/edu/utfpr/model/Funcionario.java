/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kelly
 */

@Entity
@Table(name = "funcionarios")
public class Funcionario implements Serializable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int codigo;
    @Column
    private String nome;
    @Column
    private String funcao_funcionario;
    @Column
    private double salario_bruto;
    @Column
    private double comissao;
    @Column
    private double salario_liquido;
    
    @OneToMany(mappedBy = "funcionario")
    @JoinColumn(name = "codigo_funcionario", referencedColumnName = "codigo")
    private List<Venda> vendas;

    public Funcionario(int codigoFuncionario, String nomeFuncionario, String funcaoFuncionario, double salarioFuncionario, double comissao) {
        this.codigo = codigoFuncionario;
        this.nome = nomeFuncionario;
        this.funcao_funcionario = funcaoFuncionario;
        this.salario_bruto = salarioFuncionario;
        this.comissao = comissao;
    }
    
    public Funcionario(){
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFuncao_funcionario() {
        return funcao_funcionario;
    }

    public void setFuncao_funcionario(String funcao_funcionario) {
        this.funcao_funcionario = funcao_funcionario;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getSalario_liquido() {
        return salario_liquido;
    }

    public void setSalario_liquido(double salario_liquido) {
        this.salario_liquido = salario_liquido;
    }

    
    public double calculaSalarioLiquidoFuncionario() {
        return this.salario_bruto + this.comissao;
    }
    
}
