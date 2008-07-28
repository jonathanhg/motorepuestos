/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Reportes;

import java.io.*;
import java.util.Date;
import jxl.*;
import jxl.write.*;
/**
 *
 * @author Administrador
 */
public class ModuloInventario {

    
    public void reporteInventario(){
    try {
            //Se crea el libro Excel
            WritableWorkbook workbook =
                    Workbook.createWorkbook(new File("Inventario.xls"));

            //Se crea una nueva hoja dentro del libro
            WritableSheet sheet =
                    workbook.createSheet("Reporte_Inventario", 0);

            //Creamos celdas de varios tipos
            sheet.addCell(new jxl.write.Label(2, 0, "REPORTE DE INVENTARIO"));
            sheet.addCell(new jxl.write.Number(0, 0, 1));
            sheet.addCell(new jxl.write.Number(1, 0, 1.2));
            sheet.addCell(new jxl.write.Boolean(3, 0, true));

            //Creamos una celda de tipo fecha y la mostramos
            //indicando un patÃ³n de formato
            DateFormat customDateFormat =
                    new DateFormat("d/m/yy h:mm");

            WritableCellFormat dateFormat =
                    new WritableCellFormat(customDateFormat);

            sheet.addCell(new jxl.write.DateTime(4, 0, new Date(), dateFormat));

            //Escribimos los resultados al fichero Excel
            workbook.write();
            workbook.close();



            System.out.println("Ejemplo finalizado.");
        } catch (IOException ex) {
            System.out.println("Error al crear el fichero.");
        } catch (WriteException ex) {
            System.out.println("Error al escribir el fichero.");
        }

    }
    public void reporteMinimovs(){}
}
