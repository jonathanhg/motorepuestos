package model;


import java.util.Date;
import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.0737157A-05DB-2346-7A84-5B3D356EEFE3]
// </editor-fold> 
@Entity
@Table(name= "producto")
public class Producto {

     // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CBD9D987-0AAF-95DE-26F6-1B4D043B1F68]
    // </editor-fold> 
    public Producto () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.793DC6F0-0CFA-3C8F-9507-40DA6FF677BD]
    // </editor-fold> 
    private String id;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.653935D6-03CC-5F0D-68E3-02E0B976AFF3]
    // </editor-fold> 
    private Date fechaIngreso;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7EDA296F-B66E-4E16-DF81-C2097115C137]
    // </editor-fold> 
    private int existencias; 

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AA713D94-F261-8C85-DED1-4256084954AF]
    // </editor-fold> 
    private String descripcion;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A1EDBB73-8722-68B6-8819-CF19D056F485]
    // </editor-fold> 
    private double precioUnitario;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E36533B3-F535-75D4-8568-22F25F8CED55]
    // </editor-fold> 
    private double utilidad;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E963DD5B-2068-5AEB-5D39-AC313CA24884]
    // </editor-fold> 
    private double impuestoVentas;
    
    private String idProveedor;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C7DEE7A0-2DA0-95FB-22EB-52BC6C6876AE]
    // </editor-fold> 
    @ManyToOne
    private Proveedores proveedor;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.641BF209-EFEC-D639-FA7E-20CACFACD88C]
    // </editor-fold> 
    private int minimos;

   
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C6616433-86EE-D067-08DA-498493EC5F7F]
    // </editor-fold> 
    public int getExistencias () {
        return existencias;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1A893E3D-04C6-EC4D-23CC-D3C453E0F8E4]
    // </editor-fold> 
    public void setExistencias (int val) {
        this.existencias = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DD684D74-CBB4-A44F-C1D7-312AC4164C54]
    // </editor-fold> 
    public double getPrecioUnitario () {
        return precioUnitario;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3EA1AABF-F749-A917-20C2-D5A10F1BAE0C]
    // </editor-fold> 
    public void setPrecioUnitario (double val) {
        this.precioUnitario = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EE582CF4-9CCB-2091-1488-014C2046F616]
    // </editor-fold> 
    public String getDescripcion () {
        return descripcion;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6B003E7C-E5BA-B59E-F0AE-EA1EBD2182BF]
    // </editor-fold> 
    public void setDescripcion (String val) {
        this.descripcion = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.545DF09C-C253-0F4D-F070-20E7BC8C20FB]
    // </editor-fold> 
    @Temporal(TemporalType.DATE)
    public Date getFechaIngreso () {
        return fechaIngreso;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.935422E5-49E5-3D12-0B84-C260121348CC]
    // </editor-fold> 
    public void setFechaIngreso (Date val) {
        this.fechaIngreso = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6B76175B-76E7-F817-E929-BC23663ED0FD]
    // </editor-fold> 
    @Id
    @Column(name="id", unique=true)
    public String getId () {
        return id;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A304E80D-34DD-55C6-575E-D5B3273966A9]
    // </editor-fold> 
    public void setId (String val) {
        this.id = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.96B13AD9-75AA-DD24-F068-A8D6207D2B6E]
    // </editor-fold> 
    public double getImpuestoVentas () {
        return impuestoVentas;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.96BE373C-932A-2A2A-B380-1980EAEA5020]
    // </editor-fold> 
    public void setImpuestoVentas (double val) {
        this.impuestoVentas = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A12C5BB8-6D4F-72BB-7245-8FA32AFA9F81]
    // </editor-fold> 
    public int getMinimos () {
        return minimos;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6C1C4E5D-70D5-6478-6B5F-740524337E81]
    // </editor-fold> 
    public void setMinimos (int val) {
        this.minimos = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8404954C-1F95-4A90-43FF-C63AEF0352AD]
    // </editor-fold> 
    public double getUtilidad () {
        return utilidad;
    }

 
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B136576F-289F-5435-5672-21DCCDA2DEDD]
    // </editor-fold> 
    public void setUtilidad (double val) {
        this.utilidad = val;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
        this.idProveedor=this.proveedor.getId();
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    
    
    

}

