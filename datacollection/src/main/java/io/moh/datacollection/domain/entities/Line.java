package io.moh.datacollection.domain.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Line {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cell")
	private Set<Cell> cells;

	public Set<ColumnProfile> deduceHeader() {
		Set<ColumnProfile> header = new HashSet<>();
		header = this.cells.stream().map(c -> c.getColumnProfile()).collect(Collectors.toSet());
		return header;
	}

}
