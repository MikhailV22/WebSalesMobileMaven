/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.Prod;
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
@Path("entity.prod")
public class ProdFacadeREST extends AbstractFacade<Prod> {

    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    public ProdFacadeREST() {
        super(Prod.class);
    }

//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(Prod entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, Prod entity) {
//        super.edit(entity);
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") Long id) {
//        super.remove(super.find(id));
//    }
//
    @GET
    @Secured    
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Prod find(@PathParam("id") Long id) {
//        return super.find(id);
//System.out.println("test id: "+id);
        Query q = getEntityManager().createNativeQuery("SELECT "+
"               ID, NAME, CAR_NAME, "+
//"                  NAME_FOR_SEARCH, "
                 "SCAN, DIMENSION,  "+
"                  PRODTYPE_ID, PRODTYPE_NAME, PRODTYPE_FULLNAME,  "+
"               COMMENTARY, ISVISIBLE,  "+
"                   REMARKS, EURO1 EURO,  "+
"                  YEARS,  "+
"                  PROD_YEAR_B, PROD_YEAR_E,  "+
"                  WEIGHT, "+
"                  THICKNESS, "+
"                 PICTURENAME,"+
"                 CAMERA,"+
"                 CAMERA_CALIBR,"+
"                 CALIBRATION_NAME CALIBRATIONNAME,"+
"                  P_EUROCODE_DESCR.decode_code(euro1,PRODTYPE_ID) eurocode_descr "+
//"                  case  "+
//"                        when prodtype_id in(1,4) then P_EUROCODE_DESCR.decode_code(euro1)  "+
//"                        else null  "+
//"                  end eurocode_descr, "+
                
//"                  p_web_warehouse.whereExists(p.id) whereExists  "+
"               FROM MV_PROD_AUTO P "+
        "WHERE P.ID= ?id ",Prod.class)
                    .setParameter("id",  id);
        
        if (!q.getResultList().isEmpty()){
            return (Prod)q.getResultList().get(0);
        }
        return null;


    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Prod> findAll() {
//        return super.findAll();
//    }
    
    @GET
    @Secured    
    @Path("byname/{prodName}/{whouses}/{prodtypes}/{year}/{euro}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Prod> findByName(
                    @PathParam("prodName") String prodName,
                    @PathParam("whouses") String whouses,
                    @PathParam("prodtypes") String prodtypes,
                    @PathParam("year") Integer year,
                    @PathParam("euro") String euro) {
//        return super.findAll();
//        System.out.println("year:"+year);
        // Если ввели код до 4 символов, то по оригинальному коду не ищем            
        String pOrgiginalCode="x---x";
//        if (searchParam.getScancode().length()>4){
//            pOrgiginalCode=searchParam.getScancode().replace(".", "").replace(",","").replace("-", "").replace("/", "");
//        }
        String pOrgiginalCodeSQL="";
        if (euro.length()>4){
            pOrgiginalCode=euro.replace(".", "").replace(",","").replace("-", "").replace("/", "").replace(" ", "%");
            pOrgiginalCodeSQL="             OR original_code_for_search LIKE ('%"+pOrgiginalCode.trim()+"%') ";
        }
        
        String yearSQL="";
        if (year!=0){
            yearSQL="            and CAR_YB <="+year.toString()+"   and CAR_YE>="+year.toString()+" ";
//            years=" AND CAR_YB <= "+getYear()+" AND CAR_YE>= "+getYear();
        }
        
        String prodtypeSQL="";
        if (!prodtypes.equals("null")){
            prodtypeSQL=" AND p.prodtype_id in ("+prodtypes+") ";
//            years=" AND CAR_YB <= "+getYear()+" AND CAR_YE>= "+getYear();
        }
        
//        String pFygCodeSQL="";
//        if (user_controller.getConnectedUser().getStatus()==1){
//            pFygCodeSQL="             OR NVL(UPPER(FYG_CODE),' ') LIKE ('%'|| ?scan ||'%')";
//        }

        Query q = getEntityManager().createNativeQuery(

"select \n" +
//"    rn id, \n" +
"    prod_id id, \n" +
"    rn row_num, \n" +
"    name, \n" +
//"    car_name, \n" +
"    PRODTYPE_ID, \n" +
"    PRODTYPE_NAME, \n" +
"    scancode scan, \n" +
"    eurocode euro, \n" +
//"    dimension,                \n" +
"    euro4, \n" +
"    years, \n" +
"    prod_remarks remarks, \n" +
"   PROPERTY, "+
"    PROD_COMMENTARY COMMENTARY, \n" +
//"    WEIGHT, \n" +
"    on_stock, \n" +
//"    P_PROD.HAVE_ANALOG(PROD_ID, ?whousesList) HAVE_ANALOG, "+
"    P_PROD.HAVE_SOPUT(PROD_ID) HAVE_SOPUT, \n" +
"    PICTURENAME, \n" +
//"    OBOGREV, \n" +
"    P_EUROCODE_DESCR.DECODE_CODE(eurocode,prodtype_id) EUROCODE_DESCR,                \n" +
"    rn \n" +
"from \n" +
"( \n" +
"select \n" +
"    p.id prod_id, \n" +
"    p.name, \n" +
"    PRODTYPE_ID, \n" +
"    PRODTYPE_NAME, \n" +
"    scan scancode, \n" +
"    euro1 eurocode, \n" +
"    euro4, \n" +
"    years, \n" +
"    p.REMARKS prod_remarks, \n" +
"    p.PROPERTY, "+
"    p.COMMENTARY PROD_COMMENTARY, \n" +
"    p.PICTURENAME, \n" +
"    warehouse.amount on_stock, \n" +
"    row_number() over (order by nvl2(amount,1,0) desc,euro1) rn \n" +
"    from mv_prod_auto p \n" 
+"   left join     (select sum(amount+amount_waiting) amount, prod_id from mv_warehouse2 where 1=1 AND WHOUSE_ID IN ("+whouses+") group by prod_id) warehouse"
+"   on p.id=warehouse.prod_id"        
+"             WHERE p.ISVISIBLE=1 "
//+"             p.prodtype_id in ("+prodtypes+") "
+   prodtypeSQL
+   yearSQL        
+"             AND ("
//+"             NVL(UPPER(SCAN),' ') LIKE ('%'|| ?scan ||'%') "
+"              NVL(UPPER(EURO_FOR_SEARCH),' ') LIKE ('%'|| ?euro ||'%') "
//+pFygCodeSQL
//+pIdSQL // для поиска товара по ID                
+pOrgiginalCodeSQL        
+"              )"
+"             AND  NAME_FOR_SEARCH LIKE ('%'|| ?prodName ||'%')"
//+ searchParam.getTypes2()
//+ searchParam.getYears()+
+"    order by nvl2(amount,1,0) desc, p.prodtype_id, euro1 \n" 
+"      ) \n" 
+"where                  \n" 
+"            rn > ?from and rn<= ?till "            
                ,Prod.class)
//                .setParameter("scan", searchParam.getScancode().replace(" ", "%").toUpperCase())
                .setParameter("euro", "%"+euro.toUpperCase().replace("NULL", "").replace(" ", "%") +"%")
                .setParameter("prodName", "%"+prodName.toUpperCase().replace("NULL", "").replace(" ", "%") +"%")
                .setParameter("from",0)
                .setParameter("till",1000);
        return q.getResultList();


    }

    @GET
    @Secured    
    @Path("bycar/{carId}/{whouses}/{prodtypes}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Prod> findByCar(
                    @PathParam("carId") String carId,
                    @PathParam("whouses") String whouses,
                    @PathParam("prodtypes") String prodtypes
            ) {
//        return super.findAll();
        String prodtypeSQL="";
        if (!prodtypes.equals("null")){
            prodtypeSQL=" AND p.prodtype_id in ("+prodtypes+") ";
//            years=" AND CAR_YB <= "+getYear()+" AND CAR_YE>= "+getYear();
        }

        Query q = getEntityManager().createNativeQuery(

"select \n" +
//"    rn id, \n" +
"    prod_id id, \n" +
"    rn row_num, \n" +
"    name, \n" +
//"    car_name, \n" +
"    PRODTYPE_ID, \n" +
"    PRODTYPE_NAME, \n" +
"    scancode scan, \n" +
"    eurocode euro, \n" +
//"    dimension,                \n" +
"    euro4, \n" +
"    years, \n" +
"    prod_remarks remarks, \n" +
"   PROPERTY, "+
"    PROD_COMMENTARY COMMENTARY, \n" +
//"    WEIGHT, \n" +
"    on_stock, \n" +
//"    P_PROD.HAVE_ANALOG(PROD_ID, ?whousesList) HAVE_ANALOG, "+
"    P_PROD.HAVE_SOPUT(PROD_ID) HAVE_SOPUT, \n" +
"    PICTURENAME, \n" +
//"    OBOGREV, \n" +
"    P_EUROCODE_DESCR.DECODE_CODE(eurocode,prodtype_id) EUROCODE_DESCR,                \n" +
"    rn \n" +
"from \n" +
"( \n" +
"select \n" +
"    p.id prod_id, \n" +
"    p.name, \n" +
"    PRODTYPE_ID, \n" +
"    PRODTYPE_NAME, \n" +
"    scan scancode, \n" +
"    euro1 eurocode, \n" +
"    euro4, \n" +
"    years, \n" +
"    p.REMARKS prod_remarks, \n" +
"    p.PROPERTY, "+
"    p.COMMENTARY PROD_COMMENTARY, \n" +
"    p.PICTURENAME, \n" +
"    warehouse.amount on_stock, \n" +
"    row_number() over (order by nvl2(amount,1,0) desc,euro1) rn \n" +
"    from mv_prod_auto p \n" 
+"   left join     (select sum(amount+amount_waiting) amount, prod_id from mv_warehouse2 where 1=1 AND WHOUSE_ID IN ("+whouses+") group by prod_id) warehouse"
+"   on p.id=warehouse.prod_id"        
+"    WHERE p.ID IN (select prod_id from CALLCENTRE.BIND_PROD_AUTO bind where BIND.AUTOKATALOG_ID= ?ak_id and isdeleted=0)  "                
+prodtypeSQL
//+"    AND       p.prodtype_id in ("+prodtypes+") "
+"   AND      p.ISVISIBLE=1 "
//+ searchParam.getTypes2()
//+ searchParam.getYears()+
+"    order by nvl2(amount,1,0) desc, p.prodtype_id, euro1 \n" 
+"      ) \n" 
+"where                  \n" 
+"            rn > ?from and rn<= ?till "            
                ,Prod.class)
//                .setParameter("scan", searchParam.getScancode().replace(" ", "%").toUpperCase())
                .setParameter("ak_id", carId)
                .setParameter("from",0)
                .setParameter("till",1000);
        return q.getResultList();


    }

    
    @GET
    @Secured    
    @Path("pictures/{euro}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Prod> findImgsTMD2(
                    @PathParam("euro") String euro
            ) {
    
    //public List findImgsTMD2(String str) {

        if( euro.equals("") && euro==null)
        {    
            return null;
        }
        
        
        Query q = getEntityManager().createNativeQuery(
                
"        select "+
"                 rownum ID,   "+
"                 path picturename   "+
"         from  "+
"        (  "+
"        select  "+
"            trim(picturename) path,  "+
"            substr(picturename,instr(picturename,'/',-1)+1) filename,  "+
"           row_number() over (partition by picturename order by picturename) rn   "+
"         from v_pictures_glass where upper(salescode) = nvl( upper('"+euro+"') ,'-xxx')  "+
//"         from tmd.tmdpictures where upper(salescode) = nvl( upper('"+str+"') ,'-xxx')  "+
"         order by path)  "+
"         where rn=1  "
                
                
               ,Prod.class );
        return q.getResultList();
    }    
    
    
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Prod> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
