/*
 * AnularFactura.java
 *
 * Created on 18 de agosto de 2008, 01:19 PM
 */
package view;

import daoHibernateImpl.FacturaDaoImpl;
import javax.swing.JOptionPane;
import model.Factura;

/**
 *
 * @author  Administrator
 */
public class AnularFactura extends javax.swing.JInternalFrame {

    /** Creates new form AnularFactura */
    public AnularFactura() {
        initComponents();
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
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setText("Modulo de anulación de facturas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 130, -1));

        jLabel2.setText("Código de factura:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    FacturaDaoImpl factManager = new FacturaDaoImpl();
    Factura factura = new Factura();
    int codigoFactura = 0;
    boolean buenosDatos = true;
    try {
        codigoFactura = Integer.parseInt(jTextField1.getText().toString());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Codigo de factura: debe ser un valor numerico");
        buenosDatos = false;
    }
    if (buenosDatos == true) {
        factura = factManager.facturaPorCodigo(codigoFactura);
        if (factura != null) {
            if (factura.getIs_anulado() == false) {
                factManager.anularFactura(factura);
                jTextField1.setText("");
            } else {
                System.out.println("estado de la factura: "+factura.getIs_anulado());
                JOptionPane.showMessageDialog(rootPane, "Error: la factura: " + codigoFactura + " ya estaba anulada");
            }
        }else{
JOptionPane.showMessageDialog(rootPane, "Error: la factura: " + codigoFactura + " no fue encontrada");            
        }
    }
}//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
