/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.utfpr.config;

import br.edu.utfpr.Controller.MainController;
import br.edu.utfpr.model.Produto;
import br.edu.utfpr.model.ProdutoDAO;
import java.util.HashMap;
//import br.edu.utfpr.model.tipos.BancoDeDados;
import java.util.List;

/**
 *
 * @author kelly
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static HashMap<String, String> parametros = new HashMap<>();
    
    public static void main(String[] args) {
        
        MainController.inicio(parametros);
        /*Produto produto = new Produto();
        produto.setSetor("Limpeza");
        produto.setNome("Amaciante");
        produto.setQuantidade(10);
        produto.setPreco_Custo(10.99);
        produto.setPreco_Venda(15.99);
        
        ProdutoDAO produtoDao = new ProdutoDAO();
        //produtoDao.adiciona(produto);
        
        List<Produto> lista = produtoDao.lista();
        System.out.println(lista);
        
        // buscar
        produto = produtoDao.busca(26);
        System.out.println(produto);
        
        produto.setNome("Desengordurante");
        produtoDao.atualiza(produto);
        System.out.println(produto);
        //remover
        //produtoDao.remove(produto);
        */
    }
    
}
