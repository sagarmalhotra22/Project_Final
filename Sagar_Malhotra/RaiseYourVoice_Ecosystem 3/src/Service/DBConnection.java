/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author sagar
 */
public class DBConnection {
       public Connection getDbcon(){
		Connection con=null;
		OracleDataSource ods;
		try{
			ods=new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:hr/hr@localhost:1521:orcl");
                        
			con=ods.getConnection("C##aed","Aed12345");
		}
		catch(SQLException e){
                    System.out.println("Service.DBConnection.getDbcon()");
			e.printStackTrace();
		}
		return con;
       }
}
