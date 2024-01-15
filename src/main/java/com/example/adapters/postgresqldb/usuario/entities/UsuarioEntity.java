package com.example.adapters.postgresqldb.usuario.entities;



import com.example.domain.models.usuario.Usuario;

import lombok.*;


import org.springframework.beans.BeanUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;  
@Entity
@Table(name = "usuario")  
@Data
@NoArgsConstructor
@AllArgsConstructor

// Estructura de las bases de datos, con notaciones voy a establecer como son las bases de datos
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    private String dateOfBirth;
    private String address;
    @Column(nullable = false) 
    private String token;
    @Column(length = 120) 
    private String password;
    @Column(length = 50)
    private String mobilePhone;
    @Column(length = 50)
    private String email;

    public UsuarioEntity(Usuario usuario) {
        if (usuario !=null) {
            //modificamos qui
            BeanUtils.copyProperties(usuario, this, "id");
            
        }
    }

    public void fromUsuarioEntity(UsuarioEntity usuarioEntity) {

        if (usuarioEntity !=null) { 
            //modificamos qui
            BeanUtils.copyProperties(usuarioEntity, this, "id");
        }
    }




    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (email.equals(((UsuarioEntity) obj).email));
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", token='" + token + '\'' +
                ", password='" + password + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void fromUsuario(Usuario usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    public Usuario toUsuario() {
        Usuario usuairo = new Usuario();
        BeanUtils.copyProperties(this, usuairo);
        return usuairo;
    }

    


}