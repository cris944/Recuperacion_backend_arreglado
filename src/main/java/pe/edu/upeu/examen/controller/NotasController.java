package pe.edu.upeu.examen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.examen.entity.Notas;
import pe.edu.upeu.examen.service.NotasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/notas")
@CrossOrigin
public class NotasController {
	
    @Autowired
    private NotasService notasService;

    @GetMapping
    public ResponseEntity<List<Notas>> readAll() {
        try {
            List<Notas> notas = notasService.readAll();
            if (notas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(notas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Notas> create(@Valid @RequestBody Notas notas) {
        try {
            Notas newNotas = notasService.create(notas);
            return new ResponseEntity<>(newNotas, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notas> getNotasById(@PathVariable("id") Long id) {
        try {
            Optional<Notas> notas = notasService.read(id);
            return notas.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotas(@PathVariable("id") Long id) {
        try {
            notasService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notas> updateNotas(@PathVariable("id") Long id, @Valid @RequestBody Notas notas) {
        Optional<Notas> existingNotas = notasService.read(id);

        if (existingNotas.isPresent()) {
            Notas updatedNotas = existingNotas.get();
            updatedNotas.setNota1(notas.getNota1());
            updatedNotas.setNota2(notas.getNota2());
            updatedNotas.setNota3(notas.getNota3());
            updatedNotas.setAlumno(notas.getAlumno());
            updatedNotas.setCurso(notas.getCurso());
            notasService.update(updatedNotas);
            return new ResponseEntity<>(updatedNotas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
