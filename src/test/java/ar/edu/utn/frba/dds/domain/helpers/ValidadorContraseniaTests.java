package ar.edu.utn.frba.dds.domain.helpers;

import ar.edu.utn.frba.dds.models.helpers.ValidadorContrasenia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidadorContraseniaTests {
  @Test
  @DisplayName("qwerty es una de las peores claves")
  public void esUnaDeLasPeoresClaves() throws Exception {

    Assertions.assertTrue(ValidadorContrasenia.esUnaDeLasPeoresClaves("qwerty"));
  }

  @Test
  @DisplayName("DDs2023 no es una de las peores claves")
  public void noEsDeLasPeoresClaves() throws Exception {

    Assertions.assertFalse(ValidadorContrasenia.esUnaDeLasPeoresClaves("DDs2023"));
  }

  @Test
  @DisplayName("Password1 no cumple con guia NIST")
  public void unaClaveNoesValidaNist() throws Exception {

    Assertions.assertFalse(ValidadorContrasenia.esValidaNist("Password1"));
  }

  @Test
  @DisplayName("Password1* cumple con guia NIST")
  public void unaClaveEsValidaNist() throws Exception {

    Assertions.assertTrue(ValidadorContrasenia.esValidaNist("Password1*"));
  }

  @Test
  @DisplayName("dario123+ es trivial para usuario dariodesalvo")
  public void unaClaveEsTrivial() throws Exception {

    Assertions.assertTrue(ValidadorContrasenia.esTrivial("dario", "dario123+"));
  }

  @Test
  @DisplayName("PasSSSword1* es una contraseña valida")
  public void unaClaveEsValida() throws Exception {

    Assertions.assertTrue(ValidadorContrasenia.laContraseniaEsValida("PasSSSword1*"));
  }

  @Test
  @DisplayName("pasSSword no es una contraseña valida")
  public void unaClaveEsInvalida() throws Exception {

    Assertions.assertFalse(ValidadorContrasenia.laContraseniaEsValida("pasSSword"));
  }


}

