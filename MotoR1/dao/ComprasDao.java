/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.Date;
import java.util.List;
import model.Compras;
/**
 *
 * @author lcastillo
 */
public interface  ComprasDao {
    
    public void agregarCompra(Compras compra);
    
    public void eliminarCompra(Compras compra);
    
    public void actualizarCompra(Compras compra);
    
    public List ComprasPorAnio(int anio);
    
    public List ComprasPorMes(int mes);

}
