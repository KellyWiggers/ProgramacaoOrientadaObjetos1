/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kelly
 */
public abstract class AbstractDaoImpl<T> {
    private Connection connection;
    protected abstract T mapResultSetToEntity(ResultSet rs);
    protected abstract String getNomeTabela();
    protected abstract boolean inserir(T entidade);
    protected abstract boolean remover(int codigo);
    protected abstract boolean alterar(T entidade);
    
    protected abstract T buscarPorCodigo(int codigo);
    
    public List<T> listar(){
        String sql = "SELECT * FROM " + getNomeTabela();
        List<T> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                retorno.add(mapResultSetToEntity(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }    
    
}
