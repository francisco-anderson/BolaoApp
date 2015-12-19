/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb.remote;

import com.bm.bolaoservice.entity.Campeonato;
import com.bm.bolaoservice.entity.PontuacaoUsuario;
import com.bm.bolaoservice.entity.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Anderson
 */
@Remote
public interface PontuacaoUsuarioRemote extends Serializable{
    
    public List<PontuacaoUsuario> buscarPorUsuario(Usuario usuario);
    
    public List<PontuacaoUsuario> buscarPorCampeonato(Campeonato campeonato);
    
    public PontuacaoUsuario salvar(PontuacaoUsuario pontuacaoUsuario);
    
}
