package com.proyectoSOLID.logica.clases.clasesGestoras;

import com.proyectoSOLID.logica.clases.entidades.*;
import com.proyectoSOLID.logica.clases.lugaresCompra.*;
import com.proyectoSOLID.logica.interfaces.gestion.*;
import com.proyectoSOLID.logica.interfaces.lugaresCompra.CalculoCostoCompra;


//Clase que centraliza todos los métodos de gestión de la aplicación.
public class Gestora implements NuevaCompraGestora, AltaProducto, CalculoCostoCompra, DisplayInfoCompra, DisplayInfoListaComprasGestora, CalculoPrecioTotalComprasGestora { //Esta clase Centraliza TODA la App (no sé s hacia falta una capa más de abstracción pero habiendo llegado hasta acá elegí profundizar.
    private static Gestora instancia;
    private static int numeroDeCompra =-1;
    private GestoraCompras gestoraCompras;
    private GestoraVisualizacion gestoraVisualizacion;
    private RegistroDeCompras registroDeCompras;

    private RegistroLugaresCompra registroLugaresCompra;


    private Gestora() {
        this.gestoraCompras = GestoraCompras.getInstance();
        this.gestoraVisualizacion = GestoraVisualizacion.getInstance();
        this.registroDeCompras = RegistroDeCompras.getInstance();
        this.registroLugaresCompra = RegistroLugaresCompra.getInstance();
    }

    public static Gestora getInstance(){
        if (instancia == null){
            instancia = new Gestora();
        }
        return instancia;
    }

    public RegistroLugaresCompra getRegistroLugaresCompra() {
        return registroLugaresCompra;
    }

    public void setRegistroLugaresCompra(RegistroLugaresCompra registroLugaresCompra) {
        this.registroLugaresCompra = registroLugaresCompra;
    }

    public static void setNumeroDeCompra(int numeroDeCompra) {
        Gestora.numeroDeCompra = numeroDeCompra;
    }


    public RegistroDeCompras getRegistroDeCompras() {
        return registroDeCompras;
    }

    public void setRegistroDeCompras(RegistroDeCompras registroDeCompras) {
        this.registroDeCompras = registroDeCompras;
    }

    public static int getNumeroDeCompra() {
        return numeroDeCompra;
    }

    public GestoraVisualizacion getGestoraVisualizacion() {
        return gestoraVisualizacion;
    }

    public void setGestoraVisualizacion(GestoraVisualizacion gestoraVisualizacion) {
        this.gestoraVisualizacion = gestoraVisualizacion;
    }

    public GestoraCompras getGestoraCompras() {
        return gestoraCompras;
    }

    public void setGestoraCompras(GestoraCompras gestoraCompras) {
        this.gestoraCompras = gestoraCompras;
    }

    @Override
    public void iniciarCompra(LugarCompra lugarCompra) {
        numeroDeCompra++;
        this.getGestoraCompras().iniciarCompra(this.getRegistroDeCompras().getListaCompras(), lugarCompra);
    }

    @Override
    public void agregarProducto(String nombre, double precio, Compra compra) {
        this.getGestoraCompras().agregarProducto(nombre, precio, compra);
    }

    @Override
    public double calcularCostoCompra(Compra compra) {
        return (this.getGestoraCompras().calcularCostoCompra(compra));
    }



    @Override
    public void verInfoCompra(Compra compra) {
        this.getGestoraVisualizacion().verInfoCompra(compra);
    }

    @Override
    public void verInfoListaCompras() {
        this.getGestoraVisualizacion().verInfoListaCompras(this.getRegistroDeCompras().getListaCompras());
    }


    @Override
    public void calcularPrecioTotalCompras() {
        this.getGestoraCompras().calcularPrecioTotalCompras(this.getRegistroDeCompras().getListaCompras());
    }
}
