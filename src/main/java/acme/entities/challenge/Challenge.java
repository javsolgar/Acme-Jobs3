
package acme.entities.challenge;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge extends DomainEntity {

	//Serialization Identify -------------------------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//	Atributes	----------------------------------------------------------------------------------------------------

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadline;

	@NotBlank
	private String				description;

	@NotBlank
	private String				goalGold;

	private Money				rewardGold;

	@NotBlank
	private String				goalSilver;

	private Money				rewardSilver;

	@NotBlank
	private String				goalBronze;

	private Money				rewardBronze;

}
