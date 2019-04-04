package io.moh.datacollection.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.moh.datacollection.domain.entities.RowProfile;
import io.moh.datacollection.exceptions.RowNotFoundException;

@RestController
public class TestController {

	public List<RowProfile> rowsList = new ArrayList<>();

	@GetMapping("/test")
	public String getTestString() {
		return "success.";
	}

	@GetMapping("/test/rows/show/{rowName}")
	public RowProfile getRowProfile(@PathVariable String rowName) {
		return new RowProfile(rowName);
	}

	@GetMapping("/test/rows/{id}")
	public RowProfile getRowById(@PathVariable Long id) {
		if (id <= 0) {
			throw new RowNotFoundException("Id - " + id + "can not less than 1");
		}
		RowProfile result = null;
		for (RowProfile rowProfile : rowsList) {
			if (rowProfile.getId() == id) {
				result = rowProfile;
				break;
			}
		}
		if (result == null) {
			throw new RowNotFoundException("Id - " + id + "has not found");
		}

		return result;
	}

	@GetMapping("/test/rows")
	public List<RowProfile> getAllRow() {
		return this.rowsList;
	}

	@PostMapping("/test/rows")
	public ResponseEntity<Object> createRow(@Valid @RequestBody RowProfile row) {

		rowsList.add(row);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(row.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
