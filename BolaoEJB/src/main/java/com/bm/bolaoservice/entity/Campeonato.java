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
@SequenceGenerator(name = "CAM_SEQ", sequenceName = "CAMPEONATO_SEQ", allocationSize = 1, initialValue = 1)
@NamedQueries({
    @NamedQuery(name = "Campeonato.findAll", query = "SELECT c FROM Campeonato c"),
    @NamedQuery(name = "Campeonato.findByIdCampeonato", query = "SELECT c FROM Campeonato c WHERE c.id = :idCampeonato"),
    @NamedQuery(name = "Campeonato.findByNome", query = "SELECT c FROM Campeonato c WHERE UPPER(c.nome) LIKE  :nome  ORDER BY c.nome ASC"),
    @NamedQuery(name = "Campeonato.findByQtdEquipe", query = "SELECT c FROM Campeonato c WHERE c.qtdEquipe = :qtdEquipe"),
    @NamedQuery(name = "Campeonato.findByDatainicio", query = "SELECT c FROM Campeonato c WHERE c.dataInicio = :datainicio"),
    @NamedQuery(name = "Campeonato.findByDatafinal", query = "SELECT c FROM Campeonato c WHERE c.dataFinal = :datafinal"),
    @NamedQuery(name = "Campeonato.findByDataInicioBetweenStatus", query = "SELECT c FROM Campeonato c WHERE  c.status= :status   AND  c.dataInicio BETWEEN :datacomeco and :datafim  ORDER BY c.dataInicio ASC"),
    @NamedQuery(name = "Campeonato.findByStatus", query = "SELECT c FROM Campeonato c WHERE c.status = :status ORDER BY c.nome ASC"),    
    @NamedQuery(name = "Campeonato.findByUsuario", query = "SELECT c FROM Campeonato c WHERE c.usuario.id = :id")        
})
public class Campeonato implements AbstractEntity {

    private static final long serialVersionUID = -542156336692445325L;

    @Id
    @GeneratedValue(generator = "CAM_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CAMPEONATO")
    private Long id;
    private String nome;
    @Column(name = "QTD_EQUIPE")
    private Integer qtdEquipe;
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Temporal(TemporalType.DATE)
    private Date dataFinal;
    private String status;
    private Integer regra1;
    private Integer regra2;
    private Integer regra3;
    private Integer regra4;
    private Integer regra5;
    private Integer regra6;
    private Integer regra7;
    private Integer regra8;    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "campeonato")
    private List<PontuacaoUsuario> pontuacaoUsuarioList;    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "campeonato")
    private List<Partida> partidaList;     
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "campeonato")
    private List<PontuacaoEquipe> pontuacaoEquipList;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    private Usuario usuario;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdEquipe() {
        return qtdEquipe;
    }

    public void setQtdEquipe(Integer qtdEquipe) {
        this.qtdEquipe = qtdEquipe;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<PontuacaoUsuario> getPontuacaoUsuarioList() {
        return pontuacaoUsuarioList;
    }

    public void setPontuacaoUsuarioList(List<PontuacaoUsuario> pontuacaoUsuarioList) {
        this.pontuacaoUsuarioList = pontuacaoUsuarioList;
    }

    @XmlTransient
    public List<Partida> getPartidaList() {
        return partidaList;
    }

    public void setPartidaList(List<Partida> partidaList) {
        this.partidaList = partidaList;
    }

    @XmlTransient
    public List<PontuacaoEquipe> getPontuacaoEquipList() {
        return pontuacaoEquipList;
    }

    public void setPontuacaoEquipList(List<PontuacaoEquipe> pontuacaoEquipList) {
        this.pontuacaoEquipList = pontuacaoEquipList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getRegra1() {
        return regra1;
    }

    public void setRegra1(Integer regra1) {
        this.regra1 = regra1;
    }

    public Integer getRegra2() {
        return regra2;
    }

    public void setRegra2(Integer regra2) {
        this.regra2 = regra2;
    }

    public Integer getRegra3() {
        return regra3;
    }

    public void setRegra3(Integer regra3) {
        this.regra3 = regra3;
    }

    public Integer getRegra4() {
        return regra4;
    }

    public void setRegra4(Integer regra4) {
        this.regra4 = regra4;
    }

    public Integer getRegra5() {
        return regra5;
    }

    public void setRegra5(Integer regra5) {
        this.regra5 = regra5;
    }

    public Integer getRegra6() {
        return regra6;
    }

    public void setRegra6(Integer regra6) {
        this.regra6 = regra6;
    }

    public Integer getRegra7() {
        return regra7;
    }

    public void setRegra7(Integer regra7) {
        this.regra7 = regra7;
    }

    public Integer getRegra8() {
        return regra8;
    }

    public void setRegra8(Integer regra8) {
        this.regra8 = regra8;
    }

}
