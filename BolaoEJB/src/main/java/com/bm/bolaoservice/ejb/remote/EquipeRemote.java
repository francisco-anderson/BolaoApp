/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.ejb.remote;

import com.bm.bolaoservice.entity.Equipe;
import com.bm.bolaoservice.entity.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Anderson
 */
@Remote
public interface EquipeRemote extends Serializable{
    
    public List<Equipe> buscarPorNome(String nome);
    
    public List<Equipe> buscarPorUsuario (Usuario usuario);
    
    public void remover(Equipe equipe);
    
    public Equipe salvar (Equipe equipe);
    
    public Equipe buscarPorId(Long id);
    
    public List<Equipe> buscarEquipesPorCampeonato(Long id);
    
    public List<Equipe> buscarEquipePorPontuacaoGrupo(Long idUsuario,Long idCampeonato,String tipo);
    
}
