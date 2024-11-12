package pe.edu.upeu.examen.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.examen.dao.NotasDao;
import pe.edu.upeu.examen.entity.Notas;
import pe.edu.upeu.examen.service.NotasService;

@Service
public class NotasServiceImpl implements NotasService {

    @Autowired
    private NotasDao dao;

    @Override
    public Notas create(Notas notas) {
        notas.setPromedio(calcularPromedio(notas));
        System.out.println("Promedio calculado: " + notas.getPromedio());
        return dao.create(notas);
    }

    @Override
    public Notas update(Notas notas) {
        notas.setPromedio(calcularPromedio(notas));
        return dao.update(notas);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public Optional<Notas> read(Long id) {
        return dao.read(id);
    }

    @Override
    public List<Notas> readAll() {
        return dao.readAll();
    }

    private double calcularPromedio(Notas notas) {
        return (notas.getNota1() + notas.getNota2() + notas.getNota3()) / 3.0;
    }
}
