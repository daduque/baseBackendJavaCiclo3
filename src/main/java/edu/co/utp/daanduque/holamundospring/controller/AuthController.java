package edu.co.utp.daanduque.holamundospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.co.utp.daanduque.holamundospring.dao.UsuarioDao;
import edu.co.utp.daanduque.holamundospring.models.Usuario;
import edu.co.utp.daanduque.holamundospring.utils.JWTUtil;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil = new JWTUtil();
    
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public String loginUsuario(@RequestBody Usuario usuario) {
        
        Usuario usuarioLogin = usuarioDao.checkEmailPassword(usuario);
        if(usuarioLogin != null) {

            String tokenJWT = jwtUtil.create(String.valueOf(usuarioLogin.getId()), usuarioLogin.getEmail());

            return tokenJWT;

        }

        return "Fatality";

    }

}
