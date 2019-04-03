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
public class ColumnProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = " cannot be Blank")
	@NotNull(message = " cannot be Null")
	private String name;

	// Refers to "columnProfile" property in "Cell" class
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "columnProfileId")
	private Set<Cell> cells;

	// Refers to "columnProfile" property in "Sheet" class
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "columnProfileId")
	private Set<Cell> sheets;

	public ColumnProfile(@NotBlank(message = " cannot be Blank") @NotNull(message = " cannot be Null") String name) {
		this.name = name;
	}

}
