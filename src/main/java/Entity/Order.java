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
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mikhail.volk
 */
@Entity
@Table(name = "WEB_ORDER")
@XmlRootElement
  @NamedStoredProcedureQuery(
    name="LOAD_FROM_CART",  
    procedureName="P_WEB_ORDER_MOBILE.LOAD_FROM_CART",  
    parameters={  
        @StoredProcedureParameter(name="pORDER_ID",mode = ParameterMode.IN,type=Integer.class),
        @StoredProcedureParameter(name="pWHOUSE_ID",mode = ParameterMode.IN,type=Integer.class)  
//        @StoredProcedureParameter(name="pIS_RESERV",mode = ParameterMode.IN,type=Integer.class),  
//        @StoredProcedureParameter(name="pDELIVERY_TYPE",mode = ParameterMode.IN,type=Integer.class),  
//        @StoredProcedureParameter(name="pDELIVERY_DATE",mode = ParameterMode.IN,type=Date.class),  
//        @StoredProcedureParameter(name="pDELIVERY_ADDRESS",mode = ParameterMode.IN,type=String.class),  
        //@StoredProcedureParameter(mode = ParameterMode.OUT , name="pORDER_ID", type=Integer.class)  
                }
  )

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @GeneratedValue(generator="seq_WEB_ORDER")
    @SequenceGenerator(name="seq_WEB_ORDER", sequenceName="seq_WEB_ORDER", allocationSize=1)
    private Long id;

    private String orignum;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate;

    private Long user_id;

    private Long manager_id;

    private Long status;

    private Long whouse_id;

    @Transient
    private Long shipping_whouse_id;

    private Double cost;

    private Long amount;

    private Long isdeleted;

    private Long createuser_id;

    private Long deleteuser_id;

    private String commentary;

    private Long transportcompany;

    private Long delivery_type;

    @Temporal(TemporalType.DATE)
    private Date delivery_date;

    private String delivery_address;

    private String sberjson;
    
    private Long paytype;

    
    @Column(name = "SBER_1C_STATUS")
    private Short sber1cStatus;

    public Short getSber1cStatus() {
        return sber1cStatus;
    }

    public void setSber1cStatus(Short sber1cStatus) {
        this.sber1cStatus = sber1cStatus;
    }
    
    
    


    public String getSberjson() {
        return sberjson;
    }

    public void setSberjson(String sberjson) {
        this.sberjson = sberjson;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Long getCreateuser_id() {
        return createuser_id;
    }

    public void setCreateuser_id(Long createuser_id) {
        this.createuser_id = createuser_id;
    }

    public Long getDeleteuser_id() {
        return deleteuser_id;
    }

    public void setDeleteuser_id(Long deleteuser_id) {
        this.deleteuser_id = deleteuser_id;
    }

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

    public Long getPaytype() {
        return paytype;
    }

    public void setPaytype(Long paytype) {
        this.paytype = paytype;
    }
    
    


    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }
    
    public Long getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Long isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    
    
    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
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

    public Long getShipping_whouse_id() {
        return shipping_whouse_id;
    }

    public void setShipping_whouse_id(Long shipping_whouse_id) {
        this.shipping_whouse_id = shipping_whouse_id;
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
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.OrderList[ id=" + id + " ]";
    }
    
  public Order(){
//        if (delivery_date == null){
//            Calendar date = new GregorianCalendar();
//            date.add(Calendar.DATE, 1);
//            delivery_date = date.getTime();
//        }
  }  
}
