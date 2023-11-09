/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.model;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author kelly
 */
   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author kelly
 */
public class FuncionarioDAO{
    private final DAO<Funcionario> dao;
    private EntityManager em;
    private static final Logger LOGGER = Logger.getLogger(JpaUtil.class.getName());
    
    public FuncionarioDAO(){
        //if (bancoDeDados == BancoDeDados.POSTGRES) {
            this.em = JpaUtil.getEmPostgres();
        //}
        this.dao = new DAO<Funcionario>(em, Funcionario.class);
    }
    
    public void adiciona(Funcionario funcionario) {
		this.dao.adiciona(funcionario);
	}

	public void remove(Funcionario funcionario) {
		this.dao.remove(funcionario);
	}

	public Funcionario atualiza(Funcionario funcionario) {
		funcionario = this.dao.atualiza(funcionario);
		return funcionario;
	}

	public List<Funcionario> lista() {
		return this.dao.lista();
	}

	public Funcionario busca(Integer id) {
		return dao.busca(id);
	}

	public List<Funcionario> buscaPorNome(String nome) {
		List<Funcionario> result = null;

		try {

			Query query = em.createQuery("select x from funcionarios x where x.nome like :parametro ");
			query.setParameter("parametro", "%" + nome + "%");
			result = query.getResultList();
			
		} catch (Exception ex) {
			LOGGER.severe(ex.getMessage());
		}
		return result;
	}
        
        /*public Produto buscaPorCodigo(int codigo) {
		Produto result = null;

		try {

			Query query = em.createQuery("select x from produtos x where x.codigo = :parametro ");
			query.setParameter("parametro", codigo);
			result = query.;
			
		} catch (Exception ex) {
			LOGGER.severe(ex.getMessage());
		}
		return result;
	}*/
	
	
	
	private void limpa() {
		this.em.flush();
		this.em.clear();
	}
	
	public void removeAll() {
		this.em.getTransaction().begin();
		this.em.createQuery("delete from funcionarios").executeUpdate();
		this.em.flush();
		this.em.getTransaction().commit();
	}
}


