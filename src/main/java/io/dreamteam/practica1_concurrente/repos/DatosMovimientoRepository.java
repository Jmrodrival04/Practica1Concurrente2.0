package io.dreamteam.practica1_concurrente.repos;

import io.dreamteam.practica1_concurrente.domain.DatosMovimiento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DatosMovimientoRepository extends JpaRepository<DatosMovimiento, Long> {
}
