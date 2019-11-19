
package acme.features.administrator.comercialbanner;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banner.ComercialBanner;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorComercialbannerListService implements AbstractListService<Administrator, ComercialBanner> {

	@Autowired
	AdministratorComercialbannerRepository repository;


	@Override
	public boolean authorise(final Request<ComercialBanner> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<ComercialBanner> request, final ComercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "urlPicture", "slogan", "urlTarget", "creditCard");

	}

	@Override
	public Collection<ComercialBanner> findMany(final Request<ComercialBanner> request) {
		assert request != null;

		Collection<ComercialBanner> result;
		result = this.repository.findManyAll();
		return result;
	}

}
