/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tacondeoro;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Arturo
 */
public class VentanaMozos extends javax.swing.JFrame {
    DefaultListModel dlmPendientes = null;
    DefaultListModel dlmSinStock = null;
    private Socio mozo;

    /**
     * Creates new form VentanaMozos
     */
    public VentanaMozos(Socio mozo) {
        initComponents();
        int noStock = 0;
        this.mozo = mozo;
        tf_mozo.setText(this.mozo.getNombre());
        dlmPendientes = new DefaultListModel();
        dlmSinStock = new DefaultListModel();
        dlmPendientes.addAll(Pedido.obtenerPedidosPendientes());
        lst_pedidosPendientes.setModel(dlmPendientes);
        dlmSinStock.addAll(Articulo.obtenerArticulos());
        lst_articulosSinStock.setModel(dlmSinStock);

        for (int i = 0; i < Articulo.allStocks(dlmSinStock).size(); i++) {
            if (Articulo.allStocks(dlmSinStock).get(i) <= 5) {
                noStock++;
                break;
            }
        }

        if (!(noStock == 0)) {
            btt_añadirStock.setEnabled(true);
            tf_stockAñadir.setEditable(true);
        } else {
            btt_añadirStock.setEnabled(false);
            tf_stockAñadir.setEditable(false);
        }
        this.setLocationRelativeTo(null);
    }

    private VentanaMozos() {
    }

    public Socio getMozo() {
        return mozo;
    }

    public DefaultListModel getDlmPendientes() {
        return dlmPendientes;
    }

    public void setDlmPendientes(DefaultListModel dlmPendientes) {
        this.dlmPendientes = dlmPendientes;
    }

    public DefaultListModel getDlmSinStock() {
        return dlmSinStock;
    }

    public void setDlmSinStock(DefaultListModel dlmSinStock) {
        this.dlmSinStock = dlmSinStock;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoGradiente(Color.decode("#115ad3"), Color.decode("#11d0d3"));
        jLabel1 = new javax.swing.JLabel();
        tf_mozo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_pedidosPendientes = new javax.swing.JList<>();
        btt_cumplimentar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lst_articulosSinStock = new javax.swing.JList<>();
        btt_añadirStock = new javax.swing.JButton();
        tf_stockAñadir = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btt_agregarMozos = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mi_volverAtras = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mozo:");

        tf_mozo.setDisabledTextColor(new java.awt.Color(200, 20, 20));
        tf_mozo.setEnabled(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PEDIDOS PENDIENTES:");

        lst_pedidosPendientes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lst_pedidosPendientes);

        btt_cumplimentar.setText("CUMPLIMENTAR PEDIDO");
        btt_cumplimentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_cumplimentarActionPerformed(evt);
            }
        });

        lst_articulosSinStock.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lst_articulosSinStock);

        btt_añadirStock.setText("AÑADIR STOCK");
        btt_añadirStock.setEnabled(false);
        btt_añadirStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_añadirStockActionPerformed(evt);
            }
        });

        tf_stockAñadir.setEditable(false);
        tf_stockAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_stockAñadirActionPerformed(evt);
            }
        });

        jLabel3.setText("Cantidad:");

        btt_agregarMozos.setText("AGREGAR MOZOS");
        btt_agregarMozos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_agregarMozosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btt_agregarMozos, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(btt_cumplimentar, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(btt_añadirStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_stockAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_mozo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tf_mozo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_stockAñadir)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btt_añadirStock)
                        .addGap(18, 18, 18)
                        .addComponent(btt_cumplimentar)
                        .addGap(18, 18, 18)
                        .addComponent(btt_agregarMozos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );

        jMenu1.setText("Volver");

        mi_volverAtras.setText("Volver Atrás");
        mi_volverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_volverAtrasActionPerformed(evt);
            }
        });
        jMenu1.add(mi_volverAtras);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btt_cumplimentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_cumplimentarActionPerformed
        int index = lst_pedidosPendientes.getSelectedIndex();
        Pedido a = (Pedido) dlmPendientes.getElementAt(index);
        ArrayList<Integer> todoStock = new ArrayList<>();
        int noStock = 0;
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un pedido a cumplimentar");
        } else {
            for (int i = 0; i < a.getnLineas().size(); i++) {
                Articulo b = a.getnLineas().get(i).getArticuloLinea();
                if (b.getStock() < a.getnLineas().get(i).getCantidad()) {
                    //Aqui hay que hacer cositas
                    noStock++;
                    int stockAñadir = Math.abs(b.getStock() - a.getnLineas().get(i).getCantidad());
                    JOptionPane.showMessageDialog(null, "No hay stock suficiente del articulo " + b.getNombre() + ", se necesitan añadir " + stockAñadir + " existencias");
                    btt_añadirStock.setEnabled(true);
                    tf_stockAñadir.setEditable(true);
                } else {
                    b.setStock(b.getStock() - a.getnLineas().get(i).getCantidad());
                    Articulo.nuevaCantidad(b.getStock(), b.getIdArticulo());
                }
            }
            if (noStock == 0) {
                Pedido.completarPedido(a.getIdPedido());
            }
            noStock = 0;
            dlmPendientes.clear();
            dlmSinStock.clear();
            dlmPendientes.addAll(Pedido.obtenerPedidosPendientes());
            dlmSinStock.addAll(Articulo.obtenerArticulos());
            lst_pedidosPendientes.updateUI();
            lst_articulosSinStock.updateUI();
        }
        todoStock.addAll(Articulo.allStocks(dlmSinStock));
        for (int i = 0; i < todoStock.size(); i++) {
            if (todoStock.get(i) <= 5) {
                noStock++;
                break;
            }
        }
        if (!(noStock == 0)) {
            btt_añadirStock.setEnabled(true);
            tf_stockAñadir.setEditable(true);
        }
    }//GEN-LAST:event_btt_cumplimentarActionPerformed

    private void btt_añadirStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_añadirStockActionPerformed
        int index = lst_articulosSinStock.getSelectedIndex();
        Articulo articulo = (Articulo) dlmSinStock.get(index);
        if (index == -1 || tf_stockAñadir.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un articulo y especifique una cantidad para añadir stock");
        } else {
            articulo.setStock(articulo.getStock() + Integer.parseInt(tf_stockAñadir.getText()));
            Articulo.nuevaCantidad(articulo.getStock(), articulo.getIdArticulo());
            dlmSinStock.clear();
            dlmSinStock.addAll(Articulo.obtenerArticulos());
            lst_articulosSinStock.updateUI();
        }
    }//GEN-LAST:event_btt_añadirStockActionPerformed

    private void tf_stockAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_stockAñadirActionPerformed

    }//GEN-LAST:event_tf_stockAñadirActionPerformed

    private void btt_agregarMozosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_agregarMozosActionPerformed
        this.dispose();
        VentanaRegistro a = new VentanaRegistro(this, true);
        a.setVisible(true);
    }//GEN-LAST:event_btt_agregarMozosActionPerformed

    private void mi_volverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_volverAtrasActionPerformed
        // TODO add your handling code here:
        this.dispose();
        VentanaInicio vi = new VentanaInicio();
        vi.setVisible(true);
    }//GEN-LAST:event_mi_volverAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaMozos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMozos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMozos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMozos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMozos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btt_agregarMozos;
    private javax.swing.JButton btt_añadirStock;
    private javax.swing.JButton btt_cumplimentar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lst_articulosSinStock;
    private javax.swing.JList<String> lst_pedidosPendientes;
    private javax.swing.JMenuItem mi_volverAtras;
    private javax.swing.JTextField tf_mozo;
    private javax.swing.JTextField tf_stockAñadir;
    // End of variables declaration//GEN-END:variables
}
