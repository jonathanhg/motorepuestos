/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boImpl;

import Imprimir.Impresora;
import bo.FacturaBo;
import daoHibernateImpl.FacturaDaoImpl;
import daoHibernateImpl.ProductoDaoImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.FactProduct;
import model.Factura;
import model.Producto;

/**
 *
 * @author luisj
 */
public class FacturaBoImpl implements FacturaBo {

    public FacturaDaoImpl dao;
    public ProductoDaoImpl daoProduct;

    public FacturaBoImpl() {
        dao = new FacturaDaoImpl();
        daoProduct = new ProductoDaoImpl();
    }

    public int save(Factura fact) {

        dao.agregarFactura(fact);
        Factura temp = fact;

        return fact.getId();
    }

    // GUARDA UNA FACTURA VERIFICA SI TODO ESTA BIEN CON INVENTARIO ! 
    public boolean saveFact(Factura fact, JInternalFrame jFrame) {
        FactProduct tempFactProduct;
        Producto temp;
        String mensaje = "";
        boolean todobien = true;
        fact.setProductos(borrarVacios(fact.getProductos()));
        Iterator tempIt = fact.getProductos().iterator();
        while (tempIt.hasNext()) {
            tempFactProduct = (FactProduct) tempIt.next();

            temp = daoProduct.obtenerProducto(tempFactProduct.getId());
            temp.setExistencias(temp.getExistencias() - tempFactProduct.getCantidad());

            if (temp.getExistencias() >= 0) {
                daoProduct.actualizarProducto(temp);

            }
            if (temp.getExistencias() < 0) {
                mensaje += "Error no hay existencias para el producto" + temp.getId() + " /n";
                todobien = false;
                JOptionPane.showMessageDialog(jFrame, mensaje);
            }

        }
        if (todobien) {
            dao.actualizarFactura(fact);
            Impresora impresora = new Impresora();
            impresora.imprimir(fact);
        }

        return todobien;
    }

    public List<FactProduct> borrarVacios(List<FactProduct> temp) {
        List<FactProduct> tempReturn = new ArrayList<FactProduct>();
        FactProduct tempFactProduct;
        for (int i = 0; i < temp.size(); i++) {
            tempFactProduct = (FactProduct) temp.get(i);
            if (tempFactProduct.getId() != null) {
                tempReturn.add(temp.get(i));

            }
        }
        return tempReturn;
    }
}
