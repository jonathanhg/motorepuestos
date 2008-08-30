/*
 * ManProductos.java
 *
 * Created on 11 de agosto de 2008, 07:13 PM
 */
package view;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import daoHibernateImpl.*;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import model.Producto;

/**
 *
 * @author  Administrador
 */
public class ManProductos extends javax.swing.JInternalFrame {

    public JDesktopPane panel;
    public SearchProduct productoBusqueda;

    /** Creates new form ManProductos */
    public ManProductos(JDesktopPane panel) {
        this.panel = panel;
        initComponents();
        isCamposHabilitados(false);
        this.setClosable(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jNuevo = new javax.swing.JButton();
        jBuscar = new javax.swing.JButton();
        jModificar = new javax.swing.JButton();
        jAgregar = new javax.swing.JButton();
        jCodigo = new javax.swing.JTextField();
        jMinimos = new javax.swing.JTextField();
        jDescripcion = new javax.swing.JTextField();
        jPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jExistencias = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jCambiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jBorrar = new javax.swing.JButton();
        jBusModif = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel1.setText("Mantenimiento de Productos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

        jLabel2.setText("Codigo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel3.setText("Minimos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel4.setText("Descripcion");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        jLabel5.setText("Precio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        jNuevo.setText("Nuevo");
        jNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNuevoMouseClicked(evt);
            }
        });
        jPanel1.add(jNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jBuscar.setText("Buscar");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        jModificar.setText("Modificar");
        jModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jModificarMouseClicked(evt);
            }
        });
        jPanel1.add(jModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jAgregar.setText("Agregar");
        jAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAgregarMouseClicked(evt);
            }
        });
        jPanel1.add(jAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, -1, -1));
        jPanel1.add(jCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, -1));
        jPanel1.add(jMinimos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 30, -1));
        jPanel1.add(jDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 150, -1));
        jPanel1.add(jPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 70, -1));

        jLabel6.setText("Existencias");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));
        jPanel1.add(jExistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 40, -1));

        jLabel7.setText("¢");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        jCambiar.setText("Cambiar");
        jCambiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCambiarMouseClicked(evt);
            }
        });
        jPanel1.add(jCambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, -1));

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jBorrar.setText("Borrar");
        jBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(jBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        jBusModif.setText("Buscar");
        jBusModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBusModifActionPerformed(evt);
            }
        });
        jPanel1.add(jBusModif, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        jLabel8.setText("Codigo de barras");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAgregarMouseClicked
    ProductoDaoImpl manager = new ProductoDaoImpl();
    if (manager.obtenerProducto(jCodigo.getText()) == null) {

        Producto producto = new Producto();
        producto.setId(jCodigo.getText());
        producto.setDescripcion(jDescripcion.getText());
        boolean malDato = false;

        try {
            producto.setPrecioUnitario(Double.parseDouble(jPrecio.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Precio: debe ser un valor numérico");
            malDato = true;
        }
        try {
            producto.setMinimos(Integer.parseInt(jMinimos.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Mínimos: debe ser un valor numérico");
            malDato = true;
        }
        try {
            producto.setExistencias(Integer.parseInt(jExistencias.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Existencias: debe ser un valor numérico");
            malDato = true;
        }

        if (!jTextField1.getText().equals("")) {//si se ingresa algun dato

            if (manager.obtenerProductoSoloPorCodigo(jTextField1.getText()) != null) { //si no es igual a otro codigo de producto

                if (manager.obtenerProductoSoloPorCodigoDeBarras(jTextField1.getText()) != null) { //si no es igual a otro codigo de barras

                    producto.setCodBarras(jTextField1.getText());
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Error: el codigo de barras no puede ser \n igual a otro codigo de producto");
                    malDato = true;
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error: el codigo de barras no puede ser \n igual a otro codigo de barras");
                malDato = true;
            }
        } else {
            producto.setCodBarras(jTextField1.getText());
        }
//        producto.setFechaIngreso(new Date());

        if (malDato == false) {
            manager.agregarProducto(producto);
            JOptionPane.showMessageDialog(rootPane, "El producto ha sido agregado");
            limpiarCampos();
        }


    } else {
        JOptionPane.showMessageDialog(rootPane, "No se pudo agregar: Producto Repetido");
    }
}//GEN-LAST:event_jAgregarMouseClicked

private void jNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNuevoMouseClicked
    isCamposHabilitados(true);
    jCambiar.setEnabled(false);
    jBorrar.setEnabled(false);
    jBusModif.setEnabled(false);
}//GEN-LAST:event_jNuevoMouseClicked

private void jModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jModificarMouseClicked
    limpiarCampos();
    isCamposHabilitados(false);
    jCodigo.setEnabled(true);
    jBusModif.setEnabled(true);


}//GEN-LAST:event_jModificarMouseClicked

private void jCambiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCambiarMouseClicked
    ProductoDaoImpl manager = new ProductoDaoImpl();
    if (manager.obtenerProducto(jCodigo.getText()) != null) {

        Producto producto = new Producto();
        producto.setId(jCodigo.getText());
        producto.setDescripcion(jDescripcion.getText());
        try {
            producto.setPrecioUnitario(Double.parseDouble(jPrecio.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Precio: debe ser un valor numérico");
        }
        try {
            producto.setMinimos(Integer.parseInt(jMinimos.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Mínimos: debe ser un valor numérico");
        }
        try {
            producto.setExistencias(Integer.parseInt(jExistencias.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Existencias: debe ser un valor numérico");
        }
        manager.actualizarProducto(producto);

        limpiarCampos();

        JOptionPane.showMessageDialog(rootPane, "El producto ha sido cambiado");
    } else {
        JOptionPane.showMessageDialog(rootPane, "No se pudo cambiar: El producto no está en el sistema");
    }
    limpiarCampos();
    isCamposHabilitados(false);
}//GEN-LAST:event_jCambiarMouseClicked

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    isCamposHabilitados(false);
    jCodigo.setEnabled(true);
    jBorrar.setEnabled(true);
}//GEN-LAST:event_jButton1ActionPerformed

private void jBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBorrarActionPerformed


    ProductoDaoImpl manager = new ProductoDaoImpl();
    Producto producto = new Producto();
    if (jCodigo.getText() != null) {
        if (manager.obtenerProducto(jCodigo.getText()) != null) {
            producto = manager.obtenerProducto(jCodigo.getText());
            manager.eliminarProducto(producto);
            JOptionPane.showMessageDialog(rootPane, "El producto ha sido eliminado");
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se pudo cambiar: El producto no está en el sistema");
        }
    } else {
        JOptionPane.showMessageDialog(rootPane, "No se pudo cambiar: El código de producto no puede estar vacio");
    }
}//GEN-LAST:event_jBorrarActionPerformed

private void jBusModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBusModifActionPerformed
    ProductoDaoImpl manager = new ProductoDaoImpl();
    if (manager.obtenerProducto(jCodigo.getText()) != null) {
        Producto producto = new Producto();
        isCamposHabilitados(true);
        jBorrar.setEnabled(false);
        jAgregar.setEnabled(false);
        producto = manager.obtenerProducto(jCodigo.getText());
        jDescripcion.setText(String.valueOf(producto.getDescripcion()));
        jMinimos.setText(String.valueOf(producto.getMinimos()));
        jPrecio.setText(String.valueOf(producto.getPrecioUnitario()));
        jExistencias.setText(String.valueOf(producto.getExistencias()));
    }
    jBusModif.setEnabled(false);
    jCodigo.setEnabled(false);
    jCambiar.setEnabled(true);
}//GEN-LAST:event_jBusModifActionPerformed

private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed
    productoBusqueda = new SearchProduct();
    productoBusqueda.setVisible(true);
    this.toBack();
    Dimension d = panel.getSize();
    productoBusqueda.setLocation(d.width / 2 - productoBusqueda.getWidth() / 2, d.height / 2 - productoBusqueda.getHeight() / 2);
    panel.add(productoBusqueda);
    productoBusqueda.toFront();
    productoBusqueda.addInternalFrameListener(new InternalFrameAdapter() {

        public void internalFrameClosed(InternalFrameEvent e) {
            pasarDatos();

        }
    });
}//GEN-LAST:event_jBuscarActionPerformed

    private void pasarDatos() {
        Producto tempProducto = productoBusqueda.getProduct();
        if (tempProducto != null) {
            jCodigo.setText(tempProducto.getId());
            jDescripcion.setText(tempProducto.getDescripcion());
            jExistencias.setText(String.valueOf(tempProducto.getExistencias()));
            jMinimos.setText(String.valueOf(tempProducto.getMinimos()));
            jPrecio.setText(String.valueOf(tempProducto.getPrecioUnitario()));
        }
        try {
            productoBusqueda.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ManProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limpiarCampos() {
        jCodigo.setText("");
        jDescripcion.setText("");
        jMinimos.setText("");
        jPrecio.setText("");
        jExistencias.setText("");
        jTextField1.setText("");
    }

    private void isCamposHabilitados(boolean estado) {
        jCodigo.setEnabled(estado);
        jDescripcion.setEnabled(estado);
        jMinimos.setEnabled(estado);
        jPrecio.setEnabled(estado);
        jAgregar.setEnabled(estado);
        jExistencias.setEnabled(estado);
        jCambiar.setEnabled(estado);
        jBorrar.setEnabled(estado);
        jBusModif.setEnabled(estado);
        jTextField1.setEnabled(estado);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAgregar;
    private javax.swing.JButton jBorrar;
    private javax.swing.JButton jBusModif;
    private javax.swing.JButton jBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jCambiar;
    private javax.swing.JTextField jCodigo;
    private javax.swing.JTextField jDescripcion;
    private javax.swing.JTextField jExistencias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jMinimos;
    private javax.swing.JButton jModificar;
    private javax.swing.JButton jNuevo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPrecio;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
