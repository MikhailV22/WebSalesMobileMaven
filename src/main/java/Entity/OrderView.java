/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mikhail.volk
 */
@Entity
@XmlRootElement
public class OrderView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orignum;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate;

    private String regdate_str;
    
    private Long user_id;

//    private Long manager_id;

    private Long status;

    private Long whouse_id;

    private String whouse_name;
    
    private String status_name;

    private String status_color;

    private Double cost;

    private Long amount;

    private Long isdeleted;

//    private Long createuser_id;

//    private Long deleteuser_id;

//    @Temporal(TemporalType.DATE)
//    private Date deletedate;

    private String commentary;

//    @Column(name = "MANAGER_COMMENTARY")
//    private String managerCommentary;

//    @Column(name = "USER_COMMENTARY")
//    private String userCommentary;

    private Long transportcompany;

//    private Long is_insurance;

    private Long delivery_type;

    private String delivery_typename;
    

    @Temporal(TemporalType.DATE)
    private Date delivery_date;

    private String delivery_address;

//    private String manager_name;
    
//    private String user_name;
    
//    private String sberjson;
    
//    private Long paytype;

//    @Temporal(TemporalType.DATE)
//    private Date sale_date;

    
    
    private String detailDescr;
    
    
    @Column(name = "SBER_1C_STATUS")
    private Short sber_1c_status;

    public Short getSber_1c_status() {
        return sber_1c_status;
    }

    public void setSber_1c_status(Short sber_1c_status) {
        this.sber_1c_status = sber_1c_status;
    }

    
    
    
    

    public String getDetailDescr() {
        return detailDescr;
    }

    public void setDetailDescr(String detailDescr) {
        this.detailDescr = detailDescr;
    }

//    public String getSberjson() {
//        return sberjson;
//    }
//
//    public void setSberjson(String sberjson) {
//        this.sberjson = sberjson;
//    }


    
    
    
    // для WEB формы CALENDAR
    private Boolean reserv;

    public Boolean getReserv() {
//        return true;
        return reserv;
    }

    public void setReserv(Boolean reserv) {
        this.reserv = reserv;
        System.out.println("reserv");
        is_reserv = (reserv)?1:0;
    }
    

    private int is_reserv;

    public int getIs_reserv() {
        return is_reserv;
    }

    public void setIs_reserv(int is_reserv) {
        this.is_reserv = is_reserv;
    }
    
    private Boolean isAccept;

    public Boolean getIsAccept() {
        return isAccept;
    }

    public void setIsAccept(Boolean isAccept) {
        this.isAccept = isAccept;
    }
    
    


    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getOrignum() {
        return orignum;
    }

    public void setOrignum(String orignum) {
        this.orignum = orignum;
    }
    

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

//    public String getManagerCommentary() {
////        if (managerCommentary==null || managerCommentary==""){
////            return  "Добавить";
////        }
////        else {
////            return managerCommentary;
////        }
//        return managerCommentary;
//    }
//
//    public void setManagerCommentary(String managerCommentary) {
//        this.managerCommentary = managerCommentary;
//    }
//
//    public String getUserCommentary() {
//        return userCommentary;
//    }
//
//    public void setUserCommentary(String userCommentary) {
//        this.userCommentary = userCommentary;
//    }

    
    
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

//    public Long getCreateuser_id() {
//        return createuser_id;
//    }
//
//    public void setCreateuser_id(Long createuser_id) {
//        this.createuser_id = createuser_id;
//    }
//
//    public Date getDeletedate() {
//        return deletedate;
//    }
//
//    public void setDeletedate(Date deletedate) {
//        this.deletedate = deletedate;
//    }
//
//    public Long getDeleteuser_id() {
//        return deleteuser_id;
//    }
//
//    public void setDeleteuser_id(Long deleteuser_id) {
//        this.deleteuser_id = deleteuser_id;
//    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public Long getDelivery_type() {
        return delivery_type;
    }

    public void setDelivery_type(Long delivery_type) {
        this.delivery_type = delivery_type;
    }

    public String getDelivery_typename() {
        return delivery_typename;
    }

    public void setDelivery_typename(String delivery_typename) {
        this.delivery_typename = delivery_typename;
    }

//    public Long getPaytype() {
//        return paytype;
//    }
//
//    public void setPaytype(Long paytype) {
//        this.paytype = paytype;
//    }
    
    


    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

//    public Date getSale_date() {
//        return sale_date;
//    }

//    public void setSale_date(Date sale_date) {
//        this.sale_date = sale_date;
//    }
//
//
//    
//    public Long getIs_insurance() {
//        return is_insurance;
//    }
//
//    public void setIs_insurance(Long is_insurance) {
//        this.is_insurance = is_insurance;
//    }

    public Long getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Long isdeleted) {
        this.isdeleted = isdeleted;
    }

//    public Long getManager_id() {
//        return manager_id;
//    }
//
//    public void setManager_id(Long manager_id) {
//        this.manager_id = manager_id;
//    }

//    public String getManager_name() {
//        return manager_name;
//    }
//
//    public void setManager_name(String manager_name) {
//        this.manager_name = manager_name;
//    }
//
//    public String getUser_name() {
//        return user_name;
//    }
//
//    public void setUser_name(String user_name) {
//        this.user_name = user_name;
//    }
    
    

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getRegdate_str() {
        return regdate_str;
    }

    public void setRegdate_str(String regdate_str) {
        this.regdate_str = regdate_str;
    }

    
    
    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getStatus_color() {
        return status_color;
    }

    public void setStatus_color(String status_color) {
        this.status_color = status_color;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }


    
    public Long getTransportcompany() {
        return transportcompany;
    }

    public void setTransportcompany(Long transportcompany) {
        this.transportcompany = transportcompany;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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


    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderView)) {
            return false;
        }
        OrderView other = (OrderView) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.OrderList[ id=" + id + " ]";
    }
    
  public OrderView(){
//        if (delivery_date == null){
//            Calendar date = new GregorianCalendar();
//            date.add(Calendar.DATE, 1);
//            delivery_date = date.getTime();
//        }
  }  
}
