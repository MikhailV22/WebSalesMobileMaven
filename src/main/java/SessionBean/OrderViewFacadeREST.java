/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.OrderView;
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
@Path("entity.orderview")
public class OrderViewFacadeREST extends AbstractFacade<OrderView> {

    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    public OrderViewFacadeREST() {
        super(OrderView.class);
    }

//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(OrderList entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, OrderList entity) {
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
//    public OrderList find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<OrderList> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<OrderList> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderView> findRange(@PathParam("userId") Long user_id) {

        getEntityManager().flush();
//        Query q = getEntityManager().createNativeQuery(""
//+"select "
//+"            ID, "
//+"            ORIGNUM, "
//+"            trunc(REGDATE) REGDATE, "
//+"            TO_CHAR(REGDATE,'DD.MM.YYYY') REGDATE_STR, "
//+"            USER_ID, "
////+"            MANAGER_ID, "
//+"            STATUS, "
//+"            COST, "
//+"            AMOUNT, "
//+"            ISDELETED, "
////+"            CREATEUSER_ID, "
////+"            DELETEUSER_ID, "
////+"            DELETEDATE, "
//+"            COMMENTARY, "
////+"            USER_COMMENTARY, "
//+"            TRANSPORTCOMPANY, "
////+"            IS_INSURANCE, "
//+"            DELIVERY_TYPE, "
//+"            DELIVERY_DATE, "
//+"            DELIVERY_TYPENAME, "
//+"            DELIVERY_ADDRESS, "
////+"            SALE_DATE, "
////+"            manager_name manager_name, "
//+"            detaildescr, "
////+"            user_name user_name, "
//+"            STATUS_NAME, "
//+"            STATUS_COLOR, "
//+"            rn  "
//+"from  "
//+"(  "
//+"select  /*+ ALL_ROWS */ "
//+"            ID, "
//+"            ORIGNUM, "
//+"            REGDATE, "
//+"            USER_ID, "
//+"            MANAGER_ID, "
//+"            STATUS, "
//+"            COST, "
//+"            AMOUNT, "
//+"            ISDELETED, "
//+"            CREATEUSER_ID, "
//+"            DELETEUSER_ID, "
//+"            DELETEDATE, "
//+"            COMMENTARY, "
//+"            USER_COMMENTARY, "
//+"            TRANSPORTCOMPANY, "
//+"            IS_INSURANCE, "
//+"            DELIVERY_TYPE, "
//+"            DELIVERY_DATE, "
//+"            SALE_DATE, "
//+"            DECODE(DELIVERY_TYPE,1,'Доставка',2,'Самовывоз') DELIVERY_TYPENAME, "
//+"            DELIVERY_ADDRESS, "
//+"            manager_name manager_name, "
//+"            detaildescr, "
//+"            user_name user_name, "
//+"            P_WEB_ORDER.GET_STATUS_NAME(status) STATUS_NAME, "
//+"            P_WEB_ORDER.GET_STATUS_COLOR(status) STATUS_COLOR, "
//+"            row_number() over (order by ID desc) rn  "
//+"    from v_web_order L  "
//+"    WHERE USER_ID = ?"
//+" ORDER BY ID DESC"
//+"      )  "
//+"where                   "
//+"            rn > ? and rn<= ? "
//+" ORDER BY ID DESC"
//            ,OrderList.class)
//                .setParameter(1, user_id)
//                .setParameter(2,0)
//                .setParameter(3,50);
//                .setParameter(2,range[0])
//                .setParameter(3,range[1]);


        Query q = getEntityManager().createNativeQuery("select \n" +
"    rn ID, \n" +
"    ORIGNUM,\n" +
"    REGDATE,\n" +
"    USER_ID,\n" +
"    WHOUSE_ID,\n" +
"    PRICE COST,\n" +
"    AMOUNT,\n" +
"    DELIVERY_DATE,\n" +
"    DELIVERY_ADDRESS,\n" +
"    SALEDATE,\n" +
"    STATUS,\n" +
"    WHOUSE_NAME,\n" +
"    DROPRESERVEDATE,\n" +
"    P_ORDER1C.GET_CONTENT_DESCR(orignum,?userId) COMMENTARY," +        
"    SBER_1C_STATUS,\n" +
"    rn \n" +
"FROM(\n" +
"select \n" +
"    LINE.ORIGNUM,\n" +
"    LINE.REGDATE,\n" +
"    LINE.USER_ID,\n" +
"    LINE.WHOUSE_ID,\n" +
"    LINE.PRICE,\n" +
"    LINE.AMOUNT,\n" +
"    LINE.DELIVERY_DATE,\n" +
"    LINE.DELIVERY_ADDRESS,\n" +
"    LINE.SALEDATE,\n" +
"    LINE.STATUS,\n" +
"    WHS.NAME WHOUSE_NAME,\n" +
"    LINE.DROPRESERVEDATE,\n" +
"    LINE.SBER_1C_STATUS,\n" +

"    row_number() over (order by line.regdate desc, line.orignum) rn \n" +
"from V_ORDER1C_HEAD_ALL line \n" +
"    left join web_whouses whs on LINE.WHOUSE_ID=whs.id\n" +
" where  " +
        " line.user_id = ?userId"+                
" order by line.regdate desc, line.orignum)\n" +
" where rn> ?from and rn<= ?till \n" +
" ORDER BY regdate desc, orignum desc"                
            ,OrderView.class)
//                .setParameter(1, companyId)
//                .setParameter("1",range[0])
//                .setParameter("2",range[1]);
                .setParameter("from",0)
                .setParameter("till",50)
                .setParameter("userId", user_id) ;

        return q.getResultList();
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
