package ar.edu.utn.frba.dds.domain.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidadorContrasenia implements ValidadorContrasenias {
    private String URLPeoresClaves = "https://raw.githubusercontent.com/danielmiessler/SecLists/master/Passwords/Common-Credentials/10-million-password-list-top-10000.txt";

    public void validarPassword(String contrasenia) throws MalformedURLException {
    }

    public boolean esUnaDeLasPeoresClaves(String contrasenia) throws Exception {
        try {
            String clave;
            URL peoresClaves = new URL(URLPeoresClaves);
            BufferedReader bufferReaderclaves = new BufferedReader(new InputStreamReader(peoresClaves.openStream()));
            while ((clave = bufferReaderclaves.readLine()) != null) {
                if (clave.equals(contrasenia)) {
                    bufferReaderclaves.close();
                    return true;
                }
            }
            bufferReaderclaves.close();
            return false;
        } catch (MalformedURLException e ) {
            throw new MalformedURLException("La URL no ha sido encontrada");
        } catch (IOException e) {
            throw new IOException("No se ha podido leer el archivo con las 10000 peores claves");
        }
    }

    public boolean esValidaNist(String contrasenia){

        String regex =  "^(?=.*[0-9])" //Al menos un dígito
                        + "(?=.*[a-z])(?=.*[A-Z])" // Mayúsculas y minúsculas
                        + "(?=.*[*@#$%^&+=])" // Un carácter especial
                        + "(?=\\S+$).{8,20}$"; // Sin espacios vacíos, entre 8 y 20 caracteres.

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(contrasenia);

        return matcher.matches();

    }
}
