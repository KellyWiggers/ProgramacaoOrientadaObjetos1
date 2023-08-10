/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.dao;

import br.edu.utfpr.entidades.Produto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author kelly
 */
public class ProdutoDao {
    private List<Produto> listaProduto;
    
    public ProdutoDao(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }
    
    public void salvarNoDisco(String path){
        try(OutputStream output = new FileOutputStream(path)){
        ObjectOutputStream object = new ObjectOutputStream(output);
        object.writeObject(listaProduto);
        JOptionPane.showMessageDialog(null, "Arquivo foi salvo com sucesso.");
        }catch (Exception ex){
           ex.printStackTrace();
        }
    }
    
    public List<Produto> abrir(String path){
       try(InputStream input = new FileInputStream(path)){
            ObjectInputStream object = new ObjectInputStream(input);
            listaProduto = (List<Produto>)object.readObject();//desserializa o objeto
       }catch(IOException ex){
          ex.printStackTrace();
       } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
       }
       return listaProduto;
    }
    
}
