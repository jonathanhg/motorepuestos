
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.Producto;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luisj
 */
public class chrge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        daoHibernateImpl.FacturaDaoImpl fact = new daoHibernateImpl.FacturaDaoImpl();
        model.Factura fact1 = new model.Factura();
        
        fact1.setPrecio(99999);
        
        List<Producto> productos = new ArrayList<Producto>();
        
        Producto product1 = new Producto();
        
        productos.add(product1);
        
        fact1.setProductos(productos);
        
        fact1.setProductos(productos);
        
        fact.agregarFactura(fact1);
    }

}
