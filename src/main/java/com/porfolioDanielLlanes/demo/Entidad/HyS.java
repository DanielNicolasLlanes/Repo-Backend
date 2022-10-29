
package com.porfolioDanielLlanes.demo.Entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HyS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int porcent;

    public HyS() {
    }

    public HyS(String nombre, int porcent) {
        this.nombre = nombre;
        this.porcent = porcent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcent() {
        return porcent;
    }

    public void setPorcent(int porcent) {
        this.porcent = porcent;
    }
    
    
}
