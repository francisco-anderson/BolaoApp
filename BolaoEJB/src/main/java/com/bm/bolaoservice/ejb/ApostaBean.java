/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb;

import com.bm.bolaoservice.dao.ApostaDAO;
import com.bm.bolaoservice.entity.Aposta;
import com.bm.bolaoservice.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anderson
 */
@Stateless
public class ApostaBean implements ApostaRemote {

    private static final long serialVersionUID = -8216951852189554446L;

    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    @Override
    public Aposta buscarPorId(Long id) {
        ApostaDAO dao = new ApostaDAO(em);
        return dao.find(id);
    }

    @Override
    public List<Aposta> buscarPorUsuario(Usuario usuario) {
        ApostaDAO dao = new ApostaDAO(em);
        return dao.buscarPorUsuario(usuario.getId());
    }
    
    @Override
    public Aposta salvar(Aposta aposta){
        ApostaDAO dao = new ApostaDAO(em);
        return dao.save(aposta);
    }

}
