/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.legnu.view;

import br.com.legnu.controller.ModuloConexao;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ad3ln0r
 */
public class telaLogin extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void sobre(){
        telaSobre sobre = new telaSobre();
        sobre.setVisible(true);
    }
    
    public void logar() {
        String sql = "select * from tbusuarios where login =? and senha =?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtLogin.getText());
            String captura = new String(pwLogin.getPassword());
            pst.setString(2, captura);
            
            rs = pst.executeQuery();
            
            if (rs.next()) {
                this.dispose();                
                telaPrincipal principal = new telaPrincipal();
                principal.setVisible(true);  
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "usuario e/ou senha invalido(s)");
            }
        } catch (NullPointerException e) {    
            JOptionPane.showMessageDialog(null, "Erro na conexao do banco de dados, verifique sua conexão ou sua mensalidade.");
            
        } catch (Exception e){            
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Creates new form telaLogin
     */
    public telaLogin() {
        initComponents();
        
        conexao = ModuloConexao.conector();
        System.out.println(conexao);
        
        if (conexao != null) {
            lblResultado.setText("Conectado ao Banco de Dados");
            lblResultado.setForeground(Color.GREEN);
        } else {
            lblResultado.setText("Não Conectado ao MySQL");
            lblResultado.setForeground(Color.RED);
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

        txtLogin = new javax.swing.JTextField();
        pwLogin = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JToggleButton();
        lblUsuario = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        btnLogo = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        lblResultado = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setName("jfLogin"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLogin.setName("txtLogin"); // NOI18N
        getContentPane().add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 207, 202, -1));

        pwLogin.setName("pwLogin"); // NOI18N
        getContentPane().add(pwLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 251, 202, -1));

        btnLogin.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnLogin.setText("Logar");
        btnLogin.setName("btnLogin"); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 302, 260, 47));
        btnLogin.getAccessibleContext().setAccessibleName("btnLogin");

        lblUsuario.setBackground(new java.awt.Color(204, 204, 204));
        lblUsuario.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(204, 204, 204));
        lblUsuario.setText("Usuario:");
        lblUsuario.setName("lblUsuarioLogin"); // NOI18N
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 199, -1, 39));
        lblUsuario.getAccessibleContext().setAccessibleDescription("lblUsuarioLogin");

        lblSenha.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(204, 204, 204));
        lblSenha.setText("Senha:");
        lblSenha.setName("lblUsuarioSenha"); // NOI18N
        getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 254, -1, -1));
        lblSenha.getAccessibleContext().setAccessibleDescription("lblUsuarioSenha");

        btnLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/Logo_200x164.png"))); // NOI18N
        btnLogo.setBorderPainted(false);
        btnLogo.setContentAreaFilled(false);
        btnLogo.setFocusPainted(false);
        btnLogo.setFocusable(false);
        btnLogo.setRequestFocusEnabled(false);
        btnLogo.setRolloverEnabled(false);
        btnLogo.setVerifyInputWhenFocusTarget(false);
        btnLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 17, 200, 164));

        lblStatus.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(204, 204, 204));
        lblStatus.setText("Status:");
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblResultado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblResultado.setText("...");
        getContentPane().add(lblResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/fundoTelaLogin.jpg"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        logar();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoActionPerformed
        sobre();
    }//GEN-LAST:event_btnLogoActionPerformed

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
            java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnLogin;
    private javax.swing.JButton btnLogo;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pwLogin;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables
}
