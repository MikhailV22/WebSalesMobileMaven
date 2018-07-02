/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.File;
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
@Path("entity.file")
public class FileFacadeREST extends AbstractFacade<File> {

    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    public FileFacadeREST() {
        super(File.class);
    }

    @GET
    //@Secured    
    @Path("pictures/{euro}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<File> findImgsTMD2(
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
                
                
               ,File.class );
        return q.getResultList();
    }    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
