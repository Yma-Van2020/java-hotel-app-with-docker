package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
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
}