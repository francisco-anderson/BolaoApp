/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb;

import com.bm.bolaoservice.entity.PontuacaoEquipe;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Anderson
 */
@Remote
public interface PontuacaoEquipeRemote extends Serializable{
    
    public List<PontuacaoEquipe> buscarPorEquipe(Long id);
    
    public List<PontuacaoEquipe> buscarPorCampeonato(Long id);
    
    public PontuacaoEquipe buscarPorCampeonatoEquipe(Long idCampeonato,Long idEquipe);
    
    public PontuacaoEquipe salvar(PontuacaoEquipe pontuacaoEquipe);
    
}
