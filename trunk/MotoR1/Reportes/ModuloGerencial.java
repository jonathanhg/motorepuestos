/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import daoHibernateImpl.FacturaDaoImpl;
import daoHibernateImpl.ProductoDaoImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import model.FactProduct;
import model.Factura;
import model.Producto;

import java.io.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import jxl.*;
import jxl.write.*;
import model.Producto;

/**
 *
 * @author Administrador
 */
class ProductoX {

    private String nombre;
    private String descripcion;
    private int cantVendidas;
    private int cantRotaciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantVendidas() {
        return cantVendidas;
    }

    public void setCantVendidas(int cantidad) {
        this.cantVendidas = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantRotaciones() {
        return cantRotaciones;
    }

    public void setCantRotaciones(int cantRotaciones) {
        this.cantRotaciones = cantRotaciones;
    }
}

public class ModuloGerencial {

    //producto con mayor o menor cantidad de ventas
    public void canditadVentasProducto(int mes) {
        List<ProductoX> listaProdX = new ArrayList<ProductoX>();
        List<ProductoX> listaContadaProdX = new ArrayList<ProductoX>();
        FacturaDaoImpl factManager = new FacturaDaoImpl();

        //obtenemos todas las facturas del mes indicado
        List facturas = factManager.facturasPorMes(mes);
        Iterator itFacturas = facturas.iterator();

        //llenamos a listaProdX con los productos vendidos en el mes indicado
        Factura factTemp;
        while (itFacturas.hasNext()) {
            factTemp = (Factura) itFacturas.next();
            ProductoX producto = new ProductoX();
            List<FactProduct> facProd = factTemp.getProductos();
            Iterator itProd = facProd.iterator();
            FactProduct factProductTemp;
            while (itProd.hasNext()) {
                factProductTemp = (FactProduct) itProd.next();
                producto.setNombre(factProductTemp.getId());
                producto.setDescripcion(factProductTemp.getDescripcion());
                producto.setCantVendidas(producto.getCantVendidas() + 1);
            }

            listaProdX.add(producto);
        }

        ProductoDaoImpl prodManager = new ProductoDaoImpl();

        //llenamos a prodOriginales con todos los productos del inventario
        List prodOriginales = prodManager.obtenerProductos();
        Iterator itProdOriginales = prodOriginales.iterator();
        Producto prodTemp;
        while (itProdOriginales.hasNext()) {
            ProductoX producto = new ProductoX();
            prodTemp = (Producto) itProdOriginales.next();
            producto.setNombre(prodTemp.getId());
            producto.setDescripcion(prodTemp.getDescripcion());
            producto.setCantVendidas(this.vecesRepetido(listaProdX, prodTemp.getId()));
            listaContadaProdX.add(producto);
        }
        crearExcel(listaContadaProdX.iterator(), "CantidadVentasProducto.xls", "CantidadVentasProducto", "PRODUCTOS VENDIDOS EN EL MES: " + mes + " DEL AÑO " + (new Date().getYear()) + 1900);

    }

//productos con mayor o menor rotación
    public void cantidadRotacionProducto() {
    }

    //retorna el número de veces que se repite un codigo en la lista
    private int vecesRepetido(List<ProductoX> listaProdX, String nombreProducto) {
        int result = 0;
        for (int i = 0; i < listaProdX.size(); i++) {
            if (listaProdX.get(i).getNombre().equals(nombreProducto)) {
                result++;
            }
        }
        return result;
    }

    private void crearExcel(Iterator itProd, String nombreArchivo, String nombreHoja, String nombreReporte) {
        ProductoX prodTemp;

        try {
            //Se crea el libro Excel
            WritableWorkbook workbook = Workbook.createWorkbook(new File(nombreArchivo));

            //Se crea una nueva hoja dentro del libro
            WritableSheet sheet = workbook.createSheet(nombreHoja, 0);

            //Creamos celdas de los titulos
            sheet.addCell(new jxl.write.Label(2, 0, nombreReporte)); //(columna+1) & (fila+1) & (dato)

            sheet.addCell(new jxl.write.Label(0, 3, "CODIGO DE PRODUCTO"));
            sheet.addCell(new jxl.write.Label(1, 3, "DESCRIPCION"));
            sheet.addCell(new jxl.write.Label(2, 3, "CANTIDAD VENDIDA")); //minimo

            int fila = 4;
            for (int i = 0; itProd.hasNext(); i++) {
                prodTemp = (ProductoX) itProd.next();

                //Genera los datos de las filas para la columna Codigo de Producto
                sheet.addCell(new jxl.write.Label(0, fila, prodTemp.getNombre()));

                //Genera los datos de las filas para la columna Descripcion
                sheet.addCell(new jxl.write.Label(1, fila, prodTemp.getDescripcion()));

                //Genera los datos de las filas para la columna cantidad vendidas
                sheet.addCell(new jxl.write.Number(2, fila, prodTemp.getCantVendidas()));

                fila++;
            }

            //Escribimos los resultados al fichero Excel
            workbook.write();
            workbook.close();


            System.out.println("Creacion del reporte finalizado.");
        } catch (IOException ex) {
            System.out.println("Error al crear el fichero.");
        } catch (WriteException ex) {
            System.out.println("Error al escribir el fichero.");
        }
    }
}
