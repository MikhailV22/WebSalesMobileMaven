/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Mikhail.volk
 */
@Entity
@Table(name = "ORDER1C")
@XmlRootElement


public class OrderDetailView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
//    @Size(max = 64)
//    @Column(name = "ORIGNUM")
//    private String orignum;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "REGDATE")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date regdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private long user_id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private short status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "ISDELETED")
//    private short isdeleted;
//    @Column(name = "DELETEUSER_ID")
//    private Long deleteuserId;
//    @Column(name = "DELETEDATE")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date deletedate;
    @Size(max = 512)
    @Column(name = "COMMENTARY")
    private String commentary;
//    @Column(name = "DELIVERY_TYPE")
//    private Short delivery_type;
//    @Column(name = "DELIVERY_DATE")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date delivery_date;
//    @Size(max = 300)
//    @Column(name = "DELIVERY_ADDRESS")
//    private String deliveryAddress;
    @Column(name = "WHOUSE_ID")
    private Integer whouse_id;
    @Column(name = "PROD_ID")
    private Integer prod_id;
    @Column(name = "TRADEMARK_ID")
    private Integer trademark_id;
    @Column(name = "PAYTYPE")
    private Short paytype;
    @Column(name = "CREATEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Column(name = "RESERVEDDAYS")
    private Short reserveddays;
                    
    @Column(name = "CANDROPRESERV")
    private Short canDropReserv;

    
    @Column(name = "DROPRESERVEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dropReserveDate;
    
    
    @Column(name = "WHOUSE_NAME")
    private String whouse_name;

    @Column(name = "TRADEMARK_NAME")
    private String trademark_name;
    
    @Column(name = "DROP_RESERV_STATUS")
    private String drop_reserv_status;
    
    @Column(name = "PROD_NAME")
    private String prod_name;

    @Basic(optional = false)
    @Column(name = "PROD_INFO")
    private String prod_info;
    
//    @Column(name = "SCAN")
//    private String scan;
    @Column(name = "EURO")
    private String euro;
    @Column(name = "PROD_COMMENTERY")
    private String prodCommentary;
//    @Column(name = "DIMENSION")
//    private String dimension;

//    @Column(name = "SALEDATE")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date saledate;
    
    
//    @Column(name = "SBER_1C_STATUS")
//    private Short sber1cStatus;
//
//    public Short getSber1cStatus() {
//        return sber1cStatus;
//    }
//
//    public void setSber1cStatus(Short sber1cStatus) {
//        this.sber1cStatus = sber1cStatus;
//    }
    
    
    
    
    
    
    public String getDrop_reserv_status() {
        return drop_reserv_status;
    }

    public void setDrop_reserv_status(String drop_reserv_status) {
        this.drop_reserv_status = drop_reserv_status;
    }

    public String getWhouse_name() {
        return whouse_name;
    }

    public void setWhouse_name(String whouse_name) {
        this.whouse_name = whouse_name;
    }

    public String getTrademark_name() {
        return trademark_name;
    }

    public void setTrademark_name(String trademark_name) {
        this.trademark_name = trademark_name;
    }

//    public String getProd_name() {
//        return prod_name;
//    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }
    
    


    public String getProd_name() {
        if (prod_info==null){
            return prod_name;
        }else{
            return prod_info;
        }
//        return prodName;
    }


    public String getProd_info() {
        return prod_info;
    }

    public void setProd_info(String prod_info) {
        this.prod_info = prod_info;
    }

    

    public String getEuro() {
        if (prod_info==null){
            return euro;
        }else{
            return null;
        }
//        return euro;
    }

    public void setEuro(String euro) {
        this.euro = euro;
    }

    public String getProdCommentary() {
        return prodCommentary;
    }

    public void setProdCommentary(String prodCommentary) {
        this.prodCommentary = prodCommentary;
    }

    public Integer getWhouse_id() {
        return whouse_id;
    }

    public void setWhouse_id(Integer whouse_id) {
        this.whouse_id = whouse_id;
    }

    public Integer getProd_id() {
        return prod_id;
    }

    public void setProd_id(Integer prod_id) {
        this.prod_id = prod_id;
    }

    public Integer getTrademark_id() {
        return trademark_id;
    }

    public void setTrademark_id(Integer trademark_id) {
        this.trademark_id = trademark_id;
    }

    public OrderDetailView() {
    }

    public OrderDetailView(Long id) {
        this.id = id;
    }

    public OrderDetailView(Long id, Date regdate, long user_id, short status, short isdeleted) {
        this.id = id;
//        this.regdate = regdate;
        this.user_id = user_id;
        this.status = status;
//        this.isdeleted = isdeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getOrignum() {
//        return orignum;
//    }
//
//    public void setOrignum(String orignum) {
//        this.orignum = orignum;
//    }
//
//    public Date getRegdate() {
//        return regdate;
//    }
//
//    public void setRegdate(Date regdate) {
//        this.regdate = regdate;
//    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }


    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

//    public short getIsdeleted() {
//        return isdeleted;
//    }
//
//    public void setIsdeleted(short isdeleted) {
//        this.isdeleted = isdeleted;
//    }
//
//    public Long getDeleteuserId() {
//        return deleteuserId;
//    }
//
//    public void setDeleteuserId(Long deleteuserId) {
//        this.deleteuserId = deleteuserId;
//    }

//    public Date getDeletedate() {
//        return deletedate;
//    }
//
//    public void setDeletedate(Date deletedate) {
//        this.deletedate = deletedate;
//    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }


//    public String getDeliveryAddress() {
//        return deliveryAddress;
//    }
//
//    public void setDeliveryAddress(String deliveryAddress) {
//        this.deliveryAddress = deliveryAddress;
//    }


    public Short getPaytype() {
        return paytype;
    }

    public void setPaytype(Short paytype) {
        this.paytype = paytype;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Short getReserveddays() {
        return reserveddays;
    }

    public void setReserveddays(Short reserveddays) {
        this.reserveddays = reserveddays;
    }

    public Short getCanDropReserv() {
        return canDropReserv;
    }

    public void setCanDropReserv(Short canDropReserv) {
        this.canDropReserv = canDropReserv;
    }

    
    
    public Date getDropReserveDate() {
        return dropReserveDate;
    }

    public void setDropReserveDate(Date dropReserveDate) {
        this.dropReserveDate = dropReserveDate;
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
        if (!(object instanceof OrderDetailView)) {
            return false;
        }
        OrderDetailView other = (OrderDetailView) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Order1c[ id=" + id + " ]";
    }
    
}
