package com.proyectoSOLID.logica.clases.clasesGestoras;

import com.proyectoSOLID.logica.clases.entidades.*;
import com.proyectoSOLID.logica.clases.lugaresCompra.*;
import com.proyectoSOLID.logica.interfaces.gestion.*;
import com.proyectoSOLID.logica.interfaces.lugaresCompra.CalculoCostoCompra;

import java.util.ArrayList;
import java.util.List;

//Clase que centraliza todos los métodos de gestión de la aplicación.
public class Gestora implements NuevaCompraGestora, AltaProducto, CalculoCostoCompra, DisplayInfoCompra, DisplayInfoListaComprasGestora, CalculoPrecioTotalComprasGestora { //Esta clase Centraliza TODA la App (no sé s hacia falta una capa más de abstracción pero habiendo llegado hasta acá elegí profundizar.
    private static int numeroDeCompra =-1;
    private GestoraCompras gestoraCompras;
    private GestoraVisualizacion gestoraVisualizacion;
    private RegistroDeCompras registroDeCompras;

    private List<LugarCompra> listaLugaresCompra;

    public Gestora() {
        this.gestoraCompras = new GestoraCompras();
        this.gestoraVisualizacion = new GestoraVisualizacion();
        this.listaLugaresCompra = new ArrayList<>();
        this.registroDeCompras = new RegistroDeCompras();
        LugarCompra argentinaComun = new ArgentinaComun();
        LugarCompra argentinaFreeShop = new ArgentinaFreeShop();
        LugarCompra brasil = new Brasil();
        LugarCompra exteriorFreeShop = new ExteriorFreeShop("Brasil");// En este caso es Brasil, el codigo esta preparado para ser extendido;

        // Añadir los lugares de compra a la lista
        listaLugaresCompra.add(argentinaComun);
        listaLugaresCompra.add(argentinaFreeShop);
        listaLugaresCompra.add(brasil);
        listaLugaresCompra.add(exteriorFreeShop);
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



    public List<LugarCompra> getListaLugaresCompra() {
        return listaLugaresCompra;
    }

    public void setListaLugaresCompra(List<LugarCompra> listaLugaresCompra) {
        this.listaLugaresCompra = listaLugaresCompra;
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
        this.gestoraCompras.iniciarCompra(registroDeCompras.getListaCompras(), lugarCompra);
    }

    @Override
    public void agregarProducto(String nombre, double precio, Compra compra) {
        this.gestoraCompras.agregarProducto(nombre, precio, compra);
    }

    @Override
    public double calcularCostoCompra(Compra compra) {
        return this.gestoraCompras.calcularCostoCompra(compra);
    }



    @Override
    public void verInfoCompra(Compra compra) {
        this.gestoraVisualizacion.verInfoCompra(compra);
    }

    @Override
    public void verInfoListaCompras() {
        this.gestoraVisualizacion.verInfoListaCompras(registroDeCompras.getListaCompras());
    }


    @Override
    public void calcularPrecioTotalCompras() {
        this.gestoraCompras.calcularPrecioTotalCompras(registroDeCompras.getListaCompras());
    }
}
