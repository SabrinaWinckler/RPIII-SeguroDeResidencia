    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ResidenciaDAO;
import dadosResidencia.Residencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus Montanha
 */
public class Tela_DadosResidencia extends javax.swing.JFrame {

    /**
     * Creates new form Tela_DadosResidencia
     */
    public Tela_DadosResidencia() {
        initComponents();
        ResidenciaDAO dao = new ResidenciaDAO();
        List<Residencia> listaDeResidencias;
        listaDeResidencias = dao.read();
        String cep = "" + listaDeResidencias.get(0).getCepRes();
        String rua = "" + listaDeResidencias.get(0).getRuaRes();
        campoCepResidencia.setText(cep);
        campoRuaResidencia.setText(rua);
        campoLocalizacaoPerigosa.setText("" + listaDeResidencias.get(0).getLocalizacaoPerigosa());
        campoTerrenoPerigoso.setText("" + listaDeResidencias.get(0).getTerrenoPerigoso());
        campoEstruturaAmeacada.setText("" + listaDeResidencias.get(0).getEstruturaAmeacada());
        campoDescricaoResidencia.setText("" + listaDeResidencias.get(0).getDescricaoRes());
        campoUFResidencia.setText(listaDeResidencias.get(0).getufResidencia());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoCepResidencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoRuaResidencia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoLocalizacaoPerigosa = new javax.swing.JTextField();
        campoTerrenoPerigoso = new javax.swing.JTextField();
        campoEstruturaAmeacada = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        campoDescricaoResidencia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoUFResidencia = new javax.swing.JTextField();
        ButtonContratarSeguro = new javax.swing.JButton();
        buttonRecusarSeguro = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoCepResidencia.setEditable(false);
        getContentPane().add(campoCepResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 200, 30));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel2.setText("Cep:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 30, -1));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel4.setText("Rua");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        campoRuaResidencia.setEditable(false);
        getContentPane().add(campoRuaResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 200, 30));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel3.setText("Localização Perigosa:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 30));

        jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel5.setText("Terreno Perigoso:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 110, 30));

        jLabel6.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel6.setText("Estrutura Ameaçada:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 30));

        campoLocalizacaoPerigosa.setEditable(false);
        getContentPane().add(campoLocalizacaoPerigosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 20, 30));

        campoTerrenoPerigoso.setEditable(false);
        getContentPane().add(campoTerrenoPerigoso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 20, -1));

        campoEstruturaAmeacada.setEditable(false);
        getContentPane().add(campoEstruturaAmeacada, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 20, -1));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel1.setText("Descrição:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 60, 20));

        campoDescricaoResidencia.setEditable(false);
        getContentPane().add(campoDescricaoResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 120, 30));

        jLabel7.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel7.setText("UF:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

        campoUFResidencia.setEditable(false);
        getContentPane().add(campoUFResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 120, 30));

        ButtonContratarSeguro.setBackground(new java.awt.Color(0, 102, 0));
        ButtonContratarSeguro.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        ButtonContratarSeguro.setForeground(new java.awt.Color(255, 255, 255));
        ButtonContratarSeguro.setText("Aprovada");
        ButtonContratarSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonContratarSeguroActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonContratarSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 90, -1));

        buttonRecusarSeguro.setBackground(new java.awt.Color(204, 0, 0));
        buttonRecusarSeguro.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        buttonRecusarSeguro.setForeground(new java.awt.Color(255, 255, 255));
        buttonRecusarSeguro.setText("Recusada");
        buttonRecusarSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecusarSeguroActionPerformed(evt);
            }
        });
        getContentPane().add(buttonRecusarSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 90, -1));

        voltarButton.setBackground(new java.awt.Color(0, 51, 51));
        voltarButton.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        voltarButton.setForeground(new java.awt.Color(255, 255, 255));
        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(voltarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/esse sim.jpg"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 640, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonContratarSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonContratarSeguroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonContratarSeguroActionPerformed

    private void buttonRecusarSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecusarSeguroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRecusarSeguroActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        Painel_Corretor painel = new Painel_Corretor();
        painel.setVisible(true);
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
            java.util.logging.Logger.getLogger(Tela_DadosResidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_DadosResidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_DadosResidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_DadosResidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_DadosResidencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonContratarSeguro;
    private javax.swing.JButton buttonRecusarSeguro;
    private javax.swing.JTextField campoCepResidencia;
    private javax.swing.JTextField campoDescricaoResidencia;
    private javax.swing.JTextField campoEstruturaAmeacada;
    private javax.swing.JTextField campoLocalizacaoPerigosa;
    private javax.swing.JTextField campoRuaResidencia;
    private javax.swing.JTextField campoTerrenoPerigoso;
    private javax.swing.JTextField campoUFResidencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
