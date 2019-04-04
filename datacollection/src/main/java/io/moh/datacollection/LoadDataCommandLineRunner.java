package io.moh.datacollection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.moh.datacollection.controller.TestController;
import io.moh.datacollection.domain.entities.RowProfile;

@Component
public class LoadDataCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(LoadDataCommandLineRunner.class);

	@Autowired
	private TestController testController;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Define Row
		RowProfile row01 = new RowProfile();
		row01.setName("the first line");
		RowProfile row02 = new RowProfile();
		row02.setName("the second line");

		testController.rowsList.add(row01);
		testController.rowsList.add(row02);
		log.info("Data loaded successfully.");
	}

}
