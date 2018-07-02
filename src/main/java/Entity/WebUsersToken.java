/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mikhail.volk
 */
@Entity
@Table(name = "WEB_USERS_TOKEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebUsersToken.findAll", query = "SELECT w FROM WebUsersToken w")
    , @NamedQuery(name = "WebUsersToken.findById", query = "SELECT w FROM WebUsersToken w WHERE w.id = :id")
    , @NamedQuery(name = "WebUsersToken.findByUserId", query = "SELECT w FROM WebUsersToken w WHERE w.userId = :userId")
    , @NamedQuery(name = "WebUsersToken.findByCreatedate", query = "SELECT w FROM WebUsersToken w WHERE w.createdate = :createdate")
    , @NamedQuery(name = "WebUsersToken.findByExpiredDate", query = "SELECT w FROM WebUsersToken w WHERE w.expiredDate = :expiredDate")
    , @NamedQuery(name = "WebUsersToken.findByToken", query = "SELECT w FROM WebUsersToken w WHERE w.token = :token")})
public class WebUsersToken implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation



    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(generator="seq_WEB_USERS_TOKEN")
    @SequenceGenerator(name="seq_WEB_USERS_TOKEN", sequenceName="seq_WEB_USERS_TOKEN", allocationSize=1)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "CREATEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Column(name = "EXPIRED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;
    @Column(name = "TOKEN")
    private String token;
    

    public WebUsersToken() {
    }

    public WebUsersToken(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
        if (!(object instanceof WebUsersToken)) {
            return false;
        }
        WebUsersToken other = (WebUsersToken) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.WebUsersToken[ id=" + id + " ]";
    }
    
}
