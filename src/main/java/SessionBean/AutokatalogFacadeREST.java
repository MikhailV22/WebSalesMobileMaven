/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.Autokatalog;
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
@Path("entity.autokatalog")
public class AutokatalogFacadeREST extends AbstractFacade<Autokatalog> {

    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    public AutokatalogFacadeREST() {
        super(Autokatalog.class);
    }

//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(Autokatalog entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, Autokatalog entity) {
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
//    public Autokatalog find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Autokatalog> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Autokatalog> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
//    @Path("cars/{markId}/{modelId}/{generation}/{year}")
    @Path("cars/{modelId}/{generation}/{year}")
    @Produces("application/json")
    public List<Autokatalog> findCars(//@PathParam("markId") Integer markId,
                                        @PathParam("modelId") Integer modelId,
                                        @PathParam("generation") String generation,
                                        @PathParam("year") String year
                                        ) {
        String str="";
        if (!generation.trim().equals("-1")){
//          str=" and DBMS_UTILITY.GET_HASH_VALUE(k.description,0,100000) = "+description;
          str=" and k.generation_id = "+generation;
        }
//        if (description.trim().length()!=0){
//          str=" and DBMS_UTILITY.GET_HASH_VALUE(k.description,0,100000) = "+description;
//        }
        
//        System.out.println("111");
        String year1="";
        if (!year.trim().equals("null")){
//        System.out.println("222");
            year1=" and "+year+" between yb and ye ";
        }
//        System.out.println("333");
        
        
        Query q = getEntityManager().createNativeQuery(
        "SELECT "
        + "k.ID, "
//        + "MARKNAME||' '||MODELNAME||' '||bt.name_rus||' '||YEAR_B||'-'||YEAR_E||' '||GENERATION_NAME||' '||DESCRIPTION FULL_NAME, "
        + "MARKNAME||' '||MODELNAME||' '||BODYNAME||' '||YEAR_B||'-'||YEAR_E||' '||GENERATION_NAME||' '||DESCRIPTION FULL_NAME, "
        + "MARKNAME, "
        + "MODELNAME, "
        + "BODYNAME, "
        + "BT.NAME_RUS BODYNAME_RUS, "
        + "YEAR_B, "
//        + "YEAR_E, "
        + "decode(YE,9999,'н.в.',YE) YEAR_E,  "
        + "COMMENTARY, "
        + "nvl(DESCRIPTION,' ') DESCRIPTION, "
        + "nvl(GENERATION_NAME,' ') GENERATION_NAME, "
        + "k.TMD_ID, "
        + "P_SEARCH_BY_STEP.ExistsByCar(k.id) onStock "        
        + "FROM  callcentre.mv_autokatalog k left join callcentre.bodytypes bt on k.body_id=bt.id "
        + " WHERE k.isvisible=1 "
//        + " AND P_SEARCH_BY_STEP.ExistsByCar(k.id)<>0 "
//                +" and k.mark_id = ? "
                +" and k.model_id = ? "
//                +" and k.description = ? "
                + str
                + year1
                +" ORDER BY BT.SORTIR,k.BODYNAME,k.YEAR_B desc"
                , Autokatalog.class)
//                .setParameter(1, "%");
//                .setParameter(1, markId)
                .setParameter(1, modelId);
//                .setParameter(3, description);
//                .setParameter(1, "%HONDA%");
        return q.getResultList();
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
