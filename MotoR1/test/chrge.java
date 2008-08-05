package test;


import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import model.Producto;

import Reportes.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import daoHibernateImpl.ProductoDaoImpl;
import model.FactProduct;

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
        
        ProductoDaoImpl prodManager = new ProductoDaoImpl();
        List<FactProduct> factProduct = new ArrayList<FactProduct>();
        
        Producto producto1 = new Producto();
        producto1.setId("Yamaha09");
        producto1.setDescripcion("Casco de moto");
        producto1.setFechaIngreso(new Date());
        producto1.setExistencias(24);
        producto1.setMinimos(6);
        producto1.setPrecioUnitario(7890);
        
        Producto producto2 = new Producto();
        producto2.setId("Kawasaky85");
        producto2.setDescripcion("Candelar");
        producto2.setFechaIngreso(new Date());
        producto2.setExistencias(9);
        producto2.setMinimos(10);
        producto2.setPrecioUnitario(9500);
        
        
        FactProduct prodFact = new FactProduct();
        prodFact.setId(producto1.getId());
        prodFact.setDescripcion(producto1.getDescripcion());
        prodFact.setPrecio(producto1.getPrecioUnitario());
        prodFact.setCantidad(4);
        prodFact.setSubtotal(producto1.getPrecioUnitario()*prodFact.getCantidad());
        producto1.setExistencias(producto1.getExistencias()-prodFact.getCantidad());
        
        prodManager.agregarProducto(producto1);
        prodManager.agregarProducto(producto2);
        
        factProduct.add(prodFact);
        
        //productos.add(producto2);
        
        fact1.setCliente("jon");
        fact1.setProductos(factProduct);
        fact1.setFecha(new Date()); 
        fact1.setTotal(123456789);
        
        fact.agregarFactura(fact1);
     
       ModuloFacturacion prueba = new ModuloFacturacion();
       prueba.facturasPorCliente("jon");
        
//        ModuloInventario prueba2 = new ModuloInventario();
//        prueba2.reporteInventario();
//        prueba2.reporteMinimos();
    }

}
