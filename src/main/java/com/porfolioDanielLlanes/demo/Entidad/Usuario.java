
package com.porfolioDanielLlanes.demo.Entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    @NotNull
    @Size(min = 1, max = 50, message = "Ingrese de 1 a 50 caracteres")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Ingrese de 1 a 50 caracteres")
    private String apellido;
    
    //Aniadiendo el atributo SOBRE MI en la clase Usuario
    @Size(min = 1, max = 200, message = "Ingrese de 1 a 200 caracteres")
    private String abaut;
    
    @Size(min = 1, max = 50, message = "Ingrese de 1 a 50 caracteres")
    private String img;
}
