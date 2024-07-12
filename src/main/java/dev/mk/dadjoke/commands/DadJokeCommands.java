package dev.mk.dadjoke.commands;

import dev.mk.dadjoke.client.DadJokeClient;
import dev.mk.dadjoke.model.DadJokeResponse;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class DadJokeCommands {
    private final DadJokeClient dadJokeClient;

    public DadJokeCommands(DadJokeClient dadJokeClient) {
        this.dadJokeClient = dadJokeClient;
    }

    @ShellMethod(key = "random",value = "I will return a random dad joke!")
    public String getRandomDadJoke() {
        DadJokeResponse random = dadJokeClient.random();
        return random.joke();
    }

}
