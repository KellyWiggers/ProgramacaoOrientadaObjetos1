package br.edu.utfpr.view;

import br.edu.utfpr.Thread.BarraDeProgresso;
import br.edu.utfpr.entidade.Pessoa;
import br.edu.utfpr.view.FrmDados;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class DlDados extends JDialog{

    //criar um atributo do tipo Thread
    private JButton btEnviar;
    private JProgressBar pb;
    private JProgressBar pb1;
    private JLabel lbExibirNome;
    private JLabel lbExibirIdade;
    private JLabel lbExibirEmail;
    
    public DlDados(JFrame parent, boolean modal) {
        super.setTitle("Enviar dados");
        super.setLayout(new BorderLayout());
        JLabel lbNome = new JLabel("Nome: ");
        lbExibirNome = new JLabel("...");
        JLabel lbIdade = new JLabel("Idade: ");
        lbExibirIdade = new JLabel("... ");
        JLabel lbEmail = new JLabel("E-mail: ");
        lbExibirEmail = new JLabel("... ");

        JPanel pnDados = new JPanel(new GridLayout(4, 2));
        btEnviar = new JButton("Enviar");
        
        pb = new JProgressBar(JProgressBar.HORIZONTAL, 1, 100);
        //Adiciona propriedade a barra de progresso
        pb.setStringPainted(true);
        pb.setForeground(new Color(50, 200, 20));
        
        pb1 = new JProgressBar(JProgressBar.HORIZONTAL, 1, 100);
        //Adiciona propriedade a barra de progresso
        pb1.setStringPainted(true);
        pb1.setForeground(new Color(50, 200, 20));
       
        pnDados.add(lbNome);
        pnDados.add(lbExibirNome);
        pnDados.add(lbIdade);
        pnDados.add(lbExibirIdade);
        pnDados.add(lbEmail);
        pnDados.add(lbExibirEmail);

        JPanel pnProgresso = new JPanel(new GridLayout(3, 1));
        pnProgresso.add(btEnviar);
        pnProgresso.add(pb);
        pnProgresso.add(pb1);
        
        btEnviar.addActionListener((e) -> enviarDados());

        super.add(pnDados, BorderLayout.CENTER);
        super.add(pnProgresso, BorderLayout.SOUTH);

        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setSize(300, 200);
        super.setVisible(true);

    }
    
    public void copiarDados(Pessoa pessoa){
        lbExibirNome.setText(pessoa.getNome());
        lbExibirIdade.setText(Integer.toString(pessoa.getIdade()));
        lbExibirEmail.setText(pessoa.getEmail());
        
    }
   
    public void enviarDados(){
        new Thread(new BarraDeProgresso(pb, lbExibirNome.getText())).start();
        new Thread(new BarraDeProgresso(pb1, lbExibirEmail.getText())).start();
        
    }
    
   

}

    