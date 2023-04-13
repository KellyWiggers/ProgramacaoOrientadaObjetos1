/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.utfpr.arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author kelly
 */
public class FormArquivo extends javax.swing.JFrame {
    
    File file = new File("C:\\Users\\kelly\\Documents\\GitHub\\ProgramacaoOrientadaObjetos1\\AULA11_ManipulacaoArquivos\\documento.txt");
    FileWriter fw;
    BufferedWriter bw;
    
    public FormArquivo() {
        initComponents();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        salvar = new javax.swing.JButton();
        lerArquivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        lerArquivo.setText("Leitura");
        lerArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lerArquivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(salvar)
                        .addGap(32, 32, 32)
                        .addComponent(lerArquivo)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvar)
                    .addComponent(lerArquivo))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        salvarArquivo();
    }//GEN-LAST:event_salvarActionPerformed

    private void lerArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lerArquivoActionPerformed
       lerArquivo(file);
    }//GEN-LAST:event_lerArquivoActionPerformed

    
    public void salvarArquivo(){
        if(!file.exists()){
            gravar(file);
         }
        else{
            int opcao = JOptionPane.showConfirmDialog(this, "O arquivo espcificado já existe. " + 
                    "Deseja substituí-lo?", "Arquivo", JOptionPane.YES_NO_CANCEL_OPTION);
            if(opcao == JOptionPane.YES_OPTION){
                gravar(file);
            }
        }
    }
    
    public void gravar(File file){
            try{
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(areaTexto.getText());
            bw.newLine();
            bw.flush();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo." + ex.getMessage());
        } finally{
            try{
                bw.close();
                fw.close();
            }
            catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível fechar o fluxo." + ex.getMessage());
            }
        }
    }
    
    public void lerArquivo(File file){
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //lê a primeira linha do arquivo
            String linha= bufferedReader.readLine();
            String conteudo = "";
            //a primeira linha recebe o valor numm quando o processo de repetição atingir o final do arquivo
            while(linha != null){
                conteudo += linha + "\n";
                linha = bufferedReader.readLine();
            }
            areaTexto.setText(conteudo);
        }
        catch (IOException ex){
            JOptionPane.showMessageDialog(null,"Erro na leitura:" + ex.getMessage());
        }
    }
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
            java.util.logging.Logger.getLogger(FormArquivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormArquivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormArquivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormArquivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormArquivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lerArquivo;
    private javax.swing.JButton salvar;
    // End of variables declaration//GEN-END:variables
}
