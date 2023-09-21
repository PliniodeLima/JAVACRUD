package VIEW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class frmSearchCliente extends javax.swing.JFrame {

    /**
     * Creates new form frmUpdateCliente
     */
    public frmSearchCliente() {
        initComponents();
        
                btnPesquisarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpfPesquisado = txtSearchCPF.getText();
                buscarClientePorCPF(cpfPesquisado);
            }
        });
                
                btnDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpfDeletar = txtSearchCPF.getText();
                int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o cliente?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    deletarClientePorCPF(cpfDeletar);
                    frmPrincipal btnDeletar = new frmPrincipal();
                    btnDeletar.setVisible(true);
                }
            }
        });
                

    }
    
    
        private void buscarClientePorCPF(String cpf) {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        try {
            // Estabelecer a conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/clientes", "root", "");

            // Consulta SQL para buscar os dados do cliente com base no CPF
            String consulta = "SELECT nome, email, telefone FROM clientes WHERE cpf = ?";
            stmt = conexao.prepareStatement(consulta);
            stmt.setString(1, cpf);

            // Executar a consulta
            resultado = stmt.executeQuery();

            // Verificar se algum registro foi encontrado
            if (resultado.next()) {
                // Recuperar os dados do cliente
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String telefone = resultado.getString("telefone");

                // Exibir os dados do cliente nos JLabels
                lblNome.setText("Nome: " + nome);
                lblEmail.setText("Email: " + email);
                lblTelefone.setText("Telefone: " + telefone);
            } else {
                // Se nenhum cliente foi encontrado, exibir uma mensagem de erro
                lblNome.setText("Cliente não encontrado");
                lblEmail.setText("");
                lblTelefone.setText("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Fechar os recursos
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

        
        private void deletarClientePorCPF(String cpf) {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            // Estabelecer a conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/clientes", "root", "");

            // Consulta SQL para excluir o cliente com base no CPF
            String consulta = "DELETE FROM clientes WHERE cpf = ?";
            stmt = conexao.prepareStatement(consulta);
            stmt.setString(1, cpf);

            // Executar a consulta
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                // Cliente excluído com sucesso
                System.out.println("Cliente excluído com sucesso.");
            } else {
                // Nenhum cliente encontrado com o CPF especificado
                System.out.println("Nenhum cliente encontrado com o CPF especificado.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Fechar os recursos
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        txtTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSearchCPF = new javax.swing.JTextField();
        btnPesquisarCliente = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnAtualizarCliente = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTitulo.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtTitulo.setText("CUSTOMERS 3000");

        jLabel1.setText("Digite o CPF do cliente:");

        btnPesquisarCliente.setText("PESQUISAR");
        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarClienteActionPerformed(evt);
            }
        });

        lblNome.setText("Nome:");

        lblEmail.setText("Email:");

        lblTelefone.setText("Telefone:");

        btnMenu.setText("MENU");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnDeletar.setText("DELETAR");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnAtualizarCliente.setText("ATUALIZAR");
        btnAtualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnPesquisarCliente)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(txtTitulo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearchCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDeletar)
                                .addGap(52, 52, 52)
                                .addComponent(btnAtualizarCliente)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearchCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPesquisarCliente)
                .addGap(27, 27, 27)
                .addComponent(lblNome)
                .addGap(18, 18, 18)
                .addComponent(lblEmail)
                .addGap(18, 18, 18)
                .addComponent(lblTelefone)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMenu)
                    .addComponent(btnDeletar)
                    .addComponent(btnAtualizarCliente))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarClienteActionPerformed

    }//GEN-LAST:event_btnPesquisarClienteActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        frmPrincipal btnMenu = new frmPrincipal();
        this.dispose();
        btnMenu.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        frmPrincipal btnDeletar = new frmPrincipal();
        this.dispose();
        btnDeletar.setVisible(true);
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnAtualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarClienteActionPerformed
        frmAtualizarCliente btnAtualizarCliente = new frmAtualizarCliente();
        this.dispose();
        btnAtualizarCliente.setVisible(true);
    }//GEN-LAST:event_btnAtualizarClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmSearchCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSearchCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSearchCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSearchCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSearchCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarCliente;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtSearchCPF;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
