/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ricko
 */
public class Model extends Database{
    private String sql;
    private TableField field;
    
    public Model()
    {
        super();
        field = new TableField();
        sql = "";
    }
    public void reset()
    {
        sql = "";
        field = new TableField();
    }
    public void insert(String table, Object data)
    {
        sql = "insert into "+table;
        field.setField(data);
        
        ArrayList<String> col = field.getField();
        ArrayList<String> val = field.getValue();
        
        String block = "id"+table;
        
        col.remove("modelTable");
        col.remove("tableField");
        
        sql = sql + "(";
        for(int i=0; i<col.size(); i++)
        {
            if(col.get(i) != block)
            {
                sql = sql + col.get(i);
                if(i < (col.size()-1))
                    sql = sql + ",";
            }
        }
        sql = sql + ") values(";
        for(int i=0; i<col.size(); i++)
        {
            if(col.get(i) != block)
            {
                sql = sql + "'"+val.get(i)+"'";
                if(i < (col.size()-1))
                    sql = sql + ",";
            }
        }
        sql = sql + ")";
        modifyDataTable(sql);
        reset();
   }
    
    public void update(String table, Object data)
    {
        
    }
    
    public void delete(String table, int id)
    {
        
    }
    
    public ResultSet selectAll(String table)
    {
        ResultSet result;
        sql = "select * from "+table;
        result = selectDataTable(sql);
        return result;
    }
    
    public Model selectOption(String table)
    {
        Model option = null;
        sql = "select * from "+table;
        option = this;
        return option;
    }
    
    public Object where(Object ob)
    {
        Object result;
        
        field.setField(ob);
        
        ArrayList<String> col = field.getField();
        ArrayList<String> val = field.getValue();
        
        for(int i=0; i<col.size(); i++)
        {
            sql = sql + " " +col.get(i)+" = "+val.get(i);
            if(i < (col.size()-1))
                sql = sql + " AND";
        }
        result = selectDataTable(sql);
        return result;
    }
}
