/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package daoHibernateImpl;

import dao.EmpresaDao;
import model.Empresa;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author lcastillo
 */
public class EmpresaDaoImpl implements EmpresaDao {

    public void agregarEmpresa(Empresa empresa) {
       Session session =HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           session.save(empresa);
           session.getTransaction().commit();
       }catch(Exception e ){
         System.out.println(e.toString());
       }finally{
         session.close();
       }
       
    }

    public void eliminarEmpresa(Empresa empresa) {
       Session session =HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           session.delete(empresa);
           session.getTransaction().commit();
       }catch(Exception e ){
         System.out.println(e.toString());
       }finally{
         session.close();
       }
        
    }

 

    public void actualizarEmpresa(Empresa empresa) {
         Session session =HibernateUtil.getSessionFactory().openSession();
       try{
           session.beginTransaction();
           session.update(empresa);
           session.getTransaction().commit();
       }catch(Exception e ){
         System.out.println(e.toString());
       }finally{
         session.close();
       }
    }

        
}
