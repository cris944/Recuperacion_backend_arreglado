package pe.edu.upeu.examen.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.examen.dao.AlumnoDao;
import pe.edu.upeu.examen.entity.Alumno;
import pe.edu.upeu.examen.repository.AlumnoRepository;

@Component
public class AlumnoDaoImpl implements AlumnoDao {
    
    @Autowired
    private AlumnoRepository repository;
    
    @Override
    public Alumno create(Alumno alumno) {
        return repository.save(alumno);
    }

    @Override
    public Alumno update(Alumno alumno) {
        return repository.save(alumno);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Alumno> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Alumno> readAll() {
        return repository.findAll();
    }
}