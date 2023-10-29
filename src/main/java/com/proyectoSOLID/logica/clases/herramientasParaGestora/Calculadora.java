package com.proyectoSOLID.logica.clases.herramientasParaGestora;

import com.proyectoSOLID.logica.clases.entidades.Compra;
import com.proyectoSOLID.logica.interfaces.lugaresCompra.CalculoCostoCompra;

public class Calculadora implements CalculoCostoCompra { //Aplico Patron Singleton

    private static Calculadora instancia;

    private Calculadora(){
    }

    public static Calculadora getInstance() {
        if (instancia == null) {
            instancia = new Calculadora();
        }
        return instancia;
    }

    @Override
    public double calcularCostoCompra(Compra compra) {
        double costoCompra;
        costoCompra = compra.getLugarCompra().calcularCostoCompra(compra);
        return costoCompra;
    }
}
