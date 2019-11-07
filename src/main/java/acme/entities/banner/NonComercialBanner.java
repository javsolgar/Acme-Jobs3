
package acme.entities.banner;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class NonComercialBanner extends Banner {

	// Serialization Identify ------------------------------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//	Atributes	----------------------------------------------------------------------------------------------------------

	@URL
	private String				jingle;
}
