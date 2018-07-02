/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.CartList;
import Filters.Secured;
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
@Path("entity.cartlist")
public class CartListFacadeREST extends AbstractFacade<CartList> {

    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    public CartListFacadeREST() {
        super(CartList.class);
    }

//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(CartList entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, CartList entity) {
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
//    public CartList find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<CartList> findAll() {
//        return super.findAll();
//    }

    @GET
    @Secured    
    @Path("/byuser/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<CartList> findByUser(@PathParam("userId") String userId) {
//        return super.findAll();

//        System.out.println("CartList.findByUser");
        Query q = getEntityManager().createNativeQuery(
                "                select \n" +
"                 cart.id,\n" +
"                 cart.user_id,\n" +
"                 cart.whouse_id,\n" +
"                 cart.trademark_id,\n" +
"                 cart.prod_id,\n" +
"                 cart.amount,\n" +
"                 cart.price,\n" +
"                 cart.isaccepted,\n" +
"                 p.name prod_name,\n" +
"                 p.euro1 euro,\n" +
"                 pt.id prodtype_id,\n" +
"                 pt.name prodtype_name,\n" +
"                 whs.name whouse_name,\n" +
"                 whs.name_short whouse_name_short,\n" +
"                 tm.TRADEMARK_NAME\n" +
"                from web_cart cart left join prod p on cart.prod_id=p.id\n" +
"                    left join prodtype pt on p.prodtype_id=pt.id\n" +
"                    left join web_whouses whs on cart.whouse_id=whs.id\n" +
"                    left join v_trademarks tm on CART.TRADEMARK_ID=tm.TRADEMARK_ID \n" +
"                where user_id=?userId"
                
                ,CartList.class)
//                .setParameter("scan", searchParam.getScancode().replace(" ", "%").toUpperCase())
                .setParameter("userId", userId);
        return q.getResultList();


    }
    
    
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<CartList> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
