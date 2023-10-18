/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.DAO;
import java.sql.*;
import java.util.List;
/**
 *
 * @author kelly
 */
public abstract class AbstractDAO<T> {
    protected abstract T mapearParaEntidade(ResultSet rs);
    public abstract List<T> listar();
    protected abstract boolean inserir (T entidade);
    protected abstract boolean remover(int codigo);
    protected abstract boolean alterar(T entidade);
}
