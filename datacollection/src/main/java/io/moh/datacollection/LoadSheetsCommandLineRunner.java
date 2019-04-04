package io.moh.datacollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.moh.datacollection.domain.entities.Cell;
import io.moh.datacollection.domain.entities.ColumnProfile;
import io.moh.datacollection.domain.entities.Line;
import io.moh.datacollection.domain.entities.RowProfile;
import io.moh.datacollection.domain.entities.Sheet;
import io.moh.datacollection.repository.SheetRepository;

@Component
public class LoadSheetsCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(LoadSheetsCommandLineRunner.class);

	@Autowired
	SheetRepository repository;

	@Override
	public void run(String... args) throws Exception {

		loadOneSheet(repository);

		log.info("sheets loaded successfully.");
	}

	public void loadOneSheet(SheetRepository repository) {
		// Define Column
		ColumnProfile column01 = new ColumnProfile();
		column01.setName("Name");
		ColumnProfile column02 = new ColumnProfile();
		column02.setName("Age");

		// Define Row
		RowProfile row01 = new RowProfile();
		row01.setName("the first line");
		RowProfile row02 = new RowProfile();
		row02.setName("the second line");

		// Fill In Cell
		// The First Line
		Cell c01 = new Cell();
		c01.setRowProfile(row01);
		c01.setColumnProfile(column01);
		c01.setValue("David WU");

		Cell c02 = new Cell();
		c02.setRowProfile(row01);
		c02.setColumnProfile(column02);
		c02.setValue("23");

		Set<Cell> valuesSet01 = new HashSet<>();
		valuesSet01.add(c01);
		valuesSet01.add(c02);
		Line line01 = new Line();
		line01.setCells(valuesSet01);

		// The Second Line
		Cell c03 = new Cell();
		c03.setRowProfile(row02);
		c03.setColumnProfile(column01);
		c03.setValue("Jenny");

		Set<Cell> valuesSet02 = new HashSet<>();
		valuesSet02.add(c03);
		Line line02 = new Line();
		line02.setCells(valuesSet02);

		// Lines Set
		Set<Line> lineSet01 = new HashSet<>();
		lineSet01.add(line01);
		lineSet01.add(line02);

		// Sheet
		Sheet sheet01 = new Sheet();
		sheet01.setName("the first sheet");
		sheet01.setLines(lineSet01);
		sheet01.generateHeader();

		// Sheets List
		List<Sheet> list = new ArrayList<>();
		list.add(sheet01);

		repository.saveAll(list);
	}

}
