
import model.Empresa;
import org.hibernate.Session;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import util.HibernateUtil;



/**
 *
 * @author lcastillo
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
        
        Empresa empresa = new Empresa();
        
        empresa.setNombre("Prueba");
        
        session.save(empresa);
        session.getTransaction().commit();
        
        
        
    }

}
