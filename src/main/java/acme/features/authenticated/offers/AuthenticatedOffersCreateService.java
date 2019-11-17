
package acme.features.authenticated.offers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offers;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedOffersCreateService implements AbstractCreateService<Authenticated, Offers> {

	//	Internal State -------------------------------------------------------------------------------------------------------------------
	@Autowired
	AuthenticatedOffersRepository repository;


	// Abstract<Provider, Request> -------------------------------------------------------------------------------------------------------

	@Override
	public boolean authorise(final Request<Offers> request) {
		assert request != null;
		boolean b = request.getPrincipal().hasRole(Consumer.class);
		return b;
	}

	@Override
	public void bind(final Request<Offers> request, final Offers entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "moment", "lowerRange", "majorRange", "amountLower", "amountMajor", "currency", "accept");

	}

	@Override
	public void unbind(final Request<Offers> request, final Offers entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "description", "deadline", "ticker");

	}

	@Override
	public Offers instantiate(final Request<Offers> request) {
		assert request != null;

		Offers result = new Offers();

		return result;
	}

	@Override
	public void validate(final Request<Offers> request, final Offers entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		boolean isDuplicated, isRange, isAccepted;

		isDuplicated = this.repository.findOneByTicker(entity.getTicker()) != null;
		errors.state(request, !isDuplicated, "ticker", "authenticated.offers.error.tickerDuplicated");

		isRange = request.getModel().getDouble("amountMajor") > request.getModel().getDouble("amountLower");
		errors.state(request, isRange, "amountMajor", "authenticated.offers.error.notRange");

		isAccepted = request.getModel().getBoolean("accept");
		errors.state(request, isAccepted, "accept", "authenticated.offers.error.must-accept");

	}

	@Override
	public void create(final Request<Offers> request, final Offers entity) {
		Date moment;
		Double amountMajor;
		Double amountLower;
		Money moneyMajor;
		Money moneyLower;
		String currency;

		moneyMajor = new Money();
		moneyLower = new Money();
		moment = new Date(System.currentTimeMillis() - 1);
		amountMajor = request.getModel().getDouble("amountMajor");
		amountLower = request.getModel().getDouble("amountLower");
		currency = request.getModel().getString("currency");

		moneyMajor.setAmount(amountMajor);
		moneyLower.setAmount(amountLower);
		moneyMajor.setCurrency(currency);
		moneyLower.setCurrency(currency);

		entity.setMoment(moment);
		entity.setMajorRange(moneyMajor);
		entity.setLowerRange(moneyLower);

		this.repository.save(entity);

	}

}
