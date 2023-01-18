/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exemplo2_aula2;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author kelly
 */
public class Exemplo2_AULA2 {

    public static void main(String[] args) {
        JFrame janela = new JFrame();
        JPanel painel = new JPanel();
        //para layout flow
        painel.setLayout(new FlowLayout()); 
        //para layout grid
        //painel.setLayout(new GridLayout(2,2));
        //para boxlayout
        //painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS ));
        painel.add(new JButton("1"));
        painel.add(new JTextField(9));
        painel.add(new JButton("dois"));
        painel.add(new JButton("três"));
        janela.getContentPane().add(painel);
        janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        janela.setVisible(true); // Exibe a janela } 

        
    }
}
