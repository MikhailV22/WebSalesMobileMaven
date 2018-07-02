/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.CarModels;
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
@Path("entity.carmodels")
public class CarModelsFacadeREST extends AbstractFacade<CarModels> {

    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    public CarModelsFacadeREST() {
        super(CarModels.class);
    }

//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(CarModels entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, CarModels entity) {
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
//    public CarModels find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<CarModels> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<CarModels> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("byname/{markId}/{substr}")
    @Produces("application/json")
    public List<CarModels> findByName(@PathParam("markId") Integer markId,
                                      @PathParam("substr") String substr) {
        Query q = getEntityManager().createNativeQuery(
        "SELECT distinct "
        + "ID, "
        + "NAME, "
        + "P_SEARCH_BY_STEP.ExistsByModel(id) onStock "        
        + " FROM CALLCENTRE.MODELS "
        + " WHERE isvisible=1 "
        +" and mark_id = ? "
        +" and id in (select model_id from autokatalog where isvisible=1) "
        +" and upper(trim(name)||trim(searchstring)) like ? "
        +" ORDER BY name"
                , CarModels.class)
//                .setParameter(1, "%");
                .setParameter(1,markId)
                .setParameter(2, "%"+substr.toUpperCase().replace("NULL", "").replace(" ", "%") +"%");
//                .setParameter(1, "%HONDA%");
        return q.getResultList();
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
