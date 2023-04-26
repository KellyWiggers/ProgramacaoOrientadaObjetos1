/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.entidades;

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

    public Funcionario(int codigoFuncionario, String nomeFuncionario, String funcaoFuncionario, double salarioFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.funcaoFuncionario = funcaoFuncionario;
        this.salarioBrutoFuncionario = salarioFuncionario;
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

    public double getSalarioFuncionario() {
        return salarioBrutoFuncionario;
    }

    public void setSalarioFuncionario(double salarioFuncionario) {
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

    public void calculaSalarioLiquidoFuncionario() {
        this.salarioLiquidoFuncionario = this.salarioBrutoFuncionario + this.comissao;
    }
    
    
}
