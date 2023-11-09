/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.model;

import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author kelly
 */
public class VendaDAO {
    private final DAO<Venda> dao;
    private EntityManager em;
    private static final Logger LOGGER = Logger.getLogger(JpaUtil.class.getName());
    
    public VendaDAO(){
        //if (bancoDeDados == BancoDeDados.POSTGRES) {
            this.em = JpaUtil.getEmPostgres();
        //}
        this.dao = new DAO<Venda>(em, Venda.class);
    }
    
    public void adiciona(Venda venda) {
		this.dao.adiciona(venda);
	}
}
