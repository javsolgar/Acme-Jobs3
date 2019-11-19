
package acme.features.administrator.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenge.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorChallengeCreateService implements AbstractCreateService<Administrator, Challenge> {

	//	Internal State -------------------------------------------------------------------------------------------------------------------
	@Autowired
	AdministratorChallengeRepository repository;


	//	AbstractShowService<Authenticated, Challenge> Interface ---------------------------------------------------------------------------------------

	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "description", "deadline", "goalGold", "goalSilver", "goalBronze", "rewardGold", "rewardSilver", "rewardBronze");

	}

	@Override
	public Challenge instantiate(final Request<Challenge> request) {
		Challenge result;

		result = new Challenge();
		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean hasGoldGoal, hasSilverGoal, hasBronzeGoal;

		hasGoldGoal = request.getModel().getString("goalGold") != null;
		errors.state(request, hasGoldGoal, "goalGold", "administrator.challenge.error.must-have-goal");

		hasSilverGoal = request.getModel().getString("goalSilver") != null;
		errors.state(request, hasSilverGoal, "goalGold", "administrator.challenge.error.must-have-goal");

		hasBronzeGoal = request.getModel().getString("goalBronze") != null;
		errors.state(request, hasBronzeGoal, "goalGold", "administrator.challenge.error.must-have-goal");

	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {
		this.repository.save(entity);

	}

}
