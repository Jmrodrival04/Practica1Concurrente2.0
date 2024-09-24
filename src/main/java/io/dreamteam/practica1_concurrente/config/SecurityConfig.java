package io.dreamteam.practica1_concurrente.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/", "/public/**").permitAll() // Permitir acceso a estas rutas
                .anyRequest().authenticated() // Requiere autenticación para cualquier otra solicitud
            )
            .formLogin(form -> form
                .loginPage("/login") // Página de inicio de sesión personalizada
                .permitAll() // Permitir acceso a la página de inicio de sesión
            )
            .logout(logout -> logout
                .permitAll()); // Permitir acceso al cierre de sesión

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usar BCrypt para codificar contraseñas
    }

    @Bean
    public AuthenticationManagerBuilder authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.inMemoryAuthentication()
            .withUser("usuario")
            .password(passwordEncoder().encode("contraseña"))
            .roles("USER");
        return auth;
    }
}
