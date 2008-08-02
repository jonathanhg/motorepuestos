/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package daoHibernateImpl;

import dao.ComprasDao;
import java.util.Date;
import java.util.List;
import model.Compras;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
/**
 *
 * @author luisj
 */
public class ComprasDaoImpl implements ComprasDao {

    public void agregarCompra(Compras compra) {
       Session session =HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           session.save(compra);
           session.getTransaction().commit();
       }catch(Exception e ){
         System.out.println(e.toString());
       }finally{
         session.close();
       }
    }

    public void eliminarCompra(Compras compra) {
       Session session =HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           session.delete(compra);
           session.getTransaction().commit();
       }catch(Exception e ){
         System.out.println(e.toString());
       }finally{
         session.close();
       }
    }

    public void actualizarCompra(Compras compra) {
       Session session =HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           session.update(compra);
           session.getTransaction().commit();
       }catch(Exception e ){
         System.out.println(e.toString());
       }finally{
         session.close();
       }
    }

    public List ComprasPorAnio(int anio) {
        Session session =HibernateUtil.getSessionFactory().openSession();
        List compras = null;
        try{
            session.beginTransaction();
            Query getCompras = session.createQuery("from Compras compra where year(compra.fecha) = :var1");
            getCompras.setInteger("var1", anio); // la funcion esta Deprecated hay que buscar otra
            compras = getCompras.list();
            
        }catch(Exception e){
          System.out.println(e.toString());
        }finally{
        session.close();
        }
        return compras;
    }

    public List ComprasPorMes(int mes) {
       Session session =HibernateUtil.getSessionFactory().openSession();
        List compras = null;
        try{
            session.beginTransaction();
            Query getCompras = session.createQuery("from Compras compra where month(compra.fecha) = :var1");
            getCompras.setInteger("var1", mes); // la funcion esta Deprecated hay que buscar otra
            compras = getCompras.list();
            
        }catch(Exception e){
          System.out.println(e.toString());
        }finally{
        session.close();
        }
        return compras;
    }


    
}
