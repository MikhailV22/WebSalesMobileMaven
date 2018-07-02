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
import javax.persistence.ParameterMode;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mikhail.Volk
 */
@Entity
@Table(name = "WEB_LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebLog.findAll", query = "SELECT w FROM WebLog w"),
    @NamedQuery(name = "WebLog.findById", query = "SELECT w FROM WebLog w WHERE w.id = :id"),
    @NamedQuery(name = "WebLog.findByRegdate", query = "SELECT w FROM WebLog w WHERE w.regdate = :regdate"),
    @NamedQuery(name = "WebLog.findByAction", query = "SELECT w FROM WebLog w WHERE w.action = :action"),
    @NamedQuery(name = "WebLog.findBySource", query = "SELECT w FROM WebLog w WHERE w.source = :source"),
    @NamedQuery(name = "WebLog.findByCommentary", query = "SELECT w FROM WebLog w WHERE w.commentary = :commentary")})


public class WebLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_ID")
    private Long user_id;
    @Column(name = "REGDATE")
//    @Temporal(TemporalType.)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate;
    @Size(max = 2048)
    @Column(name = "ACTION")
    private String action;
    @Size(max = 1024)
    @Column(name = "SOURCE")
    private String source;
    @Size(max = 2048)
    @Column(name = "COMMENTARY")
    private String commentary;
    @Column(name = "WHOUSE_ID")
    private Long whouse_id;
    @Column(name = "PROD_ID")
    private Long prod_id;
    @Column(name = "TRADEMARK_ID")
    private Long trademark_id;

    public WebLog() {
    }

    public WebLog(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }


    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public Long getWhouse_id() {
        return whouse_id;
    }

    public void setWhouse_id(Long whouse_id) {
        this.whouse_id = whouse_id;
    }

    public Long getProd_id() {
        return prod_id;
    }

    public void setProd_id(Long prod_id) {
        this.prod_id = prod_id;
    }

    public Long getTrademark_id() {
        return trademark_id;
    }

    public void setTrademark_id(Long trademark_id) {
        this.trademark_id = trademark_id;
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
        if (!(object instanceof WebLog)) {
            return false;
        }
        WebLog other = (WebLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.WebLog[ id=" + id + " ]";
    }
    
}
