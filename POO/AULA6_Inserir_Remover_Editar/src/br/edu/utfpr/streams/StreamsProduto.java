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
                                     .filter(x -> x.getPrecoCusto() > 15)
                                     .collect(Collectors.toList()); 
        return produtoSelecionado;
    }
    
    public List<Produto> produtoSelecionadoPorNome(List<Produto> produtos, String nome){
        List<Produto> produtoSelecionado = produtos.stream()
                                     .filter(x -> nome.equals(x.getNomeProduto()))
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
    
    public Produto buscaPorId(List<Produto> produtos, int codigo){
        Produto selecionado = produtos.stream()
                .filter(i -> i.getCodigo() == codigo)
                //.filter(x -> codigo.equals(x.getCodigo()))
                .findAny()
                .orElse(null);
        return selecionado;
    }
    
    public List<Produto> ordenarPorNome(List<Produto> produtos){
        List<Produto> ordenarPorNome = produtos.stream()
                .sorted(Comparator.comparing(Produto::getNomeProduto)).collect(Collectors.toList());
        return ordenarPorNome;
    }
    
    public List<Produto> ordenarPorPreco(List<Produto> produtos){
        List<Produto> ordenarPorPreco = produtos.stream()
                .sorted(Comparator.comparing(Produto::getPrecoCusto)).collect(Collectors.toList());
    
        return ordenarPorPreco;
     }
     
    public double somaValores(List<Produto> produtos){
         double soma = produtos.stream().mapToDouble(Produto::getPrecoCusto).sum();
         return soma;
    }
    
    public double mediaValores(List<Produto> produtos){
        double media = produtos.stream().mapToDouble(Produto::getPrecoCusto).average().getAsDouble();
        return media;
    }
    
    public double encontraMax(List<Produto> produtos){
        double maiorPreco = produtos.stream().mapToDouble(Produto::getPrecoCusto).max().getAsDouble();
        return maiorPreco;
    }
    
    public double encontraMin(List<Produto> produtos){
        double menorPreco = produtos.stream().mapToDouble(Produto::getPrecoCusto).min().getAsDouble();
        return menorPreco;
    }
}
