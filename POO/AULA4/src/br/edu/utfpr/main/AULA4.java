/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.utfpr.main;

import br.edu.utfpr.arquivoDAO.ProdutoDAO;
import br.edu.utfpr.entidades.Produto;

/**
 *
 * @author kelly
 */
public class AULA4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProdutoDAO produtoDao = new ProdutoDAO();
        Produto produto = new Produto("Pão", 12.99, 15);
        
        produtoDao.gravarArquivo(produto);
        System.out.println(produtoDao.lerArquivo().toString());
    }
    
}
