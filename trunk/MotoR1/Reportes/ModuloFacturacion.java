/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import daoHibernateImpl.FacturaDaoImpl;
import model.Factura;

import java.io.*;
import java.util.Date;
//import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jxl.*;
import jxl.write.*;
import model.FactProduct;
import model.Producto;

/**
 *
 * @author Administrador
 */
public class ModuloFacturacion {

    public void facturaPorCodigo(int codigoFactura) {
        FacturaDaoImpl facturaManager = new FacturaDaoImpl();
        Factura factura = facturaManager.facturaPorCodigo(codigoFactura);
        List<Factura> factList = new ArrayList<Factura>();
        factList.add(factura);
        Iterator itFact = factList.iterator();
        crearExcel(itFact, "FacturaPorCodigo.xls", "Factura_por_codigo", "REPORTE DE FACTURA POR CODIGO");
    }

    public void facturasPorFecha(int anioDesde, int anioHasta, int mesDesde, int mesHasta) {
        FacturaDaoImpl factura = new FacturaDaoImpl();
        List factList = factura.facturasPorFecha(anioDesde, anioHasta, mesDesde, mesHasta);
        Iterator itFact = factList.iterator();
        crearExcel(itFact, "FacturasPorFecha.xls", "Facturas_por_fecha", "REPORTE DE FACTURAS POR FECHA");
    }

    public void facturasPorCliente(String nombreCliente) {
        FacturaDaoImpl factura = new FacturaDaoImpl();
        List factList = factura.facturasPorCliente(nombreCliente);
        Iterator itFact = factList.iterator();
        crearExcel(itFact, "FacturasPorCliente.xls", "Facturas_por_cliente", "REPORTE DE FACTURAS POR CLIENTE");
    }

    public void facturasPorMes(int mes) {
        FacturaDaoImpl factura = new FacturaDaoImpl();
        List factList = factura.facturasPorMes(mes);
        Iterator itFact = factList.iterator();
        crearExcel(itFact, "FacturasPorMes.xls", "Facturas_por_mes", "REPORTE DE FACTURAS POR MES");
    }
    
    public void facturasAnuladasPorMes(int mes) {
        FacturaDaoImpl factura = new FacturaDaoImpl();
        List factList = factura.facturasAnuladasPorMes(mes);
        Iterator itFact = factList.iterator();
        crearExcel(itFact, "FacturasAnuladasPorMes.xls", "Facturas_anuladas_por_mes", "REPORTE DE FACTURAS ANULADAS POR MES");
    }

    private void crearExcel(Iterator itFact, String nombreArchivo, String nombreHoja, String nombreReporte) {
        Factura factTemp;

        try {
            //Se crea el libro Excel
            WritableWorkbook workbook = Workbook.createWorkbook(new File(nombreArchivo));

            //Se crea una nueva hoja dentro del libro
            WritableSheet sheet = workbook.createSheet(nombreHoja, 0);

            //Creamos una celda de tipo fecha y la mostramos
            //indicando un patron de formato
            DateFormat customDateFormat = new DateFormat("d/m/yy h:mm");

            WritableCellFormat dateFormat = new WritableCellFormat(customDateFormat);
            //Creamos celdas de los titulos
            sheet.addCell(new jxl.write.Label(2, 0, nombreReporte)); //(columna+1) & (fila+1) & (dato)
            sheet.addCell(new jxl.write.Label(0, 1, "Fecha de creacion:"));
            sheet.addCell(new jxl.write.DateTime(1, 1, new Date(), dateFormat));
            
            sheet.addCell(new jxl.write.Label(0, 3, "CODIGO DE FACTURA"));
            sheet.addCell(new jxl.write.Label(1, 3, "¿Anulada?"));
            sheet.addCell(new jxl.write.Label(2, 3, "FECHA"));
            sheet.addCell(new jxl.write.Label(3, 3, "CLIENTE"));
            sheet.addCell(new jxl.write.Label(4, 3, "PRODUCTOS"));
            sheet.addCell(new jxl.write.Label(5, 3, "CANTIDAD"));
            sheet.addCell(new jxl.write.Label(6, 3, "PRECIO UNITARIO"));
            sheet.addCell(new jxl.write.Label(7, 3, "SUBTOTAL"));
            sheet.addCell(new jxl.write.Label(8, 3, "TOTAL"));

            double montoTotal = 0.0;

            int fila = 4;
            for (int i = 0; itFact.hasNext(); i++) {
                factTemp = (Factura) itFact.next();

                //Genera los datos de las filas para la columna Codigo de Factura
                sheet.addCell(new jxl.write.Number(0, fila, factTemp.getId()));

                //Genera los datos de las filas para la columna Estado
                sheet.addCell(new jxl.write.Boolean(1, fila, factTemp.getIs_anulado()));

                //Genera los datos de las filas para la columna Fecha
                sheet.addCell(new jxl.write.DateTime(2, fila, factTemp.getFecha(), dateFormat));

                //Genera los datos de las filas para la columna Cliente
                sheet.addCell(new jxl.write.Label(3, fila, factTemp.getCliente()));

                //Genera los datos de las filas para la columna Productos, cantidad y Descripcion,etc
                FactProduct prodTemp = new FactProduct();
                List productos = factTemp.getProductos();
                Iterator itProd = productos.iterator();
                while (itProd.hasNext()) {
                    prodTemp = (FactProduct) itProd.next();
                    sheet.addCell(new jxl.write.Number(5, fila, prodTemp.getCantidad())); 
                    sheet.addCell(new jxl.write.Number(6, fila, prodTemp.getPrecio())); 
                    sheet.addCell(new jxl.write.Number(7, fila,prodTemp.getSubtotal())); 
                    sheet.addCell(new jxl.write.Label(4, fila++, prodTemp.getDescripcion()));           
                }

                //Genera los datos de las filas para la columna Total
                sheet.addCell(new jxl.write.Number(8, fila++, factTemp.getTotal()));
                montoTotal +=factTemp.getTotal();
                
                sheet.addCell(new jxl.write.Label(0, fila++, "____________________________________________________________________"));
                
            }

            //Genera los datos para el monto total acumulado
            sheet.addCell(new jxl.write.Label(8, fila++, "SUMA TOTALES"));
            sheet.addCell(new jxl.write.Number(8, fila, montoTotal));

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
