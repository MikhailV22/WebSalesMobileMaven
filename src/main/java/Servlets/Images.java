/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

//import JSF.WebUsersController;
import SessionBean.WebUsersTokenFacade;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotAuthorizedException;

/**
 *
 * @author mikhail.volk
 */
@WebServlet(name = "Images", urlPatterns = {"/ImagesBank/*"})
public class Images extends HttpServlet {

    @EJB
    WebUsersTokenFacade webUsersTokenFacade;
    
//    @Inject
//    WebUsersController webUsersController;
//
//    public WebUsersController getWebUsersController() {
//        return webUsersController;
//    }
//
//    public void setWebUsersController(WebUsersController webUsersController) {
//        this.webUsersController = webUsersController;
//    }
//    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Images</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Images at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//              System.out.println("request.getQueryString(): "+request.getPathInfo());
//              System.out.println(getServletContext().getRealPath("/"));
//              System.out.println("doGet Images:" +request.getPathTranslated());

        String queryParam = request.getParameter("token");
        System.out.println("queryParam:"+queryParam);

//        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//        System.out.println("header:"+ authorizationHeader);
        
        
        // Check if the HTTP Authorization header is present and formatted correctly 
//        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
//            throw new NotAuthorizedException("Authorization header must be provided");
//        }

        // Extract the token from the HTTP Authorization header
  //    String token = authorizationHeader.substring("Bearer".length()).trim();
        String token = request.getParameter("token");

        try {
            // Validate the token
            webUsersTokenFacade.validateToken(token);
        } catch (Exception e) {
            // Если пользователь не авторизован, то выдаем пустышку
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
            } finally {
                out.close();
            }
            return;
        }

            


//            if (getWebUsersController().getCanLogon()<=0){
//                response.setContentType("text/html;charset=UTF-8");
//                PrintWriter out = response.getWriter();
//                try {
//                } finally {
//                    out.close();
//                }
//                return;
//            }
        
            
            String path = request.getPathInfo().substring(1,request.getPathInfo().lastIndexOf("/"));
//            System.out.println("path:" +path);
            String justName = request.getPathInfo().substring(request.getPathInfo().lastIndexOf("/")+1,request.getPathInfo().length());        
            
            String fileName = "";
//            String fileName = request.getRequestURI();
//            String justName = fileName.substring(fileName.lastIndexOf("/")+1,fileName.length());        
//            System.out.println("fileName:"+fileName);
//            System.out.println("justName:"+justName);
            
            if (request.getRequestURL().toString().contains("localhost")){
                fileName = "C:\\Program Files\\glassfish-4.1\\glassfish\\domains\\domain1\\docroot\\images\\"+path+"\\"+justName;
            }else{
                fileName = "C:\\glassfish4\\glassfish\\domains\\domain1\\docroot\\images\\"+path+"\\"+justName;
            }
                    
                    
            

            
            File myfile = new File(fileName);

            // Проверяем есть ли файл на диске
            if (!myfile.exists()){
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try {
                    out.println("<h1>File not found</h1>");
                } finally {
                    out.close();
                }
                return;
            }
            
            BufferedInputStream buf = null;
            ServletOutputStream myOut = null;
            try {
                myOut = response.getOutputStream();
                response.setContentLength((int) myfile.length());            
            
                FileInputStream input = new FileInputStream(myfile);
                buf = new BufferedInputStream(input);
                int readBytes = 0;
 
                //read from the file; write to the ServletOutputStream
                while ((readBytes = buf.read()) != -1) {
                    myOut.write(readBytes);
                }
            } finally {
                //close the input/output streams
                if (myOut != null) {
                    myOut.close();
                }
                if (buf != null) {
                    buf.close();
                }
            }    
            
            
//        System.out.println("doGet Images:" +request.getPathTranslated());
//        System.out.println("1");
//        File file = new File(request.getPathTranslated());
//        System.out.println("2");
//        if (!file.exists())
//        {
//            response.sendError(response.SC_NOT_FOUND);
//            System.out.println("return");
//            return;
//        }
        
       // processRequest(request, response);
    }

    private void validateToken(String token) throws Exception {
        // Check if it was issued by the server and if it's not expired
        // Throw an Exception if the token is invalid
        if(!token.equals("1234")){
            throw new NotAuthorizedException("Invalid token");
            //throw new UnsupportedOperationException("Not supported yet."); 
        }
    }    
    
    
}
