package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class D387SampleCodeApplication {
	static ExecutorService messageExecutor = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);

		messageExecutor.execute(() -> displayWelcomeMessage("welcome_fr_CA.properties"));
		messageExecutor.execute(() -> displayWelcomeMessage("welcome_en_US.properties"));
	}

	public static String displayWelcomeMessage(String fileName) {
		try {
			InputStream stream = new ClassPathResource(fileName).getInputStream();
			Properties properties = new Properties();
			properties.load(stream);
			return properties.getProperty("welcome");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String[] convertAndDisplayTimeZones(LocalDateTime dateTime) {
		ZoneId zEastern = ZoneId.of("America/New_York");
		ZoneId zMountain = ZoneId.of("America/Denver");
		ZoneId zoneId = ZoneId.systemDefault();

		try {
			ZonedDateTime zonedDateTime = dateTime.atZone(zoneId);
			ZonedDateTime zonedDateTimeEastern = zonedDateTime.withZoneSameInstant(zEastern);
			ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(zMountain);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm a");

			String localTime = zonedDateTime.format(formatter);
			String easternTime = zonedDateTimeEastern.format(formatter);
			String mountainTime = zonedDateTimeMountain.format(formatter);

			return new String[]{localTime, easternTime, mountainTime};
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}