/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.streams;


import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author kelly
 */
public class StreamsNumeros {
    
    
    public void imprimeListaFiltrada(List<Integer> lista){
        lista.stream()
                .filter(n -> n >= 5)
                .map(n -> n* n)
                .forEach(System.out::println);
    }
    
    public int listaReduzida(List<Integer> lista){
        int resultado = lista.stream()
                                .filter(n -> n >= 5)
                                .map(n -> n * n)
                                .reduce(0, (subtotal, elemento) -> subtotal + elemento);
        return resultado;
    }
    
    public List<Integer> listaFiltrada(List<Integer> lista){
        List<Integer> resultado = lista.stream()
                                .filter(n -> n >= 5)
                                .collect(Collectors.toList());
        return resultado;
    }
}
