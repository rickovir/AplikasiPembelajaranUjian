/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.sql.*;

import javax.swing.JOptionPane;

/**
 *
 * @author Ricko
 */
public class Database {
    private String dbUrl;
    private String username;
    private String password;
    private Connection connection;
    private Statement statement;
    
    public Database()
    {
        // definition connection setting
        dbUrl = "jdbc:mysql://localhost:3306/pembelajaran_ujian";
        username = "root";
        password = "";
        init();
    }
    
    public void init()
    {
        // this is initialitation  for connection
        if(connection == null)
        {
            try
            {
                // register jdbc driver
                Class.forName("com.mysql.jdbc.Driver");
                //open connection
                connection = DriverManager.getConnection(dbUrl, username, password);
                //statement for execute query
                statement = connection.createStatement();
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "Connection Error occurred : "+e);
            }
        }
    }
    
    public ResultSet select(String sql)
    {
        ResultSet resultSet = null;
        try
        {
            resultSet = statement.executeQuery(sql);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Select data : "+e);
        }
        return resultSet;
    }
    public void update(String sql)
    {
        try
        {
            statement.executeUpdate(sql);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Update data : "+e);
        }
    }
    public void insert(String sql)
    {
        try
        {
            statement.executeUpdate(sql);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error Update data : "+e);
        }
    }
    
    public void closeService()
    {
        try{
            connection.close();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Problem close connection");
        }
    }
}
