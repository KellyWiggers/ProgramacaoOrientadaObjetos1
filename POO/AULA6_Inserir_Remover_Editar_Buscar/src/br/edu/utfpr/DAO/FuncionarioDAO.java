/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.DAO;
import br.edu.utfpr.entidades.Funcionario;
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
public class FuncionarioDAO extends AbstractDAO<Funcionario>{
    private final Connection conexao;
    private static final Logger logger = Logger.getLogger("ProdutoDao");
    ResultSet rs;
    PreparedStatement stmt;
    
    public FuncionarioDAO(){
        conexao = ConexaoDAO.getInstancia().getConexao();
    }
    
    protected String getNomeTabela() {
        return "funcionarios";
    }
    
    @Override
    public List<Funcionario> listar(){
        String sql = "SELECT * FROM " + getNomeTabela();
        List<Funcionario> retorno = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            logger.info(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = mapearParaEntidade(rs);
                retorno.add(funcionario);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao executar consulta: {0}", ex.getMessage());
        }
        finally{
            try {
                stmt.close();
                rs.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "Erro ao fechar conex\u00e3o{0}", ex.getMessage());
            }
        }
        return retorno;
    }
    
    @Override
   protected Funcionario mapearParaEntidade(ResultSet rs){
       try{
            Funcionario funcionario = new Funcionario();
            funcionario.setCodigoFuncionario(rs.getInt("codigo"));
            funcionario.setNomeFuncionario(rs.getString("nome"));
            funcionario.setFuncaoFuncionario(rs.getString("funcao_funcionario"));
            funcionario.setSalarioBrutoFuncionario(rs.getInt("salario_bruto"));
            funcionario.setComissao(rs.getDouble("comissao"));
            return funcionario;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar funcionario: " + ex.getMessage());
            return null;
        }
        
    }
   
   
   public Funcionario buscarPorCodigo(int codigo) {
        String sql = "SELECT * FROM funcionarios WHERE codigo = ?";
        Funcionario retorno = new Funcionario();
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo); //garante a busca
            rs = stmt.executeQuery();
            while (rs.next()) {
               retorno = mapearParaEntidade(rs);
            }
           
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao executar consulta: {0}", ex.getMessage());
        }
        finally{
            try {
                stmt.close();
                rs.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "Erro ao fechar conex\u00e3o{0}", ex.getMessage());
            }
        }
        return retorno;
    }
    
    public List<Funcionario> buscarPorNome(String nome) {
        String sql = "SELECT * FROM funcionarios WHERE nome LIKE ?";
        List<Funcionario> retorno = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%"); //garante a busca da string com começo.
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = mapearParaEntidade(rs);
                retorno.add(funcionario);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao executar consulta: {0}", ex.getMessage());
        }
        finally{
            try {
                stmt.close();
                rs.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "Erro ao fechar conex\u00e3o{0}", ex.getMessage());
            }
        }
        return retorno;
    }
    
    @Override
    public boolean inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios(nome, funcao_funcionario, salario_bruto, comissao, salario_liquido) VALUES(?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getNomeFuncionario());
            stmt.setString(2, funcionario.getFuncaoFuncionario());
            stmt.setDouble(3, funcionario.getSalarioBrutoFuncionario());
            stmt.setDouble(4, funcionario.getComissao());
            stmt.setDouble(5, funcionario.calculaSalarioLiquidoFuncionario());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao executar consulta: {0}", ex.getMessage());
            return false;
        }finally{
            try {
                stmt.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "Erro ao fechar conex\u00e3o{0}", ex.getMessage());
            }
        }
        
    }
    
    @Override
    public boolean remover(int id) {
        String sql = "DELETE FROM funcionarios WHERE codigo=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao executar consulta: {0}", ex.getMessage());
            return false;
        }
        finally{
            try {
                stmt.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "Erro ao fechar conex\u00e3o{0}", ex.getMessage());
            }
        }
    }
    
    @Override
    public boolean alterar(Funcionario funcionario) {
        String sql = "UPDATE funcionarios SET nome=?, funcao_funcionario=?, salario_bruto=?, comissao=?, salario_liquido=? WHERE codigo=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getNomeFuncionario());
            stmt.setString(2, funcionario.getFuncaoFuncionario());
            stmt.setDouble(3, funcionario.getSalarioBrutoFuncionario());
            stmt.setDouble(4, funcionario.getComissao());
            stmt.setDouble(5, funcionario.getSalarioLiquidoFuncionario());
            stmt.setInt(6, funcionario.getCodigoFuncionario());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao executar consulta: {0}", ex.getMessage());
            return false;
        }finally{
            try {
                stmt.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "Erro ao fechar conex\u00e3o{0}", ex.getMessage());
            }
        }
    }
    
}