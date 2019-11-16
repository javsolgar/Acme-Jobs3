
package acme.features.administrator.banner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.banner.Banner;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorBannerRepository extends AbstractRepository {

	@Query("select a from Banner a where a.id = ?1")
	Banner findOneById(int id);

	@Query("select a from Banner a")
	Collection<Banner> findManyAll();

}
