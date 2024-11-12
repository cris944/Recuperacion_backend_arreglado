package pe.edu.upeu.examen.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.examen.dao.NotasDao;
import pe.edu.upeu.examen.entity.Notas;
import pe.edu.upeu.examen.repository.NotasRepository;

@Component
public class NotasDaoImpl implements NotasDao {
    
    @Autowired
    private NotasRepository repository;
    
    @Override
    public Notas create(Notas notas) {
        return repository.save(notas);
    }

    @Override
    public Notas update(Notas notas) {
        return repository.save(notas);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Notas> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Notas> readAll() {
        return repository.findAll();
    }
}
