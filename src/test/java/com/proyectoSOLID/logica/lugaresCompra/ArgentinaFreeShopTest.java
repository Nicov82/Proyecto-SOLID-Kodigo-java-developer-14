package com.proyectoSOLID.logica.lugaresCompra;
import com.proyectoSOLID.logica.clases.entidades.*;
import com.proyectoSOLID.logica.clases.lugaresCompra.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ArgentinaFreeShopTest {

    private final ArgentinaFreeShop ArgFreeShopTest = new ArgentinaFreeShop();

    private Producto producto1;


    @BeforeEach
    void setUp() {
        Compra compra = new Compra(ArgFreeShopTest);
        producto1 = new Producto("Producto1", 1.0, compra);

        compra.getListaProductos().add(producto1);
    }


    @Test
    void CalcularCostoProductoTest() {
        double resultado = ArgFreeShopTest.calcularCostoProducto(producto1);

        // Verificación
        assertEquals(365.5, resultado); // El precio del producto no cambia en este lugar de compra
        assertEquals(365.5, producto1.getPrecioEnPesos()); // El precio en pesos del producto
    }

    @Test
    void CalcularCostoProductoConPreciosAltosTest() {

        producto1.setPrecio(1_000_000.0); // Precio muy alto

        double resultado = ArgFreeShopTest.calcularCostoProducto(producto1);

        assertEquals(365_500_000.0, resultado, 0.001); // Verificar con tolerancia de 0.001 para posibles errores de redondeo
        assertEquals(365_500_000.0, producto1.getPrecioEnPesos(), 0.001); // Verificar con tolerancia de 0.001
    }

    @Test
    void CalcularCostoProductoConPreciosBajosTest() {
        producto1.setPrecio(0.01); // Precio muy bajo

        double resultado = ArgFreeShopTest.calcularCostoProducto(producto1);

        assertEquals(3.655, resultado, 0.001); // Verificar con tolerancia de 0.001 para posibles errores de redondeo
        assertEquals(3.655, producto1.getPrecioEnPesos(), 0.001); // Verificar con tolerancia de 0.001
    }



    @Test
    void CalcularConversionMonedaTest() {
        double monto = 1.0;
        double resultado = ArgFreeShopTest.calcularConversionMoneda(monto);
        assertEquals(365.5, resultado);
    }

    @Test
    void CalcularConversionMonedaTestConMontoPequeno() {
        double montoPequeno = 0.01;
        double resultadoPequeno = ArgFreeShopTest.calcularConversionMoneda(montoPequeno);
        assertEquals(3.655, resultadoPequeno, 0.001); // Tolerancia de 0.001 para redondeos
    }

    @Test
    void CalcularConversionMonedaTestConMontoGrande() {
        double montoGrande = 1000000;
        double resultadoGrande = ArgFreeShopTest.calcularConversionMoneda(montoGrande);
        assertEquals(365500000, resultadoGrande);
    }




}
