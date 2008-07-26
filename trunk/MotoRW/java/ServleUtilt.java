/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import daoHibernateImpl.ComprasDaoImpl;
import daoHibernateImpl.FacturaDaoImpl;
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Compras;
import model.Factura;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author luisj
 */
public class ServleUtilt extends HttpServlet {

    public JFreeChart crearChart(int anio, int mes) {

        FacturaDaoImpl factura = new FacturaDaoImpl();
        ComprasDaoImpl compras = new ComprasDaoImpl();

        List factList = factura.facturasPorAnio(anio);
        List comprasList = compras.ComprasPorAnio(anio);

        DefaultCategoryDataset utilidadDataSet = new DefaultCategoryDataset();

        Iterator itFact = factList.iterator();
        Iterator itCompra = comprasList.iterator();
        Factura factTemp;
        Compras compraTemp;

        double meses[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String[] mesesT = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        while (itCompra.hasNext()) {
            compraTemp = (Compras) itCompra.next();
            for (int mesx = 1; mesx < 13; mesx++) {
                int uno = 1;
                if (compraTemp.getFecha().getMonth() == mesx) {
                    meses[mesx - uno] += compraTemp.getTotal();
                }
            }
        }

        while (itFact.hasNext()) {
            factTemp = (Factura) itFact.next();
            for (int mesx = 1; mesx < 13; mesx++) {
                int uno = 1;
                if (factTemp.getFecha().getMonth() == mesx) {
                    meses[mesx - uno] -= factTemp.getTotal();
                }
            }
        }

        int n = 0;
        for (int i = 0; i < 12; i++) {
            int x = i;
            if (meses[i] != 0) {
                if (i == n) {
                    utilidadDataSet.addValue(meses[i], new String("rowEnero"), new String(mesesT[x]));
                }
                n++;
            }
            n = 0;
        }

        JFreeChart chart = ChartFactory.createBarChart("Utilidad chart", "Meses", "Utilidad", utilidadDataSet, PlotOrientation.VERTICAL, true, true, false);

        return chart;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();
        try {

            JFreeChart chart = crearChart(Integer.parseInt(request.getParameter("anio")), Integer.parseInt(request.getParameter("mes")));
           

            ChartUtilities.writeChartAsPNG(out, chart, 800, 300);

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
