
package com.porfolioDanielLlanes.demo.Security.Repository;

import com.porfolioDanielLlanes.demo.Security.Entity.Rol;
import com.porfolioDanielLlanes.demo.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
