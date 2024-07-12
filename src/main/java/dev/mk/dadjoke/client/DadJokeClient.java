package dev.mk.dadjoke.client;

import dev.mk.dadjoke.model.DadJokeResponse;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

public interface DadJokeClient {
    // GET https://icanhazdadjoke.com/

    @GetExchange("/")
    DadJokeResponse random();
}
