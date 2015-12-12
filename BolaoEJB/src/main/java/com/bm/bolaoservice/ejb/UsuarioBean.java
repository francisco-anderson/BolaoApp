/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb;

import com.bm.bolaoservice.dao.UsuarioDAO;
import com.bm.bolaoservice.entity.Usuario;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anderson
 */
@Stateless
public class UsuarioBean implements UsuarioRemote {

    private static final long serialVersionUID = -466545973937668727L;

    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    @Override
    public List<Usuario> consultarTodos() {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.consultarTodosUsuarios();
    }

    @Override
    public Usuario consultaPorId(Long id) {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.find(id);
    }

    @Override
    public Usuario consultarLogin(String email, String senha) {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.consultarUsuarioLogin(email, senha);
    }

    @Override
    public String novoUsuario(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO(em);
        if (dao.consultarUsuarioEmail(usuario.getEmail()) != null) {
            return "E-mail já Cadastrado";
        }
        dao.save(usuario);
        return "OK";
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO(em);
        return dao.save(usuario);
    }

    @Override
    public String editarUsuario(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO(em);
        Usuario user = dao.consultarUsuarioEmail(usuario.getEmail());
        if(user==null){
           dao.save(usuario);
           return "OK";                
        } else {
             if(Objects.equals(user.getId(), usuario.getId())){
                dao.save(usuario);
                return "OK";
            } else {
                return "E-mail já cadastrado";
            }
        }
    }
    
    

}
