package com.proyectoSOLID.logica.interfaces.gestion;

import com.proyectoSOLID.logica.clases.entidades.Compra;

import java.util.List;

public interface CalculoPrecioTotalCompras {
    void calcularPrecioTotalCompras(List<Compra> listaDeCompras);
}
