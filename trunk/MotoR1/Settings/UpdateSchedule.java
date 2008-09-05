/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

import daoHibernateImpl.EmpresaDaoImpl;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.*;
import model.Empresa;

/**
 *
 * Esta clase hace que se modifique cualquier dato cada X segundos,
 * esto se hace para mantener el caché del programa actualizado
 */
public class UpdateSchedule {

    public UpdateSchedule() {
        final EmpresaDaoImpl em = new EmpresaDaoImpl();
        final Empresa empresa = new Empresa();
        AbstractAction aa = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {

                empresa.setId(1);
                em.actualizarEmpresa(empresa);
            }
        };
        Timer timer = new Timer(10000, aa); //10000 equivale a 10 segundos
        timer.setRepeats(true);
        timer.start();
    }
}
