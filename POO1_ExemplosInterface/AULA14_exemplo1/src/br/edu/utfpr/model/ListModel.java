/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.model;

import br.edu.utfpr.entidades.Produto;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author kelly
 */
public class ListModel extends AbstractListModel{
    private List<Produto> listaProduto;

    public ListModel(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }
    
    
    
    @Override
    public int getSize() {
       return listaProduto.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listaProduto.get(index);
    }
    
    public void adicionar(){
      
        fireContentsChanged(this, 0, getSize()-1);
    }
    
    public void remover(int index){
      listaProduto.remove(index);
        fireContentsChanged(this, 0, getSize()-1);
    }
}

