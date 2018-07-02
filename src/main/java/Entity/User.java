/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mikhail.volk
 */

@Entity
@Table(name = "WEB_USERS")
@XmlRootElement
@NamedQueries({
//    @NamedQuery(name = "ProdComments.findAll", query = "SELECT p FROM ProdComments p"),
    @NamedQuery(name = "User.findById", query = "SELECT p FROM User p WHERE p.id = :id")
//    @NamedQuery(name = "ProdComments.findByProdId", query = "SELECT p FROM ProdComments p WHERE p.prodId = :prodId"),
//    @NamedQuery(name = "ProdComments.findByUserId", query = "SELECT p FROM ProdComments p WHERE p.userId = :userId"),
//    @NamedQuery(name = "ProdComments.findByCommentary", query = "SELECT p FROM ProdComments p WHERE p.commentary = :commentary")
})

public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String password;
    @Transient
    private String token;
    private String whouses;
    private Integer status;
    private Integer default_whouse;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getWhouses() {
        return whouses;
    }

    public void setWhouses(String whouses) {
        this.whouses = whouses;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDefault_whouse() {
        return default_whouse;
    }

    public void setDefault_whouse(Integer default_whouse) {
        this.default_whouse = default_whouse;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.User[ id=" + id + " ]";
    }
    
    
}
