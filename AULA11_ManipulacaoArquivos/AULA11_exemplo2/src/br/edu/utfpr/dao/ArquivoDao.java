/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author kelly
 */
public class ArquivoDao {
    
    FileWriter fw;
    BufferedWriter bw;
    
    
    public void gravar(File file, String areaTexto){
        try{
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(areaTexto);
            bw.newLine();
            bw.flush();
        }
        catch(IOException ex){
            ex.printStackTrace();
        } finally{
            try{
                bw.close();
                fw.close();
            }
            catch(IOException ex){
            ex.printStackTrace();
            }
        }
    }
    
    public String lerArquivo(File file){
        String conteudo = "";
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //lê a primeira linha do arquivo
            String linha= bufferedReader.readLine();
            //a primeira linha recebe o valor numm quando o processo de repetição atingir o final do arquivo
            while(linha != null){
                conteudo += linha + "\n";
                linha = bufferedReader.readLine();
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return conteudo;
    }
    

}
