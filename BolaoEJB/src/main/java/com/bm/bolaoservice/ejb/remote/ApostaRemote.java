/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb.remote;

import com.bm.bolaoservice.entity.Aposta;
import com.bm.bolaoservice.entity.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Anderson
 */
@Remote
public interface ApostaRemote extends Serializable{
    
    public Aposta buscarPorId(Long id);
    
    public List<Aposta> buscarPorUsuario(Usuario usuario);
    
    public Aposta salvar(Aposta aposta);
    
}
