/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.entidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author kelly
 */
public class Produto implements Serializable {
    private static final long serialVersionUID = 3;
    private String nomeProduto;
    private double valorUnitario;
    private int quantidade;
    private Categoria nomeCategoria;
    
    public Produto(){
        
    }

    public Produto(String produto, double valorUnitario, int quantidade, Categoria nomeCategoria) {
        this.nomeProduto = produto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.nomeCategoria = nomeCategoria;
    }
      
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nProduto: " + this.nomeProduto);
        sb.append("\nCategoria: " + this.nomeCategoria.toString());
        sb.append("\nValor unitário: " + this.valorUnitario);
        sb.append("\nQuantidade: " + this.quantidade);
        
        return sb.toString();
    }

   

}
