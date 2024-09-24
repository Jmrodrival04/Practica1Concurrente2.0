package io.dreamteam.practica1_concurrente.domain;

public class SensorEvento {
    private String descripcion;
    private boolean critico;

    // Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCritico() {
        return critico;
    }

    public void setCritico(boolean critico) {
        this.critico = critico;
    }
}
