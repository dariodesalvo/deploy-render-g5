package ar.edu.utn.frba.dds.controllers;

import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeEntidades;
import ar.edu.utn.frba.dds.models.repositorios.RepositorioDeEstablecimientos;

public class FactoryController {

    public static Object controller(String nombre) {
        Object controller = null;
        switch (nombre) {
            case "Login": controller = new IndexController(); break;
            case "Incidentes": controller = new IncidenteController(); break;
            case "Usuarios" : controller = new UsuarioController(); break;
            case "Archivos" : controller = new ArchivoController() ; break;
            case "Entidades" : controller = new EntidadesController(new RepositorioDeEntidades()) ; break;
            case "Establecimientos" : controller = new EstablecimientosController(new RepositorioDeEstablecimientos(), new RepositorioDeEntidades()) ; break;

        }
        return controller;
    }
}
