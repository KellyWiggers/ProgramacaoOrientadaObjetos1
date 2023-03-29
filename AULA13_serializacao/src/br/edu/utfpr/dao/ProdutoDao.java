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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author kelly
 */
public class ProdutoDao {
    
    public ProdutoDao(){
        
    }
    
    
    public void salvar(Produto produto){
        JFileChooser chooser = new JFileChooser();
        if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            try (FileOutputStream output = new FileOutputStream(
                chooser.getSelectedFile().getPath())){
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(output);
                objectOutputStream.writeObject(produto);
                JOptionPane.showMessageDialog(null,"Lista gravada com sucesso");
            } catch (FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Erro " + ex.getMessage());
            } catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Erro " + ex.getMessage());
            }
        }
    }
       
    public Produto abrir(){
        Produto produto = null;
        JFileChooser chooser = new JFileChooser();
        if(chooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION){
            try ( FileInputStream input = new FileInputStream(chooser.getSelectedFile().getPath());
                ObjectInputStream objectInputStream = new ObjectInputStream(input)){
                produto = (Produto) objectInputStream.readObject();
                
                System.out.println(produto);
                objectInputStream.close();
            } catch (FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Erro " + ex.getMessage());
            } catch (IOException | ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Erro " + ex.getMessage());
            }
        }
        return produto;
    }
    
    
}
