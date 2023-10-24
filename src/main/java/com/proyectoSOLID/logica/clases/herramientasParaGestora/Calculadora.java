package com.proyectoSOLID.logica.clases.herramientasParaGestora;

import com.proyectoSOLID.logica.clases.entidades.Compra;
import com.proyectoSOLID.logica.interfaces.lugaresCompra.CalculoCostoCompra;
//la clase Calculadora nos permite implementar un método para que cada compra implemente a su vez sus métodos segun su lugar de compra

public class Calculadora implements CalculoCostoCompra {


    @Override
    public double calcularCostoCompra(Compra compra) {
        double costoCompra;
        costoCompra = compra.getLugarCompra().calcularCostoCompra(compra);
        return costoCompra;
    }
}
