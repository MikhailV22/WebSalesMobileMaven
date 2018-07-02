/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.GoodsResult;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mikhail.volk
 */
@Stateless
@Path("entity.goodsresult")
public class GoodsResultFacadeREST extends AbstractFacade<GoodsResult> {

    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    public GoodsResultFacadeREST() {
        super(GoodsResult.class);
    }

//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(GoodsResult entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, GoodsResult entity) {
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
//    public GoodsResult find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<GoodsResult> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<GoodsResult> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
//
//    @GET
//    @Path("count")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String countREST() {
//        return String.valueOf(super.count());
//    }

    
    
    @GET
    @Path("byprodid/{prodId}/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<GoodsResult> findWarehouseByProd(@PathParam("prodId") String prodId,@PathParam("userId") String userId) {
        try {
//System.out.println("findWarehouseByProd ку-ку ");        
        getEntityManager().flush();

        Query q = getEntityManager().createNativeQuery(
"select \n" +
"    warehouse.prod_id, \n" +
"    warehouse.trademark_name, \n" +
"    warehouse.whouse_name, \n" +
"    warehouse.whouse_real_name, "+
"    warehouse.isexternal, "+
"    warehouse.whouse_id, \n" +
"    warehouse.trademark_id, \n" +
"    sum(warehouse.amount)amount, \n" +
"    warehouse.AMOUNT_WAITING, \n" +
"    warehouse.AMOUNT_INWAY, \n" +
"    warehouse.company_id, \n" +
"    warehouse.updatedate, \n" +
//"    warehouse.base_trademark_name, \n" +
"    warehouse.days, \n" +
"    warehouse.ISSALE, \n" +
"    warehouse.DELIVERY_COMMENTARY,\n" +
"    warehouse.DELIVERY_TIME,\n" +
"    P_WEB_PRICE.GET_PRICE2( ?userId ,PROD_ID,TRADEMARK_ID,WHOUSE_ID, 0) PRICE, "+
//"    P_WEB_ORDER.WAS_BUY( ?userId ,PROD_ID,TRADEMARK_ID, warehouse.whouse_id) WAS_BUY, "+
"    row_number() over (order by warehouse.whouse_id,warehouse.trademark_id) ID \n" +
"    from  \n" +
"         mv_warehouse2 warehouse \n" +
//"    left join mv_prod_auto p "+
//"    on p.id=warehouse.prod_id"+
"             WHERE\n" +
"             warehouse.prod_id= ?prodId AND WHOUSE_ID IN (18,19,28) "+
//"              and warehouse.whouse_id=28 \n" +
"   group by " +
"    warehouse.prod_id, " +
"    warehouse.trademark_name, " +
"    warehouse.whouse_name, " +
"    warehouse.whouse_real_name, " +
"    warehouse.isexternal, "+
"    warehouse.whouse_id, " +
"    warehouse.trademark_id, " +
"    warehouse.AMOUNT_WAITING, " +
"    warehouse.AMOUNT_INWAY, " +
"    warehouse.company_id, " +
"    warehouse.updatedate, " +
"    warehouse.days, " +
"    warehouse.ISSALE, " +
"    warehouse.DELIVERY_COMMENTARY, "+
"    warehouse.DELIVERY_TIME " +
"    order by isexternal,warehouse.trademark_id,warehouse.whouse_id desc "
            ,GoodsResult.class)
                .setParameter("prodId", prodId)
                .setParameter("userId", userId);
        
        
        
        return q.getResultList();
//        return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    @GET
    @Path("byprodid/{prodId}/{whouses}/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<GoodsResult> findWarehouseByProd2(
            @PathParam("prodId") String prodId,
            @PathParam("whouses") String whouses,
            @PathParam("userId") String userId) {
        try {
//System.out.println("findWarehouseByProd.whouses: "+whouses);
        getEntityManager().flush();

        Query q = getEntityManager().createNativeQuery(
"select \n" +
"    warehouse.prod_id, \n" +
"    warehouse.trademark_name, \n" +
"    warehouse.whouse_name, \n" +
"    warehouse.whouse_real_name, "+
"    whs.name_short whouse_name_short, "+
"    warehouse.isexternal, "+
"    warehouse.whouse_id, \n" +
"    warehouse.trademark_id, \n" +
"    sum(warehouse.amount)amount, \n" +
"    warehouse.AMOUNT_WAITING, \n" +
"    warehouse.AMOUNT_INWAY, \n" +
"    warehouse.company_id, \n" +
"    warehouse.updatedate, \n" +
//"    warehouse.base_trademark_name, \n" +
"    warehouse.days, \n" +
"    warehouse.ISSALE, \n" +
"    warehouse.DELIVERY_COMMENTARY,\n" +
"    warehouse.DELIVERY_TIME,\n" +
"    P_WEB_PRICE.GET_PRICE2( ?userId ,PROD_ID,TRADEMARK_ID,WHOUSE_ID, 0) PRICE, "+
//"    P_WEB_ORDER.WAS_BUY( ?userId ,PROD_ID,TRADEMARK_ID, warehouse.whouse_id) WAS_BUY, "+
"    row_number() over (order by warehouse.whouse_id,warehouse.trademark_id) ID \n" +
"    from  \n" +
"         mv_warehouse2 warehouse \n" +
"    left join web_whouses whs "+
"    on whs.id=warehouse.whouse_id "+
//"    left join mv_prod_auto p "+
//"    on p.id=warehouse.prod_id"+
"             WHERE\n" +
"             warehouse.prod_id= ?prodId AND WHOUSE_ID IN ("+whouses+") "+
//"              and warehouse.whouse_id=28 \n" +
"   group by " +
"    warehouse.prod_id, " +
"    warehouse.trademark_name, " +
"    warehouse.whouse_name, " +
"    warehouse.whouse_real_name, " +
"    whs.name_short, "+
"    warehouse.isexternal, "+
"    warehouse.whouse_id, " +
"    warehouse.trademark_id, " +
"    warehouse.AMOUNT_WAITING, " +
"    warehouse.AMOUNT_INWAY, " +
"    warehouse.company_id, " +
"    warehouse.updatedate, " +
"    warehouse.days, " +
"    warehouse.ISSALE, " +
"    warehouse.DELIVERY_COMMENTARY, "+
"    warehouse.DELIVERY_TIME " +
"    order by isexternal,warehouse.trademark_id,warehouse.whouse_id desc "
            ,GoodsResult.class)
                .setParameter("prodId", prodId)
                .setParameter("userId", userId);
        
        
        
        return q.getResultList();
//        return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
