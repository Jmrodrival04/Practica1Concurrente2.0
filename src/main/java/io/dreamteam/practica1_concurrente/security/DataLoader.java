package io.dreamteam.practica1_concurrente.security;

import io.dreamteam.practica1_concurrente.domain.Rol;
import io.dreamteam.practica1_concurrente.domain.Usuario;
import io.dreamteam.practica1_concurrente.repos.RolRepository;
import io.dreamteam.practica1_concurrente.repos.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Crear roles
        Rol adminRole = rolRepository.findByRol("ROLE_ADMIN");
        if (adminRole == null) {
            adminRole = new Rol();
            adminRole.setRol("ROLE_ADMIN");
            rolRepository.save(adminRole);
        }

        Rol userRole = rolRepository.findByRol("ROLE_USER");
        if (userRole == null) {
            userRole = new Rol();
            userRole.setRol("ROLE_USER");
            rolRepository.save(userRole);
        }

        // Crear usuarios (Vengadores)
        createUser("tony.stark", "ironman", Set.of(adminRole, userRole)); // Admin y User
        createUser("steve.rogers", "captainamerica", Set.of(userRole)); // Solo User
        createUser("thor", "godofthunder", Set.of(userRole)); // Solo User
        createUser("bruce.banner", "hulk", Set.of(userRole)); // Solo User
        createUser("natasha.romanoff", "blackwidow", Set.of(userRole)); // Solo User
        createUser("clint.barton", "hawkeye", Set.of(userRole)); // Solo User
    }

    private void createUser(String username, String password, Set<Rol> roles) {
        if (usuarioRepository.findByUsername(username) == null) {
            Usuario usuario = new Usuario();
            usuario.setUsername(username);
            usuario.setPassword(passwordEncoder.encode(password)); // Codificar contraseña
            usuario.setRoles(roles); // Asignar roles directamente
            usuario.setIsActive(true);
            usuarioRepository.save(usuario);
        }
    }
}