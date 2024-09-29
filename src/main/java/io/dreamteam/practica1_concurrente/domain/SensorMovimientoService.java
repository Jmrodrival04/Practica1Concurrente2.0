package io.dreamteam.practica1_concurrente.domain;



import io.dreamteam.practica1_concurrente.repos.SensorMovimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorMovimientoService implements SensorService<SensorMovimiento> {

    private final SensorMovimientoRepository sensorMovimientoRepository;

    public SensorMovimientoService(SensorMovimientoRepository sensorMovimientoRepository) {
        this.sensorMovimientoRepository = sensorMovimientoRepository;
    }

    @Override
    public List<SensorMovimiento> getAll() {
        return sensorMovimientoRepository.findAll();
    }

    @Override
    public SensorMovimiento create(SensorMovimiento sensor) {
        return sensorMovimientoRepository.save(sensor);
    }

    @Override
    public void delete(Long id) {
        sensorMovimientoRepository.deleteById(id);
    }
}