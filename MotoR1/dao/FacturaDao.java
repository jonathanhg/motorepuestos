/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.Date;
import java.util.List;
import model.Factura;
/**
 *
 * @author lcastillo
 */
public interface  FacturaDao {
    
    public void agregarFactura(Factura factura);
    
    public void eliminarFactura(Factura factura);
    
    public void actualizarEmpresa(Factura factura);
    
    public List facturasPorMes(int mes);
    
    public List facturasPorFecha(int anioDesde, int anioHasta, int mesDesde, int mesHasta);
    
    public List facturasPorCliente(String nombreCliente);
    
    public List facturasAnuladasPorMes(int mes);

}
