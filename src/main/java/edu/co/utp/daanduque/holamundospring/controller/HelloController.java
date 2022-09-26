package edu.co.utp.daanduque.holamundospring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import edu.co.utp.daanduque.holamundospring.dao.UsuarioDao;
import edu.co.utp.daanduque.holamundospring.models.Usuario;
import edu.co.utp.daanduque.holamundospring.utils.JWTUtil;

@RestController
public class HelloController {
    
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    JWTUtil jwtUtil = new JWTUtil();
    
    // with token
    @RequestMapping(value = "/api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization") String token) {
        
        return jwtUtil.check(token)? usuarioDao.getUsuarios() : new ArrayList<Usuario>();

        // List<Usuario> usuarios = usuarioDao.getUsuarios();
        
        // return usuarios;

    }

    // without token
    // @RequestMapping(value = "/api/usuarios", method = RequestMethod.GET)
    // public List<Usuario> getUsuarios() {

    //    return usuarioDao.getUsuarios();
    // }


    @RequestMapping(value = "/api/usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id) {

        Usuario usuario = usuarioDao.getSingleUser(id);
        if(usuario != null && usuario.getId() != null) {
            return usuario;
        }
        return null;
    }

    public String hashPassword(String password) {
        Argon2 argon2 = Argon2Factory.create();
        String hash = argon2.hash(2, 65536, 1, password);
        return hash;
    }

    @RequestMapping(value = "/api/usuario/registrar", method = RequestMethod.POST)
    public void createUsuario(@RequestBody Usuario usuario) {

        String hash = hashPassword(usuario.getPassword());
        usuario.setPassword(hash);
        
        usuarioDao.createUsuario(usuario);

    }


    @RequestMapping(value = "/api/usuario/{id}/editar", method = RequestMethod.PUT)
    public void editUsuario(@PathVariable Long id, @RequestBody Usuario usuario){

        Usuario usuarioEdit = usuarioDao.getSingleUser(id);
        if(usuarioEdit != null && usuarioEdit.getId() != null) {          
            
            String hash = hashPassword(usuario.getPassword());
            usuario.setPassword(hash);
            usuarioDao.editSingleUser(id, usuario);
        }

    }

    @RequestMapping(value = "/api/usuario/{id}/eliminar", method = RequestMethod.DELETE)
    public void deleteUsuario(@PathVariable Long id){

        usuarioDao.deleteUsuario(id);
    }

    @RequestMapping(value = "/api/usuario/buscar", method = RequestMethod.GET)
    public Usuario searchUsuario(){
        Usuario usuario = new Usuario();
        return usuario;
    }
}
