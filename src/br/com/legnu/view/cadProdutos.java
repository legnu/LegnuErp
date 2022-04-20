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

/**
 *
 * @author Ad3ln0r
 */
public class cadProdutos extends javax.swing.JFrame {
    
    
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form cadProdutos
     */
    public cadProdutos() {
        initComponents();
        conexao = ModuloConexao.conector();
        
    }
    
   
    public void InstanciarCombobox(){
        try {
            cbCategoria.addItem("SELECIONE");
            String sql = "select categoria from categorias";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                  cbCategoria.addItem(rs.getString("categoria"));
            }
        } catch (Exception sqlEx) {
        
        }
    }
      
    
    
    public void Categorias(){
        telaCategoria categoria = new telaCategoria();
        categoria.setVisible(true);
    }
    
    private void limpar() {
        txtId.setText(null);
        txtCodigoDeBarras.setText(null);
        txtCusto.setText(null);
        txtDescricao.setText(null);
        txtPesquisa.setText(null);
        txtPrecoVenda.setText(null);
        btnAdicionar.setEnabled(true);
        btnAtualizar.setEnabled(true);
        btnCategoria.setEnabled(true);
        btnEditar.setEnabled(false);
        btnRemover.setEnabled(false);
                
    }
    
    private void pesquisar_cliente() {
        String sql = "select * from tbprodutos where produto like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPesquisa.getText() + "%");
            rs = pst.executeQuery();
            //A Linha Abaixo usa a Biblioteca rs2xml para preencher a tabela
            tbProdutos.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void setar_campos() {
        int setar = tbProdutos.getSelectedRow();
        txtCodigoDeBarras.setText(tbProdutos.getModel().getValueAt(setar, 2).toString());
        txtCusto.setText(tbProdutos.getModel().getValueAt(setar, 4).toString());
        txtDescricao.setText(tbProdutos.getModel().getValueAt(setar, 3).toString());
        txtId.setText(tbProdutos.getModel().getValueAt(setar, 1).toString());
        txtFornecedor.setText(tbProdutos.getModel().getValueAt(setar, 6).toString());
        taOBS.setText(tbProdutos.getModel().getValueAt(setar, 7).toString());
        txtPrecoVenda.setText(tbProdutos.getModel().getValueAt(setar, 5).toString());
        
        
       
      
        //A Linha Abaixo desabilita o botão adicionar
        btnAdicionar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnRemover.setEnabled(true);
    }
    
    private void consultar() {
        String sql = "select * from tbprodutos where produto=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPesquisa.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtCodigoDeBarras.setText(rs.getString(2));
                txtCusto.setText(rs.getString(4));
                txtDescricao.setText(rs.getString(3));
                txtPrecoVenda.setText(rs.getString(5));
                taOBS.setText(rs.getString(7));
                     
             
                btnRemover.setEnabled(true);
                btnEditar.setEnabled(true);
                btnAdicionar.setEnabled(false);
                
            } else {
                JOptionPane.showMessageDialog(null, "Produto não cadastrado");
                limpar();               
            }          
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }    
    
    private void adicionar() {
        String sql = "insert into tbprodutos(idproduto,codigo,produto,custo,preco,categoria,obs)values(?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(0, txtId.getText());
            pst.setString(1, txtCodigoDeBarras.getText());
            pst.setString(2, txtDescricao.getText());
            pst.setString(3, txtCusto.getText());
            pst.setString(4, txtPrecoVenda.getText());
            pst.setString(5, cbCategoria.getItemAt(WIDTH));
            pst.setString(6, txtFornecedor.getText());
            pst.setString(7, taOBS.getText());

            //Validação dos Campos Obrigatorios
            if ((txtDescricao.getText().isEmpty()) || (txtCusto.getText().isEmpty()) || (txtPrecoVenda.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
            } else {

                //A linha abaixo atualiza os dados do novo usuario
                int adicionado = pst.executeUpdate();
                //A Linha abaixo serve de apoio ao entendimento da logica
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");
                    limpar();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterar() {
        String sql = "update tbprodutos set codigo=?,produto=?,custo=?,preco=?,categoria=?,obs=? where idpro=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCodigoDeBarras.getText());
            pst.setString(2, txtDescricao.getText());
            pst.setString(3, txtCusto.getText());
            pst.setString(4, txtPrecoVenda.getText());
            pst.setString(5, cbCategoria.getName());
            pst.setString(6, taOBS.getText());
            pst.setString(7, txtId.getText());

            if ((txtDescricao.getText().isEmpty()) || (txtCusto.getText().isEmpty()) || (txtPrecoVenda.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
            } else {

                //A linha abaixo altera os dados do novo usuario
                int adicionado = pst.executeUpdate();
                //A Linha abaixo serve de apoio ao entendimento da logica
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do produto alterado(s) com sucesso");
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
            String sql = "delete from tbprodutos where idpro=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
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

        lblPrecoVenda = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblCodigoDeBarras = new javax.swing.JLabel();
        lblCusto = new javax.swing.JLabel();
        lblCamposObrigatorios = new javax.swing.JLabel();
        lblPesquisa = new javax.swing.JLabel();
        lblCategorias = new javax.swing.JLabel();
        lblOBS = new javax.swing.JLabel();
        txtPrecoVenda = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtCodigoDeBarras = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtCusto = new javax.swing.JTextField();
        txtFornecedor = new javax.swing.JTextField();
        txtPesquisa = new javax.swing.JTextField();
        btnCategoria = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        cbCategoria = new javax.swing.JComboBox<>();
        scTabela = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        scOBS = new javax.swing.JScrollPane();
        taOBS = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        Fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPrecoVenda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPrecoVenda.setForeground(new java.awt.Color(204, 204, 204));
        lblPrecoVenda.setText("*Preço de venda(R$): ");
        getContentPane().add(lblPrecoVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, -1));

        lblDescricao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDescricao.setForeground(new java.awt.Color(204, 204, 204));
        lblDescricao.setText("  *Descrição:");
        getContentPane().add(lblDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        lblId.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(204, 204, 204));
        lblId.setText("Id:");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 20, -1));

        lblCodigoDeBarras.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCodigoDeBarras.setForeground(new java.awt.Color(204, 204, 204));
        lblCodigoDeBarras.setText("Código de Barras:");
        getContentPane().add(lblCodigoDeBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        lblCusto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCusto.setForeground(new java.awt.Color(204, 204, 204));
        lblCusto.setText("*Custo(R$):");
        getContentPane().add(lblCusto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        lblCamposObrigatorios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCamposObrigatorios.setForeground(new java.awt.Color(204, 204, 204));
        lblCamposObrigatorios.setText("*Campos Obrigatorios");
        getContentPane().add(lblCamposObrigatorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, -1, -1));

        lblPesquisa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPesquisa.setForeground(new java.awt.Color(204, 204, 204));
        lblPesquisa.setText("Pesquisa:");
        getContentPane().add(lblPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblCategorias.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCategorias.setForeground(new java.awt.Color(204, 204, 204));
        lblCategorias.setText("Categoria:");
        getContentPane().add(lblCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, -1, -1));

        lblOBS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblOBS.setForeground(new java.awt.Color(204, 204, 204));
        lblOBS.setText("OBS:");
        getContentPane().add(lblOBS, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, -1, -1));

        txtPrecoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoVendaActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrecoVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 80, -1));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 420, -1));

        txtCodigoDeBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoDeBarrasActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigoDeBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 130, -1));

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });
        getContentPane().add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 460, -1));

        txtCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCusto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 80, -1));
        getContentPane().add(txtFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 210, -1));

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
        getContentPane().add(txtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 270, -1));

        btnCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/plus.png"))); // NOI18N
        btnCategoria.setContentAreaFilled(false);
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 310, 40, 30));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeRestart-removebg-preview.png"))); // NOI18N
        btnAtualizar.setContentAreaFilled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, -1, -1));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeAdicionar-removebg-preview.png"))); // NOI18N
        btnAdicionar.setContentAreaFilled(false);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeEditar-removebg-preview.png"))); // NOI18N
        btnEditar.setContentAreaFilled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, -1, -1));

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconeRemover-removebg-preview.png"))); // NOI18N
        btnRemover.setContentAreaFilled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));

        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(cbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, 300, -1));

        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProdutosMouseClicked(evt);
            }
        });
        scTabela.setViewportView(tbProdutos);

        getContentPane().add(scTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 900, 100));

        taOBS.setColumns(20);
        taOBS.setRows(5);
        scOBS.setViewportView(taOBS);

        getContentPane().add(scOBS, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 300, 110));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Fornecedor:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

        Fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/Fundo=960x500.png"))); // NOI18N
        getContentPane().add(Fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtCodigoDeBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoDeBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoDeBarrasActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void txtPrecoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoVendaActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        // TODO add your handling code here:
        Categorias();
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void txtCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        // TODO add your handling code here:
        pesquisar_cliente();
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void tbProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutosMouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_tbProdutosMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        InstanciarCombobox();
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(cadProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fundo;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCamposObrigatorios;
    private javax.swing.JLabel lblCategorias;
    private javax.swing.JLabel lblCodigoDeBarras;
    private javax.swing.JLabel lblCusto;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblOBS;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JLabel lblPrecoVenda;
    private javax.swing.JScrollPane scOBS;
    private javax.swing.JScrollPane scTabela;
    private javax.swing.JTextArea taOBS;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTextField txtCodigoDeBarras;
    private javax.swing.JTextField txtCusto;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtPrecoVenda;
    // End of variables declaration//GEN-END:variables
}
