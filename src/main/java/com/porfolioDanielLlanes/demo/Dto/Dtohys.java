
package com.porfolioDanielLlanes.demo.Dto;

import javax.validation.constraints.NotBlank;


public class Dtohys {
    @NotBlank
    private String nombre;
    private int porcent;

    public Dtohys() {
    }

    public Dtohys(String nombre, int porcent) {
        this.nombre = nombre;
        this.porcent = porcent;
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
