
package acme.features.consumer.offers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offers;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ConsumerOffersCreateService implements AbstractCreateService<Consumer, Offers> {

	//	Internal State -------------------------------------------------------------------------------------------------------------------
	@Autowired
	ConsumerOffersRepository repository;


	// Abstract<Provider, Request> -------------------------------------------------------------------------------------------------------

	@Override
	public boolean authorise(final Request<Offers> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Offers> request, final Offers entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "currency", "accept");

	}

	@Override
	public void unbind(final Request<Offers> request, final Offers entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "description", "deadline", "ticker", "moment", "lowerRange", "majorRange");

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
		boolean isDuplicated, isRange, isAccepted, isFuture, hasDeadline, hasMajorRange, hasLowerRange;
		Date dateNow, deadline;

		dateNow = new Date(System.currentTimeMillis() - 1);

		hasDeadline = entity.getDeadline() != null;
		errors.state(request, hasDeadline, "deadline", "administrator.offers.error.must-have-deadline");

		if (hasDeadline) {
			deadline = entity.getDeadline();
			isFuture = dateNow.before(deadline);
			errors.state(request, isFuture, "deadline", "administrator.offers.error.must-be-future");

		}

		isDuplicated = this.repository.findOneByTicker(entity.getTicker()) != null;
		errors.state(request, !isDuplicated, "ticker", "consumer.offers.error.tickerDuplicated");

		isRange = entity.getMajorRange().getAmount() > entity.getLowerRange().getAmount();
		errors.state(request, isRange, "amountMajor", "consumer.offers.error.notRange");

		hasMajorRange = entity.getMajorRange().getAmount() > entity.getLowerRange().getAmount();
		errors.state(request, hasMajorRange, "amountMajor", "consumer.offers.error.notRange");

		hasLowerRange = entity.getMajorRange().getAmount() > entity.getLowerRange().getAmount();
		errors.state(request, hasLowerRange, "amountMajor", "consumer.offers.error.notRange");

		isAccepted = request.getModel().getBoolean("accept");
		errors.state(request, isAccepted, "accept", "authenticated.offers.error.must-accept");

	}

	@Override
	public void create(final Request<Offers> request, final Offers entity) {
		assert request != null;
		assert entity != null;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);

		this.repository.save(entity);

	}

}
