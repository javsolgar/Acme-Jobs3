
package acme.features.administrator.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenge.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
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
		boolean b = request.getPrincipal().hasRole(Administrator.class);
		return b;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "amountGold", "currencyGold", "amountSilver", "currencySilver", "amountBronze", "currencyBronze", "rewardGold", "rewardSilver", "rewardBronze");

	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "description", "deadline", "goalGold", "goalSilver", "goalBronze");

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

	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {

		Double amountGold, amountSilver, amountBronze;
		String currencyGold, currencySilver, currencyBronze;
		Money rewardGold, rewardSilver, rewardBronze;

		rewardGold = new Money();
		rewardSilver = new Money();
		rewardBronze = new Money();

		amountGold = request.getModel().getDouble("amountGold");
		amountSilver = request.getModel().getDouble("amountSilver");
		amountBronze = request.getModel().getDouble("amountBronze");

		currencyGold = request.getModel().getString("currencyGold");
		currencySilver = request.getModel().getString("currencySilver");
		currencyBronze = request.getModel().getString("currencyBronze");

		rewardGold.setAmount(amountGold);
		rewardGold.setCurrency(currencyGold);

		rewardSilver.setAmount(amountSilver);
		rewardSilver.setCurrency(currencySilver);

		rewardBronze.setAmount(amountBronze);
		rewardBronze.setCurrency(currencyBronze);

		entity.setRewardGold(rewardGold);
		entity.setRewardSilver(rewardSilver);
		entity.setRewardBronze(rewardBronze);

		this.repository.save(entity);

	}

}
