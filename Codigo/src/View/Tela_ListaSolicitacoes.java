/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Motor.Gerenciador;
import Motor.ControleSolicitacao;
import Operacoes.Solicitacao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Matheus Montanha
 */
public class Tela_ListaSolicitacoes extends javax.swing.JFrame {

    Solicitacao solicitacaoGuardar;
    Gerenciador gerenciador = new Gerenciador();
    String motivoReprovacao, motivoAlteracao, resultado;
    int visivel = 0;

    /**
     * Creates new form Tela_ListaSolicitacoes
     */
    public Tela_ListaSolicitacoes() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) listaDeSolicitacoes.getModel();
        listaDeSolicitacoes.setRowSorter(new TableRowSorter(modelo));
        readTable();
        jPanelDadosProprietario.setVisible(false);
    }

    public int readTable() {
        DefaultTableModel modelo = (DefaultTableModel) listaDeSolicitacoes.getModel();
        modelo.setNumRows(0);
        Gerenciador motor = new Gerenciador();
        int tamanhoLista = motor.listaDeResidenciasPendentes().size();
        if (tamanhoLista > 0) {
            for (Solicitacao solicitacao : motor.listaDeResidenciasPendentes()) {
                modelo.addRow(new Object[]{
                    solicitacao.getResidencia().getCandidato().getNomePessoa(),
                    solicitacao.getDataSolicitacao()
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
        listaDeSolicitacoes = new javax.swing.JTable();
        jLabelCep = new javax.swing.JLabel();
        campoCepResidencia = new javax.swing.JTextField();
        campoRuaResidencia = new javax.swing.JTextField();
        jLabelRua = new javax.swing.JLabel();
        campoCidadeResidencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoUFResidencia = new javax.swing.JTextField();
        jLabelUF = new javax.swing.JLabel();
        jLabelDescr = new javax.swing.JLabel();
        campoDescricaoResidencia = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        campoAreaConstruida = new javax.swing.JTextField();
        campoAreaTotal = new javax.swing.JTextField();
        jPanelDadosProprietario = new javax.swing.JPanel();
        campoNomeCandidato = new javax.swing.JTextField();
        campoCPFCandidato = new javax.swing.JTextField();
        campoEmailCandidato = new javax.swing.JTextField();
        campoTelefoneCandidato = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        campoAnoConstrucao = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        campoQuantidadeDeGaragens = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        campoQuantidadeDeBanheiros = new javax.swing.JTextField();
        buttonEditarSolicitacao = new javax.swing.JButton();
        campoQuantidadeComodos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ButtonAprovarSolicitacao = new javax.swing.JButton();
        buttonRecusarSeguro = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jToggleButtonDadosProprietario = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        voltarButton.setBackground(new java.awt.Color(153, 51, 255));
        voltarButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        voltarButton.setForeground(new java.awt.Color(255, 255, 255));
        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/back2.png"))); // NOI18N
        voltarButton.setText("Voltar");
        voltarButton.setToolTipText("");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(voltarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 100, 30));

        listaDeSolicitacoes.setBackground(new java.awt.Color(0, 153, 153));
        listaDeSolicitacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Proprietário", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 250, 410));

        jLabelCep.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelCep.setText("Cep:");
        getContentPane().add(jLabelCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 30, -1));

        campoCepResidencia.setEditable(false);
        campoCepResidencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoCepResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 200, 30));

        campoRuaResidencia.setEditable(false);
        campoRuaResidencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoRuaResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 200, 30));

        jLabelRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelRua.setText("Rua:");
        getContentPane().add(jLabelRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 30, -1));

        campoCidadeResidencia.setEditable(false);
        campoCidadeResidencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoCidadeResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 200, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Cidade:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 50, -1));

        campoUFResidencia.setEditable(false);
        campoUFResidencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoUFResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 50, 30));

        jLabelUF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelUF.setText("UF:");
        getContentPane().add(jLabelUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 30, -1));

        jLabelDescr.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDescr.setText("Descrição:");
        getContentPane().add(jLabelDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 70, 20));

        campoDescricaoResidencia.setEditable(false);
        campoDescricaoResidencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoDescricaoResidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 190, 50));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Area Total:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, 70, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Area Construida:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, -1, -1));

        campoAreaConstruida.setEditable(false);
        campoAreaConstruida.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoAreaConstruida, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 390, 50, 30));

        campoAreaTotal.setEditable(false);
        campoAreaTotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoAreaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 430, 50, 30));

        jPanelDadosProprietario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelDadosProprietario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoNomeCandidato.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanelDadosProprietario.add(campoNomeCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 170, 30));

        campoCPFCandidato.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanelDadosProprietario.add(campoCPFCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 170, 30));

        campoEmailCandidato.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanelDadosProprietario.add(campoEmailCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 170, 30));

        campoTelefoneCandidato.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanelDadosProprietario.add(campoTelefoneCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 170, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Nome:");
        jPanelDadosProprietario.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("CPF:");
        jPanelDadosProprietario.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 30, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Email:");
        jPanelDadosProprietario.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 110, 40, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Telefone:");
        jPanelDadosProprietario.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        getContentPane().add(jPanelDadosProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 260, 190));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Ano de Construção:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, -1, -1));

        campoAnoConstrucao.setEditable(false);
        campoAnoConstrucao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoAnoConstrucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 350, 50, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Quantidade de Garagens:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, -1, -1));

        campoQuantidadeDeGaragens.setEditable(false);
        campoQuantidadeDeGaragens.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoQuantidadeDeGaragens, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 310, 50, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Quantidade de Banheiros:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, -1, -1));

        campoQuantidadeDeBanheiros.setEditable(false);
        campoQuantidadeDeBanheiros.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoQuantidadeDeBanheiros, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 50, 30));

        buttonEditarSolicitacao.setBackground(new java.awt.Color(0, 0, 102));
        buttonEditarSolicitacao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonEditarSolicitacao.setForeground(new java.awt.Color(255, 255, 255));
        buttonEditarSolicitacao.setText("Editar");
        buttonEditarSolicitacao.setMaximumSize(new java.awt.Dimension(87, 23));
        buttonEditarSolicitacao.setMinimumSize(new java.awt.Dimension(84, 23));
        buttonEditarSolicitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarSolicitacaoActionPerformed(evt);
            }
        });
        getContentPane().add(buttonEditarSolicitacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 100, 30));

        campoQuantidadeComodos.setEditable(false);
        campoQuantidadeComodos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(campoQuantidadeComodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, 50, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Quantidade de Comodos:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, -1, -1));

        ButtonAprovarSolicitacao.setBackground(new java.awt.Color(0, 153, 255));
        ButtonAprovarSolicitacao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ButtonAprovarSolicitacao.setForeground(new java.awt.Color(255, 255, 255));
        ButtonAprovarSolicitacao.setText("Aprovada");
        ButtonAprovarSolicitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAprovarSolicitacaoActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonAprovarSolicitacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 510, 100, 30));

        buttonRecusarSeguro.setBackground(new java.awt.Color(153, 51, 255));
        buttonRecusarSeguro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonRecusarSeguro.setForeground(new java.awt.Color(255, 255, 255));
        buttonRecusarSeguro.setText("Recusada");
        buttonRecusarSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecusarSeguroActionPerformed(evt);
            }
        });
        getContentPane().add(buttonRecusarSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 510, 100, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Dados Residência: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        jToggleButtonDadosProprietario.setBackground(new java.awt.Color(204, 204, 255));
        jToggleButtonDadosProprietario.setText("Dados Proprietário");
        jToggleButtonDadosProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonDadosProprietarioActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButtonDadosProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 160, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem Título-1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        Painel_Corretor painel = new Painel_Corretor();
        painel.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void listaDeSolicitacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaDeSolicitacoesMouseClicked
        int linhaSelecionada = listaDeSolicitacoes.getSelectedRow();
        preencherCampos(linhaSelecionada);
    }//GEN-LAST:event_listaDeSolicitacoesMouseClicked

    private void buttonEditarSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarSolicitacaoActionPerformed

    }//GEN-LAST:event_buttonEditarSolicitacaoActionPerformed

    private void ButtonAprovarSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAprovarSolicitacaoActionPerformed
        JOptionPane.showInputDialog(rootPane, "Solicitação aprovada com sucesso!");
        resultado = "aprovada";
        gerenciador.updateSituacaoSolicitacao(resultado, motivoReprovacao, motivoAlteracao);
    }//GEN-LAST:event_ButtonAprovarSolicitacaoActionPerformed

    private void buttonRecusarSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecusarSeguroActionPerformed
        int controle = 0;
        while (controle == 0) {
            resultado = "reprovada";
            motivoReprovacao = JOptionPane.showInputDialog(rootPane, "Digite o motivo da reprovação, por favor:");
            gerenciador.updateSituacaoSolicitacao(resultado, motivoReprovacao, motivoAlteracao);
            if (motivoReprovacao.equalsIgnoreCase("") || motivoReprovacao.equalsIgnoreCase(" ")) {
                JOptionPane.showConfirmDialog(rootPane, "O campo de texto não deve ser deixado em branco."
                        + " Por favor, preencha novamente!", "Alerta", JOptionPane.CLOSED_OPTION);
            } else {
                controle = 1;
            }
        }
    }//GEN-LAST:event_buttonRecusarSeguroActionPerformed

    private void jToggleButtonDadosProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonDadosProprietarioActionPerformed
        jPanelDadosProprietario.setVisible(true);
        if (visivel == 1) {
            jPanelDadosProprietario.setVisible(false);
            visivel = 0;
        } else {
            visivel++;
        }
    }//GEN-LAST:event_jToggleButtonDadosProprietarioActionPerformed

    public void preencherCampos(int numeroLinha) {
        List<Solicitacao> listaDeSolicitacao;
        listaDeSolicitacao = gerenciador.listaDeResidenciasPendentes();
        String cep = "" + listaDeSolicitacao.get(numeroLinha).getResidencia().getCepRes();
        campoCepResidencia.setText(cep);
        campoCidadeResidencia.setText(listaDeSolicitacao.get(numeroLinha).getResidencia().getCandidato().getCidade());
        campoRuaResidencia.setText(listaDeSolicitacao.get(numeroLinha).getResidencia().getRuaRes());
        campoDescricaoResidencia.setText(listaDeSolicitacao.get(numeroLinha).getResidencia().getDescricaoRes());
        campoUFResidencia.setText(listaDeSolicitacao.get(numeroLinha).getResidencia().getUfResidencia());
        campoNomeCandidato.setText(listaDeSolicitacao.get(numeroLinha).getResidencia().getCandidato().getNomePessoa());
        campoCPFCandidato.setText("" + listaDeSolicitacao.get(numeroLinha).getResidencia().getCandidato().getCpf());
        campoEmailCandidato.setText(listaDeSolicitacao.get(numeroLinha).getResidencia().getCandidato().getEmail());
        campoTelefoneCandidato.setText(listaDeSolicitacao.get(numeroLinha).getResidencia().getCandidato().getTelefone());
        campoQuantidadeComodos.setText("" + listaDeSolicitacao.get(numeroLinha).getResidencia().getQntComodos());
        campoQuantidadeDeBanheiros.setText("" + listaDeSolicitacao.get(numeroLinha).getResidencia().getQntBanheiros());
        campoQuantidadeDeGaragens.setText("" + listaDeSolicitacao.get(numeroLinha).getResidencia().getQntGaragens());
        campoAreaConstruida.setText("" + listaDeSolicitacao.get(numeroLinha).getResidencia().getAreaConstruida());
        campoAnoConstrucao.setText("" + listaDeSolicitacao.get(numeroLinha).getResidencia().getAnoConstrucao());
        campoAreaTotal.setText("" + listaDeSolicitacao.get(numeroLinha).getResidencia().getAreaTotal());
    }

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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLabelCep;
    public javax.swing.JLabel jLabelDescr;
    public javax.swing.JLabel jLabelRua;
    public javax.swing.JLabel jLabelUF;
    private javax.swing.JPanel jPanelDadosProprietario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButtonDadosProprietario;
    public javax.swing.JTable listaDeSolicitacoes;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
