package io.moh.datacollection.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.moh.datacollection.domain.entities.RowProfile;

@RestController
public class TestController {

	private List<RowProfile> rowsList = new ArrayList<>();

	@GetMapping("/test")
	public String getTestString() {
		return "success.";
	}

	@GetMapping("/test/rows/{rowName}")
	public RowProfile getRowProfile(@PathVariable String rowName) {
		return new RowProfile(rowName);
	}

	@GetMapping("/test/rows")
	public List<RowProfile> getAllRow() {
		return this.rowsList;
	}

	@PostMapping("/test/rows")
	public ResponseEntity<Object> createRow(@RequestBody RowProfile row) {

		rowsList.add(row);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(row.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
