/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aula2;
import java.io.*;
/**
 *
 * @author kelly
 */
public class AULA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        File arquivo = new File("C:\\Users\\kelly\\Documents\\NetBeansProjects\\aula1.txt");
        // Exemplo para escrever no arquivo!
        try{
            FileWriter arquivoEscrito = new FileWriter(arquivo, false);
            BufferedWriter buffer = new BufferedWriter(arquivoEscrito);
            //exemplo de gravar String
            buffer.write("Estou escrevendo no arquivo.");
            buffer.newLine();
            //exemplo de gravar um array de caracteres
            char [] texto = new char [] {'a','b','c','d'}; 
            buffer.write(texto);
            buffer.flush();
            System.out.println("Arquivo gravado com sucesso!");
            arquivoEscrito.close();
            buffer.close();
        }catch (Exception e) {
            e.getStackTrace();
        }
        
        // Exemplo para ler do arquivo e apresentar no terminal
        try{
            FileReader arquivoLido = new FileReader(arquivo);
            BufferedReader leitura = new BufferedReader(arquivoLido);
            String linha = leitura.readLine();
            String conteudoLido = "";
            while(linha != null){
                conteudoLido += linha + "\n";
                linha = leitura.readLine();
            }
            System.out.println(conteudoLido);
            leitura.close();
            arquivoLido.close();
        }catch (Exception e) {
            e.getStackTrace();
        }
    }
    
}
