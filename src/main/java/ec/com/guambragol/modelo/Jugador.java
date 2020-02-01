/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.guambragol.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author carlosballadares
 */
@Entity
@Table(name = "Jugador")
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j"),
    @NamedQuery(name = "Jugador.findByIdJugador", query = "SELECT j FROM Jugador j WHERE j.idJugador = :idJugador"),
    @NamedQuery(name = "Jugador.findByDorsal", query = "SELECT j FROM Jugador j WHERE j.dorsal = :dorsal")})
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idJugador")
    private Integer idJugador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dorsal")
    private Integer dorsal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador")
    private List<Carnet> carnetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador")
    private List<SancionesPartidos> sancionesPartidosList;
    @OneToMany(mappedBy = "idJugador")
    private List<JugadorPartido> jugadorPartidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador")
    private List<GolesPartido> golesPartidoList;
    @JoinColumn(name = "idPosicion", referencedColumnName = "idPosicion")
    @ManyToOne(optional = false)
    private Posicion idPosicion;
    @JoinColumn(name = "idClub", referencedColumnName = "idClub")
    @ManyToOne(optional = false)
    private Club idClub;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "idTipoJugador", referencedColumnName = "idTipoJugador")
    @ManyToOne(optional = false)
    private TipoJugador idTipoJugador;
    @OneToMany(mappedBy = "idJugador")
    private List<JugadorPartidfo> jugadorPartidfoList;

    public Jugador() {
    }

    public Jugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public Jugador(Integer idJugador, int dorsal) {
        this.idJugador = idJugador;
        this.dorsal = dorsal;
    }

    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public List<Carnet> getCarnetList() {
        return carnetList;
    }

    public void setCarnetList(List<Carnet> carnetList) {
        this.carnetList = carnetList;
    }

    public List<SancionesPartidos> getSancionesPartidosList() {
        return sancionesPartidosList;
    }

    public void setSancionesPartidosList(List<SancionesPartidos> sancionesPartidosList) {
        this.sancionesPartidosList = sancionesPartidosList;
    }

    public List<JugadorPartido> getJugadorPartidoList() {
        return jugadorPartidoList;
    }

    public void setJugadorPartidoList(List<JugadorPartido> jugadorPartidoList) {
        this.jugadorPartidoList = jugadorPartidoList;
    }

    public List<GolesPartido> getGolesPartidoList() {
        return golesPartidoList;
    }

    public void setGolesPartidoList(List<GolesPartido> golesPartidoList) {
        this.golesPartidoList = golesPartidoList;
    }

    public Posicion getIdPosicion() {
        return idPosicion;
    }

    public void setIdPosicion(Posicion idPosicion) {
        this.idPosicion = idPosicion;
    }

    public Club getIdClub() {
        return idClub;
    }

    public void setIdClub(Club idClub) {
        this.idClub = idClub;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public TipoJugador getIdTipoJugador() {
        return idTipoJugador;
    }

    public void setIdTipoJugador(TipoJugador idTipoJugador) {
        this.idTipoJugador = idTipoJugador;
    }

    public List<JugadorPartidfo> getJugadorPartidfoList() {
        return jugadorPartidfoList;
    }

    public void setJugadorPartidfoList(List<JugadorPartidfo> jugadorPartidfoList) {
        this.jugadorPartidfoList = jugadorPartidfoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJugador != null ? idJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.idJugador == null && other.idJugador != null) || (this.idJugador != null && !this.idJugador.equals(other.idJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.guambragol.modelo.Jugador[ idJugador=" + idJugador + " ]";
    }
    
}
