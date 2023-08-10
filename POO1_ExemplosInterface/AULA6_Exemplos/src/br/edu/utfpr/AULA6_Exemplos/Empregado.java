/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.AULA6_Exemplos;

/**
 *
 * @author kelly
 */
public class Empregado {
    
    String nome;
    String telefone, cargo;
    int idade;
    double salarioBruto, gratificacao, salarioLiquido;
    static final double GRATIFICACAO_GERENTE = 20;
    static final double GRATIFICACAO_SECRETARIO = 15;
    static final double GRATIFICACAO_ASSISTENTE = 10;
    
    public Empregado(String nome, String telefone, int idade, double salarioBruto, String cargo){
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
        this.salarioBruto = salarioBruto;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getGratificacao() {
        return gratificacao;
    }

    public void setGratificacao(double gratificacao) {
        this.gratificacao = gratificacao;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }
    
    public double calculaValorGratificacao(double salarioBruto, String cargo){
        if (cargo == "Gerente")
            this.gratificacao = salarioBruto * (GRATIFICACAO_GERENTE/100);
        else if (cargo == "Secretário")
             this.gratificacao = salarioBruto * (GRATIFICACAO_SECRETARIO/100);
        else if (cargo == "Assistente")
            this.gratificacao = salarioBruto * (GRATIFICACAO_ASSISTENTE/100);
        return this.gratificacao;
    }
    
    
    
    public double calculaSalarioLiquido(double salarioBruto, String cargo){
            this.gratificacao = calculaValorGratificacao(salarioBruto, cargo);
            this.salarioLiquido = salarioBruto + this.gratificacao;
            return this.salarioLiquido;    
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + "\n" + "Telefone: " + this.telefone + "\n" + "Idade: " + this.idade + "\n" + "Salario Bruto: " + this.salarioBruto +
                "\n" + "Valor de gratificação: " + calculaValorGratificacao(salarioBruto, cargo) + "\n" + "Salario Liquido: " + calculaSalarioLiquido(salarioBruto,cargo);
    }
}
