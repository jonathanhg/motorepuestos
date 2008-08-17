package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
// #[regen=yes,id=DCE.0737157A-05DB-2346-7A84-5B3D356EEFE3]
// </editor-fold> 

//una factura tiene muchas factProduct .. las caracteristicas principales del producto se copian a la hora 
// de escojer el producto a la factura a esta tabla en tiempo de ejecucion.. para que tenga consistencia de datos
@Entity
@Table(name = "factura_producto")
public class FactProduct implements Serializable {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CBD9D987-0AAF-95DE-26F6-1B4D043B1F68]
    // </editor-fold> 
    public FactProduct() {
    }    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.793DC6F0-0CFA-3C8F-9507-40DA6FF677BD]
    // </editor-fold> 
    private String id;    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AA713D94-F261-8C85-DED1-4256084954AF]
    // </editor-fold> 
    private String descripcion;    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A1EDBB73-8722-68B6-8819-CF19D056F485]
    // </editor-fold> 
    private double precio;    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E36533B3-F535-75D4-8568-22F25F8CED55]
    // </editor-fold> 
    private double utilidad;    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E963DD5B-2068-5AEB-5D39-AC313CA24884]
    // </editor-fold> 
    private double impuestoVentas;
    private int cantidad;
    private double total;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DD684D74-CBB4-A44F-C1D7-312AC4164C54]
    // </editor-fold> 
    public double getPrecio() {
        return precio;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3EA1AABF-F749-A917-20C2-D5A10F1BAE0C]
    // </editor-fold> 
    public void setPrecio(double val) {
        this.precio = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EE582CF4-9CCB-2091-1488-014C2046F616]
    // </editor-fold> 
    public String getDescripcion() {
        return descripcion;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6B003E7C-E5BA-B59E-F0AE-EA1EBD2182BF]
    // </editor-fold> 
    public void setDescripcion(String val) {
        this.descripcion = val;
    }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6B76175B-76E7-F817-E929-BC23663ED0FD]
    // </editor-fold> 
    @Id
    @Column(name = "id", unique = true)
    public String getId() {
        return id;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A304E80D-34DD-55C6-575E-D5B3273966A9]
    // </editor-fold> 
    public void setId(String val) {
        this.id = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.96B13AD9-75AA-DD24-F068-A8D6207D2B6E]
    // </editor-fold> 
    public double getImpuestoVentas() {
        return impuestoVentas;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.96BE373C-932A-2A2A-B380-1980EAEA5020]
    // </editor-fold> 
    public void setImpuestoVentas(double val) {
        this.impuestoVentas = val;
    }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8404954C-1F95-4A90-43FF-C63AEF0352AD]
    // </editor-fold> 
    public double getUtilidad() {
        return utilidad;
    }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B136576F-289F-5435-5672-21DCCDA2DEDD]
    // </editor-fold> 
    public void setUtilidad(double val) {
        this.utilidad = val;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double subtotal) {
        this.total = subtotal;
    }
}

