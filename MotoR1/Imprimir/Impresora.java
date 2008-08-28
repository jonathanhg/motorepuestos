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
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import model.FactProduct;
import model.Factura;
import model.Producto;
import Settings.Configuracion;

public class Impresora {

    Configuracion configuracion = new Configuracion();
    int margenSup = configuracion.getMargenSup();
    int margenIzq = configuracion.getMargenIzq();
    int tamLetra = configuracion.getTamLetra();
    int interlineado = configuracion.getInterlineado();
    Font fuente = configuracion.getFuente();
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
        int maxDesc= configuracion.getMaxDesc();
        Calendar fechaSistema = Calendar.getInstance();
        int mes = fechaSistema.get(Calendar.MONTH) + 1;
        String amPm = "a.m.";if (fechaSistema.get(Calendar.AM_PM) == 1) {amPm = "p.m.";}
        Iterator iProductos = factura.getProductos().iterator();
        FactProduct prodTemp = new FactProduct();
        ArrayList<String> texto = new ArrayList<String>();
        int total;
        texto.add("       " + configuracion.getNombreEmpresa());
        texto.add("            " + configuracion.getNombreDuenio());
        texto.add("                   Cedula: " + configuracion.getCedulaDuenio());
        texto.add(configuracion.getDireccion1());
        texto.add(configuracion.getDireccion2());
        if (factura.getId() == 0) {texto.add("                        **PROFORMA**");}
        texto.add("TELEFONO: "+configuracion.getTelefono());
        texto.add("______________________________________");
        texto.add("HORA: " + fechaSistema.get(Calendar.HOUR) + ":" + fechaSistema.get(Calendar.MINUTE) + " " + amPm + "                    " + "No.FACTURA");
        texto.add("FECHA: " + fechaSistema.get(Calendar.DAY_OF_MONTH) + "/" + mes + "/" + fechaSistema.get(Calendar.YEAR) + "                   " + factura.getId() + "");
        texto.add("CLIENTE: ");
        texto.add(factura.getCliente());
        texto.add("______________________________________");
        texto.add("CODIGO            DESCRIPCION         ");
        while (iProductos.hasNext()) {
            prodTemp = (FactProduct) iProductos.next();
            texto.add(prodTemp.getId() + "        " + prodTemp.getDescripcion());
            texto.add("¢"+prodTemp.getPrecio()+" x "+prodTemp.getCantidad()+" = "+prodTemp.getTotal());
        }
        texto.add("______________________________________");
        texto.add("TOTAL ¢ " + factura.getTotal());
        texto.add("______________________________________");
        texto.add("              Impuesto de Ventas Incluido");
        if (factura.isSin_impuesto() == true) {texto.add(" *EXONERADO DEL IMPUESTO DE VENTAS*");        }
        if (factura.getId() != 0) {
        texto.add("AUTORIZADO MEDIANTE OFICIO NUMERO");
        texto.add(configuracion.getNmroAutorizado());    
        }
        texto.add("             " + configuracion.getPaginaWeb());

        return texto.listIterator();
    }
}
