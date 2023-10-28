package com.proyectoSOLID.logica.lugaresCompra;

import com.proyectoSOLID.logica.clases.lugaresCompra.Brasil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrasilTest {

    private final Brasil brasilTest = new Brasil();



    @Test
    void CalcularConversionMonedaTest() {
        double monto = 1.0;
        double resultado = brasilTest.calcularConversionMoneda(monto);
        assertEquals(68.99, resultado);
    }

    @Test
    void CalcularConversionMonedaTestConMontoPequeno() {
        double montoPequeno = 0.01;
        double resultadoPequeno = brasilTest.calcularConversionMoneda(montoPequeno);
        assertEquals(0.6899, resultadoPequeno, 0.001); // Tolerancia de 0.001 para redondeos
    }

    @Test
    void CalcularConversionMonedaTestConMontoGrande() {
        double montoGrande = 1_000_000;
        double resultadoGrande = brasilTest.calcularConversionMoneda(montoGrande);
        assertEquals(68_990_000, resultadoGrande);
    }
}
