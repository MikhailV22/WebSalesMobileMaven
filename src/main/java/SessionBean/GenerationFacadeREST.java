/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.Generation;
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
@Path("entity.generation")
public class GenerationFacadeREST extends AbstractFacade<Generation> {

    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    public GenerationFacadeREST() {
        super(Generation.class);
    }

//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(Generation entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, Generation entity) {
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
//    public Generation find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Generation> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Generation> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("generation/{modelId}/{year}")
    @Produces("application/json")
    public List<Generation> findGeneration(
                                        @PathParam("modelId") Integer modelId,
                                        @PathParam("year") String year){
//        System.out.println(modelId);
        String str="";
        if(year.length()==4){
            str=" and "+year+" between year_b and year_e";
        }
        
        Query q = getEntityManager().createNativeQuery(
//"select distinct \n" +
//"   DBMS_UTILITY.GET_HASH_VALUE(description,0,100000) ID,  " +
//"    description\n" +
//"from autokatalog ak\n" +
//"where model_id=? and not description is null"
"select\n" +
"   ID , \n" +
"   YEARS YEARS,"+
"   name NAME\n" +
"from callcentre.models_generations\n" +
"where model_id= ?modelId " +
" and isvisible= 1 " +
" and id in(select generation_id from callcentre.autokatalog where model_id= ?modelId "+str+")"+
"order by sortir desc"
                
                , Generation.class)
                .setParameter("modelId", modelId);
//                .setParameter(1, "%HONDA%");
        return q.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
