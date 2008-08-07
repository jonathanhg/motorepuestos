/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imprimir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import model.FactProduct;
import model.Factura;
import model.Producto;

public class Impresora {

    int margenSup = 15;
    int margenIzq = 30;
    int tamLetra = 9;
    int interlineado = 10;
    Font fuente = new Font("Dialog", Font.PLAIN, tamLetra);
    PrintJob pj;
    Graphics pagina;

    public Impresora() {
        pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
    }

    public void imprimir(Factura factura) {
        Iterator iTexto = getTexto(factura);
        try {
            pagina = pj.getGraphics();
            pagina.setFont(fuente);
            pagina.setColor(Color.black);
            int espacio = 5;

            while (iTexto.hasNext()) {
                pagina.drawString((String) iTexto.next(), margenIzq, margenSup + espacio);
                espacio += interlineado;
            }

            pagina.dispose();
            pj.end();
        } catch (Exception e) {
            System.out.println("LA IMPRESION HA SIDO CANCELADA...");
        }
    }

    private Iterator getTexto(Factura factura) {
        Iterator iProductos = factura.getProductos().iterator();
        FactProduct prodTemp = new FactProduct();
        ArrayList texto = new ArrayList();
        int total;
        texto.add("     MOTO REPUESTOS SAN PEDRO");
        texto.add("      XINIA CASTILLO HIDALGO");
        texto.add("         Cedula: 1-602-294");
        texto.add("B. SAPRISSA; SN PEDRO MONT. DE OCA");
        texto.add("400NE S. TACHO");
        texto.add("TELEFONO:22340718");
        texto.add("______________________________________");
        texto.add("No.FACTURA: " + factura.getId());
        texto.add("HORA: " + new Date().getHours() + ":" + new Date().getMinutes() + ":" + new Date().getSeconds());
        texto.add("FECHA: " + factura.getFecha());
        texto.add("CLIENTE: ");
        texto.add(factura.getCliente());
        texto.add("______________________________________");
        texto.add("CODIGO    CANTIDAD    PRECIO     TOTAL");
        while (iProductos.hasNext()) {
            prodTemp = (FactProduct) iProductos.next();
            texto.add("P6995       1          4100      4100");
            texto.add(prodTemp.getId()+"          "+prodTemp.getCantidad()+"           "+prodTemp.getPrecio());
            texto.add(prodTemp.getDescripcion()+"                                "+prodTemp.getSubtotal());
        }
        texto.add("______________________________________");
        texto.add("TOTAL ¢                         "+factura.getTotal());
        texto.add("______________________________________");
        texto.add("Impuesto de venta incluido");
        texto.add("AUTORIZADO MEDIANTE OFICIO NUMERO");
        texto.add("01-0308-8 DEL 05-D9-1997   D.G.T");
        texto.add("          WWW.MRSANPEDRO.COM");

        return texto.listIterator();
    }
}