/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import model.Producto;
/**
 *
 * @author lcastillo
 */
public interface  ProductoDao {
    
    public void agregarProducto(Producto producto);
    
    public void eliminarProducto(Producto producto);
    
    public void actualizarProducto(Producto producto);
    
    public List obtenerProductos();
    
    public List obtenerMinimos();
    
    public List obtenerProductos(String criterio);

}
