package com.aluracursos.literalura.repositories;

import com.aluracursos.literalura.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iAutorRepositorio extends JpaRepository<Autor,Long> {
    @Query("SELECT a FROM Autor a WHERE a.fechaFallecimiento >= :ano")
    List<Autor> listaAutoresVivos(int ano);
}
