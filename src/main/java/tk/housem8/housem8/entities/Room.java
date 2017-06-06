/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "ROOM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findById", query = "SELECT r FROM Room r WHERE r.id = :id"),
    @NamedQuery(name = "Room.findBySquareMeters", query = "SELECT r FROM Room r WHERE r.squareMeters = :squareMeters"),
    @NamedQuery(name = "Room.findByWindows", query = "SELECT r FROM Room r WHERE r.windows = :windows")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "square_meters")
    private float squareMeters;
    @Column(name = "windows")
    private Boolean windows;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rOOMid")
    private List<Ocupation> ocupationList;
    @JoinColumn(name = "HOUSE_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private House hOUSEid;
    @JoinColumn(name = "ROOM_CLASS_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RoomClass rOOMCLASSid;

    public Room() {
    }

    public Room(Integer id) {
        this.id = id;
    }

    public Room(Integer id, float squareMeters) {
        this.id = id;
        this.squareMeters = squareMeters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(float squareMeters) {
        this.squareMeters = squareMeters;
    }

    public Boolean getWindows() {
        return windows;
    }

    public void setWindows(Boolean windows) {
        this.windows = windows;
    }

    @XmlTransient
    public List<Ocupation> getOcupationList() {
        return ocupationList;
    }

    public void setOcupationList(List<Ocupation> ocupationList) {
        this.ocupationList = ocupationList;
    }

    public House getHOUSEid() {
        return hOUSEid;
    }

    public void setHOUSEid(House hOUSEid) {
        this.hOUSEid = hOUSEid;
    }

    public RoomClass getROOMCLASSid() {
        return rOOMCLASSid;
    }

    public void setROOMCLASSid(RoomClass rOOMCLASSid) {
        this.rOOMCLASSid = rOOMCLASSid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tk.housem8.housem8.entities.Room[ id=" + id + " ]";
    }
    
}
