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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "COST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cost.findAll", query = "SELECT c FROM Cost c"),
    @NamedQuery(name = "Cost.findById", query = "SELECT c FROM Cost c WHERE c.id = :id"),
    @NamedQuery(name = "Cost.findByDescription", query = "SELECT c FROM Cost c WHERE c.description = :description"),
    @NamedQuery(name = "Cost.findByPeriod", query = "SELECT c FROM Cost c WHERE c.period = :period"),
    @NamedQuery(name = "Cost.findByDatetime", query = "SELECT c FROM Cost c WHERE c.datetime = :datetime"),
    @NamedQuery(name = "Cost.findByAmount", query = "SELECT c FROM Cost c WHERE c.amount = :amount")})
public class Cost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Column(name = "period")
    private Integer period;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Float amount;
    @JoinColumn(name = "COST_FAMILY_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CostFamily cOSTFAMILYid;
    @JoinColumn(name = "HOUSE_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private House hOUSEid;
    @JoinColumn(name = "MATE_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mate mATEid;

    public Cost() {
    }

    public Cost(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public CostFamily getCOSTFAMILYid() {
        return cOSTFAMILYid;
    }

    public void setCOSTFAMILYid(CostFamily cOSTFAMILYid) {
        this.cOSTFAMILYid = cOSTFAMILYid;
    }

    public House getHOUSEid() {
        return hOUSEid;
    }

    public void setHOUSEid(House hOUSEid) {
        this.hOUSEid = hOUSEid;
    }

    public Mate getMATEid() {
        return mATEid;
    }

    public void setMATEid(Mate mATEid) {
        this.mATEid = mATEid;
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
        if (!(object instanceof Cost)) {
            return false;
        }
        Cost other = (Cost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tk.housem8.housem8.entities.Cost[ id=" + id + " ]";
    }
    
}
