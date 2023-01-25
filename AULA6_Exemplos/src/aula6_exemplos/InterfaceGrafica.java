/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula6_exemplos;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
/**
 *
 * @author kelly
 */
public class InterfaceGrafica {
    JTextField nome, telefone, idade, salarioBruto;
    JButton botaoCalcularImposto, botaoLimparDados; 
    JTextArea areaResultados;
    JLabel label1, label2, label3, label4, label5;
    JScrollPane scrollArea;
    
    public InterfaceGrafica(){
        //criar o frame
        JFrame janela = new JFrame();
        
        //Criar os componentes
       label1 = new JLabel("Nome: ");
        nome = new JTextField();
        label2 = new JLabel("Telefone: ");
        telefone = new JTextField();
        label3 = new JLabel("Idade: ");
        idade = new JTextField();
        label4 = new JLabel("Salario Bruto: ");
        salarioBruto = new JTextField();
        label5 = new JLabel("Valores calculados: ");
        botaoCalcularImposto = new JButton("Calcular Imposto de Renda");
        botaoLimparDados = new JButton("Limpar dados");   
        areaResultados = new JTextArea(4,4);
        scrollArea = new JScrollPane(areaResultados);
        
        //Para cada painel adicionar os componentes
        JPanel panelDados = new JPanel(new GridLayout(8,1));
        panelDados.add(label1);
        panelDados.add(nome);
        panelDados.add(label2);
        panelDados.add(telefone);
        panelDados.add(label3);
        panelDados.add(idade);
        panelDados.add(label4);
        panelDados.add(salarioBruto);     
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        panelBotoes.add(botaoCalcularImposto);
        panelBotoes.add(botaoLimparDados);
        
        JPanel panelResultados = new JPanel(new BorderLayout());
        panelResultados.add(label5, BorderLayout.NORTH);
        panelResultados.add(scrollArea,BorderLayout.CENTER);
        
        //adicionar os paineis no frame
        janela.add(panelDados, BorderLayout.NORTH);
        janela.add(panelResultados, BorderLayout.CENTER);
        janela.add(panelBotoes, BorderLayout.SOUTH);
        
        //Adicionando os eventos
        botaoCalcularImposto.addActionListener((e) -> imprimirCalculo());
        botaoLimparDados.addActionListener((e) -> limparDados());
        
        //deixar a janela visivel
        janela.pack();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    //Criando os métodos para definir os eventos
    public void imprimirCalculo(){
        StringBuilder sb = new StringBuilder();
        double valorDesconto = Formulario.calculaValorDesconto(Double.parseDouble(salarioBruto.getText()));
        double valorSalarioLiquido = Formulario.calculaSalarioLiquido(Double.parseDouble(salarioBruto.getText()), valorDesconto);
        sb.append("Nome: " ).append(nome.getText()).append("\n").append("Idade: ")
          .append(idade.getText()).append("\n").append("Telefone: ")
          .append(telefone.getText()).append("\n")
          .append("Valor de desconto: ").append(valorDesconto).append("\n").append("Valor do salário líquido: ").append(valorSalarioLiquido);
        
        areaResultados.setText(sb.toString());
        
    }
    
    public void limparDados(){
         nome.setText("");
         idade.setText("");
         telefone.setText("");
         salarioBruto.setText("");
         areaResultados.setText("");
    }
    
   
}
