package com.example.adapters.postgresqldb.usuario.daos;

import com.example.adapters.postgresqldb.usuario.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    //Optional<UsuarioEntity> findByNombreUsuario(String nombreUsuario);
    
    
    //Interfa que me da los metodos para yo hacer operaciones con las bases de datos
    
    
    Optional<UsuarioEntity> findByEmail(String email);
}