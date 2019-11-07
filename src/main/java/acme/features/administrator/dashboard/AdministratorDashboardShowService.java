
package acme.features.administrator.dashboard;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.dashboard.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AdministratorDashboardRepository repository;


	// AbstractShowService<Administrator, Dashboard> interface --------------

	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalAnnouncement", "totalInvestorsRecord", "totalCompanyRecords", "minRewardRequest", "maxRewardRequest", "minRewardOffers", "maxRewardOffers", "companysBySector", "sectorsOfCompanys", "inverstorsBySector",
			"sectorsOfInverstors");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		Dashboard result = new Dashboard();
		result.setTotalAnnouncement(this.getTotalAnnouncement());
		result.setTotalCompanyRecords(this.getTotalCompanyRecords());
		result.setTotalInvestorsRecord(this.getTotalInvestorsRecord());
		result.setMinRewardRequest(this.getMinRewardRequest());
		result.setMaxRewardRequest(this.getMaxRewardRequest());
		result.setMinRewardOffers(this.getMinRewardOffer());
		result.setMaxRewardOffers(this.getMaxRewardOffer());
		result.setCompanysBySector(this.getCompanysBySector());
		result.setInverstorsBySector(this.getInverstorsBySector());
		result.setSectorsOfCompanys(this.getSectorsOfCompanys());
		result.setSectorsOfInverstors(this.getSectorOfInverstors());
		return result;
	}

	public Integer getTotalAnnouncement() {
		Integer res = this.repository.countAnnouncement();
		return res;
	}

	public Integer getTotalInvestorsRecord() {
		Integer res = this.repository.countInvestorsRecords();
		return res;
	}

	public Integer getTotalCompanyRecords() {
		Integer res = this.repository.countCompanyRecord();
		return res;
	}

	public Double getMinRewardRequest() {
		Double res = this.repository.getMinRewardRequest();
		return res;
	}

	public Double getMaxRewardRequest() {
		Double res = this.repository.getMaxRewardRequest();
		return res;
	}

	public Double getMinRewardOffer() {
		Double res = this.repository.getMinRewardOffer();
		return res;
	}

	public Double getMaxRewardOffer() {
		Double res = this.repository.getMaxRewardOffer();
		return res;
	}

	public Collection<Integer> getCompanysBySector() {
		Collection<Integer> res = this.repository.getCompanysBySector();
		return res;
	}

	public Collection<String> getSectorsOfCompanys() {
		Collection<String> res = this.repository.getSectorsOfCompanys();
		return res;
	}

	public Collection<Integer> getInverstorsBySector() {
		Collection<Integer> res = this.repository.getInverstorsBySector();
		return res;
	}

	public Collection<String> getSectorOfInverstors() {
		Collection<String> res = this.repository.getSectorOfInverstors();
		return res;
	}

}
