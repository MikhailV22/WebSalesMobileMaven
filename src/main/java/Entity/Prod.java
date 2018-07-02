/*
 * To change this template, choose Tools | Templates
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
@Table(name = "MV_PROD_AUTO")
@XmlRootElement
@NamedQueries({
//    @NamedQuery(name = "ProdComments.findAll", query = "SELECT p FROM ProdComments p"),
    @NamedQuery(name = "Prod.findById", query = "SELECT p FROM Prod p WHERE p.id = :id")
//    @NamedQuery(name = "ProdComments.findByProdId", query = "SELECT p FROM ProdComments p WHERE p.prodId = :prodId"),
//    @NamedQuery(name = "ProdComments.findByUserId", query = "SELECT p FROM ProdComments p WHERE p.userId = :userId"),
//    @NamedQuery(name = "ProdComments.findByCommentary", query = "SELECT p FROM ProdComments p WHERE p.commentary = :commentary")
})

public class Prod implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Transient
    private Long row_num; // порядковый номер в коллекции
    
   private String name;
   private String car_name;
   private String scan;
   private String dimension;
   private Long   prodtype_id;
   private String prodtype_name;
   private String prodtype_fullname;
   private String commentary;
   private Long   isvisible;
   private String remarks;
   private String property;
   private String euro="xxx";
   private String euro2;
   private String euro3;
   private String euro4;
   private String euro5;
   private String years;
   private String whouse_comment;
   private String commentary_opt;
   private String original_code;
   @Transient
   private String whereExists;
   private String eurocode_descr;
   private Double weight;
   private Double thickness;
   private String picturename;
   
   
    @Basic(optional = false)
    @Column(name = "CAMERA")
    private Integer camera;

    @Basic(optional = false)
    @Column(name = "CAMERA_CALIBR")
    private Integer cameraCalibr;
    
    @Basic(optional = false)
    private String calibrationName;
    

//   @Transient
   @Column(name = "ON_STOCK")
   private int onStock; //наличие на складах

    public int getOnStock() {
        return onStock;
    }

    public void setOnStock(int onStock) {
        this.onStock = onStock;
    }
   
   
   private int have_soput;

    public int getHave_soput() {
        return have_soput;
    }

    public void setHave_soput(int have_soput) {
        this.have_soput = have_soput;
    }
   
//   @Transient
//   private List<SearchResult> goods;
//
//    public List<SearchResult> getGoods() {
//        return goods;
//    }
//
//    public void setGoods(List<SearchResult> goods) {
//        this.goods = goods;
//    }

   @Transient
   private List<Prod> soput;

    public List<Prod> getSoput() {
        return soput;
    }

    public void setSoput(List<Prod> soput) {
        this.soput = soput;
    }
   
   
   @Transient
   private List<Prod> analogs;

    public List<Prod> getAnalogs() {
        return analogs;
    }

    public void setAnalogs(List<Prod> analogs) {
        this.analogs = analogs;
    }



    
    public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename;
    }
   
   

    public String getWhereExists() {
        return whereExists;
    }

    public void setWhereExists(String whereExists) {
        this.whereExists = whereExists;
    }

    public String getEurocode_descr() {
        return eurocode_descr;
    }

    public void setEurocode_descr(String eurocode_descr) {
        this.eurocode_descr = eurocode_descr;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getThickness() {
        return thickness;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }

    public Integer getCamera() {
        return camera;
    }

    public void setCamera(Integer camera) {
        this.camera = camera;
    }

    public Integer getCameraCalibr() {
        return cameraCalibr;
    }

    public void setCameraCalibr(Integer cameraCalibr) {
        this.cameraCalibr = cameraCalibr;
    }

    public String getCalibrationName() {
        return calibrationName;
    }

    public void setCalibrationName(String calibrationName) {
        this.calibrationName = calibrationName;
    }
   
   
   
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRow_num() {
        return row_num;
    }

    public void setRow_num(Long row_num) {
        this.row_num = row_num;
    }


    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }


    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getCommentary_opt() {
        return commentary_opt;
    }

    public void setCommentary_opt(String commentary_opt) {
        this.commentary_opt = commentary_opt;
    }

    public String getOriginal_code() {
        return original_code;
    }

    public void setOriginal_code(String original_code) {
        this.original_code = original_code;
    }
    
    

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getEuro() {
        return euro;
    }

    public void setEuro(String euro1) {
        this.euro = euro;
    }

    public String getEuro2() {
        return euro2;
    }

    public void setEuro2(String euro2) {
        this.euro2 = euro2;
    }

    public String getEuro3() {
        return euro3;
    }

    public void setEuro3(String euro3) {
        this.euro3 = euro3;
    }

    public String getEuro4() {
        return euro4;
    }

    public void setEuro4(String euro4) {
        this.euro4 = euro4;
    }

    public String getEuro5() {
        return euro5;
    }

    public void setEuro5(String euro5) {
        this.euro5 = euro5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProdtype_name() {
        return prodtype_name;
    }

    public void setProdtype_name(String prodtype_name) {
        this.prodtype_name = prodtype_name;
    }

    public String getProdtype_fullname() {
        return prodtype_fullname;
    }

    public void setProdtype_fullname(String prodtype_fullname) {
        this.prodtype_fullname = prodtype_fullname;
    }

    public Long getProdtype_id() {
        return prodtype_id;
    }

    public void setProdtype_id(Long prodtype_id) {
        this.prodtype_id = prodtype_id;
    }

    public Long getIsvisible() {
        return isvisible;
    }

    public void setIsvisible(Long isvisible) {
        this.isvisible = isvisible;
    }

    
    
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getScan() {
        return scan;
    }

    public void setScan(String scan) {
        this.scan = scan;
    }

    public String getWhouse_comment() {
        return whouse_comment;
    }

    public void setWhouse_comment(String whouse_comment) {
        this.whouse_comment = whouse_comment;
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
        if (!(object instanceof Prod)) {
            return false;
        }
        Prod other = (Prod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Prod[ id=" + id + " ]";
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
//        Prod prodClone;
//        prodClone =(Prod) super.clone();
//        for(Prod soput : this.soput){
//            Prod soputClone = (Prod)soput.clone();
//            prodClone.soput.add(soputClone);
//            for(SearchResult r : soput.goods){
//                soputClone.goods.add((SearchResult)r.clone());
//            }
//        }
//        return prodClone;
        return super.clone();
        
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
