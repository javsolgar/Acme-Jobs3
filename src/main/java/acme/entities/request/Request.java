
package acme.entities.request;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Request extends DomainEntity {

	// Serialization Identify ------------------------------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//	Atributes	----------------------------------------------------------------------------------------------------------

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadLine;

	@NotBlank
	private String				description;

	private Money				reward;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[R][a-zA-Z]{4}[-][0-9]{5}$")
	private String				ticker;


	// Derivated Atributes -------------------------------------------------------------

	@Transient
	@Min(0)
	public Integer getCifra() { //Si reward es null devuelve -1 para que no pase la condición
		Integer cifra = this.reward != null ? new Integer(this.reward.getAmount().intValue()) : -1;
		return cifra;

	}
}
