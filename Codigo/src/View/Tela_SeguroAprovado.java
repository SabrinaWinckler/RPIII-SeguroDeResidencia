/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.CandidatoDAO;
import DAO.PessoaDAO;
import DadosUsuarios.Candidato;
import DadosUsuarios.Pessoa;
import java.util.List;

/**
 *
 * @author Débora Siqueira
 */
public class Tela_SeguroAprovado extends javax.swing.JFrame {

    /**
     * Creates new form Tela_SeguroAprovado
     */
    public Tela_SeguroAprovado() {
        initComponents();
        String observacao = "Sua residência foi considerada apta para o serviço";
        double valor = 241;
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        List<Candidato> listaCandidato;
        listaCandidato = candidatoDAO.read();
        PessoaDAO pesDAO = new PessoaDAO();
        List<Pessoa> listaPessoa = pesDAO.read();
        textNome.setText(listaPessoa.get(0).getNomePessoa());
        textCPF.setText("" + listaPessoa.get(0).getCpf());
        textB.setText(listaCandidato.get(0).getBairro());
        textCidade.setText(listaCandidato.get(0).getCidade());
        textEnd.setText(listaPessoa.get(0).getEndereco());
        textCep.setText("" + listaCandidato.get(0).getCep());
        textValorSeguro.setText("" + valor);
        textObs.setText(observacao);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textCidade = new javax.swing.JTextPane();
        textBairro = new javax.swing.JScrollPane();
        textB = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        textCPF = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        textEnd = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        textObs = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        textValorSeguro = new javax.swing.JTextPane();
        jScrollPane10 = new javax.swing.JScrollPane();
        textCep = new javax.swing.JTextPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        textNome = new javax.swing.JTextPane();
        ButtonContratarSeguro = new javax.swing.JButton();
        buttonRecusarSeguro = new javax.swing.JButton();
        buttonVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setText("CPF:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setText("CEP:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setText("Endereço:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel8.setText("Bairro:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel9.setText("Cidade:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        textCidade.setEditable(false);
        jScrollPane3.setViewportView(textCidade);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 200, 30));

        textB.setEditable(false);
        textBairro.setViewportView(textB);

        getContentPane().add(textBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 200, 30));

        textCPF.setEditable(false);
        jScrollPane5.setViewportView(textCPF);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 200, 30));

        textEnd.setEditable(false);
        jScrollPane6.setViewportView(textEnd);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 200, 40));

        textObs.setEditable(false);
        jScrollPane7.setViewportView(textObs);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 270, 120));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setText("Observações:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel10.setText("Nome:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel11.setText("Valor do Seguro:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

        textValorSeguro.setEditable(false);
        jScrollPane8.setViewportView(textValorSeguro);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 60, -1));

        textCep.setEditable(false);
        jScrollPane10.setViewportView(textCep);

        getContentPane().add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 200, 30));

        textNome.setEditable(false);
        jScrollPane11.setViewportView(textNome);

        getContentPane().add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 200, 30));

        ButtonContratarSeguro.setBackground(new java.awt.Color(0, 153, 255));
        ButtonContratarSeguro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ButtonContratarSeguro.setForeground(new java.awt.Color(255, 255, 255));
        ButtonContratarSeguro.setText("Contratar ");
        ButtonContratarSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonContratarSeguroActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonContratarSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, 90, 30));

        buttonRecusarSeguro.setBackground(new java.awt.Color(153, 51, 255));
        buttonRecusarSeguro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonRecusarSeguro.setForeground(new java.awt.Color(255, 255, 255));
        buttonRecusarSeguro.setText("Recusar");
        buttonRecusarSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecusarSeguroActionPerformed(evt);
            }
        });
        getContentPane().add(buttonRecusarSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 490, 90, 30));

        buttonVoltar.setBackground(new java.awt.Color(153, 51, 255));
        buttonVoltar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        buttonVoltar.setForeground(new java.awt.Color(255, 255, 255));
        buttonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/back2.png"))); // NOI18N
        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 100, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem Título-1.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 980, 610));

        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonContratarSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonContratarSeguroActionPerformed
        Tela_Pagamento pagamento = new Tela_Pagamento();
        pagamento.setVisible(true);
        dispose();
    }//GEN-LAST:event_ButtonContratarSeguroActionPerformed

    private void buttonRecusarSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecusarSeguroActionPerformed
        PainelCandidato painel = new PainelCandidato();
        painel.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonRecusarSeguroActionPerformed

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
        PainelCandidato painel = new PainelCandidato();
        painel.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_SeguroAprovado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_SeguroAprovado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_SeguroAprovado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_SeguroAprovado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_SeguroAprovado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonContratarSeguro;
    private javax.swing.JButton buttonRecusarSeguro;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextPane textB;
    private javax.swing.JScrollPane textBairro;
    private javax.swing.JTextPane textCPF;
    private javax.swing.JTextPane textCep;
    private javax.swing.JTextPane textCidade;
    private javax.swing.JTextPane textEnd;
    private javax.swing.JTextPane textNome;
    private javax.swing.JTextPane textObs;
    private javax.swing.JTextPane textValorSeguro;
    // End of variables declaration//GEN-END:variables
}
