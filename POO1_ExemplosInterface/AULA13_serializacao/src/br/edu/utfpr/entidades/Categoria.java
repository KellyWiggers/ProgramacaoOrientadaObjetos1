/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.entidades;

import java.io.Serializable;

/**
 *
 * @author kelly
 */
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1;
    
    private String nomeCategoria;
    
    public Categoria(String categoria){
        this.nomeCategoria = categoria;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.nomeCategoria);
        return sb.toString();
    }
}
