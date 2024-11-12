package pe.edu.upeu.examen.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upeu.examen.entity.Alumno;

public interface AlumnoService {
    
    Alumno create(Alumno alumno);
    Alumno update(Alumno alumno);
    void delete(Long id);
    Optional<Alumno> read(Long id);
    List<Alumno> readAll();
}
