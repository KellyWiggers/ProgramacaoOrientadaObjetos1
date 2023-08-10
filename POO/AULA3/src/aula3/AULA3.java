/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aula3;

import java.io.File;
/**
 *
 * @author kelly
 */
public class AULA3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File arquivo = new File("C:\\Users\\kelly\\Documents\\NetBeansProjects\\aula1.txt");
        ArquivoDAO arquivoDao = new ArquivoDAO();
        // Com uso de FileOutputStream e FileInputStream
        //arquivoDao.gravarArquivo(arquivo, "Estou criando um conteudo em bytes");
        //String conteudoLido = arquivoDao.lerArquivo(arquivo);
        //System.out.println(conteudoLido);
        
        // Com uso de DataOutputStream e FileInputStream
        String nome = "Kelly";
        int idade = 20;
        String genero = "feminino";
        String escolaridade = "Superior Completo";
        arquivoDao.gravarArquivo(arquivo, nome, idade, genero, escolaridade);
        String conteudoLido = arquivoDao.ler(arquivo);
        System.out.println(conteudoLido);
    }
    
}
