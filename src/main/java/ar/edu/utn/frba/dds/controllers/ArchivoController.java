package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.archivoCSV.AdapterCSVFileReader;
import ar.edu.utn.frba.dds.models.archivoCSV.LectorCSV;
import ar.edu.utn.frba.dds.models.helpers.CargadorDeEntidades;
import ar.edu.utn.frba.dds.server.utils.ICrudViewsHandler;
import io.javalin.http.Context;
import io.javalin.http.UploadedFile;

import java.io.IOException;
import java.util.List;


public class ArchivoController extends Controller implements ICrudViewsHandler {

    @Override
    public void index(Context context) {
        context.render("carga_masiva/carga-masiva.hbs");
    }

    @Override
    public void show(Context context) {

    }

    @Override
    public void create(Context context) {

    }

    @Override
    public void save(Context context) {

    }

    @Override
    public void edit(Context context) {

    }

    @Override
    public void update(Context context) {

    }

    @Override
    public void delete(Context context) {

    }

    public void upload(Context context) {

        UploadedFile archivoCsv = context.uploadedFiles("files").get(0);
        AdapterCSVFileReader adaptadorCSV = new LectorCSV();

            try {
                List<String> lecturaCSV =  adaptadorCSV.leerArchivoCSV(archivoCsv);

                CargadorDeEntidades.cargarEntidades(lecturaCSV);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }



        context.html("Upload successful");

    }
}

