
package com.porfolioDanielLlanes.demo.Controlador;

import com.porfolioDanielLlanes.demo.Entidad.Usuario;
import com.porfolioDanielLlanes.demo.Interfaz.IUsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class UsuarioControlador {
    @Autowired IUsuarioServicio iusuarioServicio;
    
    @GetMapping("usuarios/traer")
    public List<Usuario> getUsuario(){
        return iusuarioServicio.getUsuario();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("usuarios/crear")
    public String createUsuario(@RequestBody Usuario usuario){
        iusuarioServicio.saveUsuario(usuario);
        return "Usuario creado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("usuarios/borrar/{id}")
    public String deleteUsuario(@PathVariable Long id){
        iusuarioServicio.deleteUsuario(id);
        return "Usuario eliminado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("usuarios/editar/{id}")
    public Usuario editUsuario(@PathVariable Long id, 
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("abaut") String nuevoAbaut,
                                @RequestParam("img") String nuevoImg) {
        Usuario usuario = iusuarioServicio.findUsuario(id);
        
            usuario.setNombre(nuevoNombre);
            usuario.setApellido(nuevoApellido);
            usuario.setAbaut(nuevoAbaut);
            usuario.setImg(nuevoImg);
            
            iusuarioServicio.saveUsuario(usuario);
            return usuario;
    }
    
    @GetMapping("usuarios/traer/perfil")
        public Usuario findUsuario(){
            return iusuarioServicio.findUsuario((long) 1);
        }
        
   //Editar las propiedades de un Usuario
        
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("usuarios/editar/about/{id}")
    public String editAbout(@PathVariable Long id, @RequestBody String about){
        Usuario usuario = iusuarioServicio.findUsuario(id);;
        usuario.setAbaut(about);
        iusuarioServicio.saveUsuario(usuario);
        return usuario.getAbaut();
    }
}
