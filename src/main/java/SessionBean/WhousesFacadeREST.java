/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.Whouses;
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
@Path("entity.whouses")
public class WhousesFacadeREST extends AbstractFacade<Whouses> {

    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    public WhousesFacadeREST() {
        super(Whouses.class);
    }

//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(Whouses entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, Whouses entity) {
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
//    public Whouses find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Whouses> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Whouses> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Secured    
    @Path("incart/{user_id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Whouses> findRange(@PathParam("user_id") Integer user_id) {
        Query q = getEntityManager().createNativeQuery(

"select \n" +
"    whs.id,\n" +
"    whs.name,\n" +
"    whs.name_short,\n" +
"    WHS.REAL_NAME,\n" +
"    WHS.DELIVERY_COMMENTARY,\n" +
"    WHS.DELIVERY_TIME,\n" +
"    WHS.WORKING_CONDITIONS,\n" +
"    WHS.WHOLESORTIR,\n" +
"    WHS.ISEXTERNAL\n" +
"    \n" +
"    \n" +
"from web_whouses whs\n" +
"where whs.id in(\n" +
"    select distinct\n" +
"        whouse_id\n" +
"    from web_cart \n" +
"    where user_id=?user_id\n" +
")"
               ,Whouses.class )
                .setParameter("user_id", user_id);
        return q.getResultList();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
