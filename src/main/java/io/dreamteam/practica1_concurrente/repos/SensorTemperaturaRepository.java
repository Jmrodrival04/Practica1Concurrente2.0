package io.dreamteam.practica1_concurrente.repos;

import io.dreamteam.practica1_concurrente.domain.SensorTemperatura;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SensorTemperaturaRepository extends JpaRepository<SensorTemperatura, Long> {
}
