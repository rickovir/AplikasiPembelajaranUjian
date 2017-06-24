/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ricko
 */
public class Model extends Database{
    private String sql;
    
    public Model()
    {
        super();
        sql = "";
    }
    public void reset()
    {
        sql = "";
    }
    public void insert(String table, ArrayList<String> cols, ArrayList<String> rows)
    {
        sql = "insert into "+table+"(";
        for(int i=0; i<cols.size(); i++)
        {
            sql = sql + cols.get(i);
            if(i < cols.size()-1)
                sql = sql+",";
        }
        sql = sql + ") values(";
        for(int i=0; i<rows.size(); i++)
        {
            sql = sql + "'" +rows.get(i)+"'";
            if(i < rows.size()-1)
                sql = sql+",";
        }
        sql = sql + ")";
        modifyDataTable(sql);
    }
    
    public void insert(String table, ArrayList<String> rows)
    {
        sql = "insert into "+table+" values(";
        for(int i=0; i<rows.size(); i++)
        {
            sql = sql + "'" +rows.get(i)+"'";
            if(i < rows.size()-1)
                sql = sql+",";
        }
        sql = sql + ")";
        modifyDataTable(sql);
    }
    
    public void update(String table, ArrayList<String> cols, ArrayList<String> rows)
    {
        sql = "update "+table+ " set ";
        for(int i=1; i<rows.size(); i++)
        {
            sql = sql + cols.get(i) +" = '" +rows.get(i)+"'";
            if(i < rows.size()-1)
                sql = sql+",";
        }
        sql = sql + " where "+ cols.get(0)+ " = "+rows.get(0);
        modifyDataTable(sql);
    }
    
    public void delete(String table, int id)
    {
        sql = "delete from "+table+" where id"+table+" = '"+id+"'";
        modifyDataTable(sql);
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
        Model option = new Model();
        sql = "select * from "+table;
        option = this;
        return option;
    }
    
    public ResultSet where(Object ob)
    {
        ResultSet res = null;
        return res;
    }
    public ResultSet like(String col, String key)
    {
        ResultSet res;
        sql = sql + " where " + col + " like '%"+key+"%' ";
        System.out.println(sql);
        res = selectDataTable(sql);
        return res;
    }
    
    public int randInt(int min, int max) {

    // NOTE: This will (intentionally) not run as written so that folks
    // copy-pasting have to think about how to initialize their
    // Random instance.  Initialization of the Random instance is outside
    // the main scope of the question, but some decent options are to have
    // a field that is initialized once and then re-used as needed or to
    // use ThreadLocalRandom (if using at least Java 1.7).
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
    }
    
}
