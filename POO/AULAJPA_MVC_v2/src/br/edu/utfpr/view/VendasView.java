/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.view;

import br.edu.utfpr.Controller.VendasController;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author kelly
 */
public class VendasView {
    public static void inicio() {
        // Parametros
        HashMap<String, String> parametros = new HashMap<>();
        
        // Exibicao - tela
        System.out.println("Você está no menu de VENDAS");
        System.out.println("");
        System.out.println("inicio - retornar ao menu principal");
        //System.out.println("listar - listar todas as vendas cadastradas");
        System.out.println("cadastrar - cadastrar uma nova venda");
        
        // Interacao / Entrada de dados
        Scanner entrada = new Scanner(System.in);
        parametros.put("destino", entrada.nextLine());
        
        // Novo Controller
        VendasController.irPara(parametros);
    }
    
    public static void cadastrar(){
        // Parametros
        HashMap<String, String> parametros = new HashMap<>();
        
        // Tela
        System.out.println("Informe os detalhes para cadastrar uma nova venda");
        
        // Interacao
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o código do funcionário: ");
        parametros.put("CodigoFuncionario", entrada.nextLine());
        System.out.println("Informe o código do produto: ");
        parametros.put("CodigoProduto", entrada.nextLine());
        System.out.println("Informe a quantidade: ");
        parametros.put("Quantidade", entrada.nextLine());
        
        // Controller
        VendasController.inserir(parametros);
    }
}
