
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.FactProduct;
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
        
        List<FactProduct> productos = new ArrayList<FactProduct>();
        
        Producto producto = new Producto();
        producto.setId("llanta");
        producto.setDescripcion("llanta moto");
        producto.setExistencias(100);
        FactProduct product1 = new FactProduct();
        
        product1.setId(producto.getId());
        product1.setDescripcion(producto.getDescripcion());
        product1.setCantidad(10);
        producto.setExistencias(producto.getExistencias()-10);
        productos.add(product1);
        
        fact1.setProductos(productos);
        
        
        fact.agregarFactura(fact1);
    }

}
