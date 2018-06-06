/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Motor.Gerenciador;
import Motor.ControleSolicitacao;
import Operacoes.Solicitacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Débora Siqueira
 */
public class Tela_ListaSolicitacaoCandidato extends javax.swing.JFrame {

    List<Solicitacao> listaSolicitacao = new ArrayList<>();

    /**
     * Creates new form Tela_ListaSolicitacaoCandidato
     */
    public Tela_ListaSolicitacaoCandidato() {
        initComponents();
        Gerenciador motor = new Gerenciador();
        listaSolicitacao = motor.listaDeResidenciasPendentes();
        readTable();
    }

    public int readTable() {
        DefaultTableModel modelo = (DefaultTableModel) listaSolicitacaoCandidato.getModel();
        modelo.setNumRows(0);
        Gerenciador motor = new Gerenciador();
        int tamanhoLista = listaSolicitacao.size();
        if (tamanhoLista > 0) {
            for (Solicitacao solicitacao : listaSolicitacao) {
                modelo.addRow(new Object[]{
                    solicitacao.getResidencia().getDescricaoRes(),
                    solicitacao.getDataSolicitacao(),
                    solicitacao.getResidencia().getCepRes(),
                    solicitacao.getAprovadaSolicitacao()
                });
            }
            return 1;
        } else {
            return 0;
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

        voltarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaSolicitacaoCandidato = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        voltarButton.setBackground(new java.awt.Color(153, 51, 255));
        voltarButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        voltarButton.setForeground(new java.awt.Color(255, 255, 255));
        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/back2.png"))); // NOI18N
        voltarButton.setText("Voltar");
        voltarButton.setMaximumSize(new java.awt.Dimension(93, 33));
        voltarButton.setMinimumSize(new java.awt.Dimension(93, 33));
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(voltarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 30));

        listaSolicitacaoCandidato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Data", "CEP", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaSolicitacaoCandidato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaSolicitacaoCandidatoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaSolicitacaoCandidato);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 690, 390));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem Título-1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaSolicitacaoCandidatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaSolicitacaoCandidatoMouseClicked
        int selecionado = listaSolicitacaoCandidato.getSelectedRow();
        String resultado = listaSolicitacao.get(selecionado).getAprovadaSolicitacao();
        if (resultado.equalsIgnoreCase("aprovada")) {
            Tela_SeguroAprovado telaAprovado = new Tela_SeguroAprovado();
            telaAprovado.setVisible(true);
            dispose();
        } else {
            Tela_SeguroReprovado telaReprovado = new Tela_SeguroReprovado();
            telaReprovado.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_listaSolicitacaoCandidatoMouseClicked

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        PainelCandidato painelCandidato = new PainelCandidato();
        painelCandidato.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_ListaSolicitacaoCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_ListaSolicitacaoCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_ListaSolicitacaoCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_ListaSolicitacaoCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_ListaSolicitacaoCandidato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaSolicitacaoCandidato;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
