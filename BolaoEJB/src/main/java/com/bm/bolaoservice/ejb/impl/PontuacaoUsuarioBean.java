/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb.impl;

import com.bm.bolaoservice.ejb.remote.PontuacaoUsuarioRemote;
import com.bm.bolaoservice.entity.Campeonato;
import com.bm.bolaoservice.entity.PontuacaoUsuario;
import com.bm.bolaoservice.entity.Usuario;
import com.bm.bolaoservice.repositories.dao.PontuacaoUsuarioDAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anderson
 */
@Stateless
public class PontuacaoUsuarioBean implements PontuacaoUsuarioRemote {

	private static final long serialVersionUID = -2159741467077691973L;

	@PersistenceContext(unitName = "persistencia")
	private EntityManager em;

	protected PontuacaoUsuarioBean() {

	}

	@Override
	public List<PontuacaoUsuario> buscarPorUsuario(Usuario usuario) {
		PontuacaoUsuarioDAO dao = new PontuacaoUsuarioDAO(em);
		return dao.buscarPorUsuario(usuario.getId());
	}

	@Override
	public List<PontuacaoUsuario> buscarPorCampeonato(Campeonato campeonato) {
		PontuacaoUsuarioDAO dao = new PontuacaoUsuarioDAO(em);
		return dao.buscarPorCampeonato(campeonato.getId());
	}

	@Override
	public PontuacaoUsuario salvar(PontuacaoUsuario pontuacaoUsuario) {
		PontuacaoUsuarioDAO dao = new PontuacaoUsuarioDAO(em);
		return dao.save(pontuacaoUsuario);
	}

}
