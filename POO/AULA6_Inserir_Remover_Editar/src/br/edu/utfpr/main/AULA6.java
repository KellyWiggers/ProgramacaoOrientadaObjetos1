/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.utfpr.main;

import br.edu.utfpr.entidades.Produto;
import br.edu.utfpr.DAO.ConexaoDAO;
import br.edu.utfpr.DAO.ProdutoDAO;
import br.edu.utfpr.streams.StreamsProduto;
import java.util.List;

/**
 *
 * @author kelly
 */
public class AULA6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexaoDAO conexao = ConexaoDAO.getInstancia();
        
        //OPERAÇÕES COM PRODUTO
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        //Inserir um produto
        /*
        Produto produto = new Produto();
        produto.setSetor("Limpeza");
        produto.setNomeProduto("Sabão Liquido");
        produto.setQuantidade(10);
        produto.setPrecoCusto(12.99);
        produto.setPrecoVenda(23.99);
        
        produtoDAO.inserir(produto);
        */
        
        //remover um produto
        //produtoDAO.remover(11);
        
        
        StreamsProduto smP = new StreamsProduto();
        // Uso do listar
        List<Produto> listaProdutos = produtoDAO.listar();
        //System.out.println(listaProdutos.toString());
        //System.out.println("Nome dos produtos: " + smP.nomeProdutos(listaProdutos));
        //System.out.println("Busca por nome: "+ smP.produtoSelecionadoPorNome(listaProdutos, "Carne"));
        
        Produto produtoTeste = smP.buscaPorId(listaProdutos, 4);
        System.out.println(produtoTeste);
        
        //produtoTeste.setQuantidade(7);
        //produtoDAO.alterar(produtoTeste);
        //System.out.println(produtoTeste);

    }   
}
