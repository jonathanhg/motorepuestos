/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.Proveedores;
/**
 *
 * @author lcastillo
 */
public interface  ProveedoresDao {
    
    public void agregarProveedor(Proveedores proveedor);
    
    public void eliminarProveedor(Proveedores proveedor);
    
    public void actualizarProveedor(Proveedores proveedor);
    
    

}
