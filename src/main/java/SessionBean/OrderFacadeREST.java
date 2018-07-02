/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.Order;
import Filters.Secured;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.persistence.StoredProcedureQuery;
/**
 *
 * @author mikhail.volk
 */
@Stateless
@Path("entity.order")
public class OrderFacadeREST extends AbstractFacade<Order> {

    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    public OrderFacadeREST() {
        super(Order.class);
    }

    
    @POST
    @Secured
    //@Override
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Order createOrder(Order entity) throws UnsupportedEncodingException {
//        System.out.println("cost:"+entity.getCost());
//        System.out.println("amount:"+entity.getAmount());
//        System.out.println("delivery_type:"+entity.getDelivery_type());
//        System.out.println("transportcompany:"+entity.getTransportcompany());
//        System.out.println("whouse_id:"+entity.getWhouse_id());
//        System.out.println("shipping_whouse_id:"+entity.getShipping_whouse_id());
        
        
//        System.out.println("commentary:"+entity.getCommentary());
//        System.out.println("decode(commentary):"+URLDecoder.decode(entity.getCommentary(), "UTF-8"));
//        System.out.println("delivery_date:"+entity.getDelivery_date());

        entity.setCreateuser_id(entity.getUser_id());
        entity.setStatus(Long.valueOf(0));
        entity.setIsdeleted(Long.valueOf(0));
        entity.setManager_id(Long.valueOf(0));
        entity.setCommentary(URLDecoder.decode(entity.getCommentary(), "UTF-8"));

        Long whouse_id = entity.getWhouse_id(); // запоминаем склад хранения товара
        entity.setWhouse_id(entity.getShipping_whouse_id()); // сохраняем ID склада отгрузки для шапки WEB_ORDER
        super.create(entity);
//        System.out.println("id:"+entity.getId());
        
                
        loadFromCart(entity.getId(),whouse_id);
//        entity = super.find(entity.getId()); 
        em.refresh(entity);// возвращаем новый ордер
        return entity;
    }
    
    public void loadFromCart(Long order_id,Long whouse_id) {
//        String s = "";
//        try {
        
        StoredProcedureQuery q = em.createNamedStoredProcedureQuery("LOAD_FROM_CART");
        q.setParameter("pORDER_ID", order_id);
        q.setParameter("pWHOUSE_ID", whouse_id);
        q.execute();
//        Integer id = (Integer) q.getOutputParameterValue(12);  
//        return id.toString();
//        } catch (Exception e) {
//            return "";
//        }
    }
    
    

//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, Order entity) {
//        super.edit(entity);
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") Long id) {
//        super.remove(super.find(id));
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Order find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Order> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Order> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
//
//    @GET
//    @Path("count")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String countREST() {
//        return String.valueOf(super.count());
//    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
