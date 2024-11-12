package pe.edu.upeu.examen.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.examen.entity.Curso;

public interface CursoDao {
    
    Curso create(Curso curso);
    Curso update(Curso curso);
    void delete(Long id);
    Optional<Curso> read(Long id);
    List<Curso> readAll();
}
