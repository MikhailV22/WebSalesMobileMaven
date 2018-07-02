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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ParameterMode;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asu
 */
@Entity


@XmlRootElement
public class GoodsResult implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Basic(optional = false)
    private Long prod_id;

    @Basic(optional = false)
    private String prod_name;

    @Basic(optional = false)
    private String prodtype_name;
    
    @Basic(optional = false)
    private String car_name;

    @Basic(optional = false)
    private String scancode;
    
    @Basic(optional = false)
    private String eurocode;

    @Basic(optional = false)
    private String eurocode_descr;

    @Basic(optional = false)
    private String xygcode;
    
    @Basic(optional = false)
    private String prod_remarks;
    
    private String dimension;
    
    private String prod_commentary;

    private String last_order;
    
    
    @Basic(optional = false)
    private String trademark_name;

    @Basic(optional = false)
    private Long trademark_id;


    @Basic(optional = false)
    private String whouse_name;

    @Column(name = "WHOUSE_REAL_NAME")
    private String whouse_real_name;
    
    
    @Column(name = "WHOUSE_NAME_SHORT")
    private String whouse_name_short;

    @Basic(optional = false)
    private Long whouse_id;

    @Basic(optional = false)
    private Long amount;

    @Basic(optional = false)
    @Column(name = "AMOUNT_IN_RESERV")
    private Long amount_in_reserv;

    @Basic(optional = false)
    @Column(name = "COMPANY_ID")
    private Integer companyId;
    
    
    @Basic(optional = false)
    private Double price;

    @Basic(optional = false)
    private Double work_price;

    @Temporal(TemporalType.DATE)
    private Date regdate;

    @Basic(optional = false)
    private String picturename;
    
    @Basic(optional = false)
    @Column(name = "CAMERA")
    private Integer camera;

    @Basic(optional = false)
    @Column(name = "CAMERA_CALIBR")
    private Integer cameraCalibr;
    
    @Basic(optional = false)
    @Column(name = "CALIBRATIONID")
    private Integer calibrationId;

    @Basic(optional = false)
    private String calibrationName;

    @Basic(optional = false)
    @Column(name = "DELIVERY_TIME")
    private String deliveryTime;

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    
    
    
    
    @Basic(optional = false)
    @Column(name = "DELIVERY_COMMENTARY")
    private String deliveryCommentary;

    public String getDeliveryCommentary() {
        return deliveryCommentary;
    }

    public void setDeliveryCommentary(String deliveryCommentary) {
        this.deliveryCommentary = deliveryCommentary;
    }
    
    @Basic(optional = false)
    @Column(name = "PRICE_COLOR")
    private String priceColor;

    
    public String getPriceColor() {
        return priceColor;
    }

    public void setPriceColor(String priceColor) {
        this.priceColor = priceColor;
    }
    
    
    
    

    public String getPicturename() {
        return picturename;
    }


    public void setPicturename(String picturename) {
        this.picturename = picturename;
    }
    
    

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
    
    
    

//    @Basic(optional = false)
//    private Long amount_need = Long.valueOf(0);

    
    private Long amountNeed = Long.valueOf(1);

    public Long getAmountNeed() {
        
        if (amountNeed==null){amountNeed = Long.valueOf(1);}
        return amountNeed;
    }

    public void setAmountNeed(Long amountNeed) {
        this.amountNeed = amountNeed;
    }
    
    

    @Basic(optional = false)
    private Long amount_waiting;

    @Basic(optional = false)
    private Long amount_inway;

//    @Basic(optional = false)
    @Transient
    private String amount_str;

    @Basic(optional = false)
    private String years;

    @Basic(optional = false)
    private int was_buy;

    @Basic(optional = false)
    private int have_soput;

    @Basic(optional = false)
    private int have_analog;
    
    @Basic(optional = false)
    private int have_external_stock;
    
    @Basic(optional = false)
    private int isexternal;
    
    public int getWas_buy() {
        return was_buy;
    }

    public void setWas_buy(int was_buy) {
        this.was_buy = was_buy;
    }

    public int getHave_soput() {
        return have_soput;
    }

    public void setHave_soput(int have_soput) {
        this.have_soput = have_soput;
    }

    public int getHave_analog() {
        return have_analog;
    }

    public void setHave_analog(int have_analog) {
        this.have_analog = have_analog;
    }

    public int getHave_external_stock() {
        return have_external_stock;
    }

    public void setHave_external_stock(int have_external_stock) {
        this.have_external_stock = have_external_stock;
    }

    public int getIsexternal() {
        return isexternal;
    }

    public void setIsexternal(int isexternal) {
        this.isexternal = isexternal;
    }
    
    
    
    
    
    public Long getProd_id() {
        return prod_id;
    }

    public void setProd_id(Long prod_id) {
        this.prod_id = prod_id;
    }


    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProdtype_name() {
        return prodtype_name;
    }

    public void setProdtype_name(String prodtype_name) {
        this.prodtype_name = prodtype_name;
    }


    
    public String getCar_name() {
        return car_name;
    }

    @Basic(optional = false)
    private Long days;

    @Basic(optional = false)
    private int issale;

    public int getIssale() {
        return issale;
    }

    public void setIssale(int issale) {
        this.issale = issale;
    }
    
    
    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
    
    

    
    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    
    
    public String getEurocode() {
        return eurocode;
    }

    public void setEurocode(String eurocode) {
        this.eurocode = eurocode;
    }

    public String getEurocode_descr() {
        return eurocode_descr;
    }

    public void setEurocode_descr(String eurocode_descr) {
        this.eurocode_descr = eurocode_descr;
    }


    
    public String getScancode() {
        return scancode;
    }

    public void setScancode(String scancode) {
        this.scancode = scancode;
    }

    public String getXygcode() {
        return xygcode;
    }

    public void setXygcode(String xygcode) {
        this.xygcode = xygcode;
    }

    public String getProd_remarks() {
        return prod_remarks;
    }

    public void setProd_remarks(String prod_remarks) {
        this.prod_remarks = prod_remarks;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getProd_commentary() {
        
        return prod_commentary==null?null:prod_commentary.replace("+", " ");
    }

    public void setProd_commentary(String prod_commentary) {
        this.prod_commentary = prod_commentary;
    }

    public String getLast_order() {
        return last_order;
    }

    public void setLast_order(String last_order) {
        this.last_order = last_order;
    }

    
    
    public Long getTrademark_id() {
        return trademark_id;
    }

    public void setTrademark_id(Long trademark_id) {
        this.trademark_id = trademark_id;
    }
    

    public String getTrademark_name() {
        return trademark_name;
    }

    public void setTrademark_name(String trademark_name) {
        this.trademark_name = trademark_name;
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

    
    
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getAmount_str_bak(){
      if (amount_str!=null && !amount_str.isEmpty()){  
        return amount_str;
      }  
      else if(amount_waiting!=null && amount_waiting>0)
      {
        if (whouse_id==28){  //склад Апаринки
            return "Ожидается в течение 7 дней";
        }
        else{
            return "Ожидается в течение 5 дней";
        }
      }
      else
        return "";
    }

    public String getAmount_str(){
        return amount_str;
    }
    

    public void setAmount_str(String amount_str) {
        this.amount_str = amount_str;
    }
    
    public String getAmountForView(Long amount){
      if (amount<=3){
          return amount.toString();
      }
      else{
          return "Больше 3-х";
      }
          
    }
    
    public String getAmount_str2() {
//     if (amount_str!=null && !amount_str.equals("")){  
//        return amount_str;
//      }  
     if (amount!=null && amount!=0){  
        return getAmountForView(amount);
      }  
      else if(amount_waiting!=null && amount_waiting>0)
      {
        if (days==0) {
            return getAmountForView(amount_waiting);
        }else
          {
//            return "Поступление на склад в течение "+days+" дней";
            return "В пути";
          }
      }
      else if(amount_inway!=null && amount_inway>0)
      {
            return "В пути";
      }
      else
        return "";
    }

    public Long getAmount_inway() {
        return amount_inway;
    }

    public void setAmount_inway(Long amount_inway) {
        this.amount_inway = amount_inway;
    }

    public Long getAmount_in_reserv() {
        return amount_in_reserv;
    }

    public void setAmount_in_reserv(Long amount_in_reserv) {
        this.amount_in_reserv = amount_in_reserv;
    }

    
    
    
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWork_price() {
        return work_price;
    }

    public void setWork_price(Double work_price) {
        this.work_price = work_price;
    }

    
//    public Long getAmount_need() {
//        return amount_need;
//    }
//
//    public void setAmount_need(Long amount_need) {
//        this.amount_need = amount_need;
//    }

    public Long getAmount_waiting() {
        return amount_waiting;
    }

    public void setAmount_waiting(Long amount_waiting) {
        this.amount_waiting = amount_waiting;
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

    public Integer getCalibrationId() {
        return calibrationId;
    }

    public void setCalibrationId(Integer calibrationId) {
        this.calibrationId = calibrationId;
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

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getTamplatePicture() {
    try{
        if (
                eurocode.substring(4, 5).toUpperCase().contains("F") ||
                eurocode.substring(4, 5).toUpperCase().contains("H") ||
                eurocode.substring(4, 5).toUpperCase().contains("L") ||
                eurocode.substring(4, 5).toUpperCase().contains("M") ||
                eurocode.substring(4, 5).toUpperCase().contains("R") ||
                eurocode.substring(4, 5).toUpperCase().contains("T") 
                ){
        return eurocode.substring(10, 11).toLowerCase();
        }
    }
     catch (Exception e) {
        return null;
      }
        return null;
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
        if (!(object instanceof GoodsResult)) {
            return false;
        }
        GoodsResult other = (GoodsResult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "Entity.SearchResult[ id=" + id +" " + prod_id.toString() +" " + amountNeed +" ]";
        return "Entity.SearchResult[ id=" + id +" ]";
    }

    
}
