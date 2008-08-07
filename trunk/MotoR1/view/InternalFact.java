package view;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import boImpl.FacturaBoImpl;
import daoHibernateImpl.FacturaDaoImpl;
import javax.swing.GroupLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import model.Factura;
/**
 *
 * @author Administrator
 */
public class InternalFact extends JInternalFrame {

    public JTable tableProduct;
    
    private FacturaBoImpl factBo;
    
    public InternalFact (Factura factura){
     factBo = new FacturaBoImpl();
     int idFact = 0;
        if(factura == null){
           factura = new Factura();
         
             idFact   =  factBo.save(factura);
          
        
       }
       tableProduct = new JTable(new FactTableModel() );
        
       JScrollPane scrollPane = new JScrollPane(tableProduct);
        //tableProduct.setFillsViewportHeight(true);
       JTextField fieldId = new JTextField(Integer.toString(idFact));
       fieldId.setEditable(false);
       fieldId.setSize(20,20);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
            .addComponent(fieldId)   
            .addComponent(scrollPane)
             
         );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addComponent(fieldId) 
                .addComponent(scrollPane)
                 
                );
        
    }
    
    class FactTableModel extends AbstractTableModel{
          String[] columnNames = {"Codigo",
                        "Descripcion",
                        "Cantidad",
                        "Precio"};
          
          private Object[][] data = {
            {"lala", "lala",
            "lala", "lala", "lala"}
        };
          
        public int getRowCount() {
           return data.length;
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }
        
         public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
         
        public boolean isCellEditable(int row, int col) {
          
            if (col == 0) {
                return true;
            }
            if (col == 2) {
                return true;
            }
            return false;
    }
        
        public void setValueAt(Object value, int row, int col) {
           
           if (data[row][col] != value){
            data[row][col] = value;
            for (int i = 1 ; i<columnNames.length;i++){
            data[row][i] = "Generada" ;
            
            }
            fireTableDataChanged();
            }
          
            
            

           
        }
        
}
    
}

