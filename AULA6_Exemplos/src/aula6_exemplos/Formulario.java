/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula6_exemplos;

/**
 *
 * @author kelly
 */
public class Formulario {
    
    String nome;
    String telefone;
    int idade;
    double salarioBruto, desconto, salarioLiquido;
    static double taxa_1 = 7.5;
    static double taxa_2 = 15;
    static double taxa_3 = 22.5;
    static double taxa_4 = 27.5;
    static double faixa_1 = 1900;
    static double faixa_2 = 2800;
    static double faixa_3 = 3751;
    static double faixa_4 = 4664;
    
    public Formulario(String nome, String telefone, int idade, double salarioBruto){
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
        this.salarioBruto = salarioBruto;
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

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }
    
    public static double calculaValorDesconto(double salarioBruto){
        if (salarioBruto < faixa_1)
            return salarioBruto;
        else if(salarioBruto < faixa_2)
            return salarioBruto * taxa_1/100;
        else if (salarioBruto < faixa_3)
            return salarioBruto * taxa_2/100;
        else if (salarioBruto < faixa_4)
            return salarioBruto * taxa_3/100;
        else
            return salarioBruto * taxa_4/100;
    }
    
    public static double calculaSalarioLiquido(double salarioBruto, double desconto){
        
            return salarioBruto - desconto;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + "\n" + "Telefone: " + this.telefone + "\n" + "Idade: " + this.idade + "\n" + "Salario Bruto: " + this.salarioBruto + "\n" + "Valor de desconto: " + this.desconto + "\n" + "Salario Liquido: " + this.salarioLiquido;
    }
}
