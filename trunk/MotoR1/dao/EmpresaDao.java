/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.Empresa;
/**
 *
 * @author lcastillo
 */
public interface  EmpresaDao {
    
    public void agregarEmpresa(Empresa empresa);
    
    public void eliminarEmpresa(Empresa empresa);
    
    public void actualizarEmpresa(Empresa empresa);
    
    

}
