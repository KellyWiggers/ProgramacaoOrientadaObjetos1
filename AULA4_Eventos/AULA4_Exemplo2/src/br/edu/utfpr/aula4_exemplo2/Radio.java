package br.edu.utfpr.aula4_exemplo2;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Radio {

    JLabel label;
    JRadioButton rbWin, rbMac, rbLinux;

    public Radio() {
        JFrame frame = new JFrame("Exemplo de RadioButton");
        frame.setLayout(new FlowLayout());

        rbWin = new JRadioButton("Windows");
        frame.add(rbWin);

        rbLinux = new JRadioButton("Linux");
        frame.add(rbLinux);

        rbMac = new JRadioButton("Mac OS");
        frame.add(rbMac);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbWin);
        bg.add(rbLinux);
        bg.add(rbMac);

        label = new JLabel(" Item selecionado ");
        frame.add(label);

//        Handler handler = new Handler();
//        rbWin.addItemListener(handler);
//        rbLinux.addItemListener(handler);
//        rbMac.addItemListener(handler);

        rbLinux.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                label.setText("A opção Linux foi selecionada");
            }
        });

        rbWin.addItemListener((ItemEvent e) -> label.setText("A opção Windows foi selecionada"));
        rbMac.addItemListener((ItemEvent e) -> label.setText("A opção Mac foi selecionada"));

        frame.setSize(350, 100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public class Handler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (rbWin.isSelected()) {
                label.setText("A opção Windows foi selecionada");
            } else if (rbLinux.isSelected()) {
                label.setText("A opção Linux foi selecionada");
            } else {
                label.setText("A opção Mac foi selecionada");
            }
        }

    }

    public static void main(String[] args) {
        new Radio();
    }

}
