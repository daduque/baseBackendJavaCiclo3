package edu.co.utp.daanduque.holamundospring.dao;

import java.util.List;

import edu.co.utp.daanduque.holamundospring.models.Usuario;

public interface UsuarioDao {
    
    List<Usuario> getUsuarios();

    void deleteUsuario(Long id);

    void createUsuario(Usuario usuario);

    Usuario checkEmailPassword(Usuario usuario);

    Usuario getSingleUser(Long id);

    void editSingleUser(Long id, Usuario usuario);

}
