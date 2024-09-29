package io.dreamteam.practica1_concurrente.domain;

import java.util.List;

public interface SensorService<T> {
    List<T> getAll();
    T create(T sensor);
    void delete(Long id);
}