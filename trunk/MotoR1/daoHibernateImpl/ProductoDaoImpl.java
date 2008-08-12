/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoHibernateImpl;

import dao.ProductoDao;
import java.util.Date;
import java.util.List;
import model.Producto;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Administrador
 */
public class ProductoDaoImpl implements ProductoDao {

    public void agregarProducto(Producto producto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(producto);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
    }

    public void eliminarProducto(Producto producto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(producto);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
    }

    public void actualizarProducto(Producto xProducto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Producto producto = (Producto) session.load(Producto.class, xProducto.getId());
            producto.setDescripcion(xProducto.getDescripcion());
            producto.setExistencias(xProducto.getExistencias());
            producto.setMinimos(xProducto.getMinimos());
            producto.setPrecioUnitario(xProducto.getPrecioUnitario());
            session.update(producto);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
    }

        public Producto obtenerProducto(String codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
       Producto producto = null;
        try {
            session.beginTransaction();
            Query getFacturas = session.createQuery("from Producto prod where prod.id = :ncodigo");
            getFacturas.setString("ncodigo", codigo);
            producto = (Producto)getFacturas.uniqueResult();

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return producto;
    }
    
    public List obtenerProductos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List facturas = null;
        try {
            session.beginTransaction();
            Query getFacturas = session.createQuery("from Producto prod order by prod.existencias");
            facturas = getFacturas.list();
    
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return facturas;
    }
    
    public List obtenerMinimos() { //productos donde (existencias <=minimo)
        Session session = HibernateUtil.getSessionFactory().openSession();
        List facturas = null;
        try {
            session.beginTransaction();
            Query getFacturas = session.createQuery("from Producto prod where prod.existencias <= prod.minimos");
            facturas = getFacturas.list();
    
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return facturas;
    }
}
