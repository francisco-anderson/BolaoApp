/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb;

import com.bm.bolaoservice.dao.PartidaDAO;
import com.bm.bolaoservice.entity.Partida;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anderson
 */
@Stateless
public class PartidaBean implements PartidaRemote {

    private static final long serialVersionUID = 6852748242080202548L;

    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    @Override
    public List<Partida> buscarPorCampeonato(Long id) {
        PartidaDAO dao = new PartidaDAO(em);
        return dao.buscarPorCampeonato(id);
    }

    @Override
    public Partida salvar(Partida partida) {
        PartidaDAO dao = new PartidaDAO(em);
        return dao.save(partida);
    }

    @Override
    public Partida buscarPartidaPorId(Long id) {
        PartidaDAO dao = new PartidaDAO(em);
        return dao.find(id);
    }

}
