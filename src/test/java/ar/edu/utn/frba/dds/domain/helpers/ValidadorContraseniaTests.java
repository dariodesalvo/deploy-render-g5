package ar.edu.utn.frba.dds.domain.helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidadorContraseniaTests {
    private ValidadorContrasenia validadorContraseña;
    @BeforeEach
    public void inicializar(){
        validadorContraseña = new ValidadorContrasenia();
    }

    @Test
    @DisplayName("qwerty es una de las peores claves")
    public void unaClaveseEncuentraDentroDeLaListaDePeoresClaves() throws Exception {

        Assertions.assertTrue(validadorContraseña.esUnaDeLasPeoresClaves("qwerty"));
    }
    @Test
    @DisplayName("DDs2023 no es una de las peores claves")
    public void unaClaveseNoEncuentraDentroDeLaListaDePeoresClaves() throws Exception {

        Assertions.assertFalse(validadorContraseña.esUnaDeLasPeoresClaves("DDs2023"));
    }

}

