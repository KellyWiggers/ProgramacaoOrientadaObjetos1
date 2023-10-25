/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.model;

/**
 *
 * @author kelly
 */
public class Funcionario {
    
    int codigoFuncionario;
    String nomeFuncionario;
    String funcaoFuncionario;
    double salarioBrutoFuncionario;
    double comissao;
    double salarioLiquidoFuncionario;

    public Funcionario(int codigoFuncionario, String nomeFuncionario, String funcaoFuncionario, double salarioFuncionario, double comissao) {
        this.codigoFuncionario = codigoFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.funcaoFuncionario = funcaoFuncionario;
        this.salarioBrutoFuncionario = salarioFuncionario;
        this.comissao = comissao;
    }
    
    public Funcionario(){
        
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getFuncaoFuncionario() {
        return funcaoFuncionario;
    }

    public void setFuncaoFuncionario(String funcaoFuncionario) {
        this.funcaoFuncionario = funcaoFuncionario;
    }

    public double getSalarioBrutoFuncionario() {
        return salarioBrutoFuncionario;
    }

    public void setSalarioBrutoFuncionario(double salarioFuncionario) {
        this.salarioBrutoFuncionario = salarioFuncionario;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    
    public double getSalarioLiquidoFuncionario() {
        return salarioLiquidoFuncionario;
    }
    
    public void setSalarioLiquidoFuncionario(double salarioLiquido){
        this.salarioLiquidoFuncionario = salarioLiquido;
    }

    public double calculaSalarioLiquidoFuncionario() {
        return this.salarioBrutoFuncionario + this.comissao;
    }
    
    
}