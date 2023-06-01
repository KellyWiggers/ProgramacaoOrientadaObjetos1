/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.model;
import br.edu.utfpr.entidades.Funcionario;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author kelly
 */
public class FuncionarioListModel extends AbstractTableModel {
    private List<Funcionario> listaFuncionario;
    
    private String[] colunas = new String[]{"Código", "Nome", "Função", "Salário Bruto", "Comissão", "Salário Líquido"};
    
    
     public FuncionarioListModel(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

    @Override
    public int getRowCount() {
        return listaFuncionario.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Funcionario funcionario = listaFuncionario.get(row);
        switch (column) {
            case 0:
                return funcionario.getCodigoFuncionario();
            case 1:
                return funcionario.getNomeFuncionario();
            case 2:
                return funcionario.getFuncaoFuncionario();
            case 3:
                return funcionario.getSalarioBrutoFuncionario();
            case 4:
                return funcionario.getComissao();
            case 5:
                return funcionario.getSalarioLiquidoFuncionario();
            default:
                break;
        }
        return funcionario;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void insertModel(Funcionario funcionario) {
        listaFuncionario.add(funcionario);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeModel(int indexRow) {
        listaFuncionario.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void atualizarModel(int indiceLinha,Funcionario funcionario) {
        listaFuncionario.set(indiceLinha, funcionario);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }
    
    
}
