package model;


import java.io.Serializable;
import java.util.Date;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

@Entity
@Table(name="factura")
public class Factura implements Serializable  {
    
     public Factura () {
         
     }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.68E95536-1830-1897-AFCA-FDD9C63E3C70]
    // </editor-fold> 
    private Integer id;
       // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F4443D97-F382-5B6E-18AE-4B536434DFA8]
    // </editor-fold> 
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique=true)
    public Integer getId () {
        return id;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8EF88379-55CC-7281-CFAF-0B26A818512C]
    // </editor-fold> 
    public void setId (Integer val) {
        this.id = val;
    }
    

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DE037891-D01E-6A23-16AA-F2779A1D06C3]
    // </editor-fold> 
    private String codigo;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9B722F46-4CA9-AC19-DBE9-5626053441A5]
    // </editor-fold> 
    private Date fecha;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1EF98263-7CE1-5CC1-6CCF-0A8D74180932]
    // </editor-fold> 
    private String cliente;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.13B8FAFA-26CA-029A-A588-0885B5F53F97]
    // </editor-fold> 
    private double precio;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2CBC2E20-ED11-9B3F-071D-1136A40927A1]
    // </editor-fold> 
    private double descuento;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4ED76AA7-33B4-55AF-3960-A45CED031040]
    // </editor-fold> 
    private double total;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2D02A437-35E0-78AD-1601-DBEE9A64244B]
    // </editor-fold> 
    private boolean is_anulado;
    
    private boolean sin_impuesto;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.77586E61-C6F3-81AB-C3F5-46C95807EF05]
    // </editor-fold> 
   

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0833DA86-9ED1-86B0-755F-E9BB9FEF1BDC]
    // </editor-fold> 
    public String getCliente () {
        return cliente;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.AB554424-7D57-400E-B640-C7C4AD7C493F]
    // </editor-fold> 
    public void setCliente (String val) {
        this.cliente = val;
    }





    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.CF837DC0-25C8-6C7E-1A77-D780A43E788C]
    // </editor-fold> 
    public double getDescuento () {
        return descuento;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0070D507-D480-C5A7-9386-D4271E5AC654]
    // </editor-fold> 
    public void setDescuento (double val) {
        this.descuento = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DF30B582-7376-A399-600B-36DE9035D088]
    // </editor-fold> 
    @Temporal(TemporalType.DATE)
    public Date getFecha () {
        return fecha;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.ED5AE0E6-3BAB-9A41-72E1-D5474777F8EE]
    // </editor-fold> 
    public void setFecha (Date val) {
        this.fecha = val;
    }

 

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E2C45C78-F6A5-A05D-C2B9-9AE8FAC1CBD2]
    // </editor-fold> 
    @Type(type="yes_no")
    public boolean getIs_anulado () {
        return is_anulado;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.02E2935B-3CCE-B3EA-3E03-D4C931D0A100]
    // </editor-fold> 
    public void setIs_anulado (boolean val) {
        this.is_anulado = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B5E73EBF-B9F5-5EBB-88F8-B5BE76E169F2]
    // </editor-fold> 
    public double getPrecio () {
        return precio;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6E857CF6-911A-5B33-7B78-D93E22516DC3]
    // </editor-fold> 
    public void setPrecio (double val) {
        this.precio = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.95752227-13EC-302F-0FF8-2C6A3CD9D068]
    // </editor-fold> 
    public double getTotal () {
        return total;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5049EF3E-8EEF-E44C-E747-5B16F1488D29]
    // </editor-fold> 
    public void setTotal (double val) {
        this.total = val;
    }
    
    private List<FactProduct> productos;

    // Borra todos los productos cuando se elimina factura ,  
    //crea nuevos productos en la factura sin tener que consultarlos antes para insertarlos , 
    //se utliza Eager para que traiga los campos ya inicializados
    @OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER) 
    @JoinTable(
        name="FactProductos",
        joinColumns={@JoinColumn(name="fact_id")},
        inverseJoinColumns= @JoinColumn(name="product_id")
    )
    public List<FactProduct> getProductos() {
        return productos;
    }

    public void setProductos(List<FactProduct> productos) {
        this.productos = productos;
    }

    public boolean isSin_impuesto() {
        return sin_impuesto;
    }

    public void setSin_impuesto(boolean yaImplementado) {
        double impuesto = this.getTotal()*0.13;
        this.setTotal(this.getTotal()-impuesto);
        this.sin_impuesto = true;
    }

}

