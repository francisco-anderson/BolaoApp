/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb.remote;

import com.bm.bolaoservice.entity.Campeonato;
import com.bm.bolaoservice.entity.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Anderson
 */
@Remote
public interface CampeonatoRemote extends Serializable{
    
    public Campeonato consultaPorId(Long id);
    
    public List<Campeonato> buscarPorNome(String nome);
    
    public List<Campeonato> buscarPorDatainicioStatus(Date datacomeço,Date datafim, String status);
    
    public List<Campeonato> buscarPorStatus(String status);  
        
    public List<Campeonato> buscarPorUsuario(Usuario usuario);
    
    public Campeonato salvar(Campeonato campeonato);
    
}
