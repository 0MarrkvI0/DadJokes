package dev.mk.dadjoke;

import dev.mk.dadjoke.client.DadJokeClient;
import dev.mk.dadjoke.commands.HelloCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


@SpringBootApplication
public class DadjokeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DadjokeApplication.class, args);
	}

	@Bean
	DadJokeClient dadJokeClient() {
		WebClient client = WebClient.builder()
				.baseUrl("https://icanhazdadjoke.com")
				.defaultHeader("Accept","application/json")
				.build();

		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
		return factory.createClient(DadJokeClient.class);
	}
}
