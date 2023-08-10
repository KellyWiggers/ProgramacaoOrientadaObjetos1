/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.streams;

import br.edu.utfpr.entidades.Produto;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author kelly
 */
public class StreamsProduto {
    
    
    public List<String> nomeProdutos(List<Produto> produtos){
        List<String> nomesProdutos = produtos.stream()
                                     .map(Produto::getNomeProduto)
                                     .collect(Collectors.toList());
        return nomesProdutos;
    }
    public List<String> nomeProdutosFlatMap(List<Produto> produtos){
        List<String> nomes = produtos.stream()
                                     .flatMap(nome -> Stream.of(nome.getNomeProduto()))
                                     .collect(Collectors.toList());
        return nomes;
    }
    
    public List<Produto> produtoSelecionado(List<Produto> produtos){
        List<Produto> produtoSelecionado = produtos.stream()
                                     .filter(x -> x.getValorUnitario() > 15)
                                     .collect(Collectors.toList()); 
        return produtoSelecionado;
    }
    
    public String buscaPorNome(List<Produto> produtos, String nome){
        String selecionado = produtos.stream()
                      .filter(x -> nome.equals(x.getNomeProduto()))
                      .map(Produto::getNomeProduto)
                      .findAny()
                      .orElse("");
        return selecionado;
    }
    
    public List<Produto> ordenarPorNome(List<Produto> produtos){
        List<Produto> ordenarPorNome = produtos.stream()
                .sorted(Comparator.comparing(Produto::getNomeProduto)).collect(Collectors.toList());
        return ordenarPorNome;
    }
    
    public List<Produto> ordenarPorPreco(List<Produto> produtos){
        List<Produto> ordenarPorPreco = produtos.stream()
                .sorted(Comparator.comparing(Produto::getValorUnitario)).collect(Collectors.toList());
    
        return ordenarPorPreco;
     }
     
    public double somaValores(List<Produto> produtos){
         double soma = produtos.stream().mapToDouble(Produto::getValorUnitario).sum();
         return soma;
    }
    
    public double mediaValores(List<Produto> produtos){
        double media = produtos.stream().mapToDouble(Produto::getValorUnitario).average().getAsDouble();
        return media;
    }
    
    public double encontraMax(List<Produto> produtos){
        double maiorPreco = produtos.stream().mapToDouble(Produto::getValorUnitario).max().getAsDouble();
        return maiorPreco;
    }
    
    public double encontraMin(List<Produto> produtos){
        double menorPreco = produtos.stream().mapToDouble(Produto::getValorUnitario).min().getAsDouble();
        return menorPreco;
    }
}
