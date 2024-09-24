package io.dreamteam.practica1_concurrente.repos;

import io.dreamteam.practica1_concurrente.domain.SensorMovimiento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SensorMovimientoRepository extends JpaRepository<SensorMovimiento, Long> {
}
