
package acme.entities.noncomercialbanner;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.URL;

import acme.entities.banner.Banner;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Noncomercialbanner extends Banner {

	// Serialization Identify ------------------------------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;

	//	Atributes	----------------------------------------------------------------------------------------------------------

	@URL
	private String jingle;
}
