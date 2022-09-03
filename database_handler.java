package cad_lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database_handler {
    
    public database_handler()
    {
        final String DB_URL = "jdbc:mysql://localhost/";
        final String USER = "guest";
        final String PASS = "guest123";
        create_database("test", DB_URL, USER, PASS);
    }

    public void create_database(String name, String url, String user, String pass )
    {
        try(Connection conn = DriverManager.getConnection(url, user, pass);
        Statement stmt = conn.createStatement();
     ) {		      
        String sql = String.format("CREATE DATABASE %s", name);
        stmt.executeUpdate(sql);
        System.out.println("Database created successfully...");   	  
     } catch (SQLException e) {
        e.printStackTrace();
     } 
    }

}