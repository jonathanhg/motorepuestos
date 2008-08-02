/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoHibernateImpl;

import dao.FacturaDao;
import java.util.Date;
import java.util.List;
import model.Factura;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author lcastillo
 */
public class FacturaDaoImpl implements FacturaDao {

    public void agregarFactura(Factura factura) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(factura);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
    }

    public void eliminarFactura(Factura factura) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(factura);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
    }

    public void actualizarEmpresa(Factura factura) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(factura);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
    }

    public List facturasPorAnio(int anio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List facturas = null;
        try {
            session.beginTransaction();
            Query getFacturas = session.createQuery("from Factura fact where year(fact.fecha) = :var1");
            getFacturas.setInteger("var1", anio); // la funcion esta Deprecated hay que buscar otra

            facturas = getFacturas.list();

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return facturas;
    }

    public List facturasPorFecha(int anioDesde, int anioHasta, int mesDesde, int mesHasta) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List facturas = null;
        try {
            session.beginTransaction();
            Query getFacturas = session.createQuery("from Factura fact where year(fact.fecha) >= :adesde and where year(fact.fecha) <= :ahasta and where month(fact.fecha) >= :mdesde and where month(fact.fecha) <= :mhasta");
            getFacturas.setInteger("adesde", anioDesde);
            getFacturas.setInteger("ahasta", anioHasta);
            getFacturas.setInteger("mdesde", mesDesde);
            getFacturas.setInteger("mhasta", mesHasta);
            facturas = getFacturas.list();

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return facturas;
    }

    public List facturasPorCliente(String nombreCliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List facturas = null;
        try {
            session.beginTransaction();
            Query getFacturas = session.createQuery("from Factura fact where fact.cliente = :ncliente");
            getFacturas.setString("ncliente", nombreCliente);
            facturas = getFacturas.list();

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return facturas;
    }
    
        public List facturasAnuladasPorMes(int mes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List facturas = null;
        try {
            session.beginTransaction();
            Query getFacturas = session.createQuery("from Factura fact where month(fact.fecha) = :var1 and where fact.is_anulado = :estado");
            getFacturas.setInteger("var1", mes);
            getFacturas.setBoolean("estado", true);

            facturas = getFacturas.list();

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return facturas;
    }
    
}
