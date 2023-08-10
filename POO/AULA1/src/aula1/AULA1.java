/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aula1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
//https://www.devmedia.com.br/java-arquivos-e-fluxos-de-dados/22859
//https://www.mballem.com/post/manipulando-arquivo-txt-com-java/
/**
 *
 * @author kelly
 */
public class AULA1 {
    public static void main(String[] args) {
        // Ler o caminho do arquivo ou diretório
        Scanner ler = new Scanner(System.in);
        
        System.out.printf("Informe o nome de um arquivo ou diretório:\n");
        String nome = ler.nextLine();
        
        File objFile = new File(nome);
        if (objFile.exists()) {
            if (objFile.isFile()) {
                System.out.printf("\nArquivo (%s) existe - tamanho: %d bytes\n",
            objFile.getName(),  objFile.length());
            }
            else {
                System.out.printf("\nConteúdo do diretório:\n");
                String diretorio[] = objFile.list();
                for (String item: diretorio) {
                    System.out.printf("%s\n", item);
                }
            }
        } else System.out.printf("Erro: arquivo ou diretório informado não existe!\n");
        
        // Criar um diretório manualmente
        /*File diretorio = new File("C:\\Users\\kelly\\Documents\\NetBeansProjects\\diretorioExemplo"); 
        boolean statusDir = diretorio.mkdir();
        System.out.print(statusDir); 
        
        File arquivo = new File(diretorio, "aula1.txt"); 
        try {
            boolean statusArq = arquivo.createNewFile();
            System.out.print(statusArq);
        } catch (IOException e) {
            e.printStackTrace(); 
        } */
    }
}
