package pe.edu.upeu.examen.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.examen.dao.CursoDao;
import pe.edu.upeu.examen.entity.Curso;
import pe.edu.upeu.examen.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoDao dao;

    @Override
    public Curso create(Curso curso) {
        return dao.create(curso);
    }

    @Override
    public Curso update(Curso curso) {
        return dao.update(curso);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public Optional<Curso> read(Long id) {
        return dao.read(id);
    }

    @Override
    public List<Curso> readAll() {
        return dao.readAll();
    }
}

