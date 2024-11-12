package pe.edu.upeu.examen.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.examen.entity.Notas;

public interface NotasDao {
    
    Notas create(Notas notas);
    Notas update(Notas notas);
    void delete(Long id);
    Optional<Notas> read(Long id);
    List<Notas> readAll();
}
