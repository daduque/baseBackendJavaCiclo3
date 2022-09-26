package edu.co.utp.daanduque.holamundospring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import edu.co.utp.daanduque.holamundospring.models.Usuario;

@Repository // @Repository es una anotación que indica que la clase es un repositorio
@Transactional //para que se ejecute la transaccion
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext //
    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String hql = "FROM Usuario as usuario ORDER BY usuario.id";
        return (List<Usuario>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Usuario getSingleUser(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public void deleteUsuario(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
        
    }

    @Override
    public void createUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario checkEmailPassword(Usuario usuario) {
        
        String hql = "FROM Usuario as usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(hql)
        .setParameter("email", usuario.getEmail()).getResultList();

        if(lista.size() == 0){
            return null;
        }
        String hash = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create();
        if(argon2.verify(hash, usuario.getPassword())){
            return lista.get(0);
        }
        
        return null;
        
        
    }

    @Override
    public void editSingleUser(Long id, Usuario usuario) {

        Usuario usuarioEdit = getSingleUser(id);
        usuarioEdit.setNombre(usuario.getNombre());
        usuarioEdit.setApellido(usuario.getApellido());
        usuarioEdit.setEmail(usuario.getEmail());
        usuarioEdit.setPassword(usuario.getPassword());
        entityManager.flush();

        return;


        
    }

    // @Override
    // public boolean checkEmailPassword(Usuario usuario) {

        
    //     String hql = "FROM Usuario as usuario WHERE email = :email AND password = :password ORDER BY usuario.id";
    //     List<Usuario> lista = entityManager.createQuery(hql)
    //     .setParameter("email", usuario.getEmail())
    //     .setParameter("password", usuario.getPassword()).getResultList();
        
    //     return !lista.isEmpty();
    // }




}
