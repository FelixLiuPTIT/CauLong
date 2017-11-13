/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author HIEU
 */
public class ButtonRender extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, 
            boolean isSelected, boolean isFocused, int row, int col) {
        if(o instanceof JButton){
            JButton btn = (JButton) o;
            return btn;
        }
        return super.getTableCellRendererComponent(jtable, o, isSelected, isFocused, row, col); //To change body of generated methods, choose Tools | Templates.
       
    }
    
}
