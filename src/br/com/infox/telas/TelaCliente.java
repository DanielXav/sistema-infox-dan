/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.telas;

import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author dxavi
 */
public class TelaCliente extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    // Adicionar clientes
    private void adicionar() {
        String sql = "insert into tbclientes(nomecli, cpf, cellcli, fonecli, emailcli, numrescli, ruacli, bairrocli, cidadecli, estadocli, complementocli, cepcli) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCliNome.getText());
            pst.setString(2, txtCliCPF.getText());
            pst.setString(3, txtCliCelular.getText());
            pst.setString(4, txtCliTelefone.getText());
            pst.setString(5, txtCliEmail.getText());
            pst.setString(6, txtCliNumAp.getText());
            pst.setString(7, txtCliRua.getText());
            pst.setString(8, txtCliBairro.getText());
            pst.setString(9, txtCliCidade.getText());
            pst.setString(10, txtCliEstado.getText());
            pst.setString(11, txtCliComplemento.getText());
            pst.setString(12, txtCliCEP.getText());

            // Valida os campos
            if ((txtCliNome.getText().isEmpty()) || (txtCliCPF.getText().isEmpty()) || txtCliCelular.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios!");
            } else {
                // Atualiza a tabela usuario com os dados do formulário
                // Confirmar a inserção dos dados
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");

                    txtCliNome.setText(null);
                    txtCliCPF.setText(null);
                    txtCliCelular.setText(null);
                    txtCliTelefone.setText(null);
                    txtCliEmail.setText(null);
                    txtCliNumAp.setText(null);
                    txtCliRua.setText(null);
                    txtCliBairro.setText(null);
                    txtCliCidade.setText(null);
                    txtCliEstado.setText(null);
                    txtCliComplemento.setText(null);
                    txtCliCEP.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Método para pesquisar
    private void pesquisar_cliente() {
        String sql = "select * from tbclientes where nomecli like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCliPesquisar.getText() + "%");
            rs = pst.executeQuery();

            tbtClientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Método para setar os campos do fórmulario com o conteudo da tabela7
    public void setar_campos() {
        int setar = tbtClientes.getSelectedRow();
        txtCliId.setText(tbtClientes.getModel().getValueAt(setar, 0).toString());
        txtCliNome.setText(tbtClientes.getModel().getValueAt(setar, 1).toString());
        txtCliCPF.setText(tbtClientes.getModel().getValueAt(setar, 2).toString());
        txtCliCelular.setText(tbtClientes.getModel().getValueAt(setar, 3).toString());
        txtCliTelefone.setText(tbtClientes.getModel().getValueAt(setar, 4).toString());
        txtCliEmail.setText(tbtClientes.getModel().getValueAt(setar, 5).toString());
        txtCliNumAp.setText(tbtClientes.getModel().getValueAt(setar, 6).toString());
        txtCliRua.setText(tbtClientes.getModel().getValueAt(setar, 7).toString());
        txtCliBairro.setText(tbtClientes.getModel().getValueAt(setar, 8).toString());
        txtCliCidade.setText(tbtClientes.getModel().getValueAt(setar, 9).toString());
        txtCliEstado.setText(tbtClientes.getModel().getValueAt(setar, 10).toString());
        txtCliComplemento.setText(tbtClientes.getModel().getValueAt(setar, 11).toString());
        txtCliCEP.setText(tbtClientes.getModel().getValueAt(setar, 12).toString());
        
        btnAdicionar.setEnabled(false);
    }

    // Alterar campo dos clientess
     private void alterar() {
        String sql = "update tbclientes set nomecli = ?, cpf = ?, cellcli = ?, fonecli = ?, emailcli = ?, numrescli = ?, ruacli = ?, bairrocli = ?, cidadecli = ?, estadocli = ?, complementocli = ?, cepcli = ? where idcli = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCliNome.getText());
            pst.setString(2, txtCliCPF.getText());
            pst.setString(3, txtCliCelular.getText());
            pst.setString(4, txtCliTelefone.getText());
            pst.setString(5, txtCliEmail.getText());
            pst.setString(6, txtCliNumAp.getText());
            pst.setString(7, txtCliRua.getText());
            pst.setString(8, txtCliBairro.getText());
            pst.setString(9, txtCliCidade.getText());
            pst.setString(10, txtCliEstado.getText());
            pst.setString(11, txtCliComplemento.getText());
            pst.setString(12, txtCliCEP.getText());
            pst.setString(13, txtCliId.getText());

            if (txtCliNome.getText().isEmpty() || txtCliCPF.getText().isEmpty() || txtCliId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os dados obrigatórios");
            } else {
                // Atualiza a tabela usuario com os dados do formulário
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do cliente alterados com sucesso");
                    txtCliNome.setText(null);
                    txtCliCPF.setText(null);
                    txtCliId.setText(null);
                    txtCliCelular.setText(null);
                    txtCliTelefone.setText(null);
                    txtCliEmail.setText(null);
                    txtCliNumAp.setText(null);
                    txtCliRua.setText(null);
                    txtCliBairro.setText(null);
                    txtCliCidade.setText(null);
                    txtCliEstado.setText(null);
                    txtCliComplemento.setText(null);
                    txtCliCEP.setText(null);
                    btnAdicionar.setEnabled(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    // Método excluir

    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este cliente?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbclientes where idcli=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtCliId.getText());
                int apagado = pst.executeUpdate();

                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
                    txtCliNome.setText(null);
                    txtCliCPF.setText(null);
                    txtCliId.setText(null);
                    txtCliCelular.setText(null);
                    txtCliTelefone.setText(null);
                    txtCliEmail.setText(null);
                    txtCliNumAp.setText(null);
                    txtCliRua.setText(null);
                    txtCliBairro.setText(null);
                    txtCliCidade.setText(null);
                    txtCliEstado.setText(null);
                    txtCliComplemento.setText(null);
                    txtCliCEP.setText(null);
                    btnAdicionar.setEnabled(true);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCliNome = new javax.swing.JTextField();
        txtCliCPF = new javax.swing.JTextField();
        txtCliId = new javax.swing.JTextField();
        txtCliEmail = new javax.swing.JTextField();
        txtCliEstado = new javax.swing.JTextField();
        txtCliRua = new javax.swing.JTextField();
        txtCliComplemento = new javax.swing.JTextField();
        txtCliCidade = new javax.swing.JTextField();
        txtCliTelefone = new javax.swing.JTextField();
        txtCliBairro = new javax.swing.JTextField();
        txtCliNumAp = new javax.swing.JTextField();
        txtCliCEP = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        txtCliPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtClientes = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtCliCelular = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Clientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("* Campo Obrigatório");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 14, -1, -1));

        jLabel2.setText("* Nome");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 148, -1, -1));

        jLabel3.setText("* CPF");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 148, -1, -1));

        jLabel4.setText("* Celular");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 183, -1, -1));

        jLabel5.setText("Telefone");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 183, -1, -1));

        jLabel6.setText("E-mail");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 183, -1, -1));

        jLabel7.setText("Rua");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 252, -1, -1));

        jLabel9.setText("Bairro");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 221, -1, -1));

        jLabel10.setText("Cidade");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 221, -1, -1));

        jLabel11.setText("Estado");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 221, -1, -1));

        jLabel12.setText("Complemento");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 90, -1));

        jLabel13.setText("CEP");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));
        getContentPane().add(txtCliNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 145, 302, -1));
        getContentPane().add(txtCliCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 145, 135, -1));

        txtCliId.setEnabled(false);
        getContentPane().add(txtCliId, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 100, -1));
        getContentPane().add(txtCliEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 180, 135, -1));
        getContentPane().add(txtCliEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 218, 108, -1));
        getContentPane().add(txtCliRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 249, 300, -1));
        getContentPane().add(txtCliComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 130, -1));
        getContentPane().add(txtCliCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 218, 136, -1));
        getContentPane().add(txtCliTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 136, -1));
        getContentPane().add(txtCliBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 218, 135, -1));
        getContentPane().add(txtCliNumAp, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 30, -1));
        getContentPane().add(txtCliCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 129, -1));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/create.png"))); // NOI18N
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 318, 123, 119));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/update.png"))); // NOI18N
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 318, 121, 119));

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/delete.png"))); // NOI18N
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 113, 119));

        txtCliPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliPesquisarKeyReleased(evt);
            }
        });
        getContentPane().add(txtCliPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 239, -1));

        tbtClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbtClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbtClientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 42, 539, 92));

        jLabel14.setText("N°");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, 20));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/read-cli.png"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, 20));

        jLabel16.setText("Id Cliente");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));
        getContentPane().add(txtCliCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 180, 108, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // Adicionar cliente
        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtCliPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliPesquisarKeyReleased
        // Enquanto for digitando em tempo real
        pesquisar_cliente();
    }//GEN-LAST:event_txtCliPesquisarKeyReleased

    private void tbtClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtClientesMouseClicked
        // Evento para setar campos da tabela
        setar_campos();
    }//GEN-LAST:event_tbtClientesMouseClicked

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // Método para alterar clientes
        alterar();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // Método para remover
        remover();
    }//GEN-LAST:event_btnRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbtClientes;
    private javax.swing.JTextField txtCliBairro;
    private javax.swing.JTextField txtCliCEP;
    private javax.swing.JTextField txtCliCPF;
    private javax.swing.JTextField txtCliCelular;
    private javax.swing.JTextField txtCliCidade;
    private javax.swing.JTextField txtCliComplemento;
    private javax.swing.JTextField txtCliEmail;
    private javax.swing.JTextField txtCliEstado;
    private javax.swing.JTextField txtCliId;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JTextField txtCliNumAp;
    private javax.swing.JTextField txtCliPesquisar;
    private javax.swing.JTextField txtCliRua;
    private javax.swing.JTextField txtCliTelefone;
    // End of variables declaration//GEN-END:variables
}
