package com.porfolioDanielLlanes.demo.Repositorio;

import com.porfolioDanielLlanes.demo.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository <Usuario, Long>{
    
}
