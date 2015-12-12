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
@Table(name = "PONTUACAO_EQUIPE")
@Entity
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "PONT_EQUIP", sequenceName = "PONTUACAO_EQUIPE_SEQ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PontuacaoEquipe.findByEquipe",query = "SELECT p FROM PontuacaoEquipe p WHERE p.equipe.id = :idEquipe"),
    @NamedQuery(name = "PontuacaoEquipe.findByCampeonato",query = "SELECT p FROM PontuacaoEquipe p WHERE p.campeonato.id = :idCampeonato"),
    @NamedQuery(name = "PontuacaoEquipe.findByEquipeAndCampeonato",query = "SELECT p FROM PontuacaoEquipe p WHERE p.campeonato.id = :idCampeonato AND p.equipe.id = :idEquipe")
})
public class PontuacaoEquipe implements AbstractEntity {

    private static final long serialVersionUID = -7067194567840944632L;
    
    @Id
    @Column(name = "ID_PONTUACAO")
    @GeneratedValue(generator = "PONT_EQUIP",strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer vitorias;
    private Integer derrotas;
    private Integer empates;
    private Integer golspros;
    private Integer golscontras;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_EQUIPE",referencedColumnName = "ID_EQUIPE")
    private Equipe equipe;
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

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }

    public Integer getGolspros() {
        return golspros;
    }

    public void setGolspros(Integer golspros) {
        this.golspros = golspros;
    }

    public Integer getGolscontras() {
        return golscontras;
    }

    public void setGolscontras(Integer golscontras) {
        this.golscontras = golscontras;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
    

}
