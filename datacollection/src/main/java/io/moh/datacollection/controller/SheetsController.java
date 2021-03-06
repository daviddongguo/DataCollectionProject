package io.moh.datacollection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.moh.datacollection.domain.entities.Sheet;
import io.moh.datacollection.repository.SheetRepository;

@RestController
// Instead using Spring Data REST to implement the controller
public class SheetsController {

	@Autowired
	SheetRepository repository;

	@GetMapping("/test/first")
	public String first() {
		return "It's the first method.";
	}

	@GetMapping("/test/test/sheets")
	public Iterable<Sheet> getValues() {
		return repository.findAll();
	}

	@PostMapping("/test/sheets")
	public Sheet addValue(@RequestBody Sheet value) {
		Sheet dbValue = repository.save(value);
		return dbValue;
	}

	@GetMapping("/test/sheets/{id}")
	public Sheet getValues(@PathVariable long id) {
		return repository.findById(id).get();
	}

}
