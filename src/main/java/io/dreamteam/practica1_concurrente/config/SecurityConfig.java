package io.dreamteam.practica1_concurrente.config;

import io.dreamteam.practica1_concurrente.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/", "/login", "/public/**").permitAll() // Permitir acceso a estas rutas
                        .requestMatchers("/admin/**").hasRole("ADMIN")  // Solo administradores
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")  // Usuarios o admins
                        .anyRequest().authenticated()  // Cualquier otra ruta requiere autenticación
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Página personalizada de login
                        .defaultSuccessUrl("/home/index", true)  // Redirigir a home/index.html después de un login exitoso
                        .failureUrl("/login?error=true")  // Redirigir si el login falla
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")  // Redirigir tras el logout
                        .permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usar BCrypt para codificar contraseñas
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}