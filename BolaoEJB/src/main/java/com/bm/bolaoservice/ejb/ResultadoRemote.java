/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb;

import com.bm.bolaoservice.entity.Resultado;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Anderson
 */
@Remote
public interface ResultadoRemote extends Serializable{
    
    public Resultado buscarPorId(Long idEquipe, Long idPartida);
    
    public List<Resultado> buscarPorEquipe(Long id);
    
    public List<Resultado> buscarPorPartida(Long id);
    
    public Resultado salvar(Resultado equipePartida);
    
}
