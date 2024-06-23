package com.aluracursos.literalura.services;

import com.aluracursos.literalura.entities.Libro;
import com.aluracursos.literalura.repositories.iLibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServicio {
    @Autowired
    private iLibroRepositorio libroRepositorio;
    @Autowired
    private APIServicio apiServicio;



    public void buscarTitulo(String titulo){
        List<Libro> listaLibros = apiServicio.obtenerDatosAPI();
        List<Libro> listaEncontrados = (listaLibros.stream().filter(libro -> libro.getTitulo().toUpperCase().contains(titulo)).map(libro -> new Libro(libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getIdioma())).collect(Collectors.toList()));
        if (!listaEncontrados.isEmpty()){
            try{libroRepositorio.saveAll(listaEncontrados);}
            catch (Exception e) {
                System.out.println("Registro ya Existe");
                return;
            }
            System.out.println("Libros Guardados en Base de datos\n"+listaEncontrados.toString());
        }else {
            System.out.println("Libro no encontrado");
        }
    }


    public void mostrarLibros() {
        List<Libro> listaLibros = libroRepositorio.findAll();
        if (!listaLibros.isEmpty()){
            System.out.println("Libros en Base de datos\n"+listaLibros.toString());
        }else {
            System.out.println("No Hay Libros");
        }
    }

    public void buscarPorIdioma(String idioma) {
        List<Libro> listaLibros = libroRepositorio.findAll();
        List<Libro> listaEncontrados = (listaLibros.stream().filter(libro -> libro.getIdioma().getFirst().toUpperCase().contains(idioma)).map(libro -> new Libro(libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getIdioma())).collect(Collectors.toList()));
        if (!listaEncontrados.isEmpty()){
            System.out.println("Libros en Base de datos con el Idioma\n"+listaLibros.toString());
        }else {
            System.out.println("No Hay Libros con el Idioma");
        }
    }
}
