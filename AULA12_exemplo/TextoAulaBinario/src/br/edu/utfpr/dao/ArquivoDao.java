/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Andreia
 */
public class ArquivoDao {

    public ArquivoDao() {
    }

    public void gravar(File file, String conteudo) {
        try ( OutputStream output = new FileOutputStream(file);  
              BufferedOutputStream buffer = new BufferedOutputStream(output)) {
               buffer.write(conteudo.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public String ler(File file){
       StringBuilder sb = new StringBuilder();
       try(InputStream input = new FileInputStream(file); 
               BufferedInputStream buffer = new BufferedInputStream(input)){
            int i =0;
            while((i=buffer.read())!=-1){
                sb.append((char)i);
            }
       }catch(IOException ex){
            ex.printStackTrace();
       }
       return sb.toString();
    }

    public void gravar2(File file, String nome, int idade, String genero, String escolaridade){
      try(OutputStream output = new FileOutputStream(file);
              DataOutputStream data = new DataOutputStream(output)){
          data.writeUTF(nome);
          data.writeInt(idade);
          data.writeUTF(genero);
          data.writeUTF(escolaridade);
      
      }catch(IOException ex){
        ex.printStackTrace();
      }
    }

    
    public String ler2(File file){
      StringBuilder sb = new StringBuilder();
      try(InputStream input = new FileInputStream(file);
              DataInputStream data = new DataInputStream(input)){
        sb.append(data.readUTF()).append("\n")
                .append(data.readInt()).append("\n")
                .append(data.readUTF()).append("\n")
                .append(data.readUTF()).append("\n");
      }catch(IOException ex){
         ex.printStackTrace();
      }
      return sb.toString();
    }

}
