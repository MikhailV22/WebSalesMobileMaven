/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import SessionBean.WebUsersTokenFacade;
import java.io.IOException;
import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author mikhail.volk
 */


@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {


    @EJB
    WebUsersTokenFacade webUsersTokenFacade;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
//        System.out.println("AuthenticationFilter");
        // Get the HTTP Authorization header from the request
        String authorizationHeader = 
            requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Check if the HTTP Authorization header is present and formatted correctly 
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new NotAuthorizedException("Authorization header must be provided");
        }

        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring("Bearer".length()).trim();
//        System.out.println("token: "+token);

        try {

            // Validate the token
            webUsersTokenFacade.validateToken(token);

        } catch (Exception e) {
            requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED).build());
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public void validateToken(String token) throws Exception {
//        
//// Check if it was issued by the server and if it's not expired
//        // Throw an Exception if the token is invalid
//        
//        if(webUsersTokenFacade.findByToken(token).isEmpty()){
//            throw new NotAuthorizedException("Invalid token");
//            //throw new UnsupportedOperationException("Not supported yet."); 
//        }
//    }    


}
