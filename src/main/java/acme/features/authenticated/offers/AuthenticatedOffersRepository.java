
package acme.features.authenticated.offers;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.offers.Offers;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedOffersRepository extends AbstractRepository {

	@Query("select a from Offers a")
	Collection<Offers> findManyAll();

	@Query("select a from Offers a where a.id=?1")
	Offers findOneById(Integer id);

}
