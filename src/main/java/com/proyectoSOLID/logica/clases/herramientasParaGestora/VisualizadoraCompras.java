package com.proyectoSOLID.logica.clases.herramientasParaGestora;

import com.proyectoSOLID.logica.clases.entidades.Compra;
import com.proyectoSOLID.logica.clases.entidades.Producto;
import com.proyectoSOLID.logica.interfaces.gestion.DisplayInfoCompra;
import com.proyectoSOLID.logica.interfaces.gestion.DisplayInfoListaCompras;

import java.util.List;

//Clase que se ocupa de implementaciones relativas a la visualización de datos.
public class VisualizadoraCompras implements DisplayInfoCompra, DisplayInfoListaCompras {

    private static VisualizadoraCompras instancia;

    private VisualizadoraCompras(){
    }
    public static VisualizadoraCompras getInstance(){
        if (instancia == null) {
            instancia = new VisualizadoraCompras();
        }
        return instancia;
    }
    @Override
    public void verInfoCompra(Compra compra) {
        System.out.println(compra);
        for (Producto producto : compra.getListaProductos()){
            System.out.println(producto);
        }
    }


    @Override
    public void verInfoListaCompras(List listaCompras) {
        for(Object compra :listaCompras){
                verInfoCompra((Compra) compra);
                System.out.println(" ");
        }

    }

}
