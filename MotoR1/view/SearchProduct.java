package view;

import daoHibernateImpl.ProductoDaoImpl;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.AbstractTableModel;
import model.Producto;

/**
 *
 * @author  luisj
 */
public class SearchProduct extends javax.swing.JInternalFrame {
    
    public List productos;
    
    public FactTableModelSearch factModel;

    private Producto product;
    /** Creates new form BusquedaProduct */
    public SearchProduct() {
        super("Busqueda",true, true, true, true);
        initComponents();
        
        SwingUtilities.invokeLater(new Runnable() { 
          public void run(){
           textFieldSearch.requestFocus();
          }
            });
    }

   
     public void close(){
        try {
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(SearchProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    private void initComponents() {
        productos = new ArrayList<Producto>();
        jButton1 = new javax.swing.JButton();
        textFieldSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        factModel = new FactTableModelSearch();
        jTable1 = new javax.swing.JTable(factModel);
        jLabel1 = new javax.swing.JLabel();

        //jButton1.setText("Cerrar");
        
        //textFieldSearch.requestFocus();
        addInternalFrameListener(new InternalFrameAdapter() {
             public void internalFrameOpened(InternalFrameEvent e) {
                        textFieldSearch.requestFocus();
             }
        
        });
        textFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyEnterKey(evt);
            }
          
            
           
        });
        
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt){
               if( evt.getKeyChar() == '\n'){
                    setProduct((Producto) productos.get(jTable1.getSelectedRow()));
                    if(product != null){
                       close();
                    }else{
                    JOptionPane.showMessageDialog(null, "Por Favor Escoja un Producto");
                    
                    }
                   close();
               } 
            
            }
        
        }
                
                
                
                
                
                );
        
        this.addKeyListener(new KeyAdapter() {
            public void KeyPressed(KeyEvent evt){
            
                
            }
        
        });
                
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Buscar por Codigo o Descripcion:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addGap(14, 14, 14)
                        ))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldSearch)
                    )
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

private void searchKeyEnterKey(java.awt.event.KeyEvent evt) {
    ProductoDaoImpl productDao = new ProductoDaoImpl();
    productos = new ArrayList();
    if(!textFieldSearch.getText().equalsIgnoreCase("")){
    productos =   productDao.obtenerProductos(textFieldSearch.getText().toLowerCase());
     
    }
     
     factModel.refresh();
}


    public Producto getProduct() {
        return product;
    }

    public void setProduct(Producto product) {
        this.product = product;
    }

class FactTableModelSearch extends AbstractTableModel {
          String[] columnNames = {"Codigo",
                        "Descripcion",
                        "Existencias",
                        "Precio"};
          
     public void refresh() {
          fireTableDataChanged();
     
     } 
          
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
            Producto product = (Producto) productos.get(rowIndex);
            switch(columnIndex){
                case 0:
                    return product.getId();
                case 1:
                    return product.getDescripcion();
                case 2:
                    return product.getExistencias();
                case 3:
                    return product.getPrecioUnitario();
                    
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
                 return Double.class;
                default:
                 return null;
   }

        }
         
        
        
      
        
        
        
}




    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textFieldSearch;
    // End of variables declaration

}
