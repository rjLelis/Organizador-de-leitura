package com.gui;

import com.leitor_livro.ValidaLeitorLivro;
import com.leitor_livro.LeitorLivro;
import com.livros.Livros;
import com.livros.ValidaLivros;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lelis
 */
public class FormPrincipal extends javax.swing.JFrame {

    private final Livros livro = new Livros();
    private final ValidaLivros validadorDeLivros = new ValidaLivros();
    private final LeitorLivro leitorLivro = new LeitorLivro();
    private final ValidaLeitorLivro negocioLeitorLivro = new ValidaLeitorLivro();

    /**
     * Creates new form FormPrincipal
     */
    public FormPrincipal() {
        initComponents();
        txtId.setVisible(false);
        preencherLivros();
        URL url = this.getClass().getResource("/com/imagens/livro-icone.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
    }

    //<editor-fold defaultstate="collapsed" desc="Métodos do tela principal">
    
    //Método para preencher a tabela com os itens da lista de acordo com os usuario
    private void preencherStatus() {
        try {
            leitorLivro.setLeitor_codigo(Integer.parseInt(txtId.getText()));
            ArrayList<LeitorLivro> listaStatus = negocioLeitorLivro.listar(leitorLivro);
            DefaultTableModel modeloTabela = (DefaultTableModel) tblStatus.getModel();
            modeloTabela.setNumRows(0);
            listaStatus.forEach((listaStatu) -> {
                modeloTabela.addRow(new Object[]{listaStatu.getLivro_codigo(), listaStatu.getTitulo(), listaStatu.getEstado()});
            });
            tblStatus.setModel(modeloTabela);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    //Metodo para preencher a tabela com todos os livros do banco de dados
    private void preencherLivros() {
        try {
            ArrayList<Livros> listaLivros = validadorDeLivros.listar(livro);
            DefaultTableModel modeloTabela = (DefaultTableModel) tblLivros.getModel();
            modeloTabela.setNumRows(0);
            listaLivros.forEach((listaLivro) -> {
                modeloTabela.addRow(new Object[]{listaLivro.getCodigo(),
                    listaLivro.getTitulo(),
                    listaLivro.getAutor(),
                    listaLivro.getTema(),
                    listaLivro.getNumero_paginas()});
            });
            tblLivros.setModel(modeloTabela);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    //Pega o conteúdo selecionado da tabela de livros e adiciona na lista de leitura
    private void adicionarLista() {
        int linha = tblLivros.getSelectedRow();
        if (linha >= 0) {
            try {
                String[] estado = {"Lendo", "Lido", "Na Fila"};
                Object Estado = JOptionPane.showInputDialog(this, "Escolha um Status do livro", "Status", JOptionPane.INFORMATION_MESSAGE, null, estado, estado[0]);
                leitorLivro.setLeitor_codigo(Integer.parseInt(txtId.getText()));
                leitorLivro.setLivro_codigo((int) tblLivros.getModel().getValueAt(linha, 0));
                leitorLivro.setEstado((String) Estado);
                negocioLeitorLivro.cadastrar(leitorLivro);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Livro", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    //Altera o Status do livro na lista de leitura
    private void alterarStatus() {
        int linha = tblStatus.getSelectedRow();
        if (linha >= 0) {
            try {
                String[] estado = {"Lendo", "Lido", "Na Fila"};
                Object Estado = JOptionPane.showInputDialog(this, "Escolha um novo Status do livro", "Status", JOptionPane.INFORMATION_MESSAGE, null, estado, estado[0]);
                leitorLivro.setLivro_codigo((int) tblStatus.getModel().getValueAt(linha, 0));
                leitorLivro.setEstado((String) Estado);
                leitorLivro.setLeitor_codigo(Integer.parseInt(txtId.getText()));
                negocioLeitorLivro.atualizar(leitorLivro);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Livro", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Mostra o contador de livros
    private void contadorDeLivros() {
        try {
            leitorLivro.setLeitor_codigo(Integer.parseInt(txtId.getText()));
            ArrayList<LeitorLivro> listaStatus = negocioLeitorLivro.listar(leitorLivro);
            lblQuantidade.setText(Integer.toString(listaStatus.size()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    //Procura os livros pelo nome
    private void procurarLivros() {
        try {
            livro.setTitulo(txtProcurar.getText());
            ArrayList<Livros> listaLivros = validadorDeLivros.procurarlivros(livro);
            DefaultTableModel modeloTabela = (DefaultTableModel) tblLivros.getModel();
            modeloTabela.setNumRows(0);
            listaLivros.forEach((listaLivro) -> {
                modeloTabela.addRow(new Object[]{listaLivro.getCodigo(),
                    listaLivro.getTitulo(),
                    listaLivro.getAutor(),
                    listaLivro.getTema(),
                    listaLivro.getNumero_paginas()});
            });
            tblLivros.setModel(modeloTabela);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
//</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStatus = new javax.swing.JTable();
        lblQuantidade = new javax.swing.JLabel();
        lblContador = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        lblLeitor = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLivros = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnAlterarStatus = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        txtProcurar = new javax.swing.JTextField();
        btnProcurar = new javax.swing.JButton();
        lblFilaDeLivros = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuNovo = new javax.swing.JMenu();
        menuNovoLeitor = new javax.swing.JMenuItem();
        menuNovoLivro = new javax.swing.JMenuItem();
        menuSistema = new javax.swing.JMenu();
        menuSistemaSobre = new javax.swing.JMenuItem();
        menuSistemaSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Livros");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Titulo", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        tblStatus.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblStatus);

        lblQuantidade.setText("0");

        lblContador.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblContador.setText("Contagem de livros:");

        lblIdade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblIdade.setText("0");

        lblAno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAno.setText("Idade:");

        lblLeitor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLeitor.setText("Leitor:");

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNome.setText("nome");

        tblLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Titulo", "Autor", "Tema", "N° de Paginas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLivros.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblLivros);

        btnAdicionar.setText("Adicionar a lista");
        btnAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAlterarStatus.setText("Alterar Status");
        btnAlterarStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterarStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarStatusActionPerformed(evt);
            }
        });

        txtId.setEnabled(false);

        btnProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagens/Procurar.png"))); // NOI18N
        btnProcurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        lblFilaDeLivros.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblFilaDeLivros.setText("Fila de Livros");

        menuNovo.setText("Novo");
        menuNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuNovoLeitor.setText(" Leitor");
        menuNovoLeitor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuNovoLeitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoLeitorActionPerformed(evt);
            }
        });
        menuNovo.add(menuNovoLeitor);

        menuNovoLivro.setText(" Livro");
        menuNovoLivro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuNovoLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoLivroActionPerformed(evt);
            }
        });
        menuNovo.add(menuNovoLivro);

        menu.add(menuNovo);

        menuSistema.setText(" Sistema");
        menuSistema.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuSistemaSobre.setText("Sobre");
        menuSistemaSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSistemaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSistemaSobreActionPerformed(evt);
            }
        });
        menuSistema.add(menuSistemaSobre);

        menuSistemaSair.setText(" Sair");
        menuSistemaSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSistemaSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSistemaSairActionPerformed(evt);
            }
        });
        menuSistema.add(menuSistemaSair);

        menu.add(menuSistema);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLeitor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNome)
                                .addGap(65, 65, 65)
                                .addComponent(lblAno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIdade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterarStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(txtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(lblFilaDeLivros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblContador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblQuantidade)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLeitor)
                    .addComponent(lblNome)
                    .addComponent(lblAno)
                    .addComponent(lblIdade)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFilaDeLivros)
                    .addComponent(lblContador)
                    .addComponent(lblQuantidade))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProcurar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdicionar)
                        .addComponent(btnAlterarStatus)
                        .addComponent(txtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Botão de sair do sistema
    private void menuSistemaSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSistemaSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(this, "Deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(sair);
        }
    }//GEN-LAST:event_menuSistemaSairActionPerformed

    //Botão de informações do sistema
    private void menuSistemaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSistemaSobreActionPerformed
        JOptionPane.showMessageDialog(this, "SISTEMA PARA ORGANIZAR A LEITURA\nDesenvolvido por: Renato Lélis\n"
                + "Versão 1.1", "Sobre", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_menuSistemaSobreActionPerformed

    //Botão para abrir o form de cadastro de um leitor
    private void menuNovoLeitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoLeitorActionPerformed
        FormCadastroLeitor cadLeitor = new FormCadastroLeitor();
        cadLeitor.setVisible(true);
    }//GEN-LAST:event_menuNovoLeitorActionPerformed

    //Botão para abrir o form de cadastro de um livro
    private void menuNovoLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoLivroActionPerformed
        FormCadastroLivro cadLivro = new FormCadastroLivro();
        cadLivro.setVisible(true);
    }//GEN-LAST:event_menuNovoLivroActionPerformed

    //Pega o conteúdo selecionado da tabela de livros e adiciona na lista de leitura
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        boolean autorizado = true;
        try {
            leitorLivro.setLeitor_codigo(Integer.parseInt(txtId.getText()));
            ArrayList<LeitorLivro> listaLeitor = negocioLeitorLivro.listar(leitorLivro);
            ArrayList<Livros> listaLivros = validadorDeLivros.listar(livro);
            for (LeitorLivro l : listaLeitor) {
                for (Livros li : listaLivros) {
                    autorizado = l.getLivro_codigo() != li.getCodigo(); // verifica se o livro já está na lista de leitura
                }
            }
            if (autorizado) {
                adicionarLista();
                preencherStatus();
            } else {
                JOptionPane.showMessageDialog(this, "Este Livro já está na lista", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    //Preenche a lista de leitura e mostra o contador de livros assim que a tela pricipal é carregada
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        preencherStatus();
        contadorDeLivros();
    }//GEN-LAST:event_formWindowOpened

    //Altera o Status do livro na lista de leitura
    private void btnAlterarStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarStatusActionPerformed
        alterarStatus();
        preencherStatus();
    }//GEN-LAST:event_btnAlterarStatusActionPerformed

    //Procura os livros pelo nome
    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        procurarLivros();
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        preencherLivros();
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterarStatus;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblContador;
    private javax.swing.JLabel lblFilaDeLivros;
    public static javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblLeitor;
    public static javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuNovo;
    private javax.swing.JMenuItem menuNovoLeitor;
    private javax.swing.JMenuItem menuNovoLivro;
    private javax.swing.JMenu menuSistema;
    private javax.swing.JMenuItem menuSistemaSair;
    private javax.swing.JMenuItem menuSistemaSobre;
    private javax.swing.JTable tblLivros;
    public static javax.swing.JTable tblStatus;
    public static javax.swing.JTextField txtId;
    private javax.swing.JTextField txtProcurar;
    // End of variables declaration//GEN-END:variables
}
