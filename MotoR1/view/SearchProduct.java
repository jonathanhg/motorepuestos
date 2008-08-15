package view;

import daoHibernateImpl.ProductoDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Producto;

/**
 *
 * @author  luisj
 */
public class SearchProduct extends javax.swing.JInternalFrame {
    
    public List productos;
    
    public FactTableModelSearch factModel;

    /** Creates new form BusquedaProduct */
    public SearchProduct() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
  
    private void initComponents() {
        productos = new ArrayList<Producto>();
        jButton1 = new javax.swing.JButton();
        textFieldSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        factModel = new FactTableModelSearch();
        jTable1 = new javax.swing.JTable(factModel);
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("Buscar");

        textFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyEnterKey(evt);
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
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldSearch)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

private void textFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {

}


    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textFieldSearch;
    // End of variables declaration

}
