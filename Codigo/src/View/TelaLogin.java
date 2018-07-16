/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import entity.Candidato;
import entity.Corretor;
import entity.Pessoa;
import entity.Segurado;
import Motor.Gerenciador;
import Motor.GerenciadorViewLogin;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Débora Siqueira
 */
public class TelaLogin extends javax.swing.JFrame {

    Gerenciador motor = new Gerenciador();
    TelaCandidato painelCandidato;

    /**
     * Creates new form Tela_Login
     */
    public TelaLogin() {
        initComponents();
        usuarioEsqueciASenhajPanel.setVisible(false);
        EsqueciASenhajPanel.setVisible(false);
        campoUsuario.setText("paulo");
        campoSenha.setText("0352635");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarioEsqueciASenhajPanel = new javax.swing.JPanel();
        usuarioJLabel = new javax.swing.JLabel();
        usuarioVerificar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        enviarUsuarioButton = new javax.swing.JButton();
        cancelarEnvioUsuarioButton = new javax.swing.JButton();
        EsqueciASenhajPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        novaSenha = new javax.swing.JPasswordField();
        repitaNovaSenha = new javax.swing.JPasswordField();
        enviarNovaSenha = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoUsuario = new javax.swing.JTextPane();
        identificadorUsuario = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        entrarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        perguntaPrimeiroAcesso = new javax.swing.JLabel();
        cadastro = new javax.swing.JLabel();
        perguntaEsqueceuSenha = new javax.swing.JLabel();
        recuperarSenha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuarioEsqueciASenhajPanel.setBackground(new java.awt.Color(2, 66, 130));
        usuarioEsqueciASenhajPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        usuarioEsqueciASenhajPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuarioJLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        usuarioJLabel.setForeground(new java.awt.Color(255, 255, 255));
        usuarioJLabel.setText("Login:");
        usuarioEsqueciASenhajPanel.add(usuarioJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 40, -1, 30));

        usuarioVerificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        usuarioEsqueciASenhajPanel.add(usuarioVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 170, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(188, 132, 253));
        jLabel7.setText("Digite o seu usuário:");
        usuarioEsqueciASenhajPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));

        enviarUsuarioButton.setBackground(new java.awt.Color(26, 204, 252));
        enviarUsuarioButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        enviarUsuarioButton.setForeground(new java.awt.Color(255, 255, 255));
        enviarUsuarioButton.setText("Continuar");
        enviarUsuarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarUsuarioButtonActionPerformed(evt);
            }
        });
        usuarioEsqueciASenhajPanel.add(enviarUsuarioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        cancelarEnvioUsuarioButton.setBackground(new java.awt.Color(126, 87, 194));
        cancelarEnvioUsuarioButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cancelarEnvioUsuarioButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelarEnvioUsuarioButton.setText("Cancelar");
        cancelarEnvioUsuarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEnvioUsuarioButtonActionPerformed(evt);
            }
        });
        usuarioEsqueciASenhajPanel.add(cancelarEnvioUsuarioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        getContentPane().add(usuarioEsqueciASenhajPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 230, 130));

        EsqueciASenhajPanel.setBackground(new java.awt.Color(2, 66, 130));
        EsqueciASenhajPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EsqueciASenhajPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Repita a senha:");
        EsqueciASenhajPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 140, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nova senha:");
        EsqueciASenhajPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 120, 20));
        EsqueciASenhajPanel.add(novaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 120, 30));
        EsqueciASenhajPanel.add(repitaNovaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 120, 30));

        enviarNovaSenha.setBackground(new java.awt.Color(26, 204, 252));
        enviarNovaSenha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        enviarNovaSenha.setForeground(new java.awt.Color(255, 255, 255));
        enviarNovaSenha.setText("Enviar");
        enviarNovaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarNovaSenhaActionPerformed(evt);
            }
        });
        EsqueciASenhajPanel.add(enviarNovaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        getContentPane().add(EsqueciASenhajPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 290, 150));

        jScrollPane1.setViewportView(campoUsuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 128, -1));

        identificadorUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        identificadorUsuario.setForeground(new java.awt.Color(255, 255, 255));
        identificadorUsuario.setText("Usuário:");
        getContentPane().add(identificadorUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 60, 20));
        getContentPane().add(campoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 128, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 60, 20));

        entrarButton.setBackground(new java.awt.Color(153, 51, 255));
        entrarButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        entrarButton.setForeground(new java.awt.Color(255, 255, 255));
        entrarButton.setText("Entrar");
        entrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(entrarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user-silhouette.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 30, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/locked-padlock.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

        perguntaPrimeiroAcesso.setBackground(new java.awt.Color(255, 255, 255));
        perguntaPrimeiroAcesso.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        perguntaPrimeiroAcesso.setForeground(new java.awt.Color(255, 255, 255));
        perguntaPrimeiroAcesso.setText("Seu primeiro acesso? ");
        perguntaPrimeiroAcesso.setToolTipText("");
        getContentPane().add(perguntaPrimeiroAcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 130, 30));

        cadastro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cadastro.setForeground(new java.awt.Color(255, 255, 255));
        cadastro.setText("Cadastre-se aqui");
        cadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cadastroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cadastroMouseExited(evt);
            }
        });
        getContentPane().add(cadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, 30));

        perguntaEsqueceuSenha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        perguntaEsqueceuSenha.setForeground(new java.awt.Color(255, 255, 255));
        perguntaEsqueceuSenha.setText("Esqueceu sua senha?");
        getContentPane().add(perguntaEsqueceuSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 130, 20));

        recuperarSenha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        recuperarSenha.setForeground(new java.awt.Color(255, 255, 255));
        recuperarSenha.setText("Recuperar senha");
        recuperarSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recuperarSenhaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recuperarSenhaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recuperarSenhaMouseExited(evt);
            }
        });
        getContentPane().add(recuperarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 100, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/login.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void entrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarButtonActionPerformed
        entrarButton.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        realizarLogin();
        entrarButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_entrarButtonActionPerformed

    private void cadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastroMouseClicked
        TelaCadastraPessoa telaCadastro = new TelaCadastraPessoa();
        telaCadastro.setVisible(true);
        dispose();
    }//GEN-LAST:event_cadastroMouseClicked

    private void cadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastroMouseEntered
        cadastro.setForeground(new Color(68, 122, 221));
        cadastro.setFont(new Font("Arial", Font.ITALIC, 12));
        cadastro.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cadastroMouseEntered

    private void cadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastroMouseExited
        cadastro.setForeground(new Color(255, 255, 255));
        cadastro.setFont(new Font("Arial", Font.BOLD, 12));
    }//GEN-LAST:event_cadastroMouseExited

    private void recuperarSenhaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recuperarSenhaMouseEntered
        recuperarSenha.setForeground(new Color(68, 122, 221));
        recuperarSenha.setFont(new Font("Arial", Font.ITALIC, 12));
        recuperarSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_recuperarSenhaMouseEntered

    private void recuperarSenhaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recuperarSenhaMouseExited
        recuperarSenha.setForeground(new Color(255, 255, 255));
        recuperarSenha.setFont(new Font("Arial", Font.BOLD, 12));
    }//GEN-LAST:event_recuperarSenhaMouseExited

    private void recuperarSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recuperarSenhaMouseClicked
        usuarioEsqueciASenhajPanel.setVisible(true);
    }//GEN-LAST:event_recuperarSenhaMouseClicked

    private void enviarUsuarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarUsuarioButtonActionPerformed
        boolean userNameExiste = false;
        for (String userName : GerenciadorViewLogin.getInstance().esqueciASenha()) {
            if (userName.equalsIgnoreCase(usuarioVerificar.getText())) {
                usuarioEsqueciASenhajPanel.setVisible(false);
                EsqueciASenhajPanel.setVisible(true);
                userNameExiste = true;
            }
        }
        if (!userNameExiste) {
            JOptionPane.showConfirmDialog(rootPane, "Usuário informado não foi encontrado.", "Alerta", JOptionPane.CLOSED_OPTION);
        }
    }//GEN-LAST:event_enviarUsuarioButtonActionPerformed

    private void cancelarEnvioUsuarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEnvioUsuarioButtonActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja cancelar?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
            usuarioEsqueciASenhajPanel.setVisible(false);
        }
    }//GEN-LAST:event_cancelarEnvioUsuarioButtonActionPerformed

    private void enviarNovaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarNovaSenhaActionPerformed
        String esqueciASenha = String.copyValueOf(novaSenha.getPassword());
        String repitaSenha = String.copyValueOf(repitaNovaSenha.getPassword());
        if (esqueciASenha.equals(repitaSenha)) {
            GerenciadorViewLogin.getInstance().updatePassword(usuarioVerificar.getText(), repitaSenha);
            JOptionPane.showConfirmDialog(rootPane, "Nova senha salva com sucesso.", "Alerta", JOptionPane.CLOSED_OPTION);
            EsqueciASenhajPanel.setVisible(false);
        } else {
            JOptionPane.showConfirmDialog(rootPane, "As senhas não combinam. Por favor, digite novamente.", "Alerta", JOptionPane.CLOSED_OPTION);
        }
    }//GEN-LAST:event_enviarNovaSenhaActionPerformed

    private void realizarLogin() {
        boolean usuarioExiste = false;
        List<Candidato> listPessoas = GerenciadorViewLogin.getInstance().retornaCliente();
        List<Corretor> listCorretores = GerenciadorViewLogin.getInstance().retornarCorretor();
        List<Segurado> listSegurados = GerenciadorViewLogin.getInstance().retornaSegurados();
        String senhaJunta = String.copyValueOf(campoSenha.getPassword());
        for (Segurado segurado : listSegurados) {
            if (segurado.getUsuarioCliente().equalsIgnoreCase(campoUsuario.getText()) && segurado.getSenhaCliente().equalsIgnoreCase(senhaJunta)) {
                GerenciadorViewLogin.getInstance().setSeguradoOnline(segurado);
                painelCandidato = new TelaCandidato();
                painelCandidato.setVisible(true);
                dispose();
                usuarioExiste = true;
                break;
            }
        }
        if (!usuarioExiste) {
            for (Candidato pessoa : listPessoas) {
                if (pessoa.getUsuarioCliente().equalsIgnoreCase(campoUsuario.getText()) && pessoa.getSenhaCliente().equalsIgnoreCase(senhaJunta)) {
                    usuarioExiste = true;
                    painelCandidato = new TelaCandidato(pessoa);
                    GerenciadorViewLogin.getInstance().setCandidatoOnline(pessoa);
                    painelCandidato.setVisible(true);
                    dispose();
                }
            }
        }
        if (!usuarioExiste) {
            for (Corretor certoCorretor : listCorretores) {
                if (certoCorretor.getUsuarioCliente().equalsIgnoreCase(campoUsuario.getText()) && certoCorretor.getSenhaCliente().equalsIgnoreCase(senhaJunta)) {
                    usuarioExiste = true;
                    GerenciadorViewLogin.getInstance().setCorretorOnline(certoCorretor);
                    TelaCorretor painelCorretor = new TelaCorretor();
                    painelCorretor.setVisible(true);
                    dispose();
                }
            }
        }
        if (!usuarioExiste) {
            JOptionPane.showConfirmDialog(rootPane, "Usuário ou senha inválidos. "
                    + "Por favor, digite novamente.", "Alerta", JOptionPane.CLOSED_OPTION);
        }
    }

    public Pessoa identificarUsuario() {
        return null;
    }

    public void gerarBackground() {
        String pasta = System.getProperty("user.dir");
        //bg.setIcon(new ImageIcon(pasta + "/src/imagens/barraSup.jpg"));

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EsqueciASenhajPanel;
    private javax.swing.JLabel cadastro;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextPane campoUsuario;
    private javax.swing.JButton cancelarEnvioUsuarioButton;
    private javax.swing.JButton entrarButton;
    private javax.swing.JButton enviarNovaSenha;
    private javax.swing.JButton enviarUsuarioButton;
    private javax.swing.JLabel identificadorUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField novaSenha;
    private javax.swing.JLabel perguntaEsqueceuSenha;
    private javax.swing.JLabel perguntaPrimeiroAcesso;
    private javax.swing.JLabel recuperarSenha;
    private javax.swing.JPasswordField repitaNovaSenha;
    private javax.swing.JPanel usuarioEsqueciASenhajPanel;
    private javax.swing.JLabel usuarioJLabel;
    private javax.swing.JTextField usuarioVerificar;
    // End of variables declaration//GEN-END:variables
}