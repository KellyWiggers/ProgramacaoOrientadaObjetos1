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
/**
 *
 * @author kelly
 */
public class ProdutoDAO extends AbstractDAO<Produto>{
    
    private Connection conexao;
    private Logger logger = Logger.getLogger("ProdutoDao");
    ResultSet rs;
    PreparedStatement stmt;

    
    public ProdutoDAO(){
        conexao = ConexaoDAO.getInstancia().getConexao();
    }
    
    @Override
    protected Produto mapearParaEntidade(ResultSet rs){
    try{
        Produto produto = new Produto();
        produto.setCodigo(rs.getInt("codigo"));
        produto.setNomeProduto(rs.getString("nome"));
        produto.setSetor(rs.getString("setor"));
        produto.setQuantidade(rs.getInt("quantidade"));
        produto.setPrecoCusto(rs.getDouble("preco_custo"));
        produto.setPrecoVenda(rs.getDouble("preco_venda"));
        return produto;
   }catch (SQLException ex) {
        logger.log(Level.SEVERE, "Erro ao executar consulta: {0}", ex.getMessage());
            return null;
    }   
}
    
    @Override
    public List<Produto> listar(){
        String sql = "SELECT * FROM produtos";
        List<Produto> retorno = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            logger.info(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = mapearParaEntidade(rs );
                retorno.add(produto);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao executar consulta: {0}", ex.getMessage());
        }
        return retorno;
    }

    @Override
    public boolean inserir(Produto produto) {
        String sql = "INSERT INTO produtos(setor, nome, quantidade, preco_custo, preco_venda) VALUES(?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getSetor());
            stmt.setString(2, produto.getNomeProduto());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPrecoCusto());
            stmt.setDouble(5, produto.getPrecoVenda());
            stmt.execute();
            logger.info("Inserção no banco de dados realizada!.");
            stmt.close();
            return true;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao executar consulta: {0}", ex.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean remover(int id) {
        String sql = "DELETE FROM produtos WHERE codigo=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao executar consulta: {0}", ex.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean alterar(Produto produto) {
        String sql = "UPDATE produtos SET nome=?, setor=?, quantidade=?, preco_custo=?, preco_venda=? WHERE codigo=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getSetor());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPrecoCusto());
            stmt.setDouble(5, produto.getPrecoVenda());
            stmt.setInt(6, produto.getCodigo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao executar consulta: {0}", ex.getMessage());
            return false;
        }
    }




    
}
