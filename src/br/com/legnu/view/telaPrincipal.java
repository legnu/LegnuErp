/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.legnu.view;

/**
 *
 * @author Ad3ln0r
 */
public class telaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form telaPrincipal
     */
    public telaPrincipal() {
        initComponents();
    }
    public void CadastroUsuarios(){
        cadUsuarios usuarios = new cadUsuarios();
        usuarios.setVisible(true);
    }
    
    public void CadastroServicos(){
        cadServicos servicos = new cadServicos();
        servicos.setVisible(true);
    }
    
     public void CadastroProdutos(){
        cadProdutos produtos = new cadProdutos();
        produtos.setVisible(true);
    }
    
    public void CadastroClientes(){
        cadClientes clientes = new cadClientes();
        clientes.setVisible(true);
    }
    
    public void CadastroHorarios(){
        cadHorarios horario = new cadHorarios();
        horario.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        btnLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAdministrativo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblCargo = new javax.swing.JLabel();
        lblVendas = new javax.swing.JLabel();
        lblGastos = new javax.swing.JLabel();
        lblResultadoGastos = new javax.swing.JLabel();
        lblResultadoVendas = new javax.swing.JLabel();
        lblResultadoCargo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAgendamento = new javax.swing.JButton();
        btnOS = new javax.swing.JButton();
        btnPontoDeVendas = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menCadastro = new javax.swing.JMenu();
        menCadastroUsuarios = new javax.swing.JMenuItem();
        menClientes = new javax.swing.JMenu();
        menCadastroClientes = new javax.swing.JCheckBoxMenuItem();
        menCadastroSubClientes = new javax.swing.JCheckBoxMenuItem();
        menCadastroProdutos = new javax.swing.JMenuItem();
        menCadastroServicos = new javax.swing.JMenuItem();
        menCadastroHorarios = new javax.swing.JMenuItem();
        menRelatorios = new javax.swing.JMenu();
        menRelatoriosVendas = new javax.swing.JMenuItem();
        menRelatoriosGastos = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menCadastroCargos = new javax.swing.JCheckBoxMenuItem();
        menSobre = new javax.swing.JMenu();
        menSobreAjuda = new javax.swing.JMenuItem();
        menSair = new javax.swing.JMenu();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bem Vindo");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(31, 38, 46));
        setFocusable(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/Logo_200x164.png"))); // NOI18N
        getContentPane().add(btnLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 90, -1, -1));

        jPanel1.setBackground(new java.awt.Color(31, 38, 46));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Avançado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(31, 38, 46));
        jPanel1.setToolTipText("Cadastros");
        jPanel1.setName("Cadastro"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdministrativo.setBackground(new java.awt.Color(204, 204, 204));
        btnAdministrativo.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        btnAdministrativo.setForeground(new java.awt.Color(51, 51, 51));
        btnAdministrativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconAdministrativo.png"))); // NOI18N
        btnAdministrativo.setText("Administrativo");
        btnAdministrativo.setAlignmentX(0.6F);
        btnAdministrativo.setAlignmentY(0.6F);
        btnAdministrativo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdministrativo.setBorderPainted(false);
        btnAdministrativo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdministrativo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdministrativo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAdministrativo.setMargin(new java.awt.Insets(3, 3, 3, 3));
        jPanel1.add(btnAdministrativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 320, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 990, 270));

        jPanel2.setBackground(new java.awt.Color(31, 38, 46));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCargo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCargo.setForeground(new java.awt.Color(0, 51, 255));
        lblCargo.setText("Cargo:");
        jPanel2.add(lblCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        lblVendas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblVendas.setForeground(new java.awt.Color(0, 255, 0));
        lblVendas.setText("Vendas:");
        jPanel2.add(lblVendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        lblGastos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblGastos.setForeground(new java.awt.Color(255, 0, 0));
        lblGastos.setText(" Gastos:");
        jPanel2.add(lblGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblResultadoGastos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblResultadoGastos.setForeground(new java.awt.Color(255, 0, 0));
        lblResultadoGastos.setText("(R$)");
        jPanel2.add(lblResultadoGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        lblResultadoVendas.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblResultadoVendas.setForeground(new java.awt.Color(51, 255, 0));
        lblResultadoVendas.setText("(R$)");
        jPanel2.add(lblResultadoVendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        lblResultadoCargo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblResultadoCargo.setForeground(new java.awt.Color(0, 51, 204));
        lblResultadoCargo.setText("(C)");
        jPanel2.add(lblResultadoCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 340, 210, 100));

        jPanel3.setBackground(new java.awt.Color(31, 38, 46));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Vendas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgendamento.setBackground(new java.awt.Color(204, 204, 204));
        btnAgendamento.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        btnAgendamento.setForeground(new java.awt.Color(51, 51, 51));
        btnAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconAgendamento.png"))); // NOI18N
        btnAgendamento.setText("Agendamento");
        btnAgendamento.setActionCommand("Atalho para Ponto de Vendas ");
        btnAgendamento.setAlignmentX(0.6F);
        btnAgendamento.setAlignmentY(0.6F);
        btnAgendamento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgendamento.setBorderPainted(false);
        btnAgendamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgendamento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAgendamento.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgendamento.setMargin(new java.awt.Insets(3, 3, 3, 3));
        jPanel3.add(btnAgendamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 320, 60));

        btnOS.setBackground(new java.awt.Color(204, 204, 204));
        btnOS.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        btnOS.setForeground(new java.awt.Color(51, 51, 51));
        btnOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconOs.png"))); // NOI18N
        btnOS.setText("O.S");
        btnOS.setAlignmentX(0.6F);
        btnOS.setAlignmentY(0.6F);
        btnOS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOS.setBorderPainted(false);
        btnOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOS.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnOS.setMargin(new java.awt.Insets(3, 3, 3, 3));
        btnOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOSActionPerformed(evt);
            }
        });
        jPanel3.add(btnOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 320, 60));

        btnPontoDeVendas.setBackground(new java.awt.Color(204, 204, 204));
        btnPontoDeVendas.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        btnPontoDeVendas.setForeground(new java.awt.Color(51, 51, 51));
        btnPontoDeVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/iconPdv.png"))); // NOI18N
        btnPontoDeVendas.setText("Ponto de Vendas ");
        btnPontoDeVendas.setAlignmentX(0.6F);
        btnPontoDeVendas.setAlignmentY(0.6F);
        btnPontoDeVendas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPontoDeVendas.setBorderPainted(false);
        btnPontoDeVendas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPontoDeVendas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPontoDeVendas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPontoDeVendas.setMargin(new java.awt.Insets(3, 3, 3, 3));
        jPanel3.add(btnPontoDeVendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 320, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 990, 280));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/legnu/icons/fundoTelaPrincipal.png"))); // NOI18N
        lblFundo.setMaximumSize(new java.awt.Dimension(1280, 700));
        lblFundo.setMinimumSize(new java.awt.Dimension(1280, 700));
        lblFundo.setPreferredSize(new java.awt.Dimension(1280, 700));
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1264, 645));

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setOpaque(false);

        menCadastro.setText("Cadastro");

        menCadastroUsuarios.setText("Usuarios");
        menCadastroUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadastroUsuariosActionPerformed(evt);
            }
        });
        menCadastro.add(menCadastroUsuarios);

        menClientes.setText("Clientes");

        menCadastroClientes.setText("Clientes");
        menCadastroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadastroClientesActionPerformed(evt);
            }
        });
        menClientes.add(menCadastroClientes);

        menCadastroSubClientes.setText("Sub-Clientes");
        menClientes.add(menCadastroSubClientes);

        menCadastro.add(menClientes);

        menCadastroProdutos.setText("Produtos");
        menCadastroProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadastroProdutosActionPerformed(evt);
            }
        });
        menCadastro.add(menCadastroProdutos);

        menCadastroServicos.setText("Serviços");
        menCadastroServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadastroServicosActionPerformed(evt);
            }
        });
        menCadastro.add(menCadastroServicos);

        menCadastroHorarios.setText("Horarios");
        menCadastroHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadastroHorariosActionPerformed(evt);
            }
        });
        menCadastro.add(menCadastroHorarios);

        jMenuBar1.add(menCadastro);

        menRelatorios.setText("Relatorios");

        menRelatoriosVendas.setText("Vendas");
        menRelatorios.add(menRelatoriosVendas);

        menRelatoriosGastos.setText("Gastos");
        menRelatorios.add(menRelatoriosGastos);

        jMenuBar1.add(menRelatorios);

        jMenu1.setText("Administrativo");

        menCadastroCargos.setText("Cargos");
        jMenu1.add(menCadastroCargos);

        jMenuBar1.add(jMenu1);

        menSobre.setText("Sobre");

        menSobreAjuda.setText("Ajuda");
        menSobre.add(menSobreAjuda);

        jMenuBar1.add(menSobre);

        menSair.setText("Sair");
        jMenuBar1.add(menSair);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1276, 685));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOSActionPerformed

    private void menCadastroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadastroClientesActionPerformed
        // TODO add your handling code here:
        CadastroClientes();
    }//GEN-LAST:event_menCadastroClientesActionPerformed

    private void menCadastroProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadastroProdutosActionPerformed
        // TODO add your handling code here:
        CadastroProdutos();
    }//GEN-LAST:event_menCadastroProdutosActionPerformed

    private void menCadastroUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadastroUsuariosActionPerformed
        // TODO add your handling code here:
        CadastroUsuarios();
    }//GEN-LAST:event_menCadastroUsuariosActionPerformed

    private void menCadastroServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadastroServicosActionPerformed
        // TODO add your handling code here:
        CadastroServicos();
    }//GEN-LAST:event_menCadastroServicosActionPerformed

    private void menCadastroHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadastroHorariosActionPerformed
        // TODO add your handling code here:
        CadastroHorarios();
    }//GEN-LAST:event_menCadastroHorariosActionPerformed

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
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrativo;
    private javax.swing.JButton btnAgendamento;
    private javax.swing.JLabel btnLogo;
    private javax.swing.JButton btnOS;
    private javax.swing.JButton btnPontoDeVendas;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblGastos;
    private javax.swing.JLabel lblResultadoCargo;
    private javax.swing.JLabel lblResultadoGastos;
    private javax.swing.JLabel lblResultadoVendas;
    private javax.swing.JLabel lblVendas;
    private javax.swing.JMenu menCadastro;
    private javax.swing.JCheckBoxMenuItem menCadastroCargos;
    private javax.swing.JCheckBoxMenuItem menCadastroClientes;
    private javax.swing.JMenuItem menCadastroHorarios;
    private javax.swing.JMenuItem menCadastroProdutos;
    private javax.swing.JMenuItem menCadastroServicos;
    private javax.swing.JCheckBoxMenuItem menCadastroSubClientes;
    private javax.swing.JMenuItem menCadastroUsuarios;
    private javax.swing.JMenu menClientes;
    private javax.swing.JMenu menRelatorios;
    private javax.swing.JMenuItem menRelatoriosGastos;
    private javax.swing.JMenuItem menRelatoriosVendas;
    private javax.swing.JMenu menSair;
    private javax.swing.JMenu menSobre;
    private javax.swing.JMenuItem menSobreAjuda;
    // End of variables declaration//GEN-END:variables
}
