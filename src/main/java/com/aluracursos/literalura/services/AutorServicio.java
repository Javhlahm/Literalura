package com.aluracursos.literalura.services;

import com.aluracursos.literalura.entities.Autor;
import com.aluracursos.literalura.repositories.iAutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServicio {
    @Autowired
    private iAutorRepositorio autorRepositorio;


    public void mostrarAutores() {
        List<Autor> listaAutores = autorRepositorio.findAll();
        if (!listaAutores.isEmpty()){
            System.out.println("Libros en Base de datos\n"+listaAutores.toString());
        }else {
            System.out.println("No Hay Autores");
        }
    }

    public void mostrarAutoresVivos(int ano) {
        List<Autor> listaAutoresVivos = autorRepositorio.listaAutoresVivos(ano);
        if (!listaAutoresVivos.isEmpty()){
            System.out.println("Autores Vivos en la Fecha\n"+listaAutoresVivos.toString());
        }else {
            System.out.println("No Hay Autores vivos en esa fecha");
        }
    }
}
