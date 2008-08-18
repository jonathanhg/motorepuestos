/*
 * NewJFrame.java
 *
 * Created on 1 de agosto de 2008, 02:20 PM
 */

package view;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Factura;

/**
 *
 * @author  Administrator
 */
public class NewJFrame extends javax.swing.JFrame {

    /** Creates new form NewJFrame */
    public NewJFrame()  {
     /*   try {

            UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        initComponents();
        //createInternalFrameFact();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuProforma = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItemBusquedaFacturaUnica = new javax.swing.JMenuItem();
        jMenuItemproforma = new javax.swing.JMenuItem();
        jMenuReportes = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItemProveedores = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Moto Repuestos Facturacion");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenuProforma.setText("Facturacion");
        jMenuProforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProformaActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Nueva Factura");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuProforma.add(jMenuItem1);

        jMenuItemBusquedaFacturaUnica.setText("Busqueda Factura");
        jMenuItemBusquedaFacturaUnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBusquedaFacturaUnicaActionPerformed(evt);
            }
        });
        jMenuProforma.add(jMenuItemBusquedaFacturaUnica);

        jMenuItemproforma.setText("Proforma");
        jMenuItemproforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemproformaActionPerformed(evt);
            }
        });
        jMenuProforma.add(jMenuItemproforma);

        jMenuBar1.add(jMenuProforma);

        jMenuReportes.setText("Reportes");

        jMenuItem2.setText("Reportes de Facturacion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuItem2);

        jMenuItem3.setText("Reportes de Inventario");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuItem3);

        jMenuItem4.setText("Reportes Gerenciales");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuItem4);

        jMenuBar1.add(jMenuReportes);

        jMenu2.setText("Mantenimiento");

        jMenuItem5.setText("Mantenimiento de Productos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItemProveedores.setText("Mantenimiento de Proveedores");
        jMenuItemProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProveedoresActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemProveedores);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
createInternalFrameFact();
}//GEN-LAST:event_jMenuItem1ActionPerformed

private void jMenuItemBusquedaFacturaUnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBusquedaFacturaUnicaActionPerformed
SearchUniqueFact searchFact = new SearchUniqueFact(jDesktopPane1);
 Dimension d = jDesktopPane1.getSize();
     searchFact.setLocation(d.width/2 - searchFact.getWidth()/2, d.height/2 - searchFact.getHeight()/2 );
     jDesktopPane1.add(searchFact);
     searchFact.setVisible(true);

}//GEN-LAST:event_jMenuItemBusquedaFacturaUnicaActionPerformed

private void jMenuProformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProformaActionPerformed
// TODO add your handling code here:
    
}//GEN-LAST:event_jMenuProformaActionPerformed

private void jMenuItemproformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemproformaActionPerformed
// TODO add your handling code here:
    createInternalFrameProforma();
}//GEN-LAST:event_jMenuItemproformaActionPerformed

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
// TODO add your handling code here:
    ReportesFacturacion reportesFact = new ReportesFacturacion();
     Dimension d = jDesktopPane1.getSize();
     reportesFact.setLocation(d.width/2 - reportesFact.getWidth()/2 , d.height/2 -reportesFact.getHeight()/2 );
     jDesktopPane1.add(reportesFact);
     reportesFact.setVisible(true);
    
}//GEN-LAST:event_jMenuItem2ActionPerformed

private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
 ReportesInventario reportesInv = new ReportesInventario();
     Dimension d = jDesktopPane1.getSize();
     reportesInv.setLocation(d.width/2 - reportesInv.getWidth()/2 , d.height/2 -reportesInv.getHeight()/2 );
     jDesktopPane1.add(reportesInv);
     reportesInv.setVisible(true);
}//GEN-LAST:event_jMenuItem3ActionPerformed

private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
 ReportesGerencial reportesGer = new ReportesGerencial();
     Dimension d = jDesktopPane1.getSize();
     reportesGer.setLocation(d.width/2 - reportesGer.getWidth()/2 , d.height/2 -reportesGer.getHeight()/2 );
     jDesktopPane1.add(reportesGer);
     reportesGer.setVisible(true);
}//GEN-LAST:event_jMenuItem4ActionPerformed

private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
ManProductos prodManager = new ManProductos(jDesktopPane1);
Dimension d = jDesktopPane1.getSize();
     prodManager.setLocation(d.width/2 - prodManager.getWidth()/2 , d.height/2 -prodManager.getHeight()/2 );
     jDesktopPane1.add(prodManager);
     prodManager.setVisible(true);
}//GEN-LAST:event_jMenuItem5ActionPerformed

private void jMenuItemProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProveedoresActionPerformed
// TODO add your handling code here:
JInternalProveedor prov = new JInternalProveedor();//GEN-LAST:event_jMenuItemProveedoresActionPerformed
Dimension d = jDesktopPane1.getSize();
     prov.setLocation(d.width/2 - prov.getWidth()/2 , d.height/2 -prov.getHeight()/2 );
     jDesktopPane1.add(prov);
     prov.setVisible(true);
}


private void createInternalFrameProforma(){
    FacturaView fact = new FacturaView(null, jDesktopPane1,true);
    Dimension d = jDesktopPane1.getSize();
     fact.setLocation(d.width/2 - fact.getWidth()/2 , fact.getHeight()-490 );
     jDesktopPane1.add(fact);
     fact.setVisible(true);


}

private void createInternalFrameFact(){
         FacturaView fact = new FacturaView(null,jDesktopPane1,false);
        //fact.setSize(400, 400);
       
        try {
            fact.setIcon(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        fact.setMaximizable(true);
        fact.setResizable(true);
        Dimension d = jDesktopPane1.getSize();
        fact.setLocation(d.width/2 - fact.getWidth()/2 ,  fact.getHeight()-490 );
        jDesktopPane1.add(fact);
        fact.setVisible(true);

}
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItemBusquedaFacturaUnica;
    private javax.swing.JMenuItem jMenuItemProveedores;
    private javax.swing.JMenuItem jMenuItemproforma;
    private javax.swing.JMenu jMenuProforma;
    private javax.swing.JMenu jMenuReportes;
    // End of variables declaration//GEN-END:variables

}
