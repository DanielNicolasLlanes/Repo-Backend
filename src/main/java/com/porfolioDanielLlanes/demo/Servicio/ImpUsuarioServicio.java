package com.porfolioDanielLlanes.demo.Servicio;

import com.porfolioDanielLlanes.demo.Entidad.Usuario;
import com.porfolioDanielLlanes.demo.Interfaz.IUsuarioServicio;
import com.porfolioDanielLlanes.demo.Repositorio.IUsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpUsuarioServicio implements IUsuarioServicio{
    @Autowired IUsuarioRepositorio iUsuarioRepositorio;
    
    
    @Override
    public List<Usuario> getUsuario() {
        List<Usuario> usuario = iUsuarioRepositorio.findAll();
        return usuario;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        iUsuarioRepositorio.save(usuario);
    }

    @Override
    public void deleteUsuario(Long Id) {
        iUsuarioRepositorio.deleteById(Id);
    }

    @Override
    public Usuario findUsuario(Long Id) {
       Usuario usuario = iUsuarioRepositorio.findById(Id).orElse(null);
       return usuario;
    }
}
