/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boImpl;

import bo.FacturaBo;
import daoHibernateImpl.FacturaDaoImpl;
import model.Factura;

/**
 *
 * @author luisj
 */
public class FacturaBoImpl implements FacturaBo {
    
    public FacturaDaoImpl dao;
    
    public void FacturaBoImpl(){
        dao = new FacturaDaoImpl();
    }
    
    public double save(Factura fact) {
      dao.agregarFactura(fact);
     
      
      return fact.getId();
    }

}
