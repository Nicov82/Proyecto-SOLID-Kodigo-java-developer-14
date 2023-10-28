package com.proyectoSOLID.logica.interfaces.gestion;

import com.proyectoSOLID.logica.clases.entidades.Compra;
import com.proyectoSOLID.logica.clases.entidades.Producto;

import java.util.List;

public interface AltaProducto {
    void agregarProducto(String nombre, double precio, Compra compra);
}
