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
@Entity
@Table(name = "APOSTA_RESULTADO")
@SequenceGenerator(name = "ARES_SEQ", sequenceName = "APOSTA_RESULTADO_SEQ", allocationSize = 1, initialValue = 1)
@NamedQueries({
    @NamedQuery(name = "ApostaResultado.findAll", query = "SELECT a FROM ApostaResultado a"),
    @NamedQuery(name = "ApostaResultado.findByGols", query = "SELECT a FROM ApostaResultado a WHERE a.gol = :gols"),
    @NamedQuery(name = "ApostaResultado.findByGolsPenalti", query = "SELECT a FROM ApostaResultado a WHERE a.golPenalti = :golsPenalti"),
    @NamedQuery(name = "ApostaResultado.findByIdAposta", query = "SELECT a FROM ApostaResultado a WHERE a.aposta.id = :idAposta"),
    @NamedQuery(name = "ApostaResultado.findByIdPartida", query = "SELECT a FROM ApostaResultado a WHERE a.partida.id = :idPartida"),
    @NamedQuery(name = "ApostaResultado.findByIdEquipe", query = "SELECT a FROM ApostaResultado a WHERE a.equipe.id = :idEquipe"),
    @NamedQuery(name = "ApostaResultado.findByIdEquipeAndPartida", query = "SELECT a FROM ApostaResultado a WHERE a.equipe.id = :idEquipe AND a.partida.id = :idPartida"),
    @NamedQuery(name = "ApostaResultado.findByIdApostaAndIdEquipeAndIdPartida", query = "SELECT a FROM ApostaResultado a WHERE a.aposta.id = :idAposta AND a.equipe.id = :idEquipe AND a.partida.id = :idPartida")})
public class ApostaResultado implements AbstractEntity {

    private static final long serialVersionUID = -5508100380517081748L;


    @Id
    @GeneratedValue(generator = "ARES_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_APOSTA_RESULTADO")
    private Long id;
    @Column(name = "GOLS")
    private Integer gol;
    @Column(name = "GOLS_PENALTI")
    private Integer golPenalti;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_APOSTA", referencedColumnName = "ID_APOSTA")
    private Aposta aposta;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_EQUIPE", referencedColumnName = "ID_EQUIPE")
    private Equipe equipe;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_PARTIDA", referencedColumnName = "ID_PARTIDA")
    private Partida partida;

    public ApostaResultado() {
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

    public Aposta getAposta() {
        return aposta;
    }

    public void setAposta(Aposta aposta) {
        this.aposta = aposta;
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
