/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DadosUsuarios.Candidato;
import Motor.Motor;

/**
 *
 * @author Débora Siqueira
 */
public class Tela_cadastraPessoa extends javax.swing.JFrame {

    private String sexo;
    private long cep;
    private String dataNascimento;
    private String nomePessoa;
    private long cpf;
    private String endereco;
    private String telefone;
    private String email;
    private String usuarioCliente;
    private String senhaCliente;
    private String uf;
    private String cidade;
    private String bairro;
    Motor motor = new Motor();

    /**
     * Creates new form Tela_cadastraPessoa
     */
    public Tela_cadastraPessoa() {
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

        jLabel1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoCep = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoBairro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoEndereço = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ufComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        campoCidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        diaComboBox = new javax.swing.JComboBox<>();
        mesComboBox = new javax.swing.JComboBox<>();
        anoComboBox = new javax.swing.JComboBox<>();
        Feminino = new javax.swing.JCheckBox();
        Masculino = new javax.swing.JCheckBox();
        confirmarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cpfCampo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        emailCampo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        telefoneCampo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        usuarioCampo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        senhaCampo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 51, 50, -1));
        getContentPane().add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 41, 200, 30));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel2.setText("Cep:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 91, 30, -1));
        getContentPane().add(campoCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 81, 200, 30));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel3.setText("Endereço:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));
        getContentPane().add(campoBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 121, 200, 30));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel4.setText("Bairro:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 50, -1));
        getContentPane().add(campoEndereço, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 161, 200, 30));

        jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel5.setText("UF:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 201, -1, -1));

        ufComboBox.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        ufComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        getContentPane().add(ufComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 201, -1, -1));

        jLabel6.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel6.setText("Cidade:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 211, -1, -1));
        getContentPane().add(campoCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 201, 140, 30));

        jLabel7.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel7.setText("Sexo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 241, -1, -1));

        jLabel8.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel8.setText("Data de Nascimento:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        diaComboBox.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        diaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", " " }));
        getContentPane().add(diaComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 60, -1));

        mesComboBox.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        mesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez" }));
        getContentPane().add(mesComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 60, -1));

        anoComboBox.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        anoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910" }));
        getContentPane().add(anoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        Feminino.setText("Feminino");
        getContentPane().add(Feminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 241, 80, -1));

        Masculino.setText("Masculino");
        getContentPane().add(Masculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 241, 80, -1));

        confirmarButton.setBackground(new java.awt.Color(0, 102, 0));
        confirmarButton.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        confirmarButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmarButton.setText("Confirmar");
        confirmarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(confirmarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, -1, -1));

        cancelarButton.setBackground(new java.awt.Color(204, 0, 0));
        cancelarButton.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cancelarButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 331, -1, -1));

        jLabel9.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel9.setText("CPF:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 51, -1, -1));
        getContentPane().add(cpfCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 41, 200, 30));

        jLabel10.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel10.setText("e-mail:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));
        getContentPane().add(emailCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 81, 200, 30));

        jLabel11.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel11.setText("Telefone:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, -1));
        getContentPane().add(telefoneCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 121, 200, 30));

        jLabel12.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel12.setText("Usuário:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));
        getContentPane().add(usuarioCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 161, 200, 30));

        jLabel13.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel13.setText("Senha:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 50, -1));
        getContentPane().add(senhaCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 201, 200, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/esse sim.jpg"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarButtonActionPerformed
        nomePessoa = campoNome.getText();
        cpf = Long.parseLong(cpfCampo.getText());
        dataNascimento = diaComboBox.getSelectedItem().toString() + "/" + mesComboBox.getSelectedItem().toString() + "/" + anoComboBox.getSelectedItem().toString();
        cep = Long.parseLong(campoCep.getText());
        endereco = campoEndereço.getText();
        email = emailCampo.getText();
        telefone = telefoneCampo.getText();
        usuarioCliente = usuarioCampo.getText();
        senhaCliente = senhaCampo.getText();
        uf = ufComboBox.getSelectedItem().toString();

        Candidato candidato = new Candidato(sexo, cep, dataNascimento, nomePessoa, cpf, endereco, telefone, email, usuarioCliente, senhaCliente, uf, cidade, bairro);
        motor.cadastrarCliente(candidato);
        Tela_Login telaLogin = new Tela_Login();
        telaLogin.setVisible(true);
        dispose();
    }//GEN-LAST:event_confirmarButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        Tela_Login login = new Tela_Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_cadastraPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastraPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastraPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastraPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_cadastraPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Feminino;
    private javax.swing.JCheckBox Masculino;
    private javax.swing.JComboBox<String> anoComboBox;
    private javax.swing.JTextField campoBairro;
    private javax.swing.JTextField campoCep;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoEndereço;
    private javax.swing.JTextField campoNome;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton confirmarButton;
    private javax.swing.JTextField cpfCampo;
    private javax.swing.JComboBox<String> diaComboBox;
    private javax.swing.JTextField emailCampo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> mesComboBox;
    private javax.swing.JTextField senhaCampo;
    private javax.swing.JTextField telefoneCampo;
    private javax.swing.JComboBox<String> ufComboBox;
    private javax.swing.JTextField usuarioCampo;
    // End of variables declaration//GEN-END:variables
}
