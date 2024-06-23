package com.aluracursos.literalura.repositories;

import com.aluracursos.literalura.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iLibroRepositorio extends JpaRepository<Libro,Long> {

}
