package io.dreamteam.practica1_concurrente.repos;

import io.dreamteam.practica1_concurrente.domain.DatosAcceso;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DatosAccesoRepository extends JpaRepository<DatosAcceso, Long> {
}
