
package com.porfolioDanielLlanes.demo.Interfaz;
 
import com.porfolioDanielLlanes.demo.Entidad.Usuario;
import java.util.List;

public interface IUsuarioServicio {
    //Traer una lista de usuarios
    public List<Usuario> getUsuario();
    
    //Guardar un objeto del tipo usuario
    public void saveUsuario(Usuario usuario);
    
    //Eliminar un Usuario, buscado por Id
    public void deleteUsuario(Long Id);
    
    //Buscar Usuario por Id
    public Usuario findUsuario(Long Id);
}
