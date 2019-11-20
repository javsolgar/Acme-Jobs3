
package acme.features.administrator.comercialbanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.comercialbanner.Comercialbanner;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorComercialbannerRepository extends AbstractRepository {

	@Query("select a from Comercialbanner a where a.id=?1")
	Comercialbanner findOneById(int id);

	@Query("select a from Comercialbanner a")
	Collection<Comercialbanner> findManyAll();
}
