package io.dreamteam.practica1_concurrente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Practica1ConcurrenteApplication {
    public static void main(String[] args) {
        SpringApplication.run(Practica1ConcurrenteApplication.class, args);
    }
}

