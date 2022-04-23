/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.legnu.view;


import br.com.legnu.controller.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Ad3ln0r
 */
public class cadServicos extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public cadServicos() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPesquisa = new javax.swing.JLabel();
        lblCamposObrigatorios = new javax.swing.JLabel();
        lblOBS = new javax.swing.JLabel();
        lblServico = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        txtServico = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        scOBS = new javax.swing.JScrollPane();
        taOBS = new javax.swing.JTextArea();
        scServicos = new javax.swing.JScrollPane();
        tbServicos = new javax.swing.JTable();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPesquisa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPesquisa.setForeground(new java.awt.Color(204, 204, 204));
        lblPesquisa.setText("Pesquisar:");
        getContentPane().add(lblPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblCamposObrigatorios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCamposObrigatorios.setForeground(new java.awt.Color(204, 204, 204));
        lblCamposObrigatorios.setText("*Campos Obrigatorios");
        getContentPane().add(lblCamposObrigatorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, -1));

        lblOBS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblOBS.setForeground(new java.awt.Color(204, 204, 204));
        lblOBS.setText("OBS:");
        getContentPane().add(lblOBS, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        lblServico.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblServico.setForeground(new java.awt.Color(204, 204, 204));
        lblServico.setText("Serviço:");
        getContentPane().add(lblServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        lblPreco.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPreco.setForeground(new java.awt.Color(204, 204, 204));
        lblPreco.setText("Preço(R$):");
        getContentPane().add(lblPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, -1, -1));
        getContentPane().add(txtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 260, -1));

        txtServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServicoActionPerformed(evt);
            }
        });
        getContentPane().add(txtServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 310, -1));

        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });
        getContentPane().add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 360, -1));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeAdicionar-removebg-preview.png"))); // NOI18N
        btnAdicionar.setContentAreaFilled(false);
        getContentPane().add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeEditar-removebg-preview.png"))); // NOI18N
        btnEditar.setContentAreaFilled(false);
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, -1, -1));

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeRemover-removebg-preview.png"))); // NOI18N
        btnRemover.setContentAreaFilled(false);
        getContentPane().add(btnRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, -1, -1));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeRestart-removebg-preview.png"))); // NOI18N
        btnAtualizar.setContentAreaFilled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, -1, -1));

        taOBS.setColumns(20);
        taOBS.setRows(5);
        scOBS.setViewportView(taOBS);

        getContentPane().add(scOBS, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 790, -1));

        tbServicos.setModel(new javax.swing.table.DefaultTableModel(
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
        scServicos.setViewportView(tbServicos);

        getContentPane().add(scServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 870, 100));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/Fundo=960x500.png"))); // NOI18N
        fundo.setToolTipText("");
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServicoActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

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
            java.util.logging.Logger.getLogger(cadServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadServicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel lblCamposObrigatorios;
    private javax.swing.JLabel lblOBS;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblServico;
    private javax.swing.JScrollPane scOBS;
    private javax.swing.JScrollPane scServicos;
    private javax.swing.JTextArea taOBS;
    private javax.swing.JTable tbServicos;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtServico;
    // End of variables declaration//GEN-END:variables
}
