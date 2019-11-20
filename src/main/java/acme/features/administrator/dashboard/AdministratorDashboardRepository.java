
package acme.features.administrator.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(*) from Investorsrecords a")
	Integer countInvestorsRecords();

	@Query("select count(*) from Announcement a")
	Integer countAnnouncement();

	@Query("select count(*) from Companyrecord a")
	Integer countCompanyRecord();

	@Query("select cast(MIN(reward_amount)as double) AS PRICE FROM  Request")
	Double getMinRewardRequest();

	@Query("select cast(MAX(reward_amount)as double) AS PRICE FROM  Request")
	Double getMaxRewardRequest();

	@Query("select cast(MIN(lower_range_amount)as double) AS PRICE FROM  Offers")
	Double getMinRewardOffer();

	@Query("select cast(MAX(major_range_amount)as double) AS PRICE FROM  Offers")
	Double getMaxRewardOffer();

	@Query("select count(*) as Companyrecord from Companyrecord group by sector")
	List<Integer> getCompanysBySector();

	@Query("select sector as Companyrecord from Companyrecord group by sector")
	List<String> getSectorsOfCompanys();

	@Query("select count(*) as Investorsrecords from Investorsrecords group by sector")
	List<Integer> getInverstorsBySector();

	@Query("select sector as Investorsrecords from Investorsrecords group by sector")
	List<String> getSectorOfInverstors();

	@Query("select avg(a.reward.amount) from Request a")
	Double getMediaRequest();

	@Query("select avg((a.majorRange.amount + a.lowerRange.amount)/2) from Offers a")
	Double getMediaOffer();

}
