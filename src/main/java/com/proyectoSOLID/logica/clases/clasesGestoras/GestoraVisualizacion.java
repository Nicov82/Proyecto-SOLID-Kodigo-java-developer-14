package com.proyectoSOLID.logica.clases.clasesGestoras;

import com.proyectoSOLID.logica.clases.entidades.Compra;
import com.proyectoSOLID.logica.clases.herramientasParaGestora.Calculadora;
import com.proyectoSOLID.logica.clases.herramientasParaGestora.VisualizadoraCompras;
import com.proyectoSOLID.logica.interfaces.gestion.DisplayInfoCompra;
import com.proyectoSOLID.logica.interfaces.gestion.DisplayInfoListaCompras;

import java.util.List;

//Clase que centraliza los métodos de gestión de visualización de datos de la aplicación.

public class GestoraVisualizacion implements DisplayInfoCompra, DisplayInfoListaCompras {
    private static GestoraVisualizacion instancia;

    private VisualizadoraCompras visualizadora= VisualizadoraCompras.getInstance();

    private  GestoraVisualizacion(){

    }
    public static GestoraVisualizacion getInstance() {
        if (instancia == null) {
            instancia = new GestoraVisualizacion();
        }
        return instancia;
    }

    public VisualizadoraCompras getVisualizadora() {
        return visualizadora;
    }

    public void setVisualizadora(VisualizadoraCompras visualizadora) {
        this.visualizadora = visualizadora;
    }

    @Override
    public void verInfoCompra(Compra compra) {
        this.getVisualizadora().verInfoCompra(compra);
    }


    @Override
    public void verInfoListaCompras(List listaCompras) {
        this.getVisualizadora().verInfoListaCompras(listaCompras);
    }


}
