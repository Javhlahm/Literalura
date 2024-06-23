package com.aluracursos.literalura.controllers;

import com.aluracursos.literalura.services.AutorServicio;
import com.aluracursos.literalura.services.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class LibroControlador implements CommandLineRunner {

    @Autowired
    LibroServicio libroServicio;
    @Autowired
    AutorServicio autorServicio;

    Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        int opc;

        do {
            System.out.println("""
                    Menú
                    1.-> Buscar Libro por Título
                    2.-> Mostrar Libros Registrados
                    3.-> Mostrar Autores Registrados
                    4.-> Mostrar Autores Vivos en un Determinado Año
                    5.-> Mostrar Libros por Idioma
                    0.-> Salir
                    """);
             opc = Integer.parseInt(scanner.nextLine());

             switch (opc){
                 case 1:
                     buscarLibro();
                     break;
                 case 2:
                     mostrarLibros();
                     break;
                 case 3:
                     mostrarAutores();
                     break;
                 case 4:
                     mostrarAutoresVivos();
                     break;
                 case 5:
                     mostrarLibrosPorIdioma();
                     break;
             }

        }while (opc!=0);

    }


    public void buscarLibro(){
        System.out.println("Escriba el titulo a buscar");
        String titulo = scanner.nextLine();
        libroServicio.buscarTitulo(titulo.toUpperCase());
    }

    private void mostrarLibros() {
        libroServicio.mostrarLibros();
    }

    private void mostrarAutores() {
        autorServicio.mostrarAutores();
    }

    private void mostrarAutoresVivos() {
        System.out.println("Escriba el año a buscar");
        int ano = Integer.parseInt(scanner.nextLine());
        autorServicio.mostrarAutoresVivos(ano);
    }

    private void mostrarLibrosPorIdioma() {
        System.out.println("Escriba el idioma a buscar");
        String idioma = scanner.nextLine();
        libroServicio.buscarPorIdioma(idioma.toUpperCase());
    }
}
