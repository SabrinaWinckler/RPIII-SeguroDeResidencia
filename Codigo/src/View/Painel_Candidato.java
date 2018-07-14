/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dominio.Apolice;
import Dominio.Candidato;
import Motor.RepositorioSolicitacao;
import Motor.Gerenciador;
import Dominio.Solicitacao;
import Dominio.Bem;
import Dominio.ItemServico;
import Dominio.Residencia;
import Dominio.Segurado;
import Excecoes.ExceptionEmptySpace;
import Motor.GerenciadorViewLogin;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Montanha
 */
public class Painel_Candidato extends javax.swing.JFrame {
    
    int visivel = 0;
    RepositorioSolicitacao controlador = new RepositorioSolicitacao();
    List<Solicitacao> listaSolicitacao = new ArrayList<>();
    Gerenciador gerenciador = new Gerenciador();
    private int quantidadeDeSolicitacao, selecionado;
    static Segurado segurado;
    static Candidato candidato;
    List<ItemServico> listaDeServico = new ArrayList<>();
    GerenciadorViewLogin gerenciadorLogin = new GerenciadorViewLogin();
    List<Apolice> listaDeApolices = new ArrayList<>();
    String caminho;

    /**
     * Creates new form Painel_Corretor
     */
    public Painel_Candidato() {
        initComponents();
        gerarBackground();
        home();
    }
    
    public Painel_Candidato(Candidato seguradoOnline) {
        initComponents();
        candidato = seguradoOnline;
        gerarBackground();
        quantidadeDeSolicitacao = readTableListaSolicitacao(seguradoOnline);
        habilitarOpcoesSegurado(false);
        preencherComboBox();
        home();
    }
    
    public Painel_Candidato(Segurado seguradoOnline) {
        initComponents();
        segurado = seguradoOnline;
        readTableListaServico(seguradoOnline);
        readTableApolices(seguradoOnline);
        habilitarOpcoesSegurado(true);
        gerarBackground();
        home();
    }
    
    private int readTableApolices(Segurado segurado) {
        DefaultTableModel modelo = (DefaultTableModel) jListaDeApolices.getModel();
        modelo.setNumRows(0);
        int tamanhoLista = gerenciador.apolicePorCliente(segurado).size();
        if (tamanhoLista > 0) {
            for (String string : gerenciador.apolicePorCliente(segurado)) {
                modelo.addRow(new Object[]{
                    "Apólice da Residencia: " + string
                });
            }
            return 1;
        } else {
            return 0;
        }
        
    }
    
    private int readTableMinhasSolicitacoes(Segurado candidato) {
        DefaultTableModel modelo = (DefaultTableModel) listaMinhasSolicitacoes.getModel();
        modelo.setNumRows(0);
        listaSolicitacao = gerenciador.minhasSolicitacoes(candidato.getIdSegurado());
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
    
    private int readTableListaServico(Segurado segurado) {
        DefaultTableModel modelo = (DefaultTableModel) jTabelaListaServicos.getModel();
        modelo.setNumRows(0);
        listaDeServico = gerenciador.servicoPorCliente(segurado);
        int tamanhoLista = listaDeServico.size();
        if (tamanhoLista > 0) {
            for (ItemServico itemServico : listaDeServico) {
                modelo.addRow(new Object[]{
                    itemServico.getDesc(),
                    itemServico.getDataDeSolitacao() //adicionar o cep
                });
            }
            return 1;
        } else {
            return 0;
        }
        
    }
    
    private int readTableListaSolicitacao(Candidato candidato) {
        DefaultTableModel modelo = (DefaultTableModel) listaSolicitacaoCandidato.getModel();
        modelo.setNumRows(0);
        listaSolicitacao = gerenciador.listaSolicitacaoCliente(candidato);
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
    
    private int readTableResidencia(Candidato candidato) {
        DefaultTableModel modelo = (DefaultTableModel) residencias.getModel();
        modelo.setNumRows(0);
        listaSolicitacao = gerenciador.listaSolicitacaoCliente(candidato);
        int tamanhoLista = listaSolicitacao.size();
        if (tamanhoLista > 0) {
            for (Solicitacao solicitacao : listaSolicitacao) {
                modelo.addRow(new Object[]{
                    solicitacao.getResidencia().getDescricaoRes(),
                    solicitacao.getResidencia().getCepRes()
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

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        jMenu1 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        popupMenu1 = new java.awt.PopupMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        painelP = new javax.swing.JPanel();
        painelContato = new javax.swing.JPanel();
        enviarContato = new javax.swing.JButton();
        cancelarContato = new javax.swing.JButton();
        email = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        mensagem = new javax.swing.JTextArea();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        painelResidencias = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        residencias = new javax.swing.JTable();
        jLabel59 = new javax.swing.JLabel();
        confirmResidencia = new javax.swing.JButton();
        cancelarRes = new javax.swing.JButton();
        painelSinistro = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descricaoSinistro = new javax.swing.JTextArea();
        enviarSinistro = new javax.swing.JButton();
        cancelarSinistro = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        comboSinistro = new javax.swing.JComboBox<>();
        jPanelHome = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanelListaSeguros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaSolicitacaoCandidato = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jPanelSolicitacaoAprovada = new javax.swing.JPanel();
        buttonRecusarSeguro = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        textObs = new javax.swing.JTextPane();
        jLabel31 = new javax.swing.JLabel();
        ButtonContratarSeguro = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        textValorSeguro = new javax.swing.JTextPane();
        buttonVoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        textCep = new javax.swing.JTextPane();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textCidade = new javax.swing.JTextPane();
        textBairro = new javax.swing.JScrollPane();
        textB = new javax.swing.JTextPane();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        textEnd = new javax.swing.JTextPane();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanelPagamento = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        campoNumeroDoCartao = new javax.swing.JTextField();
        campoImpressoNomeCartao = new javax.swing.JTextField();
        campoValorSeguroPagamento = new javax.swing.JTextField();
        campoCodSegurancaCartao = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        mesComboBox = new javax.swing.JComboBox<>();
        anoComboBox = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        quantidadeVezesParcela = new javax.swing.JComboBox<>();
        buttonConfirmar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        campoValorParcelado = new javax.swing.JTextField();
        painelServico = new javax.swing.JPanel();
        jPanelListaServicos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaListaServicos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        buttonFecharListaServicos = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        calendarServico = new com.toedter.calendar.JCalendar();
        enviarServico = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        chaveiro = new javax.swing.JCheckBox();
        cancelarServico = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        eletricista = new javax.swing.JCheckBox();
        listaTurnosServico = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        buttonDataServico = new javax.swing.JToggleButton();
        visualizarSolicitacaoServico = new javax.swing.JLabel();
        encanador = new javax.swing.JCheckBox();
        painelSolicitacao = new javax.swing.JPanel();
        cep = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        uf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rua = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        numero = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        descBem = new javax.swing.JTextField();
        valor = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        comodos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        banheiro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        garagem = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        andares = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        descRes = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        anoC = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        areat = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        localizacaoP = new javax.swing.JSlider();
        l = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        terrenoP = new javax.swing.JSlider();
        t = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        estruturaA = new javax.swing.JSlider();
        e = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        confirmarEdicao = new javax.swing.JButton();
        enviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        areaConstruida = new javax.swing.JTextField(4);
        jSeparator1 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        remover = new javax.swing.JButton();
        editarBem = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        tabelaBens = new javax.swing.JTable();
        jLabel61 = new javax.swing.JLabel();
        jPanelSolicitacaoReprovada = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        textMotivo = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        textCep1 = new javax.swing.JTextPane();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        textB1 = new javax.swing.JTextPane();
        jScrollPane14 = new javax.swing.JScrollPane();
        textCidade1 = new javax.swing.JTextPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        textEnd1 = new javax.swing.JTextPane();
        jLabel52 = new javax.swing.JLabel();
        buttonVoltar3 = new javax.swing.JButton();
        jPanelListaApoliceServico = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListaDeApolices = new javax.swing.JTable();
        PanelSolicitarSeguro = new javax.swing.JPanel();
        panelComListaSolicitacoes = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        listaMinhasSolicitacoes = new javax.swing.JTable();
        buttonFecharMinhasSolicitacoes = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        cancelarSolicitacao = new javax.swing.JButton();
        nova = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        minhasSolicitacoes = new javax.swing.JButton();
        editarSelecionado = new javax.swing.JButton();
        excluirSelecionado = new javax.swing.JButton();
        buttonHome = new javax.swing.JButton();
        relatarSinistro = new javax.swing.JButton();
        contratarServico = new javax.swing.JButton();
        solicitarSeguro = new javax.swing.JButton();
        buttonContratarSeguro = new javax.swing.JButton();
        sairButton = new javax.swing.JButton();
        buttonContato = new javax.swing.JButton();
        bg = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        jMenu1.setText("jMenu1");

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelP.setBackground(new java.awt.Color(255, 255, 255));
        painelP.setForeground(new java.awt.Color(110, 48, 110));
        painelP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enviarContato.setText("Enviar");
        enviarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarContatoActionPerformed(evt);
            }
        });

        cancelarContato.setText("Cancelar");
        cancelarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarContatoActionPerformed(evt);
            }
        });

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        mensagem.setColumns(20);
        mensagem.setRows(5);
        jScrollPane12.setViewportView(mensagem);

        jLabel56.setText("Contato:");

        jLabel57.setText("Email:");

        jLabel58.setText("Mensagem:");

        javax.swing.GroupLayout painelContatoLayout = new javax.swing.GroupLayout(painelContato);
        painelContato.setLayout(painelContatoLayout);
        painelContatoLayout.setHorizontalGroup(
            painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelContatoLayout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addComponent(cancelarContato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enviarContato)
                .addGap(32, 32, 32))
            .addGroup(painelContatoLayout.createSequentialGroup()
                .addGroup(painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelContatoLayout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel56))
                    .addGroup(painelContatoLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57)
                            .addGroup(painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(email)
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
                            .addComponent(jLabel58))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelContatoLayout.setVerticalGroup(
            painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addGap(8, 8, 8)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel58)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(painelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enviarContato)
                    .addComponent(cancelarContato))
                .addGap(29, 29, 29))
        );

        painelP.add(painelContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        residencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Descrição", "CEP"
            }
        ));
        residencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                residenciasMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(residencias);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setText("Escolha qual residência deseja gerenciar:");

        confirmResidencia.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        confirmResidencia.setForeground(new java.awt.Color(110, 48, 110));
        confirmResidencia.setText("Confirmar");
        confirmResidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmResidenciaActionPerformed(evt);
            }
        });

        cancelarRes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cancelarRes.setForeground(new java.awt.Color(110, 48, 110));
        cancelarRes.setText("Cancelar");
        cancelarRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarResActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelResidenciasLayout = new javax.swing.GroupLayout(painelResidencias);
        painelResidencias.setLayout(painelResidenciasLayout);
        painelResidenciasLayout.setHorizontalGroup(
            painelResidenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelResidenciasLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(painelResidenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelResidenciasLayout.createSequentialGroup()
                        .addComponent(cancelarRes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmResidencia))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelResidenciasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel59)
                .addGap(98, 98, 98))
        );
        painelResidenciasLayout.setVerticalGroup(
            painelResidenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelResidenciasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel59)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelResidenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmResidencia)
                    .addComponent(cancelarRes))
                .addGap(27, 27, 27))
        );

        painelP.add(painelResidencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Selecione o sinistro que deseja relatar:");

        descricaoSinistro.setColumns(20);
        descricaoSinistro.setRows(5);
        jScrollPane2.setViewportView(descricaoSinistro);

        enviarSinistro.setText("Enviar");
        enviarSinistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarSinistroActionPerformed(evt);
            }
        });

        cancelarSinistro.setText("Cancelar");
        cancelarSinistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarSinistroActionPerformed(evt);
            }
        });

        jLabel34.setText("Descreva Brevemente o que aconteceu:");

        comboSinistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSinistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelSinistroLayout = new javax.swing.GroupLayout(painelSinistro);
        painelSinistro.setLayout(painelSinistroLayout);
        painelSinistroLayout.setHorizontalGroup(
            painelSinistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSinistroLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(painelSinistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSinistroLayout.createSequentialGroup()
                        .addGroup(painelSinistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelSinistroLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel34))
                            .addComponent(jLabel33)
                            .addGroup(painelSinistroLayout.createSequentialGroup()
                                .addComponent(comboSinistro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(160, 160, 160))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSinistroLayout.createSequentialGroup()
                        .addComponent(cancelarSinistro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enviarSinistro)
                        .addGap(80, 80, 80))))
        );
        painelSinistroLayout.setVerticalGroup(
            painelSinistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSinistroLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(comboSinistro)
                .addGap(32, 32, 32)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelSinistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarSinistro)
                    .addComponent(enviarSinistro))
                .addGap(35, 35, 35))
        );

        painelP.add(painelSinistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 440, 360));

        jPanelHome.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/TelaInicial.png"))); // NOI18N
        jLabel28.setText("jLabel28");
        jPanelHome.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, -1));

        painelP.add(jPanelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        jPanelListaSeguros.setBackground(new java.awt.Color(255, 255, 255));
        jPanelListaSeguros.setMinimumSize(new java.awt.Dimension(730, 490));
        jPanelListaSeguros.setPreferredSize(new java.awt.Dimension(730, 490));
        jPanelListaSeguros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        listaSolicitacaoCandidato.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                listaSolicitacaoCandidatoMouseMoved(evt);
            }
        });
        listaSolicitacaoCandidato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaSolicitacaoCandidatoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                listaSolicitacaoCandidatoMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(listaSolicitacaoCandidato);

        jPanelListaSeguros.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 560, 160));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setText("Selecione a Solicitação Desejada:");
        jPanelListaSeguros.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        painelP.add(jPanelListaSeguros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        jPanelSolicitacaoAprovada.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSolicitacaoAprovada.setPreferredSize(new java.awt.Dimension(730, 490));
        jPanelSolicitacaoAprovada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonRecusarSeguro.setBackground(new java.awt.Color(126, 87, 194));
        buttonRecusarSeguro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonRecusarSeguro.setForeground(new java.awt.Color(255, 255, 255));
        buttonRecusarSeguro.setText("Recusar");
        buttonRecusarSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecusarSeguroActionPerformed(evt);
            }
        });
        jPanelSolicitacaoAprovada.add(buttonRecusarSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 90, 30));

        jLabel30.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel30.setText("Observações:");
        jPanelSolicitacaoAprovada.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        textObs.setEditable(false);
        jScrollPane7.setViewportView(textObs);

        jPanelSolicitacaoAprovada.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 270, 120));

        jLabel31.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel31.setText("Valor do Seguro:");
        jPanelSolicitacaoAprovada.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        ButtonContratarSeguro.setBackground(new java.awt.Color(0, 153, 255));
        ButtonContratarSeguro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ButtonContratarSeguro.setForeground(new java.awt.Color(255, 255, 255));
        ButtonContratarSeguro.setText("Contratar ");
        ButtonContratarSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonContratarSeguroActionPerformed(evt);
            }
        });
        jPanelSolicitacaoAprovada.add(ButtonContratarSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 90, 30));

        textValorSeguro.setEditable(false);
        jScrollPane8.setViewportView(textValorSeguro);

        jPanelSolicitacaoAprovada.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 70, 30));

        buttonVoltar.setBackground(new java.awt.Color(126, 87, 194));
        buttonVoltar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        buttonVoltar.setForeground(new java.awt.Color(255, 255, 255));
        buttonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/back2.png"))); // NOI18N
        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });
        jPanelSolicitacaoAprovada.add(buttonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 100, 30));

        jPanel1.setBackground(new java.awt.Color(1, 45, 90));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("CEP:");
        jPanel1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        textCep.setEditable(false);
        jScrollPane10.setViewportView(textCep);

        jPanel1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 200, 30));

        jLabel48.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Cidade:");
        jPanel1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 20));

        textCidade.setEditable(false);
        jScrollPane3.setViewportView(textCidade);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 200, 30));

        textB.setEditable(false);
        textBairro.setViewportView(textB);

        jPanel1.add(textBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 200, 30));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Bairro:");
        jPanel1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, 20));

        textEnd.setEditable(false);
        jScrollPane6.setViewportView(textEnd);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 200, 40));

        jLabel50.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Endereço:");
        jPanel1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jPanelSolicitacaoAprovada.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 420, 210));

        jLabel51.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel51.setText("Dados da sua Residência:");
        jPanelSolicitacaoAprovada.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        painelP.add(jPanelSolicitacaoAprovada, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelPagamento.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPagamento.setMinimumSize(new java.awt.Dimension(730, 490));
        jPanelPagamento.setName(""); // NOI18N
        jPanelPagamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(1, 45, 90));
        jLabel41.setText("Informe seus Dados:");
        jPanelPagamento.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));
        jPanelPagamento.add(campoNumeroDoCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 250, 30));
        jPanelPagamento.add(campoImpressoNomeCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 250, 30));

        campoValorSeguroPagamento.setEditable(false);
        jPanelPagamento.add(campoValorSeguroPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 70, 30));
        jPanelPagamento.add(campoCodSegurancaCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 60, 30));

        jLabel42.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel42.setText("Número Cartão:");
        jPanelPagamento.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 120, -1));

        jLabel43.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel43.setText("Nome impresso no cartão:");
        jPanelPagamento.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 190, -1));

        jLabel44.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel44.setText("Código de Segurança:");
        jPanelPagamento.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 170, -1));

        jLabel45.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel45.setText("Validade:");
        jPanelPagamento.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 70, -1));

        mesComboBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez" }));
        jPanelPagamento.add(mesComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 60, -1));

        anoComboBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        anoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", " " }));
        jPanelPagamento.add(anoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        jLabel46.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel46.setText("Parcelar em:");
        jPanelPagamento.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 90, -1));

        quantidadeVezesParcela.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        quantidadeVezesParcela.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        quantidadeVezesParcela.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                quantidadeVezesParcelaItemStateChanged(evt);
            }
        });
        jPanelPagamento.add(quantidadeVezesParcela, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 40, 20));

        buttonConfirmar.setBackground(new java.awt.Color(0, 153, 255));
        buttonConfirmar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        buttonConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        buttonConfirmar.setText("Confirmar");
        buttonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarActionPerformed(evt);
            }
        });
        jPanelPagamento.add(buttonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, 30));

        buttonCancelar.setBackground(new java.awt.Color(126, 87, 194));
        buttonCancelar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        buttonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        jPanelPagamento.add(buttonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 90, 30));

        jLabel38.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel38.setText("Valor do Seguro:");
        jPanelPagamento.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        jLabel36.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel36.setText("de");
        jPanelPagamento.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, -1, -1));

        campoValorParcelado.setEditable(false);
        campoValorParcelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoValorParceladoActionPerformed(evt);
            }
        });
        jPanelPagamento.add(campoValorParcelado, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 70, 30));

        painelP.add(jPanelPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        painelServico.setBackground(new java.awt.Color(255, 255, 255));
        painelServico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelListaServicos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelListaServicos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabelaListaServicos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTabelaListaServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Serviço", "Data", "cep"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaListaServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaListaServicosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaListaServicos);
        if (jTabelaListaServicos.getColumnModel().getColumnCount() > 0) {
            jTabelaListaServicos.getColumnModel().getColumn(0).setResizable(false);
            jTabelaListaServicos.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanelListaServicos.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 210));

        jButton1.setBackground(new java.awt.Color(126, 87, 194));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar Solicitação");
        jPanelListaServicos.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        buttonFecharListaServicos.setBackground(new java.awt.Color(204, 0, 0));
        buttonFecharListaServicos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonFecharListaServicos.setForeground(new java.awt.Color(255, 255, 255));
        buttonFecharListaServicos.setText("Fechar");
        buttonFecharListaServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFecharListaServicosActionPerformed(evt);
            }
        });
        jPanelListaServicos.add(buttonFecharListaServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        painelServico.add(jPanelListaServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 460, 270));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 45, 90));
        jLabel4.setText("Qual serviço você deseja solicitar?");
        painelServico.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));
        painelServico.add(calendarServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        enviarServico.setBackground(new java.awt.Color(0, 153, 255));
        enviarServico.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        enviarServico.setForeground(new java.awt.Color(255, 255, 255));
        enviarServico.setText("Solicitar");
        enviarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarServicoActionPerformed(evt);
            }
        });
        painelServico.add(enviarServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 100, 30));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/house-key.png"))); // NOI18N
        painelServico.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 30, 30));

        chaveiro.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        chaveiro.setText("Chaveiro");
        painelServico.add(chaveiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 140, -1));

        cancelarServico.setBackground(new java.awt.Color(126, 87, 194));
        cancelarServico.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cancelarServico.setForeground(new java.awt.Color(255, 255, 255));
        cancelarServico.setText("Cancelar");
        cancelarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarServicoActionPerformed(evt);
            }
        });
        painelServico.add(cancelarServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 100, 30));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pipe.png"))); // NOI18N
        painelServico.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 30, -1));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/flash.png"))); // NOI18N
        painelServico.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));

        eletricista.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        eletricista.setText("Eletricista");
        eletricista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eletricistaActionPerformed(evt);
            }
        });
        painelServico.add(eletricista, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 140, -1));

        listaTurnosServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhã", "Tarde" }));
        painelServico.add(listaTurnosServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        jLabel39.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel39.setText("Turno:");
        painelServico.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        buttonDataServico.setText("Data");
        buttonDataServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataServicoActionPerformed(evt);
            }
        });
        painelServico.add(buttonDataServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        visualizarSolicitacaoServico.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        visualizarSolicitacaoServico.setForeground(new java.awt.Color(68, 122, 221));
        visualizarSolicitacaoServico.setText("Visualizar Solicitações");
        visualizarSolicitacaoServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visualizarSolicitacaoServicoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                visualizarSolicitacaoServicoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                visualizarSolicitacaoServicoMouseExited(evt);
            }
        });
        painelServico.add(visualizarSolicitacaoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, -1));

        encanador.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        encanador.setText("Encanador");
        painelServico.add(encanador, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 140, -1));

        painelP.add(painelServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        painelSolicitacao.setBackground(new java.awt.Color(255, 255, 255));
        painelSolicitacao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cepActionPerformed(evt);
            }
        });
        painelSolicitacao.add(cep, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 77, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("CEP:");
        painelSolicitacao.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("UF:");
        painelSolicitacao.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        uf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ufActionPerformed(evt);
            }
        });
        painelSolicitacao.add(uf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 77, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Cidade:");
        painelSolicitacao.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeActionPerformed(evt);
            }
        });
        painelSolicitacao.add(cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 86, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Bairro:");
        painelSolicitacao.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bairroActionPerformed(evt);
            }
        });
        painelSolicitacao.add(bairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 97, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Rua:");
        painelSolicitacao.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        rua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruaActionPerformed(evt);
            }
        });
        painelSolicitacao.add(rua, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 110, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Número:");
        painelSolicitacao.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroActionPerformed(evt);
            }
        });
        painelSolicitacao.add(numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 41, -1));

        jPanel6.setBackground(new java.awt.Color(1, 45, 90));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Bem:");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, -1, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Descrição:");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Valor:");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));
        jPanel6.add(descBem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, -1));
        jPanel6.add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 60, -1));

        add.setBackground(new java.awt.Color(151, 53, 255));
        add.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Adicionar");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel6.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 90, 20));

        painelSolicitacao.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 310, 70));

        jPanel5.setBackground(new java.awt.Color(1, 45, 90));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(comodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 61, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cômodos:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel5.add(banheiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 61, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Banheiro:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));
        jPanel5.add(garagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 61, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Garagem:");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));
        jPanel5.add(andares, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 61, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Andares:");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Quantidade:");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        painelSolicitacao.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 310, 70));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Descrição:");
        painelSolicitacao.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));
        painelSolicitacao.add(descRes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 289, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Ano Construção:");
        painelSolicitacao.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1, -1));

        anoC.setMinimumSize(new java.awt.Dimension(4, 4));
        anoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anoCActionPerformed(evt);
            }
        });
        painelSolicitacao.add(anoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 81, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Área Total:");
        painelSolicitacao.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));

        areat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areatActionPerformed(evt);
            }
        });
        painelSolicitacao.add(areat, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 61, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setText("Localização Perigosa:");
        painelSolicitacao.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        localizacaoP.setMaximum(10);
        localizacaoP.setValue(5);
        localizacaoP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        localizacaoP.setName(""); // NOI18N
        localizacaoP.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                localizacaoPStateChanged(evt);
            }
        });
        localizacaoP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                localizacaoPMouseDragged(evt);
            }
        });
        painelSolicitacao.add(localizacaoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 108, 14));

        l.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        l.setText("5");
        painelSolicitacao.add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setText("Terreno Perigoso:");
        painelSolicitacao.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

        terrenoP.setMaximum(10);
        terrenoP.setSnapToTicks(true);
        terrenoP.setValue(5);
        terrenoP.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                terrenoPStateChanged(evt);
            }
        });
        painelSolicitacao.add(terrenoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 129, 14));

        t.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        t.setText("5");
        painelSolicitacao.add(t, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, -1, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setText("Estrutura Ameaçada:");
        painelSolicitacao.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 120, -1));

        estruturaA.setMaximum(10);
        estruturaA.setValue(5);
        estruturaA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        estruturaA.setName(""); // NOI18N
        estruturaA.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                estruturaAStateChanged(evt);
            }
        });
        painelSolicitacao.add(estruturaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 108, 14));

        e.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        e.setText("5");
        painelSolicitacao.add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, -1, -1));

        cancelar.setBackground(new java.awt.Color(126, 87, 194));
        cancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 255, 255));
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        painelSolicitacao.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 90, -1));

        confirmarEdicao.setBackground(new java.awt.Color(0, 153, 255));
        confirmarEdicao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        confirmarEdicao.setForeground(new java.awt.Color(255, 255, 255));
        confirmarEdicao.setText("Confirmar");
        confirmarEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarEdicaoActionPerformed(evt);
            }
        });
        painelSolicitacao.add(confirmarEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 90, -1));

        enviar.setBackground(new java.awt.Color(0, 153, 255));
        enviar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        enviar.setForeground(new java.awt.Color(255, 255, 255));
        enviar.setText("Enviar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
        painelSolicitacao.add(enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 90, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Lista de Bens de sua Residência:");
        painelSolicitacao.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, 10));

        areaConstruida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaConstruidaActionPerformed(evt);
            }
        });
        painelSolicitacao.add(areaConstruida, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 80, -1));
        painelSolicitacao.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 20, 820, 70));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setText("Área Construida:");
        painelSolicitacao.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Endereço:");
        painelSolicitacao.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));
        painelSolicitacao.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 840, 30));

        remover.setBackground(new java.awt.Color(126, 87, 194));
        remover.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        remover.setForeground(new java.awt.Color(255, 255, 255));
        remover.setText("Remover");
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });
        painelSolicitacao.add(remover, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 90, -1));

        editarBem.setBackground(new java.awt.Color(0, 153, 255));
        editarBem.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        editarBem.setForeground(new java.awt.Color(255, 255, 255));
        editarBem.setText("Editar");
        editarBem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBemActionPerformed(evt);
            }
        });
        painelSolicitacao.add(editarBem, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 90, -1));

        tabelaBens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Descrição", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaBens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaBensMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tabelaBens);

        painelSolicitacao.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 290, 100));

        jLabel61.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel61.setText("Dados:");
        painelSolicitacao.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 10));

        painelP.add(painelSolicitacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 380));

        jPanelSolicitacaoReprovada.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSolicitacaoReprovada.setMinimumSize(new java.awt.Dimension(730, 490));
        jPanelSolicitacaoReprovada.setPreferredSize(new java.awt.Dimension(730, 490));
        jPanelSolicitacaoReprovada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel40.setText("Motivo da Reprovação:");
        jPanelSolicitacaoReprovada.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, -1));

        textMotivo.setEditable(false);
        jScrollPane9.setViewportView(textMotivo);

        jPanelSolicitacaoReprovada.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 260, 140));

        jPanel2.setBackground(new java.awt.Color(1, 45, 90));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Cidade:");
        jPanel2.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 20));

        jLabel54.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Bairro:");
        jPanel2.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, 20));

        jLabel55.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Endereço:");
        jPanel2.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        textCep1.setEditable(false);
        jScrollPane16.setViewportView(textCep1);

        jPanel2.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 200, 30));

        jLabel37.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("CEP:");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        textB1.setEditable(false);
        jScrollPane13.setViewportView(textB1);

        jPanel2.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 200, 30));

        textCidade1.setEditable(false);
        jScrollPane14.setViewportView(textCidade1);

        jPanel2.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 200, 30));

        textEnd1.setEditable(false);
        jScrollPane15.setViewportView(textEnd1);

        jPanel2.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 200, 40));

        jPanelSolicitacaoReprovada.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 420, 210));

        jLabel52.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel52.setText("Dados da sua Residência:");
        jPanelSolicitacaoReprovada.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        buttonVoltar3.setBackground(new java.awt.Color(153, 51, 255));
        buttonVoltar3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonVoltar3.setForeground(new java.awt.Color(255, 255, 255));
        buttonVoltar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/back2.png"))); // NOI18N
        buttonVoltar3.setText("Voltar");
        buttonVoltar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltar3ActionPerformed(evt);
            }
        });
        jPanelSolicitacaoReprovada.add(buttonVoltar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 30));

        painelP.add(jPanelSolicitacaoReprovada, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        jPanelListaApoliceServico.setBackground(new java.awt.Color(255, 255, 255));
        jPanelListaApoliceServico.setMinimumSize(new java.awt.Dimension(700, 440));
        jPanelListaApoliceServico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(1, 45, 90));
        jLabel35.setText("Selecione a Apólice Desejada:");
        jPanelListaApoliceServico.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        jListaDeApolices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Apólices Regentes:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jListaDeApolices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListaDeApolicesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jListaDeApolices);

        jPanelListaApoliceServico.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, 120));

        painelP.add(jPanelListaApoliceServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        PanelSolicitarSeguro.setBackground(new java.awt.Color(255, 255, 255));
        PanelSolicitarSeguro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelComListaSolicitacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelComListaSolicitacoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaMinhasSolicitacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Descrição", "Data", "CEP", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane17.setViewportView(listaMinhasSolicitacoes);

        panelComListaSolicitacoes.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 170));

        buttonFecharMinhasSolicitacoes.setBackground(new java.awt.Color(204, 0, 0));
        buttonFecharMinhasSolicitacoes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonFecharMinhasSolicitacoes.setForeground(new java.awt.Color(255, 255, 255));
        buttonFecharMinhasSolicitacoes.setText("Fechar");
        buttonFecharMinhasSolicitacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFecharMinhasSolicitacoesActionPerformed(evt);
            }
        });
        panelComListaSolicitacoes.add(buttonFecharMinhasSolicitacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        PanelSolicitarSeguro.add(panelComListaSolicitacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 510, 230));

        editar.setBackground(new java.awt.Color(0, 153, 255));
        editar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        editar.setForeground(new java.awt.Color(255, 255, 255));
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/plus-circular-button.png"))); // NOI18N
        editar.setText("    Editar Solicitação");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        PanelSolicitarSeguro.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 220, 40));

        cancelarSolicitacao.setBackground(new java.awt.Color(0, 153, 255));
        cancelarSolicitacao.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cancelarSolicitacao.setForeground(new java.awt.Color(255, 255, 255));
        cancelarSolicitacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/close.png"))); // NOI18N
        cancelarSolicitacao.setText("Cancelar Solicitação");
        cancelarSolicitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarSolicitacaoActionPerformed(evt);
            }
        });
        PanelSolicitarSeguro.add(cancelarSolicitacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 220, 40));

        nova.setBackground(new java.awt.Color(0, 153, 255));
        nova.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        nova.setForeground(new java.awt.Color(255, 255, 255));
        nova.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit-interface-symbol-of-a-pencil-on-a-square-outline-paper.png"))); // NOI18N
        nova.setText("   Nova Solicitação");
        nova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaActionPerformed(evt);
            }
        });
        PanelSolicitarSeguro.add(nova, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 220, 40));

        jLabel60.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(1, 45, 90));
        jLabel60.setText("Selecione a opção Desejada:");
        PanelSolicitarSeguro.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        minhasSolicitacoes.setBackground(new java.awt.Color(0, 153, 255));
        minhasSolicitacoes.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        minhasSolicitacoes.setForeground(new java.awt.Color(255, 255, 255));
        minhasSolicitacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/text-documents.png"))); // NOI18N
        minhasSolicitacoes.setText("Minhas Solicitações");
        minhasSolicitacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minhasSolicitacoesActionPerformed(evt);
            }
        });
        PanelSolicitarSeguro.add(minhasSolicitacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 220, 40));

        painelP.add(PanelSolicitarSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 490));

        editarSelecionado.setBackground(new java.awt.Color(153, 51, 255));
        editarSelecionado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        editarSelecionado.setForeground(new java.awt.Color(255, 255, 255));
        editarSelecionado.setText("Editar");
        editarSelecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarSelecionadoActionPerformed(evt);
            }
        });
        painelP.add(editarSelecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, -1, 30));

        excluirSelecionado.setBackground(new java.awt.Color(153, 51, 255));
        excluirSelecionado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        excluirSelecionado.setForeground(new java.awt.Color(255, 255, 255));
        excluirSelecionado.setText("Excluir");
        excluirSelecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirSelecionadoActionPerformed(evt);
            }
        });
        painelP.add(excluirSelecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, -1, 30));

        getContentPane().add(painelP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 730, -1));

        buttonHome.setBackground(new java.awt.Color(255, 255, 255));
        buttonHome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonHome.setForeground(new java.awt.Color(110, 48, 110));
        buttonHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/home.png"))); // NOI18N
        buttonHome.setText("Home");
        buttonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHomeActionPerformed(evt);
            }
        });
        getContentPane().add(buttonHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 180, 40));

        relatarSinistro.setBackground(new java.awt.Color(255, 255, 255));
        relatarSinistro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        relatarSinistro.setForeground(new java.awt.Color(110, 48, 110));
        relatarSinistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/danger.png"))); // NOI18N
        relatarSinistro.setText("Relatar Sinistro");
        relatarSinistro.setToolTipText("");
        relatarSinistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatarSinistroActionPerformed(evt);
            }
        });
        getContentPane().add(relatarSinistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 180, 40));

        contratarServico.setBackground(new java.awt.Color(255, 255, 255));
        contratarServico.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        contratarServico.setForeground(new java.awt.Color(110, 48, 110));
        contratarServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tools.png"))); // NOI18N
        contratarServico.setText("Solicitar Serviços");
        contratarServico.setToolTipText("");
        contratarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contratarServicoActionPerformed(evt);
            }
        });
        getContentPane().add(contratarServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 180, 40));

        solicitarSeguro.setBackground(new java.awt.Color(255, 255, 255));
        solicitarSeguro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        solicitarSeguro.setForeground(new java.awt.Color(110, 48, 110));
        solicitarSeguro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/contract.png"))); // NOI18N
        solicitarSeguro.setText("Solicitação Seguro ");
        solicitarSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitarSeguroActionPerformed(evt);
            }
        });
        getContentPane().add(solicitarSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 180, 40));
        solicitarSeguro.getAccessibleContext().setAccessibleDescription("");

        buttonContratarSeguro.setBackground(new java.awt.Color(255, 255, 255));
        buttonContratarSeguro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonContratarSeguro.setForeground(new java.awt.Color(110, 48, 110));
        buttonContratarSeguro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/handshake (1).png"))); // NOI18N
        buttonContratarSeguro.setText("Contratar Seguro");
        buttonContratarSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonContratarSeguroActionPerformed(evt);
            }
        });
        getContentPane().add(buttonContratarSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 180, 40));

        sairButton.setBackground(new java.awt.Color(255, 255, 255));
        sairButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        sairButton.setForeground(new java.awt.Color(153, 0, 0));
        sairButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit.png"))); // NOI18N
        sairButton.setText("Sair");
        sairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sairButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 110, 30));

        buttonContato.setBackground(new java.awt.Color(255, 255, 255));
        buttonContato.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonContato.setForeground(new java.awt.Color(110, 48, 110));
        buttonContato.setText("Contato");
        buttonContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonContatoActionPerformed(evt);
            }
        });
        getContentPane().add(buttonContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 180, 40));
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo-roxoMenu.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 250, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed
        dispose();

    }//GEN-LAST:event_sairButtonActionPerformed

    private void solicitarSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitarSeguroActionPerformed
        /*Tela_ListaSolicitacoes telaSolicitacoes = new Tela_ListaSolicitacoes();
        telaSolicitacoes.setVisible(true);
        dispose();
        this.controlador = new RepositorioSolicitacao();
        editar.setVisible(true);
        nova.setVisible(true);
        cancelarSolicitacao.setVisible(true);
        jPanelHome.setVisible(false);
         */
        visualizarOpcoesSolicitacao();
    }//GEN-LAST:event_solicitarSeguroActionPerformed

    private void relatarSinistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatarSinistroActionPerformed
        readTableApolices(segurado);
        visualizarListaDeApolices("Relatar Sinistro");
        //painelResidencias.setVisible(true);

        //try{
        //    controlador.verificarSeguro(candidato.getCodPessoa());
        //}catch(Exception e){
        //    JOptionPane.showMessageDialog(painelP, "Você não possui residências seguradas!");
        //}

    }//GEN-LAST:event_relatarSinistroActionPerformed

    private void contratarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contratarServicoActionPerformed
        visualizarListaDeApolices("Contratar Serviço");
    }//GEN-LAST:event_contratarServicoActionPerformed

    private void novaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaActionPerformed
        
        confirmarEdicao.setVisible(false);
        enviar.setVisible(true);
        confirmarEdicao.setVisible(true);
        painelSolicitacao.setVisible(true);
        cancelarSolicitacao.setVisible(false);
        editar.setVisible(false);
        nova.setVisible(false);
        minhasSolicitacoes.setVisible(false);
        
    }//GEN-LAST:event_novaActionPerformed

    private void cancelarSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarSolicitacaoActionPerformed
        // TODO add your handling code here:
        if (quantidadeDeSolicitacao > 0) {
            visualizarSolicitacao();
            
        } else {
            JOptionPane.showConfirmDialog(rootPane, "Você não possui solicitações.", "Alerta", JOptionPane.CLOSED_OPTION);
        }
        /* excluirSelecionado.setVisible(true);
        cancelarSolicitacao.setVisible(false);
        editar.setVisible(false);
        nova.setVisible(false);*/
    }//GEN-LAST:event_cancelarSolicitacaoActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        //recuperar dados da solicitação que ele deseja editar
        //gerenciador.listaSolicitacaoCliente(candidato);
        if (quantidadeDeSolicitacao > 0) {
            visualizarSolicitacao();
            
        } else {
            JOptionPane.showConfirmDialog(rootPane, "Você não possui solicitações.", "Alerta", JOptionPane.CLOSED_OPTION);
        }
        /*
        editarSelecionado.setVisible(true);
        cancelarSolicitacao.setVisible(true);
        editar.setVisible(true);
        nova.setVisible(true);
        minhasSolicitacoes.setVisible(true); */
    }//GEN-LAST:event_editarActionPerformed

    private void areaConstruidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaConstruidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaConstruidaActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        try {
            ExceptionEmptySpace.informaDado(cep.getText()); //parse long
            ExceptionEmptySpace.informaDado(uf.getText());
            ExceptionEmptySpace.informaDado(cidade.getText());
            ExceptionEmptySpace.informaDado(bairro.getText());
            ExceptionEmptySpace.informaDado(rua.getText());
            ExceptionEmptySpace.informaDado(numero.getText());//parse int
            ExceptionEmptySpace.informaDado(comodos.getText());//parse int
            ExceptionEmptySpace.informaDado(banheiro.getText());///parse int
            ExceptionEmptySpace.informaDado(garagem.getText());//parse int
            ExceptionEmptySpace.informaDado(andares.getText());///parse int
            ExceptionEmptySpace.informaDado(areat.getText());//parse int
            ExceptionEmptySpace.informaDado(anoC.getText());///parse int
            ExceptionEmptySpace.informaDado(descRes.getText());
            ExceptionEmptySpace.informaDado(areaConstruida.getText());
            
            int numeroCandidato = Integer.parseInt(numero.getText());
            long cepCandidato = Long.parseLong(cep.getText());
            
            int comodosCandidato = Integer.parseInt(comodos.getText());
            int banheiroCandidato = Integer.parseInt(banheiro.getText());
            int garagemCandidato = Integer.parseInt(garagem.getText());
            int andaresCandidato = Integer.parseInt(andares.getText());
            float areaT = Float.parseFloat(areat.getText());
            double areaC = Float.parseFloat(areaConstruida.getText());
            
            int anoConstrucao = Integer.parseInt(anoC.getText());
            
            int localizacao = localizacaoP.getValue();
            int terreno = terrenoP.getValue();
            int estrutura = estruturaA.getValue();
            
            controlador.registrarSolicitacao(uf.getText(), cidade.getText(), bairro.getText(), descRes.getText(),
                    numeroCandidato, cepCandidato, comodosCandidato, banheiroCandidato, garagemCandidato, areaT, areaC, andaresCandidato,
                    anoConstrucao, rua.getText(), localizacao, terreno, estrutura, candidato.getCodPessoa());
            
            JOptionPane.showMessageDialog(painelP, "\n Sua solicitação foi enviada para avaliação!");
            //JOptionPane.showMessageDialog(painelP, "/n" + controlador.getSolicitacao().toString());//ler do banco 
            painelSolicitacao.setVisible(false);
            cancelarSolicitacao.setVisible(true);
            editar.setVisible(true);
            nova.setVisible(true);
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(painelP, "Por favor insira todas as informações");
        }
        

    }//GEN-LAST:event_enviarActionPerformed
    public void esvaziarCampos() {
        
    }
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.esvaziarCampos();
        painelSolicitacao.setVisible(false);
        minhasSolicitacoes.setVisible(true);
        cancelarSolicitacao.setVisible(true);
        editar.setVisible(true);
        nova.setVisible(true);
    }//GEN-LAST:event_cancelarActionPerformed

    private void estruturaAStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_estruturaAStateChanged
        e.setText(Integer.toString(estruturaA.getValue()));
    }//GEN-LAST:event_estruturaAStateChanged

    private void terrenoPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_terrenoPStateChanged
        t.setText(Integer.toString(terrenoP.getValue()));
    }//GEN-LAST:event_terrenoPStateChanged

    private void localizacaoPMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_localizacaoPMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_localizacaoPMouseDragged

    private void localizacaoPStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_localizacaoPStateChanged
        l.setText(Integer.toString(localizacaoP.getValue()));
    }//GEN-LAST:event_localizacaoPStateChanged

    private void areatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areatActionPerformed

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        try {
            String removido = null;
            int select = tabelaBens.getSelectedRow();
            Bem temp = null;
            for (int i = 0; i < controlador.getBens().size(); i++) {
                if (controlador.getBens().get(i).getDescricaoBem().equalsIgnoreCase(removido)) {
                    temp = controlador.getBens().get(i);
                    break;
                }
            }
            if (controlador.getBens().remove(temp)) {
                JOptionPane.showMessageDialog(null, "Bem: \r\n" + removido + " Removido!");
                
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Este bem não foi adicionado!");
        } catch (IndexOutOfBoundsException et) {
            JOptionPane.showMessageDialog(null, "Nenhum bem foi encontrado!");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_removerActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try {
            ExceptionEmptySpace.informaDado(descBem.getText());
            ExceptionEmptySpace.informaDado(valor.getText());
            if (controlador.registraBemLista(Float.parseFloat(valor.getText()), descBem.getText())) {
                descBem.setText("");
                valor.setText("");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed
    private void gerarBackground() {
        String pasta = System.getProperty("user.dir");
        bg.setIcon(new ImageIcon(pasta + "/src/imagens/barraSup.jpg"));
        
    }
    private void numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroActionPerformed

    private void ruaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ruaActionPerformed

    private void bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bairroActionPerformed

    private void cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidadeActionPerformed

    private void ufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ufActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ufActionPerformed

    private void cepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cepActionPerformed

    private void buttonContratarSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonContratarSeguroActionPerformed
        if (quantidadeDeSolicitacao > 0) {
            visualizarSolicitacao();
        } else {
            JOptionPane.showConfirmDialog(rootPane, "Você não possui solicitações.", "Alerta", JOptionPane.CLOSED_OPTION);
        }

    }//GEN-LAST:event_buttonContratarSeguroActionPerformed

    private void anoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anoCActionPerformed

    }//GEN-LAST:event_anoCActionPerformed

    private void eletricistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eletricistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eletricistaActionPerformed

    private void cancelarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarServicoActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja cancelar?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
            painelServico.setVisible(false);
        }
    }//GEN-LAST:event_cancelarServicoActionPerformed

    private void listaSolicitacaoCandidatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaSolicitacaoCandidatoMouseClicked
        selecionado = listaSolicitacaoCandidato.getSelectedRow();
        if (!editarSelecionado.isVisible() && !excluirSelecionado.isVisible()) {
            if (listaSolicitacao.get(selecionado).getAprovadaSolicitacao().equalsIgnoreCase("aprovada")) {
                solicitacaoAprovada();
                preencherCamposResultado(selecionado);
            } else {
                solicitacaoRecusada();
                preencherCamposReprovado(selecionado);
            }
        } else {
            preencherCamposEdicao(listaSolicitacao.get(selecionado).getResidencia());
            controlador.setResidencia(listaSolicitacao.get(selecionado).getResidencia());
        }

    }//GEN-LAST:event_listaSolicitacaoCandidatoMouseClicked

    private void buttonRecusarSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecusarSeguroActionPerformed
        //Painel_Candidato painel = new Painel_Candidato();
        //painel.setVisible(true);
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja recusar o seguro?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
            visualizarSolicitacao();
            //chamar o metodo para excluir do banco de dados essa soclitação

        }
    }//GEN-LAST:event_buttonRecusarSeguroActionPerformed

    private void ButtonContratarSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonContratarSeguroActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja contratar o seguro?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
            pagamento();
            
        }

    }//GEN-LAST:event_ButtonContratarSeguroActionPerformed

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
        visualizarSolicitacao();
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void editarSelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarSelecionadoActionPerformed
        enviar.setVisible(false);
        confirmarEdicao.setVisible(true);
        cancelarSolicitacao.setVisible(false);
        nova.setVisible(false);
        jPanelListaSeguros.setVisible(false);
        painelSolicitacao.setVisible(true);
        editarSelecionado.setVisible(false);
        excluirSelecionado.setVisible(false);
    }//GEN-LAST:event_editarSelecionadoActionPerformed

    private void buttonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja confirmar?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
            String nomeImpressoCartao = campoImpressoNomeCartao.getText();
            String numeroCartao = campoNumeroDoCartao.getText();
            String validadeCartao = mesComboBox.getSelectedItem().toString() + "/" + anoComboBox.getSelectedItem().toString();
            long codSeguranca = Long.parseLong(campoCodSegurancaCartao.getText());
            //float premioApolice = Float.parseFloat(campoValorSeguroPagamento.getText());
            float premioApolice = 200;
            String bandeiraCartao = null;
            long numeroApolice = 2536;
            Date dataContratacaoApolice = new Date();
            gerenciador.registrarApolice(bandeiraCartao, numeroApolice,
                    premioApolice, dataContratacaoApolice, numeroCartao,
                    validadeCartao, codSeguranca, nomeImpressoCartao, listaSolicitacao.get(selecionado).getCodSolicitacao());
            JOptionPane.showConfirmDialog(rootPane, "Apólice gerada com sucesso", "Alerta", JOptionPane.CLOSED_OPTION);
            gerenciador.transformaCandidatoEmSegurado(candidato.getCpf());
            visualizarSolicitacao();
        }
        /*
        (String bandeiraCartão, long numeroApolice, 
        float premioApolice, Date dataContratacaoApolice, 
        String cartaoCreditoPagamento, String vencimentoCartao, 
        long codSegurancaCartao, String nomeNoCartao
         */
    }//GEN-LAST:event_buttonConfirmarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja cancelar?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
            solicitacaoAprovada();
        }
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void enviarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarServicoActionPerformed
        int dia = calendarServico.getDayChooser().getDay(), mes = calendarServico.getMonthChooser().getMonth() + 1, ano = calendarServico.getYearChooser().getYear();
        String dataString = "" + dia + "/" + mes + "/" + ano;
        Date dataVisitaResidencia = null;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dataVisitaResidencia = (Date) formatter.parse(dataString);
        } catch (ParseException ex) {
            Logger.getLogger(Painel_Candidato.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja solicitar?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
            String escolhido;
            Date data = new Date();
            int qnt = 0;
            //escolhido = String.valueOf(comboServico.getSelectedItem());

            //qnt = escolhido.split(",").length;
            //controlador.registrarServico(escolhido, qnt, data, dataVisitaResidencia);
            //JOptionPane.showInternalInputDialog(painelP, "Qual data que você deseja ser atendido?");
            // controlador.registrarServico(escolhido, qnt, data, dataVisitaResidencia);
            // JOptionPane.showMessageDialog(rootPane, "\n Sua solicitação de " + qnt + " serviço(s) foi enviada para avaliação!");
            //painelServico.setVisible(false);
        }
    }//GEN-LAST:event_enviarServicoActionPerformed

    private void buttonVoltar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonVoltar3ActionPerformed

    private void listaSolicitacaoCandidatoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaSolicitacaoCandidatoMouseMoved
        listaSolicitacaoCandidato.setBackground(new Color(126, 87, 194));
    }//GEN-LAST:event_listaSolicitacaoCandidatoMouseMoved

    private void listaSolicitacaoCandidatoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaSolicitacaoCandidatoMouseExited
        listaSolicitacaoCandidato.setBackground(new Color(204, 204, 255));
    }//GEN-LAST:event_listaSolicitacaoCandidatoMouseExited

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        home();
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void confirmarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarEdicaoActionPerformed
        try {
            ExceptionEmptySpace.informaDado(cep.getText()); //parse long
            ExceptionEmptySpace.informaDado(uf.getText());
            ExceptionEmptySpace.informaDado(cidade.getText());
            ExceptionEmptySpace.informaDado(bairro.getText());
            ExceptionEmptySpace.informaDado(rua.getText());
            ExceptionEmptySpace.informaDado(numero.getText());//parse int
            ExceptionEmptySpace.informaDado(comodos.getText());//parse int
            ExceptionEmptySpace.informaDado(banheiro.getText());///parse int
            ExceptionEmptySpace.informaDado(garagem.getText());//parse int
            ExceptionEmptySpace.informaDado(andares.getText());///parse int
            ExceptionEmptySpace.informaDado(areat.getText());//parse int
            ExceptionEmptySpace.informaDado(anoC.getText());///parse int
            ExceptionEmptySpace.informaDado(descRes.getText());
            ExceptionEmptySpace.informaDado(areaConstruida.getText());
            
            int numeroCandidato = Integer.parseInt(numero.getText());
            long cepCandidato = Long.parseLong(cep.getText());
            
            int comodosCandidato = Integer.parseInt(comodos.getText());
            int banheiroCandidato = Integer.parseInt(banheiro.getText());
            int garagemCandidato = Integer.parseInt(garagem.getText());
            int andaresCandidato = Integer.parseInt(andares.getText());
            float areaT = Float.parseFloat(areat.getText());
            double areaC = Float.parseFloat(areaConstruida.getText());
            
            int anoConstrucao = Integer.parseInt(anoC.getText());
            
            int localizacao = localizacaoP.getValue();
            int terreno = terrenoP.getValue();
            int estrutura = estruturaA.getValue();
            
            controlador.atualizarSolicitacaoResidenciaEditada(uf.getText(), cidade.getText(), bairro.getText(), descRes.getText(),
                    numeroCandidato, cepCandidato, comodosCandidato, banheiroCandidato, garagemCandidato, areaT, areaC, andaresCandidato,
                    anoConstrucao, rua.getText(), localizacao, terreno, estrutura);
            JOptionPane.showMessageDialog(painelP, "Sua solicitação foi editada com susesso!");
            cancelarSolicitacao.setVisible(true);
            editar.setVisible(true);
            nova.setVisible(true);
            painelSolicitacao.setVisible(false);
            
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(painelP, "Por favor insira todas as informações");
        }
        

    }//GEN-LAST:event_confirmarEdicaoActionPerformed

    private void excluirSelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirSelecionadoActionPerformed
        try {
            controlador.deletarResidencia();
            JOptionPane.showMessageDialog(painelP, "Sua residencia com descrição: " + controlador.deletarResidencia().getDescricaoRes() + " foi removida!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(painelP, "Não foi possível remover residência!");
        }
    }//GEN-LAST:event_excluirSelecionadoActionPerformed

    private void enviarSinistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarSinistroActionPerformed
        
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja relatar este sinistro?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
            float valorSinistro = controlador.valorSinistroEscolhido(String.valueOf(comboSinistro.getSelectedItem()));
            controlador.registrarSinistro(String.valueOf(comboSinistro.getSelectedItem()), valorSinistro, descricaoSinistro.getText(), selecionado);
            JOptionPane.showMessageDialog(painelP, "Seu relato foi enviado com Sucesso! \n Valor Estimado para este tipo de sinistro: " + valorSinistro);
            painelSinistro.setVisible(false);
        }
    }//GEN-LAST:event_enviarSinistroActionPerformed

    private void cancelarSinistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarSinistroActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja cancelar essa operação?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
            painelSinistro.setVisible(false);
        }
    }//GEN-LAST:event_cancelarSinistroActionPerformed

    private void buttonDataServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataServicoActionPerformed
        calendarServico.setVisible(true);
        if (visivel == 1) {
            calendarServico.setVisible(false);
            visivel = 0;
        } else {
            visivel++;
        }
    }//GEN-LAST:event_buttonDataServicoActionPerformed

    private void visualizarSolicitacaoServicoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visualizarSolicitacaoServicoMouseEntered
        
        visualizarSolicitacaoServico.setFont(new Font("Arial", Font.ITALIC, 14));
        visualizarSolicitacaoServico.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_visualizarSolicitacaoServicoMouseEntered

    private void visualizarSolicitacaoServicoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visualizarSolicitacaoServicoMouseExited
        visualizarSolicitacaoServico.setFont(new Font("Arial", Font.BOLD, 14));
    }//GEN-LAST:event_visualizarSolicitacaoServicoMouseExited

    private void buttonFecharListaServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFecharListaServicosActionPerformed
        jPanelListaServicos.setVisible(false);
    }//GEN-LAST:event_buttonFecharListaServicosActionPerformed

    private void campoValorParceladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoValorParceladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoValorParceladoActionPerformed

    private void quantidadeVezesParcelaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_quantidadeVezesParcelaItemStateChanged
        double valorTeste = Double.parseDouble(textValorSeguro.getText());
        int quantidadeVezes = Integer.parseInt(quantidadeVezesParcela.getSelectedItem().toString());
        double resultado = valorTeste / quantidadeVezes;
        campoValorParcelado.setText("" + resultado);
    }//GEN-LAST:event_quantidadeVezesParcelaItemStateChanged

    private void visualizarSolicitacaoServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visualizarSolicitacaoServicoMouseClicked
        jPanelListaServicos.setVisible(true);
    }//GEN-LAST:event_visualizarSolicitacaoServicoMouseClicked

    private void jTabelaListaServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaListaServicosMouseClicked
        selecionado = jTabelaListaServicos.getSelectedRow();

    }//GEN-LAST:event_jTabelaListaServicosMouseClicked

    private void jListaDeApolicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListaDeApolicesMouseClicked
        if (caminho.contains("Serviço")) {
            visualizarServico();
        } else if (caminho.contains("Sinistro")) {
            visualizarSinistro();
        }
    }//GEN-LAST:event_jListaDeApolicesMouseClicked

    private void confirmResidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmResidenciaActionPerformed
        painelResidencias.setVisible(false);
        painelSinistro.setVisible(true);
    }//GEN-LAST:event_confirmResidenciaActionPerformed

    private void cancelarResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarResActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja cancelar essa operação?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
            painelResidencias.setVisible(false);
        }
    }//GEN-LAST:event_cancelarResActionPerformed

    private void residenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_residenciasMouseClicked
        selecionado = residencias.getSelectedRow();
    }//GEN-LAST:event_residenciasMouseClicked

    private void comboSinistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSinistroActionPerformed
        

    }//GEN-LAST:event_comboSinistroActionPerformed

    private void buttonContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonContatoActionPerformed
        painelContato.setVisible(true);
    }//GEN-LAST:event_buttonContatoActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void enviarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarContatoActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja enviar esta mensagem?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
            controlador.mensagemCandidato(email.getText(), mensagem.getText());
            painelContato.setVisible(false);
        }
    }//GEN-LAST:event_enviarContatoActionPerformed

    private void cancelarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarContatoActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja cancelar essa operação?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
            painelContato.setVisible(false);
        }
    }//GEN-LAST:event_cancelarContatoActionPerformed

    private void buttonFecharMinhasSolicitacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFecharMinhasSolicitacoesActionPerformed
        panelComListaSolicitacoes.setVisible(false);
    }//GEN-LAST:event_buttonFecharMinhasSolicitacoesActionPerformed

    private void minhasSolicitacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minhasSolicitacoesActionPerformed
        if (readTableMinhasSolicitacoes(segurado) == 1) {
            panelComListaSolicitacoes.setVisible(true);
        } else {
            JOptionPane.showConfirmDialog(rootPane, "Você não possui solicitações", "Alerta", JOptionPane.CLOSED_OPTION);
        }
    }//GEN-LAST:event_minhasSolicitacoesActionPerformed

    private void editarBemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarBemActionPerformed

    private void tabelaBensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaBensMouseClicked
        

    }//GEN-LAST:event_tabelaBensMouseClicked
    
    private void ocultarTudo() {
        painelP.setVisible(true);
        jPanelHome.setVisible(false);
        painelServico.setVisible(false);
        painelSolicitacao.setVisible(false);
        jPanelSolicitacaoAprovada.setVisible(false);
        jPanelPagamento.setVisible(false);
        jPanelSolicitacaoReprovada.setVisible(false);
        jPanelListaSeguros.setVisible(false);
        painelResidencias.setVisible(false);
        editar.setVisible(false);
        editarSelecionado.setVisible(false);
        excluirSelecionado.setVisible(false);
        nova.setVisible(false);
        cancelarSolicitacao.setVisible(false);
        painelSinistro.setVisible(false);
        jPanelListaApoliceServico.setVisible(false);
        painelContato.setVisible(false);
        buttonVoltar.setVisible(false);
        jPanelListaServicos.setVisible(false);
        calendarServico.setVisible(false);
        minhasSolicitacoes.setVisible(false);
        panelComListaSolicitacoes.setVisible(false);
        
    }
    
    private void home() {
        ocultarTudo();
        jPanelHome.setVisible(true);
    }
    
    private void visualizarListaDeApolices(String solicitante) {
        ocultarTudo();
        jPanelListaApoliceServico.setVisible(true);
        caminho = solicitante;
    }
    
    public void visualizarOpcoesSolicitacao() {
        ocultarTudo();
        PanelSolicitarSeguro.setVisible(true);
        editar.setVisible(true);
        cancelarSolicitacao.setVisible(true);
        nova.setVisible(true);
        minhasSolicitacoes.setVisible(true);
        
    }
    
    private void visualizarSolicitacao() {
        ocultarTudo();
        jPanelListaSeguros.setVisible(true);
        
    }
    
    public void visualizarServico() {
        ocultarTudo();
        painelServico.setVisible(true);
    }
    
    private void visualizarSinistro() {
        ocultarTudo();
        painelSinistro.setVisible(true);
    }
    
    private void solicitacaoAprovada() {
        ocultarTudo();
        jPanelSolicitacaoAprovada.setVisible(true);
        buttonVoltar.setVisible(true);
    }
    
    private void pagamento() {
        ocultarTudo();
        jPanelPagamento.setVisible(true);
    }
    
    private void solicitacaoRecusada() {
        ocultarTudo();
        jPanelSolicitacaoReprovada.setVisible(true);
    }
    
    private void preencherCamposResultado(int selecionado) {
        DecimalFormat df = new DecimalFormat("0,000.00");
        //System.out.println(df.format(valorTeste));
        textCep.setText("" + listaSolicitacao.get(selecionado).getResidencia().getCepRes());
        textB.setText(listaSolicitacao.get(selecionado).getResidencia().getBairro());
        textCidade.setText(listaSolicitacao.get(selecionado).getResidencia().getCidade());
        textEnd.setText(listaSolicitacao.get(selecionado).getResidencia().getRuaRes());
        textValorSeguro.setText("" + df.format(gerenciador.calculaValorSolicitacao(listaSolicitacao.get(selecionado).getResidencia())));
        textObs.setText(listaSolicitacao.get(selecionado).getMotivoAlteracao());
        campoValorSeguroPagamento.setText(textValorSeguro.getText());
        textValorSeguro.setText("" + gerenciador.calculaValorSolicitacao(listaSolicitacao.get(selecionado).getResidencia()));
        campoValorParcelado.setText(textValorSeguro.getText());
    }
    
    public void preencherCamposReprovado(int selecionado) {
        textCep.setText("" + listaSolicitacao.get(selecionado).getResidencia().getCepRes());
        textB.setText(listaSolicitacao.get(selecionado).getResidencia().getBairro());
        textCidade.setText(listaSolicitacao.get(selecionado).getResidencia().getCidade());
        textEnd.setText(listaSolicitacao.get(selecionado).getResidencia().getRuaRes());
        textValorSeguro.setText("" + listaSolicitacao.get(selecionado).getValorSolicitacao());
        textMotivo.setText(listaSolicitacao.get(selecionado).getMotivoReprovacao());
    }
    
    public void preencherCamposEdicao(Residencia selecionado) {
        cep.setText("" + selecionado.getCepRes());
        uf.setText(selecionado.getUfResidencia());
        bairro.setText(selecionado.getBairro());
        cidade.setText(selecionado.getCidade());
        rua.setText(selecionado.getRuaRes());
        andares.setText(String.valueOf(selecionado.getNumAndares()));
        anoC.setText(String.valueOf(selecionado.getAnoConstrucao()));
        areaConstruida.setText(String.valueOf(selecionado.getAreaConstruida()));
        areat.setText(String.valueOf(selecionado.getAreaTotal()));
        banheiro.setText(String.valueOf(selecionado.getQntBanheiros()));
        comodos.setText(String.valueOf(selecionado.getQntComodos()));
        garagem.setText(String.valueOf(selecionado.getQntGaragens()));
        terrenoP.setValue(selecionado.getTerrenoPerigoso());
        numero.setText(String.valueOf(selecionado.getNumRes()));
        localizacaoP.setValue(selecionado.getLocalizacaoPerigosa());
        estruturaA.setValue(selecionado.getEstruturaAmeacada());
        
    }
    
    public void preencherComboBox() {
        for (int i = 0; i < controlador.lerSinistro().size(); i++) {
            comboSinistro.addItem(String.valueOf(controlador.lerSinistro().get(i).getTipoSinistro()));
        }
        for (int i = 0; i < controlador.lerServico().size(); i++) {
            // comboServico.addItem(String.valueOf(controlador.lerServico().get(i).getDesc()));
        }
        
    }
    
    private void habilitarOpcoesSegurado(boolean condicao) {
        relatarSinistro.setEnabled(condicao);
        contratarServico.setEnabled(condicao);
        buttonContratarSeguro.setEnabled(condicao);
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
            java.util.logging.Logger.getLogger(Painel_Candidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Painel_Candidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Painel_Candidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Painel_Candidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Painel_Candidato painel = new Painel_Candidato(segurado);
            painel.gerarBackground();
            painel.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonContratarSeguro;
    private javax.swing.JPanel PanelSolicitarSeguro;
    private javax.swing.JButton add;
    private javax.swing.JTextField andares;
    private javax.swing.JTextField anoC;
    private javax.swing.JComboBox<String> anoComboBox;
    private javax.swing.JTextField areaConstruida;
    private javax.swing.JTextField areat;
    private javax.swing.JTextField bairro;
    private javax.swing.JTextField banheiro;
    private javax.swing.JLabel bg;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonConfirmar;
    private javax.swing.JButton buttonContato;
    private javax.swing.JButton buttonContratarSeguro;
    private javax.swing.JToggleButton buttonDataServico;
    private javax.swing.JButton buttonFecharListaServicos;
    private javax.swing.JButton buttonFecharMinhasSolicitacoes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton buttonHome;
    private javax.swing.JButton buttonRecusarSeguro;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JButton buttonVoltar3;
    private com.toedter.calendar.JCalendar calendarServico;
    private javax.swing.JTextField campoCodSegurancaCartao;
    private javax.swing.JTextField campoImpressoNomeCartao;
    private javax.swing.JTextField campoNumeroDoCartao;
    private javax.swing.JTextField campoValorParcelado;
    private javax.swing.JTextField campoValorSeguroPagamento;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton cancelarContato;
    private javax.swing.JButton cancelarRes;
    private javax.swing.JButton cancelarServico;
    private javax.swing.JButton cancelarSinistro;
    private javax.swing.JButton cancelarSolicitacao;
    private javax.swing.JTextField cep;
    private javax.swing.JCheckBox chaveiro;
    private javax.swing.JTextField cidade;
    private javax.swing.JComboBox<String> comboSinistro;
    private javax.swing.JTextField comodos;
    private javax.swing.JButton confirmResidencia;
    private javax.swing.JButton confirmarEdicao;
    private javax.swing.JButton contratarServico;
    private javax.swing.JTextField descBem;
    private javax.swing.JTextField descRes;
    private javax.swing.JTextArea descricaoSinistro;
    private javax.swing.JLabel e;
    private javax.swing.JButton editar;
    private javax.swing.JButton editarBem;
    private javax.swing.JButton editarSelecionado;
    private javax.swing.JCheckBox eletricista;
    private javax.swing.JTextField email;
    private javax.swing.JCheckBox encanador;
    private javax.swing.JButton enviar;
    private javax.swing.JButton enviarContato;
    private javax.swing.JButton enviarServico;
    private javax.swing.JButton enviarSinistro;
    private javax.swing.JSlider estruturaA;
    private javax.swing.JButton excluirSelecionado;
    private javax.swing.JTextField garagem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTable jListaDeApolices;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelHome;
    private javax.swing.JPanel jPanelListaApoliceServico;
    private javax.swing.JPanel jPanelListaSeguros;
    private javax.swing.JPanel jPanelListaServicos;
    private javax.swing.JPanel jPanelPagamento;
    private javax.swing.JPanel jPanelSolicitacaoAprovada;
    private javax.swing.JPanel jPanelSolicitacaoReprovada;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTabelaListaServicos;
    private javax.swing.JLabel l;
    private javax.swing.JTable listaMinhasSolicitacoes;
    private javax.swing.JTable listaSolicitacaoCandidato;
    private javax.swing.JComboBox<String> listaTurnosServico;
    private javax.swing.JSlider localizacaoP;
    private javax.swing.JTextArea mensagem;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private javax.swing.JComboBox<String> mesComboBox;
    private javax.swing.JButton minhasSolicitacoes;
    private javax.swing.JButton nova;
    private javax.swing.JTextField numero;
    private javax.swing.JPanel painelContato;
    private javax.swing.JPanel painelP;
    private javax.swing.JPanel painelResidencias;
    private javax.swing.JPanel painelServico;
    private javax.swing.JPanel painelSinistro;
    private javax.swing.JPanel painelSolicitacao;
    private javax.swing.JPanel panelComListaSolicitacoes;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JComboBox<String> quantidadeVezesParcela;
    private javax.swing.JButton relatarSinistro;
    private javax.swing.JButton remover;
    private javax.swing.JTable residencias;
    private javax.swing.JTextField rua;
    private javax.swing.JButton sairButton;
    private javax.swing.JButton solicitarSeguro;
    private javax.swing.JLabel t;
    private javax.swing.JTable tabelaBens;
    private javax.swing.JSlider terrenoP;
    private javax.swing.JTextPane textB;
    private javax.swing.JTextPane textB1;
    private javax.swing.JScrollPane textBairro;
    private javax.swing.JTextPane textCep;
    private javax.swing.JTextPane textCep1;
    private javax.swing.JTextPane textCidade;
    private javax.swing.JTextPane textCidade1;
    private javax.swing.JTextPane textEnd;
    private javax.swing.JTextPane textEnd1;
    private javax.swing.JTextPane textMotivo;
    private javax.swing.JTextPane textObs;
    private javax.swing.JTextPane textValorSeguro;
    private javax.swing.JTextField uf;
    private javax.swing.JTextField valor;
    private javax.swing.JLabel visualizarSolicitacaoServico;
    // End of variables declaration//GEN-END:variables
}
