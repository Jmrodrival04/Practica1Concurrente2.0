package io.dreamteam.practica1_concurrente.domain;


import io.dreamteam.practica1_concurrente.domain.SensorAcceso;
import io.dreamteam.practica1_concurrente.repos.SensorAccesoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorAccesoService implements SensorService<SensorAcceso> {

    private final SensorAccesoRepository sensorAccesoRepository;

    public SensorAccesoService(SensorAccesoRepository sensorAccesoRepository) {
        this.sensorAccesoRepository = sensorAccesoRepository;
    }

    @Override
    public List<SensorAcceso> getAll() {
        return sensorAccesoRepository.findAll();
    }

    @Override
    public SensorAcceso create(SensorAcceso sensor) {
        return sensorAccesoRepository.save(sensor);
    }

    @Override
    public void delete(Long id) {
        sensorAccesoRepository.deleteById(id);
    }
}