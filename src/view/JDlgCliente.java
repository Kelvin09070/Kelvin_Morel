/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.KvmCliente;
import bean.KvmUsuario;
import bean.KvmUsuarioId;
import dao.Cliente_DAO;
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
public class JDlgCliente extends javax.swing.JDialog {

    boolean incluindo;
    MaskFormatter mascaraCpf;
    MaskFormatter mascaraDataNascimento;

    /**
     * Creates new form JDlgUsuarios
     */
    public JDlgCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Cadastro de Clientes");
        setLocationRelativeTo(null);
        desabilitar();
        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraDataNascimento = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtCpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));
        jFmtNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNascimento));
    }

    public void habilitar() {
        jTxtCodigo.setEnabled(true);
        jTxtNome.setEnabled(true);
        jTxtSobrenome.setEnabled(true);
        jTxtSexo.setEnabled(true);
        jTxtRg.setEnabled(true);
        jFmtCpf.setEnabled(true);
        jFmtNascimento.setEnabled(true);
        jTxtEmail.setEnabled(true);
        jTxtTelefone.setEnabled(true);
        jTxtCelular.setEnabled(true);
        jTxtCep.setEnabled(true);
        jTxtEndereco.setEnabled(true);
        jTxtBairro.setEnabled(true);
        jTxtCidade.setEnabled(true);
        jTxtEstCivil.setEnabled(true);
        
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
        jTxtSexo.setEnabled(false);
        jTxtRg.setEnabled(false);
        jFmtCpf.setEnabled(false);
        jFmtNascimento.setEnabled(false);
        jTxtEmail.setEnabled(false);
        jTxtTelefone.setEnabled(false);
        jTxtCelular.setEnabled(false);
        jTxtCep.setEnabled(false);
        jTxtEndereco.setEnabled(false);
        jTxtBairro.setEnabled(false);
        jTxtCidade.setEnabled(false);
        jTxtEstCivil.setEnabled(false);

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
        jFmtNascimento.setText("");
      
    }

    public KvmCliente viewBean() {
        KvmCliente kvmCliente = new KvmCliente();
        kvmCliente.setKvmNome(jTxtNome.getText());
        kvmCliente.setKvmSobrenome(jTxtSobrenome.getText());
        kvmCliente.setKvmSexo(jTxtSexo.getText());  
        kvmCliente.setKvmRg(jTxtRg.getText());  
        kvmCliente.setKvmCpf(jFmtCpf.getText());        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            kvmCliente.setKvmNascimentol(formato.parse(jFmtNascimento.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        kvmCliente.setKvmEmail(jTxtEmail.getText());        
        kvmCliente.setKvmTelefone(jTxtTelefone.getText());        
        kvmCliente.setKvmCelular(jTxtCelular.getText());        
        kvmCliente.setKvmCep(jTxtCep.getText());        
        kvmCliente.setKvmEndereco(jTxtEndereco.getText());        
        kvmCliente.setKvmBairro(jTxtBairro.getText());        
        kvmCliente.setKvmCidade(jTxtCidade.getText());        
        kvmCliente.setKvmEstadoCivil(jTxtEstCivil.getText());        
        return kvmCliente;
    }   
    
    
    
    
    
    public KvmUsuarioId viewBean2() {
        KvmUsuarioId kvmUsuarioId = new KvmUsuarioId();
        kvmUsuarioId.setIdKvmUsuario(Util.strInt(jTxtCodigo.getText()));


        
        
        
        
        
        //Nao sei o motivo desse erro abaixo//  
    public void beanView(KvmCliente kvmCliente) {
         String cad = String.valueOf(kvmCliente.getIdKvmCliente());
        jTxtCodigo.setText(cad);        
        jTxtNome.setText(kvmCliente.getKvmNome());
        jTxtSobrenome.setText(kvmCliente.getKvmSobrenome());
        jTxtSexo.setText(kvmCliente.getKvmSexo());
        jTxtRg.setText(kvmCliente.getKvmRg());
        jFmtCpf.setText(kvmCliente.getKvmCpf());
        
       
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        jFmtNascimento.setText( formato.format(kvmCliente.getKvmNascimento1() ));
        
        jTxtEmail.setText(kvmCliente.getKvmEmail());
        jTxtTelefone.setText(kvmCliente.getKvmTelefone());
        jTxtCelular.setText(kvmCliente.getKvmCelular());
        jTxtCep.setText(kvmCliente.getKvmCep());
        jTxtEndereco.setText(kvmCliente.getKvmEndereco());
        jTxtBairro.setText(kvmCliente.getKvmBairro());
        jTxtCidade.setText(kvmCliente.getKvmCidade());
        jTxtEstCivil.setText(kvmCliente.getKvmEstadoCivil());
       
        
    }
       
    
    public void beanView2(KvmUsuarioId kvmUsuarioId) {
        String cad = String.valueOf(kvmUsuarioId.getIdKvmUsuario());

        
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
        jFmtNascimento = new javax.swing.JFormattedTextField();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jTxtSexo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxtRg = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTxtTelefone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTxtCelular = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTxtCep = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTxtEndereco = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTxtCidade = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTxtBairro = new javax.swing.JTextField();
        jTxtEstCivil = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código");

        jLabel2.setText("Nome");

        jLabel3.setText("Sobrenome");

        jLabel4.setText("CPF");

        jLabel5.setText("Data de Nascimento");

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

        jLabel8.setText("Sexo");

        jLabel9.setText("Rg");

        jLabel10.setText("Email");

        jLabel11.setText("Telefone");

        jLabel12.setText("Celular");

        jTxtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCepActionPerformed(evt);
            }
        });

        jLabel13.setText("Cep");

        jLabel14.setText("Endereço");

        jLabel15.setText("Cidade");

        jLabel16.setText("Estado Civil");

        jLabel17.setText("Bairro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
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
                .addComponent(jBtnPesquisar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jTxtEstCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel17)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTxtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jTxtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14)
                            .addComponent(jTxtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jLabel13)
                            .addComponent(jTxtCep, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jLabel12)
                            .addComponent(jTxtCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jFmtNascimento)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jFmtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFmtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jFmtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtEstCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(26, 26, 26))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar)
                    .addComponent(jBtnAlterar))
                .addContainerGap())
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
        KvmCliente kvmCliente = viewBean();
        Cliente_DAO cliente_DAO = new Cliente_DAO();
        if (incluindo == true) {
            cliente_DAO.insert(kvmCliente);
        } else {
            cliente_DAO.update(kvmCliente);
        }

        desabilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
//    
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

    private void jTxtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCepActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCliente dialog = new JDlgCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JFormattedTextField jFmtCpf;
    private javax.swing.JFormattedTextField jFmtNascimento;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTxtBairro;
    private javax.swing.JTextField jTxtCelular;
    private javax.swing.JTextField jTxtCep;
    private javax.swing.JTextField jTxtCidade;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtEndereco;
    private javax.swing.JTextField jTxtEstCivil;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtRg;
    private javax.swing.JTextField jTxtSexo;
    private javax.swing.JTextField jTxtSobrenome;
    private javax.swing.JTextField jTxtTelefone;
    // End of variables declaration//GEN-END:variables
}
