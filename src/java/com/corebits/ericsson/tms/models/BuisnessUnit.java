/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corebits.ericsson.tms.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tommy
 */
@Entity
@Table(name = "buisness_unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BuisnessUnit.findAll", query = "SELECT b FROM BuisnessUnit b"),
    @NamedQuery(name = "BuisnessUnit.findById", query = "SELECT b FROM BuisnessUnit b WHERE b.id = :id"),
    @NamedQuery(name = "BuisnessUnit.findByBuisnessUnitCode", query = "SELECT b FROM BuisnessUnit b WHERE b.buisnessUnitCode = :buisnessUnitCode"),
    @NamedQuery(name = "BuisnessUnit.findByBuisnessUnitName", query = "SELECT b FROM BuisnessUnit b WHERE b.buisnessUnitName = :buisnessUnitName"),
    @NamedQuery(name = "BuisnessUnit.findByBuisnessUnitDescription", query = "SELECT b FROM BuisnessUnit b WHERE b.buisnessUnitDescription = :buisnessUnitDescription")})
public class BuisnessUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "buisness_unit_code")
    private String buisnessUnitCode;
    @Size(max = 65)
    @Column(name = "buisness_unit_name")
    private String buisnessUnitName;
    @Size(max = 200)
    @Column(name = "buisness_unit_description")
    private String buisnessUnitDescription;
    @OneToMany(mappedBy = "buisnessUnit")
    private List<Member1> member1List;

    public BuisnessUnit() {
    }

    public BuisnessUnit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuisnessUnitCode() {
        return buisnessUnitCode;
    }

    public void setBuisnessUnitCode(String buisnessUnitCode) {
        this.buisnessUnitCode = buisnessUnitCode;
    }

    public String getBuisnessUnitName() {
        return buisnessUnitName;
    }

    public void setBuisnessUnitName(String buisnessUnitName) {
        this.buisnessUnitName = buisnessUnitName;
    }

    public String getBuisnessUnitDescription() {
        return buisnessUnitDescription;
    }

    public void setBuisnessUnitDescription(String buisnessUnitDescription) {
        this.buisnessUnitDescription = buisnessUnitDescription;
    }

    @XmlTransient
    public List<Member1> getMember1List() {
        return member1List;
    }

    public void setMember1List(List<Member1> member1List) {
        this.member1List = member1List;
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
        if (!(object instanceof BuisnessUnit)) {
            return false;
        }
        BuisnessUnit other = (BuisnessUnit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.corebits.ericsson.models.BuisnessUnit[ id=" + id + " ]";
    }
    
}
