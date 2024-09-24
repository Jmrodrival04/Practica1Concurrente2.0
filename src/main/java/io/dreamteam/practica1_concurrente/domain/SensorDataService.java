package io.dreamteam.practica1_concurrente.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SensorDataService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private Random random = new Random();

    // Simulación de eventos de sensores
    @Scheduled(fixedRate = 5000) // Cada 5 segundos
    public void generarDatosSensor() {
        SensorEvento evento = new SensorEvento();
        evento.setDescripcion(generarDescripcionAleatoria());
        evento.setCritico(random.nextBoolean());  // Determina si el evento es crítico

        // Enviar evento por WebSocket
        messagingTemplate.convertAndSend("/topic/alertas", "Sensor: " + evento.getDescripcion() + " | Crítico: " + evento.isCritico());
    }

    private String generarDescripcionAleatoria() {
        String[] eventos = {"Movimiento detectado", "Acceso no autorizado", "Temperatura alta", "Fallo de conexión"};
        return eventos[random.nextInt(eventos.length)];
    }
}
