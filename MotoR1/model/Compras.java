/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.FetchType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;


/**
 *
 * @author luisj
 */
@Entity
@Table(name="compras")
public class Compras implements Serializable {
    
    private Integer id;
    //private Proveedores Proveedor;
    private double precio ;
    private double total ;
    private Date fecha;
    private boolean is_anulado;
    private double descuento;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique=true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
  /* public Proveedores getProveedor() {
        return Proveedor;
    }*/ 

  private List<CompraProducto> productos;

    /** 
     * Borra todos los productos cuando se elimina la fatura de compra  
     *  crea nuevos productos en la factura sin tener que consultarlos antes para insertarlos , 
     **/
   @OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER) 
   @JoinTable(
        name="CompProduct",
        joinColumns={@JoinColumn(name="comp_id")},
        inverseJoinColumns= @JoinColumn(name="product_id")
    )
    public List<CompraProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<CompraProducto> productos) {
        this.productos = productos;
    }
    
    
    /*public void setProveedor(Proveedores Proveedor) {
        this.Proveedor = Proveedor;
    }*/

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    @Temporal(TemporalType.DATE)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Type(type="yes_no")
    public boolean getIs_anulado() {
        return is_anulado;
    }

    public void setIs_anulado(boolean is_anulado) {
        this.is_anulado = is_anulado;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    

}
