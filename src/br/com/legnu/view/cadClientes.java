/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.legnu.view;

import br.com.legnu.controller.ModuloConexao;
import javax.swing.JOptionPane;
import java.sql.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Ad3ln0r
 */
public class cadClientes extends javax.swing.JFrame {

     Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form cadClientes
     */
    public cadClientes() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    private void limpar() {
        txtEmail.setText(null);
        txtEndereco.setText(null);
        txtNome.setText(null);
        txtPesquisa.setText(null);
        txtTelefone.setText(null);
        btnAdicionar.setEnabled(true);
        btnAtualizar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnRemover.setEnabled(false);
        
    }
    
    private void pesquisar_cliente() {
        String sql = "select * from tbclientes where nomecli like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPesquisa.getText() + "%");
            rs = pst.executeQuery();
            //A Linha Abaixo usa a Biblioteca rs2xml para preencher a tabela
            tbClientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void setar_campos() {
        int setar = tbClientes.getSelectedRow();
        txtNome.setText(tbClientes.getModel().getValueAt(setar, 1).toString());
        txtEndereco.setText(tbClientes.getModel().getValueAt(setar, 2).toString());
        txtTelefone.setText(tbClientes.getModel().getValueAt(setar, 3).toString());
        txtEmail.setText(tbClientes.getModel().getValueAt(setar, 4).toString());
       
      
        //A Linha Abaixo desabilita o botão adicionar
        btnAdicionar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnRemover.setEnabled(true);
    }
    
    private void adicionar() {
        String sql = "insert into tbclientes(nomecli,endcli,fonecli,emailcli)values(?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtEndereco.getText());
            pst.setString(3, txtTelefone.getText());
            pst.setString(4, txtEmail.getText());

            //Validação dos Campos Obrigatorios
            if ((txtNome.getText().isEmpty()) || (txtTelefone.getText().isEmpty())) {
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
        String sql = "update tbclientes set endcli=?,fonecli=?,emailcli=? where nomecli=?";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, txtEndereco.getText());
            pst.setString(2, txtTelefone.getText());
            pst.setString(3, txtEmail.getText());
            pst.setString(4, txtNome.getText());

            if ((txtNome.getText().isEmpty()) || (txtTelefone.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
            } else {

                //A linha abaixo altera os dados do novo usuario
                int adicionado = pst.executeUpdate();
                //A Linha abaixo serve de apoio ao entendimento da logica
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Cliente alterado(s) com sucesso");
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
            String sql = "delete from tbclientes where  nomecli=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtNome.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
                    limpar();                          
                    
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTelefone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblCampos = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblComplemento = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblEndereço = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtPesquisa = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnPesquisa = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        spClientes = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTelefone.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(204, 204, 204));
        lblTelefone.setText("  *Telefone:");
        getContentPane().add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, 20));

        lblEmail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(204, 204, 204));
        lblEmail.setText("   E-mail:");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        lblCampos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCampos.setForeground(new java.awt.Color(204, 204, 204));
        lblCampos.setText("*Campos Obrigatorios");
        getContentPane().add(lblCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, -1, -1));

        lblNome.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(204, 204, 204));
        lblNome.setText("  *Nome:");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        lblId.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(204, 204, 204));
        lblId.setText("  Id:");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        lblComplemento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblComplemento.setForeground(new java.awt.Color(204, 204, 204));
        lblComplemento.setText("Complemento:");
        getContentPane().add(lblComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, -1, -1));

        lblCidade.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCidade.setForeground(new java.awt.Color(204, 204, 204));
        lblCidade.setText("Cidade:");
        getContentPane().add(lblCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, -1, -1));

        lblEndereço.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEndereço.setForeground(new java.awt.Color(204, 204, 204));
        lblEndereço.setText("    Endereço:");
        getContentPane().add(lblEndereço, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, 20));

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });
        getContentPane().add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 700, -1));

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 230, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 320, -1));

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 700, -1));

        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        getContentPane().add(txtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 320, -1));
        getContentPane().add(txtComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 260, -1));
        getContentPane().add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 260, -1));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 40, -1));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeRestart-removebg-preview.png"))); // NOI18N
        btnAtualizar.setContentAreaFilled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, -1, -1));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeAdicionar-removebg-preview.png"))); // NOI18N
        btnAdicionar.setContentAreaFilled(false);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeEditar-removebg-preview.png"))); // NOI18N
        btnEditar.setContentAreaFilled(false);
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, -1, -1));

        btnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/lupa-removebg-preview.png"))); // NOI18N
        btnPesquisa.setContentAreaFilled(false);
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeRemover-removebg-preview.png"))); // NOI18N
        btnRemover.setContentAreaFilled(false);
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, -1, -1));

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientesMouseClicked(evt);
            }
        });
        spClientes.setViewportView(tbClientes);

        getContentPane().add(spClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 900, 120));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/Fundo=960x500.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        // TODO add your handling code here:
        pesquisar_cliente();
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void tbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientesMouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_tbClientesMouseClicked

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

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
            java.util.logging.Logger.getLogger(cadClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel lblCampos;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereço;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JScrollPane spClientes;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
