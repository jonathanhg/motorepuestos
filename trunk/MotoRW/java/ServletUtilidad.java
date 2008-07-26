/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import daoHibernateImpl.ComprasDaoImpl;
import daoHibernateImpl.FacturaDaoImpl;
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
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
public class ServletUtilidad extends HttpServlet {
   
   public JFreeChart crearChart(int anio , int mes){
       
       
       
        FacturaDaoImpl factura = new FacturaDaoImpl();
        ComprasDaoImpl compras = new ComprasDaoImpl();
        
  
       List factList = factura.facturasPorAnio(anio);
       List comprasList =  compras.ComprasPorAnio(anio);
        
       double compra;
       double venta;
       
       DefaultCategoryDataset utilidadDataSet = new DefaultCategoryDataset();
       
       
       
       Iterator itFact = factList.iterator();
       Iterator itCompra = comprasList.iterator();
       Factura factTemp ;
       Compras compraTemp;
    
       double meses[] = {0,0,0,0,0,0,0,0,0,0,0,0};
       while(itCompra.hasNext()){
            compraTemp = (Compras) itCompra.next();
            if(compraTemp.getFecha().getMonth() == 1 ){ meses[0] += compraTemp.getTotal();}
            if(compraTemp.getFecha().getMonth() == 2 ){meses[1] += compraTemp.getTotal();}
            if(compraTemp.getFecha().getMonth() == 3 ){meses[2] += compraTemp.getTotal();}
            if(compraTemp.getFecha().getMonth() == 4 ){meses[3] += compraTemp.getTotal();}
            if(compraTemp.getFecha().getMonth() == 5 ){meses[4] += compraTemp.getTotal();}
            if(compraTemp.getFecha().getMonth() == 6 ){meses[5]+= compraTemp.getTotal();}
            if(compraTemp.getFecha().getMonth() == 7 ){meses[6] += compraTemp.getTotal();}
            if(compraTemp.getFecha().getMonth() == 8 ){meses[7] += compraTemp.getTotal();}
            if(compraTemp.getFecha().getMonth() == 9 ){meses[8] += compraTemp.getTotal();}
            if(compraTemp.getFecha().getMonth() == 10 ){meses[9] += compraTemp.getTotal();}
            if(compraTemp.getFecha().getMonth() == 11 ){meses[10] += compraTemp.getTotal();}
            if(compraTemp.getFecha().getMonth() == 12 ){meses[11] += compraTemp.getTotal();}
       }
       
       while(itFact.hasNext()){
          factTemp = (Factura)itFact.next();
           if(factTemp.getFecha().getMonth() == 1 ){ meses[0] -= factTemp.getTotal();}
            if(factTemp.getFecha().getMonth() == 2 ){meses[1] -= factTemp.getTotal();}
            if(factTemp.getFecha().getMonth() == 3 ){meses[2] -= factTemp.getTotal();}
            if(factTemp.getFecha().getMonth() == 4 ){meses[3] -= factTemp.getTotal();}
            if(factTemp.getFecha().getMonth() == 5 ){meses[4] -= factTemp.getTotal();}
            if(factTemp.getFecha().getMonth() == 6 ){meses[5] -= factTemp.getTotal();}
            if(factTemp.getFecha().getMonth() == 7 ){meses[6] -= factTemp.getTotal();}
            if(factTemp.getFecha().getMonth() == 8 ){meses[7] -= factTemp.getTotal();}
            if(factTemp.getFecha().getMonth() == 9 ){meses[8] -= factTemp.getTotal();}
            if(factTemp.getFecha().getMonth() == 10 ){meses[9] -= factTemp.getTotal();}
            if(factTemp.getFecha().getMonth() == 11 ){meses[10] -= factTemp.getTotal();}
            if(factTemp.getFecha().getMonth() == 12 ){meses[11] -= factTemp.getTotal();}
            
       }
       for(int i=0;i<12;i++){
           if(meses[i] != 0 ){
               if(i == 0){utilidadDataSet.addValue(meses[i],new String("rowEnero"),new String("Enero"));}
               if(i == 1){utilidadDataSet.addValue(meses[i],new String("rowEnero"),new String("Febrero"));}
               if(i == 2){utilidadDataSet.addValue(meses[i],new String("rowEnero"),new String("Marzo"));}
               if(i == 3){utilidadDataSet.addValue(meses[i],new String("rowEnero"),new String("Abril"));}
               if(i == 4){utilidadDataSet.addValue(meses[i],new String("rowEnero"),new String("Mayo"));}
               if(i == 5){utilidadDataSet.addValue(meses[i],new String("rowEnero"),new String("Junio"));}
               if(i == 6){utilidadDataSet.addValue(meses[i],new String("rowEnero"),new String("Julio"));}
               if(i == 7){utilidadDataSet.addValue(meses[i],new String("rowEnero"),new String("Agosto"));}
               if(i == 8){utilidadDataSet.addValue(meses[i],new String("rowEnero"),new String("Setiembre"));}
               if(i == 9){utilidadDataSet.addValue(meses[i],new String("rowEnero"),new String("Octubre"));}
               if(i == 10){utilidadDataSet.addValue(meses[i],new String("rowEnero"),new String("Noviembre"));}
               if(i == 11){utilidadDataSet.addValue(meses[i],new String("rowEnero"),new String("Diciembre"));}
           }
       }
       
       JFreeChart chart = ChartFactory.createBarChart("Utilidad chart","Meses", "Utilidad", utilidadDataSet, PlotOrientation.VERTICAL, true, true, false);
       
       return chart ;
   }
       
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();
        try {
            
           JFreeChart chart =  crearChart(Integer.parseInt(request.getParameter("anio")),Integer.parseInt(request.getParameter("mes")));
          
           
           ChartUtilities.writeChartAsPNG(out,chart ,800,300);
           
           
           
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
