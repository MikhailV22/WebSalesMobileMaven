/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.User;
import Entity.WebUsersToken;
import Filters.Secured;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author mikhail.volk
 */
@Stateless
@Path("entity.user")
public class UserFacadeREST extends AbstractFacade<User> {

    @EJB
    WebUsersTokenFacade webUsersTokenFacade;
    
    @PersistenceContext(unitName = "WebSalesAPIPU")
    private EntityManager em;

    public UserFacadeREST() {
        super(User.class);
    }

//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(User entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, User entity) {
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
//    public User find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<User> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }

    
    @POST @Consumes("application/json")
//    @Secured    
    @Path("/logon")
    @Produces({MediaType.APPLICATION_JSON})
    public User logon(final User input) {
//        System.out.println("name = " + input.getName());
//        System.out.println("password = " + input.getPassword());
//        User user;
//        user = new User();
        
        
        Query q = getEntityManager().createNativeQuery(
                "SELECT ID,"
                        + "NAME, "
//                        + "'1234' TOKEN, "
                        + "ALLOW_WHOUSES WHOUSES, "
                        + "default_whouse, "
                        + "STATUS "
                        + "FROM WEB_USERS WHERE upper(LOGIN)=?login and PASSWORD=?password and isdeleted=0",
                User.class)
                    .setParameter("login",input.getName().toUpperCase())
                    .setParameter("password",input.getPassword());
        

        if (!q.getResultList().isEmpty()){

            User user = (User)q.getResultList().get(0);
            //Генерируем токен для пользователя
            user.setToken(createToken(user.getId().toString(),user.getName()));

            // Записываем токен в базу
            WebUsersToken webUsersToken = new WebUsersToken();
            Calendar cal = Calendar.getInstance();
            webUsersToken.setCreatedate(cal.getTime());
            cal.add(Calendar.HOUR, 24); // по умолчанию токен живет 24 часа
            webUsersToken.setExpiredDate(cal.getTime());
            webUsersToken.setToken(user.getToken());
            webUsersToken.setUserId(user.getId().intValue());
            webUsersTokenFacade.create(webUsersToken);
            // end

            // возвращаем пользователя с токеном
            return user;
//            return (User)q.getResultList().get(0);
        }
        return null;
        
    }    

//    @GET
//    @Path("count")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String countREST() {
//        return String.valueOf(super.count());
//    }

    @GET
    @Path("count")
//    @Produces(MediaType.TEXT_PLAIN)
    public JsonObject  countREST() {
        JsonObjectBuilder builder = Json.createObjectBuilder().
            add( "report", Json.createObjectBuilder().
                 add( "reportId", "1" ).
                 add( "title", "title" ).
                 add( "subtitle", "subTitle").
                 add( "created", "created.toString()" ).
                 add( "description", "description ").
                 add( "data", "report" )
                .add("phoneNumber", Json.createArrayBuilder()
                    .add(Json.createObjectBuilder()
                        .add("type", "home")
                        .add("number", "212 555-1234"))
                    .add(Json.createObjectBuilder()
                        .add("type", "fax")
                        .add("number", "646 555-4567")))
                   );
        
//    InitialContext c = new InitialContext();
//    NamingEnumeration<NameClassPair> list = c.list(namespace);
//    while (list.hasMoreElements()) {
//        NameClassPair nameClassPair = list.nextElement();
//        String name = nameClassPair.getName();
//        String type = nameClassPair.getClassName();
//        builder.add(name, type);
//    }
    return builder.build();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public static String createToken(String id, String login) {

        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.MILLISECOND, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MINUTE , 0);
//        cal.set(Calendar.HOUR, 0);

//        System.out.println("cal: "+ cal.getTime().toString());

        String password = id+login+cal.getTime().toString();

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
        }
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
          .printHexBinary(digest).toUpperCase();


        return myHash;
    }

    @GET
    @Secured    
    @Path("validateToken/{token}")
//    @Produces({ MediaType.APPLICATION_JSON})
//    @Produces(MediaType.TEXT_PLAIN)
//    public JsonObject  validateToken(@PathParam("token") String token) {
    public Integer  validateToken(@PathParam("token") String token) {
        System.out.println("token: "+token);
        int result=0;
        try {
            webUsersTokenFacade.validateToken(token);
            result=1;
        } catch (Exception e) {
            
        }
        
        JsonObjectBuilder builder = Json.createObjectBuilder().
            add( "result", result);
//        JsonObjectBuilder builder = Json.createObjectBuilder().
//            add( "result", result);
        
    return result;
//    return builder.build();
    }
    
    
}
