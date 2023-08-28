/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u09656283104
 */
public class UsuariosController extends AbstractTableModel{
    private List lista;
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
       return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return "";
    }
    @Override
    public String getColumnName(int column) {
        
        if(column == 0) {
           return "id"; 
        }
        if(column == 1) {
           return "Nome"; 
        }
        if(column == 2) {
           return "Apelido"; 
        }
        if(column == 3) {
           return "Cpf"; 
        }
        return "";
    }
    
    
}
