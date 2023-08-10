/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.DAO;

import br.edu.utfpr.entidades.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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
        finally{
            try {
                stmt.close();
                rs.close();
            } catch (SQLException ex) {
                logger.severe("Erro ao fechar conexão" + ex.getMessage());
            }
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
    public Produto buscarPorCodigo(int codigo) {
        String sql = "SELECT * FROM produtos WHERE codigo = ?";
        Produto retorno = new Produto();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo); //garante a busca
            rs = stmt.executeQuery();
            while (rs.next()) {
               retorno = mapResultSetToEntity(rs);
            }
           
        } catch (SQLException ex) {
            logger.severe("Erro ao executar consulta: " + ex.getMessage());
        }
        finally{
            try {
                stmt.close();
                rs.close();
            } catch (SQLException ex) {
                logger.severe("Erro ao fechar conexão" + ex.getMessage());
            }
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
        finally{
            try {
                stmt.close();
                rs.close();
            } catch (SQLException ex) {
                logger.severe("Erro ao fechar conexão" + ex.getMessage());
            }
        }
        return retorno;
    }
    
    @Override
    public boolean inserir(Produto produto) {
        String sql = "INSERT INTO produtos(setor, nome, quantidade, preco_custo, preco_venda) VALUES(?,?,?,?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getSetor());
            stmt.setString(2, produto.getNome());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPrecoCusto());
            stmt.setDouble(5, produto.getPrecoVenda());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            logger.severe("Erro ao executar consulta: " + ex.getMessage());
            return false;
        }finally{
            try {
                stmt.close();
            } catch (SQLException ex) {
                logger.severe("Erro ao fechar conexão" + ex.getMessage());
            }
        }
        
    }
    
    @Override
    public boolean remover(int id) {
        String sql = "DELETE FROM produtos WHERE codigo=?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            logger.severe("Erro ao executar consulta: " + ex.getMessage());
            return false;
        }
        finally{
            try {
                stmt.close();
            } catch (SQLException ex) {
                logger.severe("Erro ao fechar conexão" + ex.getMessage());
            }
        }
    }
    
    @Override
    public boolean alterar(Produto produto) {
        String sql = "UPDATE produtos SET nome=?, setor=?, quantidade=?, preco_custo=?, preco_venda=? WHERE codigo=?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getSetor());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPrecoCusto());
            stmt.setDouble(5, produto.getPrecoVenda());
            stmt.setInt(6, produto.getCodigo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            logger.severe("Erro ao executar consulta: " + ex.getMessage());
            return false;
        }finally{
            try {
                stmt.close();
            } catch (SQLException ex) {
                logger.severe("Erro ao fechar conexão" + ex.getMessage());
            }
        }
    }
    
}
