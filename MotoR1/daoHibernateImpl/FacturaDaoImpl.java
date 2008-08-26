/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoHibernateImpl;

import dao.FacturaDao;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import model.FactProduct;
import model.Factura;
import model.Producto;
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

        public void anularFactura(Factura factura) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            factura.setIs_anulado(true);
            
            List<FactProduct> productos = factura.getProductos();
            Iterator itProductos = productos.iterator();
            ProductoDaoImpl productoManager = new ProductoDaoImpl();
            FactProduct prodTemp;
            while (itProductos.hasNext()){
                prodTemp = (FactProduct) itProductos.next();
                Producto productoEnSistema = productoManager.obtenerProducto(prodTemp.getId());
                productoEnSistema.setExistencias(productoEnSistema.getExistencias() + prodTemp.getCantidad());
                productoManager.actualizarProducto(productoEnSistema); //devuelve al inventario los productos que se habían vendido
            }
            
            session.update(factura);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
    }


    public void anuladFacturaEmpresa(Factura factura) {
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

    public List facturasPorMes(int mes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List facturas = null;
        try {
            session.beginTransaction();
            Query getFacturas = session.createQuery("from Factura fact where month(fact.fecha) = :var1 and  fact.is_anulado = :isAnulada and year(fact.fecha)= :anio order by fact.id desc");
            getFacturas.setInteger("var1", mes); // la funcion esta Deprecated hay que buscar otra

            getFacturas.setString("isAnulada", "N");
            getFacturas.setInteger("anio", new Date().getYear() + 1900);//solo las facturas de este anio** Nota: Date().getYear() retorna 108 (en vez de 2008)
            facturas = getFacturas.list();

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return facturas;
    }

    public List facturasPorAnio(int anio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List facturas = null;
        try {
            session.beginTransaction();
            Query getFacturas = session.createQuery("from Factura fact where year(fact.fecha) = :var1 and where fact.is_anulado = :isAnulada");
            getFacturas.setInteger("var1", anio); // la funcion esta Deprecated hay que buscar otra

            getFacturas.setBoolean("isAnulada", false);

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
            Query getFacturas = session.createQuery("from Factura fact where year(fact.fecha) >= :adesde and  year(fact.fecha) <= :ahasta and where month(fact.fecha) >= :mdesde and where month(fact.fecha) <= :mhasta and where fact.is_anulado = :isAnulada");
            getFacturas.setInteger("adesde", anioDesde);
            getFacturas.setInteger("ahasta", anioHasta);
            getFacturas.setInteger("mdesde", mesDesde);
            getFacturas.setInteger("mhasta", mesHasta);
            getFacturas.setString("isAnulada", "N");
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
            Query getFacturas = session.createQuery("from Factura fact where fact.cliente = :ncliente and  fact.is_anulado = :isAnulada order by fact.fecha");
            getFacturas.setString("ncliente", nombreCliente);
            getFacturas.setString("isAnulada", "N");
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
            Query getFacturas = session.createQuery("from Factura fact where month(fact.fecha) = :var1 and fact.is_anulado = :isAnulada and year(fact.fecha) = :anio");
            getFacturas.setInteger("var1", mes);
            getFacturas.setString("isAnulada", "Y");
            getFacturas.setInteger("anio", new Date().getYear() + 1900); //solo las facturas de este anio ->Date().getYear() retorna 108 (en vez de 2008)

            facturas = getFacturas.list();

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return facturas;
    }

    public Factura facturaPorCodigo(int codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Factura factura = null;
        try {
            session.beginTransaction();
            Query getFacturas = session.createQuery("from Factura fact where fact.id = :ncodigo");
            getFacturas.setInteger("ncodigo", codigo);
            factura = (Factura) getFacturas.uniqueResult();

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return factura;
    }

    public List facturasSinImpuesto(int mes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List facturas = null;
        try {
            session.beginTransaction();
            Query getFacturas = session.createQuery("from Factura fact where fact.sin_impuesto = :isSinImpuesto and month(fact.fecha) = :pMes");
            getFacturas.setInteger("pMes", mes);
            getFacturas.setString("isSinImpuesto", "Y");
            facturas = getFacturas.list();

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            session.close();
        }
        return facturas;
    }

    public void actualizarFactura(Factura factura) {
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

    public void actualizarEmpresa(Factura factura) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
