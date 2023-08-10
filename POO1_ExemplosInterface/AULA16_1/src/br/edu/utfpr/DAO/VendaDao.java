/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.DAO;

import br.edu.utfpr.entidades.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author kelly
 */
public class VendaDao {
    
    private Connection connection;
    private Logger logger = java.util.logging.Logger.getLogger("VendaDAO");
    PreparedStatement stmt;
    
    public VendaDao() {
        connection = ConexaoDao.getInstance().getConexao();
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
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, venda.getFuncionario().getCodigoFuncionario());
            stmt.setInt(2, venda.getProduto().getCodigo());
            stmt.setInt(3, venda.getQuantidade());
            stmt.setDouble(4, venda.getValorVenda());
            stmt.setDouble(5, venda.getFuncionario().getComissao());
            stmt.setInt(6, venda.getFuncionario().getCodigoFuncionario());
            stmt.setDouble(7, venda.getFuncionario().calculaSalarioLiquidoFuncionario());
            stmt.setInt(8, venda.getFuncionario().getCodigoFuncionario());
            stmt.setInt(9, venda.getProduto().getQuantidade());
            stmt.setInt(10, venda.getProduto().getCodigo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            logger.severe("Erro ao executar consulta: " + ex.getMessage());
            return false;
        }
    }
}
