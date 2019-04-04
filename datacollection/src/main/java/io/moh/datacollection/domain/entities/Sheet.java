package io.moh.datacollection.domain.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Sheet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name = "sheet")
	private Set<ColumnProfile> header;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "sheet")
	private Set<Line> lines;

	public Line getLineById(Long id) {

		Line line = null;
		for (Line l : this.lines) {
			if (l.getId() == id) {
				line = l;
				break;
			}
		}
		return line;
	}

	public Line getLineByRowProfile(RowProfile rowProfile) {

		Line line = null;
		for (Line l : this.lines) {
			List<Cell> cellsList = new ArrayList<Cell>(l.getCells());
			if (cellsList.get(0).getRowProfile() == rowProfile) {
				line = l;
				break;
			}
		}
		return line;
	}

	public void generateHeader() {
		Set<ColumnProfile> header = new HashSet<>();
		for (Line l : this.lines) {
			header.addAll(l.deduceHeader());
		}
		this.header = header;
	}
}
