/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.entity;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 220460
 */
@XmlRootElement
@Entity
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "EQUIPE_SEQ", sequenceName = "EQUIPE_SEQ")
@NamedQueries({
    @NamedQuery(name = "Equipe.findAll", query = "SELECT e FROM Equipe e"),
    @NamedQuery(name = "Equipe.findByIdEquipe", query = "SELECT e FROM Equipe e WHERE e.id = :idEquipe"),
    @NamedQuery(name = "Equipe.findByNome", query = "SELECT e FROM Equipe e WHERE UPPER(e.nome) LIKE :nome ORDER BY e.nome ASC"),
    @NamedQuery(name = "Equipe.findEquipeByCampeonato", query = "SELECT DISTINCT e FROM Equipe e INNER JOIN E.resultadoList as EP INNER JOIN EP.partida AS p WHERE p.campeonato.id = :id ORDER BY e.nome ASC"),
    @NamedQuery(name = "Equipe.findByUsuario", query = "SELECT e FROM Equipe e WHERE e.usuario.id = :idUsuario"),
    @NamedQuery(name = "Equipe.findEquipeByPontuacaoPorGrupo",query = "SELECT e FROM Equipe e INNER JOIN e.pontuacaoEquipeList AS pe INNER JOIN pe.campeonato AS p WHERE p.usuario.id = :idUsuario AND p.id = :idCampeonato AND e.id IN (SELECT n.equipe.id FROM Resultado n INNER JOIN n.partida as o WHERE o.tipo = :tipo) ")})
public class Equipe implements AbstractEntity {

    private static final long serialVersionUID = -5667197242867752204L;

    @Id
    @GeneratedValue(generator = "EQUIPE_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_EQUIPE")
    private Long id;
    private String nome;    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "equipe")    
    private List<Resultado> resultadoList;   
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "equipe")    
    private List<ApostaResultado> apostaResultadoList;    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "equipe")    
    private List<PontuacaoEquipe> pontuacaoEquipeList;
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

    @XmlTransient
    public List<Resultado> getResultadoList() {
        return resultadoList;
    }

    public void setResultadoList(List<Resultado> resultadoList) {
        this.resultadoList = resultadoList;
    }

    @XmlTransient
    public List<ApostaResultado> getApostaResultadoList() {
        return apostaResultadoList;
    }

    public void setApostaResultadoList(List<ApostaResultado> apostaResultadoList) {
        this.apostaResultadoList = apostaResultadoList;
    }

    @XmlTransient
    public List<PontuacaoEquipe> getPontuacaoEquipeList() {
        return pontuacaoEquipeList;
    }

    public void setPontuacaoEquipeList(List<PontuacaoEquipe> pontuacaoEquipeList) {
        this.pontuacaoEquipeList = pontuacaoEquipeList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
