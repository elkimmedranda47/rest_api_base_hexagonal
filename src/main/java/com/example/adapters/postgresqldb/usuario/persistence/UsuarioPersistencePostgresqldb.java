package com.example.adapters.postgresqldb.usuario.persistence;
import com.example.adapters.postgresqldb.usuario.daos.UsuarioRepository;
import com.example.adapters.postgresqldb.usuario.entities.UsuarioEntity;
//import com.example.adapters.postgresqldb.usuario.entities.UsuarioEntity;
import com.example.domain.exceptions.NotFoundException;
import com.example.domain.models.usuario.Usuario;
import com.example.domain.persistence_ports.usuario.UsuarioPersistence;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("usuarioPersistence")




    public class UsuarioPersistencePostgresqldb implements UsuarioPersistence {

        private final UsuarioRepository usuarioRepository;

    
    

    @Autowired
    public UsuarioPersistencePostgresqldb(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
   /* public Usuario read(Long id) {
        return this.usuarioRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Usuario id: " + id))
       .toUsuario();
    }

    */ //modificamos qui
    public Usuario read(Long id) {
        if (id != null) {
            return this.usuarioRepository
                    .findById(id)
                    .orElseThrow(() -> new NotFoundException("Usuario id: " + id))
                    .toUsuario();
        } else {
            // Assuming that you want to return null when the id is null
            return null;
        }
    }



    @Override
    public Stream<Usuario> readAll() {
        return this.usuarioRepository
                .findAll().stream()
                .map(UsuarioEntity::toUsuario);
    }

    @Override
    public Usuario create(Usuario usuario) {
        return this.usuarioRepository
                .save(new UsuarioEntity(usuario))
                .toUsuario();
    }
    
    @Override
    public Usuario update(Long id, Usuario usuario) {
        
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

 
    @Override
    public boolean existsEmail(String email) {
      
        throw new UnsupportedOperationException("Unimplemented method 'existsEmail'");
    }


  
   







}