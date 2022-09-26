package edu.co.utp.daanduque.holamundospring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
public class Usuario {


    @Id
    @Getter @Setter @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellido")
    private String apellido;
    
    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "password")
    private String password;

    @Getter @Setter @Column(name = "telefono")
    private String telefono;

    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public String getNombre() {
    //     return nombre;
    // }

    // public void setNombre(String nombre) {
    //     this.nombre = nombre;
    // }


    // public String getApellido() {
    //     return apellido;
    // }

    // public void setApellido(String apellido) {
    //     this.apellido = apellido;
    // }

    
    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }


    // public String getPassword() {
    //     return password;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    
    
    // public String getTelefono() {
    //     return telefono;
    // }
    
    // public void setTelefono(String telefono) {
    //     this.telefono = telefono;
    // }
    
    // public Usuario(String nombre, String apellido, String email, String password, String telefono) {
    //     this.nombre = nombre;
    //     this.apellido = apellido;
    //     this.email = email;
    //     this.password = password;
    //     this.telefono = telefono;
    // }
    
}
