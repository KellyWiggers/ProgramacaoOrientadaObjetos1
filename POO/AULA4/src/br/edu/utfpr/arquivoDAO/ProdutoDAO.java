/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.arquivoDAO;

import br.edu.utfpr.entidades.Produto;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author kelly
 */
public class ProdutoDAO {
    
    
    public void gravarArquivo(Produto produto){
        JFileChooser arquivoEscolhido = new JFileChooser();
        if(arquivoEscolhido.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            try{
                FileOutputStream arquivoSaida = new FileOutputStream(arquivoEscolhido.getSelectedFile().getPath());
                ObjectOutputStream objetoSaida = new ObjectOutputStream(arquivoSaida);
                objetoSaida.writeObject(produto);
                System.out.println("Produto salvo com sucesso");
                objetoSaida.close();
            }catch (FileNotFoundException ex){
                System.out.println("Erro " + ex.getMessage());
            }catch (IOException ex){
                System.out.println("Erro " + ex.getMessage());
            }
        }
    }
    
    public Produto lerArquivo(){
        Produto produto = null;
        JFileChooser arquivoEscolhido = new JFileChooser();
        if(arquivoEscolhido.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            try{
                FileInputStream arquivoEntrada = new FileInputStream(arquivoEscolhido.getSelectedFile().getPath());
                ObjectInputStream objetoEntrada = new ObjectInputStream(arquivoEntrada);
                try {
                    produto = (Produto) objetoEntrada.readObject();
                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro " + ex.getMessage());
                }
                objetoEntrada.close();
            }catch (FileNotFoundException ex){
                System.out.println("Erro " + ex.getMessage());
            }catch (IOException ex){
                System.out.println("Erro " + ex.getMessage());
            }
        }
        return produto;
    }
    
}
