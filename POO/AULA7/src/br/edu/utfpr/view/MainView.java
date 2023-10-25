/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.view;

import br.edu.utfpr.controller.MainController;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author kelly
 */
public class MainView {
    public static void inicio(){
        // parametros
        HashMap<String, String> parametros = new HashMap<>();
        
        // tela
        System.out.println("Você está no menu PRINCIPAL");
        System.out.println("Qual menu gostaria de acessar?");
        System.out.println("");
        System.out.println("funcionarios");
        System.out.println("produtos");
        System.out.println("vendas");
        
        // innteracao
        Scanner entrada = new Scanner(System.in);
        String destino = entrada.nextLine();
        parametros.put("destino", destino);
        
        // novo controller
        MainController.irPara(parametros);
    }
}

        
