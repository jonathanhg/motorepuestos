/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package daoHibernateImpl;

import dao.ProveedoresDao;
import model.Proveedores;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author luisj
 */
public class ProveedorDaoImpl implements ProveedoresDao {

    public void agregarProveedor(Proveedores proveedor) {
         Session session =HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           session.save(proveedor);
           session.getTransaction().commit();
       }catch(Exception e ){
         System.out.println(e.toString());
       }finally{
         session.close();
       }
    }

    public void eliminarProveedor(Proveedores proveedor) {
      Session session =HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           session.delete(proveedor);
           session.getTransaction().commit();
       }catch(Exception e ){
         System.out.println(e.toString());
       }finally{
         session.close();
       }
    }

    public void actualizarProveedor(Proveedores proveedor) {
        Session session =HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           session.update(proveedor);
           session.getTransaction().commit();
       }catch(Exception e ){
         System.out.println(e.toString());
       }finally{
         session.close();
       }
    }
    
    
    
}
