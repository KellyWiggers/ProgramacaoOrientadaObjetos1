/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.Controller;

import br.edu.utfpr.model.Funcionario;
import br.edu.utfpr.model.FuncionarioDAO;
import br.edu.utfpr.model.Produto;
import br.edu.utfpr.model.ProdutoDAO;
import br.edu.utfpr.model.Venda;
import br.edu.utfpr.model.VendaDAO;
import br.edu.utfpr.view.VendasView;
import java.util.HashMap;

/**
 *
 * @author kelly
 */
public class VendasController {
    private static final VendaDAO vendaDAO = new VendaDAO();
    
    public static void inicio(HashMap<String, String> params){
        VendasView.inicio();
    }
    
    public static void cadastrar(HashMap<String, String> params){
        VendasView.cadastrar();
    }
    
    public static void inserir(HashMap<String, String> params){
        Venda venda = new Venda();
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        ProdutoDAO prodDAO = new ProdutoDAO();
        Funcionario funcionario = funcDAO.busca(Integer.parseInt(params.get("CodigoFuncionario")));
        venda.setFuncionario(funcionario);
        Produto produto = prodDAO.busca(Integer.valueOf(params.get("CodigoProduto")));
        venda.setProduto(produto);
        venda.setQuantidade(Integer.parseInt(params.get("Quantidade")));
        venda.setPrecoTotal(produto.getPreco_Venda() * venda.getQuantidade());
        vendaDAO.adiciona(venda);
        // TODO: Se inserir for falso, retorna para cadastrar com mensagem de erro
        //VendasController.listar(params);
        VendasView.inicio();
    }
    
    public static void irPara(HashMap<String, String> parametros){
        String destino = parametros.get("destino");
        
        switch (destino) {
            case "inicio" -> MainController.inicio(parametros);
            //case "listar" -> VendasController.listar(parametros);
            case "cadastrar" -> VendasController.cadastrar(parametros);
            //case "buscar" -> VendasController.buscar(parametros);
            //case "editar" -> VendasController.editar(parametros);
            //case "remover" -> VendasController.remover(parametros);
            case  "voltar" -> VendasController.inicio(parametros);
            default -> {
                System.out.println("Opcao invalida: " +  destino);
                ProdutosController.inicio(parametros);
            }
        }
    }
}
