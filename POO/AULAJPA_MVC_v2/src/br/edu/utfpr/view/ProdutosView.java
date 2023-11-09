/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.view;

import br.edu.utfpr.Controller.MainController;
import br.edu.utfpr.Controller.ProdutosController;
import br.edu.utfpr.model.Produto;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kelly
 */
public class ProdutosView {
    public static void inicio() {
        // Parametros
        HashMap<String, String> parametros = new HashMap<>();
        
        // Exibicao - tela
        System.out.println("Você está no menu de PRODUTOS");
        System.out.println("");
        System.out.println("inicio - retornar ao menu principal");
        System.out.println("listar - listar todos os produtos cadastrados");
        System.out.println("cadastrar - cadastrar um novo produto");
        System.out.println("buscar - buscar um produto especifico");
        
        // Interacao / Entrada de dados
        Scanner entrada = new Scanner(System.in);
        parametros.put("destino", entrada.nextLine());
        
        // Novo Controller
        ProdutosController.irPara(parametros);
    }
    
    public static void listar(List<Produto> listaProdutos){
        // Parametros
        HashMap<String, String> parametros = new HashMap<>();
        
        // Tela
        System.out.println(listaProdutos.toString());
        
        // Interacao
        MainController.pressioneEnter();
        
        // Novo Controller
        ProdutosController.inicio(parametros);
    }
    
    public static void cadastrar(){
        // Parametros
        HashMap<String, String> parametros = new HashMap<>();
        
        // Tela
        System.out.println("Informe os detalhes para cadastrar um novo produto");
        
        // Interacao
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o setor: ");
        parametros.put("Setor", entrada.nextLine());
        System.out.println("Informe o nome: ");
        parametros.put("NomeProduto", entrada.nextLine());
        System.out.println("Informe a quantidade: ");
        parametros.put("Quantidade", entrada.nextLine());
        System.out.println("Informe o preço de custo: ");
        parametros.put("PrecoCusto", entrada.nextLine());
        System.out.println("Informe o preço de venda: ");
        parametros.put("PrecoVenda", entrada.nextLine());
        
        // Controller
        ProdutosController.inserir(parametros);
    }
    
    public static void buscar(){
        // Parametros
        HashMap<String, String> parametros = new HashMap<>();
        
        // Tela
        System.out.println("Informe o que quer buscar \n 1 - código \n 2 - Nome");
        
        // Interacao
        Scanner entrada = new Scanner(System.in);
        String busca = entrada.nextLine();
        if(busca.equals("1")){
            System.out.println("Digite o código que quer buscar:");
            String codigo = entrada.nextLine();
            parametros.put("opcao", "1");
            parametros.put("codigo", codigo);
        }
        
        // Novo Controller
        ProdutosController.exibir(parametros);
    }
    
    public static void exibir(Produto produto){
        // Parametros
        HashMap<String, String> parametros = new HashMap<>();
        parametros.put("codigo", String.valueOf(produto.getCodigo()));
        
        // Tela
        System.out.println(produto);
        
        // Interacao
        System.out.println("O que deseja fazer?");
        System.out.println("editar");
        System.out.println("remover");
        System.out.println("voltar - menu de produtos");
        
        Scanner entrada = new Scanner(System.in);
        parametros.put("destino", entrada.nextLine());
        
        // Novo controller
        ProdutosController.irPara(parametros);
    }
    
    public static void editar(Produto produto){
        // Parametros
        HashMap<String, String> parametros = new HashMap<>();
        parametros.put("codigo", String.valueOf(produto.getCodigo()));
        
        // Tela
        System.out.println("Informe os detalhes para alterar o produto abaixo");
        System.out.println(produto);
        
        // Interacao
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o setor: ");
        parametros.put("Setor", entrada.nextLine());
        System.out.println("Informe o nome: ");
        parametros.put("NomeProduto", entrada.nextLine());
        System.out.println("Informe a quantidade: ");
        parametros.put("Quantidade", entrada.nextLine());
        System.out.println("Informe o preço de custo: ");
        parametros.put("PrecoCusto", entrada.nextLine());
        System.out.println("Informe o preço de venda: ");
        parametros.put("PrecoVenda", entrada.nextLine());
        
        // Novo Controller
        ProdutosController.alterar(parametros);
    }
    
    public static void alterar(Produto produto){
        // Parametros
        HashMap<String, String> parametros = new HashMap<>();
        parametros.put("codigo", String.valueOf(produto.getCodigo()));
        
        // Tela
        System.out.println("O produto foi alterado com sucesso!");
        System.out.println(produto);
        
        // Interacao
        MainController.pressioneEnter();
        
        // Novo Controller
        ProdutosController.exibir(parametros);
    }
    
    public static void remover(Produto produto){
        // Parametros
        HashMap<String, String> parametros = new HashMap<>();
        
        // Tela
        System.out.println("O produto foi removido com sucesso!");
        System.out.println(produto);
        
        // Interacao
        MainController.pressioneEnter();
        
        // Novo Controller
        ProdutosController.inicio(parametros);
    }
}
