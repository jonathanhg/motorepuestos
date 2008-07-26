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
    
    public Empresa(){
        
    }

    
    
    private Integer id;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getId () {
        return id;
    }

  
    public void setId (Integer val) {
        this.id = val;
    }

    
    private String nombre;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
   

   
   

  
   
}

