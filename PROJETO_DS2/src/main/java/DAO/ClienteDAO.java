package DAO;

import DTO.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClienteDAO {

       Connection conn;
       PreparedStatement pstm;
       
   public void cadastrarCliente (ClienteDTO objclientedto){
       String sql = "insert into clientes (nome, CPF, email, telefone) values (?, ?, ?, ?)";
       
       conn = new ConexaoDAO().conectaBd();
       
       try {
           
           pstm = conn.prepareStatement (sql);
           pstm.setString(1, objclientedto.getNome_cliente());
           pstm.setString(2, objclientedto.getCPF_cliente());
           pstm.setString(3, objclientedto.getEmail_cliente());
           pstm.setString(4, objclientedto.getTelefone_cliente());
           
           
           pstm.execute();
           pstm.close();
           
       } catch (SQLException erro) {
           JOptionPane.showMessageDialog(null, "Classe ClienteDAO" + erro);
       }
   }
   
}
