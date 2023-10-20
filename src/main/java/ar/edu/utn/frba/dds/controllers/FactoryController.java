package ar.edu.utn.frba.dds.controllers;

public class FactoryController {

    public static Object controller(String nombre) {
        Object controller = null;
        switch (nombre) {
            case "login": controller = new IndexController(); break;
            case "incidente": controller = new IncidenteController(); break;
            case "usuario" : controller = new UsuarioController(); break;
            case "archivo" : controller = new ArchivoController() ; break;
        }
        return controller;
    }
}
