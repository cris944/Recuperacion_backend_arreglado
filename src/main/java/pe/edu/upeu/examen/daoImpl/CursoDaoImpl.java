package pe.edu.upeu.examen.daoImpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.examen.dao.CursoDao;
import pe.edu.upeu.examen.entity.Curso;
import pe.edu.upeu.examen.repository.CursoRepository;

@Component
public class CursoDaoImpl implements CursoDao {
    
    @Autowired
    private CursoRepository repository;
    
    @Override
    public Curso create(Curso curso) {
        return repository.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
        return repository.save(curso);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Curso> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Curso> readAll() {
        return repository.findAll();
    }
}
