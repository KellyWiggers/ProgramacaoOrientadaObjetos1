package br.edu.utfpr.controller;

import br.edu.utfpr.view.MainView;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kelly
 */
public class MainController {
    public static void inicio(HashMap<String, String> parametros){
        MainView.inicio();
    }
    
    public static void irPara(HashMap<String, String> parametros){
        String destino = parametros.get("destino");
        
        switch (destino) {
            case "inicio" -> MainController.inicio(parametros);
            case "funcionarios" -> ProdutosController.inicio(parametros);
            case "produtos" -> ProdutosController.inicio(parametros);
            case "vendas" -> ProdutosController.inicio(parametros);
            default -> throw new AssertionError();
        }
    }
    
    public static void pressioneEnter(){
        System.out.println("Tecle enter para continuar");
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
