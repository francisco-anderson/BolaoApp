/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb;

import com.bm.bolaoservice.dao.EquipeDAO;
import com.bm.bolaoservice.entity.Equipe;
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
public class EquipeBean implements EquipeRemote {

    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    private static final long serialVersionUID = 8736019182406840236L;

    @Override
    public List<Equipe> buscarPorNome(String nome) {
        EquipeDAO dao = new EquipeDAO(em);
        return dao.buscarPorNome(nome);
    }

    @Override
    public List<Equipe> buscarPorUsuario(Usuario usuario) {
        EquipeDAO dao = new EquipeDAO(em);
        return dao.buscarPorUsuario(usuario.getId());
    }

    @Override
    public void remover(Equipe equipe) {
        EquipeDAO dao = new EquipeDAO(em);
        dao.remove(equipe.getId());
    }

    @Override
    public Equipe salvar(Equipe equipe) {
        EquipeDAO dao = new EquipeDAO(em);
        return dao.save(equipe);
    }

    @Override
    public Equipe buscarPorId(Long id) {
        EquipeDAO dao = new EquipeDAO(em);
        return dao.find(id);
    }

    @Override
    public List<Equipe> buscarEquipesPorCampeonato(Long id) {
        EquipeDAO dao = new EquipeDAO(em);
        return dao.buscarEquipesPorCampeonato(id);
    }

    @Override
    public List<Equipe> buscarEquipePorPontuacaoGrupo(Long idUsuario, Long idCampeonato, String tipo) {
        EquipeDAO dao = new EquipeDAO(em);
        return dao.buscarEquipePorPontuacaoGrupo(idUsuario, idCampeonato, tipo);
        
    }

}
