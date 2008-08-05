package view;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.swing.GroupLayout;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class InternalFact extends JInternalFrame {

        public JTable tableProduct;
    
    public InternalFact (){
       
       tableProduct = new JTable(new FactTableModel() );
        
       JScrollPane scrollPane = new JScrollPane(tableProduct);
        //tableProduct.setFillsViewportHeight(true);
       
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
            .addComponent(scrollPane)
                
         );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
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

