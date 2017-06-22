/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ricko
 */
public class TableModel extends AbstractTableModel {
    private String[] columnNames = { "First Name", "Last Name", "Sport",
        "# of Years", "Vegetarian" };
    
    private List<String> cols;
    
    private List<Object> rows;

    private Object[][] data = {
        { "Mary", "Campione", "Snowboarding", new Integer(5),
            new Boolean(false) },
        { "Alison", "Huml", "Rowing", new Integer(3), new Boolean(true) },
        { "Kathy", "Walrath", "Knitting", new Integer(2),
            new Boolean(false) },
        { "Sharon", "Zakhour", "Speed reading", new Integer(20),
            new Boolean(true) },
        { "Philip", "Milne", "Pool", new Integer(10),
            new Boolean(false) } };

    public int getColumnCount() {
//      return columnNames.length;
        return cols.size();
    }

    public int getRowCount() {
//        return data.length;
        return rows.size();
    }

    public String getColumnName(int col) {
      return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
      return data[row][col];
    }
}
