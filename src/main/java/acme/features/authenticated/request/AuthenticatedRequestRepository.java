
package acme.features.authenticated.request;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import acme.entities.request.Request;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedRequestRepository extends AbstractRepository {

	@Query("select a from Request a")
	Collection<Request> findManyAll();

	@Query("select a from Request a where a.id=?1")
	Request findOneById(Integer id);

	@Query("select a from Request a where a.ticker= :ticker")
	Request findOneByTicker(@Param("ticker") String ticker);
}
