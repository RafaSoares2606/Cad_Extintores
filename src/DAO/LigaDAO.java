/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

 
public class LigaDAO {
    
    public Connection conectaBD() throws java.sql.SQLException {
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/db_extintor?user=root&password=963852";
            conn = DriverManager.getConnection(url);
            
            if(conn != null) {
                System.out.println("Concluído");
            }
        } 
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
        
return conn;
    }
    
}
