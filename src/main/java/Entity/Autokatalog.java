/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mikhail.volk
 */
@Entity
@Table(name = "AUTOKATALOG")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Autokatalog.findAll", query = "SELECT a FROM Autokatalog a"),
//    @NamedQuery(name = "Autokatalog.findById", query = "SELECT a FROM Autokatalog a WHERE a.id = :id"),
//    @NamedQuery(name = "Autokatalog.findByMarkId", query = "SELECT a FROM Autokatalog a WHERE a.markId = :markId"),
//    @NamedQuery(name = "Autokatalog.findByMarkname", query = "SELECT a FROM Autokatalog a WHERE a.markname = :markname"),
//    @NamedQuery(name = "Autokatalog.findByModelId", query = "SELECT a FROM Autokatalog a WHERE a.modelId = :modelId"),
//    @NamedQuery(name = "Autokatalog.findByModelname", query = "SELECT a FROM Autokatalog a WHERE a.modelname = :modelname"),
//    @NamedQuery(name = "Autokatalog.findByBodyId", query = "SELECT a FROM Autokatalog a WHERE a.bodyId = :bodyId"),
//    @NamedQuery(name = "Autokatalog.findByBodyname", query = "SELECT a FROM Autokatalog a WHERE a.bodyname = :bodyname"),
//    @NamedQuery(name = "Autokatalog.findByClassId", query = "SELECT a FROM Autokatalog a WHERE a.classId = :classId"),
//    @NamedQuery(name = "Autokatalog.findByClassname", query = "SELECT a FROM Autokatalog a WHERE a.classname = :classname"),
//    @NamedQuery(name = "Autokatalog.findByMb", query = "SELECT a FROM Autokatalog a WHERE a.mb = :mb"),
//    @NamedQuery(name = "Autokatalog.findByMonthB", query = "SELECT a FROM Autokatalog a WHERE a.monthB = :monthB"),
//    @NamedQuery(name = "Autokatalog.findByYb", query = "SELECT a FROM Autokatalog a WHERE a.yb = :yb"),
//    @NamedQuery(name = "Autokatalog.findByYearB", query = "SELECT a FROM Autokatalog a WHERE a.yearB = :yearB"),
//    @NamedQuery(name = "Autokatalog.findByMe", query = "SELECT a FROM Autokatalog a WHERE a.me = :me"),
//    @NamedQuery(name = "Autokatalog.findByMonthE", query = "SELECT a FROM Autokatalog a WHERE a.monthE = :monthE"),
//    @NamedQuery(name = "Autokatalog.findByYe", query = "SELECT a FROM Autokatalog a WHERE a.ye = :ye"),
//    @NamedQuery(name = "Autokatalog.findByYearE", query = "SELECT a FROM Autokatalog a WHERE a.yearE = :yearE"),
//    @NamedQuery(name = "Autokatalog.findByCommentary", query = "SELECT a FROM Autokatalog a WHERE a.commentary = :commentary"),
//    @NamedQuery(name = "Autokatalog.findByComplectation", query = "SELECT a FROM Autokatalog a WHERE a.complectation = :complectation"),
//    @NamedQuery(name = "Autokatalog.findByMarkvisible", query = "SELECT a FROM Autokatalog a WHERE a.markvisible = :markvisible"),
//    @NamedQuery(name = "Autokatalog.findByModelvisible", query = "SELECT a FROM Autokatalog a WHERE a.modelvisible = :modelvisible"),
//    @NamedQuery(name = "Autokatalog.findByAutovisible", query = "SELECT a FROM Autokatalog a WHERE a.autovisible = :autovisible"),
//    @NamedQuery(name = "Autokatalog.findByBodyvisible", query = "SELECT a FROM Autokatalog a WHERE a.bodyvisible = :bodyvisible"),
//    @NamedQuery(name = "Autokatalog.findByClassvisible", query = "SELECT a FROM Autokatalog a WHERE a.classvisible = :classvisible"),
//    @NamedQuery(name = "Autokatalog.findByIsvisible", query = "SELECT a FROM Autokatalog a WHERE a.isvisible = :isvisible"),
//    @NamedQuery(name = "Autokatalog.findByUpdatedate", query = "SELECT a FROM Autokatalog a WHERE a.updatedate = :updatedate"),
//    @NamedQuery(name = "Autokatalog.findByUpdateuser", query = "SELECT a FROM Autokatalog a WHERE a.updateuser = :updateuser")})
public class Autokatalog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MARK_ID")
    private long markId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "MARKNAME")
    private String markname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODEL_ID")
    private long modelId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "MODELNAME")
    private String modelname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BODY_ID")
    private long bodyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TMD_ID")
    private long tmdId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "BODYNAME")
    private String bodyname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLASS_ID")
    private long classId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "CLASSNAME")
    private String classname;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "MB")
//    private short mb;
//    @Size(max = 4000)
//    @Column(name = "MONTH_B")
//    private String monthB;
    @Basic(optional = false)
    @NotNull
    @Column(name = "YB")
    private short yb;
    @Size(max = 40)
    @Column(name = "YEAR_B")
    private String yearB;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "ME")
//    private short me;
//    @Size(max = 4000)
//    @Column(name = "MONTH_E")
//    private String monthE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "YE")
    private short ye;
    @Size(max = 40)
    @Column(name = "YEAR_E")
    private String yearE;
    @Size(max = 1024)
    @Column(name = "COMMENTARY")
    private String commentary;
    @Size(max = 1024)
    @Column(name = "COMPLECTATION")
    private String complectation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MARKVISIBLE")
    private short markvisible;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "MODELVISIBLE")
//    private short modelvisible;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "AUTOVISIBLE")
//    private short autovisible;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "BODYVISIBLE")
//    private short bodyvisible;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "CLASSVISIBLE")
//    private short classvisible;
//    @Column(name = "ISVISIBLE")
//    private BigInteger isvisible;
    @Column(name = "onStock")
    private BigInteger onStock;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "UPDATEDATE")
//    @Temporal(TemporalType.DATE)
//    private Date updatedate;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "UPDATEUSER")
//    private int updateuser;
    @Size(max = 128)
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Basic(optional = false)
    @Column(name = "GENERATION_ID")
    private long generationId;
    @Basic(optional = false)
    @Column(name = "GENERATION_NAME")
    private String generationName;

    @Basic(optional = false)
    @Column(name = "FULL_NAME")
    private String fullName;
    
    @Size(min = 1, max = 128)
    @Column(name = "BODYNAME_RUS")
    private String bodynameRus;

    public String getBodynameRus() {
        return bodynameRus;
    }

    public void setBodynameRus(String bodynameRus) {
        this.bodynameRus = bodynameRus;
    }
    
    
    
    

    public String getFullName() {
        return fullName;
//        return markname+" "+modelname+" "+generationName+" "+description+" "+bodyname+" "+yearB+"-"+yearE;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    
    
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getGenerationId() {
        return generationId;
    }

    public void setGenerationId(long generationId) {
        this.generationId = generationId;
    }

    public String getGenerationName() {
        return generationName;
    }

    public void setGenerationName(String generationName) {
        this.generationName = generationName;
    }

    

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

    public Autokatalog() {
    }

    public Autokatalog(Long id) {
        this.id = id;
    }

    public Autokatalog(Long id, long markId, String markname, long modelId, String modelname, long bodyId, String bodyname, long classId, String classname, short mb, short yb, short me, short ye, short markvisible, short modelvisible, short autovisible, short bodyvisible, short classvisible, Date updatedate, int updateuser) {
        this.id = id;
        this.markId = markId;
        this.markname = markname;
        this.modelId = modelId;
        this.modelname = modelname;
        this.bodyId = bodyId;
        this.bodyname = bodyname;
        this.classId = classId;
        this.classname = classname;
//        this.mb = mb;
        this.yb = yb;
//        this.me = me;
        this.ye = ye;
        this.markvisible = markvisible;
//        this.modelvisible = modelvisible;
//        this.autovisible = autovisible;
//        this.bodyvisible = bodyvisible;
//        this.classvisible = classvisible;
//        this.updatedate = updatedate;
//        this.updateuser = updateuser;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getMarkId() {
        return markId;
    }

    public void setMarkId(long markId) {
        this.markId = markId;
    }

    public String getMarkname() {
        return markname;
    }

    public void setMarkname(String markname) {
        this.markname = markname;
    }

    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public long getBodyId() {
        return bodyId;
    }

    public void setBodyId(long bodyId) {
        this.bodyId = bodyId;
    }
    
    

    public String getBodyname() {
        return bodyname;
    }

    public void setBodyname(String bodyname) {
        this.bodyname = bodyname;
    }

    public long getTmdId() {
        return tmdId;
    }

    public void setTmdId(long tmdId) {
        this.tmdId = tmdId;
    }

    
    
    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }


    public short getYb() {
        return yb;
    }

    public void setYb(short yb) {
        this.yb = yb;
    }

    public String getYearB() {
        return yearB;
    }

    public void setYearB(String yearB) {
        this.yearB = yearB;
    }


    public short getYe() {
        return ye;
    }

    public void setYe(short ye) {
        this.ye = ye;
    }

    public String getYearE() {
        return yearE;
    }

    public void setYearE(String yearE) {
        this.yearE = yearE;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getComplectation() {
        return complectation;
    }

    public void setComplectation(String complectation) {
        this.complectation = complectation;
    }

    public short getMarkvisible() {
        return markvisible;
    }

    public void setMarkvisible(short markvisible) {
        this.markvisible = markvisible;
    }



    public BigInteger getOnStock() {
        return onStock;
    }

    public void setOnStock(BigInteger onStock) {
        this.onStock = onStock;
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
        if (!(object instanceof Autokatalog)) {
            return false;
        }
        Autokatalog other = (Autokatalog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return markname+" "+modelname+" "+bodyname+" "+yearB+"-"+yearE;
    }
    

    
}
