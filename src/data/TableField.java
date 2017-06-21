/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author Ricko
 */
public class TableField {
    private ArrayList<String> field;
    private ArrayList<String> value;
            
    public TableField()
    {
        field  = new ArrayList<String>();
        value  = new ArrayList<String>();
//        setField(newObject);
    }
    
    public void setField(Object o)
    {
        try
        {
            Class<?> clazz = o.getClass();
            for(Field field : clazz.getDeclaredFields()) {
                this.field.add(field.getName());
                this.value.add(field.get(o).toString());
            }
        } 
        catch (Exception x) 
        {
	    x.printStackTrace();
	} 
    }
    
    public ArrayList<String> getField()
    {
        return this.field;
    }
    public ArrayList<String> getValue()
    {
        return this.value;
    }
}
