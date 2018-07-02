/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mikhail.volk
 */
@Entity
@Table(name = "WEB_DELIVERY_ADDRESS")
@NamedQueries({
    @NamedQuery(name = "DeliveryAddress.findAll", query = "SELECT w FROM DeliveryAddress w"),
    @NamedQuery(name = "DeliveryAddress.findById", query = "SELECT w FROM DeliveryAddress w WHERE w.id = :id"),
    @NamedQuery(name = "DeliveryAddress.findByUserId", query = "SELECT w FROM DeliveryAddress w WHERE w.userId = :userId order by w.text"),
    @NamedQuery(name = "DeliveryAddress.findByText", query = "SELECT w FROM DeliveryAddress w WHERE w.text = :text")})
@XmlRootElement
public class DeliveryAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_ID")
    private Long userId;
    @Size(max = 1016)
    @Column(name = "TEXT")
    private String text;

    public DeliveryAddress() {
    }

    public DeliveryAddress(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        if (!(object instanceof DeliveryAddress)) {
            return false;
        }
        DeliveryAddress other = (DeliveryAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.WebDeliveryAddress[ id=" + id + " ]";
    }
    
}
