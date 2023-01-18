package br.edu.utfpr.exemploEventosActionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ExGridLayoutBorderLayoutAulaEventos {

    private final JButton btSalvar;
    private final JButton btFechar;
    private final JTextField tfNome, tfIdade, tfEmail;
    private final JTextArea taSaida, taObs;

    public ExGridLayoutBorderLayoutAulaEventos() {
        JFrame frame = new JFrame("Exemplo BorderLayout e GridLayout");

        JLabel lblNome = new JLabel("Nome");
        tfNome = new JTextField();
        JLabel lblIdade = new JLabel("Idade");
        tfIdade = new JTextField();
        JLabel lblEmail = new JLabel("Email");
        tfEmail = new JTextField();

        JLabel lblObs = new JLabel("Observação");
        taObs = new JTextArea();
        JScrollPane spObs = new JScrollPane(taObs);

        JLabel lblSaida = new JLabel("Saída");
        taSaida = new JTextArea();
        JScrollPane spSaida = new JScrollPane(taSaida);

        btSalvar = new JButton("Salvar");
        JButton btLimpar = new JButton("Limpar");
        btFechar = new JButton("Fechar");

        JPanel panelDados = new JPanel(new GridLayout(6, 1));
        panelDados.add(lblNome);
        panelDados.add(tfNome);
        panelDados.add(lblIdade);
        panelDados.add(tfIdade);
        panelDados.add(lblEmail);
        panelDados.add(tfEmail);

        JPanel panelObs = new JPanel(new BorderLayout());
        panelObs.add(lblObs, BorderLayout.NORTH);
        panelObs.add(spObs, BorderLayout.CENTER);

        JPanel panelSaida = new JPanel(new BorderLayout());
        panelSaida.add(lblSaida, BorderLayout.NORTH);
        panelSaida.add(spSaida, BorderLayout.CENTER);

        JPanel panelCentro = new JPanel(new GridLayout(2, 1));
        panelCentro.add(panelObs);
        panelCentro.add(panelSaida);

        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        panelBotoes.add(btSalvar);
        panelBotoes.add(btLimpar);
        panelBotoes.add(btFechar);

        frame.add(panelDados, BorderLayout.NORTH);
        frame.add(panelCentro, BorderLayout.CENTER);
        frame.add(panelBotoes, BorderLayout.SOUTH);
        
        
////CLASSE INTERNA
//        Handler handler = new Handler();
//        btSalvar.addActionListener(handler);
//        btFechar.addActionListener(handler);

////CLASSE ANONIMA
//         btSalvar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Olá");
//            }
//        });

//LAMBDA
       
        btSalvar.addActionListener((e) -> imprimir());

        btFechar.addActionListener((e) -> System.exit(0));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void imprimir() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: " ).append(tfNome.getText()).append("\n")
          .append(tfIdade.getText()).append("\n")
          .append(tfEmail.getText()).append("\n")
          .append(taObs.getText());
        
        taSaida.setText(sb.toString());
    }

    public static void main(String[] args) {
        new ExGridLayoutBorderLayoutAulaEventos();
    }

//   public class Handler implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() == btSalvar) {
//                JOptionPane.showMessageDialog(null, "Olá");
//
//            } else if (e.getSource() == btFechar) {
//               System.exit(0);
//            }
//        }
//
//    }
}
