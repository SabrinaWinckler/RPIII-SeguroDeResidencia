/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DadosUsuarios.Candidato;
import Motor.Gerenciador;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Débora Siqueira
 */
public class Tela_Login extends javax.swing.JFrame {
    
    Gerenciador motor = new Gerenciador();
    Candidato usuario;

    /**
     * Creates new form Tela_Login
     */
    public Tela_Login() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        campoUsuario = new javax.swing.JTextPane();
        identificadorUsuario = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        entrarButton = new javax.swing.JButton();
        cadastrarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(campoUsuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 128, -1));

        identificadorUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        identificadorUsuario.setForeground(new java.awt.Color(255, 255, 255));
        identificadorUsuario.setText("Usuário:");
        getContentPane().add(identificadorUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 60, 20));

        campoSenha.setText("jPasswordField1");
        getContentPane().add(campoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 128, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 60, 20));

        entrarButton.setBackground(new java.awt.Color(153, 51, 255));
        entrarButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        entrarButton.setForeground(new java.awt.Color(255, 255, 255));
        entrarButton.setText("Entrar");
        entrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(entrarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, -1, -1));

        cadastrarButton.setBackground(new java.awt.Color(0, 153, 255));
        cadastrarButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cadastrarButton.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarButton.setText("Cadastrar-se");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cadastrarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user-silhouette.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 30, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/locked-padlock.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/login.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 980, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        Tela_cadastraPessoa cadastro = new Tela_cadastraPessoa();
        cadastro.setVisible(true);
        dispose();
    }//GEN-LAST:event_cadastrarButtonActionPerformed

    private void entrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarButtonActionPerformed
        boolean usuarioExiste = false;
        List<Candidato> listPessoas = motor.retornaCliente();
        for (Candidato pessoa : listPessoas) {
            char[] senha = campoSenha.getPassword();
            String senhaJunta = "";
            for (int i = 0; i < campoSenha.getPassword().length; i++) {
                senhaJunta += senha[i];
            }
            if (pessoa.getUsuarioCliente().equalsIgnoreCase(campoUsuario.getText()) && pessoa.getSenhaCliente().equalsIgnoreCase(senhaJunta)) {
                usuarioExiste = true;
                
                usuario = pessoa;
                Painel_Candidato painelCandidato = new Painel_Candidato();
                painelCandidato.setVisible(true);
                dispose();
            }
        }
        if (!usuarioExiste) {
            JOptionPane.showConfirmDialog(rootPane, "Usuário ou senha inválidos. "
                    + "Por favor, digite novamente.", "Alerta", JOptionPane.CLOSED_OPTION);
        }
    }//GEN-LAST:event_entrarButtonActionPerformed
    
    public Candidato usuarioIdenficacao() {
        return usuario = motor.retornaCliente().get(0);
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextPane campoUsuario;
    private javax.swing.JButton entrarButton;
    private javax.swing.JLabel identificadorUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
