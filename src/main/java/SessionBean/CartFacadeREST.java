/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.Cart;
import Filters.Secured;
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

/**
 *
 * @author mikhail.volk
 */
@Stateless
@Path("entity.cart")
public class CartFacadeREST extends AbstractFacade<Cart> {

    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    public CartFacadeREST() {
        super(Cart.class);
    }

    
    
    @POST
    @Secured    
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Cart entity) {
        System.out.println("entity:"+entity.toString());
        super.create(entity);
    }

    @PUT
    @Secured    
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(Cart entity) {
        System.out.println("edit entity:"+entity.toString());
        super.edit(entity);
    }

//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, Cart entity) {
//        super.edit(entity);
//    }

    @DELETE
    @Secured    
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
//        System.out.println("remove:" +id);
        super.remove(super.find(id));
    }

    @GET
    @Secured    
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cart find(@PathParam("id") Long id) {
        return super.find(id);
    }

//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Cart> findAll() {
//        return super.findAll();
//    }

    

    
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Cart> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
