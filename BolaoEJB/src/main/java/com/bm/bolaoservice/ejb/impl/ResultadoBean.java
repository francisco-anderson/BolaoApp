/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb.impl;

import com.bm.bolaoservice.ejb.remote.ResultadoRemote;
import com.bm.bolaoservice.entity.Resultado;
import com.bm.bolaoservice.repositories.dao.ResultadoDAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anderson
 */
@Stateless
public class ResultadoBean implements ResultadoRemote {

	private static final long serialVersionUID = -4478206095350788909L;

	@PersistenceContext(unitName = "persistencia")
	private EntityManager em;

	protected ResultadoBean() {

	}

	@Override
	public Resultado buscarPorId(Long idEquipe, Long idPartida) {
		ResultadoDAO dao = new ResultadoDAO(em);
		return dao.buscarPorPartidaEquipe(idPartida, idEquipe);
	}

	@Override
	public List<Resultado> buscarPorEquipe(Long id) {
		ResultadoDAO dao = new ResultadoDAO(em);
		return dao.buscarPorEquipe(id);
	}

	@Override
	public List<Resultado> buscarPorPartida(Long id) {
		ResultadoDAO dao = new ResultadoDAO(em);
		return dao.buscarPorPartida(id);
	}

	@Override
	public Resultado salvar(Resultado equipePartida) {
		ResultadoDAO dao = new ResultadoDAO(em);
		return dao.save(equipePartida);
	}

}
