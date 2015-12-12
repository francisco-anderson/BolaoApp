/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anderson
 */
@XmlRootElement
@Table(name = "PONTUACAO_USUARIO")
@Entity
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "PON_SEQ", sequenceName = "PONTUACAO_USUARIO_SEQ")
@NamedQueries({
    @NamedQuery(name = "PontuacaoUsuario.findAll", query = "SELECT p FROM PontuacaoUsuario p"),
    @NamedQuery(name = "PontuacaoUsuario.findByIdPontuacao", query = "SELECT p FROM PontuacaoUsuario p WHERE p.id = :idPontuacao"),
    @NamedQuery(name = "PontuacaoUsuario.findByPontos", query = "SELECT p FROM PontuacaoUsuario p WHERE p.pontos = :pontos"),
    @NamedQuery(name = "PontuacaoUsuario.findByUsuario",query = "SELECT p FROM PontuacaoUsuario p WHERE p.usuario.id = :idUsuario"),
    @NamedQuery(name = "PontuacaoUsuario.findByCampeonato",query = "SELECT p FROM PontuacaoUsuario p WHERE p.campeonato.id = :idCampeonato")})
public class PontuacaoUsuario implements AbstractEntity {

    private static final long serialVersionUID = 4015303586229474633L;

    @Id
    @GeneratedValue(generator = "PON_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_PONTUACAO")
    private Long id;
    private Integer pontos;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    private Usuario usuario;    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_CAMPEONATO", referencedColumnName = "ID_CAMPEONATO")
    private Campeonato campeonato;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

  
}
