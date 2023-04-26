/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.DAO;

import br.edu.utfpr.entidades.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kelly
 */
public class ProdutoDao extends AbstractDaoImpl<Produto>{
    
    private Connection connection;
    private Logger logger = Logger.getLogger("ProdutoDao");
    ResultSet rs;
    PreparedStatement stmt;
    
    public ProdutoDao(){
        connection = ConexaoDao.getInstance().getConexao();
    }
    
    @Override
    protected String getNomeTabela() {
        return "produtos";
    }
    
    @Override
    public List<Produto> listar(){
        String sql = "SELECT * FROM " + getNomeTabela();
        List<Produto> retorno = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sql);
            logger.info(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = mapResultSetToEntity(rs);
                retorno.add(produto);
            }
        } catch (SQLException ex) {
            logger.severe("Erro ao executar consulta: " + ex.getMessage());
        }
        return retorno;
    }
    
   @Override
   protected Produto mapResultSetToEntity(ResultSet rs){
       try{
            Produto produto = new Produto();
            produto.setCodigo(rs.getInt("codigo"));
            produto.setNome(rs.getString("nome"));
            produto.setSetor(rs.getString("setor"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setPrecoCusto(rs.getDouble("preco_custo"));
            produto.setPrecoVenda(rs.getDouble("preco_venda"));
            return produto;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar produto: " + ex.getMessage());
            return null;
        }
        
    }
   
    @Override
    public List<Produto> buscarPorCodigo(int codigo) {
        String sql = "SELECT * FROM produtos WHERE codigo = ?";
        List<Produto> retorno = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo); //garante a busca
            rs = stmt.executeQuery();
            while (rs.next()) {
               Produto produto = mapResultSetToEntity(rs);
                retorno.add(produto);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            logger.severe("Erro ao executar consulta: " + ex.getMessage());
        }  
        return retorno;
    }
    
    public List<Produto> buscarPorNome(String nome) {
        String sql = "SELECT * FROM produtos WHERE nome LIKE ?";
        List<Produto> retorno = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%"); //garante a busca da string com começo.
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = mapResultSetToEntity(rs);
                retorno.add(produto);
            }
        } catch (SQLException ex) {
            logger.severe("Erro ao executar consulta: " + ex.getMessage());
        }
        return retorno;
    }
    
}
