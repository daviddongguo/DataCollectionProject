package io.moh.datacollection.domain.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RowProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = " cannot be Blank")
	@NotNull(message = " cannot be Null")
	private String name;

	// Refers to "rowProfile" property in "Cell" class
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "rowProfileId")
	private Set<Cell> cells;

	public RowProfile(@NotBlank(message = " cannot be Blank") @NotNull(message = " cannot be Null") String name) {
		this.name = name;
	}

}
