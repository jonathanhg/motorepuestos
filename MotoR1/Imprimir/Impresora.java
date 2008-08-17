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
    int interlineado = 11;
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
        ArrayList<String> texto = new ArrayList<String>();
        int total;
        texto.add("       MOTO REPUESTOS SAN PEDRO");
        texto.add("            XINIA CASTILLO HIDALGO");
        texto.add("                   Cedula: 1-602-294");
        texto.add("B. SAPRISSA; SN PEDRO MONT. DE OCA");
        texto.add("400NE S. TACHO");
        texto.add("TELEFONO:22340718");
        texto.add("______________________________________");
        texto.add("HORA: " + new Date().getHours() + ":" + new Date().getMinutes() + ":" + new Date().getSeconds() + "                       "+"No.FACTURA");
        texto.add("FECHA: " + factura.getFecha().getDate()+"/"+factura.getFecha().getMonth()+"/"+String.valueOf(factura.getFecha().getYear()).substring(1)+"                       "+factura.getId()+"");
        texto.add("CLIENTE: ");
        texto.add(factura.getCliente());
        texto.add("______________________________________");
        texto.add("CODIGO           CANTIDAD         TOTAL");
        while (iProductos.hasNext()) {
            prodTemp = (FactProduct) iProductos.next();
            texto.add(prodTemp.getId()+"              "+prodTemp.getCantidad()+"                 "+prodTemp.getTotal());
            String descripcion;if(prodTemp.getDescripcion().length()>23){ descripcion = prodTemp.getDescripcion().substring(0,22);}else{descripcion = prodTemp.getDescripcion();}
            texto.add(descripcion+"  (Precio ¢"+prodTemp.getPrecio()+")");
        }
        texto.add("______________________________________");
        texto.add("TOTAL ¢ "+factura.getTotal());
        texto.add("______________________________________");
        texto.add("              Impuesto de ventas incluido");
        if(factura.getIs_anulado()==true){texto.add("           -EXONERADO DEL IMPUESTO DE VENTAS-");}       
        texto.add("AUTORIZADO MEDIANTE OFICIO NUMERO");
        texto.add("01-0308-8 DEL 05-D9-1997   D.G.T.D");
        texto.add("             WWW.MRSANPEDRO.COM");

        return texto.listIterator();
    }
}
