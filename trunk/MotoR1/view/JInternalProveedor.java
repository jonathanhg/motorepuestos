/*
 * JInternalProveedor.java
 *
 * Created on 16 de agosto de 2008, 02:42 PM
 */

package view;

import java.awt.event.ActionListener;
import model.Proveedores;
import daoHibernateImpl.*;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author  David
 */
public class JInternalProveedor extends javax.swing.JInternalFrame {
    
    /** Creates new form JInternalProveedor */
    public JInternalProveedor(JDesktopPane panel) {
        initComponents();
        //prov = new ProveedorDaoImpl();
    }
    
   /**
    * Método para incluir Proveedores 
    */
   public void incluirProveedor(){
        ProveedorDaoImpl prov = new ProveedorDaoImpl();                                          

        if(jTextCodigo.getText().equals("")&& jTextNombre.getText().equals("") &&
           jTextDirec.getText().equals("") && jTextTelefono.getText().equals("")&&
           jTextTipoCred.getText().equals("")){ 
            
               JOptionPane.showMessageDialog(null, "Rellene todos los datos");               
        }else{    
           if (prov.obtenerProveedor(jTextCodigo.getText()) == null) {

                Proveedores proveedor = new Proveedores();
                proveedor.setId(jTextCodigo.getText());
                proveedor.setNombre(jTextNombre.getText());
                proveedor.setDireccion(jTextDirec.getText());
                proveedor.setTelefono(jTextTelefono.getText());
                proveedor.setTipoCredito(jTextTipoCred.getText());
                prov.agregarProveedor(proveedor);                
                JOptionPane.showMessageDialog(null,"El proveedor ha sido incluido");
            }else           
            JOptionPane.showMessageDialog(null,"Ya existe el proveedor");
        }
        clear();
    }
   
   /**
    * Método para eliminar Proveedores
    */
   public void eliminarProveedor(){
       ProveedorDaoImpl prov = new ProveedorDaoImpl();
       Proveedores proveedor = new Proveedores();
       if(jTextCodigo.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Ingrese el código del proveedor a eliminar");
       }else{
           proveedor.setId(jTextCodigo.getText());
           prov.eliminarProveedor(proveedor);
           JOptionPane.showMessageDialog(rootPane,"El proveedor ha sido eliminado");
       }
       clear();
   }
   
   /**
    * Método para modificar inofrmación del Proveedor
    */
   public void modificarProveedor(){
    ProveedorDaoImpl prov = new ProveedorDaoImpl();                                          

        if(jTextCodigo.getText().equals("")&& jTextNombre.getText().equals("") &&
           jTextDirec.getText().equals("") && jTextTelefono.getText().equals("")&&
           jTextTipoCred.getText().equals("")){ 
            
               JOptionPane.showMessageDialog(null, "Rellene todos los datos");               
        }else{    
           if (prov.obtenerProveedor(jTextCodigo.getText()) != null) {

                Proveedores proveedor = new Proveedores();
                
                proveedor.setId(jTextCodigo.getText());
                proveedor.setNombre(jTextNombre.getText());
                proveedor.setDireccion(jTextDirec.getText());
                proveedor.setTelefono(jTextTelefono.getText());
                proveedor.setTipoCredito(jTextTipoCred.getText());
                prov.actualizarProveedor(proveedor);
                JOptionPane.showMessageDialog(rootPane,"El proveedor ha sido modificado");
            }else
            JOptionPane.showMessageDialog(rootPane,"El proveedor no ha sido encontrado");
        }
       // clear();
   }
   
   public void consultarProveedor(){
        //clear();
   }
       
   private void clear(){
        jTextCodigo.setText("");
        jTextNombre.setText("");
        jTextDirec.setText("");
        jTextTelefono.setText("");
        jTextTipoCred.setText("");
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
        jTextCodigo = new javax.swing.JTextField();
        jLabelCodigo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jTextDirec = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        jTextTelefono = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelTipoCred = new javax.swing.JLabel();
        jTextTipoCred = new javax.swing.JTextField();
        jBtModificar = new javax.swing.JButton();
        jBtConsultar = new javax.swing.JButton();
        jBtEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jBtIncluir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel1.setText("Mantenimiento Proveedores");

        jLabelCodigo.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelCodigo.setText("Código:");

        jLabelNombre.setText("Nombre:");

        jLabelDireccion.setText("Dirección:");

        jLabelTelefono.setText("Teléfono:");

        jLabelTipoCred.setText("Tipo Créd:");

        jBtModificar.setText("Modificar");
        jBtModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtModificarActionPerformed(evt);
            }
        });

        jBtConsultar.setText("Consultar");
        jBtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConsultarActionPerformed(evt);
            }
        });

        jBtEliminar.setText("Eliminar");
        jBtEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEliminarActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");

        jBtIncluir.setText("Incluir");
        jBtIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtIncluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelTelefono)
                                .addComponent(jLabelDireccion))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelCodigo)
                                .addComponent(jLabelNombre)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBtConsultar)
                                .addGap(18, 18, 18)
                                .addComponent(jBtIncluir)
                                .addGap(22, 22, 22)
                                .addComponent(jBtModificar)
                                .addGap(26, 26, 26)
                                .addComponent(jBtEliminar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDirec, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTipoCred)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextTipoCred, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCodigo))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelNombre)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDireccion)
                    .addComponent(jTextDirec, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono)
                    .addComponent(jLabelTipoCred)
                    .addComponent(jTextTipoCred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConsultar)
                    .addComponent(jBtModificar)
                    .addComponent(jBtEliminar)
                    .addComponent(jBtIncluir))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jBtIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtIncluirActionPerformed
// TODO add your handling code here:
    incluirProveedor();
}//GEN-LAST:event_jBtIncluirActionPerformed

private void jBtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEliminarActionPerformed
// TODO add your handling code here:
    eliminarProveedor();
}//GEN-LAST:event_jBtEliminarActionPerformed

private void jBtModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtModificarActionPerformed
// TODO add your handling code here:
    modificarProveedor();
}//GEN-LAST:event_jBtModificarActionPerformed

private void jBtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConsultarActionPerformed
// TODO add your handling code here:
    consultarProveedor();
}//GEN-LAST:event_jBtConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConsultar;
    private javax.swing.JButton jBtEliminar;
    private javax.swing.JButton jBtIncluir;
    private javax.swing.JButton jBtModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTipoCred;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextDirec;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextTelefono;
    private javax.swing.JTextField jTextTipoCred;
    // End of variables declaration//GEN-END:variables

}