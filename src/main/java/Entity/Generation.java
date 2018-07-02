/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mikhail.volk
 */
@Entity
@Table(name = "GENERATIONS")
@XmlRootElement
@NamedQueries({
//    @NamedQuery(name = "ProdComments.findAll", query = "SELECT p FROM ProdComments p"),
//    @NamedQuery(name = "Prod.findById", query = "SELECT p FROM Prod p WHERE p.id = :id")
//    @NamedQuery(name = "ProdComments.findByProdId", query = "SELECT p FROM ProdComments p WHERE p.prodId = :prodId"),
//    @NamedQuery(name = "ProdComments.findByUserId", query = "SELECT p FROM ProdComments p WHERE p.userId = :userId"),
//    @NamedQuery(name = "ProdComments.findByCommentary", query = "SELECT p FROM ProdComments p WHERE p.commentary = :commentary")
})

public class Generation implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   private String name;
   private String years;
   
   

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


    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
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
        if (!(object instanceof Generation)) {
            return false;
        }
        Generation other = (Generation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Generation[ id=" + id + " ]";
    }
    
    
//    private HashMap<String, String> tmHashMap;
//    public HashMap<String, String> getTrademarks(){
//        if(tmHashMap!=null){
//            return tmHashMap;
//        }
//        
//        if(tmHashMap==null){
//            tmHashMap = new HashMap<>();
//        }
////        System.out.println("size."+goods.size());
//        if (goods.isEmpty()){
//            return null;
//        }
//        for (int i = 0; i < goods.size(); i++) {
//              tmHashMap.put(goods.get(i).getTrademark_id().toString(),goods.get(i).getTrademark_name());
//        }
//        
//        return tmHashMap;
//    }
    
}
