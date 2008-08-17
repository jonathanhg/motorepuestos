package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import model.Producto;
import Imprimir.Impresora;

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

        fact1.setPrecio(1234);

        ProductoDaoImpl prodManager = new ProductoDaoImpl();
        List<FactProduct> factProduct = new ArrayList<FactProduct>();

        Producto producto1 = new Producto();
        producto1.setId("R428RH132");
        producto1.setDescripcion("ACEITE MOTUL ESTAN. 510");
        producto1.setFechaIngreso(new Date());
        producto1.setExistencias(24);
        producto1.setMinimos(6);
        producto1.setPrecioUnitario(567);

        Producto producto2 = new Producto();
        producto2.setId("Kawasaky85");
        producto2.setDescripcion("RAYOS DT175 MONO DT2001R(TRASEROS) DISPAREJOS");
        producto2.setFechaIngreso(new Date());
        producto2.setExistencias(9);
        producto2.setMinimos(10);
        producto2.setPrecioUnitario(8910);


        FactProduct prodFact = new FactProduct();
        prodFact.setId(producto1.getId());
        prodFact.setDescripcion(producto1.getDescripcion());
        prodFact.setPrecio(producto1.getPrecioUnitario());
        prodFact.setCantidad(4);
        prodFact.setTotal(producto1.getPrecioUnitario() * prodFact.getCantidad());
        producto1.setExistencias(producto1.getExistencias() - prodFact.getCantidad());

         FactProduct prodFact2 = new FactProduct();
        prodFact2.setId(producto2.getId());
        prodFact2.setDescripcion(producto2.getDescripcion());
        prodFact2.setPrecio(producto2.getPrecioUnitario());
        prodFact2.setCantidad(2);
        prodFact2.setTotal(producto2.getPrecioUnitario() * prodFact.getCantidad());
        producto1.setExistencias(producto2.getExistencias() - prodFact.getCantidad());
        
        prodManager.agregarProducto(producto1);
        prodManager.agregarProducto(producto2);

        factProduct.add(prodFact);
        factProduct.add(prodFact2);

        //productos.add(producto2);

        fact1.setCliente("jon");
        fact1.setProductos(factProduct);
        fact1.setFecha(new Date());
        fact1.setTotal(prodFact.getTotal()+prodFact2.getTotal());

        fact.agregarFactura(fact1);
        

        ModuloFacturacion prueba = new ModuloFacturacion();
        prueba.facturasPorCliente("jon");

//        ModuloInventario prueba2 = new ModuloInventario();
//        prueba2.reporteInventario();
//        prueba2.reporteMinimos();

//          PRUEBA DE IMPRESION
        Impresora impresora = new Impresora();
        impresora.imprimir(fact1);

    }
}
