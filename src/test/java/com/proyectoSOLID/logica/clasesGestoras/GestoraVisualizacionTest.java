package com.proyectoSOLID.logica.clasesGestoras;

import static org.mockito.Mockito.*;

import com.proyectoSOLID.logica.clases.clasesGestoras.GestoraVisualizacion;
import com.proyectoSOLID.logica.clases.entidades.Compra;
import com.proyectoSOLID.logica.clases.entidades.Producto;
import com.proyectoSOLID.logica.clases.herramientasParaGestora.VisualizadoraCompras;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GestoraVisualizacionTest {

    private GestoraVisualizacion gestoraVisualizacionMock;
    private VisualizadoraCompras visualizadoraMock;

    @BeforeEach
    void setUp() {
        visualizadoraMock = mock(VisualizadoraCompras.class);
        gestoraVisualizacionMock = mock(GestoraVisualizacion.class);
        when(gestoraVisualizacionMock.getVisualizadora()).thenReturn(visualizadoraMock);
    }

    @Test
    void testVerInfoCompra() {
        // Crea un mock de Compra
        Compra compraMock = mock(Compra.class);
        List<Producto> listaProductos = new ArrayList<>();
        Producto productoMock = mock(Producto.class);
        listaProductos.add(productoMock);
        when(compraMock.getListaProductos()).thenReturn(listaProductos);
        // Configura el mock de GestoraVisualizacion para que llame al método real
        doCallRealMethod().when(gestoraVisualizacionMock).verInfoCompra(compraMock);

        // Llama al método que quieres probar
        gestoraVisualizacionMock.verInfoCompra(compraMock);

        // Verifica que se haya llamado correctamente a verInfoCompra en visualizadoraMock
        verify(visualizadoraMock).verInfoCompra(compraMock);
    }

    @Test
    void testVerInfoListaCompras() {
        // Crea una lista de compras ficticia
        List<Compra> listaCompras = new ArrayList<>();
        Compra compraMock = mock(Compra.class);
        listaCompras.add(compraMock);

        // Configura el mock de GestoraVisualizacion para que llame al método real
        doCallRealMethod().when(gestoraVisualizacionMock).verInfoListaCompras(listaCompras);

        // Llama al método que quieres probar
        gestoraVisualizacionMock.verInfoListaCompras(listaCompras);

        // Verifica que se haya llamado correctamente a verInfoListaCompras en visualizadoraMock
        verify(visualizadoraMock).verInfoListaCompras(listaCompras);
    }
}
