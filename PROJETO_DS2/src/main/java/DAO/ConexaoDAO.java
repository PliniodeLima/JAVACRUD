package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexaoDAO {
    public Connection conectaBd( ){
        Connection conn = null;
        
        try {
        String url = "jdbc:mysql://localhost/clientes?user=root&password=";
        conn = DriverManager.getConnection(url);
        
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,erro.getMessage());
        }
        return conn;
    }
}
