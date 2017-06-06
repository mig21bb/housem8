/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "OCUPATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocupation.findAll", query = "SELECT o FROM Ocupation o"),
    @NamedQuery(name = "Ocupation.findById", query = "SELECT o FROM Ocupation o WHERE o.id = :id"),
    @NamedQuery(name = "Ocupation.findByStartDate", query = "SELECT o FROM Ocupation o WHERE o.startDate = :startDate"),
    @NamedQuery(name = "Ocupation.findByEndDate", query = "SELECT o FROM Ocupation o WHERE o.endDate = :endDate")})
public class Ocupation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "MATE_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mate mATEid;
    @JoinColumn(name = "ROOM_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Room rOOMid;

    public Ocupation() {
    }

    public Ocupation(Integer id) {
        this.id = id;
    }

    public Ocupation(Integer id, Date startDate) {
        this.id = id;
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Mate getMATEid() {
        return mATEid;
    }

    public void setMATEid(Mate mATEid) {
        this.mATEid = mATEid;
    }

    public Room getROOMid() {
        return rOOMid;
    }

    public void setROOMid(Room rOOMid) {
        this.rOOMid = rOOMid;
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
        if (!(object instanceof Ocupation)) {
            return false;
        }
        Ocupation other = (Ocupation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tk.housem8.housem8.entities.Ocupation[ id=" + id + " ]";
    }
    
}
