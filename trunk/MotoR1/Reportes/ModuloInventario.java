/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import daoHibernateImpl.ProductoDaoImpl;
import java.io.*;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import jxl.*;
import jxl.write.*;
import model.Producto;

/**
 *
 * @author Administrador
 */
public class ModuloInventario {

    public void reporteInventario() {
        ProductoDaoImpl producto = new ProductoDaoImpl();
        List prodList = producto.obtenerProductos();
        Iterator itProd = prodList.iterator();
        crearExcel(itProd, "ReporteDeInventario.xls", "Inventario", "REPORTE DE INVENTARIO");
    }

    public void reporteMinimos() { //productos donde (existencias <= minimo)
    ProductoDaoImpl producto = new ProductoDaoImpl();
        List prodList = producto.obtenerMinimos();
        Iterator itProd = prodList.iterator();
        crearExcel(itProd, "ReporteDeMinimos.xls", "Minimos", "REPORTE DE MINIMOS");
    }

    private void crearExcel(Iterator itProd, String nombreArchivo, String nombreHoja, String nombreReporte) {
        Producto prodTemp;

        try {
            //Se crea el libro Excel
            WritableWorkbook workbook = Workbook.createWorkbook(new File(nombreArchivo));

            //Se crea una nueva hoja dentro del libro
            WritableSheet sheet = workbook.createSheet(nombreHoja, 0);

            //Creamos celdas de los titulos
            sheet.addCell(new jxl.write.Label(2, 0, nombreReporte)); //(columna+1) & (fila+1) & (dato)

            sheet.addCell(new jxl.write.Label(0, 3, "CODIGO DE PRODUCTO"));
            sheet.addCell(new jxl.write.Label(1, 3, "DESCRIPCION"));
            sheet.addCell(new jxl.write.Label(2, 3, "MINIMO"));
            sheet.addCell(new jxl.write.Label(3, 3, "EXISTENCIAS"));
            sheet.addCell(new jxl.write.Label(4, 3, "PRECIO UNITARIO"));
            sheet.addCell(new jxl.write.Label(5, 3, "PROVEEDOR"));

            int fila = 4;
            for (int i = 0; itProd.hasNext(); i++) {
                prodTemp = (Producto) itProd.next();

                //Genera los datos de las filas para la columna Codigo de Producto
                sheet.addCell(new jxl.write.Label(0, fila, prodTemp.getId()));

                //Genera los datos de las filas para la columna Descripcion
                sheet.addCell(new jxl.write.Label(1, fila, prodTemp.getDescripcion()));

                //Genera los datos de las filas para la columna Minimos
                sheet.addCell(new jxl.write.Number(2, fila, prodTemp.getMinimos()));

                //Genera los datos de las filas para la columna Existencias
                sheet.addCell(new jxl.write.Number(3, fila, prodTemp.getExistencias()));
                
                //Genera los datos de las filas para la columna Cliente
                sheet.addCell(new jxl.write.Number(4, fila, prodTemp.getPrecioUnitario()));

                //Genera los datos de las filas para la columna Descripcion
                sheet.addCell(new jxl.write.Label(5, fila, prodTemp.getIdProveedor()));
                
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
