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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "COMPENSATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compensation.findAll", query = "SELECT c FROM Compensation c"),
    @NamedQuery(name = "Compensation.findById", query = "SELECT c FROM Compensation c WHERE c.id = :id"),
    @NamedQuery(name = "Compensation.findByAmount", query = "SELECT c FROM Compensation c WHERE c.amount = :amount"),
    @NamedQuery(name = "Compensation.findByDatetime", query = "SELECT c FROM Compensation c WHERE c.datetime = :datetime")})
public class Compensation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private float amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "notes")
    private String notes;
    @JoinColumn(name = "payer", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mate payer;
    @JoinColumn(name = "receiver", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mate receiver;

    public Compensation() {
    }

    public Compensation(Integer id) {
        this.id = id;
    }

    public Compensation(Integer id, float amount, Date datetime) {
        this.id = id;
        this.amount = amount;
        this.datetime = datetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Mate getPayer() {
        return payer;
    }

    public void setPayer(Mate payer) {
        this.payer = payer;
    }

    public Mate getReceiver() {
        return receiver;
    }

    public void setReceiver(Mate receiver) {
        this.receiver = receiver;
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
        if (!(object instanceof Compensation)) {
            return false;
        }
        Compensation other = (Compensation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tk.housem8.housem8.entities.Compensation[ id=" + id + " ]";
    }
    
}
