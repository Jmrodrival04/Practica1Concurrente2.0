package io.dreamteam.practica1_concurrente.repos;

import io.dreamteam.practica1_concurrente.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByRol(String rol); // Método para encontrar rol por nombre
}