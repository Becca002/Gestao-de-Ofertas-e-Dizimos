/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.Membro;
import controller.Oferta;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MembroModel;
import model.OfertaModel;

/**
 *
 * @author becca
 */
public class JFOferta extends javax.swing.JFrame {
    
    public int usuarioId = -1;
    
    int linha = -1;
    
    ArrayList<Oferta> ofertas = new ArrayList<>();
    
    ArrayList<Membro> membros = new ArrayList<>();
    
    public JFOferta() throws ClassNotFoundException, SQLException, ParseException {
        initComponents();
        setLocationRelativeTo(null);

        this.atualizeTabela();
        this.listeMembros();
    }
    
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    private void listeMembros() throws ClassNotFoundException, SQLException, ParseException {
        MembroModel model = new MembroModel();
        
        this.membros = model.liste();
        
        for (Membro m : this.membros) {
            txtMembro.addItem(m.getNome());
        }
    }
    
    private void atualizeTabela() throws ClassNotFoundException, SQLException, ParseException {
        DefaultTableModel model = (DefaultTableModel) tblOferta.getModel();

        model.setRowCount(0);

        OfertaModel oferta = new OfertaModel();
        this.ofertas = oferta.liste();

        for (Oferta o : this.ofertas) {
            model.addRow(new Object[]{
                o.getMembroNome(), 
                o.getValor()     
            });
        }
    }
    
    private void limpeFormulario() {
        this.linha = -1;
        txtValor.setText("");
    }
    
    private void controleBotoes() {
        btnRemover.setEnabled(this.linha != -1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();
        txtPago = new javax.swing.JComboBox<>();
        txtCategoria = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtMembro = new javax.swing.JComboBox<>();
        btnGravar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOferta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestão de Ofertas");

        jLabel1.setText("Valor");

        jLabel2.setText("Pago/Quitado");

        jLabel3.setText("Categoria");

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        txtPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        txtCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dízimo", "Oferta", "Doação" }));

        jLabel4.setText("Membro");

        txtMembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMembroActionPerformed(evt);
            }
        });

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblOferta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
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
        tblOferta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOfertaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOferta);
        if (tblOferta.getColumnModel().getColumnCount() > 0) {
            tblOferta.getColumnModel().getColumn(0).setResizable(false);
            tblOferta.getColumnModel().getColumn(0).setPreferredWidth(230);
            tblOferta.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(37, 37, 37)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtMembro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGravar)
                        .addGap(26, 26, 26)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addGap(30, 30, 30)
                        .addComponent(btnCancelar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMembro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnRemover)
                    .addComponent(btnBuscar)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void txtMembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMembroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMembroActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        try {
            String categoria = txtCategoria.getSelectedItem().toString();
            String categoriaSelecao = "";
            
            switch (categoria) {
                case "Dízimo":
                    categoriaSelecao = "di";
                    break;
                case "Oferta":
                    categoriaSelecao = "of";
                    break;
                case "Doação":
                    categoriaSelecao = "do";
                    break;
                default: 
                    JOptionPane.showMessageDialog(null, "Categoria inválida");
            } 
            
            Oferta oferta = new Oferta(
            
            this.linha == -1 ? -1 : this.ofertas.get(this.linha).getOfertaId(),
            Double.parseDouble(txtValor.getText().replace(",", ".")),
            txtPago.getSelectedItem().toString().equals("Sim") ? 1 : 0,
            categoriaSelecao,
            this.usuarioId,
            this.membros.get(txtMembro.getSelectedIndex()).getMembroId()
            );
            
            OfertaModel model = new OfertaModel();
            
            String msg = model.grave(oferta);
            
            this.atualizeTabela();
            
            this.limpeFormulario();
            
            this.controleBotoes();
            
            JOptionPane.showMessageDialog(null, msg);
        } catch (ParseException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Realmente deseja remover o registro?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            OfertaModel model = new OfertaModel();
            
            String msg = "";
            try {
                msg = model.remova(
                    this.ofertas.get(this.linha).getOfertaId()
                );
                
                this.atualizeTabela();
            } catch (ClassNotFoundException | SQLException | ParseException ex) {
                Logger.getLogger(JFOferta.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.limpeFormulario();
            this.controleBotoes();

            JOptionPane.showMessageDialog(null, msg);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            if (txtMembro.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Informe um termo de busca");
                this.btnCancelarActionPerformed(evt);
                return;
            }

            DefaultTableModel model = (DefaultTableModel) tblOferta.getModel();

            model.setRowCount(0);

            OfertaModel oferta = new OfertaModel();
            this.ofertas = oferta.pesquise(this.membros.get(txtMembro.getSelectedIndex()).getMembroId());

            for (Oferta o : this.ofertas) {
                model.addRow(new Object[]{
                    o.getMembroNome(), 
                    o.getValor()       
                });
            }
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(JFMembro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            this.limpeFormulario();
            this.atualizeTabela();
            this.controleBotoes();
        } catch (ClassNotFoundException | SQLException |ParseException ex) {
            Logger.getLogger(JFOferta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblOfertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOfertaMouseClicked
        this.linha = tblOferta.rowAtPoint(evt.getPoint());

        Oferta oferta = this.ofertas.get(this.linha);

        txtValor.setText(Double.toString(oferta.getValor()).replace(".", ","));
        
        switch (oferta.getPago()) {
            case 0:
                txtPago.setSelectedItem("Não");
                break;
            case 1:
                txtPago.setSelectedItem("Sim");
                break;
            default:
                txtPago.setSelectedIndex(-1);
        }
        
        switch (oferta.getCategoria()) {
            case "di":
                txtCategoria.setSelectedItem("Dízimo");
                break;
            case "of":
                txtCategoria.setSelectedItem("Oferta");
                break;
            case "do":
                txtCategoria.setSelectedItem("Doação");
                break;
            default:
                txtCategoria.setSelectedIndex(-1);
        }
        
        txtMembro.setSelectedItem(oferta.getMembroNome());
       
        this.controleBotoes();
    }//GEN-LAST:event_tblOfertaMouseClicked

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
            java.util.logging.Logger.getLogger(JFOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFOferta().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JFOferta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(JFOferta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(JFOferta.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOferta;
    private javax.swing.JComboBox<String> txtCategoria;
    private javax.swing.JComboBox<String> txtMembro;
    private javax.swing.JComboBox<String> txtPago;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
