package pe.edu.upeu.examen.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.examen.entity.Notas;

public interface NotasService {
	
    Notas create(Notas a);
    Notas update(Notas a);
    void delete(Long id);
    Optional<Notas> read(Long id);
    List<Notas> readAll();
}
