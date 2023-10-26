/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.Controller;

import br.edu.utfpr.model.Produto;
import br.edu.utfpr.model.ProdutoDAO;
import br.edu.utfpr.view.ProdutosView;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author kelly
 */
public class ProdutosController {
    private static final ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public static void inicio(HashMap<String, String> params){
        ProdutosView.inicio();
    }
    
    public static void cadastrar(HashMap<String, String> params){
        ProdutosView.cadastrar();
    }
    
    public static void inserir(HashMap<String, String> params){
        Produto produto = new Produto();
        produto.setSetor(params.get("Setor"));
        produto.setNome(params.get("NomeProduto"));
        produto.setQuantidade(Integer.parseInt(params.get("Quantidade")));
        produto.setPreco_Custo(Float.parseFloat(params.get("PrecoCusto")));
        produto.setPreco_Venda(Float.parseFloat(params.get("PrecoVenda")));
        produtoDAO.adiciona(produto);
        // TODO: Se inserir for falso, retorna para cadastrar com mensagem de erro
        ProdutosController.listar(params);
    }
    
    public static void listar(HashMap<String, String> params){
        List<Produto> listaProdutos = produtoDAO.lista();
        ProdutosView.listar(listaProdutos);
    }
    
    public static void buscar(HashMap<String, String> params){
        ProdutosView.buscar();
    }
    
    public static void exibir(HashMap<String, String> params){
        Produto produto = new Produto();
        if(params.get("opcao").equals("1")){
            produto = produtoDAO.busca(Integer.valueOf(params.get("codigo")));
        }
        //continua outras opcoes de busca;
        
        // TODO: Caso nao encontro nenhum produto, poderia voltar para buscar com a mensagem de erro
        ProdutosView.exibir(produto);
    }
    
    public static void editar(HashMap<String, String> params){
        int codigo = Integer.parseInt(params.get("codigo"));
        Produto produto = produtoDAO.busca(codigo);
        ProdutosView.editar(produto);
    }
    
    public static void alterar(HashMap<String, String> params){
        int codigo = Integer.parseInt(params.get("codigo"));
        Produto produto = produtoDAO.busca(codigo);
        produto.setSetor(params.get("Setor"));
        produto.setNome(params.get("NomeProduto"));
        produto.setQuantidade(Integer.parseInt(params.get("Quantidade")));
        produto.setPreco_Custo(Float.parseFloat(params.get("PrecoCusto")));
        produto.setPreco_Venda(Float.parseFloat(params.get("PrecoVenda")));
        produtoDAO.atualiza(produto);
       
        // TODO: Caso remover for falso, retornar para editar com a mensagem de erro
        ProdutosView.exibir(produto);
    }
    
    public static void remover(HashMap<String, String> params){
        int codigo = Integer.parseInt(params.get("codigo"));
        Produto produto = produtoDAO.busca(codigo);
        produtoDAO.remove(produto);
       
        // TODO: Caso remover for falso, retornar para exibir com a mensagem de erro
        ProdutosView.remover(produto);
    }
    
    public static void irPara(HashMap<String, String> parametros){
        String destino = parametros.get("destino");
        
        switch (destino) {
            case "inicio" -> MainController.inicio(parametros);
            case "listar" -> ProdutosController.listar(parametros);
            case "cadastrar" -> ProdutosController.cadastrar(parametros);
            case "buscar" -> ProdutosController.buscar(parametros);
            case "editar" -> ProdutosController.editar(parametros);
            case "remover" -> ProdutosController.remover(parametros);
            case  "voltar" -> ProdutosController.inicio(parametros);
            default -> {
                System.out.println("Opcao invalida: " +  destino);
                ProdutosController.inicio(parametros);
            }
        }
    }
}
