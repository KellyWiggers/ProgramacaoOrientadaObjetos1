/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.config;

import br.edu.utfpr.controller.MainController;
import java.util.HashMap;

/**
 *
 * @author kelly
 */
public class Main {
    public static HashMap<String, String> parametros = new HashMap<>();
    
    public static void main(String[] args) {
        MainController.inicio(parametros);
    }
}
