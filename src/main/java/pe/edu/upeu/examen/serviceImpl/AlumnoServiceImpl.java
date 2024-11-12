package pe.edu.upeu.examen.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.examen.dao.AlumnoDao;
import pe.edu.upeu.examen.entity.Alumno;
import pe.edu.upeu.examen.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoDao dao;

    @Override
    public Alumno create(Alumno alumno) {
        return dao.create(alumno);
    }

    @Override
    public Alumno update(Alumno alumno) {
        return dao.update(alumno);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public Optional<Alumno> read(Long id) {
        return dao.read(id);
    }

    @Override
    public List<Alumno> readAll() {
        return dao.readAll();
    }
}

