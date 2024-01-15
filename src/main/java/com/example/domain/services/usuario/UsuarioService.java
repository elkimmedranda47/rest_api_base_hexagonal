package com.example.domain.services.usuario;

import com.example.domain.exceptions.ConflictException;
import com.example.domain.models.usuario.Usuario;
import com.example.domain.persistence_ports.usuario.UsuarioPersistence;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.stream.Stream;

@Service
public class UsuarioService {

    private final UsuarioPersistence usuarioPersistence;

    @Autowired
    public UsuarioService(UsuarioPersistence usuarioPersistence) {
        this.usuarioPersistence = usuarioPersistence;
    }

    //funciones logica de negocio

     public Usuario create(Usuario usuario) {
           
        //usuario.setRegistrationDate(LocalDate.now());
       // this.assertUsernameNotExist(usuario.getUsername());
        // this.assertEmailNotExist(usuario.getEmail());
        return this.usuarioPersistence.create(usuario);
    }

     public Usuario read(Usuario usuario) {

        return this.usuarioPersistence.read(usuario.getId());
    } // se comento aqui

    public void readAll() {
         this.usuarioPersistence.readAll();
    }
    
    
    public void assertEmailNotExist(String email) {
        if (this.usuarioPersistence.existsEmail(email)) {
            throw new ConflictException("Email exist: " + email);
        }
    }


   


/*   public Stream<Article> findByProviderAndPriceGreaterThan(String provider, BigDecimal price) {
        return this.articlePersistence.findByProviderAndPriceGreaterThan(provider, price);
    }
*/
    // Add more methods based on the specific functionality you need for UsuarioService
}
