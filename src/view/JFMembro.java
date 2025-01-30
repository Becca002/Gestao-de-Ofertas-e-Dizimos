package view;

import controller.Membro;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MembroModel;

public class JFMembro extends javax.swing.JFrame {

    public int usuarioId = -1;

    // variável global que controla o modo de operação do formulário
    int linha = -1;

    // define uma coleção de objetos
    ArrayList<Membro> membros = new ArrayList<>();

    public JFMembro() throws ClassNotFoundException, SQLException, ParseException {
        initComponents();
        setLocationRelativeTo(null);
        // lista os membros para a tabela
        this.atualizeTabela();
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        btnGravar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMembro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestão de membros");

        jLabel1.setText("Nome");

        jLabel3.setText("Telefone");

        jLabel4.setText("Data de nascimento");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblMembro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Telefone", "Data de nascimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMembro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMembroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMembro);
        if (tblMembro.getColumnModel().getColumnCount() > 0) {
            tblMembro.getColumnModel().getColumn(0).setPreferredWidth(300);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(txtNome)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataNascimento))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(77, 77, 77)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnRemover)
                    .addComponent(btnCancelar)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        try {
            // cria um objeto para conversão de String em Date
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            // cria um objeto da classe membro
            Membro membro = new Membro(
                this.linha == -1 ? -1 : this.membros.get(this.linha).getMembroId(),
                txtNome.getText(),
                format.parse(txtDataNascimento.getText()),
                txtTelefone.getText().replace("(", "").replace(")", "").replace("-", ""),
                this.usuarioId
            );
            // cria um objeto da classe MembroModel
            MembroModel model = new MembroModel();
            // grava o membro e recupera a mensagem
            String msg = model.grave(membro);
            // atualiza a tabela
            this.atualizeTabela();
            // limpa o formulário
            this.limpeFormulario();
            // realiza o controle dos botões
            this.controleBotoes();
            // exibe a mensagem retornada do banco de dados
            JOptionPane.showMessageDialog(null, msg);
        } catch (ParseException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void tblMembroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMembroMouseClicked
                // identifica o indice da linha clicada pelo usuário
        this.linha = tblMembro.rowAtPoint(evt.getPoint());

        // cria uma cópia do membro selecionado
        Membro membro = this.membros.get(this.linha);

        // preenche o formulário
        txtNome.setText( membro.getNome() );
        txtTelefone.setText( membro.getTelefone() );
        // objeto para manipulação da data
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        // formata a data para o formulário
        txtDataNascimento.setText( formato.format(membro.getDataNascimento()) );

        // habilita o botao remover
        this.controleBotoes();
    }//GEN-LAST:event_tblMembroMouseClicked

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
                // revisão de remoção
        if (
            JOptionPane.showConfirmDialog(
                null, "Realmente deseja remover o registro?", "Confirmação", JOptionPane.YES_NO_OPTION
            ) == JOptionPane.YES_OPTION
        ) {
            // cria um objeto da classe MembroModel
            MembroModel model = new MembroModel();
            // executa o método de remoção do membro
            String msg = "";
            try {
                msg = model.remova(
                        this.membros.get(this.linha).getMembroId()
                );
                this.atualizeTabela();
            } catch (ClassNotFoundException | SQLException | ParseException ex) {
                Logger.getLogger(JFMembro.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.limpeFormulario();
            this.controleBotoes();

            // exibe a mensagem retornada pela procedure
            JOptionPane.showMessageDialog(null, msg);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            // valida o termo de busca
            if (txtNome.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe um termo de busca");
                this.btnCancelarActionPerformed(evt);
                return;
            }
            
            // recupera o componente JTable
            DefaultTableModel model = (DefaultTableModel) tblMembro.getModel();
            // limpa as linhas da tabela
            model.setRowCount(0);
            // lista todos os dados da view v_membro
            MembroModel membro = new MembroModel();
            this.membros = membro.pesquise(txtNome.getText());
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            // percorre todos os registros
            for (Membro m : this.membros) {
                String dataNascimento = m.getDataNascimento() != null ? dateFormat.format(m.getDataNascimento()) : "";
                // adiciona uma linha na tabela
                model.addRow(new String[]{
                    m.getNome(), m.getTelefone(), dataNascimento
                });
            }
        } catch (ClassNotFoundException | SQLException |ParseException ex) {
            Logger.getLogger(JFMembro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            this.limpeFormulario();
            this.atualizeTabela();
            this.controleBotoes();
        } catch (ClassNotFoundException | SQLException |ParseException ex) {
            Logger.getLogger(JFMembro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void atualizeTabela() throws ClassNotFoundException, SQLException, ParseException {
        // recupera o componente JTable
        DefaultTableModel model = (DefaultTableModel) tblMembro.getModel();
        // limpa as linhas da tabela
        model.setRowCount(0);
        // lista todos os dados da view v_membro
        MembroModel membro = new MembroModel();
        this.membros = membro.liste();
        
        // percorre todos os registros
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // percorre todos os registros
        for (Membro m : this.membros) {
            String dataNascimento = m.getDataNascimento() != null ? dateFormat.format(m.getDataNascimento()) : "";
            // adiciona uma linha na tabela
            model.addRow(new String[]{
                m.getNome(), m.getTelefone(), dataNascimento
            });
        }
    }

    private void limpeFormulario() {
        this.linha = -1;
        txtNome.setText("");
        txtTelefone.setText("");
        txtDataNascimento.setText("");
    }

    private void controleBotoes() {
        btnRemover.setEnabled(this.linha != -1);
    }
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
            java.util.logging.Logger.getLogger(JFMembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFMembro().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JFMembro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(JFMembro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(JFMembro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMembro;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
