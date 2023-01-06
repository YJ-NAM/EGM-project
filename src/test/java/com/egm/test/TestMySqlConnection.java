package com.egm.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class TestMySqlConnection {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/mysql";
    private String username = "root";
    private String password = "1234";
	
    @Test
    public void TestConnection() throws ClassNotFoundException, SQLException{		 
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println(con); 
		System.out.println("Connection success");
		
        PreparedStatement pstmt = con.prepareStatement("select * from user");        
        ResultSet rs = pstmt.executeQuery();
        System.out.println(rs);
        while(rs.next()) {
            System.out.println(rs.getString(1));
        }
		
    }
    
}
