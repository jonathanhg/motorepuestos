/*
 * Factura.java
 *
 * Created on 16 de agosto de 2008, 08:37 PM
 */

package view;

import boImpl.FacturaBoImpl;
import daoHibernateImpl.ProductoDaoImpl;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.*;
import model.FactProduct;
import model.Factura;
import model.Producto;

/**
 *
 * @author  luisj
 */
public class FacturaView extends javax.swing.JInternalFrame {
    
    public boolean isProforma=false;
    
    public int idFact ;
    
    public Date fecha;
    
    public double subTotal;
    
    public double total;
    
    public FactTableModel  tablemodel;
    
    /** Creates new form Factura */
    public FacturaView(Factura factura,JDesktopPane panel,boolean isProforma) {
         super("", true, false, true, true);
          
         factBo = new FacturaBoImpl();
         idFact = 0;
        this.panel = panel;
        this.isProforma = isProforma;
        if(factura == null){
            factura = new Factura();
            productos = new ArrayList<FactProduct>();
            if(!isProforma){
                idFact= factBo.save(factura);
            }
            
            FactProduct factNew = new FactProduct();
            productos.add(factNew);
            this.setTitle("Factura : "+idFact );
            if(isProforma){
                this.setTitle("Factura : Proforma");
            
            }
            
           
       }else{
            productos = factura.getProductos();
           this.setTitle("Factura : "+factura.getId()
                   
                   );
       }
       
        tablemodel = new FactTableModel();
       jTableProductos = new javax.swing.JTable(tablemodel);
        
        SwingUtilities.invokeLater(new Runnable() { 
          public void run(){
            jTableProductos.requestFocusInWindow();
            jTableProductos.changeSelection(0, 0, false, false);
          }
            });
            
       
         
        
            initComponents();
            if(isProforma){
                jButtonProcesar.setText("Imprimir");
            
            }
           
        jSpinner2.setValue(new Integer("13"));  
        
        SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaT = new Date();
         jTextFieldFecha.setEnabled(false);
         jTextFieldFecha.setText(newDateFormat.format(fechaT));
        this.fecha = fechaT;
         
          Locale locale = new Locale("es", "CR");
        NumberFormat n = NumberFormat.getCurrencyInstance(locale) ;
        CurrencyRender cellRender = new CurrencyRender(n);
        TableColumnModel _model = jTableProductos.getColumnModel();
        TableColumn _column = _model.getColumn(4);
        _column.setCellRenderer(cellRender);
        TableColumn _column1 = _model.getColumn(3);
        _column1.setCellRenderer(cellRender);
        // TableColumn _column2 = _model.getColumn(2);
        //_column2.setCellEditor(new SpinnerEditor());
    }
    
    
   /* 
    public class SpinnerEditor extends AbstractCellEditor
            implements TableCellEditor {
        final JSpinner spinner = new JSpinner();
    
        // Initializes the spinner.
        public SpinnerEditor() {
            //spinner.setModel(new SpinnerListModel(java.util.Arrays.asList(items)));
        }
    
        // Prepares the spinner component and returns it.
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            spinner.setValue((Integer)value);
            return spinner;
        }
    
        // Enables the editor only for double-clicks.
        public boolean isCellEditable(EventObject evt) {
          
            return true;
        }
    
        // Returns the spinners current value.
        public Object getCellEditorValue() {
            return spinner.getValue();
        }
    }

   
    */
   
private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBoxExonerar = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerDescuento = new javax.swing.JSpinner();
        textFieldSubTotal = new javax.swing.JTextField();
        jSpinner2 = new javax.swing.JSpinner();
        jTextFieldTotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButtonProcesar = new javax.swing.JButton();
        jButtonAnular = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldFecha = new javax.swing.JTextField();
        jButtonBusqueda = new javax.swing.JButton();
        jButtonEliminarRow = new javax.swing.JButton();

       
        jScrollPane1.setViewportView(jTableProductos);

        jLabel1.setText("Cliente: ");

        jLabel2.setText("Descuento %: ");

        jLabel3.setText("SubTotal:");

        jLabel4.setText("I.Ventas %:");
        

        jCheckBoxExonerar.setText("Exonerar");
        jCheckBoxExonerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxExonerarActionPerformed(evt);
            }
        });

        jLabel5.setText("Total:");

        textFieldSubTotal.setEditable(false);

        jTextFieldTotal.setEditable(false);

        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDescripcion);

        jLabel6.setText("Descripcion:");

        jButtonProcesar.setText("Procesar");
        jButtonProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProcesarActionPerformed(evt);
            }
        });

        jButtonAnular.setText("Cancelar");
        jButtonAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnularActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha:");

        jTextFieldFecha.setEditable(false);

        jButtonBusqueda.setFont(new java.awt.Font("Tahoma", 0, 10));
        jButtonBusqueda.setText("busqueda");
        jButtonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBusquedaActionPerformed(evt);
            }
        });

        jButtonEliminarRow.setFont(new java.awt.Font("Tahoma", 0, 10));
        jButtonEliminarRow.setText("Eliminar");
      
        
        jSpinnerDescuento.addChangeListener(new SpinnerListener());
        jSpinner2.addChangeListener(new SpinnerListenerTotal());
        
        jCheckBoxExonerar.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
               calcTotal();
            }
        } );
        
        jButtonEliminarRow.addActionListener(new ActionListener(){
          
            public void actionPerformed(ActionEvent e) {
               onClickEliminarRow();
            }
        
        
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                            .addComponent(jLabel6))
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jCheckBoxExonerar)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel4)
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(687, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textFieldSubTotal, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonBusqueda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminarRow)
                        .addGap(97, 97, 97))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178)
                .addComponent(jButtonAnular)
                .addGap(18, 18, 18)
                .addComponent(jButtonProcesar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonBusqueda)
                            .addComponent(jButtonEliminarRow))
                        .addGap(9, 9, 9)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxExonerar))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );

        pack();
    }

private void jCheckBoxExonerarActionPerformed(java.awt.event.ActionEvent evt) {                                                  
// TODO add your handling code here:
}                                                 

private void onClickEliminarRow() {                                         
    int selectedRows[] = jTableProductos.getSelectedRows();
    for(int i=0;i<selectedRows.length;i++ ){
      
        productos.remove(selectedRows[i]);
        tablemodel.refreshData();
        
    }
    
}

private void jButtonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
}

private void jButtonAnularActionPerformed(java.awt.event.ActionEvent evt) {
        try {
// TODO add your handling code here:
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
        }
}

private void jButtonProcesarActionPerformed(java.awt.event.ActionEvent evt) {
    FacturaBoImpl factBoo = new FacturaBoImpl();
    Factura fact = new Factura();
    fact.setId(idFact);
    if(productos.size() == 0 ){ //TODO VER SI EN REALIDAD HAY UN PRODUCTO PORK EL PRIMERO ESTA VACIO
    JOptionPane.showMessageDialog(this, "La factura Al Menos debe tener un producto");
    return;
    }
    fact.setProductos(productos);
    fact.setFecha(fecha);
    fact.setCliente(jTextFieldCliente.getText());
    fact.setDescuento((Integer)jSpinnerDescuento.getValue());
    fact.setIs_anulado(false);
    fact.setSin_impuesto(jCheckBoxExonerar.isSelected());
    fact.setTotal(total);
    //fact.setTotal(jTextFieldTotal.getText());
    factBoo.saveFact(fact, this);
        try {
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public class SpinnerListener implements ChangeListener{

        public void stateChanged(ChangeEvent evt) {
            JSpinner spinner = (JSpinner)evt.getSource();
    
            // Get the new value
            spinnerDescuento = (Integer)spinner.getValue();
            calcSubTotal(spinnerDescuento);
            calcTotal();
        }
            
            
  }

public class SpinnerListenerTotal implements ChangeListener{

        public void stateChanged(ChangeEvent evt) {
            JSpinner spinner = (JSpinner)evt.getSource();
    
            // Get the new value
            spinnerDescuento = (Integer)spinner.getValue();
            //calcSubTotal(spinnerDescuento);
            calcTotal();
        }
            
            
  }

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonAnular;
    private javax.swing.JButton jButtonBusqueda;
    private javax.swing.JButton jButtonEliminarRow;
    private javax.swing.JButton jButtonProcesar;
    private javax.swing.JCheckBox jCheckBoxExonerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinnerDescuento;
    public javax.swing.JTable jTableProductos;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextFieldCliente;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField textFieldSubTotal;
    private javax.swing.JDesktopPane panel;
    private FacturaBoImpl factBo;
    private List<FactProduct> productos;
    private int spinnerDescuento ;
    // End of variables declaration

    
     public void  setBringToFrontAndBack(JInternalFrame interFrame){
       // panel.getDesktopManager().deactivateFrame(this);
       // panel.getDesktopManager().activateFrame(interFrame);    
        interFrame.toFront();
    }
     public void  setBringToBackToFront(){
       
        //panel.getDesktopManager().activateFrame(this);    
    
    }
     
    public void calcSubTotal(int descuento){
       double tempSubTotal= 0;
        for(int i=0;i< productos.size();i++){
            tempSubTotal +=productos.get(i).getTotal();
            
        }
          
        Locale locale = new Locale("es", "CR");
        NumberFormat n = NumberFormat.getCurrencyInstance(locale) ;
        if(descuento == -1){
         descuento = (Integer)jSpinnerDescuento.getValue();
        
        }else{
            
        }
        
        tempSubTotal =  tempSubTotal - (tempSubTotal/100)*descuento;
        subTotal = tempSubTotal;
        String tm =       n.format(tempSubTotal);
        textFieldSubTotal.setText(tm);
      

    
    } 
    
    public void calcTotal(){
        
      if(jCheckBoxExonerar.isSelected()){
           
            total = subTotal-(subTotal/100)*(Integer)jSpinner2.getValue();
      
      }else{
             total = subTotal;
      
      }
        Locale locale = new Locale("es", "CR");
        NumberFormat n = NumberFormat.getCurrencyInstance(locale) ;
         String tm =       n.format(total);
         jTextFieldTotal.setText(tm);
         
    }
    
    static class CurrencyRender extends DefaultTableCellRenderer{
        NumberFormat currencyFormat;
        
        public CurrencyRender(NumberFormat cf){
            currencyFormat = cf;
        
        }
        
          public Component getTableCellRendererComponent(JTable table,
         Object value, boolean isSelected, boolean hasFocus, 
         int row, int col) {
            
              String formattedValue = null;
              Double _value = (Double)value;
              if(value == null){
                formattedValue = "lala";
              } else {
                   formattedValue = currencyFormat.format(_value);
              }
              JLabel testLabel = new JLabel(formattedValue,SwingConstants.RIGHT);
   if (isSelected) {
    testLabel.setBackground(table.getSelectionBackground());
    testLabel.setOpaque(true);
    testLabel.setForeground(table.getSelectionForeground());
   }
   if (hasFocus) {
    testLabel.setForeground(table.getSelectionBackground());
    testLabel.setBackground(table.getSelectionForeground());
    testLabel.setOpaque(true);
   }
   return testLabel;
  

        
        }
        
        
    
    }
    
    
     class FactTableModel extends AbstractTableModel {
          String[] columnNames = {"Codigo",
                        "Descripcion",
                        "Cantidad",
                        "Precio","Total"};
          
      
          
        public int getRowCount() {
           return productos.size();
        }

        public int getColumnCount() {
            return columnNames.length;
        }
        
         public String getColumnName(int i) {
              return columnNames[i];
          }


        public Object getValueAt(int rowIndex, int columnIndex) {
            FactProduct product = productos.get(rowIndex);
            switch(columnIndex){
                case 0:
                    return product.getId();
                case 1:
                    return product.getDescripcion();
                case 2:
                    return product.getCantidad();
                case 3:
                    return product.getPrecio();
                case 4:
                    return product.getTotal();
                default:
                    return null;
            }
          
        }
        
         public Class getColumnClass(int c) {
             switch (c) {
                case 0: //Id
                 return String.class;
                case 1: //Descripcion
                 return String.class;
                case 2: //Cantidad
                 return Integer.class;
                case 3: //precio
                 return Integer.class;
                 case 4:
                 return Integer.class;
                default:
                 return null;
   }

        }
         
        public boolean isCellEditable(int row, int col) {
          switch (col) {
            case 0: //Id
             return true;
            case 1: //Descipcion
             return false;
            case 2: //cantidad
             return true;
            case 3: //precio
             return false;
              case 4:
                  return false;
            default:
             return false;
         }

    }
        
        public void setValueAt(Object value, int row, int col) {
            final FactProduct product =  productos.get(row);
             switch (col) {
                case 0: //Id
                 product.setId(value.toString());
                 ProductoDaoImpl productDao = new ProductoDaoImpl();
                 Producto temp =  productDao.obtenerProducto(value.toString());
                 if(temp != null){
                 product.setDescripcion(temp.getDescripcion());
                 product.setPrecio(temp.getPrecioUnitario());
                 product.setCantidad(1);
                 product.setTotal(temp.getPrecioUnitario());
                 }else{
                    final SearchProduct busquedaProducto = new SearchProduct();
                    busquedaProducto.setVisible(true);
                    //busquedaProducto.setLo
                    Dimension d = panel.getSize();
                     busquedaProducto.setLocation(d.width/2 - busquedaProducto.getWidth()/2, d.height/2 - busquedaProducto.getHeight()/2 );
                    panel.add(busquedaProducto);
                    setBringToFrontAndBack(busquedaProducto);
                    busquedaProducto.addInternalFrameListener( new InternalFrameAdapter() {
                        public void internalFrameClosed(InternalFrameEvent e){
                           
                           Producto pro = busquedaProducto.getProduct();
                           product.setDescripcion(pro.getDescripcion());
                           product.setPrecio(pro.getPrecioUnitario());
                           product.setId(pro.getId());
                           product.setTotal(pro.getPrecioUnitario());
                           product.setCantidad(1);
                            FactProduct factNew = new FactProduct();
                            productos.add(factNew);
                            productos.remove(productos.size()-1);
                              calcSubTotal(-1);
                              calcTotal();
                        }
                    
                    }
                            
                            
                            );
                    
                    //setBringToBackToFront();
                 }
                 
                 break;
                case 1: //descripcion
                    
                 break;
                case 2: //cantidad
                 product.setCantidad(Integer.valueOf(value.toString()));
                 product.setTotal(product.getCantidad()*product.getPrecio());
                 break;
                case 3: //precio
                 
                    
                 break;
                 case 4:
                     break;
               }
                     if(productos.get(productos.size()-1).getId() != null){
                         FactProduct productEmpty = new FactProduct();
                         productos.add(productEmpty);
                    
                         
                     }
                    /* jTableProductos.addKeyListener(
                             new KeyAdapter() {
                             public void keyTyped(KeyEvent e){
                                 if( e.getKeyChar() == 'd'){
                                 //  Integer i = tableProduct.getSelectedRow();
                                   // JOptionPane.showMessageDialog(null, "aasd"+productos.size());
                                  // productos.remove(i);
                                  // JOptionPane.showMessageDialog(null, "aasd"+i.toString());
                                  
                                   
                                           
                                 }
                             }
                     
                     }
                             
                             );
                            */
                            
                     calcSubTotal(-1);
                     calcTotal();
                     fireTableDataChanged();
            
          
            
            

           
        }

      
        public void refreshData(){
            fireTableDataChanged();
        }
        
        
}
}