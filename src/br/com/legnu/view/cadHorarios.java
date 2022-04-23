/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.legnu.view;

import br.com.legnu.controller.ModuloConexao;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class cadHorarios extends javax.swing.JFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public cadHorarios() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    private void Iniciar() {
        String sql = "select idhorario as ID, horario as Horario from horario";
        try {
            pst = conexao.prepareStatement(sql);           
            rs = pst.executeQuery();
            //A Linha Abaixo usa a Biblioteca rs2xml para preencher a tabela
            tbHorarios.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        limpar();
    }
    
    public void setar_campos() {   
        int setar = tbHorarios.getSelectedRow();
        txtId.setText(tbHorarios.getModel().getValueAt(setar, 0).toString());
        txtHorarios.setText(tbHorarios.getModel().getValueAt(setar, 1).toString());      
        btnAdicionar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnRemover.setEnabled(true);
     }  
    
    public void limpar(){
        txtId.setText(null);
        txtHorarios.setText(null);
        btnAdicionar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnRemover.setEnabled(true);
        btnAtualizar.setEnabled(true);
        
    }
    
    private void adicionar() {
        String sql = "insert into horarios(horario)values(?)";
        try {
            pst = conexao.prepareStatement(sql);          
           
            pst.setString(1, txtHorarios.getText());
           

            //Validação dos Campos Obrigatorios
            if ((txtHorarios.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
            } else {

                //A linha abaixo atualiza os dados do novo usuario
                int adicionado = pst.executeUpdate();
                //A Linha abaixo serve de apoio ao entendimento da logica
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Horario adicionado com sucesso");
                    limpar();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterar() {
        String sql = "update horarios set horario where idhorario=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtHorarios.getText());
            pst.setString(2, txtId.getText());
          

            if ((txtHorarios.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
            } else {

                //A linha abaixo altera os dados do novo usuario
                int adicionado = pst.executeUpdate();
                //A Linha abaixo serve de apoio ao entendimento da logica
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Horario do produto alterado(s) com sucesso");
                    limpar();

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este Horario?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from horarios where idhorario=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Horario removido com sucesso");
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

        jButton1 = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        lblHorarios = new javax.swing.JLabel();
        lblCamposObregatoris = new javax.swing.JLabel();
        txtHorarios = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        scHorarios = new javax.swing.JScrollPane();
        tbHorarios = new javax.swing.JTable();
        fundo = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(204, 204, 204));
        lblId.setText("ID:");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        lblHorarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblHorarios.setForeground(new java.awt.Color(204, 204, 204));
        lblHorarios.setText("Horario:");
        getContentPane().add(lblHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        lblCamposObregatoris.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCamposObregatoris.setForeground(new java.awt.Color(204, 204, 204));
        lblCamposObregatoris.setText("*Campos Obrigatorios");
        getContentPane().add(lblCamposObregatoris, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        txtHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorariosActionPerformed(evt);
            }
        });
        getContentPane().add(txtHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 410, -1));

        txtId.setEnabled(false);
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 50, -1));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeAdicionar-removebg-preview.png"))); // NOI18N
        btnAdicionar.setContentAreaFilled(false);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, -1));

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeRemover-removebg-preview.png"))); // NOI18N
        btnRemover.setContentAreaFilled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeEditar-removebg-preview.png"))); // NOI18N
        btnEditar.setContentAreaFilled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, -1, -1));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeRestart-removebg-preview.png"))); // NOI18N
        btnAtualizar.setContentAreaFilled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, -1, -1));

        tbHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Horario"
            }
        ));
        tbHorarios.setFocusable(false);
        tbHorarios.getTableHeader().setReorderingAllowed(false);
        scHorarios.setViewportView(tbHorarios);

        getContentPane().add(scHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 470, 340));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/Fundo=960x500.png"))); // NOI18N
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
       adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorariosActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed

        remover();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_btnAtualizarActionPerformed

   
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
            java.util.logging.Logger.getLogger(cadHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadHorarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel fundo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCamposObregatoris;
    private javax.swing.JLabel lblHorarios;
    private javax.swing.JLabel lblId;
    private javax.swing.JScrollPane scHorarios;
    private javax.swing.JTable tbHorarios;
    private javax.swing.JTextField txtHorarios;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
