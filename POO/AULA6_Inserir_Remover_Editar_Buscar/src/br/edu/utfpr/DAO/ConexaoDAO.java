/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.DAO;
import java.util.logging.Logger;
import java.sql.*;
import java.util.logging.Level;

/**
 *
 * @author kelly
 */
public class ConexaoDAO {
    Connection conexao;
    private static ConexaoDAO instancia = null;
    private Logger logger = Logger.getLogger("ConexaoDao");
    
    public ConexaoDAO(){
        try{
            String url = "jdbc:postgresql://localhost:5432/BancoAULA16";
            String usuario = "postgres";
            String senha = "postgres";
            conexao = DriverManager.getConnection(url, usuario, senha);
            logger.info("Conexão com o banco de dados estabelecida.");
        } catch (SQLException e){
            logger.log(Level.SEVERE, "Erro ao estabelecer conexao com o banco de dados: {0}",
                    e.getMessage());
        }
    }
    
    public Connection getConexao(){
        return conexao;
    }
    
    public static ConexaoDAO getInstancia(){
        if(instancia == null){
            instancia = new ConexaoDAO();
            
        }
        return instancia;
    }
    
    public void fecharConexao(){
        try{
            if(conexao != null){
                conexao.close();
                logger.info("Conexão com banco de dados fechada.");
            }
        }catch (SQLException e){
                    logger.log(Level.WARNING, "Erro ao fechar conexao com banco de dados: {0}", e.getMessage());                    
                }
        }
}    

