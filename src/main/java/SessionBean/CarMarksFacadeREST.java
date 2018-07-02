/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.CarMarks;
import Filters.Secured;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

/**
 *
 * @author mikhail.volk
 */
@Stateless
@Path("entity.carmarks")
public class CarMarksFacadeREST extends AbstractFacade<CarMarks> {

    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    public CarMarksFacadeREST() {
        super(CarMarks.class);
    }

//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(CarMarks entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, CarMarks entity) {
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
//    public CarMarks find(@PathParam("id") Long id) {
//        return super.find(id);
//    }

//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<CarMarks> findAll() {
//        return super.findAll();
//    }
    
    @GET
    @Secured
    @Path("byname/{substr}")
    @Produces("application/json")
    public List<CarMarks> findByName(@PathParam("substr") String substr) {
        
        
        
        
        Query q = getEntityManager().createNativeQuery(
        "SELECT "
        + "ID, "
        + "NAME, "
//        + "P_SEARCH_BY_STEP.ExistsByMark(id) onStock "        
        + "1 onStock "        
        + "FROM CALLCENTRE.MARKS "
        + " WHERE isvisible=1 "

        +" and P_SEARCH_BY_STEP.ExistsByMark(id)=1 "
        +" and id in(select mark_id from autokatalog) "
                
        +" and name like ? "
        +" ORDER BY name"
                , CarMarks.class)
//                .setParameter(1, "%");
                .setParameter(1, "%"+substr.toUpperCase().replace("NULL", "").replace(" ", "%") +"%");
//                .setParameter(1, "%HONDA%");
        return q.getResultList();
    }
    

//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<CarMarks> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
