package io.dreamteam.practica1_concurrente.repos;

import io.dreamteam.practica1_concurrente.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
