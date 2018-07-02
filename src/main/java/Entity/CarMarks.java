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
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mikhail.volk
 */
@Entity
@Table(name = "CALLCENTRE.MARKS")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "CarMarks.findAll", query = "SELECT m FROM CarMarks m"),
//    @NamedQuery(name = "CarMarks.findById", query = "SELECT m FROM CarMarks m WHERE m.id = :id"),
//    @NamedQuery(name = "CarMarks.findByName", query = "SELECT m FROM CarMarks m WHERE m.name like :name"),
//    @NamedQuery(name = "CarMarks.findByIsvisible", query = "SELECT m FROM CarMarks m WHERE m.isvisible = :isvisible")})
public class CarMarks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISVISIBLE")
    private short isvisible;
    @Column(name = "ONSTOCK")
    private short onStock;
    
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "UPDATEDATE")
//    @Temporal(TemporalType.DATE)
//    private Date updatedate;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "UPDATEUSER")
//    private int updateuser;
    
    
    private int isExists;

    public int getIsExists() {
        return isExists;
    }

    public void setIsExists(int isExists) {
        this.isExists = isExists;
    }
    
    public String getIsExistsDescr() {
      if(isExists==1){
        return "Есть";
      }  
      else
      {
        return "Нет";
      }
    }
    
    public String getIsExistsStyle() {
      if(isExists==1){
        return "color: green;";
      }  
      else
      {
        return "color: red;";
      }
    }

    public CarMarks() {
    }

    public CarMarks(Long id) {
        this.id = id;
    }

    public CarMarks(Long id, String name, short isvisible, Date updatedate, int updateuser) {
        this.id = id;
        this.name = name;
        this.isvisible = isvisible;
//        this.updatedate = updatedate;
//        this.updateuser = updateuser;
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

    public short getIsvisible() {
        return isvisible;
    }

    public void setIsvisible(short isvisible) {
        this.isvisible = isvisible;
    }

    public short getOnStock() {
        return onStock;
    }

    public void setOnStock(short onStock) {
        this.onStock = onStock;
    }

    
    
//    public Date getUpdatedate() {
//        return updatedate;
//    }
//
//    public void setUpdatedate(Date updatedate) {
//        this.updatedate = updatedate;
//    }
//
//    public int getUpdateuser() {
//        return updateuser;
//    }
//
//    public void setUpdateuser(int updateuser) {
//        this.updateuser = updateuser;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarMarks)) {
            return false;
        }
        CarMarks other = (CarMarks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="user-description">
    @Override
    public String toString() {
        return name;
    }
    // wer
    
    // </editor-fold>
    
}
