package io.moh.datacollection.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.moh.datacollection.domain.entities.RowProfile;

@RestController
public class TestController {

	@GetMapping("/test")
	public String getTestString() {
		return "success.";
	}

	@GetMapping("/test/row/{rowName}")
	public RowProfile getRowProfile(@PathVariable String rowName) {
		return new RowProfile(rowName);
	}

}
