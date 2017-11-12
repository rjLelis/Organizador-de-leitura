package com.gui;

import com.dados.Dados;
import com.leitor.Leitor;
import com.leitor.ValidaLeitor;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lelis
 */
public class FormLogin extends javax.swing.JFrame {

    private Connection conexao;
    private Leitor leitor = new Leitor();
    private ValidaLeitor validadorDeLeitor = new ValidaLeitor();

    /**
     * Creates new form FormLogin
     */
    public FormLogin() {
        initComponents();
        URL url = this.getClass().getResource("/com/imagens/livro-icone.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
    }

    //Método de entrar no sistema
    public void entrarSistema() {
        if (txtApelido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Atenção", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                FormPrincipal principal = new FormPrincipal();
                conexao = Dados.conectarComParametros();
                leitor.setApelido(txtApelido.getText());
                ArrayList<Leitor> listaLeitor = validadorDeLeitor.listar(leitor);
                if (listaLeitor.size() > 0) {
                    principal.setVisible(true);
                    this.dispose();
                    FormPrincipal.lblNome.setText(listaLeitor.get(0).getNome());
                    FormPrincipal.txtId.setText(Integer.toString(listaLeitor.get(0).getCodigo()));
                    if (listaLeitor.get(0).getData_nascimento() > 0) {
                        int idade = 2017 - listaLeitor.get(0).getData_nascimento();
                        FormPrincipal.lblIdade.setText(Integer.toString(idade));
                    }
                } else {
                    int resp = JOptionPane.showConfirmDialog(this, "Leitor não cadastrado!\nDeseja criar um ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (resp == JOptionPane.YES_OPTION) {
                        FormCadastroLeitor cadLeitor = new FormCadastroLeitor();
                        cadLeitor.setVisible(true);
                    }
                }
                Dados.desconectar();
            } catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException e){
                JOptionPane.showMessageDialog(this,"Servidor desconectado!", "Atenção", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(this, e);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            } 
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

        txtApelido = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();
        btnCriar = new javax.swing.JButton();
        lblDigiteSeuApelido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - Livros");

        btnEntrar.setText("Entrar");
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        btnCriar.setText("Criar Novo Leitor");
        btnCriar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });

        lblDigiteSeuApelido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDigiteSeuApelido.setText("   Digite seu apelido   ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntrar)
                    .addComponent(btnCriar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDigiteSeuApelido, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(lblDigiteSeuApelido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEntrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCriar)
                .addGap(38, 38, 38))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Botão de entrar no sistema
    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        entrarSistema();
    }//GEN-LAST:event_btnEntrarActionPerformed

    //Botão para chamar a tela de cadastro de um leitor
    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        FormCadastroLeitor cadLeitor = new FormCadastroLeitor();
        cadLeitor.setVisible(true);
    }//GEN-LAST:event_btnCriarActionPerformed

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
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel lblDigiteSeuApelido;
    private javax.swing.JTextField txtApelido;
    // End of variables declaration//GEN-END:variables
}
