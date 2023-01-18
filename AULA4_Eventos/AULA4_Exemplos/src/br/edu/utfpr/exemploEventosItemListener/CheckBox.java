/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.exemploEventosItemListener;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBox {
    
    JLabel lblChange, lblSOSuportado;
    JCheckBox cbWin, cbLinux, cbMac;
    
    public CheckBox() {
        JFrame frame = new JFrame("Exemplo Checkbox");
        
        frame.setLayout(new GridBagLayout());

        //A definição de onde deve ser colocado cada componente é feita por meio de restrições fornecidas pela
        //classe GridBagConstraints passadas ao método add de um container.
        GridBagConstraints cons = new GridBagConstraints();
        //especifica a forma como o componente deve ser redimensionado para ocupar o espaço da célula, caso necessário
        cons.fill = GridBagConstraints.BOTH;
        JPanel panelBotoes = new JPanel(new GridBagLayout());
        panelBotoes.setBackground(Color.yellow);
        
        cbWin = new JCheckBox("Windows");
        cons.gridy = 0;
        panelBotoes.add(cbWin, cons);
        
        cbLinux = new JCheckBox("Linux");
        cons.gridy = 1;
        panelBotoes.add(cbLinux, cons);
        
        cbMac = new JCheckBox("Mac Os");
        cons.gridy = 2;
        panelBotoes.add(cbMac, cons);
        
        cons.gridx = 0;
        frame.add(panelBotoes, cons);
        
        JPanel panelLabel = new JPanel(new GridBagLayout());
        lblChange = new JLabel("Selecione o SO suportado: ");
        cons.gridy = 0;
        panelLabel.add(lblChange, cons);
        
        lblSOSuportado = new JLabel();
        cons.gridy = 1;
        panelLabel.add(lblSOSuportado, cons);
        
        frame.add(panelBotoes, cons);
        cons.gridx = 1;
        cons.weightx = 0.75;
        frame.add(panelLabel, cons);

//        HandlerCb handlerCb = new HandlerCb();
//        cbWin.addItemListener(handlerCb);
//        cbLinux.addItemListener(handlerCb);
//        cbMac.addItemListener(handlerCb);

        cbWin.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(cbWin.isSelected()){
                   lblChange.setText(cbWin.getText() + " selecionado. ");
                }else{
                 lblChange.setText(cbWin.getText() + " foi desmarcado. ");
                }
                 lblSOSuportado.setText(opSelecionada());
            }
        });
        
         cbLinux.addItemListener((ItemEvent e) -> {
             if(cbLinux.isSelected()){
                 lblChange.setText(cbLinux.getText() + " selecionado. ");
             }else{
                 lblChange.setText(cbLinux.getText() + " foi desmarcado. ");
             }
             lblSOSuportado.setText(opSelecionada());
        });

          cbMac.addItemListener((ItemEvent e) -> {
             if(cbLinux.isSelected()){
                 lblChange.setText(cbMac.getText() + " selecionado. ");
             }else{
                 lblChange.setText(cbMac.getText() + " foi desmarcado. ");
             }
             lblSOSuportado.setText(opSelecionada());
        });

        frame.setSize(340, 140);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public class HandlerCb implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox cb = (JCheckBox) e.getItem();

            if (cb.isSelected()) {
                lblChange.setText(cb.getText() + " selecionado. ");
            } else {
                lblChange.setText(cb.getText() + " desmarcado.");
            }

            lblSOSuportado.setText(opSelecionada());
        }

    }

    public String opSelecionada() {
        String opcao = "SO Selecionado: ";
        if (cbWin.isSelected()) {
            opcao += " Windows";
        }

        if (cbLinux.isSelected()) {
            opcao += " Linux";
        }

        if (cbMac.isSelected()) {
            opcao += " Mac";
        }
        return opcao;
    }
    
    public static void main(String[] args) {
        new CheckBox();
    }
    
}
