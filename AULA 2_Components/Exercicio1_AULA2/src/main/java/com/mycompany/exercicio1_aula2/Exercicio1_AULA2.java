/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exercicio1_aula2;
import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;
/**
 *
 * @author kelly
 */
public class Exercicio1_AULA2 {

    public static void main(String[] args) {
        JFrame janela = new JFrame();
        JPanel painel=new JPanel();
        JLabel j1 = new JLabel("Cliente");
        JCheckBox check = new JCheckBox("Ativo");
        JLabel j2 = new JLabel("Nome");
        JTextField texto = new JTextField("Insira o Nome");
        JLabel j3 = new JLabel("Gênero");
        JComboBox cbGenero = new JComboBox();
        cbGenero.addItem("Masculino");
        cbGenero.addItem("Feminino");
        JLabel j4 = new JLabel("Data");
        MaskFormatter mk = null;
        try {
            mk = new MaskFormatter("##/##/####");
            mk.setPlaceholderCharacter('_');
        }
        catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +
            ex.getMessage());
        }
        JFormattedTextField ftfData = new JFormattedTextField(mk);
        ftfData.setColumns(10);
        JLabel j5 = new JLabel("Observação");
        JTextArea areaObservacao = new JTextArea("Observação");
        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoCancelar = new JButton("Cancelar");
        painel.add(j1);
        painel.add(check);
        painel.add(j2);
        painel.add(texto);
        painel.add(j3);
        painel.add(cbGenero);
        painel.add(j4);
        painel.add(ftfData);
        painel.add(j5);
        painel.add(areaObservacao);
        painel.add(botaoCadastrar);
        painel.add(botaoCancelar);        
        janela.getContentPane().add(painel);
        janela.pack();
        janela.setVisible(true); // Exibe a janela }
        
    }
}
