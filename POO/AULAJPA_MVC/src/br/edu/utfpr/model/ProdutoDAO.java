/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.model;

import javax.persistence.EntityManager;
//import br.edu.utfpr.model.tipos.BancoDeDados;
import java.util.logging.Logger;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author kelly
 */
public class ProdutoDAO{
    private final DAO<Produto> dao;
    private EntityManager em;
    private static final Logger LOGGER = Logger.getLogger(JpaUtil.class.getName());
    
    public ProdutoDAO(){
        //if (bancoDeDados == BancoDeDados.POSTGRES) {
            this.em = JpaUtil.getEmPostgres();
        //}
        this.dao = new DAO<Produto>(em, Produto.class);
    }
    
    public void adiciona(Produto produto) {
		this.dao.adiciona(produto);
	}

	public void remove(Produto produto) {
		this.dao.remove(produto);
	}

	public Produto atualiza(Produto produto) {
		produto = this.dao.atualiza(produto);
		return produto;
	}

	public List<Produto> lista() {
		return this.dao.lista();
	}

	public Produto busca(Integer id) {
		return dao.busca(id);
	}

	public List<Produto> buscaPorNome(String nome) {
		List<Produto> result = null;

		try {

			Query query = em.createQuery("select x from produtos x where x.nome like :parametro ");
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
		this.em.createQuery("delete from produtos").executeUpdate();
		this.em.flush();
		this.em.getTransaction().commit();
	}
}
