/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.OrderDetailView;
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
@Path("entity.orderdetailview")
public class OrderDetailViewFacadeREST extends AbstractFacade<OrderDetailView> {

    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    public OrderDetailViewFacadeREST() {
        super(OrderDetailView.class);
    }

//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(OrderDetailView entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, OrderDetailView entity) {
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
//    public OrderDetailView find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<OrderDetailView> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<OrderDetailView> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("{userId}/{orignum}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<OrderDetailView> findRangeByOrderId(@PathParam("orignum") String orignum, @PathParam("userId") Long userId) {

        getEntityManager().flush();
        
        Query q = getEntityManager().createNativeQuery(
"select\n" +
"    ID,\n" +
//"    ORIGNUM,\n" +
//"    REGDATE,\n" +
"    USER_ID,\n" +
"    WHOUSE_ID,\n" +
"    PROD_ID,\n" +
"    TRADEMARK_ID,\n" +
"    PRICE,\n" +
"    AMOUNT,\n" +
"    ISDELETED,\n" +
"    RESERVEDDAYS,\n" +
"    DROPRESERVEDATE,\n" +
"    STATUS,\n" +
"    WHOUSE_NAME,\n" +
"    PROD_NAME,\n" +
"    PROD_INFO,\n" +
"    SCAN,\n" +
"    EURO,\n" +
"    PROD_COMMENTERY,\n" +
"    DIMENSION,"+
"    TRADEMARK_NAME,\n" +
"    DELIVERY_DATE,\n" +
"    DELIVERY_ADDRESS,\n" +
//"    drop_reserv_status,\n"+
//"    canDropReserv,\n"+
"    rn \n" +
"from(\n" +
"select \n" +
"    line.id,\n" +
"    LINE.ORIGNUM,\n" +
"    LINE.REGDATE,\n" +
"    LINE.USER_ID,\n" +
"    LINE.WHOUSE_ID,\n" +
"    LINE.PROD_ID,\n" +
"    LINE.TRADEMARK_ID,\n" +
"    LINE.PRICE,\n" +
"    LINE.AMOUNT,\n" +
"    LINE.ISDELETED,\n" +
"    LINE.DELIVERY_DATE,\n" +
"    LINE.DELIVERY_ADDRESS,\n" +
"    LINE.RESERVEDDAYS,\n" +
//"    LINE.CREATEDATE+LINE.RESERVEDDAYS DROPRESERVEDATE," +
"    CASE\n" +
"        WHEN LINE.STATUS=0 AND LINE.RESERVEDDAYS>0 and TRUNC(LINE.CREATEDATE)+LINE.RESERVEDDAYS>=TRUNC(SYSDATE) THEN TRUNC(LINE.CREATEDATE)+LINE.RESERVEDDAYS\n" +
"        ELSE NULL\n" +
"    END DROPRESERVEDATE," +
"    LINE.STATUS,\n" +
"    WHS.NAME_SHORT WHOUSE_NAME,\n" +
"    P.NAME PROD_NAME,\n" +
"    line.PROD_INFO,\n" +
"    P.SCAN,\n" +
"    P.EURO1 EURO,\n" +
"    P.COMMENTARY PROD_COMMENTERY,\n" +
"    P.DIMENSION," +
"    TM.TRADEMARK_NAME TRADEMARK_NAME,\n" +
//"    case\n" +
//"        when drop_reserv.status=0 then 'К удалению'\n" +
//"        when drop_reserv.status=1 then 'Удален'\n" +
//"        else null \n" +
//"    end drop_reserv_status,"+
//"    case\n" +
//"        WHEN NOT drop_reserv.status is null then 0 \n" +
//"        WHEN LINE.STATUS=0 AND LINE.RESERVEDDAYS>0 and TRUNC(LINE.CREATEDATE)+LINE.RESERVEDDAYS<TRUNC(SYSDATE) THEN 0 \n" +
//"        WHEN LINE.STATUS <> 0 THEN 0 \n" +
//"        else 1 \n" +
//"    end canDropReserv,"+
"    row_number() over (order by line.regdate desc, line.orignum) rn \n" +
"from v_order1c_all line \n" +
"    left join v_trademarks tm on LINE.TRADEMARK_ID=TM.TRADEMARK_ID\n" +
"    left join web_whouses whs on LINE.WHOUSE_ID=whs.id\n" +
"    left join mv_prod_auto p on LINE.PROD_ID=p.id " +
//"    left join ORDER1C_DROP_RESERV drop_reserv on \n" +
//"                            LINE.ORIGNUM=drop_reserv.ORIGNUM AND\n" +
//"                            LINE.WHOUSE_ID=drop_reserv.WHOUSE_ID AND\n" +
//"                            LINE.TRADEMARK_ID=drop_reserv.TRADEMARK_ID AND\n" +
//"                            LINE.PROD_ID=drop_reserv.PROD_ID \n"+
" where " +
" trim(line.orignum) = trim(?orignum) "+
" and line.USER_ID = ?userId " +
" order by line.regdate desc, line.orignum)\n " +
//" where rn> ?from and rn<= ?till   "+
" ORDER BY regdate desc, orignum desc"
            ,OrderDetailView.class)
//                .setParameter(1, companyId)
//                .setParameter("1",range[0])
//                .setParameter("2",range[1]);
                .setParameter("orignum", orignum.replace("slash","/"))
                .setParameter("userId", userId) ;
        return q.getResultList();
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
