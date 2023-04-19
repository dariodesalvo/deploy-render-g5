package ar.edu.utn.frba.dds.domain.helpers;

import java.net.MalformedURLException;
import java.net.URL;

public class ValidadorContrasenia implements ValidadorContrasenias {
    private String URLPeoresClaves = "https://raw.githubusercontent.com/danielmiessler/SecLists/master/Passwords/Common-Credentials/10-million-password-list-top-10000.txt";
    public void validarPassword(String contrasenia) throws MalformedURLException {

        try {
            URL oracle = new URL(URLPeoresClaves);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
