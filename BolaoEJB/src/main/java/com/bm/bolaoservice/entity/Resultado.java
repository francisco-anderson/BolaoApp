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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anderson
 */
@XmlRootElement
@Entity
@SequenceGenerator(name = "RES_SEQ",sequenceName = "RESULTADO_SEQ",allocationSize = 1,initialValue = 1)
@NamedQueries({
    @NamedQuery(name = "Resultado.findAll", query = "SELECT e FROM Resultado e"),
    @NamedQuery(name = "Resultado.findByGols", query = "SELECT e FROM Resultado e WHERE e.gol = :gols"),
    @NamedQuery(name = "Resultado.findByGolsPenalti", query = "SELECT e FROM Resultado e WHERE e.golPenalti = :golsPenalti"),
    @NamedQuery(name = "Resultado.findByIdEquipe", query = "SELECT e FROM Resultado e WHERE e.equipe.id = :idEquipe"),
    @NamedQuery(name = "Resultado.findByIdPartida", query = "SELECT e FROM Resultado e WHERE e.partida.id = :idPartida"),
    @NamedQuery(name = "Resultado.finByIdPartidaAndIdEquipe", query = "SELECT e FROM Resultado e WHERE e.partida.id = :idPartida AND e.equipe.id = :idEquipe")})
public class Resultado implements AbstractEntity {

    private static final long serialVersionUID = -3182922397635831126L;


    @Id
    @GeneratedValue(generator = "RES_SEQ",strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_RESULTADO")
    private Long id;
    @Column(name = "GOLS")
    private Integer gol;
    @Column(name = "GOLS_PENALTI")
    private Integer golPenalti;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_EQUIPE", referencedColumnName = "ID_EQUIPE")
    private Equipe equipe;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_PARTIDA", referencedColumnName = "ID_PARTIDA")
    private Partida partida;

    public Resultado() {
    }

 

    public Integer getGol() {
        return gol;
    }

    public void setGol(Integer gol) {
        this.gol = gol;
    }

    public Integer getGolPenalti() {
        return golPenalti;
    }

    public void setGolPenalti(Integer golPenalti) {
        this.golPenalti = golPenalti;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
