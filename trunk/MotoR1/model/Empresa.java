package model;


import java.io.Serializable;
import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="empresa")
public class Empresa implements Serializable    {
      
    private Integer id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String personaJuridica;
    private int impuestoDeVentas;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getId () {
        return id;
    }
    
    public void setId (Integer val) {
        this.id = val;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPersonaJuridica() {
        return personaJuridica;
    }

    public void setPersonaJuridica(String personaJuridica) {
        this.personaJuridica = personaJuridica;
    }

    public int getImpuestoDeVentas() {
        return impuestoDeVentas;
    }

    public void setImpuestoDeVentas(int impuestoDeVentas) {
        this.impuestoDeVentas = impuestoDeVentas;
    }
    
   

   
   

  
   
}

