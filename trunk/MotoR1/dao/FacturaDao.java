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
    
    public List facturasPorAnio(int anio);

}
