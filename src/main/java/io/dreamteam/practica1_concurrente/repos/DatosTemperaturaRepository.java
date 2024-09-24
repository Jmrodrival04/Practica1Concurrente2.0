package io.dreamteam.practica1_concurrente.repos;

import io.dreamteam.practica1_concurrente.domain.DatosTemperatura;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DatosTemperaturaRepository extends JpaRepository<DatosTemperatura, Long> {
}
