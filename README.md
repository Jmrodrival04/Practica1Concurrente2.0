Proyecto 1 Programación Concurrente: Sistema de Seguridad Concurrente para Stark Industries
Enlace al repositorio: https://github.com/Jmrodrival04/Practica1Concurrente
Descripción del proyecto:
Este proyecto tiene como objetivo desarrollar un sistema de seguridad avanzado utilizando Spring Boot para gestionar múltiples sensores en tiempo real. Para trabajar eficazmente se ha dividido la planificación del proyecto en 2 fases:

Semana 1 - Configuración y Base del Proyecto:
Configuración de Spring Boot.
Implementación inicial de sensores y lógica concurrente.
Configuración de la seguridad del sistema.
Crear el repositorio en GitHub y comenzar a trabajar de forma colaborativa.
Semana 2 - Funcionalidades avanzadas y optimización:
Implementación de las notificaciones en tiempo real.
Autenticación y autorización con Spring Security.
Monitorización y logs.
Testing y optimización.
Roles y Tareas del Equipo
DESARROLLADOR BACKEND
Responsabilidades: Implementación de los servicios que manejan los sensores y el procesamiento concurrente.
Tareas clave:
Implementar las clases y servicios que representen los diferentes tipos de sensores (movimiento, temperatura, acceso).
Configurar y manejar la concurrencia utilizando @Async y ExecutorService.
Garantizar la eficiencia y modularidad en la gestión de datos.
Consejos:
Utiliza @Async para procesar los datos de los sensores de forma concurrente.
Investiga sobre la inyección de dependencias y el uso de Beans en Spring para gestionar los sensores.
INGENIERO DE SEGURIDAD
Responsabilidades: Configurar el sistema de autenticación y autorización para el control de acceso, garantizar la seguridad del sistema.
Tareas clave:
Configurar Spring Security para autenticar usuarios.
Definir roles (e.g., administrador, operador) y permisos.
Proteger las rutas y servicios según el rol del usuario.
Consejos:
Utiliza Spring Security para implementar autenticación y autorización con una base de datos simple (puede ser en memoria o con H2 para empezar).
Define reglas claras sobre qué tipo de usuario puede acceder a cada parte del sistema (por ejemplo, solo los administradores pueden ver los logs de seguridad).
Configura JWT (JSON Web Tokens) o autenticación basada en sesión.
DESARROLLADOR FRONTEND
Responsabilidades: Implementar la interfaz de usuario y gestionar las notificaciones en tiempo real.
Tareas clave:
Diseñar una interfaz básica con paneles de control para monitorear los sensores.
Implementar las notificaciones en tiempo real usando WebSockets o STOMP para notificar intrusiones o eventos críticos.
Consejos:
Utiliza Thymeleaf o alguna otra plantilla si se utiliza Spring Boot para el frontend. O bien, el desarrollador frontend puede crear una interfaz separada usando React o Angular.
Para notificaciones, busca tutoriales sobre WebSocket en Spring, que te permitirán crear canales de comunicación en tiempo real entre el backend y el frontend.
ADMINISTRADOR DE SISTEMAS
Responsabilidades: Configurar la monitorización, logs y asegurarse de que el sistema esté bien configurado y funcionando.
Tareas clave:
Configurar Spring Actuator para monitorizar el estado del sistema (por ejemplo, el tiempo de respuesta y los sensores activos).
Implementar un sistema de logging para rastrear errores y eventos importantes.
Consejos:
Actuator te permitirá exponer puntos de monitorización del sistema y ver información clave como la salud de las aplicaciones, la memoria, y más.
Configura un sistema de alertas o logs usando Logback o SLF4J.
Desglose de Pasos para el Proyecto
Crear el Proyecto con Spring Boot: Utiliza Bootify.io para generar un proyecto de Spring Boot. Añade dependencias necesarias como Spring Web, Spring Security, Spring Data JPA, Spring Actuator y WebSocket. Cada miembro puede clonar el repositorio y comenzar a trabajar en su parte.

Implementación de Sensores (Backend Developer): Crear clases de sensores para cada tipo (movimiento, temperatura, acceso). Puedes usar el patrón Observer para que los sensores notifiquen al sistema cuando detectan un evento. Utiliza @Async para procesar la información de los sensores de manera concurrente.

Procesamiento Concurrente (Backend Developer): Crear servicios que reciban y procesen los datos de los sensores utilizando ExecutorService o @Async en Spring. Asegúrate de que los sensores puedan operar de forma concurrente y eficiente sin bloquear el sistema.

Autenticación y Autorización (Ingeniero de Seguridad): Configura Spring Security para proteger las rutas del backend. Crea un esquema básico de roles (e.g., ROLE_ADMIN, ROLE_USER). Protege las rutas críticas del sistema, por ejemplo, solo usuarios con ROLE_ADMIN deberían poder acceder al sistema de logs y monitorización.

Notificaciones en Tiempo Real (Frontend Developer): Implementa WebSocket para las notificaciones en tiempo real. Asegúrate de que el sistema envíe alertas cuando un sensor detecte un evento crítico (e.g., movimiento o acceso no autorizado).

Monitorización y Logging (Administrador de Sistemas): Configura Spring Actuator para exponer puntos de monitorización del sistema. Configura un sistema de logs para capturar eventos importantes como fallos o intrusiones.

Herramientas y Repositorio
GitHub: Crea un repositorio compartido. Cada miembro debe clonar el repositorio y crear ramas de trabajo individuales para sus propias tareas. Define buenas prácticas para los commits, como incluir mensajes claros y hacer pull requests para revisar código.

Spring Boot: Utiliza Bootify.io para generar el esqueleto del proyecto. Configura las dependencias adecuadas para concurrencia, seguridad y notificaciones.

Documentación y Diagramas: Crea un diagrama de arquitectura básica que muestre cómo los sensores, el procesamiento concurrente, la autenticación y las notificaciones están conectados. Puedes usar herramientas como Draw.io para crear el diagrama.
