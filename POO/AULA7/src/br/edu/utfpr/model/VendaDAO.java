/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kelly
 */
public class VendaDAO {
    
    private final Connection conexao;
    private static final Logger logger = java.util.logging.Logger.getLogger("VendaDAO");
    PreparedStatement stmt;
    
    public VendaDAO() {
        conexao = ConexaoDAO.getInstancia().getConexao();
    }
    
    public boolean inserirVenda(Venda venda) {
        String sql = ""
                + "BEGIN; "
                + "INSERT INTO vendas(codigo_funcionario, codigo_produto, quantidade, preco_total)"
                + "VALUES(?,?,?,?); "
                + "UPDATE funcionarios SET comissao=? WHERE codigo=?; "
                + "UPDATE funcionarios SET salario_liquido=? WHERE codigo=?; "
                + "UPDATE produtos SET quantidade=? WHERE codigo=?; "
                + "COMMIT;"
                + "END;"
                ;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, venda.getFuncionario().getCodigoFuncionario());
            stmt.setInt(2, venda.getProduto().getCodigo());
            stmt.setInt(3, venda.getQuantidade());
            stmt.setDouble(4, venda.getValorVenda());
            stmt.setDouble(5, venda.getFuncionario().getComissao());
            stmt.setInt(6, venda.getFuncionario().getCodigoFuncionario());
            stmt.setDouble(7, venda.getFuncionario().calculaSalarioLiquidoFuncionario());
            stmt.setInt(8, venda.getFuncionario().getCodigoFuncionario());
            stmt.setInt(9, venda.getProduto().getQuantidade() - venda.getQuantidade());
            stmt.setInt(10, venda.getProduto().getCodigo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao executar consulta: {0}", ex.getMessage());
            return false;
        }
    }
}