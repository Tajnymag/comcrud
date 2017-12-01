package cz.fit.cvut.comcrud.entity.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author aubrech
 */
@javax.ws.rs.ApplicationPath("rest")
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
		resources.add(cz.fit.cvut.comcrud.entity.service.AutorFacadeREST.class);
		resources.add(cz.fit.cvut.comcrud.entity.service.HistorieFacadeREST.class);
		resources.add(cz.fit.cvut.comcrud.entity.service.KapitolaFacadeREST.class);
		resources.add(cz.fit.cvut.comcrud.entity.service.KomiksFacadeREST.class);
		resources.add(cz.fit.cvut.comcrud.entity.service.NarodnostFacadeREST.class);
		resources.add(cz.fit.cvut.comcrud.entity.service.PrispevekFacadeREST.class);
		resources.add(cz.fit.cvut.comcrud.entity.service.SlozkaFacadeREST.class);
		resources.add(cz.fit.cvut.comcrud.entity.service.UzivatelFacadeREST.class);
		resources.add(cz.fit.cvut.comcrud.entity.service.ZanrFacadeREST.class);
	}

}
