/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.WebUsersToken;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotAuthorizedException;

/**
 *
 * @author mikhail.volk
 */
@Stateless
public class WebUsersTokenFacade extends AbstractFacade<WebUsersToken> {

    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WebUsersTokenFacade() {
        super(WebUsersToken.class);
    }
    
    public List<WebUsersToken> findByToken(String token) {
        try {
//            TypedQuery<WebUsersToken> q = getEntityManager().createNamedQuery("WebUsersToken.findByToken",WebUsersToken.class)
//                .setParameter("token", token);
            
            
        Query q = getEntityManager().createNativeQuery(

"select \n" +
"    id,\n" +
"    user_id,\n" +
"    createdate,\n" +
"    expired_date,\n" +
"    token\n" +
"from WEB_USERS_TOKEN token \n" +
"where token= ?token " 
+" and  expired_date>=sysdate "
               ,WebUsersToken.class )
                .setParameter("token", token);
            
            
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    public void validateToken(String token) throws Exception {
        
// Check if it was issued by the server and if it's not expired
        // Throw an Exception if the token is invalid
        
        if(findByToken(token).isEmpty()){
            throw new NotAuthorizedException("Invalid token");
            //throw new UnsupportedOperationException("Not supported yet."); 
        }
    }    
    
    
}
