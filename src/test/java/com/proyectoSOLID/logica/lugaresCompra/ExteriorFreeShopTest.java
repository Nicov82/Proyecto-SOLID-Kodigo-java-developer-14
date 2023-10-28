package com.proyectoSOLID.logica.lugaresCompra;
import com.proyectoSOLID.logica.clases.entidades.*;
import com.proyectoSOLID.logica.clases.lugaresCompra.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ExteriorFreeShopTest {

    private final ExteriorFreeShop ExtFreeShopTest = new ExteriorFreeShop("Exterior Test");

    private Producto producto1;


    @BeforeEach
    void setUp() {
        Compra compra = new Compra(ExtFreeShopTest);
        producto1 = new Producto("Producto1", 1.0, compra);
    }

    @Test
    void CalcularCostoProductoTest() {
        double resultado = ExtFreeShopTest.calcularCostoProducto(producto1);

        // Verificación
        assertEquals(475.15, resultado); // El precio del producto no cambia en este lugar de compra
        assertEquals(475.15, producto1.getPrecioEnPesos()); // El precio en pesos del producto
    }

    @Test
    void CalcularCostoProductoConPreciosAltosTest() {

        producto1.setPrecio(1_000_000.0); // Precio muy alto

        double resultado = ExtFreeShopTest.calcularCostoProducto(producto1);

        assertEquals(475_150_000.0, resultado, 0.001); // Verificar con tolerancia de 0.001 para posibles errores de redondeo
        assertEquals(475_150_000.0, producto1.getPrecioEnPesos(), 0.001); // Verificar con tolerancia de 0.001
    }
    @Test
    void CalcularCostoProductoConPreciosBajosTest() {
        producto1.setPrecio(0.01); // Precio muy bajo

        double resultado = ExtFreeShopTest.calcularCostoProducto(producto1);

        assertEquals(4.7515, resultado, 0.001); // Verificar con tolerancia de 0.001 para posibles errores de redondeo
        assertEquals(4.7515, producto1.getPrecioEnPesos(), 0.001); // Verificar con tolerancia de 0.001
    }

    @Test
    void CalcularConversionMonedaTest() {
        double monto = 1.0;
        double resultado = ExtFreeShopTest.calcularConversionMoneda(monto);
        assertEquals(365.5, resultado);
    }

    @Test
    void CalcularConversionMonedaTestConMontoPequeno() {
        double montoPequeno = 0.01;
        double resultadoPequeno = ExtFreeShopTest.calcularConversionMoneda(montoPequeno);
        assertEquals(3.655, resultadoPequeno, 0.001); // Tolerancia de 0.001 para redondeos
    }

    @Test
    void CalcularConversionMonedaTestConMontoGrande() {
        double montoGrande = 1000000;
        double resultadoGrande = ExtFreeShopTest.calcularConversionMoneda(montoGrande);
        assertEquals(365500000, resultadoGrande);
    }

    @Test
    void calcularImpuestoPaisTest(){
        double monto =1.0;
        double resultado =ExtFreeShopTest.calcularImpuestoPais(monto);
        assertEquals(0.3, resultado);
    }

    @Test
    void calcularImpuestoPaisTestMontoPequeno() {
        double montoPequeno = 0.01;
        double resultadoPequeno = ExtFreeShopTest.calcularImpuestoPais(montoPequeno);
        assertEquals(0.003, resultadoPequeno, 0.001); // Prueba con tolerancia de 0.001 para posibles errores de redondeo
    }

    @Test
    void calcularImpuestoPaisTestMontoGrande() {
        double montoGrande = 1000000;
        double resultadoGrande = ExtFreeShopTest.calcularImpuestoPais(montoGrande);
        assertEquals(300000.0, resultadoGrande);
    }

}
