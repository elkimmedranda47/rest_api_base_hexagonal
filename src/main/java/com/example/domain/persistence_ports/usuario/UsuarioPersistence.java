package com.example.domain.persistence_ports.usuario;

import com.example.domain.models.usuario.Usuario;

import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface UsuarioPersistence {

    Stream<Usuario> readAll();

    Usuario create(Usuario usuario);

    Usuario update(Long id, Usuario usuario);

    Usuario read(Long id); // se comento aqui
   
    Usuario delete(Long id);

    boolean existsEmail(String email);
}