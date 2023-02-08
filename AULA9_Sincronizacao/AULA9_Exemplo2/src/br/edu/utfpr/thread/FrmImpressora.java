/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.thread;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author andre
 */
public class FrmImpressora extends JFrame {

    private JButton btPausa;
    private JButton btIniciar;
    private JButton btParar;
    private JTextArea taSaida;
    private ThreadImpressora threadImpressora;
    private Thread thread;

    public FrmImpressora() {
        btIniciar = new JButton("Iniciar");
        btPausa = new JButton("Pausar");
        btParar = new JButton("Parar");
        taSaida = new JTextArea();
        JScrollPane sp = new JScrollPane(taSaida);
        JPanel pnBotoes = new JPanel(new GridLayout(1, 1));
        pnBotoes.add(btIniciar);
        pnBotoes.add(btPausa);
        pnBotoes.add(btParar);

        btPausa.setEnabled(false);
        btParar.setEnabled(false);

        this.add(pnBotoes, BorderLayout.NORTH);
        this.add(sp, BorderLayout.CENTER);
        threadImpressora = new ThreadImpressora(taSaida);

        btIniciar.addActionListener(e -> {
            threadImpressora.setParar(false);
            if (thread == null || thread.getState() == Thread.State.TERMINATED) {
                thread = new Thread(threadImpressora);
                thread.start();
                btPausa.setEnabled(true);
                btParar.setEnabled(true);
            } else if (thread.isAlive()) {
                taSaida.append("Thread está em execução.");
            }
        });

        btPausa.addActionListener(e -> {
            threadImpressora.setParar(false);
            if ("Pausar".equals(btPausa.getText())) {
                btPausa.setText("Continuar");
                threadImpressora.setPausar(true);
            } else {
                btPausa.setText("Pausar");
                threadImpressora.setPausar(false);
            }

            if (thread.getState() == Thread.State.TERMINATED) {
                btPausa.setEnabled(false);
                btPausa.setText("Pausar");
            }
        });

        btParar.addActionListener(e -> {
            threadImpressora.setParar(true);
            btParar.setEnabled(false);
            if ("Continuar".equals(btPausa.getText())) {
                btPausa.setText("Pausar");
                threadImpressora.setPausar(false);
            }
            btPausa.setEnabled(false);

        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 480);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FrmImpressora();

    }

}
