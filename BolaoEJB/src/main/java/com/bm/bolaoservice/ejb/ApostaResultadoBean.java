/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb;

import com.bm.bolaoservice.dao.ApostaResultadoDAO;
import com.bm.bolaoservice.entity.ApostaResultado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anderson
 */
@Stateless
public class ApostaResultadoBean implements ApostaResultadoRemote {

    private static final long serialVersionUID = 600675813423842596L;
    
    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    @Override
    public ApostaResultado buscarPorId(Long idAposta, Long Equipe, Long Partida) {
        ApostaResultadoDAO dao = new ApostaResultadoDAO(em);
        return dao.buscarPorApostaEquipePartida(idAposta, Equipe, Partida);
    }

    @Override
    public List<ApostaResultado> buscarPorAposta(Long id) {
        ApostaResultadoDAO dao = new ApostaResultadoDAO(em);
        return dao.buscarPorAposta(id);
    }

    @Override
    public List<ApostaResultado> buscarPorEquipe(Long id) {
        ApostaResultadoDAO dao = new ApostaResultadoDAO(em);
        return dao.buscarPorEquipe(id);
    }

    @Override
    public List<ApostaResultado> buscarPorPartida(Long id) {
        ApostaResultadoDAO dao = new ApostaResultadoDAO(em);
        return dao.buscarPorPartida(id);
    }

    @Override
    public ApostaResultado salvar(ApostaResultado apostaEquipePartida) {
        ApostaResultadoDAO dao = new ApostaResultadoDAO(em);
        return dao.save(apostaEquipePartida);
    }

    @Override
    public List<ApostaResultado> buscarPorEquipePartida(Long idEquipe, Long idPartida) {
        ApostaResultadoDAO dao = new ApostaResultadoDAO(em);
        return  dao.buscarPorEquipePartida(idEquipe, idPartida);
    }

}
