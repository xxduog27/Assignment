/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trand
 */
public class DBContext {
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=car;encrypt=true;trustServerCertificate=true;";
    private final String username = "sa";
    private final String password = "12345";
  

   private Connection connection;
   public DBContext()
   {
       try {          
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           connection = DriverManager.getConnection(url, username, password);
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
   }

   public Connection getConnection() {
        return this.connection;
    }
   
    public static void closeConnection(ResultSet rs, PreparedStatement pstm, Connection conn) throws SQLException
    {
        if(rs != null)
        {
            rs.close();
        }
        if(pstm != null)
        {
            pstm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

}
    

