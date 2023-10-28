package com.proyectoSOLID.logica.herramientasParaGestora;

import static org.mockito.Mockito.*;
import com.proyectoSOLID.logica.clases.entidades.Compra;
import com.proyectoSOLID.logica.clases.entidades.Producto;
import com.proyectoSOLID.logica.clases.herramientasParaGestora.VisualizadoraCompras;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class VisualizadoraComprasTest {

    @Test
    void testVerInfoCompra() {
        // Crea un mock de Compra
        Compra compraMock = mock(Compra.class);

        // Crea un mock de VisualizadoraCompras
        VisualizadoraCompras visualizadoraMock = mock(VisualizadoraCompras.class);

        // Crea una lista de productos ficticia
        List<Producto> listaProductos = new ArrayList<>();
        Producto productoMock = mock(Producto.class);
        listaProductos.add(productoMock);

        // Configura el mock de Compra para que devuelva la lista de productos
        when(compraMock.getListaProductos()).thenReturn(listaProductos);

        // Configura el mock de VisualizadoraCompras para que sea el objeto bajo prueba
        doCallRealMethod().when(visualizadoraMock).verInfoCompra(any(Compra.class));

        // Llama al método que quieres probar
        visualizadoraMock.verInfoCompra(compraMock);

        // Verifica que se haya llamado correctamente a getListaProductos en la compraMock
        verify(compraMock).getListaProductos();
    }
    @Test
    void testVerInfoListaCompras() {
        // Crea un mock de Compra y una lista de compras ficticia
        Compra compraMock = mock(Compra.class);
        List<Compra> listaCompras = new ArrayList<>();
        listaCompras.add(compraMock);

        // Crea un mock de VisualizadoraCompras
        VisualizadoraCompras visualizadoraMock = mock(VisualizadoraCompras.class);

        // Configura el mock de VisualizadoraCompras para que sea el objeto bajo prueba
        doCallRealMethod().when(visualizadoraMock).verInfoListaCompras(anyList());

        // Llama al método que quieres probar
        visualizadoraMock.verInfoListaCompras(listaCompras);

        // Verifica que se haya llamado correctamente a verInfoCompra con la compraMock
        verify(visualizadoraMock).verInfoCompra(any(Compra.class)); // Utiliza any() para cualquier Compra
    }
}
