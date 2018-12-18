package com.needle.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	private static Connection conn;
	
	public static synchronized Connection getConnection() {
		if(conn != null)
			return conn;
		else {
			try {
				String user = "root";
				String pass = "root";
				String url = "jdbc:mysql://localhost:8889/hotel_db";
				
				conn = DriverManager.getConnection(url, user, pass);
				return conn;
			}catch(SQLException ex) {
				System.out.println("Error!! "+ex.getMessage());
				return conn;
			}
		}
	}
	
	public static synchronized void closeConnection(){
        if(conn != null)
            conn = null;
        try{
            conn.close();
        }catch(SQLException ex){
            
        }
    }
}
