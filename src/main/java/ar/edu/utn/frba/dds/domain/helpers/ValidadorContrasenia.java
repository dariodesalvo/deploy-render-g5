package ar.edu.utn.frba.dds.domain.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorContrasenia implements ValidadorContrasenias {
  private final String urlPeoresClaves = "https://raw.githubusercontent.com/danielmiessler/SecLists/master/Passwords/Common-Credentials/10-million-password-list-top-10000.txt";

  public void validarPassword(String contrasenia) throws MalformedURLException {

  }

  public boolean laContraseniaEsValida(String contrasenia) throws Exception {
    try {
      return !this.esUnaDeLasPeoresClaves(contrasenia) && this.esValidaNist(contrasenia);

    } catch (Exception e) {
      throw new Exception("No se ha podido validar la contraseña");
    }
  }

  public boolean esUnaDeLasPeoresClaves(String contrasenia) throws Exception {
    try {
      String clave;
      BufferedReader peoresClaves = leerUrl(this.urlPeoresClaves);

      while ((clave = peoresClaves.readLine()) != null) {
        if (clave.equals(contrasenia)) {
          peoresClaves.close();
          return true;
        }
      }
      peoresClaves.close();
      return false;
    } catch (Exception e) {
      throw new Exception("No se ha podido validar las peores claves");
    }
  }

  public BufferedReader leerUrl(String url) throws MalformedURLException {
    try {
      URL peoresClaves = new URL(url);
      InputStreamReader streamReaderPeoresClaves = new InputStreamReader(peoresClaves.openStream());
      BufferedReader bufferReader = new BufferedReader(streamReaderPeoresClaves);
      return bufferReader;
    } catch (MalformedURLException e) {
      throw new MalformedURLException("No se ha podido encontrar la URL");
    } catch (IOException e) {
      throw new RuntimeException("No se ha podido leer el archivo con las 10000 peores claves");
    }
  }

  public boolean esValidaNist(String contrasenia) {

    String regex = "^(?=.*[0-9])" //Al menos un dígito
            + "(?=.*[a-z])(?=.*[A-Z])" // Mayúsculas y minúsculas
            + "(?=.*[*@#$%^&+=])" // Un carácter especial
            + "(?=\\S+$).{8,20}$"; // Sin espacios vacíos, entre 8 y 20 caracteres.

    Pattern pattern = Pattern.compile(regex);

    Matcher matcher = pattern.matcher(contrasenia);

    return matcher.matches();

  }
}
