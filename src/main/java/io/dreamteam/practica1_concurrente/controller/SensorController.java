package io.dreamteam.practica1_concurrente.controller;

import io.dreamteam.practica1_concurrente.domain.SensorEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sensores")
public class SensorController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Evento simulado de detección de movimiento
    @Async
    @PostMapping("/alerta")
    public void enviarAlerta(@RequestBody SensorEvento evento) {
        if (evento.isCritico()) {
            messagingTemplate.convertAndSend("/topic/alertas", "Alerta: " + evento.getDescripcion());
        }
    }
}
