/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.model;


import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kelly
 */
public class JpaUtil {
    private static final Logger LOGGER = Logger.getLogger(JpaUtil.class.getName());
	
	public static EntityManager getEmPostgres(){
		EntityManager result =null;
		try {
			final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AULAJPAPU");
			result=entityManagerFactory.createEntityManager();
		}catch (Exception ex) {
			LOGGER.severe(ex.getMessage());
		}
		return result;
	}
}
