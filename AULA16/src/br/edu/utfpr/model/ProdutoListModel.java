/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.model;

import br.edu.utfpr.entidades.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kelly
 */
public class ProdutoListModel extends AbstractTableModel {
    private List<Produto> listaProduto;
    
    private String[] colunas = new String[]{"Código", "Nome", "Setor", "Quantidade", "Preço de custo", "Preço de venda"};
    
    
     public ProdutoListModel(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    @Override
    public int getRowCount() {
        return listaProduto.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Produto produto = listaProduto.get(row);
        switch (column) {
            case 0:
                return produto.getCodigo();
            case 1:
                return produto.getNome();
            case 2:
                return produto.getSetor();
            case 3:
                return produto.getQuantidade();
            case 4:
                return produto.getPrecoCusto();
            case 5:
                return produto.getPrecoVenda();
            default:
                break;
        }
        return produto;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void insertModel(Produto produto) {
        listaProduto.add(produto);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeModel(int indexRow) {
        listaProduto.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void atualizarModel(int indiceLinha,Produto produto) {
        listaProduto.set(indiceLinha, produto);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }
    
    
}
