/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Reportes;
import java.io.*;
import dao.ProveedoresDao;
import java.util.List;
import model.Proveedores;
import org.hibernate.Session;
import util.HibernateUtil;
import org.hibernate.Query;
import daoHibernateImpl.ProveedorDaoImpl;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import jxl.write.WriteException;
import model.Producto;
import model.Proveedores;

/**
 *
 * @author Administrador
 */
public class ModuloProveedores {
      private String rutaDeGuardado ="\\ReportesMRSP\\";
public void productosPorProveedor(String idProveedor){
    ProveedorDaoImpl proveedorManager = new ProveedorDaoImpl();
    List listaProductos = proveedorManager.productosPorProveedor(idProveedor);
    Iterator itProductos = listaProductos.iterator();
    crearExcelProductos(itProductos, "ProductosPorProveedor.xls", "Productos_por_proveedor", "REPORTE DE PRODUCTOS PARA EL PROVEEDOR: "+idProveedor);
}

public void proveedoresRegistrados(){
    ProveedorDaoImpl proveedorManager = new ProveedorDaoImpl();
    List listaProveedores = proveedorManager.obtenerProveedores();
    Iterator itProveedores = listaProveedores.iterator();
    crearExcelProveedores(itProveedores, "ProveedoresRegistrados.xls", "Proveedores", "REPORTE DE PROVEEDORES");
}

    
    private void crearExcelProductos(Iterator itProd, String nombreArchivo, String nombreHoja, String nombreReporte) {
        Producto prodTemp;

        try {
            //Se crea el libro Excel
            WritableWorkbook workbook = Workbook.createWorkbook(new File(rutaDeGuardado+nombreArchivo));

            //Se crea una nueva hoja dentro del libro
            WritableSheet sheet = workbook.createSheet(nombreHoja, 0);

            //Creamos celdas de los titulos
            sheet.addCell(new jxl.write.Label(2, 0, nombreReporte)); //(columna+1) & (fila+1) & (dato)

            sheet.addCell(new jxl.write.Label(0, 3, "CODIGO DE PRODUCTO"));
            sheet.addCell(new jxl.write.Label(1, 3, "DESCRIPCION"));
            sheet.addCell(new jxl.write.Label(2, 3, "EXISTENCIAS")); 

            int fila = 4;
            for (int i = 0; itProd.hasNext(); i++) {
                prodTemp = (Producto) itProd.next();

                //Genera los datos de las filas para la columna Codigo de Producto
                sheet.addCell(new jxl.write.Label(0, fila, prodTemp.getId()));

                //Genera los datos de las filas para la columna Descripcion
                sheet.addCell(new jxl.write.Label(1, fila, prodTemp.getDescripcion()));

                //Genera los datos de las filas para la columna cantidad vendidas
                sheet.addCell(new jxl.write.Number(2, fila, prodTemp.getExistencias()));

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
    
     private void crearExcelProveedores(Iterator itProv, String nombreArchivo, String nombreHoja, String nombreReporte) {
        Proveedores provTemp;

        try {
            //Se crea el libro Excel
            WritableWorkbook workbook = Workbook.createWorkbook(new File(nombreArchivo));

            //Se crea una nueva hoja dentro del libro
            WritableSheet sheet = workbook.createSheet(nombreHoja, 0);

            //Creamos celdas de los titulos
            sheet.addCell(new jxl.write.Label(2, 0, nombreReporte)); //(columna+1) & (fila+1) & (dato)

            sheet.addCell(new jxl.write.Label(0, 3, "ID DE PROVEEDOR"));
            sheet.addCell(new jxl.write.Label(1, 3, "NOMBRE"));
            sheet.addCell(new jxl.write.Label(2, 3, "DIRECCION")); 
            sheet.addCell(new jxl.write.Label(3, 3, "TIPO CREDITO")); 

            int fila = 4;
            for (int i = 0; itProv.hasNext(); i++) {
                provTemp = (Proveedores) itProv.next();

                //Genera los datos de las filas para la columna Codigo de Producto
                sheet.addCell(new jxl.write.Label(0, fila, provTemp.getId()));

                //Genera los datos de las filas para la columna Descripcion
                sheet.addCell(new jxl.write.Label(1, fila, provTemp.getNombre()));

                //Genera los datos de las filas para la columna cantidad vendidas
                sheet.addCell(new jxl.write.Label(2, fila, provTemp.getDireccion()));

                //Genera los datos de las filas para la columna tipo credito
                sheet.addCell(new jxl.write.Label(3, fila, provTemp.getTipoCredito()));
                fila++;
            }

            //Escribimos los resultados al fichero Excel
            workbook.write();
            workbook.close();


            System.out.println("Creacion del reporte finalizado.");
        } catch (IOException ex) {
            //System.out.println("Error al crear el fichero.");
            JOptionPane.showMessageDialog(null,"Error al crear el fichero.\n Posible causa:\n No se encuentra el directorio: "+rutaDeGuardado+" en la raíz (ejm C:/)");
        } catch (WriteException ex) {
            System.out.println("Error al escribir el fichero.");
        }
    }
}
