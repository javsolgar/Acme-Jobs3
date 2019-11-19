
package acme.features.provider.request;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.request.Request;
import acme.entities.roles.Provider;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.services.AbstractCreateService;

@Service
public class ProviderRequestCreateService implements AbstractCreateService<Provider, Request> {

	//	Internal State -------------------------------------------------------------------------------------------------------------------
	@Autowired
	ProviderRequestRepository repository;


	// Abstract<Provider, Request> -------------------------------------------------------------------------------------------------------

	@Override
	public boolean authorise(final acme.framework.components.Request<Request> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "moment", "accept", "deadLine");

	}

	@Override
	public void unbind(final acme.framework.components.Request<Request> request, final Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "description", "reward", "deadLine");

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

		Date dateNow, deadLine;
		boolean isDuplicated, isAccepted, isFuture, deadLineNotNull;

		//deadLineNotNull = request.getModel().getDate("deadLine") != null;
		deadLineNotNull = request.getModel().getString("deadLine") != null && request.getModel().getString("deadLine") != "";
		errors.state(request, deadLineNotNull, "deadLine", "provider.request.error.must-not-be-null");

		if (deadLineNotNull) {
			dateNow = new Date(System.currentTimeMillis() - 1);

			deadLine = request.getModel().getDate("deadLine");
			//deadLine = new SimpleDateFormat("yyyy/mm/dd")

			isFuture = dateNow.before(deadLine);
			errors.state(request, isFuture, "deadLine", "provider.request.error.must-be-future");

		}

		isDuplicated = this.repository.findOneByTicker(entity.getTicker()) != null;
		errors.state(request, !isDuplicated, "ticker", "provider.request.error.tickerDuplicated");

		isAccepted = request.getModel().getString("accept") != "" && request.getModel().getString("accept") != null;
		errors.state(request, isAccepted, "accept", "provider.request.error.must-accept");

		isAccepted = request.getModel().getString("accept") != "" && request.getModel().getString("accept") != null;
		errors.state(request, isAccepted, "accept", "provider.request.error.must-accept");
	}

	@Override
	public void create(final acme.framework.components.Request<Request> request, final Request entity) {
		Date deadline;
		//		Money reward;

		//reward = (Money) request.getModel().getAttribute("reward");
		deadline = request.getModel().getDate("deadLine");
		//entity.setReward(reward);
		entity.setDeadLine(deadline);

		this.repository.save(entity);

	}

}
