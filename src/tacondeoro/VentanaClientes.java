/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tacondeoro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Arturo
 */
public class VentanaClientes extends javax.swing.JFrame {
    Connection c = null;

    DefaultListModel dlmArticulos;
    DefaultListModel dlmLineasPedido;
    private Socio usuario; 

    /**
     * Creates new form VentanaClientes
     */
    public VentanaClientes(Socio socio) {
        initComponents();

        dlmArticulos = new DefaultListModel();
        dlmLineasPedido = new DefaultListModel();
        lst_Articulos.setModel(dlmArticulos);
        lst_lineasPedido.setModel(dlmLineasPedido);
        usuario = socio;
        tf_socioCliente.setText(usuario.getNombre());
        System.out.println(socio.getNombre());
        DatabaseConnection db = new DatabaseConnection();
        c = db.getConexion();

        ArrayList<Zapato> z = Zapato.obtenerZapatos();
        ArrayList<Bolso> b = Bolso.obtenerBolsos();
        ArrayList<Complemento> c = Complemento.obtenerComplementos();

        dlmArticulos.addAll(z);
        dlmArticulos.addAll(b);
        dlmArticulos.addAll(c);

    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cb_CampanaOtoñoInvierno = new javax.swing.JCheckBox();
        cb_CampanaPrimaveraVerano = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        lst_Articulos = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lst_lineasPedido = new javax.swing.JList<>();
        btt_añadirAlCarrito = new javax.swing.JButton();
        btt_tramitarPedido = new javax.swing.JButton();
        btt_borrarDelCarrito = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tf_Cantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_total = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_Bolsos = new javax.swing.JCheckBox();
        cb_Complementos = new javax.swing.JCheckBox();
        cb_Zapatos = new javax.swing.JCheckBox();
        tf_Talla = new javax.swing.JTextField();
        cbb_añoTemporada = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_socioCliente = new javax.swing.JTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cb_CampanaOtoñoInvierno.setText("Otoño/Invierno");
        cb_CampanaOtoñoInvierno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_CampanaOtoñoInviernoActionPerformed(evt);
            }
        });

        cb_CampanaPrimaveraVerano.setText("Primavera/Verano");
        cb_CampanaPrimaveraVerano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_CampanaPrimaveraVeranoActionPerformed(evt);
            }
        });

        lst_Articulos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lst_Articulos.setAutoscrolls(false);
        jScrollPane2.setViewportView(lst_Articulos);

        jLabel1.setText("ARTICULOS");

        jLabel5.setText("CANTIDAD");

        lst_lineasPedido.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Linea Pedido 1", "Linea Pedido 2", "Linea Pedido 3", "Linea Pedido 4", "Linea Pedido 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(lst_lineasPedido);

        btt_añadirAlCarrito.setText("AÑADIR AL CARRITO");
        btt_añadirAlCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_añadirAlCarritoActionPerformed(evt);
            }
        });

        btt_tramitarPedido.setBackground(new java.awt.Color(204, 204, 204));
        btt_tramitarPedido.setText("TRAMITAR PEDIDO");
        btt_tramitarPedido.setBorder(new javax.swing.border.MatteBorder(null));
        btt_tramitarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_tramitarPedidoActionPerformed(evt);
            }
        });

        btt_borrarDelCarrito.setText("ELIMINAR DEL CARRITO");
        btt_borrarDelCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_borrarDelCarritoActionPerformed(evt);
            }
        });

        jLabel6.setText("TALLA");

        jLabel2.setText("CARRITO");

        jLabel3.setText("TOTAL DE PEDIDO");

        cb_Bolsos.setText("Bolsos");
        cb_Bolsos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_BolsosActionPerformed(evt);
            }
        });

        cb_Complementos.setText("Complementos");
        cb_Complementos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ComplementosActionPerformed(evt);
            }
        });

        cb_Zapatos.setText("Zapatos");
        cb_Zapatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ZapatosActionPerformed(evt);
            }
        });

        cbb_añoTemporada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023" }));
        cbb_añoTemporada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_añoTemporadaActionPerformed(evt);
            }
        });

        jLabel4.setText("Año Temporada:");

        jLabel7.setText("Temporadas:");

        jLabel8.setText("Usuario:");

        tf_socioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_socioClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cb_Complementos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_Bolsos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_Zapatos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cb_CampanaOtoñoInvierno)
                    .addComponent(cb_CampanaPrimaveraVerano)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbb_añoTemporada, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(tf_total, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btt_tramitarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btt_borrarDelCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btt_añadirAlCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tf_Talla, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(tf_socioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tf_socioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cb_CampanaPrimaveraVerano)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_CampanaOtoñoInvierno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbb_añoTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(cb_Zapatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_Bolsos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_Complementos)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(tf_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(tf_Talla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(btt_añadirAlCarrito)
                                        .addGap(18, 18, 18)
                                        .addComponent(btt_borrarDelCarrito)
                                        .addGap(125, 125, 125))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(12, 12, 12)
                                .addComponent(btt_tramitarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_CampanaOtoñoInviernoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_CampanaOtoñoInviernoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_CampanaOtoñoInviernoActionPerformed

    private void cb_CampanaPrimaveraVeranoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_CampanaPrimaveraVeranoActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_cb_CampanaPrimaveraVeranoActionPerformed

    private void btt_añadirAlCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_añadirAlCarritoActionPerformed
        // TODO add your handling code here:
        int indice = lst_Articulos.getSelectedIndex();
        float total = 0;

        if (indice == -1 && tf_Cantidad.getText().equalsIgnoreCase("") || indice == -1 || tf_Cantidad.getText().equalsIgnoreCase("") || tf_Cantidad.getText().equalsIgnoreCase("0")) {
            JOptionPane.showMessageDialog(this, "Para añadir un producto al carrito debes seleccionarlo y escribir la cantidad deseada (mayor que 0)");
        } else {
            LineaPedido a = new LineaPedido((Articulo) dlmArticulos.get(indice), Integer.parseInt(tf_Cantidad.getText()));
            Articulo b = (Articulo) dlmArticulos.get(indice);
            dlmLineasPedido.addElement(a);

            if (dlmLineasPedido.size() > 1) {
                for (int i = 0; i < dlmLineasPedido.size(); i++) {
                    LineaPedido x = (LineaPedido) dlmLineasPedido.getElementAt(i);
                    total = total + (x.getArticuloLinea().getPrecio() * x.getCantidad());
                }

                for (int i = 0; i < dlmLineasPedido.size(); i++) {
                    LineaPedido x = (LineaPedido) dlmLineasPedido.getElementAt(i);
                    for (int j = 0; j < dlmLineasPedido.size(); j++) {
                        LineaPedido c = (LineaPedido) dlmLineasPedido.getElementAt(j);
                        if (!(i == j) && x.getArticuloLinea().getNombre().equals(c.getArticuloLinea().getNombre())) {
                            c.setCantidad(c.getCantidad()+x.getCantidad());
                            dlmLineasPedido.removeElement(x);
                            lst_lineasPedido.updateUI();
                        }
                    }
                }
            } else if (dlmLineasPedido.size() == 1) {
                total = (b.getPrecio() * Integer.parseInt(tf_Cantidad.getText()));
            }

            tf_total.setText(String.valueOf(total));
        }
    }//GEN-LAST:event_btt_añadirAlCarritoActionPerformed

    private void btt_tramitarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_tramitarPedidoActionPerformed
        // TODO add your handling code here:
        Date fecha = new Date();
        if(lst_lineasPedido.getLastVisibleIndex()==-1){
            JOptionPane.showMessageDialog(null, "Para tramitar pedido tiene que añadir articulos en la cesta");
        }else if(lst_lineasPedido.getLastVisibleIndex()>-1){

            ArrayList <LineaPedido> lineasDePedido = new ArrayList<>();
            for (int i = 0; i < dlmLineasPedido.getSize(); i++) {
                lineasDePedido.add(i,(LineaPedido) dlmLineasPedido.getElementAt(i));
            }
            //Hacer metodo para comprobar el pueblo del socio con el q nos hemos registrado con el array de areaDeInfluencia de todas las rutas. 
            //Cuando este coincida se eligira esa ruta y se le pasara el idRuta al pedido nuevo para posteriormente hacer un insert
            Pedido pedido = new Pedido(fecha, Float.parseFloat(tf_total.getText()), lineasDePedido, usuario.getIdSocio(), 1);
            DatabaseConnection d = new DatabaseConnection();
            d.añadirPedidoBBDD(pedido);
        }
    }//GEN-LAST:event_btt_tramitarPedidoActionPerformed

    private void btt_borrarDelCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_borrarDelCarritoActionPerformed
        // TODO add your handling code here:
        int indice = lst_lineasPedido.getSelectedIndex();
        float total = 0;

        if (indice == -1 ) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un artículo a eliminar");
        } else {
            LineaPedido li = (LineaPedido) dlmLineasPedido.getElementAt(indice);
            float precioanterior = li.getCantidad() * li.getArticuloLinea().getPrecio();
            float f = Float.parseFloat(tf_total.getText()) - precioanterior;
            tf_total.setText(String.valueOf(f));
            dlmLineasPedido.removeElementAt(indice);
        }
    }//GEN-LAST:event_btt_borrarDelCarritoActionPerformed

    private void cb_BolsosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_BolsosActionPerformed
        // TODO add your handling code here:
        comprobarCheckboxes();
    }//GEN-LAST:event_cb_BolsosActionPerformed

    private void cb_ComplementosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ComplementosActionPerformed
        // TODO add your handling code here:
        comprobarCheckboxes();
    }//GEN-LAST:event_cb_ComplementosActionPerformed

    private void cb_ZapatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ZapatosActionPerformed
        // TODO add your handling code here:
        comprobarCheckboxes();
    }//GEN-LAST:event_cb_ZapatosActionPerformed

    private void cbb_añoTemporadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_añoTemporadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_añoTemporadaActionPerformed

    private void tf_socioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_socioClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_socioClienteActionPerformed

    private void comprobarCheckboxes() {
        ArrayList<Zapato> z = Zapato.obtenerZapatos();
        ArrayList<Bolso> b = Bolso.obtenerBolsos();
        ArrayList<Complemento> c = Complemento.obtenerComplementos();

        if (!cb_Zapatos.isSelected() && !cb_Bolsos.isSelected() && !cb_Complementos.isSelected()) {
            dlmArticulos.clear();
            dlmArticulos.addAll(z);
            dlmArticulos.addAll(b);
            dlmArticulos.addAll(c);
            lst_Articulos.updateUI();
        }

        if (cb_Zapatos.isSelected() && cb_Bolsos.isSelected() && cb_Complementos.isSelected()) {
            dlmArticulos.clear();
            dlmArticulos.addAll(z);
            dlmArticulos.addAll(b);
            dlmArticulos.addAll(c);
            lst_Articulos.updateUI();
        }
        
        if (cb_Zapatos.isSelected() && cb_Bolsos.isSelected() && !cb_Complementos.isSelected()) {
            dlmArticulos.clear();
            dlmArticulos.addAll(z);
            dlmArticulos.addAll(b);
            lst_Articulos.updateUI();
        }
        
        if (cb_Zapatos.isSelected() && cb_Complementos.isSelected() && !cb_Bolsos.isSelected()) {
            dlmArticulos.clear();
            dlmArticulos.addAll(z);
            dlmArticulos.addAll(c);
            lst_Articulos.updateUI();
        }
        
        if (cb_Bolsos.isSelected() && cb_Complementos.isSelected() && !cb_Zapatos.isSelected()) {
            dlmArticulos.clear();
            dlmArticulos.addAll(b);
            dlmArticulos.addAll(c);
            lst_Articulos.updateUI();
        }

        if (cb_Zapatos.isSelected() && !cb_Bolsos.isSelected() && !cb_Complementos.isSelected()) {
            dlmArticulos.clear();
            dlmArticulos.addAll(z);
            lst_Articulos.updateUI();
        }

        if (cb_Bolsos.isSelected() && !cb_Zapatos.isSelected() && !cb_Complementos.isSelected()) {
            dlmArticulos.clear();
            dlmArticulos.addAll(b);
            lst_Articulos.updateUI();
        }

        if (cb_Complementos.isSelected() && !cb_Zapatos.isSelected() && !cb_Bolsos.isSelected()) {
            dlmArticulos.clear();
            dlmArticulos.addAll(c);
            lst_Articulos.updateUI();
        }

        // Checkbox Primavera/Verano
        if (cb_CampanaPrimaveraVerano.isSelected() && !cb_CampanaOtoñoInvierno.isSelected()) {
            dlmArticulos.clear();
            mostrarPrimaveraVerano();
            lst_Articulos.updateUI();
        }
    }

    private void mostrarPrimaveraVerano() {
        Statement s = null;
        ResultSet rs = null;

        try {
            s = c.createStatement();
            rs = s.executeQuery("SELECT * from articulos inner join campanias on articulos.idcampania=campanias.idcampania where campanias.temporada='Primavera / Verano';");
                                  
            while (rs.next()) {
                    //  ??????????????
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        
    }

    /**
     * @param args the command line arguments
     */
    private VentanaClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            java.util.logging.Logger.getLogger(VentanaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btt_añadirAlCarrito;
    private javax.swing.JButton btt_borrarDelCarrito;
    private javax.swing.JButton btt_tramitarPedido;
    private javax.swing.JCheckBox cb_Bolsos;
    private javax.swing.JCheckBox cb_CampanaOtoñoInvierno;
    private javax.swing.JCheckBox cb_CampanaPrimaveraVerano;
    private javax.swing.JCheckBox cb_Complementos;
    private javax.swing.JCheckBox cb_Zapatos;
    private javax.swing.JComboBox<String> cbb_añoTemporada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> lst_Articulos;
    private javax.swing.JList<String> lst_lineasPedido;
    private javax.swing.JTextField tf_Cantidad;
    private javax.swing.JTextField tf_Talla;
    private javax.swing.JTextField tf_socioCliente;
    private javax.swing.JTextField tf_total;
    // End of variables declaration//GEN-END:variables
}
