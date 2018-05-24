/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ResidenciaDAO;
import Motor.Gerenciador;
import Motor.Solicitacao;
import dadosResidencia.Residencia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
        Gerenciador gerenciador = new Gerenciador();
        List<Solicitacao> listaDeSolicitacao;
        listaDeSolicitacao = gerenciador.listaDeResidenciasPendentes();
        String cep = "" + listaDeSolicitacao.get(0).getResidencia().getCepRes();
        campoCepResidencia.setText(cep);
        campoCidadeResidencia.setText(listaDeSolicitacao.get(0).getResidencia().getCandidato().getCidade());
        campoRuaResidencia.setText(listaDeSolicitacao.get(0).getResidencia().getRuaRes());
        campoDescricaoResidencia.setText(listaDeSolicitacao.get(0).getResidencia().getDescricaoRes());
        campoUFResidencia.setText(listaDeSolicitacao.get(0).getResidencia().getUfResidencia());
        campoNomeCandidato.setText(listaDeSolicitacao.get(0).getResidencia().getCandidato().getNomePessoa());
        campoCPFCandidato.setText("" + listaDeSolicitacao.get(0).getResidencia().getCandidato().getCpf());
        campoEmailCandidato.setText(listaDeSolicitacao.get(0).getResidencia().getCandidato().getEmail());
        campoTelefoneCandidato.setText(listaDeSolicitacao.get(0).getResidencia().getCandidato().getTelefone());
        campoQuantidadeComodos.setText("" + listaDeSolicitacao.get(0).getResidencia().getQntComodos());
        campoQuantidadeDeBanheiros.setText("" + listaDeSolicitacao.get(0).getResidencia().getQntBanheiros());
        campoQuantidadeDeGaragens.setText("" + listaDeSolicitacao.get(0).getResidencia().getQntGaragens());
        campoAreaConstruida.setText("" + listaDeSolicitacao.get(0).getResidencia().getAreaConstruida());
        campoAnoConstrucao.setText("" + listaDeSolicitacao.get(0).getResidencia().getAnoConstrucao());
        campoAreaTotal.setText("" + listaDeSolicitacao.get(0).getResidencia().getAreaTotal());
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
        jLabelCep = new javax.swing.JLabel();
        jLabelRua = new javax.swing.JLabel();
        campoRuaResidencia = new javax.swing.JTextField();
        jLabelDescr = new javax.swing.JLabel();
        campoDescricaoResidencia = new javax.swing.JTextField();
        jLabelUF = new javax.swing.JLabel();
        campoUFResidencia = new javax.swing.JTextField();
        ButtonAprovarSolicitacao = new javax.swing.JButton();
        buttonRecusarSeguro = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoCidadeResidencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoNomeCandidato = new javax.swing.JTextField();
        campoCPFCandidato = new javax.swing.JTextField();
        campoEmailCandidato = new javax.swing.JTextField();
        campoTelefoneCandidato = new javax.swing.JTextField();
        buttonEditarSolicitacao = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        campoQuantidadeComodos = new javax.swing.JTextField();
        campoQuantidadeDeBanheiros = new javax.swing.JTextField();
        campoQuantidadeDeGaragens = new javax.swing.JTextField();
        campoAnoConstrucao = new javax.swing.JTextField();
        campoAreaConstruida = new javax.swing.JTextField();
        campoAreaTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoCepResidencia.setEditable(false);
        campoCepResidencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoCepResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 200, 30));

        jLabelCep.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelCep.setText("Cep:");
        getContentPane().add(jLabelCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 30, -1));

        jLabelRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelRua.setText("Rua:");
        getContentPane().add(jLabelRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 30, -1));

        campoRuaResidencia.setEditable(false);
        campoRuaResidencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoRuaResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 200, 30));

        jLabelDescr.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDescr.setText("Descrição:");
        getContentPane().add(jLabelDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 70, 20));

        campoDescricaoResidencia.setEditable(false);
        campoDescricaoResidencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoDescricaoResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 190, 50));

        jLabelUF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelUF.setText("UF:");
        getContentPane().add(jLabelUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 30, -1));

        campoUFResidencia.setEditable(false);
        campoUFResidencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoUFResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 50, 30));

        ButtonAprovarSolicitacao.setBackground(new java.awt.Color(0, 153, 255));
        ButtonAprovarSolicitacao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ButtonAprovarSolicitacao.setForeground(new java.awt.Color(255, 255, 255));
        ButtonAprovarSolicitacao.setText("Aprovada");
        ButtonAprovarSolicitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAprovarSolicitacaoActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonAprovarSolicitacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 520, 100, 30));

        buttonRecusarSeguro.setBackground(new java.awt.Color(153, 51, 255));
        buttonRecusarSeguro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonRecusarSeguro.setForeground(new java.awt.Color(255, 255, 255));
        buttonRecusarSeguro.setText("Recusada");
        buttonRecusarSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecusarSeguroActionPerformed(evt);
            }
        });
        getContentPane().add(buttonRecusarSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 520, 100, 30));

        voltarButton.setBackground(new java.awt.Color(0, 153, 255));
        voltarButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        voltarButton.setForeground(new java.awt.Color(255, 255, 255));
        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/back2.png"))); // NOI18N
        voltarButton.setText("      Voltar");
        voltarButton.setToolTipText("");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(voltarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 130, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Cidade:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 50, -1));

        campoCidadeResidencia.setEditable(false);
        campoCidadeResidencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoCidadeResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 200, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Dados Residência: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, 10, 200));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Dados Proprietário:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, -1, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Nome:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 40, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("CPF:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, -1, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Email: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 330, 40, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Telefone:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 370, 60, 20));

        campoNomeCandidato.setEditable(false);
        campoNomeCandidato.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoNomeCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 240, 160, 30));

        campoCPFCandidato.setEditable(false);
        campoCPFCandidato.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoCPFCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 280, 160, 30));

        campoEmailCandidato.setEditable(false);
        campoEmailCandidato.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoEmailCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 320, 160, 30));

        campoTelefoneCandidato.setEditable(false);
        campoTelefoneCandidato.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoTelefoneCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 360, 160, 30));

        buttonEditarSolicitacao.setBackground(new java.awt.Color(0, 0, 102));
        buttonEditarSolicitacao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonEditarSolicitacao.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditarSolicitacao.setText("Editar");
        buttonEditarSolicitacao.setMaximumSize(new java.awt.Dimension(87, 23));
        buttonEditarSolicitacao.setMinimumSize(new java.awt.Dimension(84, 23));
        getContentPane().add(buttonEditarSolicitacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 520, 100, 30));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, -1, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 280, 10));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, 280, 10));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Quantidade de Comodos:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Quantidade de Banheiros:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Quantidade de Garagens:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Area Construida:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Area Total:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 70, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Ano de Construção:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, -1, -1));

        campoQuantidadeComodos.setEditable(false);
        campoQuantidadeComodos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoQuantidadeComodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 50, 30));

        campoQuantidadeDeBanheiros.setEditable(false);
        campoQuantidadeDeBanheiros.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoQuantidadeDeBanheiros, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 50, 30));

        campoQuantidadeDeGaragens.setEditable(false);
        campoQuantidadeDeGaragens.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoQuantidadeDeGaragens, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 50, 30));

        campoAnoConstrucao.setEditable(false);
        campoAnoConstrucao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoAnoConstrucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 50, 30));

        campoAreaConstruida.setEditable(false);
        campoAreaConstruida.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoAreaConstruida, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 50, 30));

        campoAreaTotal.setEditable(false);
        campoAreaTotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoAreaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 50, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem Título-1.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAprovarSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAprovarSolicitacaoActionPerformed
        
    }//GEN-LAST:event_ButtonAprovarSolicitacaoActionPerformed

    private void buttonRecusarSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecusarSeguroActionPerformed
        int controle = 0;
        while (controle == 0) {
            String motivo = JOptionPane.showInputDialog(rootPane, "Digite o motivo da reprovação, por favor:");
            if (motivo.equalsIgnoreCase("") || motivo.equalsIgnoreCase(" ")) {
                JOptionPane.showConfirmDialog(rootPane, "O campo de texto não deve ser deixado em branco."
                        + " Por favor, preencha novamente!", "Alerta", JOptionPane.CLOSED_OPTION);
            } else {
                controle = 1;
            }
        }
    }//GEN-LAST:event_buttonRecusarSeguroActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        int resposta = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja retornar a lista de solicitações?");
        if (resposta == 0) {
            Tela_ListaSolicitacoes telaLista = new Tela_ListaSolicitacoes();
            telaLista.setVisible(true);
            dispose();
        }
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
    private javax.swing.JButton ButtonAprovarSolicitacao;
    private javax.swing.JButton buttonEditarSolicitacao;
    private javax.swing.JButton buttonRecusarSeguro;
    private javax.swing.JTextField campoAnoConstrucao;
    private javax.swing.JTextField campoAreaConstruida;
    private javax.swing.JTextField campoAreaTotal;
    private javax.swing.JTextField campoCPFCandidato;
    public javax.swing.JTextField campoCepResidencia;
    private javax.swing.JTextField campoCidadeResidencia;
    public javax.swing.JTextField campoDescricaoResidencia;
    private javax.swing.JTextField campoEmailCandidato;
    private javax.swing.JTextField campoNomeCandidato;
    private javax.swing.JTextField campoQuantidadeComodos;
    private javax.swing.JTextField campoQuantidadeDeBanheiros;
    private javax.swing.JTextField campoQuantidadeDeGaragens;
    public javax.swing.JTextField campoRuaResidencia;
    private javax.swing.JTextField campoTelefoneCandidato;
    public javax.swing.JTextField campoUFResidencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabelCep;
    public javax.swing.JLabel jLabelDescr;
    public javax.swing.JLabel jLabelRua;
    public javax.swing.JLabel jLabelUF;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
