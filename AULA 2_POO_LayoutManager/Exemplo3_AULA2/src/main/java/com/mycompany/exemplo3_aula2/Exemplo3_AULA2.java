/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exemplo3_aula2;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author kelly
 */
public class Exemplo3_AULA2 {

    public static void main(String[] args) {
        JFrame janela = new JFrame();
        JPanel painel=new JPanel(new BorderLayout( ));
        JButton b1=new JButton("1");
        JButton b2=new JButton("2");
        JButton b3=new JButton("3");
        JButton b4=new JButton("4");
        JButton b5=new JButton("5");
        painel.add(b1,BorderLayout.NORTH);
        painel.add(b2,BorderLayout.EAST);
        painel.add(b3,BorderLayout.SOUTH);
        painel.add(b4,BorderLayout.WEST);
        painel.add(b5,BorderLayout.CENTER);
        janela.getContentPane().add(painel);
        janela.setVisible(true); // Exibe a janela }

    }
}
