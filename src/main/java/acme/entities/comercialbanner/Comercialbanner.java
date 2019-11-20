
package acme.entities.comercialbanner;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.CreditCardNumber;

import acme.entities.banner.Banner;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comercialbanner extends Banner {

	// Serialization Identify ------------------------------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;

	//	Atributes	----------------------------------------------------------------------------------------------------------

	@NotBlank
	@CreditCardNumber
	private String creditCard;

}
