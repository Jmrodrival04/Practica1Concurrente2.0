package io.dreamteam.practica1_concurrente.domain;


import io.dreamteam.practica1_concurrente.domain.SensorTemperatura;
import io.dreamteam.practica1_concurrente.repos.SensorTemperaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorTemperaturaService implements SensorService<SensorTemperatura> {

    private final SensorTemperaturaRepository sensorTemperaturaRepository;

    public SensorTemperaturaService(SensorTemperaturaRepository sensorTemperaturaRepository) {
        this.sensorTemperaturaRepository = sensorTemperaturaRepository;
    }

    @Override
    public List<SensorTemperatura> getAll() {
        return sensorTemperaturaRepository.findAll();
    }

    @Override
    public SensorTemperatura create(SensorTemperatura sensor) {
        return sensorTemperaturaRepository.save(sensor);
    }

    @Override
    public void delete(Long id) {
        sensorTemperaturaRepository.deleteById(id);
    }
}