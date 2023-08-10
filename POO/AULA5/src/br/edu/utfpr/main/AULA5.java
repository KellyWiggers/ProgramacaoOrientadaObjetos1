/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.utfpr.main;

import br.edu.utfpr.entidades.Produto;
import br.edu.utfpr.streams.StreamsNumeros;
import br.edu.utfpr.streams.StreamsProduto;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author kelly
 */
public class AULA5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*List<Integer> numeros= new ArrayList<Integer>();
        numeros.add(4);
        numeros.add(2);
        numeros.add(10);
        numeros.add(5);
        numeros.add(3);
        numeros.add(1);
        numeros.add(8);
        
        StreamsNumeros sn = new StreamsNumeros();
        
        sn.imprimeListaFiltrada(numeros);
        System.out.println(sn.listaReduzida(numeros));
        System.out.println(sn.listaFiltrada(numeros));
        */
        
        
        
        
        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(new Produto("Pão", 12.99, 15));
        produtos.add(new Produto("Bolacha", 5.99, 10));
        produtos.add(new Produto("Bolo", 23.99, 5));
        produtos.add(new Produto("Pastel", 7.99, 6));
        
        
        StreamsProduto smP = new StreamsProduto();
        System.out.println("Nome dos produtos: " + smP.nomeProdutos(produtos));
        
        
        System.out.println("Produto selecionado " + smP.produtoSelecionado(produtos));
        
        System.out.println("Busca por nome: "+ smP.buscaPorNome(produtos,"Bolacha"));
     
      
      
        System.out.println("Lista ordenada por nome:" + smP.ordenarPorNome(produtos));
        System.out.println("Soma dos valores: " + smP.somaValores(produtos));
        System.out.println("Valor maximo: " + smP.encontraMax(produtos));
        System.out.println("Valor minimo:" + smP.encontraMin(produtos));
       
      

}

    
}
