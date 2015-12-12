/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb;

import com.bm.bolaoservice.dao.PontuacaoEquipeDAO;
import com.bm.bolaoservice.entity.PontuacaoEquipe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anderson
 */
@Stateless
public class PontuacaoEquipeBean implements PontuacaoEquipeRemote {

    private static final long serialVersionUID = -1579104739063372774L;

    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    @Override
    public List<PontuacaoEquipe> buscarPorEquipe(Long id) {
        PontuacaoEquipeDAO dao = new PontuacaoEquipeDAO(em);
        return dao.buscarPorEquipe(id);
    }

    @Override
    public List<PontuacaoEquipe> buscarPorCampeonato(Long id) {
        PontuacaoEquipeDAO dao = new PontuacaoEquipeDAO(em);
        return dao.buscarPorCampeonato(id);
    }

    @Override
    public PontuacaoEquipe buscarPorCampeonatoEquipe(Long idCampeonato, Long idEquipe) {
        PontuacaoEquipeDAO dao = new PontuacaoEquipeDAO(em);
        return dao.buscarPorCampeonatoEquipe(idCampeonato, idEquipe);
    }

    @Override
    public PontuacaoEquipe salvar(PontuacaoEquipe pontuacaoEquipe) {
        PontuacaoEquipeDAO dao = new PontuacaoEquipeDAO(em);
        return dao.save(pontuacaoEquipe);
    }

}
