/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.KvmUsuario;
import bean.KvmUsuarioId;
import dao.Usuario_DAO;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author Marcos
 */
public class JDlgUsuarios extends javax.swing.JDialog {

    boolean incluindo;
    MaskFormatter mascaraCpf;
    MaskFormatter mascaraDataNascimento;

    /**
     * Creates new form JDlgUsuarios
     */
    public JDlgUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Cadastro de usuários");
        setLocationRelativeTo(null);
        desabilitar();
        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraDataNascimento = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtCpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));
        jFmtDataNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNascimento));
    }

    public void habilitar() {
        jTxtCodigo.setEnabled(true);
        jTxtNome.setEnabled(true);
        jTxtSobrenome.setEnabled(true);
        jFmtCpf.setEnabled(true);
        jFmtDataNascimento.setEnabled(true);
        jPwfSenha.setEnabled(true);
        jCboNivel.setEnabled(true);
        jChbAtivo.setEnabled(true);
        jBtnConfirmar.setEnabled(true);
        jBtnCancelar.setEnabled(true);

        jBtnIncluir.setEnabled(false);
        jBtnAlterar.setEnabled(false);
        jBtnExcluir.setEnabled(false);
        jBtnPesquisar.setEnabled(false);
    }

    public void desabilitar() {
        jTxtCodigo.setEnabled(false);
        jTxtNome.setEnabled(false);
        jTxtSobrenome.setEnabled(false);
        jFmtCpf.setEnabled(false);
        jFmtDataNascimento.setEnabled(false);
        jPwfSenha.setEnabled(false);
        jCboNivel.setEnabled(false);
        jChbAtivo.setEnabled(false);

        jBtnConfirmar.setEnabled(false);
        jBtnCancelar.setEnabled(false);

        jBtnIncluir.setEnabled(true);
        jBtnAlterar.setEnabled(true);
        jBtnExcluir.setEnabled(true);
        jBtnPesquisar.setEnabled(true);
    }

    public void limparCampos() {
        jTxtCodigo.setText("");
        jTxtNome.setText("");
        jTxtSobrenome.setText("");
        jFmtCpf.setText("");
        jFmtDataNascimento.setText("");
        jPwfSenha.setText("");
        jCboNivel.setSelectedIndex(-1);
        jChbAtivo.setSelected(false);
    }

    public KvmUsuario viewBean() {
        KvmUsuario kvmUsuario = new KvmUsuario();
        kvmUsuario.setKvmNome(jTxtNome.getText());
        kvmUsuario.setKvmSobrenome(jTxtSobrenome.getText());
        kvmUsuario.setKvmCpf(jFmtCpf.getText());        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            kvmUsuario.setKvmNascimento(formato.parse(jFmtDataNascimento.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(JDlgUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        kvmUsuario.setKvmSenha(jPwfSenha.getText());
        
        if (jChbAtivo.isSelected() == true) {
            kvmUsuario.setKvmAtivo("S");
        } else {
            kvmUsuario.setKvmAtivo("N");
        }
        return kvmUsuario;
    }   
    
    
    
    
    
    public KvmUsuarioId viewBean2() {
        KvmUsuarioId kvmUsuarioId = new KvmUsuarioId();
        kvmUsuarioId.setIdKvmUsuario(Util.strInt(jTxtCodigo.getText()));
        kvmUsuarioId.setKvmNivel(jCboNivel.getSelectedIndex());

        
        
        
        
        
       //Nao sei o motivo desse erro abaixo//  
    public void beanView(KvmUsuario kvmUsuario) {
        String cad = String.valueOf(kvmUsuario.getId());
        jTxtCodigo.setText(cad);        
        jTxtNome.setText(kvmUsuario.getKvmNome());
        jTxtSobrenome.setText(kvmUsuario.getKvmSobrenome());
        jFmtCpf.setText(kvmUsuario.getKvmCpf());
        jPwfSenha.setText(kvmUsuario.getKvmSenha());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        jFmtDataNascimento.setText( formato.format(kvmUsuario.getKvmNascimento() ));
        
       
        if (kvmUsuario.getKvmAtivo().equals("S") == true) {
            jChbAtivo.setSelected(true);
        } else {
            jChbAtivo.setSelected(false);
        }
    }
    
    public void beanView2(KvmUsuarioId kvmUsuarioId) {
        String cad = String.valueOf(kvmUsuarioId.getIdKvmUsuario());
         jCboNivel.setSelectedIndex(kvmUsuarioId.getKvmNivel());
        
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
        jTxtCodigo = new javax.swing.JTextField();
        jTxtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtSobrenome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFmtCpf = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jFmtDataNascimento = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jPwfSenha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jCboNivel = new javax.swing.JComboBox<>();
        jChbAtivo = new javax.swing.JCheckBox();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código");

        jLabel2.setText("Nome");

        jLabel3.setText("Sobrenome");

        jLabel4.setText("CPF");

        jLabel5.setText("Data de Nascimento");

        jLabel6.setText("Senha");

        jLabel7.setText("Nível");

        jCboNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adminstrador", "Convidado", "Financeiro" }));

        jChbAtivo.setText("Ativo");

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gravar.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtNome)
                    .addComponent(jTxtSobrenome)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPwfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jFmtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jCboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jChbAtivo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jFmtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnIncluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnConfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnPesquisar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jTxtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFmtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jFmtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPwfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChbAtivo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar)
                    .addComponent(jBtnAlterar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        habilitar();
        incluindo = false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
        KvmUsuario kvmUsuario = viewBean();
        Usuario_DAO usuarioDAO = new Usuario_DAO();
        if (incluindo == true) {
            usuarioDAO.insert(kvmUsuario);
        } else {
            usuarioDAO.update(kvmUsuario);
        }

        desabilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here: //
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        habilitar();
        limparCampos();
        incluindo = true;
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        desabilitar();
        limparCampos();
        JOptionPane.showMessageDialog(null, "operação cancelada.");
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
        
          if (Util.perguntar("Deseja excluir o registro") == true ){
       }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgUsuarios dialog = new JDlgUsuarios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<String> jCboNivel;
    private javax.swing.JCheckBox jChbAtivo;
    private javax.swing.JFormattedTextField jFmtCpf;
    private javax.swing.JFormattedTextField jFmtDataNascimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPwfSenha;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtSobrenome;
    // End of variables declaration//GEN-END:variables
}
