package com.porfolioDanielLlanes.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

//NuevoUsuario, Rol, User son clases corregidas;
//RolService modificado su atributo de RolRepository a rolRepository;
//Creados los constructores de AuthControler que antes no estaban;
