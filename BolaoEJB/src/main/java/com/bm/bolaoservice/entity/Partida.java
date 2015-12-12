/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Anderson
 */
@XmlRootElement
@Entity
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "PAR_SEQ", sequenceName = "PARTIDA_SEQ")
@NamedQueries({
    @NamedQuery(name = "Partida.findAll", query = "SELECT p FROM Partida p"),
    @NamedQuery(name = "Partida.findByIdPartida", query = "SELECT p FROM Partida p WHERE p.id = :idPartida"),
    @NamedQuery(name = "Partida.findByFase", query = "SELECT p FROM Partida p WHERE p.fase = :fase"),
    @NamedQuery(name = "Partida.findByTipo", query = "SELECT p FROM Partida p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Partida.findByDataPartida", query = "SELECT p FROM Partida p WHERE p.dataPartida = :dataPartida"),
    @NamedQuery(name = "Partida.findByLocalPartida", query = "SELECT p FROM Partida p WHERE p.localPartida = :localPartida"),
    @NamedQuery(name = "Partida.findByStatus", query = "SELECT p FROM Partida p WHERE p.status = :status"),
    @NamedQuery(name = "Partida.findByCampeonato",query = "SELECT p FROM Partida p WHERE p.campeonato.id = :idCampeonato")})
public class Partida implements AbstractEntity {

    private static final long serialVersionUID = 6073361808409878750L;

    @Id
    @GeneratedValue(generator = "PAR_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_PARTIDA")
    private Long id;
    private String fase;
    private String tipo;
    @Column(name = "NUMERO_PARTIDA")
    private Integer numeroPartida;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_PARTIDA")
    private Date dataPartida;
    @Column(name = "LOCAL_PARTIDA")
    private String localPartida;
    private String status;    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "partida")    
    private List<ApostaResultado> apostaResultadoList;    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "partida")    
    private List<Resultado> resultadoList;
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

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Integer getNumeroPartida(){
        return this.numeroPartida;
    }
    
    public void setNumeroPartida(Integer numeroPartida){
        this.numeroPartida=numeroPartida;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getLocalPartida() {
        return localPartida;
    }

    public void setLocalPartida(String localPartida) {
        this.localPartida = localPartida;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<ApostaResultado> getApostaResultadoList() {
        return apostaResultadoList;
    }

    public void setApostaResultadoList(List<ApostaResultado> apostaResultadoList) {
        this.apostaResultadoList = apostaResultadoList;
    }

    @XmlTransient
    public List<Resultado> getResultadoList() {
        return resultadoList;
    }

    public void setResultadoList(List<Resultado> resultadoList) {
        this.resultadoList = resultadoList;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

}
