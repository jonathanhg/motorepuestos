package test;


import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import model.Producto;

import Reportes.ModuloFacturacion;
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
        product1.setId("Yamaha09");
        product1.setDescripcion("Casco de moto");
        product1.setFecha(new Date());
        product1.setExistencias(24);
        product1.setMinimos(6);
        product1.setPrecio(7890);
        
        Producto product2 = new Producto();
        product2.setId("Kawasaky85");
        product2.setDescripcion("Candelar");
        product2.setFecha(new Date());
        product2.setExistencias(30);
        product2.setMinimos(10);
        product2.setPrecio(9500);
        
        productos.add(product1);
        productos.add(product2);
        
        fact1.setCliente("jon");
        fact1.setProductos(productos);
        fact1.setFecha(new Date());       
        
        fact.agregarFactura(fact1);
     
       ModuloFacturacion prueba = new ModuloFacturacion();
       prueba.facturasPorCliente("jon");
    }

}
