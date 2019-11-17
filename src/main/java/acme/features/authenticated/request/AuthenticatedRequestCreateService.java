
package acme.features.authenticated.request;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.request.Request;
import acme.entities.roles.Provider;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.datatypes.Money;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedRequestCreateService implements AbstractCreateService<Authenticated, Request> {

	//	Internal State -------------------------------------------------------------------------------------------------------------------
	@Autowired
	AuthenticatedRequestRepository repository;


	// Abstract<Provider, Request> -------------------------------------------------------------------------------------------------------

	@Override
	public boolean authorise(final acme.framework.components.Request<Request> request) {
		assert request != null;
		boolean b = request.getPrincipal().hasRole(Provider.class);
		return b;
	}

	@Override
	public void bind(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "moment", "remember", "amount", "currency", "reward");

	}

	@Override
	public void unbind(final acme.framework.components.Request<Request> request, final Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "description", "deadLine");

	}

	@Override
	public Request instantiate(final acme.framework.components.Request<Request> request) {
		Request result;

		result = new Request();
		return result;
	}

	@Override
	public void validate(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		boolean isDuplicated, isAccepted;

		isDuplicated = this.repository.findOneByTicker(entity.getTicker()) != null;
		errors.state(request, !isDuplicated, "ticker", "authenticated.request.error.tickerDuplicated");

		isAccepted = request.getModel().getBoolean("accept");
		errors.state(request, isAccepted, "accept", "authenticated.request.error.must-accept");
	}

	@Override
	public void create(final acme.framework.components.Request<Request> request, final Request entity) {
		Date moment;
		Money reward;
		Double amount;
		String currency;

		reward = new Money();
		amount = request.getModel().getDouble("amount");
		currency = request.getModel().getString("currency");
		moment = new Date(System.currentTimeMillis() - 1);
		reward.setAmount(amount);
		reward.setCurrency(currency);

		entity.setReward(reward);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
