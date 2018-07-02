/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mikhail.volk
 */
@Entity
@Table(name = "WEB_WHOUSES")
@XmlRootElement
public class Whouses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "NAME")
    private String name;

    @Column(name = "NAME_SHORT")
    private String name_short;

    @Column(name = "REAL_NAME")
    private String real_name;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ISVISIBLE")
    private short isvisible;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 128)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "WHOLESORTIR")
    private int wholesortir;

    @Column(name = "DELIVERY_COMMENTARY")
    private String delivery_commentary;

    @Column(name = "DELIVERY_TIME")
    private String delivery_time;

    @Column(name = "WORKING_CONDITIONS")
    private String working_conditions;

    @Column(name = "ISEXTERNAL")
    private Boolean isexternal;

    public Boolean getIsexternal() {
        return isexternal;
    }

    public void setIsexternal(Boolean isexternal) {
        this.isexternal = isexternal;
    }
    
    
    
    @Transient
//    @Column(updatable = false, insertable = false )
    private Boolean isselected;

    public Boolean getIsselected() {
        return isselected;
    }

    public void setIsselected(Boolean isselected) {
        this.isselected = isselected;
    }

    public String getDelivery_commentary() {
        return delivery_commentary;
    }

    public void setDelivery_commentary(String delivery_commentary) {
        this.delivery_commentary = delivery_commentary;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public String getWorking_conditions() {
        return working_conditions;
    }

    public void setWorking_conditions(String working_conditions) {
        this.working_conditions = working_conditions;
    }


    
    
    

    

    public Whouses() {
    }

    public Whouses(Long id) {
        this.id = id;
    }

    public Whouses(Long id, String name, short isvisible, short groupType, int retailsortir, int wholesortir, Date updatedate) {
        this.id = id;
        this.name = name;
        this.isvisible = isvisible;
        this.wholesortir = wholesortir;
    }

    public Whouses(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getName_short() {
        return name_short;
    }

    public void setName_short(String name_short) {
        this.name_short = name_short;
    }

    
    
    public short getIsvisible() {
        return isvisible;
    }

    public void setIsvisible(short isvisible) {
        this.isvisible = isvisible;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getWholesortir() {
        return wholesortir;
    }

    public void setWholesortir(int wholesortir) {
        this.wholesortir = wholesortir;
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
        if (!(object instanceof Whouses)) {
            return false;
        }
        Whouses other = (Whouses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "Entity.WebWhouses[ id=" + id + " ]";
        return getName();
    }
    
}
