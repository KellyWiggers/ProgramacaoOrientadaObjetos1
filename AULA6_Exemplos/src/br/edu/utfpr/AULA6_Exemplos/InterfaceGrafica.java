/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.AULA6_Exemplos;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import javax.swing.*;
/**
 *
 * @author kelly
 */
public class InterfaceGrafica {
    JTextField nome, telefone, idade, salarioBruto;
    JButton botaoCalcularSalario, botaoLimparDados; 
    JTextArea areaResultados;
    JLabel label1, label2, label3, label4, label5;
    JScrollPane scrollArea;
    JComboBox comboPessoa;
    
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
        comboPessoa = new JComboBox();
        comboPessoa.addItem("Assistente");
        comboPessoa.addItem("Secretário");
        comboPessoa.addItem("Gerente");
        botaoCalcularSalario = new JButton("Calcular Salário Líquido");
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
        panelDados.add(comboPessoa);
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        panelBotoes.add(botaoCalcularSalario);
        panelBotoes.add(botaoLimparDados);
        
        JPanel panelResultados = new JPanel(new BorderLayout());
        panelResultados.add(label5, BorderLayout.NORTH);
        panelResultados.add(scrollArea,BorderLayout.CENTER);
        
        //adicionar os paineis no frame
        janela.add(panelDados, BorderLayout.NORTH);
        janela.add(panelResultados, BorderLayout.CENTER);
        janela.add(panelBotoes, BorderLayout.SOUTH);
        
        //Adicionando os eventos
        comboPessoa.addItemListener((e) -> itemSelecionado(e));
        botaoCalcularSalario.addActionListener((e) -> imprimirCalculo());
        botaoLimparDados.addActionListener((e) -> limparDados());
        
        //deixar a janela visivel
        janela.pack();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void itemSelecionado(ItemEvent e){
		// Quando for selecionado um item
		if(e.getStateChange() == ItemEvent.SELECTED){
			if(e.getItem()== "Gerente")
                            areaResultados.setText("Voce selecionou gerente");
                        else
                            areaResultados.setText("");
		}
	}
    //Criando os métodos para definir os eventos
    public void imprimirCalculo(){
        Empregado empregado = new Empregado(
                nome.getText(),
                telefone.getText(),
                Integer.parseInt(idade.getText()),
                Double.parseDouble(salarioBruto.getText()),
                comboPessoa.getSelectedItem().toString()
        );
        areaResultados.setText(empregado.toString());
        
    }
    
    public void limparDados(){
         nome.setText("");
         idade.setText("");
         telefone.setText("");
         salarioBruto.setText("");
         areaResultados.setText("");
    }
}
