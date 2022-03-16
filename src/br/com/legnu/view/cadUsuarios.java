/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.legnu.view;

import br.com.legnu.controller.ModuloConexao;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Ad3ln0r
 */
public class cadUsuarios extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form cadUsuarios
     */
    public cadUsuarios() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    public void sobre(){
        telaSobre sobre = new telaSobre();
        sobre.setVisible(true);
    }
    
    private void limpar() {
        tbUsuario.setText(null);
        tbCargo.setText(null);
        tbSenha.setText(null);
        tbId.setText(null);
        btnRemover.setEnabled(false);
        btnEditar.setEnabled(false);
        btnAdicionar.setEnabled(true);
        btnPesquisar.setEnabled(true);
    }

    private void consultar() {
        String sql = "select * from tbusuarios where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tbId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                tbUsuario.setText(rs.getString(3));
                tbSenha.setText(rs.getString(4));
                tbCargo.setText(rs.getString(2));
                btnRemover.setEnabled(true);
                btnEditar.setEnabled(true);
                btnAdicionar.setEnabled(false);
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
                limpar();               
            }          
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

          
    
    private void adicionar() {
        String sql = "insert into tbusuarios(iduser,cargo,login,senha)values(?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tbId.getText());
            pst.setString(2, tbCargo.getText());
            pst.setString(3, tbUsuario.getText());
            pst.setString(4, tbSenha.getText());

            //Validação dos Campos Obrigatorios
            if ((tbUsuario.getText().isEmpty()) || (tbCargo.getText().isEmpty()) || (tbSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
            } else {

                //A linha abaixo atualiza os dados do novo usuario
                int adicionado = pst.executeUpdate();
                //A Linha abaixo serve de apoio ao entendimento da logica
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");
                    limpar();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterar() {
        String sql = "update tbusuarios set cargo=?,login=?,senha=? where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, tbCargo.getText());
            pst.setString(2, tbUsuario.getText());
            pst.setString(3, tbSenha.getText());
            pst.setString(4, tbId.getText());

            if ((tbCargo.getText().isEmpty()) || (tbUsuario.getText().isEmpty()) || (tbSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
            } else {

                //A linha abaixo altera os dados do novo usuario
                int adicionado = pst.executeUpdate();
                //A Linha abaixo serve de apoio ao entendimento da logica
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do usuário alterado(s) com sucesso");
                    limpar();

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbusuarios where iduser=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, tbId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");
                    limpar();
                    
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
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

        lblId = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnLogo = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();
        tbId = new javax.swing.JTextField();
        tbUsuario = new javax.swing.JTextField();
        tbSenha = new javax.swing.JTextField();
        tbCargo = new javax.swing.JTextField();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setForeground(new java.awt.Color(204, 204, 204));
        lblId.setText("* Id");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        lblUsuario.setForeground(new java.awt.Color(204, 204, 204));
        lblUsuario.setText("* Usuario");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        lblSenha.setForeground(new java.awt.Color(204, 204, 204));
        lblSenha.setText("* Senha");
        getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        lblCargo.setForeground(new java.awt.Color(204, 204, 204));
        lblCargo.setText("* Cargo");
        getContentPane().add(lblCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, -1, -1));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeAdicionar-removebg-preview.png"))); // NOI18N
        btnAdicionar.setToolTipText("Adicionar");
        btnAdicionar.setContentAreaFilled(false);
        btnAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionar.setRequestFocusEnabled(false);
        btnAdicionar.setRolloverEnabled(false);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconePesquisa-removebg-preview (1).png"))); // NOI18N
        btnPesquisar.setToolTipText("Pesquisar");
        btnPesquisar.setContentAreaFilled(false);
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeEditar-removebg-preview.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setContentAreaFilled(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeRemover-removebg-preview.png"))); // NOI18N
        btnRemover.setToolTipText("Remover");
        btnRemover.setContentAreaFilled(false);
        btnRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, -1));

        btnLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/Logo_200x164.png"))); // NOI18N
        btnLogo.setContentAreaFilled(false);
        btnLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, -1, -1));

        btnRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeRestart-removebg-preview.png"))); // NOI18N
        btnRestaurar.setToolTipText("Restaurar");
        btnRestaurar.setContentAreaFilled(false);
        btnRestaurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, -1, -1));

        tbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbIdActionPerformed(evt);
            }
        });
        getContentPane().add(tbId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 120, -1));

        tbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(tbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 600, -1));

        tbSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(tbSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 300, -1));

        tbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbCargoActionPerformed(evt);
            }
        });
        getContentPane().add(tbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 200, -1));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/fundoTelaCadastro.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void tbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbUsuarioActionPerformed

    private void tbSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbSenhaActionPerformed

    private void tbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbCargoActionPerformed

    private void tbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbIdActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        alterar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        consultar();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        remover();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        limpar();
    }//GEN-LAST:event_btnRestaurarActionPerformed

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
            java.util.logging.Logger.getLogger(cadUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLogo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField tbCargo;
    private javax.swing.JTextField tbId;
    private javax.swing.JTextField tbSenha;
    private javax.swing.JTextField tbUsuario;
    // End of variables declaration//GEN-END:variables
}
