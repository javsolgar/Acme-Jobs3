
package acme.features.administrator.comercialbanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banner.ComercialBanner;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorComercialbannerCreateService implements AbstractCreateService<Administrator, ComercialBanner> {

	@Autowired
	AdministratorComercialbannerRepository repository;


	@Override
	public boolean authorise(final Request<ComercialBanner> request) {
		assert request != null;
		boolean b = request.getPrincipal().hasRole(Administrator.class);
		return b;
	}

	@Override
	public void bind(final Request<ComercialBanner> request, final ComercialBanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<ComercialBanner> request, final ComercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "urlPicture", "slogan", "urlTarget", "reditCard");
	}

	@Override
	public ComercialBanner instantiate(final Request<ComercialBanner> request) {
		ComercialBanner result;
		result = new ComercialBanner();
		return result;
	}

	@Override
	public void validate(final Request<ComercialBanner> request, final ComercialBanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<ComercialBanner> request, final ComercialBanner entity) {
		this.repository.save(entity);
	}
}
