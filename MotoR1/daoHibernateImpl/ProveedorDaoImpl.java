/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package daoHibernateImpl;

import dao.ProveedoresDao;
import java.util.List;
import model.Proveedores;
import org.hibernate.Session;
import util.HibernateUtil;
import org.hibernate.Query;


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
    
    public Proveedores obtenerProveedor(String codigo) {
       Session session = HibernateUtil.getSessionFactory().openSession();
       Proveedores Proveedores = null;
        try {
            session.beginTransaction();
            Query getProveedor = session.createQuery("from Proveedores prov where prov.id = :ncodigo");
            getProveedor.setString("ncodigo", codigo);
            Proveedores = (Proveedores)getProveedor.uniqueResult();

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return Proveedores;
    }
    
        public List obtenerProveedores() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List proveedores = null;
        try {
            session.beginTransaction();
            Query getFacturas = session.createQuery("from Proveedores prov");
            proveedores = getFacturas.list();
    
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return proveedores;
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
   
        public List productosPorProveedor(String idProveedor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List productos = null;
        try {
            Proveedores provedor = new Proveedores();
            session.beginTransaction();
            Query getProductos = session.createQuery("from Producto prod where prod.idproveedor =: pIdProveedor");
            getProductos.setString("pIdProveedor", idProveedor);
            productos = getProductos.list();

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return productos;
    }
    
}
