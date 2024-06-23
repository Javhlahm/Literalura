package com.aluracursos.literalura.services;

import com.aluracursos.literalura.entities.Libro;
import com.aluracursos.literalura.repositories.iAutorRepositorio;
import com.aluracursos.literalura.repositories.iLibroRepositorio;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


@Service
public class APIServicio {

    @Autowired
     iLibroRepositorio libroRepositorio;

    private  Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();




    public List<Libro> obtenerDatosAPI(){
        List<Libro> listaLibros = new ArrayList<>();
        try {
            HttpClient client = HttpClient.newHttpClient();
           HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://gutendex.com/books/")).GET().build();
           HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = (JsonObject) JsonParser.parseString(response.body());
            JsonArray resultsJson = jsonObject.getAsJsonArray("results");

            for (JsonElement j : resultsJson){
               listaLibros.add(gson.fromJson(j, Libro.class));
            }
            return listaLibros;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
