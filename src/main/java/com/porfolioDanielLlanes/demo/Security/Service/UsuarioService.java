
package com.porfolioDanielLlanes.demo.Security.Service;

import com.porfolioDanielLlanes.demo.Security.Entity.User;
import com.porfolioDanielLlanes.demo.Security.Repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository IusuarioRepository;
    
    public Optional<User> getByNombreUsuario(String nombreUsuario){
        return IusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existByNombreUsuario(String nombreUsuario){
        return IusuarioRepository.existsByNombreUsuario(nombreUsuario); 
    }
    
    public boolean existByEmail(String email){
        return IusuarioRepository.existsByEmail(email); 
    } 
    
    public void save(User usuario){
        IusuarioRepository.save(usuario);
    }
}