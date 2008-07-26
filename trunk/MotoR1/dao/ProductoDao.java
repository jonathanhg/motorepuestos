/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.Producto;
/**
 *
 * @author lcastillo
 */
public interface  ProductoDao {
    
    public void agregarProducto(Producto producto);
    
    public void eliminarProducto(Producto producto);
    
    public void actualizarProducto(Producto producto);
    
    

}
