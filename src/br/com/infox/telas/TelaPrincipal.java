/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.telas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author dxavi
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        jLabel3 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        menCad = new javax.swing.JMenu();
        menCadCli = new javax.swing.JMenuItem();
        menCadEve = new javax.swing.JMenuItem();
        menCadUsu = new javax.swing.JMenuItem();
        menRel = new javax.swing.JMenu();
        menRelEve = new javax.swing.JMenuItem();
        menAju = new javax.swing.JMenu();
        menAjuSob = new javax.swing.JMenuItem();
        menOps = new javax.swing.JMenu();
        menOpcSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("X - Sistema de Gerenciamento Buffe Santana");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\dxavi\\OneDrive\\Área de Trabalho\\buffetsantana.png")); // NOI18N

        lblData.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblData.setText("Data");

        menCad.setText("Cadastro");

        menCadCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        menCadCli.setText("Cliente");
        menCadCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadCliActionPerformed(evt);
            }
        });
        menCad.add(menCadCli);

        menCadEve.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        menCadEve.setText("Evento");
        menCad.add(menCadEve);

        menCadUsu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK));
        menCadUsu.setText("Usuário");
        menCadUsu.setEnabled(false);
        menCad.add(menCadUsu);

        Menu.add(menCad);

        menRel.setText("Relatório");
        menRel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRelActionPerformed(evt);
            }
        });

        menRelEve.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        menRelEve.setText("Eventos");
        menRelEve.setEnabled(false);
        menRelEve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRelEveActionPerformed(evt);
            }
        });
        menRel.add(menRelEve);

        Menu.add(menRel);

        menAju.setText("Ajuda");

        menAjuSob.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        menAjuSob.setText("Sobre");
        menAjuSob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAjuSobActionPerformed(evt);
            }
        });
        menAju.add(menAjuSob);

        Menu.add(menAju);

        menOps.setText("Opções");

        menOpcSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menOpcSair.setText("Sair");
        menOpcSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOpcSairActionPerformed(evt);
            }
        });
        menOps.add(menOpcSair);

        Menu.add(menOps);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(lblData))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblData)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(828, 564));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menCadCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menCadCliActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // As linhas abaixo substituem a label lbldata pela data atual
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();
        lblData.setText(sdf.format(now));
    }//GEN-LAST:event_formWindowActivated

    private void menOpcSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOpcSairActionPerformed
         // Exibi uma caixa de diálogo
         int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
         if (sair == JOptionPane.YES_OPTION){
             System.exit(0);
         }
    }//GEN-LAST:event_menOpcSairActionPerformed

    private void menAjuSobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAjuSobActionPerformed
        // Chamando a tela sobre
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_menAjuSobActionPerformed

    private void menRelEveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRelEveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menRelEveActionPerformed

    private void menRelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menRelActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblData;
    private javax.swing.JMenu menAju;
    private javax.swing.JMenuItem menAjuSob;
    private javax.swing.JMenu menCad;
    private javax.swing.JMenuItem menCadCli;
    private javax.swing.JMenuItem menCadEve;
    public static javax.swing.JMenuItem menCadUsu;
    private javax.swing.JMenuItem menOpcSair;
    private javax.swing.JMenu menOps;
    private javax.swing.JMenu menRel;
    public static javax.swing.JMenuItem menRelEve;
    // End of variables declaration//GEN-END:variables
}