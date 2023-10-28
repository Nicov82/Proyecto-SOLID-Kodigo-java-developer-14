package com.proyectoSOLID.logica.herramientasParaGestora;
import static org.mockito.Mockito.*;
import com.proyectoSOLID.logica.clases.entidades.Compra;
import com.proyectoSOLID.logica.clases.entidades.Producto;
import com.proyectoSOLID.logica.clases.herramientasParaGestora.Calculadora;
import com.proyectoSOLID.logica.clases.lugaresCompra.LugarCompra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraTest {

    private Calculadora calculadoraMock; //Usamos un mock de calculadora porque planeo aplicarle el patron Singleton
    private Compra compraTest;
    private LugarCompra lugarCompraTest;

    @BeforeEach
    void setUp() {
        calculadoraMock = mock(Calculadora.class);
        lugarCompraTest = mock(LugarCompra.class);
        compraTest = mock(Compra.class);


        List<Producto> listaProductos = new ArrayList<>();
        Producto producto1 = new Producto("Producto 1", 10.0, compraTest);
        Producto producto2 = new Producto("Producto 2", 20.0, compraTest);
        listaProductos.add(producto1);
        listaProductos.add(producto2);

        // Configurar el mock para que devuelva la lista de productos cuando se llame a getListaProductos
        when(compraTest.getListaProductos()).thenReturn(listaProductos);

        // Usar el mock de Compra en lugar de crear una nueva instancia
        when(compraTest.getLugarCompra()).thenReturn(lugarCompraTest);

        this.compraTest = compraTest;
    }


    @Test
    void testCalcularCostoCompra() { //Dado que ya fue probado con éxito el método CalcularCostoCompra en las subclases
        // de LugarCompra, acá sólo verificamos que ante una instancia de lugar Compra, la Calculadora llame a CalcularCostoCompra correctamente.
        doCallRealMethod().when(calculadoraMock).calcularCostoCompra(compraTest);
        doCallRealMethod().when(lugarCompraTest).calcularCostoCompra(compraTest);
        calculadoraMock.calcularCostoCompra(compraTest);
        verify(lugarCompraTest).calcularCostoCompra(compraTest);
    }


}
