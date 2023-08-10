/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.utfpr.exemploEventosItemListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
/**
 *
 * @author kelly
 */
public class ExemploCheckBox {
    JTextArea selecao, textoSelecionado;
    JCheckBox escolha1;
    JCheckBox escolha2;
    
    public ExemploCheckBox (){    
        JFrame janela= new JFrame("CheckBox Exepmlo"); 
       
        selecao = new JTextArea("Seleção:");  
        textoSelecionado = new JTextArea("   ");  
        escolha1 = new JCheckBox("C++");    
        escolha2 = new JCheckBox("Java");
        JPanel painel = new JPanel();
        painel.setBackground(Color.BLUE);
        painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS ));
        painel.add(escolha1); 
        painel.add(escolha2);  
        painel.add(selecao);  
        painel.add(textoSelecionado);
        janela.getContentPane().add(painel);
        janela.pack(); 
        janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        janela.setVisible(true);
       
    
        escolha1.addItemListener((ItemEvent e) -> {
            if(escolha1.isSelected()){
                selecao.setText(escolha1.getText() + " selecionado. ");
            }else{
                selecao.setText(escolha1.getText() + " foi desmarcado. ");
                }
            textoSelecionado.setText(opSelecionada());
        });
    
        escolha2.addItemListener((ItemEvent e) -> {
            if(escolha2.isSelected()){
                selecao.setText(escolha2.getText() + " selecionado. ");
            }else{
                selecao.setText(escolha2.getText() + " foi desmarcado. ");
            }
            textoSelecionado.setText(opSelecionada());
        });
          
    }
    
public String opSelecionada() {
    String opcao = "OP selecionada: ";
        if (escolha1.isSelected()) {
            opcao += " C++";
        }

        if (escolha2.isSelected()) {
            opcao += " Java";
        }

        return opcao;
    }
   
public static void main(String args[])    
{    
    new ExemploCheckBox();    
}    
    
}
