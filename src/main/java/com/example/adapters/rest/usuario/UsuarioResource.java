package com.example.adapters.rest.usuario;


//import  com.example.adapters.rest.LexicalAnalyzer;
import  com.example.domain.models.usuario.Usuario;
//import com.example.domain.models.usuairo.ArticlePriceUpdating;
import com.example.domain.services.usuario.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import java.util.List; // se comento aqui



@RestController
@RequestMapping(UsuarioResource.USUARIOS)

public class UsuarioResource {
    //static final String USUARIOS = "/usuario";  // Change this path as needed
    static final String USUARIOS = "/api/v1"; 

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/users")
    public Usuario create(@RequestBody Usuario usuario) {
        // Implement your logic for creating a usuario
        return this.usuarioService.create(usuario);

        
    }

   @GetMapping("/users/{id}")
    public Usuario getById(@PathVariable Long id) {
        // Implement your logic for getting a usuario by ID
        return this.usuarioService.read(id);
    }

     @GetMapping("/users")
    public  List<Usuario> readAll() {
        // Implement your logic for searching usuarios based on criteria
        // You can use LexicalAnalyzer for extracting values from the query string
        System.out.println  ("llegamos");
       return  this.usuarioService.readAll();
    }

 
    @DeleteMapping("/users/{id}")
    public Usuario delete(@PathVariable Long id) {
        // Implement your logic for getting a usuario by ID
        return this.usuarioService.delete(id);
    }

    // estamso qui
     @PutMapping("/users/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        // Implement your logic for updating a usuario
        return this.usuarioService.update(id, usuario);
    }


    /* 
    @GetMapping("/users")
    public  void readAll() {
        // Implement your logic for searching usuarios based on criteria
        // You can use LexicalAnalyzer for extracting values from the query string
         this.usuarioService.readAll();
    }*/




 /*
    @GetMapping("/search")
    public List<Usuario> findByCriteria(@RequestParam String q) {
        // Implement your logic for searching usuarios based on criteria
        // You can use LexicalAnalyzer for extracting values from the query string
        return this.usuarioService.findByCriteria(q);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        // Implement your logic for updating a usuario
        return this.usuarioService.update(id, usuario);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        // Implement your logic for deleting a usuario
        this.usuarioService.delete(id);
    }

    */
}