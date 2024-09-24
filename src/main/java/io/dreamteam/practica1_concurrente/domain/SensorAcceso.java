package io.dreamteam.practica1_concurrente.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "SensorAccesoes")
@Getter
@Setter
public class SensorAcceso extends Sensor {
}
