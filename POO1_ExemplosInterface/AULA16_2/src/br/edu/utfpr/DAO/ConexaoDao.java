/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.DAO;

import java.sql.*;
import java.util.logging.Logger;

public class ConexaoDao {
    private Connection conexao;
    private static ConexaoDao instancia = null;
    private Logger logger = Logger.getLogger("ConexaoDao");
    
    public ConexaoDao(){
        try {
            String url = "jdbc:postgresql://localhost:5432/BancoAULA16";
            String usuario = "postgres";
            String senha = "postgres";
            conexao= DriverManager.getConnection(url,usuario, senha);
            logger.info("Conexão com o banco de dados estabelecida.");
        } catch (SQLException e) {
            logger.severe("Erro ao estabelecer conexão com o banco de dados: " + e.getMessage());
        }
    }
    
    public static ConexaoDao getInstance() {
      if (instancia == null) {
         instancia = new ConexaoDao();
      }
      return instancia;
   }
    
    public Connection getConexao() {
      return conexao;
   }

   public void fecharConexao() {
      try {
         if (conexao != null) {
            conexao.close();
            logger.info("Conexão com o banco de dados fechada.");
         }
      } catch (SQLException e) {
         logger.warning("Erro ao fechar conexão com o banco de dados: " + e.getMessage());
      }
   }
}
