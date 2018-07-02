/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author mikhail.volk
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Filters.AuthenticationFilter.class);
        resources.add(SessionBean.AutokatalogFacadeREST.class);
        resources.add(SessionBean.CarMarksFacadeREST.class);
        resources.add(SessionBean.CarModelsFacadeREST.class);
        resources.add(SessionBean.CartFacadeREST.class);
        resources.add(SessionBean.CartListFacadeREST.class);
        resources.add(SessionBean.DeliveryAddressFacadeREST.class);
        resources.add(SessionBean.FileFacadeREST.class);
        resources.add(SessionBean.GenerationFacadeREST.class);
        resources.add(SessionBean.GoodsResultFacadeREST.class);
        resources.add(SessionBean.OrderDetailViewFacadeREST.class);
        resources.add(SessionBean.OrderFacadeREST.class);
        resources.add(SessionBean.OrderViewFacadeREST.class);
        resources.add(SessionBean.ProdFacadeREST.class);
        resources.add(SessionBean.UserFacadeREST.class);
        resources.add(SessionBean.WebLogFacadeREST.class);
        resources.add(SessionBean.WhousesFacadeREST.class);
    }
    
}
