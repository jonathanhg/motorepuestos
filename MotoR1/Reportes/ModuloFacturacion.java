/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import daoHibernateImpl.FacturaDaoImpl;
import model.Factura;

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
public class ModuloFacturacion {

    public void facturasPorFecha(int anioDesde, int anioHasta, int mesDesde, int mesHasta) {
        FacturaDaoImpl factura = new FacturaDaoImpl();
        List factList = factura.facturasPorFecha(anioDesde, anioHasta, mesDesde, mesHasta);
        Iterator itFact = factList.iterator();
        Factura factTemp;

        try {
            //Se crea el libro Excel
            WritableWorkbook workbook = Workbook.createWorkbook(new File("FacturasPorFecha.xls"));

            //Se crea una nueva hoja dentro del libro
            WritableSheet sheet = workbook.createSheet("Facturas_por_fecha", 0);

            //Creamos una celda de tipo fecha y la mostramos
            //indicando un patron de formato
            DateFormat customDateFormat = new DateFormat("d/m/yy h:mm");

            WritableCellFormat dateFormat = new WritableCellFormat(customDateFormat);

            //Creamos celdas de varios tipos
            sheet.addCell(new jxl.write.Label(2, 0, "REPORTE DE FACTURAS POR FECHA")); //(columna+1) & (fila+1) & (dato)
            sheet.addCell(new jxl.write.Label(0, 3, "CODIGO DE FACTURA"));
            sheet.addCell(new jxl.write.Label(1, 3, "¿Anulada?"));
            sheet.addCell(new jxl.write.Label(2, 3, "FECHA"));
            sheet.addCell(new jxl.write.Label(3, 3, "CLIENTE"));
            sheet.addCell(new jxl.write.Label(4, 3, "PRODUCTOS"));
            sheet.addCell(new jxl.write.Label(5, 3, "PRECIO"));
            sheet.addCell(new jxl.write.Label(6, 3, "TOTAL"));

            int fila = 4;
            for (int i = 0; itFact.hasNext(); i++) {
                factTemp = (Factura) itFact.next();
                                
                //Genera los datos de las filas para la columna Codigo de Factura
                sheet.addCell(new jxl.write.Label(0, fila, factTemp.getCodigo()));

                //Genera los datos de las filas para la columna Estado
                sheet.addCell(new jxl.write.Boolean(1, fila, factTemp.getIs_anulado()));

                //Genera los datos de las filas para la columna Fecha
                sheet.addCell(new jxl.write.DateTime(2, fila, factTemp.getFecha(), dateFormat));

                //Genera los datos de las filas para la columna Cliente
                sheet.addCell(new jxl.write.Label(3, fila, factTemp.getCliente()));

                //Genera los datos de las filas para la columna Productos
                Producto prodTemp = new Producto();
                List productos = factTemp.getProductos();
                Iterator itProd = productos.iterator();
                while (itProd.hasNext()) {
                    prodTemp = (Producto) itProd.next();
                    sheet.addCell(new jxl.write.Label(4, fila++, prodTemp.getDescripcion()));
                    sheet.addCell(new jxl.write.Number(5, fila, prodTemp.getPrecio())); // cómo hago --> cantidad comprada * precio unitario?
                }

                //Genera los datos de las filas para la columna Total
                sheet.addCell(new jxl.write.Number(6, fila, factTemp.getTotal()));

                sheet.addCell(new jxl.write.Label(3, fila, "----------------------------------"));
                
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

    public void facturasPorCliente() {
    }

    public void facturasAnuladasPorFecha() {
    }
}