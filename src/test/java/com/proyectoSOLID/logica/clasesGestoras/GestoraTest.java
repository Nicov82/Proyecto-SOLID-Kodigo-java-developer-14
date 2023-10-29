package com.proyectoSOLID.logica.clasesGestoras;

import com.proyectoSOLID.logica.clases.clasesGestoras.Gestora;
import com.proyectoSOLID.logica.clases.clasesGestoras.GestoraCompras;
import com.proyectoSOLID.logica.clases.clasesGestoras.GestoraVisualizacion;
import com.proyectoSOLID.logica.clases.entidades.Compra;
import com.proyectoSOLID.logica.clases.entidades.RegistroDeCompras;
import com.proyectoSOLID.logica.clases.lugaresCompra.LugarCompra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GestoraTest { //En esta clase testeamos que cada método llame a su vez a los métodos de las gestoras de compras y visualizacion

    private Gestora gestoraMock;
    private GestoraCompras gestoraComprasMock;
    private GestoraVisualizacion gestoraVisualizacionMock;
    private RegistroDeCompras registroDeComprasTest;
    private LugarCompra lugarCompraTest;
    private Compra compraTest;



    @BeforeEach
    void setUp(){
        gestoraMock = mock(Gestora.class);
        gestoraComprasMock = mock(GestoraCompras.class);
        gestoraVisualizacionMock = mock(GestoraVisualizacion.class);
        registroDeComprasTest = mock(RegistroDeCompras.class);
        lugarCompraTest = new LugarCompra() {
        };
        compraTest = new Compra(lugarCompraTest);
        when(gestoraMock.getRegistroDeCompras()).thenReturn(registroDeComprasTest);
        when(gestoraMock.getGestoraVisualizacion()).thenReturn(gestoraVisualizacionMock);
        when(gestoraMock.getGestoraCompras()).thenReturn(gestoraComprasMock);
    }

    @Test
    void testIniciarCompra(){
        doCallRealMethod().when(gestoraMock).iniciarCompra(lugarCompraTest);
        gestoraMock.iniciarCompra(lugarCompraTest);
        verify(gestoraMock.getGestoraCompras()).iniciarCompra(registroDeComprasTest.getListaCompras(), lugarCompraTest);
    }

    @Test
    void testAgregarProducto(){
        String nombre = "Producto1";
        double precio = 1.0;
        doCallRealMethod().when(gestoraMock).agregarProducto(nombre, precio, compraTest);
        gestoraMock.agregarProducto(nombre, precio, compraTest);
        verify(gestoraMock.getGestoraCompras()).agregarProducto(nombre, precio, compraTest);
    }

    @Test
    void testCalcularCostoCompra(){
        doCallRealMethod().when(gestoraMock).calcularCostoCompra(compraTest);
        gestoraMock.calcularCostoCompra(compraTest);
        verify(gestoraMock.getGestoraCompras()).calcularCostoCompra(compraTest);
    }

    @Test
    void testVerInfoCompra(){
        doCallRealMethod().when(gestoraMock).verInfoCompra(compraTest);
        gestoraMock.verInfoCompra(compraTest);
        verify(gestoraMock.getGestoraVisualizacion()).verInfoCompra(compraTest);

    }

    @Test
    void testVerInfoListaCompras(){
        doCallRealMethod().when(gestoraMock).verInfoListaCompras();
        gestoraMock.verInfoListaCompras();
        verify(gestoraMock.getGestoraVisualizacion()).verInfoListaCompras(gestoraMock.getRegistroDeCompras().getListaCompras());

    }
    @Test
    void testCalcularCostoTotalCompras(){
        doCallRealMethod().when(gestoraMock).calcularPrecioTotalCompras();
        gestoraMock.calcularPrecioTotalCompras();
        verify(gestoraMock.getGestoraCompras()).calcularPrecioTotalCompras(gestoraMock.getRegistroDeCompras().getListaCompras());

    }
}

