/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb;

import com.bm.bolaoservice.entity.Partida;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Anderson
 */
@Remote
public interface PartidaRemote extends Serializable{
    
    public List<Partida> buscarPorCampeonato(Long id);
    
    public Partida salvar(Partida partida);
    
    public Partida buscarPartidaPorId(Long id);
    
}
