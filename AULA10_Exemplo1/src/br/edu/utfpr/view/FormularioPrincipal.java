/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.utfpr.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kelly
 */
public class FormularioPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FormularioPrincipal
     */
    public FormularioPrincipal() {
        initComponents();
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdJanela = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuRoupas = new javax.swing.JMenuItem();
        menuCalcados = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jdJanelaLayout = new javax.swing.GroupLayout(jdJanela);
        jdJanela.setLayout(jdJanelaLayout);
        jdJanelaLayout.setHorizontalGroup(
            jdJanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jdJanelaLayout.setVerticalGroup(
            jdJanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        jMenu1.setText("Cadastrar");

        menuRoupas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/32x32/estoque (Custom).png"))); // NOI18N
        menuRoupas.setText("Roupas");
        menuRoupas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRoupasActionPerformed(evt);
            }
        });
        jMenu1.add(menuRoupas);

        menuCalcados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/32x32/estoque (Custom).png"))); // NOI18N
        menuCalcados.setText("Calçados");
        jMenu1.add(menuCalcados);
        jMenu1.add(jSeparator1);

        menuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/32x32/Log-Out-icon (Custom).png"))); // NOI18N
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenu1.add(menuSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdJanela)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdJanela)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(this, 
            "Tem certeza que deseja encerrar a aplicação?", 
            "Sair", JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE);
        if(sair == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuRoupasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRoupasActionPerformed
       CadastroRoupas cdRoupas = new CadastroRoupas();
       jdJanela.add(cdRoupas);
       cdRoupas.setVisible(true);
    }//GEN-LAST:event_menuRoupasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormularioPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JDesktopPane jdJanela;
    private javax.swing.JMenuItem menuCalcados;
    private javax.swing.JMenuItem menuRoupas;
    private javax.swing.JMenuItem menuSair;
    // End of variables declaration//GEN-END:variables
}
