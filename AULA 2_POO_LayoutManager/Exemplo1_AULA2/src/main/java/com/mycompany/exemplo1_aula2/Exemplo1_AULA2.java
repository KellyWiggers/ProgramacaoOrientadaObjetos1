/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exemplo1_aula2;
import javax.swing.*;

/**
 *
 * @author kelly
 */
public class Exemplo1_AULA2 {

    public static void main(String[] args) {
        JFrame janela = new JFrame("Swing Application");
        JButton botao = new JButton("I am a Swing button");
        JLabel texto = new JLabel("Number of button clicks: 0");
        JPanel painel = new JPanel();
        painel.add(botao);
        painel.add(texto);
        janela.getContentPane().add(painel);
        janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        janela.setVisible(true); // Exibe a janela } 

    }
}
