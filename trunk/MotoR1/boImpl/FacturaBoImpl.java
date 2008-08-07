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
    
    public  FacturaBoImpl(){
        dao = new FacturaDaoImpl();
    }
    
    public int save(Factura fact) {
      
        dao.agregarFactura(fact);
        Factura temp = fact;
      
      return fact.getId() ;
    }

}
