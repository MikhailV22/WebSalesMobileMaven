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
import javax.persistence.ParameterMode;
//import javax.persistence.ParameterMode;
//import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mikhail.volk
 */



@Entity
@Table(name = "WEB_CART")
@XmlRootElement
  
  
public class CartList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @Basic(optional = false)
    @Column(name = "USER_ID")
    private Long user_id;

    @Basic(optional = false)
    @Column(name = "WHOUSE_ID")
    private Long whouse_id;

    @Column(name = "WHOUSE_NAME")
    private String whouse_name;

    @Column(name = "WHOUSE_REAL_NAME")
    private String whouse_real_name;
    
    @Column(name = "WHOUSE_NAME_SHORT")
    private String whouse_name_short;
    

    @Basic(optional = false)
    @Column(name = "PROD_ID")
    private Long prod_id;

    @Column(name = "PROD_NAME")
    private String prod_name;
    
    @Column(name = "PRODTYPE_ID")
    private Long prodtype_id;
    
    @Column(name = "PRODTYPE_NAME")
    private String prodtype_name;

    @Column(name = "EURO")
    private String euro;

    @Basic(optional = false)
    @Column(name = "TRADEMARK_ID")
    private Long trademark_id;

    @Column(name = "TRADEMARK_NAME")
    private String trademark_name;

    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private Long amount;
    
    @Basic(optional = false)
    @Column(name = "PRICE")
    private Double price;

    
    @Basic(optional = false)
    @Column(name = "COMMENTARY")
    private String commentary;

    @Basic(optional = false)
    @Column(name = "ISACCEPTED")
    private Boolean isaccepted;
    
    
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public Boolean getIsaccepted() {
        return isaccepted;
    }

    public void setIsaccepted(Boolean isaccepted) {
        this.isaccepted = isaccepted;
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

    public Long getWhouse_id() {
        return whouse_id;
    }

    public void setWhouse_id(Long whouse_id) {
        this.whouse_id = whouse_id;
    }

    public String getWhouse_name() {
        return whouse_name;
    }

    public void setWhouse_name(String whouse_name) {
        this.whouse_name = whouse_name;
    }

    public String getWhouse_real_name() {
        return whouse_real_name;
    }

    public void setWhouse_real_name(String whouse_real_name) {
        this.whouse_real_name = whouse_real_name;
    }

    public String getWhouse_name_short() {
        return whouse_name_short;
    }

    public void setWhouse_name_short(String whouse_name_short) {
        this.whouse_name_short = whouse_name_short;
    }

    
    
    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public Long getProdtype_id() {
        return prodtype_id;
    }

    public void setProdtype_id(Long prodtype_id) {
        this.prodtype_id = prodtype_id;
    }

    public String getProdtype_name() {
        return prodtype_name;
    }

    public void setProdtype_name(String prodtype_name) {
        this.prodtype_name = prodtype_name;
    }
    
    

    public String getEuro() {
        return euro;
    }

    public void setEuro(String euro) {
        this.euro = euro;
    }

    public String getTrademark_name() {
        return trademark_name;
    }

    public void setTrademark_name(String trademark_name) {
        this.trademark_name = trademark_name;
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
        if (!(object instanceof CartList)) {
            return false;
        }
        CartList other = (CartList) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public boolean equalsSpec(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartList)) {
            return false;
        }
        CartList other = (CartList) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
        if ((this.prod_id == null && other.prod_id != null) || (this.prod_id != null && !this.prod_id.equals(other.prod_id))) {
            return false;
        }
        if ((this.trademark_id == null && other.trademark_id != null) || (this.trademark_id != null && !this.trademark_id.equals(other.trademark_id))) {
            return false;
        }
        
        if ((this.whouse_id == null && other.whouse_id != null) || (this.whouse_id != null && !this.whouse_id.equals(other.whouse_id))) {
            return false;
        }
        
//        if ((this.price == null && other.price != null) || (this.price != null && !this.price.equals(other.price))) {
//            return false;
//        }

        if ((this.user_id == null && other.user_id != null) || (this.user_id != null && !this.user_id.equals(other.user_id))) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        return "Entity.Cart[ id=" + id + " ]";
    }
    
}
