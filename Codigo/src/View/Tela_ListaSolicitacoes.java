/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ResidenciaDAO;
import DAO.SolicitacaoDAO;
import Motor.Solicitacao;
import dadosResidencia.Residencia;
import SevicosSeguradora.SolicitacaoSeguro;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Matheus Montanha
 */
public class Tela_ListaSolicitacoes extends javax.swing.JFrame {

    Solicitacao solicitacaoGuardar;

    /**
     * Creates new form Tela_ListaSolicitacoes
     */
    public Tela_ListaSolicitacoes() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) listaDeSolicitacoes.getModel();
        listaDeSolicitacoes.setRowSorter(new TableRowSorter(modelo));
        readTable();
    }

    public void readTable() {
        DefaultTableModel modelo = (DefaultTableModel) listaDeSolicitacoes.getModel();
        modelo.setNumRows(0);
        ResidenciaDAO daoResidencia = new ResidenciaDAO();
        for (Residencia r : daoResidencia.read()) {
            modelo.addRow(new Object[]{
                r.getCepRes(),
                r.getRuaRes()
            });
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

        jFileChooser1 = new javax.swing.JFileChooser();
        popupMenu1 = new java.awt.PopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        voltarButton = new javax.swing.JButton();
        jLabelSeguroDeResidencia = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDeSolicitacoes = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        popupMenu1.setLabel("popupMenu1");

        jMenu1.setText("jMenu1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        voltarButton.setBackground(new java.awt.Color(0, 51, 51));
        voltarButton.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        voltarButton.setForeground(new java.awt.Color(255, 255, 255));
        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(voltarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, 30));

        jLabelSeguroDeResidencia.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelSeguroDeResidencia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSeguroDeResidencia.setText("Seguro de Residência");
        getContentPane().add(jLabelSeguroDeResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagem-de-fundo-preta-wallpaper-pc-computador-tela-gratis-ambiente-de-trabalho.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 50));

        listaDeSolicitacoes.setBackground(new java.awt.Color(0, 153, 153));
        listaDeSolicitacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Proprietário", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaDeSolicitacoes.setColumnSelectionAllowed(true);
        listaDeSolicitacoes.getTableHeader().setReorderingAllowed(false);
        listaDeSolicitacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaDeSolicitacoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaDeSolicitacoes);
        listaDeSolicitacoes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 530, 270));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seguro de Residência");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -40, 240, 130));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/esse sim.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 550, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        Painel_Corretor painel = new Painel_Corretor();
        painel.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void listaDeSolicitacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaDeSolicitacoesMouseClicked
        Tela_DadosResidencia telaDados = new Tela_DadosResidencia();
        telaDados.setVisible(true);
        dispose();
    }//GEN-LAST:event_listaDeSolicitacoesMouseClicked

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
            java.util.logging.Logger.getLogger(Tela_ListaSolicitacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_ListaSolicitacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_ListaSolicitacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_ListaSolicitacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_ListaSolicitacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelSeguroDeResidencia;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable listaDeSolicitacoes;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
