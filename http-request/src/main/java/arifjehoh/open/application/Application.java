package arifjehoh.open.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public Function<String, String> function() {
		return this::getResponse;
	}

	private String getResponse(String value) {
		return request(value);
	}

	private String request(String value) {
		final String uri = "https://dog.ceo/api/breeds/image/random";
		RestTemplate restTemplate = new RestTemplate();
		Dog result = restTemplate.getForObject(uri, Dog.class);
		System.out.println(result.getMessage());
		return result.getMessage();
	}
}
