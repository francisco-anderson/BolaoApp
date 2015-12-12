/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb;

import com.bm.bolaoservice.entity.ApostaResultado;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Anderson
 */
@Remote
public interface ApostaResultadoRemote extends Serializable{
    
    public ApostaResultado buscarPorId(Long idAposta,Long Equipe,Long Partida);
    
    public List<ApostaResultado> buscarPorAposta(Long id);
    
    public List<ApostaResultado> buscarPorEquipe(Long id);
    
    public List<ApostaResultado> buscarPorPartida(Long id);
    
    public List<ApostaResultado> buscarPorEquipePartida(Long idEquipe,Long idPartida);
    
    public ApostaResultado salvar(ApostaResultado apostaEquipePartida);
    
}
