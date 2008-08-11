package view;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import boImpl.FacturaBoImpl;
import daoHibernateImpl.FacturaDaoImpl;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import model.FactProduct;
import model.Factura;
import model.Producto;
/**
 *
 * @author Administrator
 */
public class InternalFact extends JInternalFrame {

    public JTable tableProduct;
    
    private FacturaBoImpl factBo;
    
    private List<FactProduct> productos;
    
    public InternalFact (Factura factura){
     factBo = new FacturaBoImpl();
     int idFact = 0;
        if(factura == null){
           factura = new Factura();
            productos = new ArrayList<FactProduct>();
             idFact   =  factBo.save(factura);
             FactProduct factNew = new FactProduct();
            productos.add(factNew);
            
       
       }
       tableProduct = new JTable(new FactTableModel() );
        //tableProduct.setRowSelectionInterval(0,0);
        //tableProduct.editCellAt(0, 0);
       // selecciona el Row de la tabla para empezar a ingresar productos con el invokeLater hace un
       //delay para que los otros focus de la tabla esten completos y no tengan conflictos
       SwingUtilities.invokeLater(new Runnable() { 
          public void run(){
            tableProduct.requestFocusInWindow();
            tableProduct.changeSelection(0, 0, false, false);
          }
            });

       JScrollPane scrollPane = new JScrollPane(tableProduct);
        //tableProduct.setFillsViewportHeight(true);
       JTextField fieldId = new JTextField(Integer.toString(idFact));
       fieldId.setEditable(false);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
           .addComponent(fieldId)
           .addComponent(scrollPane))

             
         );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addComponent(fieldId) 
               
                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                 .addComponent(scrollPane))

                );
        
    }
    
    
    class FactTableModel extends AbstractTableModel {
          String[] columnNames = {"Codigo",
                        "Descripcion",
                        "Cantidad",
                        "Precio"};
          
      
          
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
            default:
             return false;
         }

    }
        
        public void setValueAt(Object value, int row, int col) {
            FactProduct product =  productos.get(row);
             switch (col) {
                case 0: //Id
                 product.setId(value.toString());
                 break;
                case 1: //descripcion
                    
                 break;
                case 2: //cantidad
                 product.setCantidad(Integer.valueOf(value.toString()));
                 break;
                case 3: //precio
                 
                 break;
                 
               }
               
                     FactProduct productEmpty = new FactProduct();
                     productos.add(productEmpty);
                     tableProduct.addKeyListener(
                             new KeyAdapter() {
                             public void keyTyped(KeyEvent e){
                                 if( e.getKeyChar() == 'd'){
                                   Integer i = tableProduct.getSelectedRow();
                                    JOptionPane.showMessageDialog(null, "aasd"+productos.size());
                                   productos.remove(i);
                                   JOptionPane.showMessageDialog(null, "aasd"+i.toString());
                                   
                                 }
                             }
                     
                     }
                             
                             );
                            
                     fireTableDataChanged();
            
          
            
            

           
        }

      
        
        
        
}
    
}

